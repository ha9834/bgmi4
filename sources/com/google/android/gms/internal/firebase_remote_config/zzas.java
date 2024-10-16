package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.Arrays;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public final class zzas extends zzag {
    private static final String[] b;
    private final zzap c;
    private final SSLSocketFactory d;
    private final HostnameVerifier e;

    public zzas() {
        this(null, null, null);
    }

    private zzas(zzap zzapVar, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        zzao zzaoVar;
        if (System.getProperty("com.google.api.client.should_use_proxy") != null) {
            zzaoVar = new zzao(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(System.getProperty("https.proxyHost"), Integer.parseInt(System.getProperty("https.proxyPort")))));
        } else {
            zzaoVar = new zzao();
        }
        this.c = zzaoVar;
        this.d = null;
        this.e = null;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzag
    public final boolean zzz(String str) {
        return Arrays.binarySearch(b, str) >= 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_remote_config.zzag
    public final /* synthetic */ zzaj a(String str, String str2) throws IOException {
        Object[] objArr = {str};
        if (!zzz(str)) {
            throw new IllegalArgumentException(zzdy.zza("HTTP method %s not supported", objArr));
        }
        HttpURLConnection zza = this.c.zza(new URL(str2));
        zza.setRequestMethod(str);
        boolean z = zza instanceof HttpsURLConnection;
        return new b(zza);
    }

    static {
        String[] strArr = {"DELETE", "GET", "HEAD", "OPTIONS", "POST", "PUT", "TRACE"};
        b = strArr;
        Arrays.sort(strArr);
    }
}
