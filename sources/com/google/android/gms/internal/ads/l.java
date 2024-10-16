package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends zzacj<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(int i, String str, Boolean bool) {
        super(i, str, bool, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Boolean zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return Boolean.valueOf(bundle.getBoolean(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return zzqm();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Boolean bool) {
        editor.putBoolean(getKey(), bool.booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Boolean a(JSONObject jSONObject) {
        return Boolean.valueOf(jSONObject.optBoolean(getKey(), zzqm().booleanValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Boolean a(SharedPreferences sharedPreferences) {
        return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), zzqm().booleanValue()));
    }
}
