package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public abstract class zzuw {
    protected volatile int b = -1;

    protected int a() {
        return 0;
    }

    public abstract zzuw zza(zzun zzunVar) throws IOException;

    public void zza(zzuo zzuoVar) throws IOException {
    }

    public final int zzse() {
        if (this.b < 0) {
            zzpe();
        }
        return this.b;
    }

    public final int zzpe() {
        int a2 = a();
        this.b = a2;
        return a2;
    }

    public static final void zza(zzuw zzuwVar, byte[] bArr, int i, int i2) {
        try {
            zzuo zzk = zzuo.zzk(bArr, 0, i2);
            zzuwVar.zza(zzk);
            zzk.zzrx();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzuw> T zza(T t, byte[] bArr) throws zzuv {
        return (T) a(t, bArr, 0, bArr.length);
    }

    private static final <T extends zzuw> T a(T t, byte[] bArr, int i, int i2) throws zzuv {
        try {
            zzun zzj = zzun.zzj(bArr, 0, i2);
            t.zza(zzj);
            zzj.zzan(0);
            return t;
        } catch (zzuv e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).", e2);
        }
    }

    public String toString() {
        return zzux.zzc(this);
    }

    @Override // 
    /* renamed from: zzry, reason: merged with bridge method [inline-methods] */
    public zzuw clone() throws CloneNotSupportedException {
        return (zzuw) super.clone();
    }
}
