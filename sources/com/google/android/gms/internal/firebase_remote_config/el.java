package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
abstract class el {
    abstract int a(int i, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String a(byte[] bArr, int i, int i2) throws zzhm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(byte[] bArr, int i, int i2) {
        return a(0, bArr, i, i2) == 0;
    }
}
