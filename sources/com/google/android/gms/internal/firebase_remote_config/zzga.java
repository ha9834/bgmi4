package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
final class zzga extends zzgh {
    private final int zzoz;
    private final int zzpa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzga(byte[] bArr, int i, int i2) {
        super(bArr);
        b(i, i + i2, bArr.length);
        this.zzoz = i;
        this.zzpa = i2;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgh, com.google.android.gms.internal.firebase_remote_config.zzfx
    public final byte zzv(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzpc[this.zzoz + i];
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
    @Override // com.google.android.gms.internal.firebase_remote_config.zzgh, com.google.android.gms.internal.firebase_remote_config.zzfx
    public final byte a(int i) {
        return this.zzpc[this.zzoz + i];
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgh, com.google.android.gms.internal.firebase_remote_config.zzfx
    public final int size() {
        return this.zzpa;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzgh
    protected final int b() {
        return this.zzoz;
    }
}
