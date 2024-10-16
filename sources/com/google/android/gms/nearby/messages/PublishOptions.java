package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzbq;

/* loaded from: classes2.dex */
public final class PublishOptions {
    public static final PublishOptions DEFAULT = new Builder().build();

    /* renamed from: a, reason: collision with root package name */
    private final Strategy f4984a;
    private final PublishCallback b;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Strategy f4985a = Strategy.DEFAULT;
        private PublishCallback b;

        public PublishOptions build() {
            return new PublishOptions(this.f4985a, this.b);
        }

        public Builder setCallback(PublishCallback publishCallback) {
            this.b = (PublishCallback) zzbq.checkNotNull(publishCallback);
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.f4985a = (Strategy) zzbq.checkNotNull(strategy);
            return this;
        }
    }

    private PublishOptions(Strategy strategy, PublishCallback publishCallback) {
        this.f4984a = strategy;
        this.b = publishCallback;
    }

    public final PublishCallback getCallback() {
        return this.b;
    }

    public final Strategy getStrategy() {
        return this.f4984a;
    }
}
