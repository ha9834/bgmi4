package com.google.android.gms.internal.firebase_remote_config;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class di {

    /* renamed from: a, reason: collision with root package name */
    private static final di f4076a = new di();
    private final ConcurrentMap<Class<?>, dm<?>> c = new ConcurrentHashMap();
    private final dl b = new cr();

    public static di a() {
        return f4076a;
    }

    public final <T> dm<T> a(Class<T> cls) {
        zzhi.a(cls, "messageType");
        dm<T> dmVar = (dm) this.c.get(cls);
        if (dmVar != null) {
            return dmVar;
        }
        dm<T> a2 = this.b.a(cls);
        zzhi.a(cls, "messageType");
        zzhi.a(a2, "schema");
        dm<T> dmVar2 = (dm) this.c.putIfAbsent(cls, a2);
        return dmVar2 != null ? dmVar2 : a2;
    }

    public final <T> dm<T> a(T t) {
        return a((Class) t.getClass());
    }

    private di() {
    }
}
