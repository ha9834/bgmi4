package com.tencent.imsdk.android.login.twitter;

import a.l;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.adjust.sdk.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.login.IMSDKLoginResult;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.IMSDKProxyActivity;
import com.tencent.imsdk.android.base.login.IMSDKLoginBase;
import com.tencent.imsdk.android.tools.DigestUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.twitterweb.TwitterWebActivity;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.identity.TwitterAuthClient;
import com.twitter.sdk.android.core.internal.oauth.OAuthConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

/* loaded from: classes.dex */
public class TwitterLogin extends IMSDKLoginBase {
    private static final String IMSDK_TWITTER_KEY = "TWITTER_CONSUMER_KEY";
    private static final String IMSDK_TWITTER_LOGIN_USING_WEB = "IMSDK_TWITTER_LOGIN_USING_WEB";
    private static final String IMSDK_TWITTER_SECRET = "TWITTER_CONSUMER_SECRET";
    private static final String IMSDK_TWITTER_WEB_LOGIN_URL = "IMSDK_TWITTER_WEB_LOGIN_URL";
    private static final int TWITTER_CHANNEL_ID = 35;
    private static final int TWITTER_WEB_REQUEST_CODE = 1;
    private String TWITTER_WEB_SUB_CHANNEL;
    private boolean isWebLogin;

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public int getChannelId() {
        return 35;
    }

    /* loaded from: classes.dex */
    static class TwitterWebSession {
        private static String webOAuthToken = "";
        private static String webOAuthTokenSecret = "";
        private static String webUserId = "";
        private static String webUserName = "";

        TwitterWebSession() {
        }

        static boolean isValid() {
            return (T.ckIsEmpty(webOAuthToken) || T.ckIsEmpty(webOAuthTokenSecret) || T.ckIsEmpty(webUserId)) ? false : true;
        }

        static void setSession(String str, String str2, String str3, String str4) {
            webOAuthToken = str;
            webOAuthTokenSecret = str2;
            webUserName = str4;
            webUserId = str3;
        }

        static void clearSession() {
            webUserId = "";
            webUserName = "";
            webOAuthTokenSecret = "";
            webOAuthToken = "";
        }
    }

