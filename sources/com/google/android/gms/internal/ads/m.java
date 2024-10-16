package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class m extends zzacj<Integer> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public m(int i, String str, Integer num) {
        super(i, str, num, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return Integer.valueOf(bundle.getInt(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return zzqm();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Integer num) {
        editor.putInt(getKey(), num.intValue());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer a(JSONObject jSONObject) {
        return Integer.valueOf(jSONObject.optInt(getKey(), zzqm().intValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Integer a(SharedPreferences sharedPreferences) {
        return Integer.valueOf(sharedPreferences.getInt(getKey(), zzqm().intValue()));
    }
}
