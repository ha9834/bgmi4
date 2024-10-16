package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.IR;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class ue implements zzalm<zzcir> {
    @Override // com.google.android.gms.internal.ads.zzalm
    public final /* synthetic */ JSONObject zzj(zzcir zzcirVar) throws JSONException {
        zzcir zzcirVar2 = zzcirVar;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put(IR.MODULE_URL, zzcirVar2.zzfxu.zztu());
        jSONObject2.put("signals", zzcirVar2.zzfxt);
        jSONObject3.put("body", zzcirVar2.zzfxs.c);
        jSONObject3.put("headers", zzk.zzlg().zzi(zzcirVar2.zzfxs.b));
        jSONObject3.put("response_code", zzcirVar2.zzfxs.f3274a);
        jSONObject3.put("latency", zzcirVar2.zzfxs.d);
        jSONObject.put("request", jSONObject2);
        jSONObject.put(AnalyticsEventKey.RESPONSE, jSONObject3);
        jSONObject.put("flags", zzcirVar2.zzfxu.zztx());
        return jSONObject;
    }
}
