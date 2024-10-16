package com.helpshift.android.commons.downloader;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.DownloaderKeyValueStorage;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.runnable.BaseDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.ExternalStorageDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.FilteredViewExternalStorageDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.InternalStorageDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.MediaStoreDownloadRunnable;
import com.helpshift.android.commons.downloader.runnable.RawResponseDownloadRunnable;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import com.helpshift.android.commons.downloader.storage.DownloadManagerCacheDbStorage;
import com.helpshift.util.HSLogger;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: classes2.dex */
public class DownloadManager {
    private static final String TAG = "Helpshift_DownloadMngr";
    ConcurrentHashMap<String, ConcurrentLinkedQueue<OnDownloadFinishListener>> activeDownloadFinishListeners = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, ConcurrentLinkedQueue<OnProgressChangedListener>> activeProgressChangeListeners = new ConcurrentHashMap<>();
    private DownloadManagerCacheDbStorage cacheDbStorage;
    private Context context;
    private ThreadPoolExecutor downloadExecutor;
    private DownloaderKeyValueStorage storage;

    public DownloadManager(Context context, DownloaderKeyValueStorage downloaderKeyValueStorage, ThreadPoolExecutor threadPoolExecutor) {
        this.context = context;
        this.storage = downloaderKeyValueStorage;
        this.downloadExecutor = threadPoolExecutor;
        this.cacheDbStorage = new DownloadManagerCacheDbStorage(downloaderKeyValueStorage);
    }

    public void startDownload(DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadConfig downloadConfig, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        if (downloadConfig.useCache) {
            String availableCacheFile = getAvailableCacheFile(downloadRequestedFileInfo.url);
            if (!TextUtils.isEmpty(availableCacheFile)) {
                onDownloadFinishListener.onDownloadFinish(true, downloadRequestedFileInfo.url, availableCacheFile, 200, "");
                return;
            }
        }
        ConcurrentLinkedQueue<OnDownloadFinishListener> concurrentLinkedQueue = this.activeDownloadFinishListeners.get(downloadRequestedFileInfo.url);
        ConcurrentLinkedQueue<OnProgressChangedListener> concurrentLinkedQueue2 = this.activeProgressChangeListeners.get(downloadRequestedFileInfo.url);
        if (concurrentLinkedQueue != null && concurrentLinkedQueue2 != null) {
            if (onDownloadFinishListener != null) {
                concurrentLinkedQueue.add(onDownloadFinishListener);
            }
            if (onProgressChangedListener != null) {
                concurrentLinkedQueue2.add(onProgressChangedListener);
                return;
            }
            return;
        }
        ConcurrentLinkedQueue<OnDownloadFinishListener> concurrentLinkedQueue3 = new ConcurrentLinkedQueue<>();
        ConcurrentLinkedQueue<OnProgressChangedListener> concurrentLinkedQueue4 = new ConcurrentLinkedQueue<>();
        if (onDownloadFinishListener != null) {
            concurrentLinkedQueue3.add(onDownloadFinishListener);
        }
        if (onProgressChangedListener != null) {
            concurrentLinkedQueue4.add(onProgressChangedListener);
        }
        this.activeDownloadFinishListeners.put(downloadRequestedFileInfo.url, concurrentLinkedQueue3);
        this.activeProgressChangeListeners.put(downloadRequestedFileInfo.url, concurrentLinkedQueue4);
        this.downloadExecutor.execute(buildDownloadRunnable(downloadRequestedFileInfo, downloadConfig, networkAuthDataFetcher));
    }

    private String getAvailableCacheFile(String str) {
        String filePath = this.cacheDbStorage.getFilePath(str);
        if (TextUtils.isEmpty(filePath)) {
            return null;
        }
        if (HsUriUtils.isValidUriPath(filePath)) {
            if (!HsUriUtils.canReadFileAtUri(this.context, filePath)) {
                this.cacheDbStorage.removeFilePath(str);
                return null;
            }
        } else {
            File file = new File(filePath);
            if (!file.exists() || !file.canRead()) {
                this.cacheDbStorage.removeFilePath(str);
                return null;
            }
        }
        return filePath;
    }

