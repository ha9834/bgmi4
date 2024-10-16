package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class zzpx extends zzqc {
    private final int zzawb;
    private final int zzawc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpx(byte[] bArr, int i, int i2) {
        super(bArr);
        b(i, i + i2, bArr.length);
        this.zzawb = i;
        this.zzawc = i2;
    }

    @Override // com.google.android.gms.internal.gtm.zzqc, com.google.android.gms.internal.gtm.zzps
    public final byte zzak(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzawe[this.zzawb + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.zzqc, com.google.android.gms.internal.gtm.zzps
    public final byte a(int i) {
        return this.zzawe[this.zzawb + i];
    }

    @Override // com.google.android.gms.internal.gtm.zzqc, com.google.android.gms.internal.gtm.zzps
    public final int size() {
        return this.zzawc;
    }

    @Override // com.google.android.gms.internal.gtm.zzqc
    protected final int b() {
        return this.zzawb;
    }
}
