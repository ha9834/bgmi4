package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcyt implements zzdti<zzawu> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcyo f3507a;
    private final zzdtu<zzcym> b;

    private zzcyt(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        this.f3507a = zzcyoVar;
        this.b = zzdtuVar;
    }

    public static zzcyt zzd(zzcyo zzcyoVar, zzdtu<zzcym> zzdtuVar) {
        return new zzcyt(zzcyoVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzawu) zzdto.zza(this.b.get().zzdsw, "Cannot return null from a non-@Nullable @Provides method");
    }
}
