package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzcmo extends zzcmn<zzbnf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjm f3323a;
    private final zzbqy.zza b;
    private final zzcow c;
    private final zzbtv d;
    private final zzbxk e;
    private final zzbtb f;
    private final ViewGroup g;

    public zzcmo(zzbjm zzbjmVar, zzbqy.zza zzaVar, zzcow zzcowVar, zzbtv zzbtvVar, zzbxk zzbxkVar, zzbtb zzbtbVar, ViewGroup viewGroup) {
        this.f3323a = zzbjmVar;
        this.b = zzaVar;
        this.c = zzcowVar;
        this.d = zzbtvVar;
        this.e = zzbxkVar;
        this.f = zzbtbVar;
        this.g = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzcmn
    protected final zzbbh<zzbnf> a(zzcxv zzcxvVar, Bundle bundle) {
        return this.f3323a.zzacj().zzb(this.b.zza(zzcxvVar).zze(bundle).zzagh()).zzb(this.d).zza(this.c).zzb(this.e).zza(new zzbox(this.f)).zza(new zzbnc(this.g)).zzads().zzadu();
    }
}
