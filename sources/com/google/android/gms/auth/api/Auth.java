package com.google.android.gms.auth.api;

import android.os.Bundle;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzf;
import com.google.android.gms.auth.api.signin.internal.zzg;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.p000authapi.zzi;
import com.google.android.gms.internal.p000authapi.zzr;

/* loaded from: classes.dex */
public final class Auth {
    public static final Api.ClientKey<zzr> zzg = new Api.ClientKey<>();
    public static final Api.ClientKey<zzg> zzh = new Api.ClientKey<>();

    /* renamed from: a, reason: collision with root package name */
    private static final Api.AbstractClientBuilder<zzr, AuthCredentialsOptions> f1218a = new b();
    private static final Api.AbstractClientBuilder<zzg, GoogleSignInOptions> b = new c();

    @KeepForSdk
    @Deprecated
    public static final Api<AuthProxyOptions> PROXY_API = AuthProxy.API;
    public static final Api<AuthCredentialsOptions> CREDENTIALS_API = new Api<>("Auth.CREDENTIALS_API", f1218a, zzg);
    public static final Api<GoogleSignInOptions> GOOGLE_SIGN_IN_API = new Api<>("Auth.GOOGLE_SIGN_IN_API", b, zzh);

    @KeepForSdk
    @Deprecated
    public static final ProxyApi ProxyApi = AuthProxy.ProxyApi;
    public static final CredentialsApi CredentialsApi = new zzi();
    public static final GoogleSignInApi GoogleSignInApi = new zzf();

    private Auth() {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class AuthCredentialsOptions implements Api.ApiOptions.Optional {

        /* renamed from: a, reason: collision with root package name */
        private static final AuthCredentialsOptions f1219a = new Builder().zzc();
        private final String b = null;
        private final boolean c;

        public AuthCredentialsOptions(Builder builder) {
            this.c = builder.f1220a.booleanValue();
        }

        @Deprecated
        /* loaded from: classes.dex */
        public static class Builder {

            /* renamed from: a, reason: collision with root package name */
            protected Boolean f1220a = false;

            public Builder forceEnableSaveDialog() {
                this.f1220a = true;
                return this;
            }

            public AuthCredentialsOptions zzc() {
                return new AuthCredentialsOptions(this);
            }
        }

        public final Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putString("consumer_package", null);
            bundle.putBoolean("force_save_dialog", this.c);
            return bundle;
        }
    }
}
