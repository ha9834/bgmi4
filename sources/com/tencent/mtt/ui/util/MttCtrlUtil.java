package com.tencent.mtt.ui.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Picture;

/* loaded from: classes.dex */
public class MttCtrlUtil {
    public static Bitmap getScaleBitmap(Picture picture, int i, int i2, boolean z, boolean z2, Bitmap.Config config) {
        if (picture == null || i <= 0 || i2 <= 0 || picture.getHeight() <= 0 || picture.getWidth() <= 0) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
            float f = 1.0f;
            if (z) {
                float f2 = i;
                float f3 = i2;
                if (f2 / f3 > picture.getHeight() / picture.getWidth()) {
                    f = f3 / picture.getHeight();
                } else {
                    f = f2 / picture.getWidth();
                }
            }
            Canvas canvas = new Canvas(createBitmap);
            if (z) {
                canvas.scale(f, f);
            }
            canvas.drawPicture(picture);
            return createBitmap;
        } catch (OutOfMemoryError unused) {
            return null;
        }
    }
}
