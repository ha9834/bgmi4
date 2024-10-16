package com.helpshift.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.adjust.sdk.Constants;
import com.helpshift.constants.CommonSharedPrefrences;
import java.io.File;
import java.security.MessageDigest;
import java.util.Map;

/* loaded from: classes2.dex */
public class SDKSanityCheck {
    private static final String TAG = "Helpshift_SntyChck";

    public static void checkInstallCredsSanity(Context context, String str, String str2, String str3, String str4, Map<String, String> map) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        try {
            String string = sharedPreferences.getString(CommonSharedPrefrences.LIBRARY_VERSION, "");
            String string2 = sharedPreferences.getString(CommonSharedPrefrences.INSTALL_CREDS_HASH, "");
            String generateInstallCredsHash = generateInstallCredsHash(str2, str3, str4);
            if (StringUtils.isEmpty(string)) {
                Log.d(TAG, "SDK version empty, SDK sanity check not needed.");
                storeInstallHash(sharedPreferences, generateInstallCredsHash);
                return;
            }
            if (StringUtils.isEmpty(string2)) {
                if (!str3.endsWith(".com")) {
                    Log.d(TAG, "Old install hash does not exist and domain change to " + str3);
                    deleteDatabases(context, map);
                }
                storeInstallHash(sharedPreferences, generateInstallCredsHash);
                return;
            }
            if (generateInstallCredsHash.equals(string2)) {
                return;
            }
            Log.d(TAG, "Install creds changed, delete all data.");
            deleteDatabases(context, map);
            storeInstallHash(sharedPreferences, generateInstallCredsHash);
        } catch (Exception e) {
            Log.e(TAG, "Error while install creds sanity check:", e);
        }
    }

    private static void deleteDatabases(Context context, Map<String, String> map) {
        Log.d(TAG, "Deleting databases for install creds switch");
        File databasePath = context.getDatabasePath("dummy");
        File parentFile = databasePath == null ? null : databasePath.getParentFile();
        for (String str : map.values()) {
            context.deleteDatabase(str);
            deleteFileByName(parentFile, str);
        }
    }

    private static void deleteFileByName(File file, String str) {
        File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2.getName() != null && file2.getName().startsWith(str)) {
                file2.delete();
            }
        }
    }

    private static void storeInstallHash(SharedPreferences sharedPreferences, String str) {
        Log.d(TAG, "Storing install creds hash");
        sharedPreferences.edit().putString(CommonSharedPrefrences.INSTALL_CREDS_HASH, str).commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String generateInstallCredsHash(String str, String str2, String str3) throws Exception {
        try {
            byte[] digest = MessageDigest.getInstance(Constants.MD5).digest((str + "|" + str2 + "|" + str3).getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", Byte.valueOf(b)));
            }
            return sb.toString();
        } catch (Exception e) {
            Log.e("Helpshift", "Error in generating MD5 hash");
            throw e;
        }
    }
}
