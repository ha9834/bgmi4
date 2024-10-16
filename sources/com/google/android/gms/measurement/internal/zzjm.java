package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzjm {

    /* renamed from: a, reason: collision with root package name */
    final Context f4954a;

    @VisibleForTesting
    public zzjm(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.f4954a = applicationContext;
    }
}
