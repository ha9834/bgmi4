package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class aen {

    /* renamed from: a, reason: collision with root package name */
    private static final Class<?> f1834a = a("libcore.io.Memory");
    private static final boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return (f1834a == null || b) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> b() {
        return f1834a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static {
        b = a("org.robolectric.Robolectric") != null;
    }
}
