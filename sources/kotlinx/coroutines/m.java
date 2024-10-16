package kotlinx.coroutines;

import kotlin.coroutines.e;

/* loaded from: classes3.dex */
public final class m extends kotlin.coroutines.a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f7023a = new a(null);
    private final String b;

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof m) && kotlin.jvm.internal.h.a((Object) this.b, (Object) ((m) obj).b);
        }
        return true;
    }

    public int hashCode() {
        String str = this.b;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String a() {
        return this.b;
    }

    /* loaded from: classes3.dex */
    public static final class a implements e.c<m> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public String toString() {
        return "CoroutineName(" + this.b + ')';
    }
}
