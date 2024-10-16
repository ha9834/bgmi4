package com.google.android.gms.internal.gtm;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class bd implements be {
    private bd() {
    }

    @Override // com.google.android.gms.internal.gtm.be
    public final byte[] a(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(ba baVar) {
        this();
    }
}
