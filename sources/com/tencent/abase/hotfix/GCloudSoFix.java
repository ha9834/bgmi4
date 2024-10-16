package com.tencent.abase.hotfix;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.abase.utils.FileUtils;
import com.tencent.abase.utils.SDKUtils;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class GCloudSoFix {
    private static final String TAG = "ABase.GCloudSoFix";
    private static Context sContext;

    public static void init(Context context) {
        sContext = context;
    }

    public static void loadLibrary(String str) {
        if (str == null || str.isEmpty() || sContext == null) {
            Log.e(TAG, "libName or context is null!");
        } else {
            if (GCloudFixConfig.enableSoFix && loadLibraryFromGCloud(str)) {
                return;
            }
            System.loadLibrary(str);
        }
    }

    public static boolean loadLibraryFromGCloud(String str) throws UnsatisfiedLinkError {
        if (!str.startsWith("lib")) {
            str = "lib" + str;
        }
        if (!str.endsWith(".so")) {
            str = str + ".so";
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (String str2 : SDKUtils.getAllSDKNames(sContext)) {
            List<SoInfo> patchSoInfos = PatchManager.getPatchSoInfos(str2);
            if (patchSoInfos != null) {
                for (SoInfo soInfo : patchSoInfos) {
                    if (str.equals(soInfo.name)) {
                        String str3 = PatchManager.getPatchLibPath(sContext, str2) + "/" + str;
                        File file = new File(str3);
                        if (file.exists()) {
                            if (GCloudFixConfig.enableSoMd5Check && !FileUtils.verifyFileMd5(file, soInfo.md5)) {
                                Log.e(TAG, str3 + " md5 dismatch!");
                                return false;
                            }
                            System.load(str3);
                            Log.i(TAG, "loadLibraryFromGCloud success:" + str3 + ",cost: " + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
