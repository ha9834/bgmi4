package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcpf {

    /* renamed from: a, reason: collision with root package name */
    private final zzclc f3359a;
    private final Map<String, zzcpk> b = new ConcurrentHashMap();
    private final Map<String, List<zzcpk>> c = new ConcurrentHashMap();
    private final Executor d;
    private final Context e;

    public zzcpf(zzclc zzclcVar, Executor executor, Context context) {
        this.f3359a = zzclcVar;
        this.d = executor;
        this.e = context;
    }

    public final void zzakw() {
        zzk.zzlk().zzvc().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.xd

            /* renamed from: a, reason: collision with root package name */
            private final zzcpf f2605a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2605a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2605a.b();
            }
        });
        this.d.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.xe

            /* renamed from: a, reason: collision with root package name */
            private final zzcpf f2606a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2606a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2606a.a();
            }
        });
    }

    public final Map<String, List<zzcpk>> zzakx() {
        return this.c;
    }

    public final void zzfr(String str) {
        if (TextUtils.isEmpty(str) || this.b.containsKey(str)) {
            return;
        }
        try {
            this.b.put(str, new zzcpk(str, "", new Bundle(), this.f3359a.zzcy(str)));
        } catch (RemoteException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void c() {
        JSONArray optJSONArray;
        JSONObject zzuv = zzk.zzlk().zzvc().zzvr().zzuv();
        if (zzuv != null) {
            try {
                JSONArray optJSONArray2 = zzuv.optJSONArray("ad_unit_id_settings");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            bundle.putString(next, optJSONObject2.optString(next, ""));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (optJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                            String optString3 = optJSONArray3.optString(i3, "");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                arrayList3.add(optString3);
                                            }
                                        }
                                        ArrayList arrayList4 = arrayList3;
                                        int size = arrayList4.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            Object obj = arrayList4.get(i4);
                                            i4++;
                                            String str = (String) obj;
                                            zzfr(str);
                                            zzcpk zzcpkVar = this.b.get(str);
                                            if (zzcpkVar != null) {
                                                arrayList2.add(new zzcpk(str, optString2, bundle, zzcpkVar.zzgdj));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(optString)) {
                            this.c.put(optString, arrayList);
                        }
                    }
                }
            } catch (JSONException e) {
                zzawz.zza("Malformed config loading JSON.", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b() {
        this.d.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.xf

            /* renamed from: a, reason: collision with root package name */
            private final zzcpf f2607a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2607a = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2607a.c();
            }
        });
    }
}
