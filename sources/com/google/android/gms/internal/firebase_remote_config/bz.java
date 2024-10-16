package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
final class bz {

    /* renamed from: a, reason: collision with root package name */
    private static final by<?> f4052a = new ca();
    private static final by<?> b = c();

    private static by<?> c() {
        try {
            return (by) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static by<?> a() {
        return f4052a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static by<?> b() {
        by<?> byVar = b;
        if (byVar != null) {
            return byVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
