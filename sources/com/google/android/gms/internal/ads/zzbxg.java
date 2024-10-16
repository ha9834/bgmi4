package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import javax.annotation.ParametersAreNonnullByDefault;

/* loaded from: classes.dex */
public final class zzbxg implements zzbrl, zzbur {

    /* renamed from: a, reason: collision with root package name */
    private final zzavf f3101a;
    private final Context b;
    private final zzavg c;
    private final View d;
    private String e;
    private final int f;

    public zzbxg(zzavf zzavfVar, Context context, zzavg zzavgVar, View view, int i) {
        this.f3101a = zzavfVar;
        this.b = context;
        this.c = zzavgVar;
        this.d = view;
        this.f = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdOpened() {
        View view = this.d;
        if (view != null && this.e != null) {
            this.c.zzf(view.getContext(), this.e);
        }
        this.f3101a.zzag(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    public final void onAdClosed() {
        this.f3101a.zzag(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbur
    public final void zzagu() {
        this.e = this.c.zzz(this.b);
        String valueOf = String.valueOf(this.e);
        String valueOf2 = String.valueOf(this.f == 7 ? "/Rewarded" : "/Interstitial");
        this.e = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbrl
    @ParametersAreNonnullByDefault
    public final void zzb(zzasr zzasrVar, String str, String str2) {
        if (this.c.zzx(this.b)) {
            try {
                this.c.zza(this.b, this.c.zzac(this.b), this.f3101a.getAdUnitId(), zzasrVar.getType(), zzasrVar.getAmount());
            } catch (RemoteException e) {
                zzawz.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
