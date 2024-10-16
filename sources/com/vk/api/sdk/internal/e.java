package com.vk.api.sdk.internal;

import android.content.Context;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f6885a = new e();

    private e() {
    }

    public final void a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("context is null");
        }
    }

    public final void a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Illegal accessToken value");
        }
    }
}
