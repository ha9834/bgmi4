package com.google.android.gms.common.images;

/* loaded from: classes.dex */
public final class Size {

    /* renamed from: a, reason: collision with root package name */
    private final int f1428a;
    private final int b;

    public Size(int i, int i2) {
        this.f1428a = i;
        this.b = i2;
    }

    public final int getWidth() {
        return this.f1428a;
    }

    public final int getHeight() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return this.f1428a == size.f1428a && this.b == size.b;
    }

    public final String toString() {
        int i = this.f1428a;
        int i2 = this.b;
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        return sb.toString();
    }

    private static NumberFormatException a(String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 16);
        sb.append("Invalid Size: \"");
        sb.append(str);
        sb.append("\"");
        throw new NumberFormatException(sb.toString());
    }

    public static Size parseSize(String str) throws NumberFormatException {
        if (str == null) {
            throw new IllegalArgumentException("string must not be null");
        }
        int indexOf = str.indexOf(42);
        if (indexOf < 0) {
            indexOf = str.indexOf(120);
        }
        if (indexOf < 0) {
            throw a(str);
        }
        try {
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (NumberFormatException unused) {
            throw a(str);
        }
    }

    public final int hashCode() {
        int i = this.b;
        int i2 = this.f1428a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }
}
