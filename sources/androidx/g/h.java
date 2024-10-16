package androidx.g;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* loaded from: classes.dex */
class h<T> extends Property<T, Float> {

    /* renamed from: a, reason: collision with root package name */
    private final Property<T, PointF> f727a;
    private final PathMeasure b;
    private final float c;
    private final float[] d;
    private final PointF e;
    private float f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.d = new float[2];
        this.e = new PointF();
        this.f727a = property;
        this.b = new PathMeasure(path, false);
        this.c = this.b.getLength();
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Float get(T t) {
        return Float.valueOf(this.f);
    }

    @Override // android.util.Property
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void set(T t, Float f) {
        this.f = f.floatValue();
        this.b.getPosTan(this.c * f.floatValue(), this.d, null);
        PointF pointF = this.e;
        float[] fArr = this.d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f727a.set(t, pointF);
    }
}
