package com.twitter.sdk.android.core.internal.oauth;

import a.a.a.a;
import a.m;
import com.amazonaws.http.HttpHeader;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.network.OkHttpClientHelper;
import java.io.IOException;
import okhttp3.ab;
import okhttp3.u;
import okhttp3.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class OAuthService {
    private static final String CLIENT_NAME = "TwitterAndroidSDK";
    private final TwitterApi api;
    private final m retrofit = new m.a().a(getApi().getBaseHostUrl()).a(new x.a().a(new u() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuthService.1
        @Override // okhttp3.u
        public ab intercept(u.a aVar) throws IOException {
            return aVar.a(aVar.a().e().a(HttpHeader.USER_AGENT, OAuthService.this.getUserAgent()).b());
        }
    }).a(OkHttpClientHelper.getCertificatePinner()).a()).a(a.a()).a();
    private final TwitterCore twitterCore;
    private final String userAgent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public OAuthService(TwitterCore twitterCore, TwitterApi twitterApi) {
        this.twitterCore = twitterCore;
        this.api = twitterApi;
        this.userAgent = TwitterApi.buildUserAgent(CLIENT_NAME, twitterCore.getVersion());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TwitterCore getTwitterCore() {
        return this.twitterCore;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TwitterApi getApi() {
        return this.api;
    }

    protected String getUserAgent() {
        return this.userAgent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m getRetrofit() {
        return this.retrofit;
    }
}
