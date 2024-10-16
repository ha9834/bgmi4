package com.google.android.gms.plus.internal;

import android.app.PendingIntent;
import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
final class c extends zza {

    /* renamed from: a, reason: collision with root package name */
    private final BaseImplementation.ResultHolder<Status> f5048a;

    public c(BaseImplementation.ResultHolder<Status> resultHolder) {
        this.f5048a = resultHolder;
    }

    @Override // com.google.android.gms.plus.internal.zza, com.google.android.gms.plus.internal.zzb
    public final void zza(int i, Bundle bundle) {
        this.f5048a.setResult(new Status(i, null, bundle != null ? (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT) : null));
    }
}
