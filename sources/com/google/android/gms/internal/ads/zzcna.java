package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcna implements zzcka<zzcdb, zzams, zzcla> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3332a;
    private final Executor b;
    private final zzcdf c;

    public zzcna(Context context, Executor executor, zzcdf zzcdfVar) {
        this.f3332a = context;
        this.b = executor;
        this.c = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        try {
            zzcjyVar.zzdgc.zzb(ObjectWrapper.wrap(this.f3332a), zzcxuVar.zzgkx.zzfjp.zzghg, zzcxmVar.zzgkh.toString(), zzcjyVar.zzfzn);
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcjyVar.zzfis);
            zzawz.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzcdb zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzcdc zza = this.c.zza(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis), new zzcdd(new zzbwz(zzcjyVar) { // from class: com.google.android.gms.internal.ads.vz

            /* renamed from: a, reason: collision with root package name */
            private final zzcjy f2577a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2577a = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void zza(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.f2577a;
                try {
                    ((zzams) zzcjyVar2.zzdgc).setImmersiveMode(z);
                    ((zzams) zzcjyVar2.zzdgc).zzs(ObjectWrapper.wrap(context));
                } catch (RemoteException e) {
                    zzawz.zzd("Cannot show rewarded .", e);
                }
            }
        }));
        zza.zzadd().zza((zzbry) new zzccy(zzcjyVar.zzdgc), this.b);
        zzcjyVar.zzfzn.zza(zza.zzael());
        return zza.zzaej();
    }
}
