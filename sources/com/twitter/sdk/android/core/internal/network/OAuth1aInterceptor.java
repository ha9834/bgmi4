package com.twitter.sdk.android.core.internal.network;

import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aHeaders;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.q;
import okhttp3.t;
import okhttp3.u;
import okhttp3.z;

/* loaded from: classes.dex */
public class OAuth1aInterceptor implements u {
    final TwitterAuthConfig authConfig;
    final Session<? extends TwitterAuthToken> session;

    public OAuth1aInterceptor(Session<? extends TwitterAuthToken> session, TwitterAuthConfig twitterAuthConfig) {
        this.session = session;
        this.authConfig = twitterAuthConfig;
    }

    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        z a2 = aVar.a();
        z b = a2.e().a(urlWorkaround(a2.a())).b();
        return aVar.a(b.e().a("Authorization", getAuthorizationHeader(b)).b());
    }

    t urlWorkaround(t tVar) {
        t.a e = tVar.p().e(null);
        int m = tVar.m();
        for (int i = 0; i < m; i++) {
            e.b(UrlUtils.percentEncode(tVar.a(i)), UrlUtils.percentEncode(tVar.b(i)));
        }
        return e.c();
    }

    String getAuthorizationHeader(z zVar) throws IOException {
        return new OAuth1aHeaders().getAuthorizationHeader(this.authConfig, this.session.getAuthToken(), null, zVar.b(), zVar.a().toString(), getPostParams(zVar));
    }

    Map<String, String> getPostParams(z zVar) throws IOException {
        HashMap hashMap = new HashMap();
        if ("POST".equals(zVar.b().toUpperCase(Locale.US))) {
            aa d = zVar.d();
            if (d instanceof q) {
                q qVar = (q) d;
                for (int i = 0; i < qVar.a(); i++) {
                    hashMap.put(qVar.a(i), qVar.c(i));
                }
            }
        }
        return hashMap;
    }
}
