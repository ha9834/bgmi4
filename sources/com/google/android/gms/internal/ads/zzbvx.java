package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzbvx extends zzbpc {
    private final Context f;
    private final zzbup g;
    private final zzbwz h;
    private final zzbpv i;
    private final zzdan j;
    private boolean k = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvx(Context context, zzbry zzbryVar, zzbup zzbupVar, zzbwz zzbwzVar, zzbpv zzbpvVar, zzdan zzdanVar) {
        this.f = context;
        this.c = zzbryVar;
        this.g = zzbupVar;
        this.h = zzbwzVar;
        this.i = zzbpvVar;
        this.j = zzdanVar;
    }

    public final void show(boolean z) {
        this.g.zzagu();
        this.h.zza(z, this.f);
        this.k = true;
    }

    public final zzbry zzadd() {
        return this.c;
    }

    public final boolean isClosed() {
        return this.i.isClosed();
    }

    public final boolean zzagz() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcoe)).booleanValue()) {
            zzk.zzlg();
            if (zzaxi.zzaq(this.f)) {
                zzawz.zzep("It is not recommended to show an interstitial when app is not in foreground.");
                if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcof)).booleanValue()) {
                    this.j.zzgb(this.f2989a.zzgky.zzgku.zzcep);
                }
                return false;
            }
        }
        return !this.k;
    }
}
