package com.helpshift.websockets;

import com.facebook.internal.security.CertificateUtil;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public class WebSocketFactory {
    private int mConnectionTimeout;
    private final SocketFactorySettings mSocketFactorySettings = new SocketFactorySettings();
    private final ProxySettings mProxySettings = new ProxySettings(this);

    private static int determinePort(int i, boolean z) {
        return i >= 0 ? i : z ? 443 : 80;
    }

    private static boolean isSecureConnectionRequired(String str) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("The scheme part is empty.");
        }
        if ("wss".equalsIgnoreCase(str) || "https".equalsIgnoreCase(str)) {
            return true;
        }
        if ("ws".equalsIgnoreCase(str) || "http".equalsIgnoreCase(str)) {
            return false;
        }
        throw new IllegalArgumentException("Bad scheme: " + str);
    }

    private static String determinePath(String str) {
        if (str == null || str.length() == 0) {
            return "/";
        }
        if (str.startsWith("/")) {
            return str;
        }
        return "/" + str;
    }

    public SocketFactory getSocketFactory() {
        return this.mSocketFactorySettings.getSocketFactory();
    }

    public WebSocketFactory setSocketFactory(SocketFactory socketFactory) {
        this.mSocketFactorySettings.setSocketFactory(socketFactory);
        return this;
    }

    public SSLSocketFactory getSSLSocketFactory() {
        return this.mSocketFactorySettings.getSSLSocketFactory();
    }

    public WebSocketFactory setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.mSocketFactorySettings.setSSLSocketFactory(sSLSocketFactory);
        return this;
    }

    public SSLContext getSSLContext() {
        return this.mSocketFactorySettings.getSSLContext();
    }

    public WebSocketFactory setSSLContext(SSLContext sSLContext) {
        this.mSocketFactorySettings.setSSLContext(sSLContext);
        return this;
    }

    public ProxySettings getProxySettings() {
        return this.mProxySettings;
    }

    public int getConnectionTimeout() {
        return this.mConnectionTimeout;
    }

    public WebSocketFactory setConnectionTimeout(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("timeout value cannot be negative.");
        }
        this.mConnectionTimeout = i;
        return this;
    }

    public WebSocket createSocket(String str) throws IOException {
        return createSocket(str, getConnectionTimeout());
    }

    public WebSocket createSocket(String str, int i) throws IOException {
        if (str == null) {
            throw new IllegalArgumentException("The given URI is null.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("The given timeout value is negative.");
        }
        return createSocket(URI.create(str), i);
    }

    public WebSocket createSocket(URL url) throws IOException {
        return createSocket(url, getConnectionTimeout());
    }

    public WebSocket createSocket(URL url, int i) throws IOException {
        if (url == null) {
            throw new IllegalArgumentException("The given URL is null.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("The given timeout value is negative.");
        }
        try {
            return createSocket(url.toURI(), i);
        } catch (URISyntaxException unused) {
            throw new IllegalArgumentException("Failed to convert the given URL into a URI.");
        }
    }

    public WebSocket createSocket(URI uri) throws IOException {
        return createSocket(uri, getConnectionTimeout());
    }

    public WebSocket createSocket(URI uri, int i) throws IOException {
        if (uri == null) {
            throw new IllegalArgumentException("The given URI is null.");
        }
        if (i < 0) {
            throw new IllegalArgumentException("The given timeout value is negative.");
        }
        return createSocket(uri.getScheme(), uri.getUserInfo(), Misc.extractHost(uri), uri.getPort(), uri.getRawPath(), uri.getRawQuery(), i);
    }

    private WebSocket createSocket(String str, String str2, String str3, int i, String str4, String str5, int i2) throws IOException {
        boolean isSecureConnectionRequired = isSecureConnectionRequired(str);
        if (str3 == null || str3.length() == 0) {
            throw new IllegalArgumentException("The host part is empty.");
        }
        return createWebSocket(isSecureConnectionRequired, str2, str3, i, determinePath(str4), str5, createRawSocket(str3, i, isSecureConnectionRequired, i2));
    }

    private SocketConnector createRawSocket(String str, int i, boolean z, int i2) throws IOException {
        int determinePort = determinePort(i, z);
        if (this.mProxySettings.getHost() != null) {
            return createProxiedRawSocket(str, determinePort, z, i2);
        }
        return createDirectRawSocket(str, determinePort, z, i2);
    }

    private SocketConnector createProxiedRawSocket(String str, int i, boolean z, int i2) throws IOException {
        int determinePort = determinePort(this.mProxySettings.getPort(), this.mProxySettings.isSecure());
        Socket createSocket = this.mProxySettings.selectSocketFactory().createSocket();
        return new SocketConnector(createSocket, new Address(this.mProxySettings.getHost(), determinePort), i2, new ProxyHandshaker(createSocket, str, i, this.mProxySettings), z ? (SSLSocketFactory) this.mSocketFactorySettings.selectSocketFactory(z) : null, str, i);
    }

    private SocketConnector createDirectRawSocket(String str, int i, boolean z, int i2) throws IOException {
        return new SocketConnector(this.mSocketFactorySettings.selectSocketFactory(z).createSocket(), new Address(str, i), i2);
    }

    private WebSocket createWebSocket(boolean z, String str, String str2, int i, String str3, String str4, SocketConnector socketConnector) {
        String str5;
        String str6;
        if (i >= 0) {
            str5 = str2 + CertificateUtil.DELIMITER + i;
        } else {
            str5 = str2;
        }
        if (str4 != null) {
            str6 = str3 + "?" + str4;
        } else {
            str6 = str3;
        }
        return new WebSocket(this, z, str, str5, str6, socketConnector);
    }
}
