package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class dg {

    /* renamed from: a, reason: collision with root package name */
    private static final df f4515a = c();
    private static final df b = new de();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static df a() {
        return f4515a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static df b() {
        return b;
    }

    private static df c() {
        try {
            return (df) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
