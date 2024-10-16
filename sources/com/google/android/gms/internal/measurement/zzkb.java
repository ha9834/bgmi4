package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkb implements zzkc {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4599a;
    private static final zzcm<Boolean> b;
    private static final zzcm<Boolean> c;
    private static final zzcm<Boolean> d;
    private static final zzcm<Long> e;

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zzza() {
        return f4599a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zzzb() {
        return b.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzkc
    public final boolean zzzc() {
        return c.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4599a = zzctVar.zzb("measurement.sdk.dynamite.allow_remote_dynamite", false);
        b = zzctVar.zzb("measurement.collection.init_params_control_enabled", true);
        c = zzctVar.zzb("measurement.sdk.dynamite.use_dynamite", false);
        d = zzctVar.zzb("measurement.sdk.dynamite.use_dynamite2", false);
        e = zzctVar.zze("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }
}
