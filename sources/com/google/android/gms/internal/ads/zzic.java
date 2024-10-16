package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzic implements zzip {

    /* renamed from: a, reason: collision with root package name */
    private final ajy f3655a;
    private final zzhm b = new zzhm(0);
    private boolean c = true;
    private long d = Long.MIN_VALUE;
    private long e = Long.MIN_VALUE;
    private volatile long f = Long.MIN_VALUE;
    private volatile zzhj g;

    public zzic(zzjl zzjlVar) {
        this.f3655a = new ajy(zzjlVar);
    }

    public final void clear() {
        this.f3655a.a();
        this.c = true;
        this.d = Long.MIN_VALUE;
        this.e = Long.MIN_VALUE;
        this.f = Long.MIN_VALUE;
    }

    public final boolean zzfd() {
        return this.g != null;
    }

    public final zzhj zzfe() {
        return this.g;
    }

    public final long zzff() {
        return this.f;
    }

    public final boolean isEmpty() {
        return !a();
    }

    public final boolean zza(zzhm zzhmVar) {
        if (!a()) {
            return false;
        }
        this.f3655a.b(zzhmVar);
        this.c = false;
        this.d = zzhmVar.zzaga;
        return true;
    }

    public final void zzdr(long j) {
        while (this.f3655a.a(this.b) && this.b.zzaga < j) {
            this.f3655a.b();
            this.c = true;
        }
        this.d = Long.MIN_VALUE;
    }

    public final boolean zzds(long j) {
        return this.f3655a.a(j);
    }

    private final boolean a() {
        boolean a2 = this.f3655a.a(this.b);
        if (this.c) {
            while (a2 && !this.b.zzep()) {
                this.f3655a.b();
                a2 = this.f3655a.a(this.b);
            }
        }
        if (a2) {
            return this.e == Long.MIN_VALUE || this.b.zzaga < this.e;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public final void zza(zzhj zzhjVar) {
        this.g = zzhjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public final int zza(zzie zzieVar, int i) throws IOException, InterruptedException {
        return this.f3655a.a(zzieVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public final void zza(zzkm zzkmVar, int i) {
        this.f3655a.a(zzkmVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzip
    public void zza(long j, int i, int i2, int i3, byte[] bArr) {
        this.f = Math.max(this.f, j);
        ajy ajyVar = this.f3655a;
        ajyVar.a(j, i, (ajyVar.c() - i2) - i3, i2, bArr);
    }
}
