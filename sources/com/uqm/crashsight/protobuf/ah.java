package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
final class ah {

    /* renamed from: a, reason: collision with root package name */
    private static final ae f6789a = c();
    private static final ae b = new ag();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ae a() {
        return f6789a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ae b() {
        return b;
    }

    private static ae c() {
        try {
            return (ae) Class.forName("com.uqm.crashsight.protobuf.af").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
