package com.google.android.gms.auth.api;

import com.google.android.gms.auth.api.proxy.ProxyApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.auth.zzak;
import com.google.android.gms.internal.auth.zzar;

@KeepForSdk
/* loaded from: classes.dex */
public final class AuthProxy {

    /* renamed from: a, reason: collision with root package name */
    private static final Api.ClientKey<zzak> f1221a = new Api.ClientKey<>();
    private static final Api.AbstractClientBuilder<zzak, AuthProxyOptions> b = new a();

    @KeepForSdk
    public static final Api<AuthProxyOptions> API = new Api<>("Auth.PROXY_API", b, f1221a);

    @KeepForSdk
    public static final ProxyApi ProxyApi = new zzar();
}
