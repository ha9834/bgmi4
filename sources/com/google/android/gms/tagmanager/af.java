package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class af extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5070a = com.google.android.gms.internal.gtm.zza.EVENT.toString();
    private final cu b;

    public af(cu cuVar) {
        super(f5070a, new String[0]);
        this.b = cuVar;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        String a2 = this.b.a();
        if (a2 == null) {
            return zzgj.zzkc();
        }
        return zzgj.zzi(a2);
    }
}
