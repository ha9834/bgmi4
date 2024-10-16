package com.gcloudsdk.apollo.apollovoice.httpclient;

import android.content.Context;
import com.gcloudsdk.apollo.ApolloVoiceLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public class HttpsUtils {
    private static String PATTERN_IP = "(\\d*\\.){3}\\d*";
    private static Context ctx;

    public static void setContext(Context context) {
        ctx = context;
    }

    public static boolean connnectWithIP(String str) {
        Pattern compile = Pattern.compile(PATTERN_IP);
        String host = getHost(str);
        if (host == null || !compile.matcher(host).find()) {
            return false;
        }
        ApolloVoiceLog.LogI("the url connect with ip: " + str);
        return true;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0149: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:112:0x0149 */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static javax.net.ssl.SSLSocketFactory getSocketFactory(java.lang.String r4) throws java.security.cert.CertificateException {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gcloudsdk.apollo.apollovoice.httpclient.HttpsUtils.getSocketFactory(java.lang.String):javax.net.ssl.SSLSocketFactory");
    }

    public static HostnameVerifier getHostNameVerify(String str) {
        final String host = getHost(str);
        if (host == null || host.length() == 0) {
            return null;
        }
        ApolloVoiceLog.LogI("url: " + str + " host: " + host);
        return new HostnameVerifier() { // from class: com.gcloudsdk.apollo.apollovoice.httpclient.HttpsUtils.1
            @Override // javax.net.ssl.HostnameVerifier
            public boolean verify(String str2, SSLSession sSLSession) {
                boolean z = str2.equalsIgnoreCase(host) || HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sSLSession);
                ApolloVoiceLog.LogI("hostname: " + str2 + " verify result: " + z);
                return z;
            }
        };
    }

    private static String getHost(String str) {
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
