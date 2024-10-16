package com.google.android.material.a;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class f extends Property<ImageView, Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final Matrix f5208a;

    public f() {
        super(Matrix.class, "imageMatrixProperty");
        this.f5208a = new Matrix();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Matrix get(ImageView imageView) {
        this.f5208a.set(imageView.getImageMatrix());
        return this.f5208a;
    }
}
