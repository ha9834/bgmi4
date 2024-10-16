package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzl;

/* loaded from: classes2.dex */
final class da {

    /* renamed from: a, reason: collision with root package name */
    private bs<zzl> f5113a;
    private zzl b;

    public da(bs<zzl> bsVar, zzl zzlVar) {
        this.f5113a = bsVar;
        this.b = zzlVar;
    }

    public final bs<zzl> a() {
        return this.f5113a;
    }

    public final zzl b() {
        return this.b;
    }

    public final int c() {
        int zzse = this.f5113a.a().zzse();
        zzl zzlVar = this.b;
        return zzse + (zzlVar == null ? 0 : zzlVar.zzse());
    }
}
