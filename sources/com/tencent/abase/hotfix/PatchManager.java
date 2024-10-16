package com.tencent.abase.hotfix;

import android.content.Context;
import android.util.Log;
import com.tencent.abase.utils.FileUtils;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PatchManager {
    private static final String PATCH_FILE_NAME = "patch.zip";
    private static final String PATCH_INFO_FILE_NAME = "patch_info.json";
    private static final String PATCH_LIB_DIR_NAME = "lib";
    private static final String PATCH_ROOT_DIR_NAME = "GCloudPatch";
    private static final String TAG = "ABase.PatchManager";
    private static Map<String, List<SoInfo>> sPatchSoInfos = new ConcurrentHashMap();

    public static boolean copyPatch(Context context, String str, File file) {
        File file2 = new File(getPatchRootPath(context));
        if (!file2.exists() && !file2.mkdir()) {
            Log.e(TAG, "mkdir " + file2.getAbsolutePath() + "failed!");
            return false;
        }
        File file3 = new File(getPatchSDKPath(context, str));
        if (!file3.exists() && !file3.mkdir()) {
            Log.e(TAG, "mkdir " + file3.getAbsolutePath() + "failed!");
            return false;
        }
        try {
            FileUtils.copyFileUsingStream(file, new File(getPatchFilePath(context, str)));
            Log.i(TAG, " delete originalFile success!");
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean excractSo(android.content.Context r9, java.lang.String r10, java.util.List<com.tencent.abase.hotfix.SoInfo> r11) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.abase.hotfix.PatchManager.excractSo(android.content.Context, java.lang.String, java.util.List):boolean");
    }

    public static void setPatchSoInfos(String str, List<SoInfo> list) {
        sPatchSoInfos.put(str, list);
    }

    public static List<SoInfo> getPatchSoInfos(String str) {
        return sPatchSoInfos.get(str);
    }

    public static int getSDKPatchVersion(Context context, String str, String str2) {
        File file = new File(getPatchInfoFilePath(context, str));
        if (!file.exists()) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(FileUtils.readFileToString(file));
            String string = jSONObject.getString("sdk_name");
            String string2 = jSONObject.getString(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION);
            if (str.equals(string) && str2.equals(string2)) {
                return jSONObject.getInt("patch_version");
            }
            return 0;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static void updateSDKPatchVersion(Context context, PatchInfo patchInfo) {
        String jSONObject;
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("sdk_name", patchInfo.sdkName);
                jSONObject2.put(Constants.JumpUrlConstants.URL_KEY_SDK_VERSION, patchInfo.sdkVersion);
                jSONObject2.put("patch_version", patchInfo.patchVersion);
                jSONObject = jSONObject2.toString();
                fileWriter = new FileWriter(getPatchInfoFilePath(context, patchInfo.sdkName));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            fileWriter.write(jSONObject);
            FileUtils.closeQuietly(fileWriter);
        } catch (IOException e3) {
            e = e3;
            fileWriter2 = fileWriter;
            e.printStackTrace();
            FileUtils.closeQuietly(fileWriter2);
        } catch (JSONException e4) {
            e = e4;
            fileWriter2 = fileWriter;
            e.printStackTrace();
            FileUtils.closeQuietly(fileWriter2);
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            FileUtils.closeQuietly(fileWriter2);
            throw th;
        }
    }

    public static String getPatchRootPath(Context context) {
        return context.getFilesDir() + "/" + PATCH_ROOT_DIR_NAME;
    }

    public static String getPatchSDKPath(Context context, String str) {
        return getPatchRootPath(context) + "/" + str;
    }

    public static String getPatchLibPath(Context context, String str) {
        return getPatchSDKPath(context, str) + "/" + PATCH_LIB_DIR_NAME;
    }

    public static String getPatchFilePath(Context context, String str) {
        return getPatchSDKPath(context, str) + "/" + PATCH_FILE_NAME;
    }

    public static String getPatchInfoFilePath(Context context, String str) {
        return getPatchSDKPath(context, str) + "/" + PATCH_INFO_FILE_NAME;
    }
}
