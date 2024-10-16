package com.vk.api.sdk.auth;

import kotlin.jvm.internal.f;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final a f6861a;
    private final int b;

    public e(a aVar, int i) {
        this.f6861a = aVar;
        this.b = i;
    }

    public /* synthetic */ e(a aVar, int i, int i2, f fVar) {
        this(aVar, (i2 & 2) != 0 ? 0 : i);
    }

    public final a a() {
        return this.f6861a;
    }

    public final boolean b() {
        return this.b != 0;
    }
}
