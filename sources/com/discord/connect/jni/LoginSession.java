package com.discord.connect.jni;

import java.io.Closeable;

/* loaded from: classes.dex */
public final class LoginSession implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private long f1073a;

    private native void destroy(long j);

    public boolean a() {
        return this.f1073a != 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (a()) {
            destroy(this.f1073a);
            this.f1073a = 0L;
        }
    }
}
