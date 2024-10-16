package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class e extends a<Boolean> implements Internal.BooleanList, aj, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final e f6811a;
    private boolean[] b;
    private int c;

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        int i2;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
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
        this.b[i] = booleanValue;
        this.c++;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* synthetic */ boolean add(Object obj) {
        a(((Boolean) obj).booleanValue());
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Boolean.valueOf(b(i));
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        c();
        d(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        if (i < this.c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        c();
        d(i);
        boolean[] zArr = this.b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    static {
        e eVar = new e(new boolean[0], 0);
        f6811a = eVar;
        eVar.b();
    }

    public static e d() {
        return f6811a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e() {
        this(new boolean[10], 0);
    }

    private e(boolean[] zArr, int i) {
        this.b = zArr;
        this.c = i;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        c();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.b;
        System.arraycopy(zArr, i2, zArr, i, this.c - i2);
        this.c -= i2 - i;
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return super.equals(obj);
        }
        e eVar = (e) obj;
        if (this.c != eVar.c) {
            return false;
        }
        boolean[] zArr = eVar.b;
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] != zArr[i]) {
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
    public final Internal.BooleanList c(int i) {
        if (i < this.c) {
            throw new IllegalArgumentException();
        }
        return new e(Arrays.copyOf(this.b, i), this.c);
    }

    public final boolean b(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        return this.b[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }

    public final void a(boolean z) {
        c();
        int i = this.c;
        boolean[] zArr = this.b;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[((i * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.b = zArr2;
        }
        boolean[] zArr3 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        zArr3[i2] = z;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        c();
        Internal.a(collection);
        if (!(collection instanceof e)) {
            return super.addAll(collection);
        }
        e eVar = (e) collection;
        int i = eVar.c;
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
        System.arraycopy(eVar.b, 0, this.b, this.c, eVar.c);
        this.c = i3;
        this.modCount++;
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        c();
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

    private void d(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
    }
}
