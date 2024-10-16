package com.vk.api.sdk.okhttp;

import com.vk.api.sdk.utils.log.Logger;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Logger.LogLevel f6897a;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && this.f6897a == ((a) obj).f6897a;
    }

    public int hashCode() {
        return this.f6897a.hashCode();
    }

    public String toString() {
        return "LogLevelRequestTag(level=" + this.f6897a + ')';
    }

    public final Logger.LogLevel a() {
        return this.f6897a;
    }
}
