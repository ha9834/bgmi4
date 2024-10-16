package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzcdn {

    /* renamed from: a, reason: collision with root package name */
    private final zzbhf f3196a;
    private final Context b;
    private final zzcxv c;
    private final zzdh d;
    private final zzbai e;
    private final com.google.android.gms.ads.internal.zza f;
    private final zzwj g;
    private final zzbtb h;

    public zzcdn(zzbhf zzbhfVar, Context context, zzcxv zzcxvVar, zzdh zzdhVar, zzbai zzbaiVar, com.google.android.gms.ads.internal.zza zzaVar, zzwj zzwjVar, zzbtb zzbtbVar) {
        this.f3196a = zzbhfVar;
        this.b = context;
        this.c = zzcxvVar;
        this.d = zzdhVar;
        this.e = zzbaiVar;
        this.f = zzaVar;
        this.g = zzwjVar;
        this.h = zzbtbVar;
    }

    public final zzbgz zzc(zzyd zzydVar) throws zzbhj {
        return zzbhf.zza(this.b, zzbin.zzb(zzydVar), zzydVar.zzaap, false, false, this.d, this.e, null, new sc(this), this.f, this.g);
    }
}
