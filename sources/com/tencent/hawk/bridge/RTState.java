package com.tencent.hawk.bridge;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.Random;
import java.util.UUID;

/* loaded from: classes2.dex */
public class RTState {
    public static long sBootTime;
    private static String sCdnURL;
    public static String sLinkedSessionId;
    public static int sRandSeed;
    public static String sSessionId;
    public static long sUUIDHigh;
    public static long sUUIDLow;
    public static String sUniversalSessionId;

    public static void initCCURL(Context context) {
        try {
            String string = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("TAPM.CC_URL", "");
            HawkLogger.d("read cc url: " + string);
            HawkLogger.w("set customized cc url: " + string);
            if (string.length() > 1) {
                sCdnURL = string + "/";
            }
        } catch (Exception e) {
            Log.e(HawkLogger.LOG_TAG, "getMeta error=" + e);
        }
    }

    public static String getCCURL() {
        String str = sCdnURL;
        if (str == null || str.length() <= 1) {
            return null;
        }
        HawkLogger.d(sCdnURL);
        return sCdnURL;
    }

    private static Pair<Long, Long> getUUID(Context context) {
        if (context == null) {
            return new Pair<>(0L, 0L);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0);
        if (sharedPreferences == null) {
            return new Pair<>(0L, 0L);
        }
        long j = sharedPreferences.getLong(Constant.APM_UUID_HIGH, 0L);
        long j2 = sharedPreferences.getLong(Constant.APM_UUID_LOW, 0L);
        if (j == 0 && j2 == 0) {
            UUID randomUUID = UUID.randomUUID();
            j = randomUUID.getMostSignificantBits();
            j2 = randomUUID.getLeastSignificantBits();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putLong(Constant.APM_UUID_HIGH, j);
                edit.putLong(Constant.APM_UUID_LOW, j2);
                edit.commit();
            }
        }
        return new Pair<>(Long.valueOf(j), Long.valueOf(j2));
    }

    private static String getUUIDSym(Context context) {
        if (context == null) {
            return new String(Constant.APM_CFG_GPU_NA);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0);
        if (sharedPreferences == null) {
            return new String(Constant.APM_CFG_GPU_NA);
        }
        String string = sharedPreferences.getString(Constant.APM_UUID_STR, Constant.APM_CFG_GPU_NA);
        if (string.equals(Constant.APM_CFG_GPU_NA)) {
            string = UUID.randomUUID().toString();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            if (edit != null) {
                edit.putString(Constant.APM_UUID_STR, string);
                edit.commit();
            }
        }
        return string;
    }

    private static String readLinkedSessionId(Context context, String str) {
        SharedPreferences.Editor edit;
        if (context == null) {
            return new String(Constant.APM_CFG_GPU_NA);
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(Constant.APM_CFG_NAME, 0);
        if (sharedPreferences == null) {
            return new String(Constant.APM_CFG_GPU_NA);
        }
        String string = sharedPreferences.getString(Constant.APM_UUID_LINKED, str);
        if (str != null && (edit = sharedPreferences.edit()) != null) {
            edit.putString(Constant.APM_UUID_LINKED, str);
            edit.commit();
        }
        return string;
    }

    public static void initRTState(Context context) {
        HawkLogger.i("Init RT State");
        sBootTime = System.currentTimeMillis();
        sRandSeed = new Random().nextInt();
        sSessionId = UUID.randomUUID().toString();
        sUniversalSessionId = getUUIDSym(context);
        Pair<Long, Long> uuid = getUUID(context);
        sUUIDHigh = uuid.getLeft().longValue();
        sUUIDLow = uuid.getRight().longValue();
        sLinkedSessionId = readLinkedSessionId(context, sSessionId);
        HawkLogger.i("end init RT State");
    }

    public static long getBootTime() {
        return sBootTime;
    }

    public static String getSessionId() {
        return sSessionId;
    }

    public static int getRandSeed() {
        return sRandSeed;
    }

    public static String getUniversalSessionId() {
        return sUniversalSessionId;
    }

    public static String getLinkedSessionId() {
        return sLinkedSessionId;
    }

    public static long getUUIDHigh() {
        return sUUIDHigh;
    }

    public static long getUUIDLow() {
        return sUUIDLow;
    }
}
