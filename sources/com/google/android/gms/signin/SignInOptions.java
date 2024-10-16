package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;

/* loaded from: classes2.dex */
public final class SignInOptions implements Api.ApiOptions.Optional {
    public static final SignInOptions DEFAULT;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f5053a = false;
    private final boolean b = false;
    private final String c = null;
    private final boolean d = false;
    private final boolean f = false;
    private final String e = null;
    private final Long g = null;
    private final Long h = null;

    /* loaded from: classes2.dex */
    public static final class zaa {
    }

    private SignInOptions(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
    }

    public final boolean isOfflineAccessRequested() {
        return this.f5053a;
    }

    public final boolean isIdTokenRequested() {
        return this.b;
    }

    public final String getServerClientId() {
        return this.c;
    }

    public final boolean isForceCodeForRefreshToken() {
        return this.d;
    }

    public final String getHostedDomain() {
        return this.e;
    }

    public final boolean waitForAccessTokenRefresh() {
        return this.f;
    }

    public final Long getAuthApiSignInModuleVersion() {
        return this.g;
    }

    public final Long getRealClientLibraryVersion() {
        return this.h;
    }

    static {
        new zaa();
        DEFAULT = new SignInOptions(false, false, null, false, null, false, null, null);
    }
}
