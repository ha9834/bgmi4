package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbxn implements zzdti<zzbzc> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbxk f3107a;

    private zzbxn(zzbxk zzbxkVar) {
        this.f3107a = zzbxkVar;
    }

    public static zzbxn zzd(zzbxk zzbxkVar) {
        return new zzbxn(zzbxkVar);
    }

    public static zzbzc zze(zzbxk zzbxkVar) {
        return (zzbzc) zzdto.zza(zzbxkVar.zzahf(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zze(this.f3107a);
    }
}
