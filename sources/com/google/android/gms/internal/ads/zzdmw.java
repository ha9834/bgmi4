package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class zzdmw extends zzdnb {
    private final int zzhcv;
    private final int zzhcw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdmw(byte[] bArr, int i, int i2) {
        super(bArr);
        b(i, i + i2, bArr.length);
        this.zzhcv = i;
        this.zzhcw = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdnb, com.google.android.gms.internal.ads.zzdmr
    public final byte zzfm(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzhcy[this.zzhcv + i];
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
    @Override // com.google.android.gms.internal.ads.zzdnb, com.google.android.gms.internal.ads.zzdmr
    public final byte a(int i) {
        return this.zzhcy[this.zzhcv + i];
    }

    @Override // com.google.android.gms.internal.ads.zzdnb, com.google.android.gms.internal.ads.zzdmr
    public final int size() {
        return this.zzhcw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdnb
    public final int b() {
        return this.zzhcv;
    }

    @Override // com.google.android.gms.internal.ads.zzdnb, com.google.android.gms.internal.ads.zzdmr
    protected final void a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzhcy, b(), bArr, 0, i3);
    }
}
