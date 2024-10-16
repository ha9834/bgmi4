package androidx.core.e;

/* loaded from: classes.dex */
public class c<F, S> {

    /* renamed from: a, reason: collision with root package name */
    public final F f514a;
    public final S b;

    public c(F f, S s) {
        this.f514a = f;
        this.b = s;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return b.a(cVar.f514a, this.f514a) && b.a(cVar.b, this.b);
    }

    public int hashCode() {
        F f = this.f514a;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + String.valueOf(this.f514a) + " " + String.valueOf(this.b) + "}";
    }
}
