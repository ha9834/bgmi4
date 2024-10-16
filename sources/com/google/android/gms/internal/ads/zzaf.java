package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public class zzaf extends Exception {
    private long zzad;
    private final zzp zzbk;

    public zzaf() {
        this.zzbk = null;
    }

    public zzaf(zzp zzpVar) {
        this.zzbk = zzpVar;
    }

    public zzaf(String str) {
        super(str);
        this.zzbk = null;
    }

    public zzaf(Throwable th) {
        super(th);
        this.zzbk = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(long j) {
        this.zzad = j;
    }
}
