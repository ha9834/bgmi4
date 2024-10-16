package com.vk.api.sdk.okhttp;

import android.content.Context;
import com.vk.api.sdk.o;
import com.vk.api.sdk.utils.log.Logger;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final com.vk.api.sdk.e f6902a;

    public d(com.vk.api.sdk.e eVar) {
        h.b(eVar, "apiConfig");
        this.f6902a = eVar;
        com.vk.api.sdk.internal.e.f6885a.a(a());
        com.vk.api.sdk.internal.e.f6885a.a(d());
    }

    public final Context a() {
        return this.f6902a.a();
    }

    public final int b() {
        return this.f6902a.b();
    }

    public final kotlin.jvm.a.a<String> c() {
        return this.f6902a.k();
    }

    public final String d() {
        return this.f6902a.h().a();
    }

    public final String e() {
        return this.f6902a.i().a();
    }

    public final o f() {
        return this.f6902a.f();
    }

    public final boolean g() {
        return this.f6902a.j();
    }

    public final Logger h() {
        return this.f6902a.g();
    }

    public final String i() {
        return this.f6902a.m().a();
    }

    public String toString() {
        return "OkHttpExecutorConfig(host='" + c().b() + "', accessToken='" + d() + "', secret='" + ((Object) e()) + "', logFilterCredentials=" + g() + ')';
    }
}
