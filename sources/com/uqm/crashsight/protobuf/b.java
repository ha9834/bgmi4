package com.uqm.crashsight.protobuf;

/* loaded from: classes3.dex */
final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f6806a = a("libcore.io.Memory");
    private static final boolean b;

    static {
        b = a("org.robolectric.Robolectric") != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (f6806a == null || b) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> b() {
        return f6806a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
