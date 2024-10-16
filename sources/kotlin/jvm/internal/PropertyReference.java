package kotlin.jvm.internal;

/* loaded from: classes3.dex */
public abstract class PropertyReference extends CallableReference implements kotlin.e.e {
    public PropertyReference() {
    }

    public PropertyReference(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.CallableReference
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public kotlin.e.e d() {
        return (kotlin.e.e) super.d();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PropertyReference) {
            PropertyReference propertyReference = (PropertyReference) obj;
            return e().equals(propertyReference.e()) && f().equals(propertyReference.f()) && g().equals(propertyReference.g()) && h.a(b(), propertyReference.b());
        }
        if (obj instanceof kotlin.e.e) {
            return obj.equals(c());
        }
        return false;
    }

    public int hashCode() {
        return (((e().hashCode() * 31) + f().hashCode()) * 31) + g().hashCode();
    }

    public String toString() {
        kotlin.e.a c = c();
        if (c != this) {
            return c.toString();
        }
        return "property " + f() + " (Kotlin reflection is not available)";
    }
}
