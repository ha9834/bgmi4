package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzckm implements zzcka<zzbnf, zzaov, zzcla> {

    /* renamed from: a */
    private final Context f3296a;
    private final zzboc b;
    private View c;

    public zzckm(Context context, zzboc zzbocVar) {
        this.f3296a = context;
        this.b = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.zzdgc.zza(zzcxmVar.zzemu, zzcxmVar.zzgkh.toString(), zzcxuVar.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.f3296a), new ux(this, zzcjyVar), zzcjyVar.zzfzn, zzcxuVar.zzgkx.zzfjp.zzdll);
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbnf zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzboc zzbocVar = this.b;
        zzbpr zzbprVar = new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis);
        View view = this.c;
        zzaov zzaovVar = zzcjyVar.zzdgc;
        zzaovVar.getClass();
        zzbng zza = zzbocVar.zza(zzbprVar, new zzbnk(view, null, uv.a(zzaovVar), zzcxmVar.zzgkg.get(0)));
        zza.zzadz().zzq(this.c);
        zzcjyVar.zzfzn.zza(zza.zzadi());
        return zza.zzadx();
    }
}
