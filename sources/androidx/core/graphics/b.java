package androidx.core.graphics;

import android.graphics.Color;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static final ThreadLocal<double[]> f555a = new ThreadLocal<>();

    public static int a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int c = c(alpha2, alpha);
        return Color.argb(c, a(Color.red(i), alpha2, Color.red(i2), alpha, c), a(Color.green(i), alpha2, Color.green(i2), alpha, c), a(Color.blue(i), alpha2, Color.blue(i2), alpha, c));
    }

    private static int c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }

    private static int a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int b(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }

    public static int a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }
}
