package com.subao.common.e;

/* loaded from: classes2.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    public final int f5968a;
    public final int b;

    public al(int i, int i2) {
        this.f5968a = i;
        this.b = i2;
    }

    public static String a(al alVar) {
        if (alVar == null) {
            return null;
        }
        return alVar.a();
    }

    public String a() {
        k kVar;
        j jVar;
        k[] values = k.values();
        int length = values.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                kVar = null;
                break;
            }
            kVar = values[i2];
            if (this.f5968a == kVar.H) {
                break;
            }
            i2++;
        }
        j[] values2 = j.values();
        int length2 = values2.length;
        while (true) {
            if (i >= length2) {
                jVar = null;
                break;
            }
            jVar = values2[i];
            if (this.b == jVar.d) {
                break;
            }
            i++;
        }
        StringBuilder sb = new StringBuilder(128);
        if (kVar == null) {
            sb.append(this.f5968a);
        } else {
            sb.append(kVar.K);
        }
        sb.append('.');
        if (jVar == null) {
            sb.append(this.b);
        } else {
            sb.append(jVar.f);
        }
        return sb.toString();
    }

    public String toString() {
        return String.format(r.f6001a, "[region=%d, isp=%d]", Integer.valueOf(this.f5968a), Integer.valueOf(this.b));
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof al)) {
            return false;
        }
        al alVar = (al) obj;
        return this.f5968a == alVar.f5968a && this.b == alVar.b;
    }

    public int hashCode() {
        return (this.f5968a * 100) + this.b;
    }
}
