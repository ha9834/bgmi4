package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbjx implements zzdti<zzbai> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbjn f2894a;

    public zzbjx(zzbjn zzbjnVar) {
        this.f2894a = zzbjnVar;
    }

    public static zzbai zzb(zzbjn zzbjnVar) {
        return (zzbai) zzdto.zza(zzbjnVar.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzb(this.f2894a);
    }
}
