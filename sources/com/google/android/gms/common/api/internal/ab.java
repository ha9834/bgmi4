package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;

/* loaded from: classes.dex */
final class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f1330a;
    private final /* synthetic */ GoogleApiManager.zaa b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(GoogleApiManager.zaa zaaVar, ConnectionResult connectionResult) {
        this.b = zaaVar;
        this.f1330a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.onConnectionFailed(this.f1330a);
    }
}
