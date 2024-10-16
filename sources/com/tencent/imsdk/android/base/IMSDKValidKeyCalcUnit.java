package com.tencent.imsdk.android.base;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.adjust.sdk.Constants;
import com.helpshift.db.legacy_profile.tables.ProfileTable;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.tools.APKUtils;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.DigestUtils;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class IMSDKValidKeyCalcUnit {
    private static final String DECORATE_SYMBOL = "|";
    private static String signature;
    private Context mCtx;
    private static Object mLock = new Object();
    private static volatile IMSDKValidKeyCalcUnit mIns = null;

    private IMSDKValidKeyCalcUnit() {
    }

    private IMSDKValidKeyCalcUnit(Context context) {
        this.mCtx = context;
    }

    public static IMSDKValidKeyCalcUnit getIns(Context context) {
        if (mIns == null) {
            synchronized (mLock) {
                if (mIns == null) {
                    mIns = new IMSDKValidKeyCalcUnit(context);
                }
            }
        }
        return mIns;
    }

    public void putIfAbsence(Map<String, String> map, String str, String str2) {
        if (map == null || map.containsKey(str)) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        map.put(str, str2);
    }

    public String getApplicationSignature() {
        PackageManager packageManager;
        String str = signature;
        if (str != null && str.length() > 0) {
            return signature;
        }
        try {
            if (this.mCtx == null || (packageManager = this.mCtx.getPackageManager()) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.mCtx.getPackageName(), 64);
                Signature[] signatureArr = packageInfo.signatures;
                if (signatureArr == null || signatureArr.length == 0) {
                    return null;
                }
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
                    messageDigest.update(packageInfo.signatures[0].toByteArray());
                    signature = T.toHexString(messageDigest.digest());
                    return signature;
                } catch (NoSuchAlgorithmException unused) {
                    return null;
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                return null;
            }
        } catch (Exception unused3) {
            return null;
        }
    }

    public Map<String, String> getSortableMap() {
        return T.getSortableMap();
    }

    public String fillFixedParamsAndValidKey(Map<String, String> map) {
        String applicationSignature = this.mCtx != null ? getApplicationSignature() : "";
        Map<String, String> requestParams = getRequestParams(map);
        StringBuilder sb = new StringBuilder();
        for (String str : requestParams.values()) {
            if (!T.ckIsEmpty(str)) {
                sb.append(str);
            }
        }
        if (applicationSignature == null) {
            return "";
        }
        String md5 = DigestUtils.getMD5(((Object) sb) + applicationSignature);
        IMLogger.d("valid key = " + md5 + " , was " + sb.toString() + " encode by " + applicationSignature);
        putIfAbsence(map, "sValidKey", md5);
        return md5;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<String, String> getRequestParams(Map<String, String> map) {
        if (map == null) {
            throw new IllegalArgumentException("params must not null");
        }
        int i = 0;
        if (this.mCtx != null) {
            i = IMSDKConfig.getOrMetaData(IR.meta.GAME_ID, IR.meta.GAME_ID, 0);
            putIfAbsence(map, "sGuestId", DeviceUtils.getDeviceUuid(this.mCtx));
            putIfAbsence(map, "sOriginalId", DeviceUtils.getOriginalDeviceUuid(this.mCtx));
            putIfAbsence(map, "sRefer", APKUtils.getPackageChannelId(this.mCtx, null));
            putIfAbsence(map, ProfileTable.Columns.COLUMN_DID, DeviceUtils.getInstallId(this.mCtx));
            putIfAbsence(map, IR.unifiedAccount.UNIFIED_ACCOUNT_DINFO, getDeviceInfoString(this.mCtx));
        } else {
            IMLogger.w("IMSDKValidKeyCalcUnit getRequestParams context is null!!", new Object[0]);
        }
        if (11 == i) {
            T.HelperLog.gameIdDefault();
        } else if (i <= 0) {
            T.HelperLog.gameIdError();
        }
        putIfAbsence(map, "iGameId", String.valueOf(i));
        putIfAbsence(map, "iPlatform", "2");
        if (map instanceof TreeMap) {
            return map;
        }
        Map<String, String> sortableMap = T.getSortableMap();
        for (String str : map.keySet()) {
            sortableMap.put(str, map.get(str));
        }
        return sortableMap;
    }

    private String getDeviceInfoString(Context context) {
        StringBuilder sb = new StringBuilder();
        if (IMSDKConfig.getOrMetaData(IR.meta.IMSDK_DEVICE_INFO_ENABLE, IR.meta.IMSDK_DEVICE_INFO_ENABLE, true)) {
            sb.append(T.Device.getNetworkType(context));
            sb.append(DECORATE_SYMBOL);
            sb.append(T.Device.getSimOperator(context));
            sb.append(DECORATE_SYMBOL);
            sb.append(T.Device.getModel());
            sb.append(DECORATE_SYMBOL);
            sb.append(T.Device.getLanguage());
            sb.append(DECORATE_SYMBOL);
            sb.append(T.Device.getAppVersion(context));
            sb.append(DECORATE_SYMBOL);
            sb.append(System.currentTimeMillis());
            sb.append(DECORATE_SYMBOL);
            sb.append(T.Device.getScreenDPI(context));
            sb.append(DECORATE_SYMBOL);
            sb.append(T.Device.getScreenResolution(context));
            sb.append(DECORATE_SYMBOL);
            sb.append(T.Device.getBrand());
        }
        return sb.toString();
    }
}
