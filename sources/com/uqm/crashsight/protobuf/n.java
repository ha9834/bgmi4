package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    private static final k<?> f6829a = new m();
    private static final k<?> b = c();

    private static k<?> c() {
        try {
            return (k) Class.forName("com.uqm.crashsight.protobuf.l").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k<?> a() {
        return f6829a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k<?> b() {
        k<?> kVar = b;
        if (kVar != null) {
            return kVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
