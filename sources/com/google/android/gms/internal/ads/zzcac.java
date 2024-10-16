package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcac implements zzbrw {

    /* renamed from: a, reason: collision with root package name */
    private final zzbyt f3146a;
    private final zzbyx b;

    public zzcac(zzbyt zzbytVar, zzbyx zzbyxVar) {
        this.f3146a = zzbytVar;
        this.b = zzbyxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final void onAdImpression() {
        if (this.f3146a.zzaib() == null) {
            return;
        }
        zzbgz zzaia = this.f3146a.zzaia();
        zzbgz zzahz = this.f3146a.zzahz();
        if (zzaia == null) {
            zzaia = zzahz != null ? zzahz : null;
        }
        if (!this.b.zzaih() || zzaia == null) {
            return;
        }
        zzaia.zza("onSdkImpression", new androidx.b.a());
    }
}
