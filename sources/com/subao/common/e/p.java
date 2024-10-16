package com.subao.common.e;

/* loaded from: classes2.dex */
public class p<T> {

    /* renamed from: a, reason: collision with root package name */
    private final T[] f5999a;
    private final T[] b;

    public p(T[] tArr, T[] tArr2) {
        this.f5999a = a(tArr) ? null : tArr;
        this.b = a(tArr2) ? null : tArr2;
    }

    private static <T> boolean a(T[] tArr) {
        return tArr == null || tArr.length == 0;
    }
}
