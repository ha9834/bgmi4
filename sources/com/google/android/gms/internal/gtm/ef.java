package com.google.android.gms.internal.gtm;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class ef {

    /* renamed from: a, reason: collision with root package name */
    final int f4360a;
    final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ef(int i, byte[] bArr) {
        this.f4360a = i;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ef)) {
            return false;
        }
        ef efVar = (ef) obj;
        return this.f4360a == efVar.f4360a && Arrays.equals(this.b, efVar.b);
    }

    public final int hashCode() {
        return ((this.f4360a + 527) * 31) + Arrays.hashCode(this.b);
    }
}
