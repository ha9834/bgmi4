package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes2.dex */
final /* synthetic */ class vr implements zzbal {

    /* renamed from: a, reason: collision with root package name */
    static final zzbal f2571a = new vr();

    private vr() {
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (!jSONObject.optBoolean("success")) {
            throw new zzali("process json failed");
        }
        return zzbar.zzm(jSONObject.getJSONObject("json").getJSONArray("ads"));
    }
}
