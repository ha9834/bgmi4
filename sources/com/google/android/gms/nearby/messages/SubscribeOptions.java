package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbq;

/* loaded from: classes2.dex */
public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();

    /* renamed from: a, reason: collision with root package name */
    private final Strategy f4988a;
    private final MessageFilter b;
    private final SubscribeCallback c;

    @Hide
    public final boolean zzkbr;

    @Hide
    public final int zzkbs;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private Strategy f4989a = Strategy.DEFAULT;
        private MessageFilter b = MessageFilter.INCLUDE_ALL_MY_TYPES;
        private SubscribeCallback c;

        public SubscribeOptions build() {
            return new SubscribeOptions(this.f4989a, this.b, this.c);
        }

        public Builder setCallback(SubscribeCallback subscribeCallback) {
            this.c = (SubscribeCallback) zzbq.checkNotNull(subscribeCallback);
            return this;
        }

        public Builder setFilter(MessageFilter messageFilter) {
            this.b = messageFilter;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.f4989a = strategy;
            return this;
        }
    }

    private SubscribeOptions(Strategy strategy, MessageFilter messageFilter, SubscribeCallback subscribeCallback, boolean z, int i) {
        this.f4988a = strategy;
        this.b = messageFilter;
        this.c = subscribeCallback;
        this.zzkbr = z;
        this.zzkbs = i;
    }

    public final SubscribeCallback getCallback() {
        return this.c;
    }

    public final MessageFilter getFilter() {
        return this.b;
    }

    public final Strategy getStrategy() {
        return this.f4988a;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f4988a);
        String valueOf2 = String.valueOf(this.b);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 36 + String.valueOf(valueOf2).length());
        sb.append("SubscribeOptions{strategy=");
        sb.append(valueOf);
        sb.append(", filter=");
        sb.append(valueOf2);
        sb.append('}');
        return sb.toString();
    }
}
