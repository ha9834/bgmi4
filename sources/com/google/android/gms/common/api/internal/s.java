package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
final class s implements GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ StatusPendingResult f1374a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zaaw zaawVar, StatusPendingResult statusPendingResult) {
        this.f1374a = statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f1374a.setResult(new Status(8));
    }
}
