package com.google.android.gms.nearby.connection;

/* loaded from: classes2.dex */
public final class ConnectionInfo {

    /* renamed from: a, reason: collision with root package name */
    private final String f4966a;
    private final String b;
    private final boolean c;

    public ConnectionInfo(String str, String str2, boolean z) {
        this.f4966a = str;
        this.b = str2;
        this.c = z;
    }

    public final String getAuthenticationToken() {
        return this.b;
    }

    public final String getEndpointName() {
        return this.f4966a;
    }

    public final boolean isIncomingConnection() {
        return this.c;
    }
}
