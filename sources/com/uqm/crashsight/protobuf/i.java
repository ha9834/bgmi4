package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class i extends a<Double> implements Internal.DoubleList, aj, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final i f6824a;
    private double[] b;
    private int c;

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        double doubleValue = ((Double) obj).doubleValue();
        c();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        double[] dArr = this.b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.b, i, dArr2, i + 1, this.c - i);
            this.b = dArr2;
        }
        this.b[i] = doubleValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Double) obj).doubleValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Double.valueOf(b(i));
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        d(i);
        double[] dArr = this.b;
        double d = dArr[i];
        if (i < this.c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        c();
        d(i);
        double[] dArr = this.b;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    static {
        i iVar = new i(new double[0], 0);
        f6824a = iVar;
        iVar.b();
    }

    public static i d() {
        return f6824a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i() {
        this(new double[10], 0);
    }

    private i(double[] dArr, int i) {
        this.b = dArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.b;
        System.arraycopy(dArr, i2, dArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return super.equals(obj);
        }
        i iVar = (i) obj;
        if (this.c != iVar.c) {
            return false;
        }
        double[] dArr = iVar.b;
        for (int i = 0; i < this.c; i++) {
            if (Double.doubleToLongBits(this.b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Internal.a(Double.doubleToLongBits(this.b[i2]));
        }
        return i;
    }

    @Override // com.uqm.crashsight.protobuf.Internal.ProtobufList
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Internal.DoubleList c(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new i(Arrays.copyOf(this.b, i), this.c);
    }

    public final double b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        return this.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(double d) {
        c();
        int i = this.c;
        double[] dArr = this.b;
        if (i == dArr.length) {
            double[] dArr2 = new double[((i * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.b = dArr2;
        }
        double[] dArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        dArr3[i2] = d;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        c();
        Internal.a(collection);
        if (!(collection instanceof i)) {
            return super.addAll(collection);
        }
        i iVar = (i) collection;
        int i = iVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.b;
        if (i3 > dArr.length) {
            this.b = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(iVar.b, 0, this.b, this.c, iVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Double.valueOf(this.b[i]))) {
                double[] dArr = this.b;
                System.arraycopy(dArr, i + 1, dArr, i, (this.c - i) - 1);
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
