package androidx.d.a.a;

import android.view.animation.Interpolator;

/* loaded from: classes.dex */
abstract class d implements Interpolator {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f587a;
    private final float b;

    /* JADX INFO: Access modifiers changed from: protected */
    public d(float[] fArr) {
        this.f587a = fArr;
        this.b = 1.0f / (this.f587a.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f587a;
        int min = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.b;
        float f3 = (f - (min * f2)) / f2;
        float[] fArr2 = this.f587a;
        return fArr2[min] + (f3 * (fArr2[min + 1] - fArr2[min]));
    }
}
