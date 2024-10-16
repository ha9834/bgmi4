package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class cc {

    /* renamed from: a, reason: collision with root package name */
    private static final ca<?> f4496a = new bz();
    private static final ca<?> b = c();

    private static ca<?> c() {
        try {
            return (ca) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ca<?> a() {
        return f4496a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ca<?> b() {
        ca<?> caVar = b;
        if (caVar != null) {
            return caVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
