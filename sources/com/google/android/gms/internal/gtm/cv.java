package com.google.android.gms.internal.gtm;

/* loaded from: classes2.dex */
final class cv {

    /* renamed from: a, reason: collision with root package name */
    private static final ct f4339a = c();
    private static final ct b = new cu();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ct a() {
        return f4339a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ct b() {
        return b;
    }

    private static ct c() {
        try {
            return (ct) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
