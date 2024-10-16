package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class bn implements bo {
    private bn() {
    }

    @Override // com.google.android.gms.internal.measurement.bo
    public final byte[] a(byte[] bArr, int i, int i2) {
        return Arrays.copyOfRange(bArr, i, i2 + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bn(bk bkVar) {
        this();
    }
}
