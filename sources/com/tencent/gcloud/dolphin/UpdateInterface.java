package com.tencent.gcloud.dolphin;

import android.util.Log;

/* loaded from: classes2.dex */
public class UpdateInterface {
    private int updateHandle = 0;
    private UpdateCallBack updateCallBack = null;

    /* loaded from: classes2.dex */
    public class DataVersion {
        public short dataVersion = 0;

        public DataVersion() {
        }
    }

    static {
        System.loadLibrary("abase");
        System.loadLibrary("TDataMaster");
        System.loadLibrary("gcloud");
    }

    private native void cancelUpdateNative(int i);

    private native boolean checkAppUpdateNative(int i);

    private native int createUpdateHandleNative();

    private native boolean deleteUpdateHandleNative(int i);

    private native long getCurrentDownloadSpeedNative(int i);

    private native long getLastErrorNative(int i);

    private native boolean initUpdateHandleNative(int i, UpdateCallBack updateCallBack, String str);

    private native boolean pollCallBackNative(int i);

    private native boolean sentMsgToCurrentActionNative(int i, String str);

    private native boolean setNextStageNative(int i, boolean z);

    private native boolean uninitUpdateHandleNative(int i);

    public void cancelUpdate() {
        int i = this.updateHandle;
        if (i == 0) {
            return;
        }
        cancelUpdateNative(i);
    }

    public boolean checkAppUpdate() {
        int i = this.updateHandle;
        if (i == 0) {
            return false;
        }
        return checkAppUpdateNative(i);
    }

    public boolean createUpdateHandle() {
        if (this.updateHandle != 0) {
            return false;
        }
        this.updateHandle = createUpdateHandleNative();
        Log.i("IIPSUpdateInterface", "create value:" + this.updateHandle);
        return true;
    }

    public boolean deleteUpdateHandle() {
        int i = this.updateHandle;
        if (i == 0) {
            return false;
        }
        boolean deleteUpdateHandleNative = deleteUpdateHandleNative(i);
        this.updateHandle = 0;
        return deleteUpdateHandleNative;
    }

    public long getCurrentDownloadSpeed() {
        int i = this.updateHandle;
        if (i == 0) {
            return 0L;
        }
        return getCurrentDownloadSpeedNative(i);
    }

    public long getLastError() {
        int i = this.updateHandle;
        if (i == 0) {
            return 0L;
        }
        return getLastErrorNative(i);
    }

    public boolean initUpdateHandle(UpdateCallBack updateCallBack, String str) {
        int i = this.updateHandle;
        if (i == 0) {
            return false;
        }
        this.updateCallBack = updateCallBack;
        return initUpdateHandleNative(i, updateCallBack, str);
    }

    public boolean pollCallBack() {
        int i = this.updateHandle;
        if (i == 0) {
            return false;
        }
        return pollCallBackNative(i);
    }

    public boolean sentMsgToCurrentAction(String str) {
        int i = this.updateHandle;
        if (i == 0) {
            return false;
        }
        return sentMsgToCurrentActionNative(i, str);
    }

    public boolean setNextStage(boolean z) {
        int i = this.updateHandle;
        if (i == 0) {
            return false;
        }
        return setNextStageNative(i, z);
    }

    public boolean uninitUpdateHandle() {
        int i = this.updateHandle;
        if (i == 0) {
            return false;
        }
        return uninitUpdateHandleNative(i);
    }
}
