package com.tdatamaster.tdm.system;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import com.tencent.midas.oversea.api.CocosPayHelper;
import java.io.File;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class TDMSystem {
    private static TDMSystem instance = null;
    private static final String tag = "TDMSystem";
    private long m_szMemeryAvail = 0;
    private long m_szSpaceAvail = 0;

    private TDMSystem() {
    }

    public static TDMSystem getInstance() {
        if (instance == null) {
            instance = new TDMSystem();
        }
        return instance;
    }

    @TargetApi(16)
    private void GetMemoryInfo(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null) {
                return;
            }
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            this.m_szMemeryAvail = memoryInfo.availMem >> 20;
        } catch (Exception e) {
            TDMLog.e(tag, "GetMemoryInfo failed");
            TDMLog.i(tag, "Exception Track: " + e);
        }
    }

    public long GetAvailMemory(Context context) {
        GetMemoryInfo(context);
        return this.m_szMemeryAvail;
    }

    @TargetApi(18)
    private void GetSpaceInfo() {
        long blockSize;
        long availableBlocks;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return;
            }
            StatFs statFs = new StatFs(externalStorageDirectory.getPath());
            if (Build.VERSION.SDK_INT >= 18) {
                blockSize = statFs.getBlockSizeLong();
                statFs.getBlockCountLong();
                availableBlocks = statFs.getAvailableBlocksLong();
            } else {
                blockSize = statFs.getBlockSize();
                statFs.getBlockCount();
                availableBlocks = statFs.getAvailableBlocks();
            }
            this.m_szSpaceAvail = (blockSize * availableBlocks) >> 20;
        } catch (Exception e) {
            TDMLog.e(tag, "getStorage failed");
            TDMLog.i(tag, "exception track: " + e);
        }
    }

    public long GetAvailSpace() {
        GetSpaceInfo();
        return this.m_szSpaceAvail;
    }

    public NetworkType GetNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                TDMLog.w(tag, "NetworkStateChecker connManager is null");
                return NetworkType.NETWORK_UNKNOWN;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                if (1 == activeNetworkInfo.getType()) {
                    return NetworkType.NETWORK_WIFI;
                }
                if (activeNetworkInfo.getType() == 0) {
                    switch (activeNetworkInfo.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return NetworkType.NETWORK_2G;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return NetworkType.NETWORK_3G;
                        case 13:
                            return NetworkType.NETWORK_4G;
                        default:
                            return NetworkType.NETWORK_MOBILE;
                    }
                }
                if (9 == activeNetworkInfo.getType()) {
                    return NetworkType.NETWORK_WIRED;
                }
                return NetworkType.NETWORK_UNKNOWN;
            }
            TDMLog.w(tag, "NetworkStateChecker netInfo is null");
            return NetworkType.NETWORK_UNKNOWN;
        } catch (Exception e) {
            TDMLog.w(tag, "check Get exception");
            TDMLog.i(tag, "Exception Track: " + e);
            return NetworkType.NETWORK_UNKNOWN;
        }
    }

    public String GetSimOperator(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        return (telephonyManager == null || 5 != telephonyManager.getSimState()) ? CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR : telephonyManager.getSimOperator();
    }

    private String getCommentFromBuffer(byte[] bArr, int i) {
        byte[] bArr2 = {80, 75, 5, 6};
        for (int i2 = i - 22; i2 >= 0; i2--) {
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= bArr2.length) {
                    z = true;
                    break;
                }
                if (bArr[i2 + i3] != bArr2[i3]) {
                    break;
                }
                i3++;
            }
            if (z) {
                return new String(bArr, i2 + 22, Math.min(bArr[i2 + 20] + (bArr[i2 + 21] * 256), (i - i2) - 22), Charset.forName("UTF-8"));
            }
        }
        return "";
    }

    public String GetMetaString(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString(str);
        } catch (Exception e) {
            TDMLog.e(tag, "GetMetaString exception");
            TDMLog.i(tag, "Exception Track: " + e);
            return null;
        }
    }

    public boolean GetMetaBool(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean(str);
        } catch (Exception e) {
            TDMLog.e(tag, "GetMetaBool exception");
            TDMLog.i(tag, "Exception Track: " + e);
            return false;
        }
    }

    public int GetMetaInt(Context context, String str, int i) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getInt(str, i);
        } catch (Exception e) {
            TDMLog.e(tag, "GetMetaInt exception");
            TDMLog.i(tag, "Exception Track: " + e);
            return i;
        }
    }

    public long GetMetaLong(Context context, String str) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getLong(str);
        } catch (Exception e) {
            TDMLog.e(tag, "GetMetaLong exception");
            TDMLog.i(tag, "Exception Track: " + e);
            return 0L;
        }
    }
}
