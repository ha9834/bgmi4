package com.helpshift.common.platform;

import android.content.Context;
import com.helpshift.android.commons.downloader.DownloadConfig;
import com.helpshift.android.commons.downloader.DownloadManager;
import com.helpshift.android.commons.downloader.contracts.DownloadDirType;
import com.helpshift.android.commons.downloader.contracts.DownloadRequestedFileInfo;
import com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher;
import com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener;
import com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener;
import com.helpshift.common.domain.HSThreadFactory;
import com.helpshift.common.domain.network.AuthDataProvider;
import com.helpshift.common.platform.network.Method;
import com.helpshift.downloader.AdminFileInfo;
import com.helpshift.downloader.SupportDownloadStateChangeListener;
import com.helpshift.downloader.SupportDownloader;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class AndroidSupportDownloader implements SupportDownloader {
    private static final int CORE_POOL_SIZE = 5;
    private static final int KEEP_ALIVE_TIME = 1;
    private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private static final int MAXIMUM_POOL_SIZE = 5;
    private Map<String, Set<SupportDownloadStateChangeListener>> callbackManager = new HashMap();
    private Context context;
    private final DownloadManager downloadManager;

    public AndroidSupportDownloader(Context context, KVStore kVStore) {
        this.context = context;
        this.downloadManager = new DownloadManager(context, new SupportDownloaderKVStorage(kVStore), new ThreadPoolExecutor(5, 5, 1L, KEEP_ALIVE_TIME_UNIT, new LinkedBlockingQueue(), new HSThreadFactory("sp-dwnld")));
    }

    private DownloadConfig buildDownloadConfig(SupportDownloader.StorageDirType storageDirType, boolean z) {
        DownloadDirType downloadDirType;
        boolean z2 = false;
        switch (storageDirType) {
            case INTERNAL_ONLY:
                downloadDirType = DownloadDirType.INTERNAL_ONLY;
                z2 = true;
                break;
            case EXTERNAL_ONLY:
                downloadDirType = DownloadDirType.EXTERNAL_ONLY;
                break;
            case EXTERNAL_OR_INTERNAL:
                downloadDirType = DownloadDirType.EXTERNAL_OR_INTERNAL;
                break;
            default:
                throw new IllegalStateException("Unsupported download Dir type");
        }
        return new DownloadConfig.Builder().setUseCache(z).setIsNoMedia(z2).setWriteToFile(true).setDownloadDirType(downloadDirType).create();
    }

    @Override // com.helpshift.downloader.SupportDownloader
    public void startDownload(AdminFileInfo adminFileInfo, SupportDownloader.StorageDirType storageDirType, final AuthDataProvider authDataProvider, SupportDownloadStateChangeListener supportDownloadStateChangeListener) {
        addCallback(adminFileInfo.url, supportDownloadStateChangeListener);
        this.downloadManager.startDownload(new DownloadRequestedFileInfo(adminFileInfo.url, adminFileInfo.isSecureAttachment, adminFileInfo.contentType, adminFileInfo.etag), buildDownloadConfig(storageDirType, !adminFileInfo.skipCaching), new NetworkAuthDataFetcher() { // from class: com.helpshift.common.platform.AndroidSupportDownloader.1
            @Override // com.helpshift.android.commons.downloader.contracts.NetworkAuthDataFetcher
            public Map<String, String> getAuthData(Map<String, String> map) throws GeneralSecurityException {
                return authDataProvider.getAuthData(Method.GET, map);
            }
        }, new OnProgressChangedListener() { // from class: com.helpshift.common.platform.AndroidSupportDownloader.2
            @Override // com.helpshift.android.commons.downloader.contracts.OnProgressChangedListener
            public void onProgressChanged(String str, int i) {
                AndroidSupportDownloader.this.handleProgressChange(str, i);
            }
        }, new OnDownloadFinishListener() { // from class: com.helpshift.common.platform.AndroidSupportDownloader.3
            @Override // com.helpshift.android.commons.downloader.contracts.OnDownloadFinishListener
            public void onDownloadFinish(boolean z, String str, Object obj, int i, String str2) {
                if (z) {
                    AndroidSupportDownloader.this.handleDownloadSuccess(str, obj.toString(), str2);
                } else {
                    AndroidSupportDownloader.this.handleDownloadFailure(str, i);
                }
            }
        });
    }

    void handleDownloadSuccess(String str, String str2, String str3) {
        Iterator<SupportDownloadStateChangeListener> it = getAndRemoveCallbacks(str).iterator();
        while (it.hasNext()) {
            it.next().onSuccess(str, str2, str3);
        }
    }

    void handleProgressChange(String str, int i) {
        Iterator<SupportDownloadStateChangeListener> it = getCallbacks(str).iterator();
        while (it.hasNext()) {
            it.next().onProgressChange(str, i);
        }
    }

    void handleDownloadFailure(String str, int i) {
        Iterator<SupportDownloadStateChangeListener> it = getAndRemoveCallbacks(str).iterator();
        while (it.hasNext()) {
            it.next().onFailure(str, i);
        }
    }

    private synchronized void addCallback(String str, SupportDownloadStateChangeListener supportDownloadStateChangeListener) {
        if (supportDownloadStateChangeListener == null) {
            return;
        }
        Set<SupportDownloadStateChangeListener> set = this.callbackManager.get(str);
        if (set == null) {
            set = new HashSet<>();
        }
        set.add(supportDownloadStateChangeListener);
        this.callbackManager.put(str, set);
    }

    private synchronized void removeCallbacks(String str) {
        this.callbackManager.remove(str);
    }

    private synchronized Set<SupportDownloadStateChangeListener> getCallbacks(String str) {
        HashSet hashSet;
        Set<SupportDownloadStateChangeListener> set = this.callbackManager.get(str);
        if (set == null) {
            hashSet = new HashSet();
        } else {
            hashSet = new HashSet(set);
        }
        return hashSet;
    }

    private synchronized Set<SupportDownloadStateChangeListener> getAndRemoveCallbacks(String str) {
        Set<SupportDownloadStateChangeListener> callbacks;
        callbacks = getCallbacks(str);
        removeCallbacks(str);
        return callbacks;
    }
}
