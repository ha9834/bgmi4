package com.twitter.sdk.android.core.internal.oauth;

import com.amazonaws.services.s3.internal.Constants;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.internal.network.UrlUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import okio.ByteString;

/* loaded from: classes.dex */
class OAuth1aParameters {
    private static final SecureRandom RAND = new SecureRandom();
    private static final String SIGNATURE_METHOD = "HMAC-SHA1";
    private static final String VERSION = "1.0";
    private final TwitterAuthConfig authConfig;
    private final TwitterAuthToken authToken;
    private final String callback;
    private final String method;
    private final Map<String, String> postParams;
    private final String url;

    public OAuth1aParameters(TwitterAuthConfig twitterAuthConfig, TwitterAuthToken twitterAuthToken, String str, String str2, String str3, Map<String, String> map) {
        this.authConfig = twitterAuthConfig;
        this.authToken = twitterAuthToken;
        this.callback = str;
        this.method = str2;
        this.url = str3;
        this.postParams = map;
    }

    public String getAuthorizationHeader() {
        String nonce = getNonce();
        String timestamp = getTimestamp();
        return constructAuthorizationHeader(nonce, timestamp, calculateSignature(constructSignatureBase(nonce, timestamp)));
    }

    private String getNonce() {
        return String.valueOf(System.nanoTime()) + String.valueOf(Math.abs(RAND.nextLong()));
    }

    private String getTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    String constructSignatureBase(String str, String str2) {
        URI create = URI.create(this.url);
        TreeMap<String, String> queryParams = UrlUtils.getQueryParams(create, true);
        Map<String, String> map = this.postParams;
        if (map != null) {
            queryParams.putAll(map);
        }
        String str3 = this.callback;
        if (str3 != null) {
            queryParams.put(OAuthConstants.PARAM_CALLBACK, str3);
        }
        queryParams.put("oauth_consumer_key", this.authConfig.getConsumerKey());
        queryParams.put(OAuthConstants.PARAM_NONCE, str);
        queryParams.put(OAuthConstants.PARAM_SIGNATURE_METHOD, SIGNATURE_METHOD);
        queryParams.put(OAuthConstants.PARAM_TIMESTAMP, str2);
        TwitterAuthToken twitterAuthToken = this.authToken;
        if (twitterAuthToken != null && twitterAuthToken.token != null) {
            queryParams.put(OAuthConstants.PARAM_TOKEN, this.authToken.token);
        }
        queryParams.put(OAuthConstants.PARAM_VERSION, "1.0");
        return this.method.toUpperCase(Locale.ENGLISH) + '&' + UrlUtils.percentEncode(create.getScheme() + "://" + create.getHost() + create.getPath()) + '&' + getEncodedQueryParams(queryParams);
    }

    private String getEncodedQueryParams(TreeMap<String, String> treeMap) {
        StringBuilder sb = new StringBuilder();
        int size = treeMap.size();
        int i = 0;
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            sb.append(UrlUtils.percentEncode(UrlUtils.percentEncode(entry.getKey())));
            sb.append("%3D");
            sb.append(UrlUtils.percentEncode(UrlUtils.percentEncode(entry.getValue())));
            i++;
            if (i < size) {
                sb.append("%26");
            }
        }
        return sb.toString();
    }

    String calculateSignature(String str) {
        try {
            String signingKey = getSigningKey();
            byte[] bytes = str.getBytes(UrlUtils.UTF8);
            SecretKeySpec secretKeySpec = new SecretKeySpec(signingKey.getBytes(UrlUtils.UTF8), Constants.HMAC_SHA1_ALGORITHM);
            Mac mac = Mac.getInstance(Constants.HMAC_SHA1_ALGORITHM);
            mac.init(secretKeySpec);
            byte[] doFinal = mac.doFinal(bytes);
            return ByteString.a(doFinal, 0, doFinal.length).b();
        } catch (UnsupportedEncodingException e) {
            Twitter.getLogger().e("Twitter", "Failed to calculate signature", e);
            return "";
        } catch (InvalidKeyException e2) {
            Twitter.getLogger().e("Twitter", "Failed to calculate signature", e2);
            return "";
        } catch (NoSuchAlgorithmException e3) {
            Twitter.getLogger().e("Twitter", "Failed to calculate signature", e3);
            return "";
        }
    }

    private String getSigningKey() {
        TwitterAuthToken twitterAuthToken = this.authToken;
        return UrlUtils.urlEncode(this.authConfig.getConsumerSecret()) + '&' + UrlUtils.urlEncode(twitterAuthToken != null ? twitterAuthToken.secret : null);
    }

    String constructAuthorizationHeader(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder("OAuth");
        appendParameter(sb, OAuthConstants.PARAM_CALLBACK, this.callback);
        appendParameter(sb, "oauth_consumer_key", this.authConfig.getConsumerKey());
        appendParameter(sb, OAuthConstants.PARAM_NONCE, str);
        appendParameter(sb, OAuthConstants.PARAM_SIGNATURE, str3);
        appendParameter(sb, OAuthConstants.PARAM_SIGNATURE_METHOD, SIGNATURE_METHOD);
        appendParameter(sb, OAuthConstants.PARAM_TIMESTAMP, str2);
        TwitterAuthToken twitterAuthToken = this.authToken;
        appendParameter(sb, OAuthConstants.PARAM_TOKEN, twitterAuthToken != null ? twitterAuthToken.token : null);
        appendParameter(sb, OAuthConstants.PARAM_VERSION, "1.0");
        return sb.substring(0, sb.length() - 1);
    }

    private void appendParameter(StringBuilder sb, String str, String str2) {
        if (str2 != null) {
            sb.append(' ');
            sb.append(UrlUtils.percentEncode(str));
            sb.append("=\"");
            sb.append(UrlUtils.percentEncode(str2));
            sb.append("\",");
        }
    }
}
