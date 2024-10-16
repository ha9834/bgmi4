package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzclq implements zzcka<zzbvx, zzaov, zzcla> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3312a;
    private final zzbws b;

    public zzclq(Context context, zzbws zzbwsVar) {
        this.f3312a = context;
        this.b = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.zzdgc.zza(zzcxmVar.zzemu, zzcxmVar.zzgkh.toString(), zzcxuVar.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.f3312a), new vn(this, zzcjyVar), zzcjyVar.zzfzn);
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbvx zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        final zzcjx zzcjxVar = new zzcjx(zzcxmVar);
        zzbvy zza = this.b.zza(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis), new zzbvz(new zzbwz(zzcjyVar, zzcjxVar) { // from class: com.google.android.gms.internal.ads.vl

            /* renamed from: a, reason: collision with root package name */
            private final zzcjy f2567a;
            private final zzcjx b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2567a = zzcjyVar;
                this.b = zzcjxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void zza(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.f2567a;
                zzcjx zzcjxVar2 = this.b;
                try {
                    if (((zzaov) zzcjyVar2.zzdgc).zzy(ObjectWrapper.wrap(context))) {
                        zzcjxVar2.zzakq();
                    } else {
                        zzawz.zzep("Cannot show interstitial.");
                    }
                } catch (RemoteException e) {
                    zzawz.zzd("Cannot show interstitial.", e);
                }
            }
        }));
        zzcjxVar.zza(zza.zzadg());
        zzcjyVar.zzfzn.zza(zza.zzadi());
        return zza.zzaee();
    }
}
