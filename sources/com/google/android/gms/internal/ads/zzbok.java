package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbok implements zzdti<Boolean> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcxv> f2973a;

    public zzbok(zzdtu<zzcxv> zzdtuVar) {
        this.f2973a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        boolean booleanValue;
        if (this.f2973a.get().zzamn() != null) {
            booleanValue = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcpm)).booleanValue();
        } else {
            booleanValue = ((Boolean) zzyt.zzpe().zzd(zzacu.zzcvq)).booleanValue();
        }
        return Boolean.valueOf(booleanValue);
    }
}
