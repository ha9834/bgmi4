package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
final class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ ConnectionResult f1333a;
    private final /* synthetic */ GoogleApiManager.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(GoogleApiManager.b bVar, ConnectionResult connectionResult) {
        this.b = bVar;
        this.f1333a = connectionResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zai zaiVar;
        Api.Client client;
        zai zaiVar2;
        Api.Client client2;
        if (this.f1333a.isSuccess()) {
            GoogleApiManager.b.a(this.b, true);
            client = this.b.b;
            if (!client.requiresSignIn()) {
                try {
                    client2 = this.b.b;
                    client2.getRemoteService(null, Collections.emptySet());
                    return;
                } catch (SecurityException e) {
                    Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
                    Map map = GoogleApiManager.this.l;
                    zaiVar2 = this.b.c;
                    ((GoogleApiManager.zaa) map.get(zaiVar2)).onConnectionFailed(new ConnectionResult(10));
                    return;
                }
            }
            this.b.a();
            return;
        }
        Map map2 = GoogleApiManager.this.l;
        zaiVar = this.b.c;
        ((GoogleApiManager.zaa) map2.get(zaiVar)).onConnectionFailed(this.f1333a);
    }
}
