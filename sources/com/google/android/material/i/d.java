package com.google.android.material.i;

import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import java.util.List;

/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public float f5278a;
    public float b;
    public float c;
    public float d;
    private final List<c> e;

    /* loaded from: classes2.dex */
    public static abstract class c {
        protected final Matrix g = new Matrix();

        public abstract void a(Matrix matrix, Path path);
    }

    public void a(float f, float f2) {
        this.f5278a = f;
        this.b = f2;
        this.c = f;
        this.d = f2;
        this.e.clear();
    }

    public void b(float f, float f2) {
        b bVar = new b();
        bVar.f5280a = f;
        bVar.b = f2;
        this.e.add(bVar);
        this.c = f;
        this.d = f2;
    }

    public void a(float f, float f2, float f3, float f4, float f5, float f6) {
        a aVar = new a(f, f2, f3, f4);
        aVar.e = f5;
        aVar.f = f6;
        this.e.add(aVar);
        double d = f5 + f6;
        this.c = ((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(d))));
        this.d = ((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(d))));
    }

    public void a(Matrix matrix, Path path) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.get(i).a(matrix, path);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends c {

        /* renamed from: a, reason: collision with root package name */
        private float f5280a;
        private float b;

        @Override // com.google.android.material.i.d.c
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.f5280a, this.b);
            path.transform(matrix);
        }
    }

    /* loaded from: classes2.dex */
    public static class a extends c {
        private static final RectF h = new RectF();

        /* renamed from: a, reason: collision with root package name */
        public float f5279a;
        public float b;
        public float c;
        public float d;
        public float e;
        public float f;

        public a(float f, float f2, float f3, float f4) {
            this.f5279a = f;
            this.b = f2;
            this.c = f3;
            this.d = f4;
        }

        @Override // com.google.android.material.i.d.c
        public void a(Matrix matrix, Path path) {
            Matrix matrix2 = this.g;
            matrix.invert(matrix2);
            path.transform(matrix2);
            h.set(this.f5279a, this.b, this.c, this.d);
            path.arcTo(h, this.e, this.f, false);
            path.transform(matrix);
        }
    }
}
