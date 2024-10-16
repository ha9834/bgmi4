package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class zzcep implements zzbro, zzbrw, zzbsr, zzbtk, zzxr {

    /* renamed from: a, reason: collision with root package name */
    private final zzwj f3212a;

    @GuardedBy("this")
    private boolean b = false;

    @GuardedBy("this")
    private boolean c = false;

    public zzcep(zzwj zzwjVar) {
        this.f3212a = zzwjVar;
        zzwjVar.zza(zzwl.zza.zzb.AD_REQUEST);
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zzb(zzarx zzarxVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbtk
    public final void zza(final zzcxu zzcxuVar) {
        this.f3212a.zza(new zzwk(zzcxuVar) { // from class: com.google.android.gms.internal.ads.sp

            /* renamed from: a, reason: collision with root package name */
            private final zzcxu f2496a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2496a = zzcxuVar;
            }

            @Override // com.google.android.gms.internal.ads.zzwk
            public final void zza(zzxn zzxnVar) {
                zzcxu zzcxuVar2 = this.f2496a;
                zzxnVar.zzcfl.zzceh.zzcep = zzcxuVar2.zzgky.zzgku.zzcep;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        this.f3212a.zza(zzwl.zza.zzb.AD_LOADED);
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i) {
        switch (i) {
            case 1:
                this.f3212a.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_INVALID_REQUEST);
                return;
            case 2:
                this.f3212a.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NETWORK_ERROR);
                return;
            case 3:
                this.f3212a.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NO_FILL);
                return;
            case 4:
                this.f3212a.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_TIMEOUT);
                return;
            case 5:
                this.f3212a.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_CANCELLED);
                return;
            case 6:
                this.f3212a.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NO_ERROR);
                return;
            case 7:
                this.f3212a.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD_NOT_FOUND);
                return;
            default:
                this.f3212a.zza(zzwl.zza.zzb.AD_FAILED_TO_LOAD);
                return;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbrw
    public final synchronized void onAdImpression() {
        this.f3212a.zza(zzwl.zza.zzb.AD_IMPRESSION);
    }

    @Override // com.google.android.gms.internal.ads.zzxr
    public final synchronized void onAdClicked() {
        if (!this.c) {
            this.f3212a.zza(zzwl.zza.zzb.AD_FIRST_CLICK);
            this.c = true;
        } else {
            this.f3212a.zza(zzwl.zza.zzb.AD_SUBSEQUENT_CLICK);
        }
    }
}
