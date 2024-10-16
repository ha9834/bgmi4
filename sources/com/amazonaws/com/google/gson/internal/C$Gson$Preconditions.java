package com.amazonaws.com.google.gson.internal;

/* renamed from: com.amazonaws.com.google.gson.internal.$Gson$Preconditions, reason: invalid class name */
/* loaded from: classes.dex */
public final class C$Gson$Preconditions {
    public static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void checkArgument(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
