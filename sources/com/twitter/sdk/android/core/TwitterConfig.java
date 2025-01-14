package com.twitter.sdk.android.core;

import android.content.Context;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class TwitterConfig {
    final Context context;
    final Boolean debug;
    final ExecutorService executorService;
    final Logger logger;
    final TwitterAuthConfig twitterAuthConfig;

    private TwitterConfig(Context context, Logger logger, TwitterAuthConfig twitterAuthConfig, ExecutorService executorService, Boolean bool) {
        this.context = context;
        this.logger = logger;
        this.twitterAuthConfig = twitterAuthConfig;
        this.executorService = executorService;
        this.debug = bool;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private final Context context;
        private Boolean debug;
        private ExecutorService executorService;
        private Logger logger;
        private TwitterAuthConfig twitterAuthConfig;

        public Builder(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.context = context.getApplicationContext();
        }

        public Builder logger(Logger logger) {
            if (logger == null) {
                throw new IllegalArgumentException("Logger must not be null.");
            }
            this.logger = logger;
            return this;
        }

        public Builder twitterAuthConfig(TwitterAuthConfig twitterAuthConfig) {
            if (twitterAuthConfig == null) {
                throw new IllegalArgumentException("TwitterAuthConfig must not be null.");
            }
            this.twitterAuthConfig = twitterAuthConfig;
            return this;
        }

        public Builder executorService(ExecutorService executorService) {
            if (executorService == null) {
                throw new IllegalArgumentException("ExecutorService must not be null.");
            }
            this.executorService = executorService;
            return this;
        }

        public Builder debug(boolean z) {
            this.debug = Boolean.valueOf(z);
            return this;
        }

        public TwitterConfig build() {
            return new TwitterConfig(this.context, this.logger, this.twitterAuthConfig, this.executorService, this.debug);
        }
    }
}
