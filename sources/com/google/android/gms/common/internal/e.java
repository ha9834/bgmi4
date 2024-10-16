package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ GoogleApiClient.OnConnectionFailedListener f1469a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f1469a = onConnectionFailedListener;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f1469a.onConnectionFailed(connectionResult);
    }
}
