package com.discord.connect.jni;

import lombok.NonNull;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private long f1075a;

    public a(@NonNull Core core) {
        if (core == null) {
            throw new NullPointerException("core is marked non-null but is null");
        }
        this.f1075a = core.f1072a;
    }
}
