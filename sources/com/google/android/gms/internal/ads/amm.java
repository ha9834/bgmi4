package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class amm implements amk {

    /* renamed from: a, reason: collision with root package name */
    private final int f1971a;
    private final int b;
    private final zzst c;

    public amm(amh amhVar) {
        this.c = amhVar.az;
        this.c.setPosition(12);
        this.f1971a = this.c.zzgg();
        this.b = this.c.zzgg();
    }

    @Override // com.google.android.gms.internal.ads.amk
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.amk
    public final int b() {
        int i = this.f1971a;
        return i == 0 ? this.c.zzgg() : i;
    }

    @Override // com.google.android.gms.internal.ads.amk
    public final boolean c() {
        return this.f1971a != 0;
    }
}
