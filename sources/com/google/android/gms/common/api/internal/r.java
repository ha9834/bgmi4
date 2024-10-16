package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
final class r implements GoogleApiClient.ConnectionCallbacks {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AtomicReference f1373a;
    private final /* synthetic */ StatusPendingResult b;
    private final /* synthetic */ zaaw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(zaaw zaawVar, AtomicReference atomicReference, StatusPendingResult statusPendingResult) {
        this.c = zaawVar;
        this.f1373a = atomicReference;
        this.b = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.c.a((GoogleApiClient) this.f1373a.get(), this.b, true);
    }
}
