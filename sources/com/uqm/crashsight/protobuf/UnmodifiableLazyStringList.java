package com.uqm.crashsight.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class UnmodifiableLazyStringList extends AbstractList<String> implements LazyStringList, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final LazyStringList f6775a;

    @Override // com.uqm.crashsight.protobuf.LazyStringList
    public final LazyStringList e() {
        return this;
    }

    @Override // java.util.AbstractList, java.util.List
    public /* bridge */ /* synthetic */ Object get(int i) {
        return (String) this.f6775a.get(i);
    }

    public UnmodifiableLazyStringList(LazyStringList lazyStringList) {
        this.f6775a = lazyStringList;
    }

    @Override // com.uqm.crashsight.protobuf.LazyStringList
    public final Object b(int i) {
        return this.f6775a.b(i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f6775a.size();
    }

    @Override // com.uqm.crashsight.protobuf.LazyStringList
    public final void a(ByteString byteString) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<String> listIterator(final int i) {
        return new ListIterator<String>() { // from class: com.uqm.crashsight.protobuf.UnmodifiableLazyStringList.1

            /* renamed from: a, reason: collision with root package name */
            private ListIterator<String> f6776a;

            {
                this.f6776a = UnmodifiableLazyStringList.this.f6775a.listIterator(i);
            }

            @Override // java.util.ListIterator
            public /* synthetic */ void add(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public /* bridge */ /* synthetic */ Object next() {
                return this.f6776a.next();
            }

            @Override // java.util.ListIterator
            public /* bridge */ /* synthetic */ String previous() {
                return this.f6776a.previous();
            }

            @Override // java.util.ListIterator
            public /* synthetic */ void set(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f6776a.hasNext();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f6776a.hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return this.f6776a.nextIndex();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return this.f6776a.previousIndex();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<String> iterator() {
        return new Iterator<String>() { // from class: com.uqm.crashsight.protobuf.UnmodifiableLazyStringList.2

            /* renamed from: a, reason: collision with root package name */
            private Iterator<String> f6777a;

            {
                this.f6777a = UnmodifiableLazyStringList.this.f6775a.iterator();
            }

            @Override // java.util.Iterator
            public /* bridge */ /* synthetic */ String next() {
                return this.f6777a.next();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6777a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    @Override // com.uqm.crashsight.protobuf.LazyStringList
    public final List<?> d() {
        return this.f6775a.d();
    }
}
