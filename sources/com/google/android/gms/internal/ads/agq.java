package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class agq {

    /* renamed from: a, reason: collision with root package name */
    private static final ago f1867a = c();
    private static final ago b = new agp();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ago a() {
        return f1867a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ago b() {
        return b;
    }

    private static ago c() {
        try {
            return (ago) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
