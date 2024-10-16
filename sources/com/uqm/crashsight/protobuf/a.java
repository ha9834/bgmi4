package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
abstract class a<E> extends AbstractList<E> implements Internal.ProtobufList<E> {

    /* renamed from: a, reason: collision with root package name */
    private boolean f6785a = true;

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        return super.add(e);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        super.add(i, e);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        return super.addAll(i, collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        super.clear();
    }

    public boolean a() {
        return this.f6785a;
    }

    @Override // com.uqm.crashsight.protobuf.Internal.ProtobufList
    public final void b() {
        this.f6785a = false;
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        return (E) super.remove(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
        return (E) super.set(i, e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        if (!this.f6785a) {
            throw new UnsupportedOperationException();
        }
    }
}
