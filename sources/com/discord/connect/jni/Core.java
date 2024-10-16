package com.discord.connect.jni;

import java.io.Closeable;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class Core implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    long f1072a;

    /* loaded from: classes.dex */
    public interface a {
    }

    private native void destroy(long j);

    public static native void initNative();

    private static native long newInstance(String str, a aVar);

    public Core(@NonNull String str, @NonNull a aVar) {
        if (str == null) {
            throw new NullPointerException("accessToken is marked non-null but is null");
        }
        if (aVar == null) {
            throw new NullPointerException("eventHandler is marked non-null but is null");
        }
        this.f1072a = newInstance(str, aVar);
    }

    public boolean a() {
        return this.f1072a != 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (a()) {
            destroy(this.f1072a);
            this.f1072a = 0L;
        }
    }
}
