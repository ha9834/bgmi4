package com.google.android.gms.internal.measurement;

/* loaded from: classes2.dex */
final class cw {

    /* renamed from: a, reason: collision with root package name */
    private static final cv f4511a = c();
    private static final cv b = new cx();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cv a() {
        return f4511a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cv b() {
        return b;
    }

    private static cv c() {
        try {
            return (cv) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
