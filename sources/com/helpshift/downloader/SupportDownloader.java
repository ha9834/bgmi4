package com.helpshift.downloader;

import com.helpshift.common.domain.network.AuthDataProvider;

/* loaded from: classes2.dex */
public interface SupportDownloader {

    /* loaded from: classes2.dex */
    public enum StorageDirType {
        INTERNAL_ONLY,
        EXTERNAL_ONLY,
        EXTERNAL_OR_INTERNAL
    }

    void startDownload(AdminFileInfo adminFileInfo, StorageDirType storageDirType, AuthDataProvider authDataProvider, SupportDownloadStateChangeListener supportDownloadStateChangeListener);
}
