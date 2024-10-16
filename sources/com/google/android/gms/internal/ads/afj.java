package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class afj {

    /* renamed from: a, reason: collision with root package name */
    private static final afh<?> f1845a = new afi();
    private static final afh<?> b = c();

    private static afh<?> c() {
        try {
            return (afh) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static afh<?> a() {
        return f1845a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static afh<?> b() {
        afh<?> afhVar = b;
        if (afhVar != null) {
            return afhVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
