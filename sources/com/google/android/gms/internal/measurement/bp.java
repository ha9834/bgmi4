package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bp {

    /* renamed from: a, reason: collision with root package name */
    private final zzee f4489a;
    private final byte[] b;

    private bp(int i) {
        this.b = new byte[i];
        this.f4489a = zzee.zzf(this.b);
    }

    public final zzdp a() {
        this.f4489a.zzth();
        return new zzdz(this.b);
    }

    public final zzee b() {
        return this.f4489a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bp(int i, bk bkVar) {
        this(i);
    }
}
