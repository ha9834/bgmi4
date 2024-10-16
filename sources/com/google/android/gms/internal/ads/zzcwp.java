package com.google.android.gms.internal.ads;

import android.location.Location;
import com.adjust.sdk.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcwp implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final Location f3478a;

    public zzcwp(Location location) {
        this.f3478a = location;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (this.f3478a != null) {
                JSONObject jSONObject3 = new JSONObject();
                Float valueOf = Float.valueOf(this.f3478a.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(this.f3478a.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (this.f3478a.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (this.f3478a.getLongitude() * 1.0E7d));
                jSONObject3.put("radius", valueOf);
                jSONObject3.put("lat", valueOf3);
                jSONObject3.put(Constants.LONG, valueOf4);
                jSONObject3.put("time", valueOf2);
                jSONObject2.put("uule", jSONObject3);
            }
        } catch (JSONException e) {
            zzawz.zza("Failed adding location to the request JSON.", e);
        }
    }
}
