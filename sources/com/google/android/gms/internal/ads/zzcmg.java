package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzcmg implements zzcka<zzbyn, zzaov, zzcla> {

    /* renamed from: a */
    private final Context f3319a;
    private final zzbxo b;
    private zzang c;

    public zzcmg(Context context, zzbxo zzbxoVar) {
        this.f3319a = context;
        this.b = zzbxoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.zzdgc.zza(zzcxmVar.zzemu, zzcxmVar.zzgkh.toString(), zzcxuVar.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.f3319a), new vv(this, zzcjyVar), zzcjyVar.zzfzn);
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbyn zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        if (!zzcxuVar.zzgkx.zzfjp.zzglc.contains(Integer.toString(6))) {
            throw new zzcmw("Unified must be used for RTB.", 1);
        }
        zzbyt zzb = zzbyt.zzb(this.c);
        if (!zzcxuVar.zzgkx.zzfjp.zzglc.contains(Integer.toString(zzb.zzahv()))) {
            throw new zzcmw("No corresponding native ad listener", 0);
        }
        zzbyw zza = this.b.zza(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis), new zzbzf(zzb), new zzcag(null, null, this.c));
        zzcjyVar.zzfzn.zza(zza.zzadi());
        return zza.zzadj();
    }
}
