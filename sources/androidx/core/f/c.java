package androidx.core.f;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Object f537a;

    private c(Object obj) {
        this.f537a = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        Object obj2 = this.f537a;
        if (obj2 == null) {
            return cVar.f537a == null;
        }
        return obj2.equals(cVar.f537a);
    }

    public int hashCode() {
        Object obj = this.f537a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f537a + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(Object obj) {
        if (obj == null) {
            return null;
        }
        return new c(obj);
    }
}
