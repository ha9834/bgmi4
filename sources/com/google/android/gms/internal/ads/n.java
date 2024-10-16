package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class n extends zzacj<Long> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(int i, String str, Long l) {
        super(i, str, l, null);
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long zza(Bundle bundle) {
        String valueOf = String.valueOf(getKey());
        if (bundle.containsKey(valueOf.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf) : new String("com.google.android.gms.ads.flag."))) {
            String valueOf2 = String.valueOf(getKey());
            return Long.valueOf(bundle.getLong(valueOf2.length() != 0 ? "com.google.android.gms.ads.flag.".concat(valueOf2) : new String("com.google.android.gms.ads.flag.")));
        }
        return zzqm();
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ void zza(SharedPreferences.Editor editor, Long l) {
        editor.putLong(getKey(), l.longValue());
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long a(JSONObject jSONObject) {
        return Long.valueOf(jSONObject.optLong(getKey(), zzqm().longValue()));
    }

    @Override // com.google.android.gms.internal.ads.zzacj
    public final /* synthetic */ Long a(SharedPreferences sharedPreferences) {
        return Long.valueOf(sharedPreferences.getLong(getKey(), zzqm().longValue()));
    }
}
