package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class amj {

    /* renamed from: a, reason: collision with root package name */
    public final int f1969a;
    public int b;
    public int c;
    public long d;
    private final boolean e;
    private final zzst f;
    private final zzst g;
    private int h;
    private int i;

    public amj(zzst zzstVar, zzst zzstVar2, boolean z) {
        this.g = zzstVar;
        this.f = zzstVar2;
        this.e = z;
        zzstVar2.setPosition(12);
        this.f1969a = zzstVar2.zzgg();
        zzstVar.setPosition(12);
        this.i = zzstVar.zzgg();
        zzsk.checkState(zzstVar.readInt() == 1, "first_chunk must be 1");
        this.b = -1;
    }

    public final boolean a() {
        int i = this.b + 1;
        this.b = i;
        if (i == this.f1969a) {
            return false;
        }
        this.d = this.e ? this.f.zzgh() : this.f.zzge();
        if (this.b == this.h) {
            this.c = this.g.zzgg();
            this.g.zzac(4);
            int i2 = this.i - 1;
            this.i = i2;
            this.h = i2 > 0 ? this.g.zzgg() - 1 : -1;
        }
        return true;
    }
}
