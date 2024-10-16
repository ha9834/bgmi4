package com.tencent.msdk.a.a;

import android.content.Context;
import android.os.Build;
import android.util.Base64;
import android.util.Log;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class i {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(String str) {
        Log.i("MID", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Throwable th) {
        Log.w("MID", th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(JSONObject jSONObject, String str, String str2) {
        if (b(str2)) {
            jSONObject.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        try {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } catch (Throwable th) {
            Log.e("MID", "checkPermission error", th);
            return false;
        }
    }

    public static boolean b(String str) {
        return (str == null || str.trim().length() == 0) ? false : true;
    }

    public static boolean c(String str) {
        return str != null && str.trim().length() >= 40;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String d(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(com.tencent.msdk.stat.common.e.b(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            Log.e("MID", "decode error", th);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String e(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(com.tencent.msdk.stat.common.e.a(str.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            Log.w("MID", "encode error", th);
            return str;
        }
    }
}
