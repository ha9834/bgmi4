package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzdrw {
    protected volatile int b = -1;

    protected int a() {
        return 0;
    }

    public void zza(zzdrp zzdrpVar) throws IOException {
    }

    public final int zzaxj() {
        int a2 = a();
        this.b = a2;
        return a2;
    }

    public static final byte[] zza(zzdrw zzdrwVar) {
        byte[] bArr = new byte[zzdrwVar.zzaxj()];
        try {
            zzdrp zzp = zzdrp.zzp(bArr, 0, bArr.length);
            zzdrwVar.zza(zzp);
            zzp.zzawv();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public String toString() {
        return zzdrx.zzb(this);
    }

    @Override // 
    /* renamed from: zzbal, reason: merged with bridge method [inline-methods] */
    public zzdrw clone() throws CloneNotSupportedException {
        return (zzdrw) super.clone();
    }
}
