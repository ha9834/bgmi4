package com.tencent.hawk.bridge;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes2.dex */
public class VersionHandler {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class VersionInfo {
        private int mVersionCode;
        private String mVersionName;

        public VersionInfo(String str, int i) {
            this.mVersionCode = i;
            this.mVersionName = str;
        }

        public boolean compareTo(VersionInfo versionInfo) {
            return versionInfo.mVersionCode == this.mVersionCode && versionInfo.mVersionName.equals(this.mVersionName);
        }
    }

    private static VersionInfo getVerionInfoCurrent(Context context) {
        if (context == null) {
            return new VersionInfo(Constant.strError, -1);
        }
        Pair<String, Integer> pkgVersionInfo = DevPacket.getPkgVersionInfo(context);
        return new VersionInfo(pkgVersionInfo.getLeft(), pkgVersionInfo.getRight().intValue());
    }

    private static VersionInfo getVerionInfoCached(Context context) {
        String str = Constant.strError;
        int i = -1;
        if (context == null) {
            return new VersionInfo(Constant.strError, -1);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0);
        if (sharedPreferences != null) {
            str = sharedPreferences.getString(Constant.APM_CFG_VERSION_NAME, Constant.strError);
            i = sharedPreferences.getInt(Constant.APM_CFG_VERSION_CODE, -1);
        }
        return new VersionInfo(str, i);
    }

    private static void writeVersionInfo(Context context, VersionInfo versionInfo) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0);
        if (sharedPreferences != null) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit == null) {
                return;
            }
            edit.putString(Constant.APM_CFG_VERSION_NAME, versionInfo.mVersionName);
            edit.putInt(Constant.APM_CFG_VERSION_CODE, versionInfo.mVersionCode);
            edit.commit();
            HawkLogger.d("WriteVersionInfo");
            return;
        }
        HawkLogger.e("WriteVersionInfo error");
    }

    public static boolean checkCacheValidation(Context context) {
        if (context == null) {
            return false;
        }
        VersionInfo verionInfoCurrent = getVerionInfoCurrent(context);
        VersionInfo verionInfoCached = getVerionInfoCached(context);
        if (new VersionInfo(Constant.strError, -1).compareTo(verionInfoCached)) {
            writeVersionInfo(context, verionInfoCurrent);
            return false;
        }
        if (verionInfoCurrent.compareTo(verionInfoCached)) {
            return true;
        }
        writeVersionInfo(context, verionInfoCurrent);
        return false;
    }
}
