package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcyq implements zzdti<zzcym> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcyo f3504a;
    private final zzdtu<zzcyk> b;
    private final zzdtu<String> c;

    private zzcyq(zzcyo zzcyoVar, zzdtu<zzcyk> zzdtuVar, zzdtu<String> zzdtuVar2) {
        this.f3504a = zzcyoVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzcyq zza(zzcyo zzcyoVar, zzdtu<zzcyk> zzdtuVar, zzdtu<String> zzdtuVar2) {
        return new zzcyq(zzcyoVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcym) zzdto.zza(this.b.get().zzfw(this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
