package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.TwitterApiClient;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.scribe.DefaultScribeClient;
import com.twitter.sdk.android.core.internal.scribe.EventNamespace;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import com.twitter.sdk.android.core.services.AccountService;
import java.io.IOException;

/* loaded from: classes.dex */
public class TwitterSessionVerifier implements SessionVerifier<TwitterSession> {
    static final String SCRIBE_ACTION = "impression";
    static final String SCRIBE_CLIENT = "android";
    static final String SCRIBE_COMPONENT = "";
    static final String SCRIBE_ELEMENT = "";
    static final String SCRIBE_PAGE = "credentials";
    static final String SCRIBE_SECTION = "";
    private final AccountServiceProvider accountServiceProvider;
    private final DefaultScribeClient scribeClient;

    public TwitterSessionVerifier() {
        this.accountServiceProvider = new AccountServiceProvider();
        this.scribeClient = TwitterCoreScribeClientHolder.getScribeClient();
    }

    TwitterSessionVerifier(AccountServiceProvider accountServiceProvider, DefaultScribeClient defaultScribeClient) {
        this.accountServiceProvider = accountServiceProvider;
        this.scribeClient = defaultScribeClient;
    }

    @Override // com.twitter.sdk.android.core.internal.SessionVerifier
    public void verifySession(TwitterSession twitterSession) {
        AccountService accountService = this.accountServiceProvider.getAccountService(twitterSession);
        try {
            scribeVerifySession();
            accountService.verifyCredentials(true, false, false).a();
        } catch (IOException | RuntimeException unused) {
        }
    }

    private void scribeVerifySession() {
        if (this.scribeClient == null) {
            return;
        }
        this.scribeClient.scribe(new EventNamespace.Builder().setClient("android").setPage(SCRIBE_PAGE).setSection("").setComponent("").setElement("").setAction(SCRIBE_ACTION).builder());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class AccountServiceProvider {
        protected AccountServiceProvider() {
        }

        public AccountService getAccountService(TwitterSession twitterSession) {
            return new TwitterApiClient(twitterSession).getAccountService();
        }
    }
}
