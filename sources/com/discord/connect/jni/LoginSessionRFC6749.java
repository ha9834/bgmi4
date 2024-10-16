package com.discord.connect.jni;

import java.io.Closeable;
import lombok.NonNull;

/* loaded from: classes.dex */
public final class LoginSessionRFC6749 implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private long f1074a;

    /* loaded from: classes.dex */
    public interface a {
    }

    private native void destroy(long j);

    private native void exchangeAndDestroy(long j, @NonNull String str, @NonNull String str2, @NonNull a aVar);

    @NonNull
    private native String getAuthorizationUrl(long j);

    private static native long newInstance(long j, @NonNull String str, @NonNull String[] strArr);

    public LoginSessionRFC6749(long j, @NonNull String str, @NonNull String[] strArr) {
        if (str == null) {
            throw new NullPointerException("redirectUri is marked non-null but is null");
        }
        if (strArr == null) {
            throw new NullPointerException("scopes is marked non-null but is null");
        }
        this.f1074a = newInstance(j, str, strArr);
    }

    public boolean a() {
        return this.f1074a != 0;
    }

    @NonNull
    public String b() {
        return getAuthorizationUrl(this.f1074a);
    }

    public void a(@NonNull String str, @NonNull String str2, @NonNull a aVar) {
        if (str == null) {
            throw new NullPointerException("accessCode is marked non-null but is null");
        }
        if (str2 == null) {
            throw new NullPointerException("state is marked non-null but is null");
        }
        if (aVar == null) {
            throw new NullPointerException("callback is marked non-null but is null");
        }
        if (!a()) {
            throw new IllegalStateException("Session has been invalidated");
        }
        exchangeAndDestroy(this.f1074a, str, str2, aVar);
        this.f1074a = 0L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (a()) {
            destroy(this.f1074a);
            this.f1074a = 0L;
        }
    }
}
