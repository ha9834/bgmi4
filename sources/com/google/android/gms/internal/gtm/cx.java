package com.google.android.gms.internal.gtm;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cx {

    /* renamed from: a, reason: collision with root package name */
    private static final cx f4340a = new cx();
    private final ConcurrentMap<Class<?>, da<?>> c = new ConcurrentHashMap();
    private final db b = new ch();

    public static cx a() {
        return f4340a;
    }

    public final <T> da<T> a(Class<T> cls) {
        zzre.a(cls, "messageType");
        da<T> daVar = (da) this.c.get(cls);
        if (daVar != null) {
            return daVar;
        }
        da<T> a2 = this.b.a(cls);
        zzre.a(cls, "messageType");
        zzre.a(a2, "schema");
        da<T> daVar2 = (da) this.c.putIfAbsent(cls, a2);
        return daVar2 != null ? daVar2 : a2;
    }

    public final <T> da<T> a(T t) {
        return a((Class) t.getClass());
    }

    private cx() {
    }
}
