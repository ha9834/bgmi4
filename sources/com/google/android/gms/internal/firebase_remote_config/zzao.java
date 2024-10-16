package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;

/* loaded from: classes2.dex */
public final class zzao implements zzap {

    /* renamed from: a, reason: collision with root package name */
    private final Proxy f4124a;

    public zzao() {
        this(null);
    }

    public zzao(Proxy proxy) {
        this.f4124a = proxy;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzap
    public final HttpURLConnection zza(URL url) throws IOException {
        Proxy proxy = this.f4124a;
        return (HttpURLConnection) (proxy == null ? url.openConnection() : url.openConnection(proxy));
    }
}
