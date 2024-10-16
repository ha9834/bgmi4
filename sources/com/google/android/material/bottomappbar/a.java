package com.google.android.material.bottomappbar;

import com.google.android.material.i.b;
import com.google.android.material.i.d;

/* loaded from: classes2.dex */
public class a extends b {

    /* renamed from: a, reason: collision with root package name */
    private float f5238a;
    private float b;
    private float c;
    private float d;
    private float e;

    @Override // com.google.android.material.i.b
    public void a(float f, float f2, d dVar) {
        float f3 = this.c;
        if (f3 == 0.0f) {
            dVar.b(f, 0.0f);
            return;
        }
        float f4 = ((this.b * 2.0f) + f3) / 2.0f;
        float f5 = f2 * this.f5238a;
        float f6 = (f / 2.0f) + this.e;
        float f7 = (this.d * f2) + ((1.0f - f2) * f4);
        if (f7 / f4 >= 1.0f) {
            dVar.b(f, 0.0f);
            return;
        }
        float f8 = f4 + f5;
        float f9 = f7 + f5;
        float sqrt = (float) Math.sqrt((f8 * f8) - (f9 * f9));
        float f10 = f6 - sqrt;
        float f11 = f6 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f9));
        float f12 = 90.0f - degrees;
        float f13 = f10 - f5;
        dVar.b(f13, 0.0f);
        float f14 = f5 * 2.0f;
        dVar.a(f13, 0.0f, f10 + f5, f14, 270.0f, degrees);
        dVar.a(f6 - f4, (-f4) - f7, f6 + f4, f4 - f7, 180.0f - f12, (f12 * 2.0f) - 180.0f);
        dVar.a(f11 - f5, 0.0f, f11 + f5, f14, 270.0f - degrees, degrees);
        dVar.b(f, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        this.e = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        this.d = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        this.c = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        this.b = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f5238a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f) {
        this.f5238a = f;
    }
}
