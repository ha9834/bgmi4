package com.ihoc.mgpa.e.a;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    String f5512a;
    int b;
    int c;
    int d;
    int e;
    public long f;
    int h;
    public boolean g = true;
    public int i = 0;

    public b(String str, int i, int i2, int i3, int i4) {
        this.f5512a = str;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }

    public int a() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int b() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public int d() {
        return this.b;
    }

    public void d(int i) {
        this.h = i;
    }

    public String e() {
        return this.f5512a;
    }

    public int f() {
        return this.h;
    }

    public String toString() {
        return "NonRichTapLooperInfo{mPattern='" + this.f5512a + "', mLooper=" + this.b + ", mInterval=" + this.c + ", mAmplitude=" + this.d + ", mFreq=" + this.e + ", mWhen=" + this.f + ", mValid=" + this.g + ", mPatternLastTime=" + this.h + ", mHasVibNum=" + this.i + '}';
    }
}
