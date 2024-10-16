package com.vk.api.sdk.chain;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private String f6868a = "";
    private String b = "";
    private boolean c;

    public final String a() {
        return this.f6868a;
    }

    public final void a(String str) {
        kotlin.jvm.internal.h.b(str, "<set-?>");
        this.f6868a = str;
    }

    public final String b() {
        return this.b;
    }

    public final void b(String str) {
        kotlin.jvm.internal.h.b(str, "<set-?>");
        this.b = str;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        if (this.f6868a.length() > 0) {
            if (this.b.length() > 0) {
                return true;
            }
        }
        return false;
    }
}
