package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zaq implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1404a;
    private zar b;
    public final Api<?> mApi;

    public zaq(Api<?> api, boolean z) {
        this.mApi = api;
        this.f1404a = z;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        a();
        this.b.onConnected(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        a();
        this.b.onConnectionSuspended(i);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        a();
        this.b.zaa(connectionResult, this.mApi, this.f1404a);
    }

    public final void zaa(zar zarVar) {
        this.b = zarVar;
    }

    private final void a() {
        Preconditions.checkNotNull(this.b, "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }
}
