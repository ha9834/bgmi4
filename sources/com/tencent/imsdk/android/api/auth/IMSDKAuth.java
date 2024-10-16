package com.tencent.imsdk.android.api.auth;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKFuse;
import com.tencent.imsdk.android.base.auth.IMSDKAuthManager;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.json.JsonSerializable;
import com.tencent.imsdk.android.tools.log.IMLogger;

/* loaded from: classes.dex */
public class IMSDKAuth {
    protected static final int BASE_RESULT = 0;
    public static IMSDKBind Bind = null;
    private static final String NO_CODE = null;
    protected static final int SERVER_AUTH_RESULT = 1;
    private static final int SERVER_CONNECT_RESULT = 2;
    private static final int SERVER_MIGRATE_RESULT = 3;
    private static InnerStat mAPIStat;
    private static IMSDKAuthManager mAuthImpl;
    private static Context mCurCtx;
    private static String mFuseChannel;

    public static boolean initialize(Activity activity) {
        T.setGlobalActivityUpToDate(activity);
        if (mCurCtx != activity.getApplicationContext()) {
            mCurCtx = activity.getApplicationContext();
            IMLogger.d("initialize set ctx =  " + mCurCtx);
            mAuthImpl = new IMSDKAuthManager(activity);
            Bind = new IMSDKBind(activity);
            mAPIStat = new InnerStat.Builder(activity, "2.10.1", IR.MODULE_AUTH, "Init<IMSDKAuth>").create();
        }
        return mAuthImpl != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean isInit(int i, IMSDKResultListener iMSDKResultListener) {
        int i2;
        JsonSerializable iMSDKAuthResult;
        if (mAuthImpl == null) {
            T.HelperLog.channelInstanceNotInit();
            i2 = 17;
        } else {
            i2 = -1;
        }
        if (iMSDKResultListener != null && i2 != -1) {
            if (i == 1) {
                iMSDKAuthResult = new IMSDKAuthResult(i2, -1);
            } else {
                iMSDKAuthResult = new IMSDKResult(i2, -1);
            }
            iMSDKResultListener.onResult(iMSDKAuthResult);
        }
        return mAuthImpl != null;
    }

    private static boolean isInitAndNotFuse(int i, String str, String str2, IMSDKResultListener iMSDKResultListener) {
        boolean z;
        int i2;
        JsonSerializable iMSDKAuthResult;
        if (T.ckIsEmpty(str)) {
            z = true;
        } else {
            z = IMSDKFuse.isAvailable(str) && IMSDKFuse.isAvailable(str, str2);
        }
        if (mAuthImpl == null) {
            T.HelperLog.channelInstanceNotInit();
            i2 = 17;
        } else if (z) {
            i2 = -1;
        } else {
            T.HelperLog.moduleIsFused();
            i2 = 19;
        }
        if (iMSDKResultListener != null && i2 != -1) {
            switch (i) {
                case 1:
                    iMSDKAuthResult = new IMSDKAuthResult(i2, -1);
                    break;
                case 2:
                    iMSDKAuthResult = new IMSDKAuthConnectResult(i2, -1);
                    break;
                case 3:
                    iMSDKAuthResult = new IMSDKAuthMigrateResult(i2, -1);
                    break;
                default:
                    iMSDKAuthResult = new IMSDKResult(i2, -1);
                    break;
            }
            iMSDKResultListener.onResult(iMSDKAuthResult);
        }
        return mAuthImpl != null && z;
    }

    public static void auth(IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(1, null, null, iMSDKResultListener)) {
            mAuthImpl.auth(iMSDKResultListener);
        }
    }

    public static IMSDKAuthResult getAuthResult() {
        if (isInitAndNotFuse(1, null, null, null)) {
            return mAuthImpl.getAuthResult();
        }
        return new IMSDKAuthResult(1001, -1);
    }

    public static void connect(String str, IMSDKResultListener<IMSDKAuthConnectResult> iMSDKResultListener, Object... objArr) {
        connect(str, "", iMSDKResultListener, objArr);
    }

