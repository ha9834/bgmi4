package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzblm implements zzdti<zzaql> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzblm f2913a = new zzblm();

    public static zzblm zzaey() {
        return f2913a;
    }

    public static zzaql zzaez() {
        return (zzaql) zzdto.zza(new zzaql(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzaez();
    }
}
