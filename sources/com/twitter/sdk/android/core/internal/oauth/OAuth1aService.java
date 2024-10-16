package com.twitter.sdk.android.core.internal.oauth;

import a.b;
import a.b.i;
import a.b.o;
import a.b.t;
import android.net.Uri;
import com.tencent.connect.common.Constants;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.network.UrlUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
import okhttp3.ac;

/* loaded from: classes.dex */
public class OAuth1aService extends OAuthService {
    private static final String CALLBACK_URL = "twittersdk://callback";
    private static final String PARAM_SCREEN_NAME = "screen_name";
    private static final String PARAM_USER_ID = "user_id";
    private static final String RESOURCE_OAUTH = "oauth";
    OAuthApi api;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface OAuthApi {
        @o(a = "/oauth/access_token")
        b<ac> getAccessToken(@i(a = "Authorization") String str, @t(a = "oauth_verifier") String str2);

        @o(a = "/oauth/request_token")
        b<ac> getTempToken(@i(a = "Authorization") String str);
    }

    public OAuth1aService(TwitterCore twitterCore, TwitterApi twitterApi) {
        super(twitterCore, twitterApi);
        this.api = (OAuthApi) getRetrofit().a(OAuthApi.class);
    }

    public void requestTempToken(Callback<OAuthResponse> callback) {
        TwitterAuthConfig authConfig = getTwitterCore().getAuthConfig();
        this.api.getTempToken(new OAuth1aHeaders().getAuthorizationHeader(authConfig, null, buildCallbackUrl(authConfig), "POST", getTempTokenUrl(), null)).a(getCallbackWrapper(callback));
    }

    String getTempTokenUrl() {
        return getApi().getBaseHostUrl() + "/oauth/request_token";
    }

    public String buildCallbackUrl(TwitterAuthConfig twitterAuthConfig) {
        return Uri.parse(CALLBACK_URL).buildUpon().appendQueryParameter("version", getTwitterCore().getVersion()).appendQueryParameter(Constants.JumpUrlConstants.SRC_TYPE_APP, twitterAuthConfig.getConsumerKey()).build().toString();
    }

    public void requestAccessToken(Callback<OAuthResponse> callback, TwitterAuthToken twitterAuthToken, String str) {
        this.api.getAccessToken(new OAuth1aHeaders().getAuthorizationHeader(getTwitterCore().getAuthConfig(), twitterAuthToken, null, "POST", getAccessTokenUrl(), null), str).a(getCallbackWrapper(callback));
    }

    String getAccessTokenUrl() {
        return getApi().getBaseHostUrl() + "/oauth/access_token";
    }

    public String getAuthorizeUrl(TwitterAuthToken twitterAuthToken) {
        return getApi().buildUponBaseHostUrl(RESOURCE_OAUTH, "authorize").appendQueryParameter(OAuthConstants.PARAM_TOKEN, twitterAuthToken.token).build().toString();
    }

    public static OAuthResponse parseAuthResponse(String str) {
        TreeMap<String, String> queryParams = UrlUtils.getQueryParams(str, false);
        String str2 = queryParams.get(OAuthConstants.PARAM_TOKEN);
        String str3 = queryParams.get(OAuthConstants.PARAM_TOKEN_SECRET);
        String str4 = queryParams.get(PARAM_SCREEN_NAME);
        long parseLong = queryParams.containsKey("user_id") ? Long.parseLong(queryParams.get("user_id")) : 0L;
        if (str2 == null || str3 == null) {
            return null;
        }
        return new OAuthResponse(new TwitterAuthToken(str2, str3), str4, parseLong);
    }

    Callback<ac> getCallbackWrapper(final Callback<OAuthResponse> callback) {
        return new Callback<ac>() { // from class: com.twitter.sdk.android.core.internal.oauth.OAuth1aService.1
            @Override // com.twitter.sdk.android.core.Callback
            public void success(Result<ac> result) {
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = null;
                try {
                    try {
                        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(result.data.c()));
                        while (true) {
                            try {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                } else {
                                    sb.append(readLine);
                                }
                            } catch (Throwable th) {
                                th = th;
                                bufferedReader = bufferedReader2;
                                if (bufferedReader != null) {
                                    bufferedReader.close();
                                }
                                throw th;
                            }
                        }
                        bufferedReader2.close();
                        String sb2 = sb.toString();
                        OAuthResponse parseAuthResponse = OAuth1aService.parseAuthResponse(sb2);
                        if (parseAuthResponse == null) {
                            callback.failure(new TwitterAuthException("Failed to parse auth response: " + sb2));
                            return;
                        }
                        callback.success(new Result(parseAuthResponse, null));
                    } catch (Throwable th2) {
                        th = th2;
                    }
                } catch (IOException e) {
                    callback.failure(new TwitterAuthException(e.getMessage(), e));
                }
            }

            @Override // com.twitter.sdk.android.core.Callback
            public void failure(TwitterException twitterException) {
                callback.failure(twitterException);
            }
        };
    }
}
