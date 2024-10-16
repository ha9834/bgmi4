package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bt extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5093a = com.google.android.gms.internal.gtm.zza.ADVERTISER_ID.toString();
    private final zza b;

    public bt(Context context) {
        this(zza.zzf(context));
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }

    @VisibleForTesting
    private bt(zza zzaVar) {
        super(f5093a, new String[0]);
        this.b = zzaVar;
        this.b.zzgq();
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String zzgq = this.b.zzgq();
        return zzgq == null ? zzgj.zzkc() : zzgj.zzi(zzgq);
    }
}
