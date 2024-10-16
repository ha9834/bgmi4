package com.vk.api.sdk.exceptions;

import kotlin.jvm.internal.f;

/* loaded from: classes3.dex */
public final class VKAuthException extends Exception {
    private final String authError;
    private final int webViewError;

    /* JADX WARN: Multi-variable type inference failed */
    public VKAuthException() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public /* synthetic */ VKAuthException(int i, String str, int i2, f fVar) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : str);
    }

    public final int a() {
        return this.webViewError;
    }

    public final String b() {
        return this.authError;
    }

    public VKAuthException(int i, String str) {
        super("Auth canceled");
        this.webViewError = i;
        this.authError = str;
    }

    public final boolean c() {
        if (this.webViewError == 0) {
            String str = this.authError;
            if (str == null || str.length() == 0) {
                return true;
            }
        }
        return false;
    }
}
