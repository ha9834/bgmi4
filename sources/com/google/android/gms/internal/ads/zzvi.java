package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzvi {

    /* renamed from: a, reason: collision with root package name */
    final long f3759a;
    final String b;
    final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzvi(long j, String str, int i) {
        this.f3759a = j;
        this.b = str;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzvi)) {
            return false;
        }
        zzvi zzviVar = (zzvi) obj;
        return zzviVar.f3759a == this.f3759a && zzviVar.c == this.c;
    }

    public final int hashCode() {
        return (int) this.f3759a;
    }
}
