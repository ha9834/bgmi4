package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcaq {

    /* renamed from: a, reason: collision with root package name */
    private final zzbbl f3159a;
    private final zzcau b;
    private final zzcbd c;

    public zzcaq(zzbbl zzbblVar, zzcau zzcauVar, zzcbd zzcbdVar) {
        this.f3159a = zzbblVar;
        this.b = zzcauVar;
        this.c = zzcbdVar;
    }

    public final zzbbh<zzbyt> zza(final zzcxu zzcxuVar, final zzcxm zzcxmVar, final JSONObject jSONObject) {
        final zzbbh zza;
        final zzbbh submit = this.f3159a.submit(new Callable(this, zzcxuVar, zzcxmVar, jSONObject) { // from class: com.google.android.gms.internal.ads.qu

            /* renamed from: a, reason: collision with root package name */
            private final zzcaq f2449a;
            private final zzcxu b;
            private final zzcxm c;
            private final JSONObject d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2449a = this;
                this.b = zzcxuVar;
                this.c = zzcxmVar;
                this.d = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcxu zzcxuVar2 = this.b;
                zzcxm zzcxmVar2 = this.c;
                JSONObject jSONObject2 = this.d;
                zzbyt zzbytVar = new zzbyt();
                zzbytVar.zzdn(jSONObject2.optInt("template_id", -1));
                zzbytVar.zzfl(jSONObject2.optString("custom_template_id"));
                zzcxv zzcxvVar = zzcxuVar2.zzgkx.zzfjp;
                if (!zzcxvVar.zzglc.contains(Integer.toString(zzbytVar.zzahv()))) {
                    int zzahv = zzbytVar.zzahv();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Invalid template ID: ");
                    sb.append(zzahv);
                    throw new zzcmw(sb.toString(), 0);
                }
                if (zzbytVar.zzahv() == 3) {
                    if (zzbytVar.getCustomTemplateId() == null) {
                        throw new zzcmw("No custom template id for custom template ad response.", 0);
                    }
                    if (!zzcxvVar.zzgld.contains(zzbytVar.getCustomTemplateId())) {
                        throw new zzcmw("Unexpected custom template id in the response.", 0);
                    }
                }
                zzbytVar.setStarRating(jSONObject2.optDouble("rating", -1.0d));
                String optString = jSONObject2.optString("headline", null);
                if (zzcxmVar2.zzdpc) {
                    zzk.zzlg();
                    String zzwe = zzaxi.zzwe();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(zzwe).length() + 3 + String.valueOf(optString).length());
                    sb2.append(zzwe);
                    sb2.append(" : ");
                    sb2.append(optString);
                    optString = sb2.toString();
                }
                zzbytVar.zzp("headline", optString);
                zzbytVar.zzp("body", jSONObject2.optString("body", null));
                zzbytVar.zzp("call_to_action", jSONObject2.optString("call_to_action", null));
                zzbytVar.zzp("store", jSONObject2.optString("store", null));
                zzbytVar.zzp(FirebaseAnalytics.Param.PRICE, jSONObject2.optString(FirebaseAnalytics.Param.PRICE, null));
                zzbytVar.zzp("advertiser", jSONObject2.optString("advertiser", null));
                return zzbytVar;
            }
        });
        final zzbbh<List<zzadw>> zzd = this.b.zzd(jSONObject, "images");
        final zzbbh<zzadw> zzc = this.b.zzc(jSONObject, "secondary_image");
        final zzbbh<zzadw> zzc2 = this.b.zzc(jSONObject, "app_icon");
        final zzbbh<zzadt> zze = this.b.zze(jSONObject, "attribution");
        final zzbbh<zzbgz> zzl = this.b.zzl(jSONObject);
        final zzcau zzcauVar = this.b;
        if (!jSONObject.optBoolean("enable_omid")) {
            zza = zzbar.zzm(null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zza = zzbar.zzm(null);
            } else {
                final String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zza = zzbar.zzm(null);
                } else {
                    zza = zzbar.zza(zzbar.zzm(null), new zzbal(zzcauVar, optString) { // from class: com.google.android.gms.internal.ads.qz

                        /* renamed from: a, reason: collision with root package name */
                        private final zzcau f2454a;
                        private final String b;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2454a = zzcauVar;
                            this.b = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbal
                        public final zzbbh zzf(Object obj) {
                            return this.f2454a.a(this.b, obj);
                        }
                    }, zzbbm.zzeae);
                }
            }
        }
        final zzbbh<List<zzcbg>> zzg = this.c.zzg(jSONObject, "custom_assets");
        return zzbar.zza(submit, zzd, zzc, zzc2, zze, zzl, zza, zzg).zza(new Callable(this, submit, zzd, zzc2, zzc, zze, jSONObject, zzl, zza, zzg) { // from class: com.google.android.gms.internal.ads.qv

            /* renamed from: a, reason: collision with root package name */
            private final zzcaq f2450a;
            private final zzbbh b;
            private final zzbbh c;
            private final zzbbh d;
            private final zzbbh e;
            private final zzbbh f;
            private final JSONObject g;
            private final zzbbh h;
            private final zzbbh i;
            private final zzbbh j;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2450a = this;
                this.b = submit;
                this.c = zzd;
                this.d = zzc2;
                this.e = zzc;
                this.f = zze;
                this.g = jSONObject;
                this.h = zzl;
                this.i = zza;
                this.j = zzg;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcaq zzcaqVar = this.f2450a;
                zzbbh zzbbhVar = this.b;
                zzbbh zzbbhVar2 = this.c;
                zzbbh zzbbhVar3 = this.d;
                zzbbh zzbbhVar4 = this.e;
                zzbbh zzbbhVar5 = this.f;
                JSONObject jSONObject2 = this.g;
                zzbbh zzbbhVar6 = this.h;
                zzbbh zzbbhVar7 = this.i;
                zzbbh zzbbhVar8 = this.j;
                zzbyt zzbytVar = (zzbyt) zzbbhVar.get();
                zzbytVar.setImages((List) zzbbhVar2.get());
                zzbytVar.zza((zzaei) zzbbhVar3.get());
                zzbytVar.zzb((zzaei) zzbbhVar4.get());
                zzbytVar.zza((zzaea) zzbbhVar5.get());
                zzbytVar.zze(zzcau.zzi(jSONObject2));
                zzbytVar.zza(zzcau.zzj(jSONObject2));
                zzbgz zzbgzVar = (zzbgz) zzbbhVar6.get();
                if (zzbgzVar != null) {
                    zzbytVar.zzh(zzbgzVar);
                    zzbytVar.zzz(zzbgzVar.getView());
                    zzbytVar.zzb(zzbgzVar.zzyb());
                }
                zzbgz zzbgzVar2 = (zzbgz) zzbbhVar7.get();
                if (zzbgzVar2 != null) {
                    zzbytVar.zzi(zzbgzVar2);
                }
                for (zzcbg zzcbgVar : (List) zzbbhVar8.get()) {
                    switch (zzcbgVar.type) {
                        case 1:
                            zzbytVar.zzp(zzcbgVar.zzcc, zzcbgVar.zzfrt);
                            break;
                        case 2:
                            zzbytVar.zza(zzcbgVar.zzcc, zzcbgVar.zzfru);
                            break;
                    }
                }
                return zzbytVar;
            }
        }, this.f3159a);
    }
}
