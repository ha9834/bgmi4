package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aew {

    /* renamed from: a, reason: collision with root package name */
    private final zzdni f1838a;
    private final byte[] b;

    private aew(int i) {
        this.b = new byte[i];
        this.f1838a = zzdni.zzab(this.b);
    }

    public final zzdmr a() {
        this.f1838a.zzawv();
        return new zzdnb(this.b);
    }

    public final zzdni b() {
        return this.f1838a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aew(int i, aer aerVar) {
        this(i);
    }
}
