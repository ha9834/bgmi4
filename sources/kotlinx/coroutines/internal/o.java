package kotlinx.coroutines.internal;

/* loaded from: classes3.dex */
final /* synthetic */ class o {

    /* renamed from: a, reason: collision with root package name */
    private static final int f7017a = Runtime.getRuntime().availableProcessors();

    public static final int a() {
        return f7017a;
    }

    public static final String a(String str) {
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }
}
