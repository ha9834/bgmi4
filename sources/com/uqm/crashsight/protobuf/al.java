package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class al<E> extends a<E> implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private static final al<Object> f6792a;
    private E[] b;
    private int c;

    @Override // com.uqm.crashsight.protobuf.Internal.ProtobufList
    public final /* synthetic */ Internal.ProtobufList c(int i) {
        if (i >= this.c) {
            return new al(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    static {
        al<Object> alVar = new al<>(new Object[0], 0);
        f6792a = alVar;
        alVar.b();
    }

    public static <E> al<E> d() {
        return (al<E>) f6792a;
    }

    al() {
        this(new Object[10], 0);
    }

    private al(E[] eArr, int i) {
        this.b = eArr;
        this.c = i;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(E e) {
        c();
        int i = this.c;
        E[] eArr = this.b;
        if (i == eArr.length) {
            this.b = (E[]) Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final void add(int i, E e) {
        int i2;
        c();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        E[] eArr = this.b;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = (E[]) new Object[((i2 * 3) / 2) + 1];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.b, i, eArr2, i + 1, this.c - i);
            this.b = eArr2;
        }
        this.b[i] = e;
        this.c++;
        this.modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final E get(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        return this.b[i];
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final E remove(int i) {
        int i2;
        c();
        if (i < 0 || i >= (i2 = this.c)) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        E[] eArr = this.b;
        E e = eArr[i];
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return e;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public final E set(int i, E e) {
        c();
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException("Index:" + i + ", Size:" + this.c);
        }
        E[] eArr = this.b;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.c;
    }
}
