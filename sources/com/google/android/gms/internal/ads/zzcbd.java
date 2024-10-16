package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcbd {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f3163a;
    private final zzcau b;

    public zzcbd(Executor executor, zzcau zzcauVar) {
        this.f3163a = executor;
        this.b = zzcauVar;
    }

    public final zzbbh<List<zzcbg>> zzg(JSONObject jSONObject, String str) {
        Future zzm;
        final String optString;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzbar.zzm(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                String optString2 = optJSONObject.optString("type");
                if ("string".equals(optString2)) {
                    c = 1;
                } else {
                    c = "image".equals(optString2) ? (char) 2 : (char) 0;
                }
                switch (c) {
                    case 1:
                        zzm = zzbar.zzm(new zzcbg(optString, optJSONObject.optString("string_value")));
                        break;
                    case 2:
                        zzm = zzbar.zza(this.b.zzc(optJSONObject, "image_value"), new zzbam(optString) { // from class: com.google.android.gms.internal.ads.rf

                            /* renamed from: a, reason: collision with root package name */
                            private final String f2461a;

                            /* JADX INFO: Access modifiers changed from: package-private */
                            {
                                this.f2461a = optString;
                            }

                            @Override // com.google.android.gms.internal.ads.zzbam
                            public final Object apply(Object obj) {
                                return new zzcbg(this.f2461a, (zzadw) obj);
                            }
                        }, this.f3163a);
                        break;
                }
                arrayList.add(zzm);
            }
            zzm = zzbar.zzm(null);
            arrayList.add(zzm);
        }
        return zzbar.zza(zzbar.zze(arrayList), re.f2460a, this.f3163a);
    }
}
