package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class aa implements zzbp<zzcc> {

    /* renamed from: a, reason: collision with root package name */
    private final zzap f4291a;
    private final zzcc b = new zzcc();

    public aa(zzap zzapVar) {
        this.f4291a = zzapVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, String str2) {
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzc(String str, String str2) {
        if ("ga_appName".equals(str)) {
            this.b.zzaau = str2;
            return;
        }
        if ("ga_appVersion".equals(str)) {
            this.b.zzaav = str2;
        } else if ("ga_logLevel".equals(str)) {
            this.b.zzaaw = str2;
        } else {
            this.f4291a.zzco().zzd("String xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zza(String str, boolean z) {
        if ("ga_dryRun".equals(str)) {
            this.b.zzaay = z ? 1 : 0;
        } else {
            this.f4291a.zzco().zzd("Bool xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, int i) {
        if ("ga_dispatchPeriod".equals(str)) {
            this.b.zzaax = i;
        } else {
            this.f4291a.zzco().zzd("Int xml configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final /* synthetic */ zzcc zzel() {
        return this.b;
    }
}
