package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
final class aw {

    /* renamed from: a, reason: collision with root package name */
    private final int f1347a;
    private final ConnectionResult b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(ConnectionResult connectionResult, int i) {
        Preconditions.checkNotNull(connectionResult);
        this.b = connectionResult;
        this.f1347a = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.f1347a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ConnectionResult b() {
        return this.b;
    }
}
