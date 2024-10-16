package com.google.android.gms.tagmanager;

import android.os.Build;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* loaded from: classes2.dex */
final class bu extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5094a = com.google.android.gms.internal.gtm.zza.OS_VERSION.toString();

    public bu() {
        super(f5094a, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(Build.VERSION.RELEASE);
    }
}