    private BaseDownloadRunnable buildDownloadRunnable(DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadConfig downloadConfig, NetworkAuthDataFetcher networkAuthDataFetcher) {
        OnProgressChangedListener onProgressChangedListener = getOnProgressChangedListener();
        OnDownloadFinishListener onDownloadFinishListener = getOnDownloadFinishListener(downloadConfig);
        if (!downloadConfig.writeToFile) {
            return new RawResponseDownloadRunnable(downloadRequestedFileInfo, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        }
        DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage = new DownloadInProgressCacheDbStorage(downloadRequestedFileInfo, this.storage);
        switch (downloadConfig.downloadDirType) {
            case INTERNAL_ONLY:
                return new InternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
            case EXTERNAL_ONLY:
                if (isScopedStorageEnabled()) {
                    return new MediaStoreDownloadRunnable(this.context, downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
                }
                if (isExternalStoragePermissionGranted()) {
                    return new ExternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadConfig.externalStorageDirectoryPath, downloadConfig.isNoMedia, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
                }
                throw new IllegalStateException("External storage permission is not granted on below Android-Q device");
            case EXTERNAL_OR_INTERNAL:
                if (isScopedStorageEnabled()) {
                    return new FilteredViewExternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
                }
                if (isExternalStoragePermissionGranted()) {
                    return new ExternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadConfig.externalStorageDirectoryPath, downloadConfig.isNoMedia, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
                }
                return new InternalStorageDownloadRunnable(this.context, downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
            default:
                throw new IllegalStateException("Unsupported download Dir type");
        }
    }

    private OnDownloadFinishListener getOnDownloadFinishListener(final DownloadConfig downloadConfig) {
        return new OnDownloadFinishListener() { // from class: com.helpshift.android.commons.downloader.DownloadManager.1
            @Override // com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener
            public void onDownloadFinish(boolean z, String str, Object obj, int i, String str2) {
                if (z && downloadConfig.writeToFile) {
                    DownloadManager.this.cacheDbStorage.insertFilePath(str, obj.toString());
                }
                ConcurrentLinkedQueue<OnDownloadFinishListener> remove = DownloadManager.this.activeDownloadFinishListeners.remove(str);
                DownloadManager.this.activeProgressChangeListeners.remove(str);
                if (remove != null) {
                    Iterator<OnDownloadFinishListener> it = remove.iterator();
                    while (it.hasNext()) {
                        OnDownloadFinishListener next = it.next();
                        if (next != null) {
                            next.onDownloadFinish(z, str, obj, i, str2);
                        }
                    }
                }
            }
        };
    }

    private OnProgressChangedListener getOnProgressChangedListener() {
        return new OnProgressChangedListener() { // from class: com.helpshift.android.commons.downloader.DownloadManager.2
            @Override // com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener
            public void onProgressChanged(String str, int i) {
                ConcurrentLinkedQueue<OnProgressChangedListener> concurrentLinkedQueue = DownloadManager.this.activeProgressChangeListeners.get(str);
                if (concurrentLinkedQueue != null) {
                    Iterator<OnProgressChangedListener> it = concurrentLinkedQueue.iterator();
                    while (it.hasNext()) {
                        OnProgressChangedListener next = it.next();
                        if (next != null) {
                            next.onProgressChanged(str, i);
                        }
                    }
                }
            }
        };
    }

    private boolean isExternalStoragePermissionGranted() {
        try {
            return this.context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.context.getPackageName()) == 0;
        } catch (Exception e) {
            HSLogger.d(TAG, "Error checking for permission : android.permission.WRITE_EXTERNAL_STORAGE", e);
            return false;
        }
    }

    private boolean isScopedStorageEnabled() {
        if (Build.VERSION.SDK_INT >= 29) {
            return !Environment.isExternalStorageLegacy();
        }
        return false;
    }
}
