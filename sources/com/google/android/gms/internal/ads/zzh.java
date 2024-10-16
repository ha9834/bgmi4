package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzh implements zzac {

    /* renamed from: a, reason: collision with root package name */
    private int f3644a;
    private int b;
    private final int c;
    private final float d;

    public zzh() {
        this(2500, 1, 1.0f);
    }

    private zzh(int i, int i2, float f) {
        this.f3644a = 2500;
        this.c = 1;
        this.d = 1.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final int zzb() {
        return this.f3644a;
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final int zzc() {
        return this.b;
    }

    @Override // com.google.android.gms.internal.ads.zzac
    public final void zza(zzaf zzafVar) throws zzaf {
        this.b++;
        int i = this.f3644a;
        this.f3644a = i + ((int) (i * this.d));
        if (!(this.b <= this.c)) {
            throw zzafVar;
        }
    }
}
