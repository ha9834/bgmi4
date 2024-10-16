package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import com.twitter.sdk.android.core.models.User;

/* loaded from: classes.dex */
public class TwitterAuthClient {
    private static final String SCRIBE_ACTION = "impression";
    private static final String SCRIBE_CLIENT = "android";
    private static final String SCRIBE_COMPONENT = "";
    private static final String SCRIBE_ELEMENT = "";
    private static final String SCRIBE_LOGIN_PAGE = "login";
    private static final String SCRIBE_SECTION = "";
    private static final String SCRIBE_SHARE_EMAIL_PAGE = "shareemail";
    final TwitterAuthConfig authConfig;
    final AuthState authState;
    final SessionManager<TwitterSession> sessionManager;
    final TwitterCore twitterCore;

    /* loaded from: classes.dex */
    private static class AuthStateLazyHolder {
        private static final AuthState INSTANCE = new AuthState();

        private AuthStateLazyHolder() {
        }
    }

    public int getRequestCode() {
        return this.authConfig.getRequestCode();
    }

    public TwitterAuthClient() {
        this(TwitterCore.getInstance(), TwitterCore.getInstance().getAuthConfig(), TwitterCore.getInstance().getSessionManager(), AuthStateLazyHolder.INSTANCE);
    }

    TwitterAuthClient(TwitterCore twitterCore, TwitterAuthConfig twitterAuthConfig, SessionManager<TwitterSession> sessionManager, AuthState authState) {
        this.twitterCore = twitterCore;
        this.authState = authState;
        this.authConfig = twitterAuthConfig;
        this.sessionManager = sessionManager;
    }

    public void authorize(Activity activity, Callback<TwitterSession> callback) {
        if (activity == null) {
            throw new IllegalArgumentException("Activity must not be null.");
        }
        if (callback == null) {
            throw new IllegalArgumentException("Callback must not be null.");
        }
        if (activity.isFinishing()) {
            Twitter.getLogger().e("Twitter", "Cannot authorize, activity is finishing.", null);
        } else {
            handleAuthorize(activity, callback);
        }
    }

    private void handleAuthorize(Activity activity, Callback<TwitterSession> callback) {
        scribeAuthorizeImpression();
        CallbackWrapper callbackWrapper = new CallbackWrapper(this.sessionManager, callback);
        if (authorizeUsingSSO(activity, callbackWrapper) || authorizeUsingOAuth(activity, callbackWrapper)) {
            return;
        }
        callbackWrapper.failure(new TwitterAuthException("Authorize failed."));
    }

    public void cancelAuthorize() {
        this.authState.endAuthorize();
    }

    private boolean authorizeUsingSSO(Activity activity, CallbackWrapper callbackWrapper) {
        if (!SSOAuthHandler.isAvailable(activity)) {
            return false;
        }
        Twitter.getLogger().d("Twitter", "Using SSO");
        AuthState authState = this.authState;
        TwitterAuthConfig twitterAuthConfig = this.authConfig;
        return authState.beginAuthorize(activity, new SSOAuthHandler(twitterAuthConfig, callbackWrapper, twitterAuthConfig.getRequestCode()));
    }

    private boolean authorizeUsingOAuth(Activity activity, CallbackWrapper callbackWrapper) {
        Twitter.getLogger().d("Twitter", "Using OAuth");
        AuthState authState = this.authState;
        TwitterAuthConfig twitterAuthConfig = this.authConfig;
        return authState.beginAuthorize(activity, new OAuthHandler(twitterAuthConfig, callbackWrapper, twitterAuthConfig.getRequestCode()));
    }

    private void scribeAuthorizeImpression() {
        DefaultScribeClient scribeClient = getScribeClient();
        if (scribeClient == null) {
            return;
        }
        scribeClient.scribe(new EventNamespace.Builder().setClient("android").setPage("login").setSection("").setComponent("").setElement("").setAction(SCRIBE_ACTION).builder());
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        Twitter.getLogger().d("Twitter", "onActivityResult called with " + i + " " + i2);
        if (!this.authState.isAuthorizeInProgress()) {
            Twitter.getLogger().e("Twitter", "Authorize not in progress", null);
            return;
        }
        AuthHandler authHandler = this.authState.getAuthHandler();
        if (authHandler == null || !authHandler.handleOnActivityResult(i, i2, intent)) {
            return;
        }
        this.authState.endAuthorize();
    }

    public void requestEmail(TwitterSession twitterSession, final Callback<String> callback) {
        scribeRequestEmail();
        this.twitterCore.getApiClient(twitterSession).getAccountService().verifyCredentials(false, false, true).a(new Callback<User>() { // from class: com.twitter.sdk.android.core.identity.TwitterAuthClient.1
            @Override // com.twitter.sdk.android.core.Callback
            public void success(Result<User> result) {
                callback.success(new Result(result.data.email, null));
            }

            @Override // com.twitter.sdk.android.core.Callback
            public void failure(TwitterException twitterException) {
                callback.failure(twitterException);
            }
        });
    }

    protected DefaultScribeClient getScribeClient() {
        return TwitterCoreScribeClientHolder.getScribeClient();
    }

    private void scribeRequestEmail() {
        DefaultScribeClient scribeClient = getScribeClient();
        if (scribeClient == null) {
            return;
        }
        scribeClient.scribe(new EventNamespace.Builder().setClient("android").setPage(SCRIBE_SHARE_EMAIL_PAGE).setSection("").setComponent("").setElement("").setAction(SCRIBE_ACTION).builder());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class CallbackWrapper extends Callback<TwitterSession> {
        private final Callback<TwitterSession> callback;
        private final SessionManager<TwitterSession> sessionManager;

        CallbackWrapper(SessionManager<TwitterSession> sessionManager, Callback<TwitterSession> callback) {
            this.sessionManager = sessionManager;
            this.callback = callback;
        }

        @Override // com.twitter.sdk.android.core.Callback
        public void success(Result<TwitterSession> result) {
            Twitter.getLogger().d("Twitter", "Authorization completed successfully");
            this.sessionManager.setActiveSession(result.data);
            this.callback.success(result);
        }

        @Override // com.twitter.sdk.android.core.Callback
        public void failure(TwitterException twitterException) {
            Twitter.getLogger().e("Twitter", "Authorization completed with an error", twitterException);
            this.callback.failure(twitterException);
        }
    }
}
