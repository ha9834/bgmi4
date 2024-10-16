package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
public final class zzkg implements zzkd {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcm<Boolean> f4602a = new zzct(zzcn.zzdh("com.google.android.gms.measurement")).zzb("measurement.collection.event_safelist", false);

    @Override // com.google.android.gms.internal.measurement.zzkd
    public final boolean zzzd() {
        return f4602a.get().booleanValue();
    }
}
