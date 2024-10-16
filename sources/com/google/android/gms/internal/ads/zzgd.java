package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzgd extends Exception {
    private final boolean zzabp;

    public zzgd(String str) {
        super(str);
        this.zzabp = false;
    }

    public zzgd(Throwable th) {
        super(th);
        this.zzabp = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgd(Throwable th, boolean z) {
        super(th);
        this.zzabp = true;
    }
}
