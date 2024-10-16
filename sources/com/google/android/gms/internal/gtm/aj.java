package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class aj extends zzam implements zzbp<zzcy> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcy f4299a;

    public aj(zzap zzapVar) {
        super(zzapVar);
        this.f4299a = new zzcy();
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, String str2) {
        this.f4299a.zzacs.put(str, str2);
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzc(String str, String str2) {
        if ("ga_trackingId".equals(str)) {
            this.f4299a.zzacm = str2;
            return;
        }
        if ("ga_sampleFrequency".equals(str)) {
            try {
                this.f4299a.zzacn = Double.parseDouble(str2);
                return;
            } catch (NumberFormatException e) {
                zzc("Error parsing ga_sampleFrequency value", str2, e);
                return;
            }
        }
        zzd("string configuration name not recognized", str);
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zza(String str, boolean z) {
        if ("ga_autoActivityTracking".equals(str)) {
            this.f4299a.zzacp = z ? 1 : 0;
        } else if ("ga_anonymizeIp".equals(str)) {
            this.f4299a.zzacq = z ? 1 : 0;
        } else if ("ga_reportUncaughtExceptions".equals(str)) {
            this.f4299a.zzacr = z ? 1 : 0;
        } else {
            zzd("bool configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final void zzb(String str, int i) {
        if ("ga_sessionTimeout".equals(str)) {
            this.f4299a.zzaco = i;
        } else {
            zzd("int configuration name not recognized", str);
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzbp
    public final /* synthetic */ zzcy zzel() {
        return this.f4299a;
    }
}
