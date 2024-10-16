package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzckj implements zzcka<zzbnf, zzams, zzcla> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3294a;
    private final zzbai b;
    private final zzboc c;

    public zzckj(Context context, zzbai zzbaiVar, zzboc zzbocVar) {
        this.f3294a = context;
        this.b = zzbaiVar;
        this.c = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        zzyd zza = zzcxy.zza(this.f3294a, zzcxmVar.zzgkg);
        if (this.b.zzdzd < 4100000) {
            zzcjyVar.zzdgc.zza(ObjectWrapper.wrap(this.f3294a), zza, zzcxuVar.zzgkx.zzfjp.zzghg, zzcxmVar.zzgkh.toString(), zzcjyVar.zzfzn);
        } else {
            zzcjyVar.zzdgc.zza(ObjectWrapper.wrap(this.f3294a), zza, zzcxuVar.zzgkx.zzfjp.zzghg, zzcxmVar.zzgkh.toString(), zzazc.zza(zzcxmVar.zzgke), zzcjyVar.zzfzn);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbnf zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzboc zzbocVar = this.c;
        zzbpr zzbprVar = new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis);
        View view = (View) ObjectWrapper.unwrap(zzcjyVar.zzdgc.zzse());
        zzams zzamsVar = zzcjyVar.zzdgc;
        zzamsVar.getClass();
        zzbng zza = zzbocVar.zza(zzbprVar, new zzbnk(view, null, uu.a(zzamsVar), zzcxmVar.zzgkg.get(0)));
        zza.zzadz().zzq((View) ObjectWrapper.unwrap(zzcjyVar.zzdgc.zzse()));
        zzcjyVar.zzfzn.zza(zza.zzadi());
        return zza.zzadx();
    }
}
