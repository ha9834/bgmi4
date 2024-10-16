package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class aeq extends aem<Boolean> implements agr, zzdoj<Boolean>, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final aeq f1836a;
    private boolean[] b;
    private int c;

    aeq() {
        this(new boolean[10], 0);
    }

    private aeq(boolean[] zArr, int i) {
        this.b = zArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        a();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.b;
        System.arraycopy(zArr, i2, zArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aeq)) {
            return super.equals(obj);
        }
        aeq aeqVar = (aeq) obj;
        if (this.c != aeqVar.c) {
            return false;
        }
        boolean[] zArr = aeqVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + zzdod.zzbh(this.b[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(boolean z) {
        a(this.c, z);
    }

    private final void a(int i, boolean z) {
        int i2;
        a();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        boolean[] zArr = this.b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.b, i, zArr2, i + 1, this.c - i);
            this.b = zArr2;
        }
        this.b[i] = z;
        this.c++;
        this.modCount++;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        a();
        zzdod.a(collection);
        if (!(collection instanceof aeq)) {
            return super.addAll(collection);
        }
        aeq aeqVar = (aeq) collection;
        int i = aeqVar.c;
        if (i == 0) {
            return false;
        }
        int i2 = this.c;
        if (Integer.MAX_VALUE - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.b;
        if (i3 > zArr.length) {
            this.b = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(aeqVar.b, 0, this.b, this.c, aeqVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.c; i++) {
            if (obj.equals(Boolean.valueOf(this.b[i]))) {
                boolean[] zArr = this.b;
                System.arraycopy(zArr, i + 1, zArr, i, (this.c - i) - 1);
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
        boolean booleanValue = ((Boolean) obj).booleanValue();
        a();
        a(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        a();
        a(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        if (i < this.c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.ads.aem, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.zzdoj
    public final /* synthetic */ zzdoj<Boolean> zzfl(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new aeq(Arrays.copyOf(this.b, i), this.c);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Boolean.valueOf(this.b[i]);
    }

    static {
        aeq aeqVar = new aeq(new boolean[0], 0);
        f1836a = aeqVar;
        aeqVar.zzavj();
    }
}
