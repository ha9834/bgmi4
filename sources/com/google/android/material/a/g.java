package com.google.android.material.a;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f5209a = new float[9];
    private final float[] b = new float[9];
    private final Matrix c = new Matrix();

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f5209a);
        matrix2.getValues(this.b);
        for (int i = 0; i < 9; i++) {
            float[] fArr = this.b;
            float f2 = fArr[i];
            float[] fArr2 = this.f5209a;
            fArr[i] = fArr2[i] + ((f2 - fArr2[i]) * f);
        }
        this.c.setValues(this.b);
        return this.c;
    }
}
