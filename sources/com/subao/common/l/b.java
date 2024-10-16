package com.subao.common.l;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f6123a = a(a.DEFAULT);
    public final a b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;

    public b(int i, int i2, a aVar, int i3, int i4) {
        this.c = i;
        this.d = i2;
        this.b = aVar;
        this.e = i3;
        this.f = i4;
    }

    public static b a(a aVar) {
        return new b(0, 900, aVar, 0, 0);
    }

    public static b a(String str) {
        Integer[] b = b(str);
        if (b == null) {
            return f6123a;
        }
        return new b(a(b, 0, 0), a(b, 1, 900), a.a(a(b, 3, a.DEFAULT.g)), a(b, 4, 0), a(b, 5, 0));
    }

    private static int a(Integer[] numArr, int i, int i2) {
        Integer num;
        return (numArr == null || numArr.length <= i || (num = numArr[i]) == null) ? i2 : num.intValue();
    }

    static Integer[] b(String str) {
        Integer num;
        if (str == null || str.isEmpty()) {
            return null;
        }
        String[] split = str.split(",");
        Integer[] numArr = new Integer[split.length];
        int length = split.length;
        for (int i = 0; i < length; i++) {
            try {
                num = Integer.valueOf(Integer.parseInt(split[i].trim()));
            } catch (NumberFormatException unused) {
                num = null;
            }
            numArr[i] = num;
        }
        return numArr;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.c == bVar.c && this.d == bVar.d && this.b == bVar.b && this.e == bVar.e && this.f == bVar.f;
    }

    public String toString() {
        return a();
    }

    public String a() {
        StringBuilder sb = new StringBuilder(64);
        sb.append(this.c);
        sb.append(',');
        sb.append(this.d);
        sb.append(',');
        sb.append(0);
        sb.append(',');
        sb.append(this.b.g);
        sb.append(',');
        sb.append(this.e);
        sb.append(',');
        sb.append(this.f);
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public enum a {
        DEFAULT(0),
        IVTIME_TELECOM(1),
        ZTE(2),
        HUAWEI(3),
        IVTIME_MOBILE(4),
        IVTIME_TELECOM_OLD(5);

        public final int g;

        a(int i) {
            this.g = i;
        }

        public static a a(int i) {
            for (a aVar : values()) {
                if (i == aVar.g) {
                    return aVar;
                }
            }
            return DEFAULT;
        }
    }
}
