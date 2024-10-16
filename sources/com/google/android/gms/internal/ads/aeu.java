package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class aeu implements aev {
    private aeu() {
    }

    @Override // com.google.android.gms.internal.ads.aev
    public final byte[] a(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aeu(aer aerVar) {
        this();
    }
}
