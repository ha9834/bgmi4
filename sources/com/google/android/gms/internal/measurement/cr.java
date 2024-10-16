package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cr extends bg<Long> implements di, zzfg, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final cr f4508a;
    private long[] b;
    private int c;

    public static cr b() {
        return f4508a;
    }

    cr() {
        this(new long[10], 0);
    }

    private cr(long[] jArr, int i) {
        this.b = jArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.b;
        System.arraycopy(jArr, i2, jArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cr)) {
            return super.equals(obj);
        }
        cr crVar = (cr) obj;
        if (this.c != crVar.c) {
            return false;
        }
        long[] jArr = crVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + zzez.zzbx(this.b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.zzff
    /* renamed from: zzbv, reason: merged with bridge method [inline-methods] */
    public final zzfg zzap(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new cr(Arrays.copyOf(this.b, i), this.c);
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    public final long getLong(int i) {
        a(i);
        return this.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    public final void zzby(long j) {
        a(this.c, j);
    }

    private final void a(int i, long j) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        long[] jArr = this.b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.b, i, jArr2, i + 1, this.c - i);
            this.b = jArr2;
        }
        this.b[i] = j;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        a();
        zzez.a(collection);
        if (!(collection instanceof cr)) {
            return super.addAll(collection);
        }
        cr crVar = (cr) collection;
        int i = crVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.b;
        if (i3 > jArr.length) {
            this.b = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(crVar.b, 0, this.b, this.c, crVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Long.valueOf(this.b[i]))) {
                long[] jArr = this.b;
                System.arraycopy(jArr, i + 1, jArr, i, (this.c - i) - 1);
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

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        a();
        a(i);
        long[] jArr = this.b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        a(i);
        long[] jArr = this.b;
        long j = jArr[i];
        if (i < this.c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.measurement.bg, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        cr crVar = new cr(new long[0], 0);
        f4508a = crVar;
        crVar.zzry();
    }
}
