package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class o extends zzacj<Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i, String str, Float f) {
        super(i, str, f, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return Float.valueOf(bundle.getFloat(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return zzqm();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Float f) {
        editor.putFloat(getKey(), f.floatValue());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float a(JSONObject jSONObject) {
        return Float.valueOf((float) jSONObject.optDouble(getKey(), zzqm().floatValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Float a(SharedPreferences sharedPreferences) {
        return Float.valueOf(sharedPreferences.getFloat(getKey(), zzqm().floatValue()));
    }
}
