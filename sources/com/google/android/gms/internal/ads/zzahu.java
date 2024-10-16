package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzahu implements zzaho<Object> {

    /* renamed from: a, reason: collision with root package name */
    private final Object f2735a = new Object();

    @GuardedBy("lock")
    private final Map<String, zzahw> b = new HashMap();

    public final void zza(String str, zzahw zzahwVar) {
        synchronized (this.f2735a) {
            this.b.put(str, zzahwVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final void zza(Object obj, Map<String, String> map) {
        String concat;
        String str = map.get("id");
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("fail_stack");
        String str5 = map.get("result");
        if (TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            concat = "";
        } else {
            String valueOf = String.valueOf(str4);
            concat = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.f2735a) {
            zzahw remove = this.b.remove(str);
            if (remove == null) {
                String valueOf2 = String.valueOf(str);
                zzawz.zzep(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                String valueOf3 = String.valueOf(str3);
                String valueOf4 = String.valueOf(concat);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else {
                if (str5 == null) {
                    remove.zzc(null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (zzawz.zzvj()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzawz.zzds(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zzc(jSONObject);
                } catch (JSONException e) {
                    remove.onFailure(e.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzakg> zzbbh<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzbbr zzbbrVar = new zzbbr();
        zzk.zzlg();
        String zzwb = zzaxi.zzwb();
        zza(zzwb, new an(this, zzbbrVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", zzwb);
            jSONObject2.put("args", jSONObject);
            enginet.zzb(str, jSONObject2);
        } catch (Exception e) {
            zzbbrVar.setException(e);
        }
        return zzbbrVar;
    }
}
