package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class dd extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5116a = com.google.android.gms.internal.gtm.zza.SDK_VERSION.toString();

    public dd() {
        super(f5116a, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(Integer.valueOf(Build.VERSION.SDK_INT));
    }
}
