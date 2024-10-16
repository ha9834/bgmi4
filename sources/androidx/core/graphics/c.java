package androidx.core.graphics;

import android.graphics.Insets;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f556a = new c(0, 0, 0, 0);
    public final int b;
    public final int c;
    public final int d;
    public final int e;

    private c(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public static c a(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return f556a;
        }
        return new c(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.e == cVar.e && this.b == cVar.b && this.d == cVar.d && this.c == cVar.c;
    }

    public int hashCode() {
        return (((((this.b * 31) + this.c) * 31) + this.d) * 31) + this.e;
    }

    public String toString() {
        return "Insets{left=" + this.b + ", top=" + this.c + ", right=" + this.d + ", bottom=" + this.e + '}';
    }

    public Insets a() {
        return Insets.of(this.b, this.c, this.d, this.e);
    }
}
