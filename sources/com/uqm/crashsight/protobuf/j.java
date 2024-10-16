package com.uqm.crashsight.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    private static Class<?> f6825a = b();

    private static Class<?> b() {
        try {
            return Class.forName("com.uqm.crashsight.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static ExtensionRegistryLite a() {
        ExtensionRegistryLite a2 = a("getEmptyRegistry");
        return a2 != null ? a2 : ExtensionRegistryLite.f6698a;
    }

    private static final ExtensionRegistryLite a(String str) {
        Class<?> cls = f6825a;
        if (cls == null) {
            return null;
        }
        try {
            return (ExtensionRegistryLite) cls.getDeclaredMethod(str, new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
