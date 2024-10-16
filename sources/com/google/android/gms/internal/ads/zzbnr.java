package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbnr implements zzdti<zzbnf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2956a;
    private final zzdtu<nh> b;

    public zzbnr(zzbnk zzbnkVar, zzdtu<nh> zzdtuVar) {
        this.f2956a = zzbnkVar;
        this.b = zzdtuVar;
    }

    public static zzbnf zza(zzbnk zzbnkVar, Object obj) {
        return (zzbnf) zzdto.zza((nh) obj, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f2956a, this.b.get());
    }
}
