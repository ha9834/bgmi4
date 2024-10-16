package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcnw implements zzcka<zzcdb, zzams, zzclb> {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3341a;
    private final Executor b;
    private final zzcdf c;

    public zzcnw(Context context, Executor executor, zzcdf zzcdfVar) {
        this.f3341a = context;
        this.b = executor;
        this.c = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void zza(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzclb> zzcjyVar) throws RemoteException {
        if (!zzcjyVar.zzdgc.isInitialized()) {
            zzcjyVar.zzfzn.zza(new wn(this, zzcxuVar, zzcxmVar, zzcjyVar));
            zzcjyVar.zzdgc.zza(ObjectWrapper.wrap(this.f3341a), zzcxuVar.zzgkx.zzfjp.zzghg, (String) null, zzcjyVar.zzfzn, zzcxmVar.zzgkh.toString());
            return;
        }
        a(zzcxuVar, zzcxmVar, zzcjyVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzclb> zzcjyVar) {
        try {
            zzcjyVar.zzdgc.zza(zzcxuVar.zzgkx.zzfjp.zzghg, zzcxmVar.zzgkh.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcjyVar.zzfis);
            zzawz.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzcdb zzb(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy<zzams, zzclb> zzcjyVar) throws RemoteException, zzcmw {
        zzcdc zza = this.c.zza(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.zzfis), new zzcdd(new zzbwz(zzcjyVar) { // from class: com.google.android.gms.internal.ads.wm

            /* renamed from: a, reason: collision with root package name */
            private final zzcjy f2589a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2589a = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void zza(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.f2589a;
                try {
                    ((zzams) zzcjyVar2.zzdgc).setImmersiveMode(z);
                    ((zzams) zzcjyVar2.zzdgc).showVideo();
                } catch (RemoteException e) {
                    zzawz.zzd("Cannot show rewarded video.", e);
                }
            }
        }));
        zza.zzadd().zza((zzbry) new zzccy(zzcjyVar.zzdgc), this.b);
        zzbse zzade = zza.zzade();
        zzbri zzadf = zza.zzadf();
        zzcjyVar.zzfzn.zza(new wq(this, zza.zzaef(), zzadf, zzade, zza.zzaek()));
        return zza.zzaej();
    }
}
