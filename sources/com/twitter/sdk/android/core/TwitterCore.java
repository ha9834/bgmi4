package com.twitter.sdk.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.twitter.sdk.android.core.GuestSession;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.core.internal.SessionMonitor;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.TwitterSessionVerifier;
import com.twitter.sdk.android.core.internal.oauth.OAuth2Service;
import com.twitter.sdk.android.core.internal.persistence.PreferenceStoreImpl;
import com.twitter.sdk.android.core.internal.scribe.TwitterCoreScribeClientHolder;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class TwitterCore {
    static final String KIT_SCRIBE_NAME = "TwitterCore";
    static final String PREF_KEY_ACTIVE_GUEST_SESSION = "active_guestsession";
    static final String PREF_KEY_ACTIVE_TWITTER_SESSION = "active_twittersession";
    static final String PREF_KEY_GUEST_SESSION = "guestsession";
    static final String PREF_KEY_TWITTER_SESSION = "twittersession";
    static final String SESSION_PREF_FILE_NAME = "session_store";
    public static final String TAG = "Twitter";

    @SuppressLint({"StaticFieldLeak"})
    static volatile TwitterCore instance;
    private final ConcurrentHashMap<Session, TwitterApiClient> apiClients;
    private final TwitterAuthConfig authConfig;
    private final Context context;
    private volatile TwitterApiClient guestClient;
    SessionManager<GuestSession> guestSessionManager;
    private volatile GuestSessionProvider guestSessionProvider;
    SessionMonitor<TwitterSession> sessionMonitor;
    SessionManager<TwitterSession> twitterSessionManager;

    public String getIdentifier() {
        return "com.twitter.sdk.android:twitter-core";
    }

    public String getVersion() {
        return "3.1.1.9";
    }

    TwitterCore(TwitterAuthConfig twitterAuthConfig) {
        this(twitterAuthConfig, new ConcurrentHashMap(), null);
    }

    TwitterCore(TwitterAuthConfig twitterAuthConfig, ConcurrentHashMap<Session, TwitterApiClient> concurrentHashMap, TwitterApiClient twitterApiClient) {
        this.authConfig = twitterAuthConfig;
        this.apiClients = concurrentHashMap;
        this.guestClient = twitterApiClient;
        this.context = Twitter.getInstance().getContext(getIdentifier());
        this.twitterSessionManager = new PersistedSessionManager(new PreferenceStoreImpl(this.context, SESSION_PREF_FILE_NAME), new TwitterSession.Serializer(), PREF_KEY_ACTIVE_TWITTER_SESSION, PREF_KEY_TWITTER_SESSION);
        this.guestSessionManager = new PersistedSessionManager(new PreferenceStoreImpl(this.context, SESSION_PREF_FILE_NAME), new GuestSession.Serializer(), PREF_KEY_ACTIVE_GUEST_SESSION, PREF_KEY_GUEST_SESSION);
        this.sessionMonitor = new SessionMonitor<>(this.twitterSessionManager, Twitter.getInstance().getExecutorService(), new TwitterSessionVerifier());
    }

    public static TwitterCore getInstance() {
        if (instance == null) {
            synchronized (TwitterCore.class) {
                if (instance == null) {
                    instance = new TwitterCore(Twitter.getInstance().getTwitterAuthConfig());
                    Twitter.getInstance().getExecutorService().execute(new Runnable() { // from class: com.twitter.sdk.android.core.TwitterCore.1
                        @Override // java.lang.Runnable
                        public void run() {
                            TwitterCore.instance.doInBackground();
                        }
                    });
                }
            }
        }
        return instance;
    }

    public TwitterAuthConfig getAuthConfig() {
        return this.authConfig;
    }

    void doInBackground() {
        this.twitterSessionManager.getActiveSession();
        this.guestSessionManager.getActiveSession();
        getGuestSessionProvider();
        setUpScribeClient();
        this.sessionMonitor.monitorActivityLifecycle(Twitter.getInstance().getActivityLifecycleManager());
    }

    private void setUpScribeClient() {
        TwitterCoreScribeClientHolder.initialize(this.context, getSessionManager(), getGuestSessionProvider(), Twitter.getInstance().getIdManager(), KIT_SCRIBE_NAME, getVersion());
    }

    public SessionManager<TwitterSession> getSessionManager() {
        return this.twitterSessionManager;
    }

    public GuestSessionProvider getGuestSessionProvider() {
        if (this.guestSessionProvider == null) {
            createGuestSessionProvider();
        }
        return this.guestSessionProvider;
    }

    private synchronized void createGuestSessionProvider() {
        if (this.guestSessionProvider == null) {
            this.guestSessionProvider = new GuestSessionProvider(new OAuth2Service(this, new TwitterApi()), this.guestSessionManager);
        }
    }

    public TwitterApiClient getApiClient() {
        TwitterSession activeSession = this.twitterSessionManager.getActiveSession();
        if (activeSession == null) {
            return getGuestApiClient();
        }
        return getApiClient(activeSession);
    }

    public TwitterApiClient getApiClient(TwitterSession twitterSession) {
        if (!this.apiClients.containsKey(twitterSession)) {
            this.apiClients.putIfAbsent(twitterSession, new TwitterApiClient(twitterSession));
        }
        return this.apiClients.get(twitterSession);
    }

    public void addGuestApiClient(TwitterApiClient twitterApiClient) {
        if (this.guestClient == null) {
            createGuestClient(twitterApiClient);
        }
    }

    public void addApiClient(TwitterSession twitterSession, TwitterApiClient twitterApiClient) {
        if (this.apiClients.containsKey(twitterSession)) {
            return;
        }
        this.apiClients.putIfAbsent(twitterSession, twitterApiClient);
    }

    public TwitterApiClient getGuestApiClient() {
        if (this.guestClient == null) {
            createGuestClient();
        }
        return this.guestClient;
    }

    private synchronized void createGuestClient() {
        if (this.guestClient == null) {
            this.guestClient = new TwitterApiClient();
        }
    }

    private synchronized void createGuestClient(TwitterApiClient twitterApiClient) {
        if (this.guestClient == null) {
            this.guestClient = twitterApiClient;
        }
    }
}
