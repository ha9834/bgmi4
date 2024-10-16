package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzku extends Exception {
    private final int type;
    private final int zzark;

    public static zzku zza(Exception exc, int i) {
        return new zzku(1, null, exc, i);
    }

    public static zzku zza(IOException iOException) {
        return new zzku(0, null, iOException, -1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzku a(RuntimeException runtimeException) {
        return new zzku(2, null, runtimeException, -1);
    }

    private zzku(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.zzark = i2;
    }
}
