package com.helpshift.android.commons.downloader.runnable;

import android.content.Context;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.android.commons.downloader.storage.DownloadInProgressCacheDbStorage;
import java.io.File;

/* loaded from: classes2.dex */
public class FilteredViewExternalStorageDownloadRunnable extends StorageDownloadRunnable {
    private Context context;

    @Override // com.helpshift.android.commons.downloader.runnable.StorageDownloadRunnable
    public boolean isNoMediaDir() {
        return false;
    }

    public FilteredViewExternalStorageDownloadRunnable(Context context, DownloadRequestedFileInfo downloadRequestedFileInfo, DownloadInProgressCacheDbStorage downloadInProgressCacheDbStorage, NetworkAuthDataFetcher networkAuthDataFetcher, OnProgressChangedListener onProgressChangedListener, OnDownloadFinishListener onDownloadFinishListener) {
        super(downloadRequestedFileInfo, downloadInProgressCacheDbStorage, networkAuthDataFetcher, onProgressChangedListener, onDownloadFinishListener);
        this.context = context;
    }

    @Override // com.helpshift.android.commons.downloader.runnable.StorageDownloadRunnable
    public File getCacheDir() {
        return this.context.getExternalFilesDir(null);
    }
}
