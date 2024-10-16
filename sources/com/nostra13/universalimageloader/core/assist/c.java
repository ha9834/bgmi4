package com.nostra13.universalimageloader.core.assist;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final int f5736a;
    private final int b;

    public c(int i, int i2) {
        this.f5736a = i;
        this.b = i2;
    }

    public c(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.f5736a = i;
            this.b = i2;
        } else {
            this.f5736a = i2;
            this.b = i;
        }
    }

    public int a() {
        return this.f5736a;
    }

    public int b() {
        return this.b;
    }

    public c a(int i) {
        return new c(this.f5736a / i, this.b / i);
    }

    public c a(float f) {
        return new c((int) (this.f5736a * f), (int) (this.b * f));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(9);
        sb.append(this.f5736a);
        sb.append("x");
        sb.append(this.b);
        return sb.toString();
    }
}
