package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.zad;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
final class o implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zaak f1370a;

    private o(zaak zaakVar) {
        this.f1370a = zaakVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        ClientSettings clientSettings;
        zad zadVar;
        Lock lock;
        Lock lock2;
        zad zadVar2;
        zad zadVar3;
        clientSettings = this.f1370a.r;
        if (clientSettings.isSignInClientDisconnectFixEnabled()) {
            lock = this.f1370a.b;
            lock.lock();
            try {
                zadVar2 = this.f1370a.k;
                if (zadVar2 == null) {
                    return;
                }
                zadVar3 = this.f1370a.k;
                zadVar3.zaa(new m(this.f1370a));
                return;
            } finally {
                lock2 = this.f1370a.b;
                lock2.unlock();
            }
        }
        zadVar = this.f1370a.k;
        zadVar.zaa(new m(this.f1370a));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        Lock lock;
        Lock lock2;
        boolean a2;
        lock = this.f1370a.b;
        lock.lock();
        try {
            a2 = this.f1370a.a(connectionResult);
            if (!a2) {
                this.f1370a.b(connectionResult);
            } else {
                this.f1370a.d();
                this.f1370a.b();
            }
        } finally {
            lock2 = this.f1370a.b;
            lock2.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ o(zaak zaakVar, g gVar) {
        this(zaakVar);
    }
}
