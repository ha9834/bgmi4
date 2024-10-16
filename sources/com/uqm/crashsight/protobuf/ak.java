package com.uqm.crashsight.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class ak {

    /* renamed from: a, reason: collision with root package name */
    private static final ak f6791a = new ak();
    private final ConcurrentMap<Class<?>, ao<?>> c = new ConcurrentHashMap();
    private final ap b = new t();

    public static ak a() {
        return f6791a;
    }

    public final <T> void a(T t, an anVar, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        a((Class) t.getClass()).a(t, anVar, extensionRegistryLite);
    }

    public final <T> ao<T> a(Class<T> cls) {
        Internal.a(cls, "messageType");
        ao<T> aoVar = (ao) this.c.get(cls);
        if (aoVar != null) {
            return aoVar;
        }
        ao<T> a2 = this.b.a(cls);
        Internal.a(cls, "messageType");
        Internal.a(a2, "schema");
        ao<T> aoVar2 = (ao) this.c.putIfAbsent(cls, a2);
        return aoVar2 != null ? aoVar2 : a2;
    }

    public final <T> ao<T> a(T t) {
        return a((Class) t.getClass());
    }

    private ak() {
    }
}
