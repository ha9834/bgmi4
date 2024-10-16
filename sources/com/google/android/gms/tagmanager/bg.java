package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class bg extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5090a = com.google.android.gms.internal.gtm.zza.MOBILE_ADWORDS_UNIQUE_ID.toString();
    private final Context b;

    public bg(Context context) {
        super(f5090a, new String[0]);
        this.b = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String string = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
        return string == null ? zzgj.zzkc() : zzgj.zzi(string);
    }
}
