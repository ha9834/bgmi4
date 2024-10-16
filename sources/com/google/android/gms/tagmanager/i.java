package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes2.dex */
final class i extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5143a = com.google.android.gms.internal.gtm.zza.CONTAINER_VERSION.toString();
    private final String b;

    public i(String str) {
        super(f5143a, new String[0]);
        this.b = str;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return true;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String str = this.b;
        return str == null ? zzgj.zzkc() : zzgj.zzi(str);
    }
}
