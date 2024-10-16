package com.subao.common.b;

/* loaded from: classes2.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public final String f5933a;
    public final boolean b;
    public final boolean c;
    public final char d;

    public static o a(String str) {
        if (str == null || str.length() != 3) {
            return null;
        }
        return new o(str);
    }

    private o(String str) {
        this.f5933a = str;
        this.b = '0' != str.charAt(0);
        this.c = '0' != str.charAt(1);
        this.d = str.charAt(2);
    }

    public o(boolean z, boolean z2, char c) {
        this.b = z;
        this.c = z2;
        this.d = c;
        Object[] objArr = new Object[3];
        objArr[0] = Character.valueOf(z ? '1' : '0');
        objArr[1] = Character.valueOf(z2 ? '1' : '0');
        objArr[2] = Character.valueOf(c);
        this.f5933a = String.format("%c%c%c", objArr);
    }

    public String toString() {
        String str = this.f5933a;
        return str == null ? "(null)" : str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.b == oVar.b && this.c == oVar.c && this.d == oVar.d && com.subao.common.e.a(this.f5933a, oVar.f5933a);
    }
}
