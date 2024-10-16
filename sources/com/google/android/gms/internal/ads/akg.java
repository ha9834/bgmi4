package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class akg {

    /* renamed from: a, reason: collision with root package name */
    public final int f1931a;
    public final long[] b;
    public final int[] c;
    public final long[] d;
    public final int[] e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public akg(long[] jArr, int[] iArr, long[] jArr2, int[] iArr2) {
        zzkh.checkArgument(iArr.length == jArr2.length);
        zzkh.checkArgument(jArr.length == jArr2.length);
        zzkh.checkArgument(iArr2.length == jArr2.length);
        this.b = jArr;
        this.c = iArr;
        this.d = jArr2;
        this.e = iArr2;
        this.f1931a = jArr.length;
    }
}
