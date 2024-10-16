package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbyh implements zzdti<zzccj> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbyc f3121a;

    public zzbyh(zzbyc zzbycVar) {
        this.f3121a = zzbycVar;
    }

    public static zzccj zza(zzbyc zzbycVar) {
        return (zzccj) zzdto.zza(zzbycVar.zzahp(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f3121a);
    }
}
