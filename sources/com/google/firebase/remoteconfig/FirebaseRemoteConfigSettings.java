package com.google.firebase.remoteconfig;

import com.google.android.gms.internal.firebase_remote_config.zzeq;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigSettings {
    private final boolean zzjq;
    private final long zzjr;
    private final long zzjs;

    private FirebaseRemoteConfigSettings(Builder builder) {
        this.zzjq = builder.zzjq;
        this.zzjr = builder.zzjr;
        this.zzjs = builder.zzjs;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private boolean zzjq = false;
        private long zzjr = 5;
        private long zzjs = zzeq.zzkv;

        public Builder setDeveloperModeEnabled(boolean z) {
            this.zzjq = z;
            return this;
        }

        public Builder setFetchTimeoutInSeconds(long j) throws IllegalArgumentException {
            if (j < 0) {
                throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j)));
            }
            this.zzjr = j;
            return this;
        }

        public Builder setMinimumFetchIntervalInSeconds(long j) {
            if (j < 0) {
                StringBuilder sb = new StringBuilder(109);
                sb.append("Minimum interval between fetches has to be a non-negative number. ");
                sb.append(j);
                sb.append(" is an invalid argument");
                throw new IllegalArgumentException(sb.toString());
            }
            this.zzjs = j;
            return this;
        }

        public FirebaseRemoteConfigSettings build() {
            return new FirebaseRemoteConfigSettings(this);
        }
    }

    public boolean isDeveloperModeEnabled() {
        return this.zzjq;
    }

    public long getFetchTimeoutInSeconds() {
        return this.zzjr;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.zzjs;
    }

    public Builder toBuilder() {
        Builder builder = new Builder();
        builder.setDeveloperModeEnabled(isDeveloperModeEnabled());
        builder.setFetchTimeoutInSeconds(getFetchTimeoutInSeconds());
        builder.setMinimumFetchIntervalInSeconds(getMinimumFetchIntervalInSeconds());
        return builder;
    }
}
