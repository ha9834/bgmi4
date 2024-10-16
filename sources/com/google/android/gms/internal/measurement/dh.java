package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dh {

    /* renamed from: a, reason: collision with root package name */
    private static final dh f4516a = new dh();
    private final ConcurrentMap<Class<?>, dl<?>> c = new ConcurrentHashMap();
    private final Cdo b = new cq();

    public static dh a() {
        return f4516a;
    }

    public final <T> dl<T> a(Class<T> cls) {
        zzez.a(cls, "messageType");
        dl<T> dlVar = (dl) this.c.get(cls);
        if (dlVar != null) {
            return dlVar;
        }
        dl<T> a2 = this.b.a(cls);
        zzez.a(cls, "messageType");
        zzez.a(a2, "schema");
        dl<T> dlVar2 = (dl) this.c.putIfAbsent(cls, a2);
        return dlVar2 != null ? dlVar2 : a2;
    }

    public final <T> dl<T> a(T t) {
        return a((Class) t.getClass());
    }

    private dh() {
    }
}
