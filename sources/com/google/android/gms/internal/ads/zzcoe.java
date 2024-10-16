package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbsm;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class zzcoe<AdT, AdapterT, ListenerT extends zzbsm> implements zzcjv<AdT> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcjz<AdapterT, ListenerT> f3345a;
    private final zzcka<AdT, AdapterT, ListenerT> b;
    private final zzczt c;
    private final zzbbl d;

    public zzcoe(zzczt zzcztVar, zzbbl zzbblVar, zzcjz<AdapterT, ListenerT> zzcjzVar, zzcka<AdT, AdapterT, ListenerT> zzckaVar) {
        this.c = zzcztVar;
        this.d = zzbblVar;
        this.b = zzckaVar;
        this.f3345a = zzcjzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return !zzcxmVar.zzgkf.isEmpty();
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<AdT> zzb(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        final zzcjy<AdapterT, ListenerT> zzcjyVar;
        Iterator<String> it = zzcxmVar.zzgkf.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcjyVar = null;
                break;
            }
            try {
                zzcjyVar = this.f3345a.zzd(it.next(), zzcxmVar.zzgkh);
                break;
            } catch (Throwable unused) {
            }
        }
        if (zzcjyVar == null) {
            return zzbar.zzd(new zzcmk("unable to instantiate mediation adapter class"));
        }
        zzbbr zzbbrVar = new zzbbr();
        zzcjyVar.zzfzn.zza(new wt(this, zzbbrVar, zzcjyVar));
        if (zzcxmVar.zzdpc) {
            Bundle bundle = zzcxuVar.zzgkx.zzfjp.zzghg.zzcgv;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.c.zzv(zzczs.ADAPTER_LOAD_AD_SYN).zza(new zzczd(this, zzcxuVar, zzcxmVar, zzcjyVar) { // from class: com.google.android.gms.internal.ads.wr

            /* renamed from: a, reason: collision with root package name */
            private final zzcoe f2594a;
            private final zzcxu b;
            private final zzcxm c;
            private final zzcjy d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2594a = this;
                this.b = zzcxuVar;
                this.c = zzcxmVar;
                this.d = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzczd
            public final void run() {
                this.f2594a.a(this.b, this.c, this.d);
            }
        }, this.d).zzx(zzczs.ADAPTER_LOAD_AD_ACK).zzb(zzbbrVar).zzx(zzczs.ADAPTER_WRAP_ADAPTER).zzb(new zzczc(this, zzcxuVar, zzcxmVar, zzcjyVar) { // from class: com.google.android.gms.internal.ads.ws

            /* renamed from: a, reason: collision with root package name */
            private final zzcoe f2595a;
            private final zzcxu b;
            private final zzcxm c;
            private final zzcjy d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2595a = this;
                this.b = zzcxuVar;
                this.c = zzcxmVar;
                this.d = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzczc
            public final Object apply(Object obj) {
                return this.f2595a.a(this.b, this.c, this.d, (Void) obj);
            }
        }).zzane();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar, Void r4) throws Exception {
        return this.b.zzb(zzcxuVar, zzcxmVar, zzcjyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar) throws Exception {
        this.b.zza(zzcxuVar, zzcxmVar, zzcjyVar);
    }
}
