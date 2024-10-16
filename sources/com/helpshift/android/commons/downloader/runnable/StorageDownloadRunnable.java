package com.helpshift.android.commons.downloader.runnable;

import android.text.TextUtils;
import android.util.Log;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import com.helpshift.util.HSLogger;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public abstract class StorageDownloadRunnable extends BaseDownloadRunnable {
    private static final String TAG = "Helpshift_InterDownRun";
    private DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage;

    public abstract File getCacheDir();

    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected boolean isGzipSupported() {
        return false;
    }

    public abstract boolean isNoMediaDir();

    /* JADX INFO: Access modifiers changed from: package-private */
    public StorageDownloadRunnable(DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        this.downloadInProgressCacheDbStorage = downloadInProgressCacheDbStorage;
    }

    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected long getAlreadyDownloadedBytes() {
        File cachedFile = getCachedFile();
        if (cachedFile != null) {
            return cachedFile.length();
        }
        return 0L;
    }

    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected void clearCache() {
        File cachedFile = getCachedFile();
        this.downloadInProgressCacheDbStorage.removeFilePath();
        deleteFile(cachedFile);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected void processHttpResponse(InputStream inputStream, int i, int i2, String str) throws IOException {
        FileOutputStream fileOutputStream;
        long alreadyDownloadedBytes = getAlreadyDownloadedBytes();
        File fileToWriteResponseData = getFileToWriteResponseData();
        try {
            fileOutputStream = new FileOutputStream(fileToWriteResponseData, true);
            try {
                byte[] bArr = new byte[8192];
                long j = 0;
                while (true) {
                    int read = inputStream.read(bArr, 0, 8192);
                    if (read == -1) {
                        this.downloadInProgressCacheDbStorage.removeFilePath();
                        String absolutePath = fileToWriteResponseData.getAbsolutePath();
                        HSLogger.d(TAG, "Download finished : " + this.requestInfo.url);
                        notifyDownloadFinish(true, absolutePath, i2, str);
                        closeFileStream(fileOutputStream);
                        return;
                    }
                    if (read < 0) {
                        throw new EOFException();
                    }
                    fileOutputStream.write(bArr, 0, read);
                    long length = (((float) fileToWriteResponseData.length()) / ((float) (i + alreadyDownloadedBytes))) * 100.0f;
                    if (length != j) {
                        notifyProgressChange((int) length);
                        j = length;
                    }
                }
            } catch (Throwable th) {
                th = th;
                closeFileStream(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream = null;
        }
    }

    private File getFileToWriteResponseData() {
        File cachedFile = getCachedFile();
        if (cachedFile != null) {
            return cachedFile;
        }
        File cacheDir = getCacheDir();
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }
        if (isNoMediaDir()) {
            checkAndCreateNoMediaFile(cacheDir);
        }
        File file = new File(cacheDir, generateFileName());
        this.downloadInProgressCacheDbStorage.insertFilePath(file.getAbsolutePath());
        return file;
    }

    private void deleteFile(File file) {
        if (file == null) {
            return;
        }
        try {
            file.delete();
        } catch (Exception e) {
            HSLogger.e(TAG, "Exception in deleting file ", e);
        }
    }

    public File getCachedFile() {
        String filePath = this.downloadInProgressCacheDbStorage.getFilePath();
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        File file = new File(filePath);
        if (file.exists() && file.canWrite()) {
            return file;
        }
        this.downloadInProgressCacheDbStorage.removeFilePath();
        return null;
    }

    private void checkAndCreateNoMediaFile(File file) {
        try {
            File file2 = new File(file, ".nomedia");
            if (file2.exists()) {
                return;
            }
            file2.createNewFile();
        } catch (IOException e) {
            Log.d(TAG, "Exception while creating no media file", e);
        }
    }

    private String generateFileName() {
        return "Support_" + System.currentTimeMillis() + this.requestInfo.url.substring(this.requestInfo.url.lastIndexOf("/") + 1);
    }
}
