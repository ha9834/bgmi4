package com.tencent.msdk.stat.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.tencent.msdk.stat.StatConfig;
import java.util.Map;

/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    private static SharedPreferences f6325a;
    private static StatLogger b = j.b();

    public static int a(Context context, String str, int i) {
        return a(context).getInt(b(context, str), i);
    }

    public static long a(Context context, String str, long j) {
        return a(context).getLong(b(context, str), j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized SharedPreferences a(Context context) {
        SharedPreferences defaultSharedPreferences;
        SharedPreferences sharedPreferences;
        synchronized (o.class) {
            if (f6325a == null) {
                try {
                    if (StatConfig.getMTAPreferencesFileName() != null && StatConfig.getMTAPreferencesFileName().trim().length() != 0) {
                        defaultSharedPreferences = context.getSharedPreferences(StatConfig.getMTAPreferencesFileName(), 0);
                        f6325a = defaultSharedPreferences;
                    }
                    defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                    f6325a = defaultSharedPreferences;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            sharedPreferences = f6325a;
        }
        return sharedPreferences;
    }

    public static String a(Context context, String str, String str2) {
        return a(context).getString(b(context, str), str2);
    }

    public static void a(Context context, Map<String, Object> map) {
        if (context == null || map == null || map.size() == 0) {
            return;
        }
        b.i("putObjectList size:" + map.size());
        SharedPreferences.Editor edit = a(context).edit();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String b2 = b(context, entry.getKey());
            Object value = entry.getValue();
            try {
                if (value instanceof String) {
                    b.i("putObjectList putString:" + b2 + "," + value);
                    edit.putString(b2, (String) value);
                } else if (value instanceof Long) {
                    b.i("putObjectList putLong:" + b2 + "," + value);
                    edit.putLong(b2, ((Long) value).longValue());
                } else if (value instanceof Boolean) {
                    b.i("putObjectList putBoolean:" + b2 + "," + value);
                    edit.putBoolean(b2, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    b.i("putObjectList putInt:" + b2 + "," + value);
                    edit.putInt(b2, ((Integer) value).intValue());
                } else if (value instanceof Float) {
                    b.i("putObjectList putFloat:" + b2 + "," + value);
                    edit.putFloat(b2, ((Float) value).floatValue());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        edit.commit();
    }

    public static boolean a(Context context, String str) {
        return a(context).contains(b(context, str));
    }

    public static String b(Context context, String str) {
        return j.a(context, "" + str);
    }

    public static void b(Context context, String str, int i) {
        if (a(context, str, Integer.MAX_VALUE) == i) {
            return;
        }
        String b2 = b(context, str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putInt(b2, i);
        edit.commit();
    }

    public static void b(Context context, String str, long j) {
        if (a(context, str, Long.MAX_VALUE) == j) {
            return;
        }
        String b2 = b(context, str);
        SharedPreferences.Editor edit = a(context).edit();
        edit.putLong(b2, j);
        edit.commit();
    }

    public static void b(Context context, String str, String str2) {
        String a2 = a(context, str, (String) null);
        if (str2 == null && a2 == null) {
            return;
        }
        if (str2 == null || a2 == null || !str2.equals(a2)) {
            String b2 = b(context, str);
            SharedPreferences.Editor edit = a(context).edit();
            edit.putString(b2, str2);
            edit.commit();
        }
    }
}
