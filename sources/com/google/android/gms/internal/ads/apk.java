package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class apk implements BaseGmsClient.BaseOnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbr f2033a;
    private final /* synthetic */ zzwb b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public apk(zzwb zzwbVar, zzbbr zzbbrVar) {
        this.b = zzwbVar;
        this.f2033a = zzbbrVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Object obj;
        obj = this.b.d;
        synchronized (obj) {
            this.f2033a.setException(new RuntimeException("Connection failed."));
        }
    }
}
