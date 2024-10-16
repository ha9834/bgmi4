package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Hide;

/* loaded from: classes2.dex */
public class MessagesOptions implements Api.ApiOptions.Optional {

    @Hide
    public final String zzkav;

    @Hide
    public final boolean zzkaw;

    @Hide
    public final int zzkax;

    @Hide
    public final String zzkay;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private int f4983a = -1;

        public MessagesOptions build() {
            return new MessagesOptions(this);
        }

        public Builder setPermissions(int i) {
            this.f4983a = i;
            return this;
        }
    }

    private MessagesOptions(Builder builder) {
        this.zzkav = null;
        this.zzkaw = false;
        this.zzkax = builder.f4983a;
        this.zzkay = null;
    }
}