    public static void connect(String str, String str2, IMSDKResultListener<IMSDKAuthConnectResult> iMSDKResultListener, Object... objArr) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener<IMSDKAuthConnectResult> proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(str, iMSDKResultListener) : iMSDKResultListener;
        if (isInitAndNotFuse(2, IR.fuse.IMSDK_FUSE_AUTH_CONNECT, str, proxyListener4EventReport)) {
            mFuseChannel = str;
            mAuthImpl.loginChannel(IR.path.CONNECT_PATH, str, str2, proxyListener4EventReport, objArr);
        }
    }

    public static void reconnect(IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        reconnect(null, iMSDKResultListener, objArr);
    }

    public static void reconnect(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener, Object... objArr) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(0, IR.fuse.IMSDK_FUSE_AUTH_CONNECT, mFuseChannel, iMSDKResultListener)) {
            mAuthImpl.optAccount(IR.path.RECONNECT_PATH, str, iMSDKResultListener, objArr);
        }
    }

    public static void restore(IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener, Object... objArr) {
        restore(null, iMSDKResultListener, objArr);
    }

    public static void getConnectInfo(IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(1, IR.fuse.IMSDK_FUSE_AUTH_CONNECT, null, iMSDKResultListener)) {
            mAuthImpl.optAccount("bind/bindRelationInfo", "", iMSDKResultListener, new Object[0]);
        }
    }

    public static void disconnect(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        IMSDKResultListener<IMSDKResult> proxyListener4EventReport = innerStat != null ? innerStat.proxyListener4EventReport(str, iMSDKResultListener) : iMSDKResultListener;
        if (isInitAndNotFuse(0, IR.fuse.IMSDK_FUSE_AUTH_CONNECT, str, proxyListener4EventReport)) {
            mAuthImpl.optAccount(IR.path.DISCONNECT_PATH, str, "", proxyListener4EventReport, new Object[0]);
        }
    }

    public static void restore(String str, IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener, Object... objArr) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(1, IR.fuse.IMSDK_FUSE_AUTH_CONNECT, mFuseChannel, iMSDKResultListener)) {
            mAuthImpl.optAccount(IR.path.RESTORE_PATH, str, iMSDKResultListener, objArr);
        }
    }

    public static void recover(String str, IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(str, iMSDKResultListener);
        }
        if (isInitAndNotFuse(1, null, null, iMSDKResultListener)) {
            mAuthImpl.loginChannel(IR.path.RECOVER_PATH, str, iMSDKResultListener, new Object[0]);
        }
    }

    public static void migrate(IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener) {
        migrate(null, iMSDKResultListener);
    }

    public static void getMigrateCode(IMSDKResultListener<IMSDKAuthMigrateResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(3, IR.fuse.IMSDK_FUSE_AUTH_MIGRATE, null, iMSDKResultListener)) {
            mAuthImpl.optAccount(IR.path.GET_MIGRATE_CODE_PATH, NO_CODE, iMSDKResultListener, new Object[0]);
        }
    }

    public static void getMigrateInfo(IMSDKResultListener<IMSDKAuthMigrateResult> iMSDKResultListener) {
        getMigrateInfo(null, iMSDKResultListener);
    }

    public static void getMigrateInfo(String str, IMSDKResultListener<IMSDKAuthMigrateResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(3, IR.fuse.IMSDK_FUSE_AUTH_MIGRATE, null, iMSDKResultListener)) {
            mAuthImpl.optAccount(IR.path.GET_MIGRATE_INFO_PATH, str, iMSDKResultListener, new Object[0]);
        }
    }

    public static void migrate(String str, IMSDKResultListener<IMSDKAuthResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(1, IR.fuse.IMSDK_FUSE_AUTH_MIGRATE, null, iMSDKResultListener)) {
            mAuthImpl.optAccount(IR.path.MIGRATE_PATH, str, iMSDKResultListener, new Object[0]);
        }
    }

    public static void deleteDeviceAccount(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(0, IR.fuse.IMSDK_FUSE_AUTH_DELETE, null, iMSDKResultListener)) {
            mAuthImpl.optAccount(IR.path.DELETE_DEVICE_ACCOUNT_PATH, NO_CODE, iMSDKResultListener, new Object[0]);
        }
    }

    public static void deleteAllAccount(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(null, iMSDKResultListener);
        }
        if (isInitAndNotFuse(0, IR.fuse.IMSDK_FUSE_AUTH_DELETE, null, iMSDKResultListener)) {
            mAuthImpl.optAccount(IR.path.DELETE_ALL_ACCOUNT_PATH, NO_CODE, iMSDKResultListener, new Object[0]);
        }
    }

    public static void signOut(String str, IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        InnerStat innerStat = mAPIStat;
        if (innerStat != null) {
            iMSDKResultListener = innerStat.proxyListener4EventReport(str, iMSDKResultListener);
        }
        if (isInitAndNotFuse(3, IR.fuse.IMSDK_FUSE_AUTH_CONNECT, null, iMSDKResultListener)) {
            if (str.length() >= 0) {
                mAuthImpl.logout(str, iMSDKResultListener);
            } else {
                iMSDKResultListener.onResult(new IMSDKResult(11, "please check your channel argument"));
            }
        }
    }
}
