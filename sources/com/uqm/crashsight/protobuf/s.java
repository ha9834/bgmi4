package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class s extends a<Long> implements Internal.LongList, aj, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final s f6835a;
    private long[] b;
    private int c;

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        long longValue = ((Long) obj).longValue();
        c();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
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
        this.b[i] = longValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Long) obj).longValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(b(i));
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        d(i);
        long[] jArr = this.b;
        long j = jArr[i];
        if (i < this.c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Long.valueOf(j);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        c();
        d(i);
        long[] jArr = this.b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    static {
        s sVar = new s(new long[0], 0);
        f6835a = sVar;
        sVar.b();
    }

    public static s d() {
        return f6835a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s() {
        this(new long[10], 0);
    }

    private s(long[] jArr, int i) {
        this.b = jArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.b;
        System.arraycopy(jArr, i2, jArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return super.equals(obj);
        }
        s sVar = (s) obj;
        if (this.c != sVar.c) {
            return false;
        }
        long[] jArr = sVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.c; i2++) {
            i = (i * 31) + Internal.a(this.b[i2]);
        }
        return i;
    }

    @Override // com.uqm.crashsight.protobuf.Internal.ProtobufList
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Internal.LongList c(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new s(Arrays.copyOf(this.b, i), this.c);
    }

    public final long b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        return this.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(long j) {
        c();
        int i = this.c;
        long[] jArr = this.b;
        if (i == jArr.length) {
            long[] jArr2 = new long[((i * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.b = jArr2;
        }
        long[] jArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        c();
        Internal.a(collection);
        if (!(collection instanceof s)) {
            return super.addAll(collection);
        }
        s sVar = (s) collection;
        int i = sVar.c;
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
        System.arraycopy(sVar.b, 0, this.b, this.c, sVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
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

    private void d(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
    }
}
