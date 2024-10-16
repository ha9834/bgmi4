package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzdf;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
final class cl implements co {
    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar) {
    }

    @Override // com.google.android.gms.tagmanager.co
    public final ScheduledExecutorService a() {
        return zzdf.zzgp().zza(1, com.google.android.gms.internal.gtm.zzdi.zzadg);
    }
}
