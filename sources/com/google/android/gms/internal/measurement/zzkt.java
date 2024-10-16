package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkt implements zzku {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4611a;
    private static final zzcm<Boolean> b;
    private static final zzcm<Boolean> c;

    @Override // com.google.android.gms.internal.measurement.zzku
    public final boolean zzzj() {
        return f4611a.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final boolean zzzk() {
        return b.get().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzku
    public final boolean zzzl() {
        return c.get().booleanValue();
    }

    static {
        zzct zzctVar = new zzct(zzcn.zzdh("com.google.android.gms.measurement"));
        f4611a = zzctVar.zzb("measurement.sdk.collection.last_deep_link_referrer", false);
        b = zzctVar.zzb("measurement.sdk.collection.last_deep_link_referrer_campaign", false);
        c = zzctVar.zzb("measurement.sdk.collection.last_gclid_from_referrer", false);
    }
}
