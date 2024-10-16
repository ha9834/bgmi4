package kotlinx.coroutines;

/* loaded from: classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6997a;
    public final kotlin.jvm.a.b<Throwable, kotlin.k> b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return kotlin.jvm.internal.h.a(this.f6997a, eVar.f6997a) && kotlin.jvm.internal.h.a(this.b, eVar.b);
    }

    public int hashCode() {
        Object obj = this.f6997a;
        int hashCode = (obj != null ? obj.hashCode() : 0) * 31;
        kotlin.jvm.a.b<Throwable, kotlin.k> bVar = this.b;
        return hashCode + (bVar != null ? bVar.hashCode() : 0);
    }

    public String toString() {
        return "CompletedWithCancellation(result=" + this.f6997a + ", onCancellation=" + this.b + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(Object obj, kotlin.jvm.a.b<? super Throwable, kotlin.k> bVar) {
        this.f6997a = obj;
        this.b = bVar;
    }
}
