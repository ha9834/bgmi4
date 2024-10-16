package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p extends zzacj<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i, String str, String str2) {
        super(i, str, str2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return bundle.getString(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag."));
        }
        return zzqm();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, String str) {
        editor.putString(getKey(), str);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String a(JSONObject jSONObject) {
        return jSONObject.optString(getKey(), zzqm());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ String a(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString(getKey(), zzqm());
    }
}
