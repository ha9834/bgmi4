package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbze {

    /* renamed from: a, reason: collision with root package name */
    zzafl f3134a;
    zzafi b;
    zzafx c;
    zzafu d;
    zzaje e;
    final androidx.b.g<String, zzafr> f = new androidx.b.g<>();
    final androidx.b.g<String, zzafo> g = new androidx.b.g<>();

    public final zzbze zzb(zzafl zzaflVar) {
        this.f3134a = zzaflVar;
        return this;
    }

    public final zzbze zzb(zzafi zzafiVar) {
        this.b = zzafiVar;
        return this;
    }

    public final zzbze zzb(zzafx zzafxVar) {
        this.c = zzafxVar;
        return this;
    }

    public final zzbze zza(zzafu zzafuVar) {
        this.d = zzafuVar;
        return this;
    }

    public final zzbze zzb(zzaje zzajeVar) {
        this.e = zzajeVar;
        return this;
    }

    public final zzbze zzb(String str, zzafr zzafrVar, zzafo zzafoVar) {
        this.f.put(str, zzafrVar);
        this.g.put(str, zzafoVar);
        return this;
    }

    public final zzbzc zzaip() {
        return new zzbzc(this);
    }
}
