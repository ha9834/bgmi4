package com.google.android.gms.internal.measurement;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class er {

    /* renamed from: a, reason: collision with root package name */
    final int f4535a;
    final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public er(int i, byte[] bArr) {
        this.f4535a = i;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof er)) {
            return false;
        }
        er erVar = (er) obj;
        return this.f4535a == erVar.f4535a && Arrays.equals(this.b, erVar.b);
    }

    public final int hashCode() {
        return ((this.f4535a + 527) * 31) + Arrays.hashCode(this.b);
    }
}
