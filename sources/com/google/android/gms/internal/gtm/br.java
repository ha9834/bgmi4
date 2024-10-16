package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class br {

    /* renamed from: a, reason: collision with root package name */
    private static final bp<?> f4319a = new bq();
    private static final bp<?> b = c();

    private static bp<?> c() {
        try {
            return (bp) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bp<?> a() {
        return f4319a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static bp<?> b() {
        bp<?> bpVar = b;
        if (bpVar != null) {
            return bpVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
