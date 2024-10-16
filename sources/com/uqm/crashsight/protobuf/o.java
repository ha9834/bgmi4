package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class o extends a<Float> implements Internal.FloatList, aj, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final o f6830a;
    private float[] b;
    private int c;

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        float floatValue = ((Float) obj).floatValue();
        c();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        float[] fArr = this.b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.b, i, fArr2, i + 1, this.c - i);
            this.b = fArr2;
        }
        this.b[i] = floatValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Float) obj).floatValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Float.valueOf(b(i));
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        d(i);
        float[] fArr = this.b;
        float f = fArr[i];
        if (i < this.c - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Float.valueOf(f);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        c();
        d(i);
        float[] fArr = this.b;
        float f = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f);
    }

    static {
        o oVar = new o(new float[0], 0);
        f6830a = oVar;
        oVar.b();
    }

    public static o d() {
        return f6830a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this(new float[10], 0);
    }

    private o(float[] fArr, int i) {
        this.b = fArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.b;
        System.arraycopy(fArr, i2, fArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        if (this.c != oVar.c) {
            return false;
        }
        float[] fArr = oVar.b;
        for (int i = 0; i < this.c; i++) {
            if (Float.floatToIntBits(this.b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.b[i2]);
        }
        return i;
    }

    @Override // com.uqm.crashsight.protobuf.Internal.ProtobufList
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Internal.FloatList c(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new o(Arrays.copyOf(this.b, i), this.c);
    }

    public final float b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        return this.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(float f) {
        c();
        int i = this.c;
        float[] fArr = this.b;
        if (i == fArr.length) {
            float[] fArr2 = new float[((i * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.b = fArr2;
        }
        float[] fArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        c();
        Internal.a(collection);
        if (!(collection instanceof o)) {
            return super.addAll(collection);
        }
        o oVar = (o) collection;
        int i = oVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        float[] fArr = this.b;
        if (i3 > fArr.length) {
            this.b = Arrays.copyOf(fArr, i3);
        }
        System.arraycopy(oVar.b, 0, this.b, this.c, oVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Float.valueOf(this.b[i]))) {
                float[] fArr = this.b;
                System.arraycopy(fArr, i + 1, fArr, i, (this.c - i) - 1);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private void d(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
    }
}
