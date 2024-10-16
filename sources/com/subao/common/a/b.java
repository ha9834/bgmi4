package com.subao.common.a;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static a f5866a;

    public static synchronized a a(a aVar) {
        a aVar2;
        synchronized (b.class) {
            aVar2 = f5866a;
            f5866a = aVar;
        }
        return aVar2;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (b.class) {
            aVar = f5866a;
        }
        return aVar;
    }
}
