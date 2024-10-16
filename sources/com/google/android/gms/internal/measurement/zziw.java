package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zziw {
    protected volatile int b = -1;

    protected int a() {
        return 0;
    }

    public abstract zziw zza(zzil zzilVar) throws IOException;

    public void zza(zzio zzioVar) throws IOException {
    }

    public final int zzuk() {
        int a2 = a();
        this.b = a2;
        return a2;
    }

    public String toString() {
        return zziv.zzb(this);
    }

    @Override // 
    /* renamed from: zzxb, reason: merged with bridge method [inline-methods] */
    public zziw clone() throws CloneNotSupportedException {
        return (zziw) super.clone();
    }
}
