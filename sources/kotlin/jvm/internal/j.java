package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static final k f6972a;
    private static final kotlin.e.b[] b;

    static {
        k kVar = null;
        try {
            kVar = (k) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException unused) {
        } catch (ClassNotFoundException unused2) {
        } catch (IllegalAccessException unused3) {
        } catch (InstantiationException unused4) {
        }
        if (kVar == null) {
            kVar = new k();
        }
        f6972a = kVar;
        b = new kotlin.e.b[0];
    }

    public static kotlin.e.c a(Class cls) {
        return f6972a.a(cls, "");
    }

    public static kotlin.e.b b(Class cls) {
        return f6972a.a(cls);
    }

    public static String a(Lambda lambda) {
        return f6972a.a(lambda);
    }

    public static kotlin.e.d a(FunctionReference functionReference) {
        return f6972a.a(functionReference);
    }

    public static kotlin.e.f a(PropertyReference1 propertyReference1) {
        return f6972a.a(propertyReference1);
    }
}
