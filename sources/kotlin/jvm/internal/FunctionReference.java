package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public class FunctionReference extends CallableReference implements kotlin.e.d, g {
    private final int arity;
    private final int flags;

    public FunctionReference(int i, Object obj, Class cls, String str, String str2, int i2) {
        super(obj, cls, str, str2, (i2 & 1) == 1);
        this.arity = i;
        this.flags = i2 >> 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public kotlin.e.d d() {
        return (kotlin.e.d) super.d();
    }

    @Override // kotlin.jvm.internal.CallableReference
    protected kotlin.e.a a() {
        return j.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference functionReference = (FunctionReference) obj;
            return h.a(e(), functionReference.e()) && f().equals(functionReference.f()) && g().equals(functionReference.g()) && this.flags == functionReference.flags && this.arity == functionReference.arity && h.a(b(), functionReference.b());
        }
        if (obj instanceof kotlin.e.d) {
            return obj.equals(c());
        }
        return false;
    }

    public int hashCode() {
        return (((e() == null ? 0 : e().hashCode() * 31) + f().hashCode()) * 31) + g().hashCode();
    }

    public String toString() {
        kotlin.e.a c = c();
        if (c != this) {
            return c.toString();
        }
        if ("<init>".equals(f())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + f() + " (Kotlin reflection is not available)";
    }
}
