package com.google.android.gms.internal.ads;

@zzard
/* loaded from: classes2.dex */
public final class zzbin {

    /* renamed from: a, reason: collision with root package name */
    private final int f2878a;
    public final int heightPixels;
    public final int widthPixels;

    public static zzbin zzb(zzyd zzydVar) {
        if (zzydVar.zzchf) {
            return new zzbin(3, 0, 0);
        }
        if (zzydVar.zzchh) {
            return new zzbin(2, 0, 0);
        }
        if (zzydVar.zzbsz) {
            return zzabu();
        }
        return zzr(zzydVar.widthPixels, zzydVar.heightPixels);
    }

    public static zzbin zzabu() {
        return new zzbin(0, 0, 0);
    }

    public static zzbin zzr(int i, int i2) {
        return new zzbin(1, i, i2);
    }

    public static zzbin zzabv() {
        return new zzbin(4, 0, 0);
    }

    public static zzbin zzabw() {
        return new zzbin(5, 0, 0);
    }

    private zzbin(int i, int i2, int i3) {
        this.f2878a = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public final boolean isFluid() {
        return this.f2878a == 2;
    }

    public final boolean zzabx() {
        return this.f2878a == 3;
    }

    public final boolean zzaby() {
        return this.f2878a == 0;
    }

    public final boolean zzabz() {
        return this.f2878a == 4;
    }

    public final boolean zzaca() {
        return this.f2878a == 5;
    }
}
