package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.IR;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzchq {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3264a;
    private final zzbai b;
    private final zzcxv c;
    private final Executor d;

    public zzchq(Context context, zzbai zzbaiVar, zzcxv zzcxvVar, Executor executor) {
        this.f3264a = context;
        this.b = zzbaiVar;
        this.c = zzcxvVar;
        this.d = executor;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzbbh<zzcxu> a() {
        final zzalj zza = zzk.zzlt().zzb(this.f3264a, this.b).zza("google.afma.response.normalize", zzalo.zzddi, zzalo.zzddi);
        final zzxt zzxtVar = this.c.zzghg.zzchb;
        return zzbar.zza(zzbar.zza(zzbar.zza(zzbar.zzm(""), new zzbal(this, zzxtVar) { // from class: com.google.android.gms.internal.ads.tn

            /* renamed from: a, reason: collision with root package name */
            private final zzchq f2521a;
            private final zzxt b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2521a = this;
                this.b = zzxtVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                zzxt zzxtVar2 = this.b;
                String str = zzxtVar2.zzcgj;
                String str2 = zzxtVar2.zzcgk;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("headers", new JSONObject());
                jSONObject3.put("body", str);
                jSONObject2.put(IR.MODULE_URL, "");
                jSONObject2.put("signals", new JSONObject(str2));
                jSONObject.put("request", jSONObject2);
                jSONObject.put(AnalyticsEventKey.RESPONSE, jSONObject3);
                jSONObject.put("flags", new JSONObject());
                return zzbar.zzm(jSONObject);
            }
        }, this.d), new zzbal(zza) { // from class: com.google.android.gms.internal.ads.to

            /* renamed from: a, reason: collision with root package name */
            private final zzalj f2522a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2522a = zza;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2522a.zzi((JSONObject) obj);
            }
        }, this.d), new zzbal(this) { // from class: com.google.android.gms.internal.ads.tp

            /* renamed from: a, reason: collision with root package name */
            private final zzchq f2523a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2523a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.f2523a.a((JSONObject) obj);
            }
        }, this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(JSONObject jSONObject) throws Exception {
        return zzbar.zzm(new zzcxu(new zzcxr(this.c), zzcxs.zza(new StringReader(jSONObject.toString()))));
    }
}
