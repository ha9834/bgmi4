package com.adjust.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class PreinstallUtil {
    private static final long ALL_LOCATION_BITMASK = 255;
    private static final long CONTENT_PROVIDER_BITMASK = 16;
    private static final long CONTENT_PROVIDER_INTENT_ACTION_BITMASK = 32;
    private static final long CONTENT_PROVIDER_NO_PERMISSION_BITMASK = 128;
    private static final long FILE_SYSTEM_BITMASK = 64;
    private static final long SYSTEM_PROPERTY_BITMASK = 1;
    private static final long SYSTEM_PROPERTY_PATH_BITMASK = 4;
    private static final long SYSTEM_PROPERTY_PATH_REFLECTION_BITMASK = 8;
    private static final long SYSTEM_PROPERTY_REFLECTION_BITMASK = 2;

    public static boolean hasAllLocationsBeenRead(long j) {
        return (j & ALL_LOCATION_BITMASK) == ALL_LOCATION_BITMASK;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean hasNotBeenRead(String str, long j) {
        char c;
        switch (str.hashCode()) {
            case -1771852303:
                if (str.equals(Constants.CONTENT_PROVIDER_INTENT_ACTION)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1590804087:
                if (str.equals(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -782042377:
                if (str.equals(Constants.CONTENT_PROVIDER)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -480091743:
                if (str.equals(Constants.SYSTEM_PROPERTIES_PATH)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -468656985:
                if (str.equals(Constants.SYSTEM_PROPERTIES_REFLECTION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -95318717:
                if (str.equals(Constants.SYSTEM_PROPERTIES)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2055247442:
                if (str.equals(Constants.FILE_SYSTEM)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2080271301:
                if (str.equals(Constants.CONTENT_PROVIDER_NO_PERMISSION)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return (j & 1) != 1;
            case 1:
                return (j & 2) != 2;
            case 2:
                return (j & 4) != 4;
            case 3:
                return (j & SYSTEM_PROPERTY_PATH_REFLECTION_BITMASK) != SYSTEM_PROPERTY_PATH_REFLECTION_BITMASK;
            case 4:
                return (j & CONTENT_PROVIDER_BITMASK) != CONTENT_PROVIDER_BITMASK;
            case 5:
                return (j & CONTENT_PROVIDER_INTENT_ACTION_BITMASK) != CONTENT_PROVIDER_INTENT_ACTION_BITMASK;
            case 6:
                return (j & FILE_SYSTEM_BITMASK) != FILE_SYSTEM_BITMASK;
            case 7:
                return (j & CONTENT_PROVIDER_NO_PERMISSION_BITMASK) != CONTENT_PROVIDER_NO_PERMISSION_BITMASK;
            default:
                return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static long markAsRead(String str, long j) {
        char c;
        switch (str.hashCode()) {
            case -1771852303:
                if (str.equals(Constants.CONTENT_PROVIDER_INTENT_ACTION)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1590804087:
                if (str.equals(Constants.SYSTEM_PROPERTIES_PATH_REFLECTION)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -782042377:
                if (str.equals(Constants.CONTENT_PROVIDER)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -480091743:
                if (str.equals(Constants.SYSTEM_PROPERTIES_PATH)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -468656985:
                if (str.equals(Constants.SYSTEM_PROPERTIES_REFLECTION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -95318717:
                if (str.equals(Constants.SYSTEM_PROPERTIES)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 2055247442:
                if (str.equals(Constants.FILE_SYSTEM)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 2080271301:
                if (str.equals(Constants.CONTENT_PROVIDER_NO_PERMISSION)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return j | 1;
            case 1:
                return j | 2;
            case 2:
                return j | 4;
            case 3:
                return j | SYSTEM_PROPERTY_PATH_REFLECTION_BITMASK;
            case 4:
                return j | CONTENT_PROVIDER_BITMASK;
            case 5:
                return j | CONTENT_PROVIDER_INTENT_ACTION_BITMASK;
            case 6:
                return j | FILE_SYSTEM_BITMASK;
            case 7:
                return j | CONTENT_PROVIDER_NO_PERMISSION_BITMASK;
            default:
                return j;
        }
    }

    public static String getPayloadFromSystemProperty(String str, ILogger iLogger) {
        return readSystemProperty(Constants.ADJUST_PREINSTALL_SYSTEM_PROPERTY_PREFIX + str, iLogger);
    }

    public static String getPayloadFromSystemPropertyReflection(String str, ILogger iLogger) {
        return readSystemPropertyReflection(Constants.ADJUST_PREINSTALL_SYSTEM_PROPERTY_PREFIX + str, iLogger);
    }

    public static String getPayloadFromSystemPropertyFilePath(String str, ILogger iLogger) {
        String readFileContent;
        String readSystemProperty = readSystemProperty(Constants.ADJUST_PREINSTALL_SYSTEM_PROPERTY_PATH, iLogger);
        if (readSystemProperty == null || readSystemProperty.isEmpty() || (readFileContent = readFileContent(readSystemProperty, iLogger)) == null || readFileContent.isEmpty()) {
            return null;
        }
        return readPayloadFromJsonString(readFileContent, str, iLogger);
    }

    public static String getPayloadFromSystemPropertyFilePathReflection(String str, ILogger iLogger) {
        String readFileContent;
        String readSystemPropertyReflection = readSystemPropertyReflection(Constants.ADJUST_PREINSTALL_SYSTEM_PROPERTY_PATH, iLogger);
        if (readSystemPropertyReflection == null || readSystemPropertyReflection.isEmpty() || (readFileContent = readFileContent(readSystemPropertyReflection, iLogger)) == null || readFileContent.isEmpty()) {
            return null;
        }
        return readPayloadFromJsonString(readFileContent, str, iLogger);
    }

    public static String getPayloadFromContentProviderDefault(Context context, String str, ILogger iLogger) {
        if (Util.resolveContentProvider(context, Constants.ADJUST_PREINSTALL_CONTENT_URI_AUTHORITY)) {
            return readContentProvider(context, Util.formatString("content://%s/%s", Constants.ADJUST_PREINSTALL_CONTENT_URI_AUTHORITY, Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH), str, iLogger);
        }
        return null;
    }

    public static List<String> getPayloadsFromContentProviderIntentAction(Context context, String str, ILogger iLogger) {
        return readContentProviderIntentAction(context, str, "android.permission.INSTALL_PACKAGES", iLogger);
    }

    public static List<String> getPayloadsFromContentProviderNoPermission(Context context, String str, ILogger iLogger) {
        return readContentProviderIntentAction(context, str, null, iLogger);
    }

    public static String getPayloadFromFileSystem(String str, String str2, ILogger iLogger) {
        String readFileContent = readFileContent(Constants.ADJUST_PREINSTALL_FILE_SYSTEM_PATH, iLogger);
        if (readFileContent == null || readFileContent.isEmpty()) {
            if (str2 != null && !str2.isEmpty()) {
                readFileContent = readFileContent(str2, iLogger);
            }
            if (readFileContent == null || readFileContent.isEmpty()) {
                return null;
            }
        }
        return readPayloadFromJsonString(readFileContent, str, iLogger);
    }

    private static String readSystemProperty(String str, ILogger iLogger) {
        try {
            return System.getProperty(str);
        } catch (Exception e) {
            iLogger.error("Exception read system property key [%s] error [%s]", str, e.getMessage());
            return null;
        }
    }

    @SuppressLint({"PrivateApi"})
    private static String readSystemPropertyReflection(String str, ILogger iLogger) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
        } catch (Exception e) {
            iLogger.error("Exception read system property using reflection key [%s] error [%s]", str, e.getMessage());
            return null;
        }
    }

    private static String readContentProvider(Context context, String str, String str2, ILogger iLogger) {
        try {
            Cursor query = context.getContentResolver().query(Uri.parse(str), new String[]{"encrypted_data"}, "package_name=?", new String[]{str2}, null);
            if (query == null) {
                iLogger.debug("Read content provider cursor null content uri [%s]", str);
                return null;
            }
            if (!query.moveToFirst()) {
                iLogger.debug("Read content provider cursor empty content uri [%s]", str);
                query.close();
                return null;
            }
            String string = query.getString(0);
            query.close();
            return string;
        } catch (Exception e) {
            iLogger.error("Exception read content provider uri [%s] error [%s]", str, e.getMessage());
            return null;
        }
    }

    private static List<String> readContentProviderIntentAction(Context context, String str, String str2, ILogger iLogger) {
        String str3;
        String readContentProvider;
        if (Build.VERSION.SDK_INT < 19) {
            return null;
        }
        List<ResolveInfo> queryIntentContentProviders = context.getPackageManager().queryIntentContentProviders(new Intent(Constants.ADJUST_PREINSTALL_CONTENT_PROVIDER_INTENT_ACTION), 0);
        ArrayList arrayList = new ArrayList();
        for (ResolveInfo resolveInfo : queryIntentContentProviders) {
            if ((str2 == null || context.getPackageManager().checkPermission(str2, resolveInfo.providerInfo.packageName) == 0) && (str3 = resolveInfo.providerInfo.authority) != null && !str3.isEmpty() && (readContentProvider = readContentProvider(context, Util.formatString("content://%s/%s", str3, Constants.ADJUST_PREINSTALL_CONTENT_URI_PATH), str, iLogger)) != null && !readContentProvider.isEmpty()) {
                arrayList.add(readContentProvider);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    private static String readFileContent(String str, ILogger iLogger) {
        File file = new File(str);
        if (file.exists() && file.isFile() && file.canRead()) {
            try {
                int length = (int) file.length();
                if (length <= 0) {
                    iLogger.debug("Read file content empty file", new Object[0]);
                    return null;
                }
                byte[] bArr = new byte[length];
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    try {
                        fileInputStream.read(bArr);
                        fileInputStream.close();
                        return new String(bArr);
                    } catch (Exception e) {
                        iLogger.error("Exception read file input stream error [%s]", e.getMessage());
                        fileInputStream.close();
                        return null;
                    }
                } catch (Throwable th) {
                    fileInputStream.close();
                    throw th;
                }
            } catch (Exception e2) {
                iLogger.error("Exception read file content error [%s]", e2.getMessage());
            }
        }
        return null;
    }

    private static String readPayloadFromJsonString(String str, String str2, ILogger iLogger) {
        try {
            return new JSONObject(str.trim()).optString(str2);
        } catch (Exception e) {
            iLogger.error("Exception read payload from json string error [%s]", e.getMessage());
            return null;
        }
    }
}
