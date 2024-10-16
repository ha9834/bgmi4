package com.discord.connect.jni;

import lombok.NonNull;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final long f1076a;

    public b(@NonNull Core core) {
        if (core == null) {
            throw new NullPointerException("core is marked non-null but is null");
        }
        this.f1076a = core.f1072a;
    }
}
