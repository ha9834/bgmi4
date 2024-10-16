package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class amn implements amk {

    /* renamed from: a, reason: collision with root package name */
    private final zzst f1972a;
    private final int b;
    private final int c;
    private int d;
    private int e;

    public amn(amh amhVar) {
        this.f1972a = amhVar.az;
        this.f1972a.setPosition(12);
        this.c = this.f1972a.zzgg() & 255;
        this.b = this.f1972a.zzgg();
    }

    @Override // com.google.android.gms.internal.ads.amk
    public final boolean c() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.amk
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.amk
    public final int b() {
        int i = this.c;
        if (i == 8) {
            return this.f1972a.readUnsignedByte();
        }
        if (i == 16) {
            return this.f1972a.readUnsignedShort();
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 % 2 == 0) {
            this.e = this.f1972a.readUnsignedByte();
            return (this.e & 240) >> 4;
        }
        return this.e & 15;
    }
}
