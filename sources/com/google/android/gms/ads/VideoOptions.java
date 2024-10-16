package com.google.android.gms.ads;

import com.google.android.gms.internal.ads.zzacd;
import com.google.android.gms.internal.ads.zzard;

@zzard
/* loaded from: classes.dex */
public final class VideoOptions {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f1129a;
    private final boolean b;
    private final boolean c;

    public VideoOptions(zzacd zzacdVar) {
        this.f1129a = zzacdVar.zzaax;
        this.b = zzacdVar.zzaay;
        this.c = zzacdVar.zzaaz;
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1130a = true;
        private boolean b = false;
        private boolean c = false;

        public final Builder setStartMuted(boolean z) {
            this.f1130a = z;
            return this;
        }

        public final Builder setCustomControlsRequested(boolean z) {
            this.b = z;
            return this;
        }

        public final Builder setClickToExpandRequested(boolean z) {
            this.c = z;
            return this;
        }

        public final VideoOptions build() {
            return new VideoOptions(this);
        }
    }

    private VideoOptions(Builder builder) {
        this.f1129a = builder.f1130a;
        this.b = builder.b;
        this.c = builder.c;
    }

    public final boolean getStartMuted() {
        return this.f1129a;
    }

    public final boolean getCustomControlsRequested() {
        return this.b;
    }

    public final boolean getClickToExpandRequested() {
        return this.c;
    }
}
