package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzbal;
import com.google.android.gms.internal.ads.zzbar;
import com.google.android.gms.internal.ads.zzbbh;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements zzbal {

    /* renamed from: a, reason: collision with root package name */
    static final zzbal f1148a = new a();

    private a() {
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzk.zzlk().zzvc().zzdv(jSONObject.getString("appSettingsJson"));
        }
        return zzbar.zzm(null);
    }
}
