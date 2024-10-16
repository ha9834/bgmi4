package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
final class gw extends SSLSocketFactory {

    /* renamed from: a, reason: collision with root package name */
    private final SSLSocketFactory f4896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gw() {
        this(HttpsURLConnection.getDefaultSSLSocketFactory());
    }

    private gw(SSLSocketFactory sSLSocketFactory) {
        this.f4896a = sSLSocketFactory;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return a((SSLSocket) this.f4896a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getDefaultCipherSuites() {
        return this.f4896a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final String[] getSupportedCipherSuites() {
        return this.f4896a.getSupportedCipherSuites();
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i) throws IOException {
        return a((SSLSocket) this.f4896a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i) throws IOException {
        return a((SSLSocket) this.f4896a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
        return a((SSLSocket) this.f4896a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
        return a((SSLSocket) this.f4896a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.SocketFactory
    public final Socket createSocket() throws IOException {
        return a((SSLSocket) this.f4896a.createSocket());
    }

    private final SSLSocket a(SSLSocket sSLSocket) {
        return new gx(this, sSLSocket);
    }
}
