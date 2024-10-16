package androidx.media;

import java.util.Arrays;

/* loaded from: classes.dex */
class c implements a {

    /* renamed from: a, reason: collision with root package name */
    int f834a = 0;
    int b = 0;
    int c = 0;
    int d = -1;

    public int a() {
        int i = this.d;
        return i != -1 ? i : AudioAttributesCompat.a(false, this.c, this.f834a);
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.f834a;
    }

    public int d() {
        int i = this.c;
        int a2 = a();
        if (a2 == 6) {
            i |= 4;
        } else if (a2 == 7) {
            i |= 1;
        }
        return i & 273;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.f834a), Integer.valueOf(this.d)});
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.b == cVar.b() && this.c == cVar.d() && this.f834a == cVar.c() && this.d == cVar.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.d != -1) {
            sb.append(" stream=");
            sb.append(this.d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        sb.append(AudioAttributesCompat.a(this.f834a));
        sb.append(" content=");
        sb.append(this.b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.c).toUpperCase());
        return sb.toString();
    }
}
