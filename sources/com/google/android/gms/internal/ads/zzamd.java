package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzamd<I, O> implements zzbal<I, O> {

    /* renamed from: a, reason: collision with root package name */
    private final zzall<O> f2755a;
    private final zzalm<I> b;
    private final String c;
    private final zzbbh<zzalf> d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamd(zzbbh<zzalf> zzbbhVar, String str, zzalm<I> zzalmVar, zzall<O> zzallVar) {
        this.d = zzbbhVar;
        this.c = str;
        this.b = zzalmVar;
        this.f2755a = zzallVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh<O> zzf(final I i) throws Exception {
        return zzbar.zza(this.d, new zzbal(this, i) { // from class: com.google.android.gms.internal.ads.co

            /* renamed from: a, reason: collision with root package name */
            private final zzamd f2101a;
            private final Object b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2101a = this;
                this.b = i;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2101a.a(this.b, (zzalf) obj);
            }
        }, zzbbm.zzeaf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(Object obj, zzalf zzalfVar) throws Exception {
        zzbbr zzbbrVar = new zzbbr();
        zzk.zzlg();
        String zzwb = zzaxi.zzwb();
        zzagz.zzdae.zza(zzwb, new cp(this, zzbbrVar));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzwb);
        jSONObject.put("args", this.b.zzj(obj));
        zzalfVar.zzb(this.c, jSONObject);
        return zzbbrVar;
    }
}
