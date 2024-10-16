package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class aff extends aem<Double> implements agr, zzdoj<Double>, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final aff f1843a;
    private double[] b;
    private int c;

    aff() {
        this(new double[10], 0);
    }

    private aff(double[] dArr, int i) {
        this.b = dArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.b;
        System.arraycopy(dArr, i2, dArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aff)) {
            return super.equals(obj);
        }
        aff affVar = (aff) obj;
        if (this.c != affVar.c) {
            return false;
        }
        double[] dArr = affVar.b;
        for (int i = 0; i < this.c; i++) {
            if (Double.doubleToLongBits(this.b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + zzdod.zzft(Double.doubleToLongBits(this.b[i2]));
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(double d) {
        a(this.c, d);
    }

    private final void a(int i, double d) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(b(i));
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
        this.b[i] = d;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        a();
        zzdod.a(collection);
        if (!(collection instanceof aff)) {
            return super.addAll(collection);
        }
        aff affVar = (aff) collection;
        int i = affVar.c;
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
        System.arraycopy(affVar.b, 0, this.b, this.c, affVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
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

    private final void a(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    private final String b(int i) {
        int i2 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        a();
        a(i);
        double[] dArr = this.b;
        double d = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        a(i);
        double[] dArr = this.b;
        double d = dArr[i];
        if (i < this.c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Double.valueOf(d);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj<Double> zzfl(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new aff(Arrays.copyOf(this.b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Double.valueOf(this.b[i]);
    }

    static {
        aff affVar = new aff(new double[0], 0);
        f1843a = affVar;
        affVar.zzavj();
    }
}
