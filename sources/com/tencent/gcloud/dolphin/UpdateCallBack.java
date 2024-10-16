package com.tencent.gcloud.dolphin;

/* loaded from: classes2.dex */
public interface UpdateCallBack {

    /* loaded from: classes2.dex */
    public static class AppVersion {
        public short versionNumberOne = 0;
        public short versionNumberTwo = 0;
        public short versionNumberThree = 0;
        public short versionNumberFour = 0;
    }

    /* loaded from: classes2.dex */
    public static class VersionInfo {
        public AppVersion newAppVersion;
        public boolean isAppUpdating = false;
        public boolean isNeedUpdating = false;
        public boolean isForcedUpdating = false;
        public long needDownloadSize = 0;
    }

    boolean onActionMsgArrive(String str);

    void onError(int i, int i2);

    boolean onGetNewVersionInfo(VersionInfo versionInfo);

    boolean onNoticeInstallAPK(String str);

    void onProgress(int i, long j, long j2);

    void onSuccess();
}
