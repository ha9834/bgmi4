package com.tencent.mid.util;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class g {
    private static volatile g c;

    /* renamed from: a, reason: collision with root package name */
    private int f6277a = 10;
    private int b;
    private Context d;
    private boolean e;

    public boolean a(String str, String str2) {
        if (!this.e) {
            return false;
        }
        try {
            return Settings.System.putString(this.d.getContentResolver(), str, str2);
        } catch (Throwable th) {
            int i = this.b;
            this.b = i + 1;
            if (i >= this.f6277a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public String a(String str) {
        try {
            return Settings.System.getString(this.d.getContentResolver(), str);
        } catch (Throwable th) {
            int i = this.b;
            this.b = i + 1;
            if (i >= this.f6277a) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    public boolean a(String str, int i) {
        if (!this.e) {
            return false;
        }
        try {
            return Settings.System.putInt(this.d.getContentResolver(), str, i);
        } catch (Throwable th) {
            int i2 = this.b;
            this.b = i2 + 1;
            if (i2 >= this.f6277a) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    public int b(String str, int i) {
        try {
            return Settings.System.getInt(this.d.getContentResolver(), str, i);
        } catch (Throwable th) {
            int i2 = this.b;
            this.b = i2 + 1;
            if (i2 < this.f6277a) {
                th.printStackTrace();
            }
            return i;
        }
    }

    private g(Context context) {
        this.b = 0;
        this.d = null;
        this.e = false;
        this.d = context.getApplicationContext();
        try {
            this.e = Util.checkPermission(this.d, "android.permission.WRITE_SETTINGS");
            if (!this.e || Build.VERSION.SDK_INT < 23) {
                return;
            }
            Method declaredMethod = Settings.System.class.getDeclaredMethod("canWrite", Context.class);
            declaredMethod.setAccessible(true);
            this.e = ((Boolean) declaredMethod.invoke(null, this.d)).booleanValue();
        } catch (Throwable th) {
            int i = this.b;
            this.b = i + 1;
            if (i < this.f6277a) {
                th.printStackTrace();
            }
        }
    }

    public static g a(Context context) {
        if (c == null) {
            synchronized (g.class) {
                if (c == null) {
                    c = new g(context);
                }
            }
        }
        return c;
    }
}
