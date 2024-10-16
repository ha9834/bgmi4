package com.tencent.msdk.a.a;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    protected Context f6281a;

    /* JADX INFO: Access modifiers changed from: protected */
    public g(Context context) {
        this.f6281a = null;
        this.f6281a = context;
    }

    public static String c() {
        return i.d("6X8Y4XdM2Vhvn0I=");
    }

    public static String d() {
        return i.d("6X8Y4XdM2Vhvn0KfzcEatGnWaNU=");
    }

    private void d(String str) {
        if (a()) {
            a(b(str));
        }
    }

    private String g() {
        if (a()) {
            return c(b());
        }
        return null;
    }

    public void a(d dVar) {
        if (dVar == null) {
            return;
        }
        d(dVar.toString());
    }

    protected abstract void a(String str);

    protected abstract boolean a();

    protected abstract String b();

    protected String b(String str) {
        return i.e(str);
    }

    protected String c(String str) {
        return i.d(str);
    }

    public d e() {
        String g = g();
        if (g != null) {
            return d.a(g);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String f() {
        return i.d("4kU71lN96TJUomD1vOU9lgj9Tw==");
    }
}
