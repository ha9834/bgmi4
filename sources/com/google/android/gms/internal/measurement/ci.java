package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ci extends bg<Integer> implements di, zzfd, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final ci f4502a;
    private int[] b;
    private int c;

    public static ci b() {
        return f4502a;
    }

    ci() {
        this(new int[10], 0);
    }

    private ci(int[] iArr, int i) {
        this.b = iArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.b;
        System.arraycopy(iArr, i2, iArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ci)) {
            return super.equals(obj);
        }
        ci ciVar = (ci) obj;
        if (this.c != ciVar.c) {
            return false;
        }
        int[] iArr = ciVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.b[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzff
    /* renamed from: zzbt, reason: merged with bridge method [inline-methods] */
    public final zzfd zzap(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new ci(Arrays.copyOf(this.b, i), this.c);
    }

    public final int a(int i) {
        c(i);
        return this.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void b(int i) {
        a(this.c, i);
    }

    private final void a(int i, int i2) {
        int i3;
        a();
        if (i < 0 || i > (i3 = this.c)) {
            throw new IndexOutOfBoundsException(d(i));
        }
        int[] iArr = this.b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.b, i, iArr2, i + 1, this.c - i);
            this.b = iArr2;
        }
        this.b[i] = i2;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        a();
        zzez.a(collection);
        if (!(collection instanceof ci)) {
            return super.addAll(collection);
        }
        ci ciVar = (ci) collection;
        int i = ciVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.b;
        if (i3 > iArr.length) {
            this.b = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(ciVar.b, 0, this.b, this.c, ciVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Integer.valueOf(this.b[i]))) {
                int[] iArr = this.b;
                System.arraycopy(iArr, i + 1, iArr, i, (this.c - i) - 1);
                this.c--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void c(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    private final String d(int i) {
        int i2 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        a();
        c(i);
        int[] iArr = this.b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        c(i);
        int[] iArr = this.b;
        int i2 = iArr[i];
        if (i < this.c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(a(i));
    }

    static {
        ci ciVar = new ci(new int[0], 0);
        f4502a = ciVar;
        ciVar.zzry();
    }
}
