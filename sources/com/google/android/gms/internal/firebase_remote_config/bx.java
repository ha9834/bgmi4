package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
final class bx {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f4051a = b();

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzgu a() {
        Class<?> cls = f4051a;
        if (cls != null) {
            try {
                return (zzgu) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke(null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return zzgu.f4177a;
    }
}
