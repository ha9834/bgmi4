package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public abstract class zzchj implements zzbal<zzarx, zzcxu> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtg f3261a;

    public zzchj(zzbtg zzbtgVar) {
        this.f3261a = zzbtgVar;
    }

    protected abstract zzbbh<zzcxu> zze(zzarx zzarxVar) throws zzcgm;

    @Override // com.google.android.gms.internal.ads.zzbal
    public final /* synthetic */ zzbbh<zzcxu> zzf(zzarx zzarxVar) throws Exception {
        zzarx zzarxVar2 = zzarxVar;
        this.f3261a.zzb(zzarxVar2);
        zzbbh<zzcxu> zze = zze(zzarxVar2);
        zzbar.zza(zze, new tj(this), zzbbm.zzeaf);
        return zze;
    }
}
