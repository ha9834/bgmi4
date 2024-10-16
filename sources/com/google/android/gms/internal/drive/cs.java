package com.google.android.gms.internal.drive;

import java.util.Arrays;

/* loaded from: classes2.dex */
final class cs {

    /* renamed from: a, reason: collision with root package name */
    final int f3932a;
    final byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(int i, byte[] bArr) {
        this.f3932a = i;
        this.b = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cs)) {
            return false;
        }
        cs csVar = (cs) obj;
        return this.f3932a == csVar.f3932a && Arrays.equals(this.b, csVar.b);
    }

    public final int hashCode() {
        return ((this.f3932a + 527) * 31) + Arrays.hashCode(this.b);
    }
}
