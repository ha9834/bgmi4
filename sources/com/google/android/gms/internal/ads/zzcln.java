package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzcln implements zzcka<zzbvx, zzams, zzcla> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3310a;
    private final zzbws b;
    private final zzbai c;

    public zzcln(Context context, zzbai zzbaiVar, zzbws zzbwsVar) {
        this.f3310a = context;
        this.c = zzbaiVar;
        this.b = zzbwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        if (this.c.zzdzd < 4100000) {
            zzcjyVar.zzdgc.zza(ObjectWrapper.wrap(this.f3310a), zzcxuVar.zzgkx.zzfjp.zzghg, zzcxmVar.zzgkh.toString(), zzcjyVar.zzfzn);
        } else {
            zzcjyVar.zzdgc.zza(ObjectWrapper.wrap(this.f3310a), zzcxuVar.zzgkx.zzfjp.zzghg, zzcxmVar.zzgkh.toString(), zzazc.zza(zzcxmVar.zzgke), zzcjyVar.zzfzn);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbvx zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzbvy zza = this.b.zza(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis), new zzbvz(new zzbwz(zzcjyVar) { // from class: com.google.android.gms.internal.ads.vk

            /* renamed from: a, reason: collision with root package name */
            private final zzcjy f2566a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2566a = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void zza(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.f2566a;
                try {
                    ((zzams) zzcjyVar2.zzdgc).setImmersiveMode(z);
                    ((zzams) zzcjyVar2.zzdgc).showInterstitial();
                } catch (RemoteException unused) {
                    zzawz.zzeo("Cannot show interstitial.");
                }
            }
        }));
        zzcjyVar.zzfzn.zza(zza.zzadi());
        return zza.zzaee();
    }
}
