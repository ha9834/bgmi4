package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class at implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbr f2058a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(zzaii zzaiiVar, zzbbr zzbbrVar) {
        this.f2058a = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.f2058a.setException(new RuntimeException("Connection failed."));
    }
}
