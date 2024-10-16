package com.google.android.gms.ads.rewarded;

/* loaded from: classes.dex */
public class ServerSideVerificationOptions {

    /* renamed from: a, reason: collision with root package name */
    private final String f1180a;
    private final String b;

    private ServerSideVerificationOptions(Builder builder) {
        this.f1180a = builder.f1181a;
        this.b = builder.b;
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f1181a = "";
        private String b = "";

        public final Builder setUserId(String str) {
            this.f1181a = str;
            return this;
        }

        public final Builder setCustomData(String str) {
            this.b = str;
            return this;
        }

        public final ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this);
        }
    }

    public String getUserId() {
        return this.f1180a;
    }

    public String getCustomData() {
        return this.b;
    }
}
