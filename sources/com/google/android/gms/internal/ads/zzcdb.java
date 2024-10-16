package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzcdb extends zzbpc {
    private final Context f;
    private final zzbwz g;
    private final zzbup h;
    private final zzbrp i;
    private final zzbpv j;
    private final zzatq k;
    private final zzdan l;
    private boolean m = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdb(Context context, zzbwz zzbwzVar, zzbup zzbupVar, zzbrp zzbrpVar, zzbry zzbryVar, zzbpv zzbpvVar, zzcxm zzcxmVar, zzdan zzdanVar) {
        this.f = context;
        this.g = zzbwzVar;
        this.h = zzbupVar;
        this.i = zzbrpVar;
        this.c = zzbryVar;
        this.j = zzbpvVar;
        this.l = zzdanVar;
        this.k = new zzaup(zzcxmVar.zzdnx);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    public final void zzb(boolean z, Activity activity) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoe)).booleanValue()) {
            zzk.zzlg();
            if (zzaxi.zzaq(this.f)) {
                zzawz.zzep("Rewarded ad can not be shown when app is not in foreground.");
                this.i.zzcs(3);
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcof)).booleanValue()) {
                    this.l.zzgb(this.f2989a.zzgky.zzgku.zzcep);
                    return;
                }
                return;
            }
        }
        if (this.m) {
            zzawz.zzep("The rewarded ad have been showed.");
            this.i.zzcs(1);
            return;
        }
        this.m = true;
        this.h.zzagu();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.f;
        }
        this.g.zza(z, activity2);
    }

    public final zzatq zzqh() {
        return this.k;
    }

    public final zzbry zzadd() {
        return this.c;
    }

    public final boolean isClosed() {
        return this.j.isClosed();
    }
}
