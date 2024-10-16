package com.twitter.sdk.android.core.internal.oauth;

import a.b;
import a.b.c;
import a.b.e;
import a.b.i;
import a.b.k;
import a.b.o;
import com.facebook.internal.security.CertificateUtil;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.network.UrlUtils;
import okio.ByteString;

/* loaded from: classes.dex */
public class OAuth2Service extends OAuthService {
    OAuth2Api api;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OAuth2Api {
        @k(a = {"Content-Type: application/x-www-form-urlencoded;charset=UTF-8"})
        @o(a = "/oauth2/token")
        @e
        b<OAuth2Token> getAppAuthToken(@i(a = "Authorization") String str, @c(a = "grant_type") String str2);

        @o(a = "/1.1/guest/activate.json")
        b<GuestTokenResponse> getGuestToken(@i(a = "Authorization") String str);
    }

    public OAuth2Service(TwitterCore twitterCore, TwitterApi twitterApi) {
        super(twitterCore, twitterApi);
        this.api = (OAuth2Api) getRetrofit().a(OAuth2Api.class);
    }

    public void requestGuestAuthToken(final Callback<GuestAuthToken> callback) {
        requestAppAuthToken(new Callback<OAuth2Token>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuth2Service.1
            @Override // com.twitter.sdk.android.core.Callback
            public void success(Result<OAuth2Token> result) {
                final OAuth2Token oAuth2Token = result.data;
                OAuth2Service.this.requestGuestToken(new Callback<GuestTokenResponse>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuth2Service.1.1
                    @Override // com.twitter.sdk.android.core.Callback
                    public void success(Result<GuestTokenResponse> result2) {
                        callback.success(new Result(new GuestAuthToken(oAuth2Token.getTokenType(), oAuth2Token.getAccessToken(), result2.data.guestToken), null));
                    }

                    @Override // com.twitter.sdk.android.core.Callback
                    public void failure(TwitterException twitterException) {
                        Twitter.getLogger().e("Twitter", "Your app may not allow guest auth. Please talk to us regarding upgrading your consumer key.", twitterException);
                        callback.failure(twitterException);
                    }
                }, oAuth2Token);
            }

            @Override // com.twitter.sdk.android.core.Callback
            public void failure(TwitterException twitterException) {
                Twitter.getLogger().e("Twitter", "Failed to get app auth token", twitterException);
                Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.failure(twitterException);
                }
            }
        });
    }

    void requestAppAuthToken(Callback<OAuth2Token> callback) {
        this.api.getAppAuthToken(getAuthHeader(), OAuthConstants.GRANT_TYPE_CLIENT_CREDENTIALS).a(callback);
    }

    void requestGuestToken(Callback<GuestTokenResponse> callback, OAuth2Token oAuth2Token) {
        this.api.getGuestToken(getAuthorizationHeader(oAuth2Token)).a(callback);
    }

    private String getAuthorizationHeader(OAuth2Token oAuth2Token) {
        return "Bearer " + oAuth2Token.getAccessToken();
    }

    private String getAuthHeader() {
        TwitterAuthConfig authConfig = getTwitterCore().getAuthConfig();
        return "Basic " + ByteString.a(UrlUtils.percentEncode(authConfig.getConsumerKey()) + CertificateUtil.DELIMITER + UrlUtils.percentEncode(authConfig.getConsumerSecret())).b();
    }
}
