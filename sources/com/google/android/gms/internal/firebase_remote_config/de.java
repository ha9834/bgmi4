package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
final class de {

    /* renamed from: a, reason: collision with root package name */
    private static final dd f4074a = c();
    private static final dd b = new df();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static dd a() {
        return f4074a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static dd b() {
        return b;
    }

    private static dd c() {
        try {
            return (dd) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
