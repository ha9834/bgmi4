package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcwt implements zzcuz<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f3481a;

    public zzcwt(Bundle bundle) {
        this.f3481a = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void zzt(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.f3481a != null) {
            try {
                zzazc.zzb(zzazc.zzb(jSONObject2, "device"), "play_store").put("parental_controls", zzk.zzlg().zzd(this.f3481a));
            } catch (JSONException unused) {
                zzawz.zzds("Failed putting parental controls bundle.");
            }
        }
    }
}
