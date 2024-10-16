package com.ihoc.mgpa.download;

import android.util.Log;
import com.ihoc.mgpa.n.n;

/* loaded from: classes2.dex */
public class BgDownloadProxy {
    private static final String CLASS_BG_PRE_DOWNLOAD_PROVIDER = "com.ihoc.tgpa.bgdownload.proxy.BgDownloadProvider";
    public static final String STATE_ICON = "update_icon";
    public static final String STATE_PROGRESS = "update_progress";
    public static final String STATE_TITLE = "update_title";
    private static final String TAG = "TGPABgDownloadProxy";
    private static volatile BgDownloadProxy mInstance;
    private Object mBgDownloadProvider;

    private BgDownloadProxy() {
        init();
    }

    public static BgDownloadProxy getInstance() {
        if (mInstance == null) {
            synchronized (BgDownloadProxy.class) {
                if (mInstance == null) {
                    mInstance = new BgDownloadProxy();
                }
            }
        }
        return mInstance;
    }

    private void init() {
        this.mBgDownloadProvider = n.a(CLASS_BG_PRE_DOWNLOAD_PROVIDER, "getInstance");
        if (this.mBgDownloadProvider == null) {
            Log.e(TAG, "[init]: com.ihoc.tgpa.bgdownload.proxy.BgDownloadProviderget fail!");
        }
    }

    public String GetBgPreDownload() {
        Object a2 = n.a(this.mBgDownloadProvider, "getBgPreDownload", new Class[0], new Object[0]);
        return a2 instanceof String ? (String) a2 : "";
    }

    public String GetBgPreDownloadFromCache() {
        Object a2 = n.a(this.mBgDownloadProvider, "getBgPreDownloadFromCache", new Class[0], new Object[0]);
        return a2 instanceof String ? (String) a2 : "";
    }

    public void checkCloudCtlConfig() {
        n.a(this.mBgDownloadProvider, "checkCloudCtlConfig", new Class[0], new Object[0]);
    }

    public void cleanFile() {
        n.a(this.mBgDownloadProvider, "cleanFile", new Class[0], new Object[0]);
    }

    public void handleStringData(String str) {
        n.a(this.mBgDownloadProvider, "handleStringData", new Class[]{String.class}, new Object[]{str});
    }

    public void initAndCheck() {
        n.a(this.mBgDownloadProvider, "initAndCheck", new Class[0], new Object[0]);
    }

    public void updateBgPreDownloadNewTask() {
        n.a(this.mBgDownloadProvider, "updateBgPreDownloadNewTask", new Class[0], new Object[0]);
    }
}
