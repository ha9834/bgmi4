package kotlin.text;

/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private final String f6983a;
    private final kotlin.d.c b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.h.a((Object) this.f6983a, (Object) fVar.f6983a) && kotlin.jvm.internal.h.a(this.b, fVar.b);
    }

    public int hashCode() {
        String str = this.f6983a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        kotlin.d.c cVar = this.b;
        return hashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public String toString() {
        return "MatchGroup(value=" + this.f6983a + ", range=" + this.b + ")";
    }

    public f(String str, kotlin.d.c cVar) {
        kotlin.jvm.internal.h.b(str, "value");
        kotlin.jvm.internal.h.b(cVar, "range");
        this.f6983a = str;
        this.b = cVar;
    }
}
