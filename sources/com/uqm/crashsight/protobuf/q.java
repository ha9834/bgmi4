package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class q extends a<Integer> implements Internal.IntList, aj, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final q f6832a;
    private int[] b;
    private int c;

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        int intValue = ((Integer) obj).intValue();
        c();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        int[] iArr = this.b;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.b, i, iArr2, i + 1, this.c - i);
            this.b = iArr2;
        }
        this.b[i] = intValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        d(((Integer) obj).intValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(b(i));
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        e(i);
        int[] iArr = this.b;
        int i2 = iArr[i];
        if (i < this.c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        c();
        e(i);
        int[] iArr = this.b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    static {
        q qVar = new q(new int[0], 0);
        f6832a = qVar;
        qVar.b();
    }

    public static q d() {
        return f6832a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q() {
        this(new int[10], 0);
    }

    private q(int[] iArr, int i) {
        this.b = iArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.b;
        System.arraycopy(iArr, i2, iArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return super.equals(obj);
        }
        q qVar = (q) obj;
        if (this.c != qVar.c) {
            return false;
        }
        int[] iArr = qVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + this.b[i2];
        }
        return i;
    }

    @Override // com.uqm.crashsight.protobuf.Internal.ProtobufList
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Internal.IntList c(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new q(Arrays.copyOf(this.b, i), this.c);
    }

    @Override // com.uqm.crashsight.protobuf.Internal.IntList
    public final int b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        return this.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    @Override // com.uqm.crashsight.protobuf.Internal.IntList
    public final void d(int i) {
        c();
        int i2 = this.c;
        int[] iArr = this.b;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[((i2 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.b = iArr2;
        }
        int[] iArr3 = this.b;
        int i3 = this.c;
        this.c = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        c();
        Internal.a(collection);
        if (!(collection instanceof q)) {
            return super.addAll(collection);
        }
        q qVar = (q) collection;
        int i = qVar.c;
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
        System.arraycopy(qVar.b, 0, this.b, this.c, qVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
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

    private void e(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
    }
}
