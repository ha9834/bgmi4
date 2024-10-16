package com.helpshift.android.commons.downloader.runnable;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.helpshift.android.commons.downloader.HsUriUtils;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import com.helpshift.util.HSLogger;
import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class MediaStoreDownloadRunnable extends BaseDownloadRunnable {
    private static final String TAG = "Helpshift_mediaRun";
    private Context context;
    private DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage;

    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected boolean isGzipSupported() {
        return false;
    }

    public MediaStoreDownloadRunnable(Context context, DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        this.context = context;
        this.downloadInProgressCacheDbStorage = downloadInProgressCacheDbStorage;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
    
        if (r3 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r3 != null) goto L24;
     */
    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected long getAlreadyDownloadedBytes() {
        /*
            r6 = this;
            android.net.Uri r0 = r6.getCachedFileUri()
            r1 = 0
            if (r0 == 0) goto L34
            r3 = 0
            android.content.Context r4 = r6.context     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            java.lang.String r5 = "r"
            android.os.ParcelFileDescriptor r3 = r4.openFileDescriptor(r0, r5)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            if (r3 == 0) goto L1b
            long r1 = r3.getStatSize()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
        L1b:
            if (r3 == 0) goto L34
        L1d:
            r3.close()     // Catch: java.lang.Exception -> L34
            goto L34
        L21:
            r0 = move-exception
            goto L2e
        L23:
            r0 = move-exception
            java.lang.String r4 = "Helpshift_mediaRun"
            java.lang.String r5 = "Exception while getting file size via Uri"
            com.helpshift.util.HSLogger.e(r4, r5, r0)     // Catch: java.lang.Throwable -> L21
            if (r3 == 0) goto L34
            goto L1d
        L2e:
            if (r3 == 0) goto L33
            r3.close()     // Catch: java.lang.Exception -> L33
        L33:
            throw r0
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.helpshift.android.commons.downloader.runnable.MediaStoreDownloadRunnable.getAlreadyDownloadedBytes():long");
    }

    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected void clearCache() {
        Uri cachedFileUri = getCachedFileUri();
        this.downloadInProgressCacheDbStorage.removeFilePath();
        deleteUri(cachedFileUri);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable
    protected void processHttpResponse(InputStream inputStream, int i, int i2, String str) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor;
        FileOutputStream fileOutputStream;
        long alreadyDownloadedBytes = getAlreadyDownloadedBytes();
        Uri fileUriToWriteResponseData = getFileUriToWriteResponseData();
        int i3 = 0;
        if (fileUriToWriteResponseData == null) {
            notifyDownloadFinish(false, null, i2, str);
            return;
        }
        this.downloadInProgressCacheDbStorage.insertFilePath(fileUriToWriteResponseData.toString());
        try {
            parcelFileDescriptor = this.context.getContentResolver().openFileDescriptor(fileUriToWriteResponseData, "w");
            try {
                if (parcelFileDescriptor == null) {
                    notifyDownloadFinish(false, null, i2, str);
                    closeFileStream(null);
                    HsUriUtils.closeParcelFileDescriptor(parcelFileDescriptor);
                    return;
                }
                fileOutputStream = new FileOutputStream(parcelFileDescriptor.getFileDescriptor());
                int i4 = 8192;
                try {
                    byte[] bArr = new byte[8192];
                    long j = 0;
                    while (true) {
                        int read = inputStream.read(bArr, i3, i4);
                        if (read == -1) {
                            updateIsPendingFlag(fileUriToWriteResponseData, this.requestInfo.contentType);
                            this.downloadInProgressCacheDbStorage.removeFilePath();
                            HSLogger.d(TAG, "Download finished : " + this.requestInfo.url + "\n URI : " + fileUriToWriteResponseData);
                            notifyDownloadFinish(true, fileUriToWriteResponseData, i2, str);
                            closeFileStream(fileOutputStream);
                            HsUriUtils.closeParcelFileDescriptor(parcelFileDescriptor);
                            return;
                        }
                        if (read < 0) {
                            throw new EOFException();
                        }
                        fileOutputStream.write(bArr, i3, read);
                        long statSize = (((float) parcelFileDescriptor.getStatSize()) / ((float) (i + alreadyDownloadedBytes))) * 100.0f;
                        if (statSize != j) {
                            notifyProgressChange((int) statSize);
                            j = statSize;
                        }
                        i3 = 0;
                        i4 = 8192;
                    }
                } catch (Throwable th) {
                    th = th;
                    closeFileStream(fileOutputStream);
                    HsUriUtils.closeParcelFileDescriptor(parcelFileDescriptor);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            parcelFileDescriptor = null;
            fileOutputStream = null;
        }
    }

    private Uri getFileUriToWriteResponseData() {
        Uri cachedFileUri = getCachedFileUri();
        return cachedFileUri != null ? cachedFileUri : createFile(generateFileName(), this.requestInfo.contentType);
    }

    private Uri createFile(String str, String str2) {
        Uri contentUri;
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        ContentResolver contentResolver = this.context.getContentResolver();
        if (isImageType(str2)) {
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", str2);
            contentValues.put("is_pending", (Integer) 1);
            contentUri = MediaStore.Images.Media.getContentUri("external_primary");
        } else {
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", str2);
            contentValues.put("is_pending", (Integer) 1);
            contentUri = MediaStore.Downloads.getContentUri("external_primary");
        }
        return contentResolver.insert(contentUri, contentValues);
    }

    private void updateIsPendingFlag(Uri uri, String str) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        ContentValues contentValues = new ContentValues();
        if (isImageType(str)) {
            contentValues.put("is_pending", (Integer) 0);
        } else {
            contentValues.put("is_pending", (Integer) 0);
        }
        this.context.getContentResolver().update(uri, contentValues, null, null);
    }

    private String generateFileName() {
        return "Support_" + System.currentTimeMillis() + this.requestInfo.url.substring(this.requestInfo.url.lastIndexOf("/") + 1);
    }

    private Uri getCachedFileUri() {
        String filePath = this.downloadInProgressCacheDbStorage.getFilePath();
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        Uri buildUri = buildUri(filePath);
        if (buildUri != null) {
            return buildUri;
        }
        this.downloadInProgressCacheDbStorage.removeFilePath();
        return null;
    }

    private Uri buildUri(String str) {
        if (!HsUriUtils.canReadFileAtUri(this.context, str)) {
            return null;
        }
        try {
            return Uri.parse(str);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error while converting filePath to uri", e);
            return null;
        }
    }

    private boolean isImageType(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("image/.*").matcher(str).matches();
        } catch (Exception e) {
            HSLogger.e(TAG, "Error when check image mime type", e);
            return false;
        }
    }

    private void deleteUri(Uri uri) {
        if (uri == null) {
            return;
        }
        try {
            this.context.getContentResolver().delete(uri, null, null);
        } catch (Exception e) {
            HSLogger.e(TAG, "Error when deleting a file via uri", e);
        }
    }
}
