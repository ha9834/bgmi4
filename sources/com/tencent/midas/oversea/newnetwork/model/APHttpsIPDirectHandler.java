package com.tencent.midas.oversea.newnetwork.model;

import android.net.SSLCertificateSocketFactory;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.HttpHandler;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public class APHttpsIPDirectHandler implements HttpHandler {
    private static final String TAG = "APHttpsIPDirectHandler";
    private final ThreadLocal<Boolean> hasSet = new ThreadLocal<Boolean>() { // from class: com.tencent.midas.oversea.newnetwork.model.APHttpsIPDirectHandler.1
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return false;
        }
    };

    @Override // com.tencent.midas.http.core.HttpHandler
    public void onHttpRetry(int i, int i2, Request request, Response response) {
    }

    @Override // com.tencent.midas.http.core.HttpHandler
    public void onHttpStart(Request request) {
        if (request == null) {
            APLog.e(TAG, "On http start, null request");
            return;
        }
        if (!(request instanceof APMidasHttpRequestBase)) {
            APLog.e(TAG, "On http start, type error = " + request);
            return;
        }
        APMidasHttpRequestBase aPMidasHttpRequestBase = (APMidasHttpRequestBase) request;
        if (!aPMidasHttpRequestBase.isRequestWithIP()) {
            APLog.d(TAG, "On http start, not request with ip, no need to set custom verifier and ssl socket factory");
            return;
        }
        APLog.d(TAG, "On http start, set custom host name verifier and ssl socket factory");
        aPMidasHttpRequestBase.setCustomHostnameVerifier(new APMidasHostNameVerifier(GlobalData.singleton().NetCfg().getHost()));
        aPMidasHttpRequestBase.setCustomSSLSocketFactory(new APMidasTlsSniSocketFactory(GlobalData.singleton().NetCfg().getHost()));
        this.hasSet.set(true);
    }

    @Override // com.tencent.midas.http.core.HttpHandler
    public void onHttpEnd(Request request, Response response) {
        if (this.hasSet.get().booleanValue()) {
            APLog.d(TAG, "On http end, need reset host name verifier and ssl socket factory");
            this.hasSet.set(false);
            request.clearCustomHostnameVerifier();
            request.clearCustomSSLSocketFactory();
            return;
        }
        APLog.d(TAG, "On http end, no need reset host name verifier and ssl socket factory");
    }

    /* loaded from: classes.dex */
    static class APMidasTlsSniSocketFactory extends SSLSocketFactory {
        private final String currentHost;

        private APMidasTlsSniSocketFactory(String str) {
            this.currentHost = str;
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket() throws IOException {
            return SSLSocketFactory.getDefault().createSocket();
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i) throws IOException {
            return SSLSocketFactory.getDefault().createSocket(str, i);
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(String str, int i, InetAddress inetAddress, int i2) throws IOException {
            return SSLSocketFactory.getDefault().createSocket(str, i, inetAddress, i2);
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i) throws IOException {
            return SSLSocketFactory.getDefault().createSocket(inetAddress, i);
        }

        @Override // javax.net.SocketFactory
        public Socket createSocket(InetAddress inetAddress, int i, InetAddress inetAddress2, int i2) throws IOException {
            return SSLSocketFactory.getDefault().createSocket(inetAddress, i, inetAddress2, i2);
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getDefaultCipherSuites() {
            APLog.d(APHttpsIPDirectHandler.TAG, "SniSocketFactory, get default cipher suits");
            return new String[0];
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public String[] getSupportedCipherSuites() {
            APLog.d(APHttpsIPDirectHandler.TAG, "SniSocketFactory, get supports cipher suits");
            return new String[0];
        }

        @Override // javax.net.ssl.SSLSocketFactory
        public Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
            APLog.d(APHttpsIPDirectHandler.TAG, "SniSocketFactory, create delegate");
            String str2 = this.currentHost;
            if (TextUtils.isEmpty(str2)) {
                APLog.e(APHttpsIPDirectHandler.TAG, "SniSocketFactory, connection host header empty");
            } else {
                str = str2;
            }
            SSLCertificateSocketFactory sSLCertificateSocketFactory = (SSLCertificateSocketFactory) SSLCertificateSocketFactory.getDefault(0);
            SSLSocket sSLSocket = (SSLSocket) sSLCertificateSocketFactory.createSocket(socket, str, i, z);
            sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            if (Build.VERSION.SDK_INT >= 17) {
                sSLCertificateSocketFactory.setHostname(sSLSocket, str);
            } else {
                try {
                    sSLSocket.getClass().getMethod("setHostname", String.class).invoke(sSLSocket, str);
                } catch (Exception e) {
                    Log.e(APHttpsIPDirectHandler.TAG, "SNI not usable exception = " + e);
                }
            }
            return sSLSocket;
        }

        public boolean equals(Object obj) {
            APLog.d(APHttpsIPDirectHandler.TAG, "SniSocketFactory, equals called");
            if (obj != null && (obj instanceof APMidasTlsSniSocketFactory)) {
                return !TextUtils.isEmpty(this.currentHost) && this.currentHost.equals(((APMidasTlsSniSocketFactory) obj).currentHost);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    private static class APMidasHostNameVerifier implements HostnameVerifier {
        private String currentHost;

        private APMidasHostNameVerifier(String str) {
            this.currentHost = str;
            if (TextUtils.isEmpty(str)) {
                APLog.e(APHttpsIPDirectHandler.TAG, "New Host name verifier, host header empty!");
                return;
            }
            APLog.d(APHttpsIPDirectHandler.TAG, "New Host name verifier, host header = " + str);
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            boolean verify = HttpsURLConnection.getDefaultHostnameVerifier().verify(this.currentHost, sSLSession);
            if (verify) {
                APLog.d(APHttpsIPDirectHandler.TAG, "Host name verifier, host = " + str + ", host header = " + this.currentHost + ", verify result true");
            } else {
                APLog.e(APHttpsIPDirectHandler.TAG, "Host name verifier, host = " + str + ", host header = " + this.currentHost + ", verify result fail");
            }
            return verify;
        }

        public boolean equals(Object obj) {
            APLog.d(APHttpsIPDirectHandler.TAG, "Host name verifier, equals called");
            if (obj != null && (obj instanceof APMidasHostNameVerifier)) {
                return !TextUtils.isEmpty(this.currentHost) && this.currentHost.equals(((APMidasHostNameVerifier) obj).currentHost);
            }
            return false;
        }
    }
}
