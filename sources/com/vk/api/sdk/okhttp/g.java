package com.vk.api.sdk.okhttp;

import com.amazonaws.http.HttpHeader;
import com.vk.api.sdk.utils.i;
import kotlin.jvm.internal.h;
import okhttp3.ab;
import okhttp3.u;

/* loaded from: classes3.dex */
public final class g implements u {

    /* renamed from: a, reason: collision with root package name */
    private final i f6906a;

    public g(i iVar) {
        h.b(iVar, "userAgent");
        this.f6906a = iVar;
    }

    @Override // okhttp3.u
    public ab intercept(u.a aVar) {
        h.b(aVar, "chain");
        return aVar.a(aVar.a().e().a(HttpHeader.USER_AGENT, this.f6906a.e()).b());
    }
}
