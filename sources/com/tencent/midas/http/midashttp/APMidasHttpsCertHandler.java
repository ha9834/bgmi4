package com.tencent.midas.http.midashttp;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class APMidasHttpsCertHandler extends APMidasBaseHttpHandler {
    private final String certification;
    private final MidasIPChecker ipChecker;
    private ThreadLocal<Boolean> hasSetHttpsHeader = new ThreadLocal<Boolean>() { // from class: com.tencent.midas.http.midashttp.APMidasHttpsCertHandler.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return false;
        }
    };
    private ThreadLocal<Boolean> hasSetHostnameVerifier = new ThreadLocal<Boolean>() { // from class: com.tencent.midas.http.midashttp.APMidasHttpsCertHandler.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return false;
        }
    };
    private ThreadLocal<Boolean> hasSetSSLSocketFactory = new ThreadLocal<Boolean>() { // from class: com.tencent.midas.http.midashttp.APMidasHttpsCertHandler.3
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return false;
        }
    };

    /* loaded from: classes.dex */
    public interface MidasIPChecker {
        boolean isMidasIP(String str);
    }

    public APMidasHttpsCertHandler(String str, MidasIPChecker midasIPChecker) {
        this.certification = str;
        this.ipChecker = midasIPChecker;
    }

    private boolean needCustomCert(Request request) {
        return request != null && request.isHttpsRequest() && request.isRequestWithIP() && (request instanceof APMidasHttpRequest) && request.getCustomHostnameVerifier() == null && request.getCustomSSLSocketFactory() == null;
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpStart(Request request) {
        if (request != null && needCustomCert(request)) {
            if (!request.hasHttpHeader("https.protocols", "TLSv1")) {
                request.addHttpHeader("https.protocols", "TLSv1");
                this.hasSetHttpsHeader.set(true);
            }
            createSSLConnection(request);
        }
    }

    @Override // com.tencent.midas.http.midashttp.APMidasBaseHttpHandler, com.tencent.midas.http.core.HttpHandler
    public void onHttpEnd(Request request, Response response) {
        super.onHttpEnd(request, response);
        if (this.hasSetHttpsHeader.get().booleanValue()) {
            this.hasSetHttpsHeader.set(false);
            request.removeHttpHeader("https.protocols", "TLSv1");
        }
        if (this.hasSetHostnameVerifier.get().booleanValue()) {
            this.hasSetHostnameVerifier.set(false);
            request.clearCustomHostnameVerifier();
        }
        if (this.hasSetSSLSocketFactory.get().booleanValue()) {
            this.hasSetSSLSocketFactory.set(false);
            request.clearCustomSSLSocketFactory();
        }
    }

    private void createSSLConnection(Request request) {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLSv1");
            if (request.isRequestWithIP()) {
                sSLContext.init(null, new TrustManager[]{new myTrustManager(this.certification)}, new SecureRandom());
                request.setCustomHostnameVerifier(new myHostnameVerifier(this.ipChecker));
                this.hasSetHostnameVerifier.set(true);
            } else {
                sSLContext.init(null, null, new SecureRandom());
            }
            if (Build.VERSION.SDK_INT >= 20) {
                request.setCustomSSLSocketFactory(sSLContext.getSocketFactory());
                this.hasSetSSLSocketFactory.set(true);
            } else {
                request.setCustomSSLSocketFactory(new APDelegateNoSSLv3Compat.NoSSLv3Factory(sSLContext.getSocketFactory()));
                this.hasSetSSLSocketFactory.set(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class myTrustManager implements X509TrustManager {
        private X509TrustManager my509TrustManager;

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        myTrustManager(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
                X509Certificate x509Certificate = (X509Certificate) certificateFactory.generateCertificate(byteArrayInputStream);
                byteArrayInputStream.close();
                KeyStore.TrustedCertificateEntry trustedCertificateEntry = new KeyStore.TrustedCertificateEntry(x509Certificate);
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null, null);
                keyStore.setEntry("ca_root", trustedCertificateEntry, null);
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                for (int i = 0; i < trustManagers.length; i++) {
                    if (trustManagers[i] instanceof X509TrustManager) {
                        this.my509TrustManager = (X509TrustManager) trustManagers[i];
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            this.my509TrustManager.checkServerTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return this.my509TrustManager.getAcceptedIssuers();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class myHostnameVerifier implements HostnameVerifier {
        private final MidasIPChecker ipChecker;

        private myHostnameVerifier(MidasIPChecker midasIPChecker) {
            this.ipChecker = midasIPChecker;
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            MidasIPChecker midasIPChecker = this.ipChecker;
            if (midasIPChecker == null) {
                return false;
            }
            return midasIPChecker.isMidasIP(str);
        }
    }

    /* loaded from: classes.dex */
    private static class APDelegateNoSSLv3Compat {
        private APDelegateNoSSLv3Compat() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class NoSSLv3SSLSocket extends APDelegateSSLSocket {
            private NoSSLv3SSLSocket(SSLSocket sSLSocket) {
                super(sSLSocket);
                if (sSLSocket.getClass().getCanonicalName().equals("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl")) {
                    return;
                }
                try {
                    Method method = sSLSocket.getClass().getMethod("setUseSessionTickets", Boolean.TYPE);
                    if (method != null) {
                        method.invoke(sSLSocket, true);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e2) {
                    e2.printStackTrace();
                } catch (InvocationTargetException e3) {
                    e3.printStackTrace();
                }
            }

            @Override // com.tencent.midas.http.midashttp.APMidasHttpsCertHandler.APDelegateSSLSocket, javax.net.ssl.SSLSocket
            public void setEnabledProtocols(String[] strArr) {
                if (strArr != null && strArr.length == 1 && "SSLv3".equals(strArr[0])) {
                    ArrayList arrayList = new ArrayList(Arrays.asList(this.delegate.getEnabledProtocols()));
                    if (arrayList.size() > 1) {
                        arrayList.remove("SSLv3");
                    }
                    strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                }
                super.setEnabledProtocols(strArr);
            }
        }

        /* loaded from: classes.dex */
        public static class NoSSLv3Factory extends SSLSocketFactory {
            private final SSLSocketFactory delegate;

            public NoSSLv3Factory(SSLSocketFactory sSLSocketFactory) {
                this.delegate = sSLSocketFactory;
            }

            private static Socket makeSocketSafe(Socket socket) {
                boolean z;
                if (!(socket instanceof SSLSocket) || (socket instanceof NoSSLv3SSLSocket)) {
                    return socket;
                }
                NoSSLv3SSLSocket noSSLv3SSLSocket = new NoSSLv3SSLSocket((SSLSocket) socket);
                NoSSLv3SSLSocket noSSLv3SSLSocket2 = noSSLv3SSLSocket;
                String[] supportedProtocols = noSSLv3SSLSocket2.getSupportedProtocols();
                if (supportedProtocols != null) {
                    z = false;
                    for (String str : supportedProtocols) {
                        if ("TLSv1.2".equals(str)) {
                            z = true;
                        }
                    }
                } else {
                    z = false;
                }
                if (z) {
                    noSSLv3SSLSocket2.setEnabledProtocols(new String[]{"TLSv1.1", "TLSv1.2"});
                }
                return noSSLv3SSLSocket;
            }

            @Override // javax.net.ssl.SSLSocketFactory
            public String[] getDefaultCipherSuites() {
                return this.delegate.getDefaultCipherSuites();
            }

            @Override // javax.net.ssl.SSLSocketFactory
            public String[] getSupportedCipherSuites() {
                return this.delegate.getSupportedCipherSuites();
            }

            @Override // javax.net.ssl.SSLSocketFactory
            public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
                return makeSocketSafe(this.delegate.createSocket(socket, str, i, z));
            }

            @Override // javax.net.SocketFactory
            public Socket createSocket(String str, int i) throws IOException {
                return makeSocketSafe(this.delegate.createSocket(str, i));
            }

            @Override // javax.net.SocketFactory
            public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
                return makeSocketSafe(this.delegate.createSocket(str, i, inetAddress, i2));
            }

            @Override // javax.net.SocketFactory
            public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
                return makeSocketSafe(this.delegate.createSocket(inetAddress, i));
            }

            @Override // javax.net.SocketFactory
            public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
                return makeSocketSafe(this.delegate.createSocket(inetAddress, i, inetAddress2, i2));
            }
        }
    }

    /* loaded from: classes.dex */
    private static class APDelegateSSLSocket extends SSLSocket {
        protected final SSLSocket delegate;

        APDelegateSSLSocket(SSLSocket sSLSocket) {
            this.delegate = sSLSocket;
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedCipherSuites() {
            return this.delegate.getSupportedCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledCipherSuites() {
            return this.delegate.getEnabledCipherSuites();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledCipherSuites(String[] strArr) {
            this.delegate.setEnabledCipherSuites(strArr);
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getSupportedProtocols() {
            return this.delegate.getSupportedProtocols();
        }

        @Override // javax.net.ssl.SSLSocket
        public String[] getEnabledProtocols() {
            return this.delegate.getEnabledProtocols();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnabledProtocols(String[] strArr) {
            this.delegate.setEnabledProtocols(strArr);
        }

        @Override // javax.net.ssl.SSLSocket
        public SSLSession getSession() {
            return this.delegate.getSession();
        }

        @Override // javax.net.ssl.SSLSocket
        public void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.delegate.addHandshakeCompletedListener(handshakeCompletedListener);
        }

        @Override // javax.net.ssl.SSLSocket
        public void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
            this.delegate.removeHandshakeCompletedListener(handshakeCompletedListener);
        }

        @Override // javax.net.ssl.SSLSocket
        public void startHandshake() throws IOException {
            this.delegate.startHandshake();
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getUseClientMode() {
            return this.delegate.getUseClientMode();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setUseClientMode(boolean z) {
            this.delegate.setUseClientMode(z);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getNeedClientAuth() {
            return this.delegate.getNeedClientAuth();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setNeedClientAuth(boolean z) {
            this.delegate.setNeedClientAuth(z);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getWantClientAuth() {
            return this.delegate.getWantClientAuth();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setWantClientAuth(boolean z) {
            this.delegate.setWantClientAuth(z);
        }

        @Override // javax.net.ssl.SSLSocket
        public boolean getEnableSessionCreation() {
            return this.delegate.getEnableSessionCreation();
        }

        @Override // javax.net.ssl.SSLSocket
        public void setEnableSessionCreation(boolean z) {
            this.delegate.setEnableSessionCreation(z);
        }

        @Override // java.net.Socket
        public void bind(SocketAddress socketAddress) throws IOException {
            this.delegate.bind(socketAddress);
        }

        @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            this.delegate.close();
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress) throws IOException {
            this.delegate.connect(socketAddress);
        }

        @Override // java.net.Socket
        public void connect(SocketAddress socketAddress, int i) throws IOException {
            this.delegate.connect(socketAddress, i);
        }

        @Override // java.net.Socket
        public SocketChannel getChannel() {
            return this.delegate.getChannel();
        }

        @Override // java.net.Socket
        public InetAddress getInetAddress() {
            return this.delegate.getInetAddress();
        }

        @Override // java.net.Socket
        public InputStream getInputStream() throws IOException {
            return this.delegate.getInputStream();
        }

        @Override // java.net.Socket
        public boolean getKeepAlive() throws SocketException {
            return this.delegate.getKeepAlive();
        }

        @Override // java.net.Socket
        public void setKeepAlive(boolean z) throws SocketException {
            this.delegate.setKeepAlive(z);
        }

        @Override // java.net.Socket
        public InetAddress getLocalAddress() {
            return this.delegate.getLocalAddress();
        }

        @Override // java.net.Socket
        public int getLocalPort() {
            return this.delegate.getLocalPort();
        }

        @Override // java.net.Socket
        public SocketAddress getLocalSocketAddress() {
            return this.delegate.getLocalSocketAddress();
        }

        @Override // java.net.Socket
        public boolean getOOBInline() throws SocketException {
            return this.delegate.getOOBInline();
        }

        @Override // java.net.Socket
        public void setOOBInline(boolean z) throws SocketException {
            this.delegate.setOOBInline(z);
        }

        @Override // java.net.Socket
        public OutputStream getOutputStream() throws IOException {
            return this.delegate.getOutputStream();
        }

        @Override // java.net.Socket
        public int getPort() {
            return this.delegate.getPort();
        }

        @Override // java.net.Socket
        public synchronized int getReceiveBufferSize() throws SocketException {
            return this.delegate.getReceiveBufferSize();
        }

        @Override // java.net.Socket
        public synchronized void setReceiveBufferSize(int i) throws SocketException {
            this.delegate.setReceiveBufferSize(i);
        }

        @Override // java.net.Socket
        public SocketAddress getRemoteSocketAddress() {
            return this.delegate.getRemoteSocketAddress();
        }

        @Override // java.net.Socket
        public boolean getReuseAddress() throws SocketException {
            return this.delegate.getReuseAddress();
        }

        @Override // java.net.Socket
        public void setReuseAddress(boolean z) throws SocketException {
            this.delegate.setReuseAddress(z);
        }

        @Override // java.net.Socket
        public synchronized int getSendBufferSize() throws SocketException {
            return this.delegate.getSendBufferSize();
        }

        @Override // java.net.Socket
        public synchronized void setSendBufferSize(int i) throws SocketException {
            this.delegate.setSendBufferSize(i);
        }

        @Override // java.net.Socket
        public int getSoLinger() throws SocketException {
            return this.delegate.getSoLinger();
        }

        @Override // java.net.Socket
        public synchronized int getSoTimeout() throws SocketException {
            return this.delegate.getSoTimeout();
        }

        @Override // java.net.Socket
        public synchronized void setSoTimeout(int i) throws SocketException {
            this.delegate.setSoTimeout(i);
        }

        @Override // java.net.Socket
        public boolean getTcpNoDelay() throws SocketException {
            return this.delegate.getTcpNoDelay();
        }

        @Override // java.net.Socket
        public void setTcpNoDelay(boolean z) throws SocketException {
            this.delegate.setTcpNoDelay(z);
        }

        @Override // java.net.Socket
        public int getTrafficClass() throws SocketException {
            return this.delegate.getTrafficClass();
        }

        @Override // java.net.Socket
        public void setTrafficClass(int i) throws SocketException {
            this.delegate.setTrafficClass(i);
        }

        @Override // java.net.Socket
        public boolean isBound() {
            return this.delegate.isBound();
        }

        @Override // java.net.Socket
        public boolean isClosed() {
            return this.delegate.isClosed();
        }

        @Override // java.net.Socket
        public boolean isConnected() {
            return this.delegate.isConnected();
        }

        @Override // java.net.Socket
        public boolean isInputShutdown() {
            return this.delegate.isInputShutdown();
        }

        @Override // java.net.Socket
        public boolean isOutputShutdown() {
            return this.delegate.isOutputShutdown();
        }

        @Override // java.net.Socket
        public void sendUrgentData(int i) throws IOException {
            this.delegate.sendUrgentData(i);
        }

        @Override // java.net.Socket
        public void setPerformancePreferences(int i, int i2, int i3) {
            this.delegate.setPerformancePreferences(i, i2, i3);
        }

        @Override // java.net.Socket
        public void setSoLinger(boolean z, int i) throws SocketException {
            this.delegate.setSoLinger(z, i);
        }

        @Override // javax.net.ssl.SSLSocket
        public void setSSLParameters(SSLParameters sSLParameters) {
            this.delegate.setSSLParameters(sSLParameters);
        }

        @Override // java.net.Socket
        public void shutdownInput() throws IOException {
            this.delegate.shutdownInput();
        }

        @Override // java.net.Socket
        public void shutdownOutput() throws IOException {
            this.delegate.shutdownOutput();
        }

        @Override // javax.net.ssl.SSLSocket, java.net.Socket
        public String toString() {
            return this.delegate.toString();
        }

        public boolean equals(Object obj) {
            return this.delegate.equals(obj);
        }
    }
}
