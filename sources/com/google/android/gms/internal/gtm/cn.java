package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class cn {

    /* renamed from: a, reason: collision with root package name */
    private static final cl f4336a = c();
    private static final cl b = new cm();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cl a() {
        return f4336a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cl b() {
        return b;
    }

    private static cl c() {
        try {
            return (cl) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
