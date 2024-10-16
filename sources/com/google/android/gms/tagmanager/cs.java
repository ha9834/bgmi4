package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cs extends ag {

    /* renamed from: a, reason: collision with root package name */
    private static final String f5109a = com.google.android.gms.internal.gtm.zza.ADVERTISING_TRACKING_ENABLED.toString();
    private final zza b;

    public cs(Context context) {
        this(zza.zzf(context));
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final boolean zzgw() {
        return false;
    }

    @VisibleForTesting
    private cs(zza zzaVar) {
        super(f5109a, new String[0]);
        this.b = zzaVar;
    }

    @Override // com.google.android.gms.tagmanager.ag
    public final zzl zzb(Map<String, zzl> map) {
        return zzgj.zzi(Boolean.valueOf(!this.b.isLimitAdTrackingEnabled()));
    }
}
