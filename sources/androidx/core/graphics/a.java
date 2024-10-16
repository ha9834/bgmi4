package androidx.core.graphics;

import android.graphics.Bitmap;
import android.os.Build;

/* loaded from: classes.dex */
public final class a {
    public static int a(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        return bitmap.getByteCount();
    }
}
