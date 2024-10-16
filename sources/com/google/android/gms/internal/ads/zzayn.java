package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzayn extends Exception {
    private final int errorCode;

    public zzayn(String str, int i) {
        super(str);
        this.errorCode = i;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }
}
