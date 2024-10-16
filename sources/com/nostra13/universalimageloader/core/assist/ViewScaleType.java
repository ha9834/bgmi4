package com.nostra13.universalimageloader.core.assist;

import android.widget.ImageView;

/* loaded from: classes2.dex */
public enum ViewScaleType {
    FIT_INSIDE,
    CROP;

    /* renamed from: com.nostra13.universalimageloader.core.assist.ViewScaleType$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5734a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f5734a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5734a[ImageView.ScaleType.FIT_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5734a[ImageView.ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5734a[ImageView.ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5734a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5734a[ImageView.ScaleType.MATRIX.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5734a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5734a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static ViewScaleType a(ImageView imageView) {
        switch (AnonymousClass1.f5734a[imageView.getScaleType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return FIT_INSIDE;
            default:
                return CROP;
        }
    }
}
