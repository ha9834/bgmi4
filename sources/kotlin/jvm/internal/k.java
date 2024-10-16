package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public class k {
    public kotlin.e.d a(FunctionReference functionReference) {
        return functionReference;
    }

    public kotlin.e.f a(PropertyReference1 propertyReference1) {
        return propertyReference1;
    }

    public kotlin.e.c a(Class cls, String str) {
        return new i(cls, str);
    }

    public kotlin.e.b a(Class cls) {
        return new d(cls);
    }

    public String a(Lambda lambda) {
        return a((g) lambda);
    }

    public String a(g gVar) {
        String obj = gVar.getClass().getGenericInterfaces()[0].toString();
        return obj.startsWith("kotlin.jvm.functions.") ? obj.substring(21) : obj;
    }
}
