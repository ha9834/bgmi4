package com.google.android.gms.internal.ads;

import com.helpshift.analytics.AnalyticsEventKey;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzclx implements zzclw<zzbyn> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbxo f3315a;
    private final zzbbl b;
    private final zzcaq c;

    public zzclx(zzbxo zzbxoVar, zzbbl zzbblVar, zzcaq zzcaqVar) {
        this.f3315a = zzbxoVar;
        this.b = zzbblVar;
        this.c = zzcaqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean zza(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return (zzcxmVar.zzgke == null || zzcxmVar.zzgke.zzfmo == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<List<zzbbh<zzbyn>>> zzb(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        zzbbh<zzccj> zzamr = this.f3315a.zzadc().zzamr();
        this.f3315a.zzadc().zza(zzamr);
        return zzbar.zza(zzbar.zza(zzamr, new zzbal(this, zzcxmVar) { // from class: com.google.android.gms.internal.ads.vo

            /* renamed from: a, reason: collision with root package name */
            private final zzclx f2569a;
            private final zzcxm b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2569a = this;
                this.b = zzcxmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2569a.a(this.b, (zzccj) obj);
            }
        }, this.b), new zzbal(this, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.vp

            /* renamed from: a, reason: collision with root package name */
            private final zzclx f2570a;
            private final zzcxu b;
            private final zzcxm c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2570a = this;
                this.b = zzcxuVar;
                this.c = zzcxmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2570a.a(this.b, this.c, (JSONArray) obj);
            }
        }, this.b);
    }

    private final zzbbh<zzbyn> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar, final JSONObject jSONObject) {
        final zzbbh<zzccj> zzamr = this.f3315a.zzadc().zzamr();
        final zzbbh<zzbyt> zza = this.c.zza(zzcxuVar, zzcxmVar, jSONObject);
        return zzbar.zza(zzamr, zza).zza(new Callable(this, zza, zzamr, zzcxuVar, zzcxmVar, jSONObject) { // from class: com.google.android.gms.internal.ads.vt

            /* renamed from: a, reason: collision with root package name */
            private final zzclx f2573a;
            private final zzbbh b;
            private final zzbbh c;
            private final zzcxu d;
            private final zzcxm e;
            private final JSONObject f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2573a = this;
                this.b = zza;
                this.c = zzamr;
                this.d = zzcxuVar;
                this.e = zzcxmVar;
                this.f = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f2573a.a(this.b, this.c, this.d, this.e, this.f);
            }
        }, this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzbyn a(zzbbh zzbbhVar, zzbbh zzbbhVar2, zzcxu zzcxuVar, zzcxm zzcxmVar, JSONObject jSONObject) throws Exception {
        zzbyt zzbytVar = (zzbyt) zzbbhVar.get();
        zzccj zzccjVar = (zzccj) zzbbhVar2.get();
        zzbyv zza = this.f3315a.zza(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbzf(zzbytVar), new zzbyc(jSONObject, zzccjVar));
        zza.zzadk().zzaji();
        zza.zzadl().zzb(zzccjVar);
        zza.zzadm().zzk(zzbytVar.zzahz());
        return zza.zzadj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(zzcxu zzcxuVar, zzcxm zzcxmVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzbar.zzd(new zzcgm(3));
        }
        if (zzcxuVar.zzgkx.zzfjp.zzglg > 1) {
            int length = jSONArray.length();
            this.f3315a.zzadc().zzdq(Math.min(length, zzcxuVar.zzgkx.zzfjp.zzglg));
            ArrayList arrayList = new ArrayList(zzcxuVar.zzgkx.zzfjp.zzglg);
            for (int i = 0; i < zzcxuVar.zzgkx.zzfjp.zzglg; i++) {
                if (i < length) {
                    arrayList.add(a(zzcxuVar, zzcxmVar, jSONArray.getJSONObject(i)));
                } else {
                    arrayList.add(zzbar.zzd(new zzcgm(3)));
                }
            }
            return zzbar.zzm(arrayList);
        }
        return zzbar.zza(a(zzcxuVar, zzcxmVar, jSONArray.getJSONObject(0)), vs.f2572a, this.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(zzcxm zzcxmVar, zzccj zzccjVar) throws Exception {
        JSONObject zza = zzazc.zza("isNonagon", (Object) true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AnalyticsEventKey.RESPONSE, zzcxmVar.zzgke.zzfmo);
        jSONObject.put("sdk_params", zza);
        return zzbar.zza(zzccjVar.zzc("google.afma.nativeAds.preProcessJson", jSONObject), vr.f2571a, this.b);
    }
}
