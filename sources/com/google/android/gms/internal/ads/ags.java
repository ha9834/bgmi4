package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ags {

    /* renamed from: a, reason: collision with root package name */
    private static final ags f1868a = new ags();
    private final ConcurrentMap<Class<?>, agx<?>> c = new ConcurrentHashMap();
    private final agy b = new aga();

    public static ags a() {
        return f1868a;
    }

    public final <T> agx<T> a(Class<T> cls) {
        zzdod.a(cls, "messageType");
        agx<T> agxVar = (agx) this.c.get(cls);
        if (agxVar != null) {
            return agxVar;
        }
        agx<T> a2 = this.b.a(cls);
        zzdod.a(cls, "messageType");
        zzdod.a(a2, "schema");
        agx<T> agxVar2 = (agx) this.c.putIfAbsent(cls, a2);
        return agxVar2 != null ? agxVar2 : a2;
    }

    public final <T> agx<T> a(T t) {
        return a((Class) t.getClass());
    }

    private ags() {
    }
}
