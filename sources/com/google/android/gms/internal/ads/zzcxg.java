package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcxg implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f3490a;

    public zzcxg(Map<String, Object> map) {
        this.f3490a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", zzk.zzlg().zzi(this.f3490a));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzawz.zzds(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
