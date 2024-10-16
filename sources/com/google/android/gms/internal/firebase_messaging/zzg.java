package com.google.android.gms.internal.firebase_messaging;

import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

/* loaded from: classes.dex */
public final class zzg {
    @NonNullDecl
    public static <T> T checkNotNull(@NonNullDecl T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }
}