    public TwitterLogin(Context context) {
        super(context);
        this.TWITTER_WEB_SUB_CHANNEL = "WEB";
        this.isWebLogin = false;
        Twitter.initialize(getTwitterConfig(getTwitterKey(), getTwitterSecret()));
        this.mSTBuilder = new InnerStat.Builder(context, com.twitter.sdk.android.core.BuildConfig.VERSION_NAME, com.twitter.sdk.android.core.BuildConfig.VERSION_NAME);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public boolean isChannelLogin() {
        TwitterAuthToken authToken;
        if (this.isWebLogin) {
            return TwitterWebSession.isValid();
        }
        TwitterSession activeSession = TwitterCore.getInstance().getSessionManager().getActiveSession();
        return (activeSession == null || (authToken = activeSession.getAuthToken()) == null || authToken.isExpired()) ? false : true;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void login2Channel(IMSDKLoginBase.LoginAction loginAction, String str, final IMSDKListener<Map<String, String>> iMSDKListener, Object... objArr) {
        TwitterAuthToken authToken;
        IMLogger.d("twitter login start : " + str);
        boolean orMetaData = IMSDKConfig.getOrMetaData(IMSDK_TWITTER_LOGIN_USING_WEB, IMSDK_TWITTER_LOGIN_USING_WEB, false);
        boolean z = str != null && str.equalsIgnoreCase(this.TWITTER_WEB_SUB_CHANNEL);
        if (orMetaData || z) {
            this.isWebLogin = true;
            TwitterWebSession.clearSession();
            String orMetaData2 = IMSDKConfig.getOrMetaData(IMSDK_TWITTER_WEB_LOGIN_URL, IMSDK_TWITTER_WEB_LOGIN_URL);
            if (T.ckIsEmpty(orMetaData2)) {
                if (iMSDKListener != null) {
                    iMSDKListener.onResult(new IMSDKResult(13, -1, "need twitter login url configuration IMSDK_TWITTER_WEB_LOGIN_URL"));
                    return;
                }
                return;
            }
            String concat = orMetaData2.concat("?gameid=").concat(String.valueOf(IMSDKConfig.getOrMetaData(IR.meta.GAME_ID, IR.meta.GAME_ID, 0)));
            IMLogger.d("twitter web login with url : " + concat);
            final Intent intent = new Intent(this.mCurCtx, (Class<?>) TwitterWebActivity.class);
            intent.putExtra("url", concat);
            IMSDKProxyActivity.registerLifeCycle(this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.twitter.TwitterLogin.1
                boolean bActivityCallbackFlag = false;

                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                protected void onActivityCreate(Bundle bundle, Activity activity) {
                    if (TwitterLogin.this.mSTBuilder != null) {
                        TwitterLogin.this.mSTBuilder.setMethod("login twitter").create().reportEvent();
                    }
                    activity.startActivityForResult(intent, 1);
                }

                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                protected boolean onActivityResult(int i, int i2, Intent intent2) {
                    if (i == 1) {
                        this.bActivityCallbackFlag = true;
                        if (intent2 != null) {
                            int intExtra = intent2.getIntExtra("code", -1);
                            if (intExtra == 0) {
                                String stringExtra = intent2.getStringExtra("user_id");
                                String stringExtra2 = intent2.getStringExtra("screen_name");
                                IMLogger.d("TwitterWeb success data, userId : " + stringExtra + ", userName : " + stringExtra2);
                                String stringExtra3 = intent2.getStringExtra(OAuthConstants.PARAM_TOKEN);
                                String stringExtra4 = intent2.getStringExtra(OAuthConstants.PARAM_TOKEN_SECRET);
                                TwitterWebSession.setSession(stringExtra3, stringExtra4, stringExtra, stringExtra2);
                                if (!T.ckIsEmpty(stringExtra3) && !T.ckIsEmpty(stringExtra4)) {
                                    TwitterLogin.this.fillParamsWithAccessToken(iMSDKListener, stringExtra3, stringExtra4);
                                    return true;
                                }
                            } else {
                                String stringExtra5 = intent2.getStringExtra("msg");
                                iMSDKListener.onResult(new IMSDKLoginResult(9999, "twitterWeb login fail", intExtra, stringExtra5));
                                IMLogger.d("TwitterWeb fail with code : " + intExtra + ", msg : " + stringExtra5);
                            }
                        }
                        if (i2 == 0) {
                            iMSDKListener.onResult(new IMSDKResult(2, -1, "activity comes back with cancel"));
                        } else {
                            iMSDKListener.onResult(new IMSDKResult(9999, -1, "twitter web login return no data"));
                        }
                    }
                    return true;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                public void onActivityDestroy() {
                    super.onActivityDestroy();
                    if (this.bActivityCallbackFlag) {
                        return;
                    }
                    iMSDKListener.onResult(new IMSDKLoginResult(2, 2, "activity destroyed with out twitter callback"));
                }
            });
            return;
        }
        this.isWebLogin = false;
        TwitterSession activeSession = TwitterCore.getInstance().getSessionManager().getActiveSession();
        if (activeSession != null && (authToken = activeSession.getAuthToken()) != null && !authToken.isExpired()) {
            IMLogger.d("twitter already login.");
            fillParamsWithAccessToken(iMSDKListener, authToken.token, authToken.secret);
        } else {
            IMSDKProxyActivity.registerLifeCycle(this.mCurCtx, new IMSDKProxyActivity.LifeCycleCallback() { // from class: com.tencent.imsdk.android.login.twitter.TwitterLogin.2
                private TwitterAuthClient mTwitterAuthClient = null;
                boolean bActivityCallbackFlag = false;

                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                protected void onActivityCreate(Bundle bundle, final Activity activity) {
                    if (TwitterLogin.this.mSTBuilder != null) {
                        TwitterLogin.this.mSTBuilder.setMethod("login twitter").create().reportEvent();
                    }
                    this.mTwitterAuthClient = new TwitterAuthClient();
                    this.mTwitterAuthClient.authorize(activity, new Callback<TwitterSession>() { // from class: com.tencent.imsdk.android.login.twitter.TwitterLogin.2.1
                        @Override // com.twitter.sdk.android.core.Callback
                        public void success(Result<TwitterSession> result) {
                            l lVar = result.response;
                            StringBuilder sb = new StringBuilder();
                            sb.append("success response = ");
                            sb.append(lVar != null ? lVar.toString() : "NULL");
                            IMLogger.d(sb.toString());
                            TwitterSession twitterSession = result.data;
                            if (twitterSession != null) {
                                IMLogger.d("success data, userId = " + twitterSession.getUserId() + ", userName = " + twitterSession.getUserName());
                                TwitterAuthToken authToken2 = twitterSession.getAuthToken();
                                if (authToken2 != null) {
                                    TwitterLogin.this.fillParamsWithAccessToken(iMSDKListener, authToken2.token, authToken2.secret);
                                    return;
                                }
                            }
                            IMLogger.w("twitter login success, but return data TwitterSession | TwitterAuthToken error", new Object[0]);
                            iMSDKListener.onResult(new IMSDKLoginResult(9999, "", 11, "twitter login success, but return data TwitterSession | TwitterAuthToken error"));
                        }

                        @Override // com.twitter.sdk.android.core.Callback
                        public void failure(TwitterException twitterException) {
                            IMLogger.w("twitter login failure, exception = " + twitterException.getMessage(), new Object[0]);
                            iMSDKListener.onResult(new IMSDKLoginResult(9999, "", -1, "twitter login failure, exception = " + twitterException.getMessage()));
                            try {
                                activity.finish();
                            } catch (Exception e) {
                                IMLogger.w("finish proxy activity failed : " + e.getMessage(), new Object[0]);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                protected boolean onActivityResult(int i, int i2, Intent intent2) {
                    this.bActivityCallbackFlag = true;
                    StringBuilder sb = new StringBuilder();
                    sb.append("requestCode = ");
                    sb.append(i);
                    sb.append(", resultCode = ");
                    sb.append(i2);
                    sb.append(", data = ");
                    sb.append(intent2 != null ? intent2.toString() : "NULL");
                    IMLogger.d(sb.toString());
                    if (i == this.mTwitterAuthClient.getRequestCode()) {
                        this.mTwitterAuthClient.onActivityResult(i, i2, intent2);
                    }
                    return true;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.tencent.imsdk.android.base.IMSDKProxyActivity.LifeCycleCallback
                public void onActivityDestroy() {
                    super.onActivityDestroy();
                    TwitterAuthClient twitterAuthClient = this.mTwitterAuthClient;
                    if (twitterAuthClient != null) {
                        twitterAuthClient.cancelAuthorize();
                    }
                    if (this.bActivityCallbackFlag) {
                        return;
                    }
                    iMSDKListener.onResult(new IMSDKLoginResult(2, 2, "activity destroyed with out twitter callback"));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fillParamsWithAccessToken(IMSDKListener<Map<String, String>> iMSDKListener, String str, String str2) {
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("oauthToken", str);
        sortableMap.put("oauthTokenSecret", str2);
        sortableMap.put("iChannel", String.valueOf(35));
        iMSDKListener.onNotify(sortableMap);
    }

    private String getTwitterKey() {
        return DigestUtils.decryptAES(IMSDKConfig.getOrMetaData(IMSDK_TWITTER_KEY, IMSDK_TWITTER_KEY), getSignMd5Str());
    }

    private String getTwitterSecret() {
        return DigestUtils.decryptAES(IMSDKConfig.getOrMetaData(IMSDK_TWITTER_SECRET, IMSDK_TWITTER_SECRET), getSignMd5Str());
    }

    private String encryptionMD5(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.reset();
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            for (int i = 0; i < digest.length; i++) {
                if (Integer.toHexString(digest[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED));
                }
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private String getSignMd5Str() {
        try {
            return encryptionMD5(T.mGlobalActivityUpToDate.getPackageManager().getPackageInfo(T.mGlobalActivityUpToDate.getPackageName(), 64).signatures[0].toByteArray());
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    private TwitterConfig getTwitterConfig(String str, String str2) {
        TwitterConfig.Builder builder = new TwitterConfig.Builder(T.mGlobalActivityUpToDate);
        builder.debug(true);
        IMLogger.d("twitter config, key : " + str + ", secret : " + str2);
        builder.twitterAuthConfig(new TwitterAuthConfig(str, str2));
        return builder.build();
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void addExtraBindParams(Map<String, String> map) {
        TwitterAuthToken authToken;
        if (this.isWebLogin && TwitterWebSession.isValid()) {
            map.put("oauthToken", TwitterWebSession.webOAuthToken);
            map.put("oauthTokenSecret", TwitterWebSession.webOAuthTokenSecret);
            return;
        }
        TwitterSession activeSession = TwitterCore.getInstance().getSessionManager().getActiveSession();
        if (activeSession == null || (authToken = activeSession.getAuthToken()) == null || authToken.isExpired()) {
            return;
        }
        map.put("oauthToken", authToken.token);
        map.put("oauthTokenSecret", authToken.secret);
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public IMSDKLoginResult modifyLoginResultAsChannel(IMSDKLoginResult iMSDKLoginResult) {
        if (this.isWebLogin && TwitterWebSession.isValid()) {
            iMSDKLoginResult.channelUserId = TwitterWebSession.webUserId;
            iMSDKLoginResult.guidUserNick = TwitterWebSession.webUserName;
        } else {
            TwitterSession activeSession = TwitterCore.getInstance().getSessionManager().getActiveSession();
            if (activeSession != null) {
                TwitterAuthToken authToken = activeSession.getAuthToken();
                iMSDKLoginResult.channelUserId = String.valueOf(activeSession.getUserId());
                iMSDKLoginResult.guidUserNick = activeSession.getUserName();
                if (authToken != null && !authToken.isExpired()) {
                    iMSDKLoginResult.channelToken = authToken.token;
                }
            }
        }
        return iMSDKLoginResult;
    }

    @Override // com.tencent.imsdk.android.base.login.IMSDKLoginBase
    public void logout(IMSDKResultListener<IMSDKResult> iMSDKResultListener) {
        if (this.isWebLogin) {
            TwitterWebSession.clearSession();
            this.isWebLogin = false;
        } else {
            TwitterCore.getInstance().getSessionManager().clearActiveSession();
        }
        super.logout(iMSDKResultListener);
    }
}
