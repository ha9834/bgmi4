package com.google.zxing;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final int f5394a;
    private final int b;

    public int a() {
        return this.f5394a;
    }

    public int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f5394a == aVar.f5394a && this.b == aVar.b;
    }

    public int hashCode() {
        return (this.f5394a * 32713) + this.b;
    }

    public String toString() {
        return this.f5394a + "x" + this.b;
    }
}
