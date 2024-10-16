package com.google.android.gms.internal;

import com.google.android.gms.nearby.connection.ConnectionInfo;
import com.google.android.gms.nearby.connection.ConnectionLifecycleCallback;
import com.google.android.gms.nearby.connection.ConnectionResolution;

/* loaded from: classes.dex */
final class ao extends ConnectionLifecycleCallback {

    /* renamed from: a, reason: collision with root package name */
    private final ConnectionLifecycleCallback f3794a;
    private /* synthetic */ zzcpz b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(zzcpz zzcpzVar, ConnectionLifecycleCallback connectionLifecycleCallback) {
        this.b = zzcpzVar;
        this.f3794a = connectionLifecycleCallback;
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionInitiated(String str, ConnectionInfo connectionInfo) {
        if (connectionInfo.isIncomingConnection()) {
            this.b.a(str);
        }
        this.f3794a.onConnectionInitiated(str, connectionInfo);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onConnectionResult(String str, ConnectionResolution connectionResolution) {
        if (!connectionResolution.getStatus().isSuccess()) {
            this.b.b(str);
        }
        this.f3794a.onConnectionResult(str, connectionResolution);
    }

    @Override // com.google.android.gms.nearby.connection.ConnectionLifecycleCallback
    public final void onDisconnected(String str) {
        this.b.b(str);
        this.f3794a.onDisconnected(str);
    }
}
