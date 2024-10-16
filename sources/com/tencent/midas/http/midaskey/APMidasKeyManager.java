package com.tencent.midas.http.midaskey;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.midas.oversea.comm.APSPTools;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.HashMap;

/* loaded from: classes.dex */
public class APMidasKeyManager {
    private static final String AES_KEY = "caUdsBbJ1oOxMbPy";
    private final HashMap<String, String> secretKeyMap = new HashMap<>();
    private final HashMap<String, String> cryptKeyMap = new HashMap<>();
    private final HashMap<String, String> cryptKeyTimeMap = new HashMap<>();

    private String getEncodeKey() {
        String substring = AES_KEY.substring(0, 4);
        String substring2 = AES_KEY.substring(4, 8);
        return AES_KEY.substring(8, 12) + substring2 + substring + AES_KEY.substring(12, 16);
    }

    public void loadKeyFromDisk(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null || TextUtils.isEmpty(str3)) {
            return;
        }
        String readSecretKeyFromDisk = readSecretKeyFromDisk(context, str, str2, str3);
        String readCryptKeyFromDisk = readCryptKeyFromDisk(context, str, str2, str3);
        String readCryptKeyTimeFromDisk = readCryptKeyTimeFromDisk(context, str, str2, str3);
        if ((TextUtils.isEmpty(readSecretKeyFromDisk) || TextUtils.isEmpty(readCryptKeyFromDisk)) && TextUtils.isEmpty(readCryptKeyTimeFromDisk)) {
            return;
        }
        setSecretKeyToRam(str, str2, readSecretKeyFromDisk);
        setCryptKeyToRam(str, str2, readCryptKeyFromDisk);
        setCryptKeyTimeToRam(str, str2, readCryptKeyTimeFromDisk);
    }

    public boolean needChangeKey(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || context == null || TextUtils.isEmpty(str3)) {
            return false;
        }
        String secretKeyFromRam = getSecretKeyFromRam(str, str2);
        String cryptoKeyFromRam = getCryptoKeyFromRam(str, str2);
        String cryptKeyTimeFromRam = getCryptKeyTimeFromRam(str, str2);
        if (TextUtils.isEmpty(secretKeyFromRam) || TextUtils.isEmpty(cryptoKeyFromRam) || TextUtils.isEmpty(cryptKeyTimeFromRam)) {
            String readSecretKeyFromDisk = readSecretKeyFromDisk(context, str, str2, str3);
            String readCryptKeyFromDisk = readCryptKeyFromDisk(context, str, str2, str3);
            String readCryptKeyTimeFromDisk = readCryptKeyTimeFromDisk(context, str, str2, str3);
            if (TextUtils.isEmpty(readSecretKeyFromDisk) || TextUtils.isEmpty(readCryptKeyFromDisk) || TextUtils.isEmpty(readCryptKeyTimeFromDisk)) {
                clearAllKey(context, str, str2, str3);
                return true;
            }
            setSecretKeyToRam(str, str2, readSecretKeyFromDisk);
            setCryptKeyToRam(str, str2, readCryptKeyFromDisk);
            setCryptKeyTimeToRam(str, str2, readCryptKeyTimeFromDisk);
        }
        return false;
    }

    public String getSecretKeyFromRam(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String str3 = this.secretKeyMap.get(str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2);
        return str3 == null ? "" : str3;
    }

    public void setSecretKeyToRam(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        this.secretKeyMap.put(str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2, str3);
    }

    public String getCryptoKeyFromRam(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String str3 = this.cryptKeyMap.get(str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2);
        return TextUtils.isEmpty(str3) ? "" : str3;
    }

    public void setCryptKeyToRam(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        this.cryptKeyMap.put(str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2, str3);
    }

    public String getCryptKeyTimeFromRam(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        String str3 = this.cryptKeyTimeMap.get(str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2);
        return TextUtils.isEmpty(str3) ? "" : str3;
    }

    public void setCryptKeyTimeToRam(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        this.cryptKeyTimeMap.put(str + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2, str3);
    }

    private static synchronized String getDataFromSharedPreference(Context context, String str, String str2) {
        synchronized (APMidasKeyManager.class) {
            if (context == null) {
                return "";
            }
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            return context.getSharedPreferences(str, 4).getString(str2, "");
        }
    }

    private static synchronized void clearDataFromSharedPreference(Context context, String str, String str2) {
        synchronized (APMidasKeyManager.class) {
            if (context == null) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 4).edit();
            edit.remove(str2);
            edit.commit();
        }
    }

    private static synchronized void saveDataToSharedPreference(Context context, String str, String str2, String str3) {
        synchronized (APMidasKeyManager.class) {
            if (context == null) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            if (TextUtils.isEmpty(str3)) {
                return;
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 4).edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    public String readSecretKeyFromDisk(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || context == null || TextUtils.isEmpty(str3)) {
            return "";
        }
        String encodeKey = getEncodeKey();
        try {
            String dataFromSharedPreference = getDataFromSharedPreference(context, APSPTools.SP_NAME, str3 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_SecretEncodeKey");
            String doDecode = TextUtils.isEmpty(dataFromSharedPreference) ? "" : APMidasToolAES.doDecode(dataFromSharedPreference, encodeKey);
            return TextUtils.isEmpty(doDecode) ? "" : doDecode;
        } catch (Exception unused) {
            return "";
        }
    }

    public void saveSecretKeyToDisk(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4) || context == null) {
            return;
        }
        saveDataToSharedPreference(context, APSPTools.SP_NAME, str4 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_SecretEncodeKey", APMidasToolAES.doEncode(str3, getEncodeKey()));
    }

    public String readCryptKeyFromDisk(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || context == null || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return "";
        }
        String readSecretKeyFromDisk = readSecretKeyFromDisk(context, str, str2, str3);
        if (TextUtils.isEmpty(readSecretKeyFromDisk)) {
            return "";
        }
        String str4 = "";
        try {
            str4 = getDataFromSharedPreference(context, APSPTools.SP_NAME, str3 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_CryptEncodeKey");
        } catch (Exception unused) {
        }
        String doDecode = TextUtils.isEmpty(str4) ? "" : APMidasToolAES.doDecode(str4, readSecretKeyFromDisk);
        return TextUtils.isEmpty(doDecode) ? "" : doDecode;
    }

    public void saveCryptKeyToDisk(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4) || context == null) {
            return;
        }
        String secretKeyFromRam = getSecretKeyFromRam(str, str2);
        if (TextUtils.isEmpty(secretKeyFromRam)) {
            return;
        }
        saveDataToSharedPreference(context, APSPTools.SP_NAME, str4 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_CryptEncodeKey", APMidasToolAES.doEncode(str3, secretKeyFromRam));
    }

    public String readCryptKeyTimeFromDisk(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || context == null) {
            return "";
        }
        try {
            return getDataFromSharedPreference(context, APSPTools.SP_NAME, str3 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_CryptEncodeKeyTime");
        } catch (Exception unused) {
            return "";
        }
    }

    public void saveCryptKeyTimeToDisk(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str4) || context == null) {
            return;
        }
        saveDataToSharedPreference(context, APSPTools.SP_NAME, str4 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_CryptEncodeKeyTime", str3);
    }

    public void clearCryptKeyAndKeyTime(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || context == null) {
            return;
        }
        clearDataFromSharedPreference(context, APSPTools.SP_NAME, str3 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_CryptEncodeKey");
        clearDataFromSharedPreference(context, APSPTools.SP_NAME, str3 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_CryptEncodeKeyTime");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        sb.append(str2);
        String sb2 = sb.toString();
        this.cryptKeyMap.remove(sb2);
        this.cryptKeyTimeMap.remove(sb2);
    }

    public void clearAllKey(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || context == null) {
            return;
        }
        clearDataFromSharedPreference(context, APSPTools.SP_NAME, str3 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_CryptEncodeKey");
        clearDataFromSharedPreference(context, APSPTools.SP_NAME, str3 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_SecretEncodeKey");
        clearDataFromSharedPreference(context, APSPTools.SP_NAME, str3 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str2 + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + str + "_CryptEncodeKeyTime");
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR);
        sb.append(str2);
        String sb2 = sb.toString();
        this.cryptKeyMap.remove(sb2);
        this.secretKeyMap.remove(sb2);
        this.cryptKeyTimeMap.remove(sb2);
    }
}
