package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
final class x {

    /* renamed from: a, reason: collision with root package name */
    private static final u f6838a = c();
    private static final u b = new w();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u a() {
        return f6838a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u b() {
        return b;
    }

    private static u c() {
        try {
            return (u) Class.forName("com.uqm.crashsight.protobuf.v").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
