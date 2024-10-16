package com.twitter.sdk.android.core.internal.network;

import java.io.IOException;
import okhttp3.ab;
import okhttp3.u;

/* loaded from: classes.dex */
public class GuestAuthNetworkInterceptor implements u {
    @Override // okhttp3.u
    public ab intercept(u.a aVar) throws IOException {
        ab a2 = aVar.a(aVar.a());
        return a2.b() == 403 ? a2.h().a(401).a() : a2;
    }
}
