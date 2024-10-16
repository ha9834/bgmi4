package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class qt implements zzbam<zzp, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ double f2448a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzcan c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public qt(zzcan zzcanVar, double d, boolean z) {
        this.c = zzcanVar;
        this.f2448a = d;
        this.b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbam
    public final /* synthetic */ Bitmap apply(zzp zzpVar) {
        Bitmap a2;
        a2 = this.c.a(zzpVar.data, this.f2448a, this.b);
        return a2;
    }
}
