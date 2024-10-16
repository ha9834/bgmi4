package com.tencent.mid.local;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    protected Context f6266a;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context) {
        this.f6266a = null;
        this.f6266a = context;
    }

    public static String c() {
        return i.d("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=");
    }

    private String f() {
        if (a()) {
            return a(b());
        }
        return null;
    }

    protected String a(String str) {
        return i.d(str);
    }

    protected abstract boolean a();

    protected abstract String b();

    public c d() {
        String f = f();
        if (f != null) {
            return c.a(f);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String e() {
        return i.d("4kU71lN96TJUomD1vOU9lgj9Tw==");
    }
}
