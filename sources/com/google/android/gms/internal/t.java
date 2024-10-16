package com.google.android.gms.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.nearby.connection.Connections;

/* loaded from: classes.dex */
final class t implements Connections.StartAdvertisingResult {

    /* renamed from: a, reason: collision with root package name */
    private final Status f4673a;
    private final String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(Status status, String str) {
        this.f4673a = status;
        this.b = str;
    }

    @Override // com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult
    public final String getLocalEndpointName() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.f4673a;
    }
}
