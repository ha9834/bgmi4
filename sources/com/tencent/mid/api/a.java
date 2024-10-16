package com.tencent.mid.api;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f6260a;
    private Context b;
    private SharedPreferences c;
    private String d = "__QQ_MID_STR__";

    public SharedPreferences a() {
        return this.c;
    }

    private a(Context context) {
        this.b = null;
        this.c = null;
        this.b = context.getApplicationContext();
        this.c = this.b.getSharedPreferences(this.b.getPackageName() + ".mid.world.ro", 0);
    }

    public void a(String str) {
        if (str == null || !str.equals(b())) {
            this.c.edit().putString(this.d, str).commit();
        }
    }

    public String b() {
        return this.c.getString(this.d, null);
    }

    public static a a(Context context) {
        if (f6260a == null) {
            synchronized (a.class) {
                if (f6260a == null) {
                    f6260a = new a(context);
                }
            }
        }
        return f6260a;
    }
}
