package com.amazonaws.services.s3;

/* loaded from: classes.dex */
public class S3ClientOptions {
    public static final boolean DEFAULT_ACCELERATE_MODE_ENABLED = false;
    public static final boolean DEFAULT_CHUNKED_ENCODING_DISABLED = false;
    public static final boolean DEFAULT_DUALSTACK_ENABLED = false;
    public static final boolean DEFAULT_PATH_STYLE_ACCESS = false;
    public static final boolean DEFAULT_PAYLOAD_SIGNING_ENABLED = false;
    private final boolean accelerateModeEnabled;
    private final boolean chunkedEncodingDisabled;
    private final boolean dualstackEnabled;
    private boolean pathStyleAccess;
    private final boolean payloadSigningEnabled;

    public static Builder builder() {
        return new Builder();
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private boolean accelerateModeEnabled;
        private boolean chunkedEncodingDisabled;
        private boolean dualstackEnabled;
        private boolean pathStyleAccess;
        private boolean payloadSigningEnabled;

        private Builder() {
            this.pathStyleAccess = false;
            this.chunkedEncodingDisabled = false;
            this.accelerateModeEnabled = false;
            this.payloadSigningEnabled = false;
            this.dualstackEnabled = false;
        }

        public S3ClientOptions build() {
            return new S3ClientOptions(this.pathStyleAccess, this.chunkedEncodingDisabled, this.accelerateModeEnabled, this.payloadSigningEnabled, this.dualstackEnabled);
        }

        public Builder setPathStyleAccess(boolean z) {
            this.pathStyleAccess = z;
            return this;
        }

        public Builder setAccelerateModeEnabled(boolean z) {
            this.accelerateModeEnabled = z;
            return this;
        }

        public Builder setPayloadSigningEnabled(boolean z) {
            this.payloadSigningEnabled = z;
            return this;
        }

        public Builder disableChunkedEncoding() {
            this.chunkedEncodingDisabled = true;
            return this;
        }

        public Builder enableDualstack() {
            this.dualstackEnabled = true;
            return this;
        }
    }

    @Deprecated
    public S3ClientOptions() {
        this.pathStyleAccess = false;
        this.chunkedEncodingDisabled = false;
        this.accelerateModeEnabled = false;
        this.payloadSigningEnabled = false;
        this.dualstackEnabled = false;
    }

    @Deprecated
    public S3ClientOptions(S3ClientOptions s3ClientOptions) {
        this.pathStyleAccess = s3ClientOptions.pathStyleAccess;
        this.chunkedEncodingDisabled = s3ClientOptions.chunkedEncodingDisabled;
        this.accelerateModeEnabled = s3ClientOptions.accelerateModeEnabled;
        this.payloadSigningEnabled = s3ClientOptions.payloadSigningEnabled;
        this.dualstackEnabled = s3ClientOptions.dualstackEnabled;
    }

    private S3ClientOptions(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        this.pathStyleAccess = z;
        this.chunkedEncodingDisabled = z2;
        this.accelerateModeEnabled = z3;
        this.payloadSigningEnabled = z4;
        this.dualstackEnabled = z5;
    }

    public boolean isPathStyleAccess() {
        return this.pathStyleAccess;
    }

    public boolean isChunkedEncodingDisabled() {
        return this.chunkedEncodingDisabled;
    }

    public boolean isAccelerateModeEnabled() {
        return this.accelerateModeEnabled;
    }

    public boolean isPayloadSigningEnabled() {
        return this.payloadSigningEnabled;
    }

    @Deprecated
    public void setPathStyleAccess(boolean z) {
        this.pathStyleAccess = z;
    }

    public boolean isDualstackEnabled() {
        return this.dualstackEnabled;
    }

    @Deprecated
    public S3ClientOptions withPathStyleAccess(boolean z) {
        setPathStyleAccess(z);
        return this;
    }
}
