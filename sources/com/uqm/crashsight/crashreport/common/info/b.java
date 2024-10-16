package com.uqm.crashsight.crashreport.common.info;

/* loaded from: classes3.dex */
public final class b {
    private static b d;

    /* renamed from: a, reason: collision with root package name */
    private String f6571a = "";
    private String b = "";
    private String c = "";

    public static b a() {
        b bVar = d;
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = new b();
        d = bVar2;
        return bVar2;
    }

    public final synchronized void a(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.f6571a = str;
            }
        }
    }

    public final synchronized String b() {
        return this.f6571a;
    }

    public final synchronized void b(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.b = str;
            }
        }
    }

    public final synchronized String c() {
        return this.b;
    }

    public final synchronized void c(String str) {
        if (str != null) {
            if (str.length() > 0) {
                this.c = str;
            }
        }
    }

    public final synchronized String d() {
        return this.c;
    }
}
