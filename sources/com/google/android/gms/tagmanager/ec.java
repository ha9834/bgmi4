package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class ec extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5133a = com.google.android.gms.internal.gtm.zza.APP_ID.toString();
    private final Context b;

    public ec(Context context) {
        super(f5133a, new String[0]);
        this.b = context;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(this.b.getPackageName());
    }
}
