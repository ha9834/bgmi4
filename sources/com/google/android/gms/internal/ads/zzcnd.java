package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzcnd implements zzcka<zzcdb, zzaov, zzcla> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3334a;
    private final zzcdf b;

    public zzcnd(Context context, zzcdf zzcdfVar) {
        this.f3334a = context;
        this.b = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.zzdgc.zza(zzcxmVar.zzemu, zzcxmVar.zzgkh.toString(), zzcxuVar.zzgkx.zzfjp.zzghg, ObjectWrapper.wrap(this.f3334a), new wc(this, zzcjyVar), zzcjyVar.zzfzn);
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzcdb zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        final zzcjx zzcjxVar = new zzcjx(zzcxmVar);
        zzcdc zza = this.b.zza(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis), new zzcdd(new zzbwz(zzcjyVar, zzcjxVar) { // from class: com.google.android.gms.internal.ads.wa

            /* renamed from: a, reason: collision with root package name */
            private final zzcjy f2578a;
            private final zzcjx b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2578a = zzcjyVar;
                this.b = zzcjxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void zza(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.f2578a;
                zzcjx zzcjxVar2 = this.b;
                try {
                    if (((zzaov) zzcjyVar2.zzdgc).zzz(ObjectWrapper.wrap(context))) {
                        zzcjxVar2.zzakq();
                    } else {
                        zzawz.zzep("Can't show rewarded video.");
                    }
                } catch (RemoteException e) {
                    zzawz.zzd("Can't show rewarded video.", e);
                }
            }
        }));
        zzcjxVar.zza(zza.zzadg());
        zzcjyVar.zzfzn.zza(zza.zzael());
        return zza.zzaej();
    }
}
