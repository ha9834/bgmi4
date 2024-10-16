package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzcme implements zzcka<zzbyn, zzams, zzcla> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3317a;
    private final zzbxo b;

    public zzcme(Context context, zzbxo zzbxoVar) {
        this.f3317a = context;
        this.b = zzbxoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.zzdgc.zza(ObjectWrapper.wrap(this.f3317a), zzcxuVar.zzgkx.zzfjp.zzghg, zzcxmVar.zzgkh.toString(), zzazc.zza(zzcxmVar.zzgke), zzcjyVar.zzfzn, zzcxuVar.zzgkx.zzfjp.zzdgs, zzcxuVar.zzgkx.zzfjp.zzglc);
    }

    private static boolean a(zzcxu zzcxuVar, int i) {
        return zzcxuVar.zzgkx.zzfjp.zzglc.contains(Integer.toString(i));
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbyn zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzbyt zza;
        zzana zzsf = zzcjyVar.zzdgc.zzsf();
        zzand zzsg = zzcjyVar.zzdgc.zzsg();
        zzang zzsl = zzcjyVar.zzdgc.zzsl();
        if (zzsl != null && a(zzcxuVar, 6)) {
            zza = zzbyt.zzb(zzsl);
        } else if (zzsf != null && a(zzcxuVar, 6)) {
            zza = zzbyt.zzb(zzsf);
        } else if (zzsf != null && a(zzcxuVar, 2)) {
            zza = zzbyt.zza(zzsf);
        } else if (zzsg != null && a(zzcxuVar, 6)) {
            zza = zzbyt.zzb(zzsg);
        } else if (zzsg != null && a(zzcxuVar, 1)) {
            zza = zzbyt.zza(zzsg);
        } else {
            throw new zzcmw("No native ad mappers", 0);
        }
        if (!zzcxuVar.zzgkx.zzfjp.zzglc.contains(Integer.toString(zza.zzahv()))) {
            throw new zzcmw("No corresponding native ad listener", 0);
        }
        zzbyw zza2 = this.b.zza(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis), new zzbzf(zza), new zzcag(zzsg, zzsf, zzsl));
        zzcjyVar.zzfzn.zza(zza2.zzadi());
        return zza2.zzadj();
    }
}
