package com.google.android.gms.internal.gtm;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes2.dex */
public final class zzar {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4388a;
    private final Context b;

    public zzar(Context context) {
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext, "Application context can't be null");
        this.f4388a = applicationContext;
        this.b = applicationContext;
    }

    public final Context getApplicationContext() {
        return this.f4388a;
    }

    public final Context zzdc() {
        return this.b;
    }
}
