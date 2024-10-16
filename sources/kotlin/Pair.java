package kotlin;

import java.io.Serializable;

/* loaded from: classes3.dex */
public final class Pair<A, B> implements Serializable {
    private final A first;
    private final B second;

    public final A c() {
        return this.first;
    }

    public final B d() {
        return this.second;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return kotlin.jvm.internal.h.a(this.first, pair.first) && kotlin.jvm.internal.h.a(this.second, pair.second);
    }

    public int hashCode() {
        A a2 = this.first;
        int hashCode = (a2 != null ? a2.hashCode() : 0) * 31;
        B b = this.second;
        return hashCode + (b != null ? b.hashCode() : 0);
    }

    public Pair(A a2, B b) {
        this.first = a2;
        this.second = b;
    }

    public final A a() {
        return this.first;
    }

    public final B b() {
        return this.second;
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
