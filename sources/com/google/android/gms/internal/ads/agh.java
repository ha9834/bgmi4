package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class agh {

    /* renamed from: a, reason: collision with root package name */
    private static final agf f1863a = c();
    private static final agf b = new agg();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static agf a() {
        return f1863a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static agf b() {
        return b;
    }

    private static agf c() {
        try {
            return (agf) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
