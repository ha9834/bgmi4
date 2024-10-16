package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes3.dex */
public class LazyStringArrayList extends a<String> implements LazyStringList, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public static final LazyStringList f6738a;
    private static final LazyStringArrayList b;
    private final List<Object> c;

    static /* synthetic */ Object a(LazyStringArrayList lazyStringArrayList, int i, ByteString byteString) {
        lazyStringArrayList.c();
        return lazyStringArrayList.c.set(i, byteString);
    }

    static /* synthetic */ Object a(LazyStringArrayList lazyStringArrayList, int i, byte[] bArr) {
        lazyStringArrayList.c();
        return lazyStringArrayList.c.set(i, bArr);
    }

    static /* synthetic */ void b(LazyStringArrayList lazyStringArrayList, int i, ByteString byteString) {
        lazyStringArrayList.c();
        lazyStringArrayList.c.add(i, byteString);
        lazyStringArrayList.modCount++;
    }

    static /* synthetic */ void b(LazyStringArrayList lazyStringArrayList, int i, byte[] bArr) {
        lazyStringArrayList.c();
        lazyStringArrayList.c.add(i, bArr);
        lazyStringArrayList.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.a, com.uqm.crashsight.protobuf.Internal.ProtobufList
    public final /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public /* synthetic */ void add(int i, Object obj) {
        c();
        this.c.add(i, (String) obj);
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.Internal.ProtobufList
    public final /* synthetic */ Internal.ProtobufList c(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.c);
        return new LazyStringArrayList((ArrayList<Object>) arrayList);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public /* synthetic */ Object get(int i) {
        Object obj = this.c.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String f = byteString.f();
            if (byteString.g()) {
                this.c.set(i, f);
            }
            return f;
        }
        byte[] bArr = (byte[]) obj;
        String b2 = Internal.b(bArr);
        if (Internal.a(bArr)) {
            this.c.set(i, b2);
        }
        return b2;
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public /* synthetic */ Object remove(int i) {
        c();
        Object remove = this.c.remove(i);
        this.modCount++;
        return c(remove);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public /* synthetic */ Object set(int i, Object obj) {
        c();
        return c(this.c.set(i, (String) obj));
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        b = lazyStringArrayList;
        lazyStringArrayList.b();
        f6738a = b;
    }

    public LazyStringArrayList() {
        this(10);
    }

    public LazyStringArrayList(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public LazyStringArrayList(LazyStringList lazyStringList) {
        this.c = new ArrayList(lazyStringList.size());
        addAll(lazyStringList);
    }

    private LazyStringArrayList(ArrayList<Object> arrayList) {
        this.c = arrayList;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.c.size();
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends String> collection) {
        c();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).d();
        }
        boolean addAll = this.c.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public final String a(int i) {
        c();
        Object remove = this.c.remove(i);
        this.modCount++;
        return c(remove);
    }

    @Override // com.uqm.crashsight.protobuf.a, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        c();
        this.c.clear();
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.LazyStringList
    public final void a(ByteString byteString) {
        c();
        this.c.add(byteString);
        this.modCount++;
    }

    @Override // com.uqm.crashsight.protobuf.LazyStringList
    public final Object b(int i) {
        return this.c.get(i);
    }

    public final ByteString d(int i) {
        Object obj = this.c.get(i);
        ByteString d = d(obj);
        if (d != obj) {
            this.c.set(i, d);
        }
        return d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final byte[] e(int i) {
        Object obj = this.c.get(i);
        byte[] e = e(obj);
        if (e != obj) {
            this.c.set(i, e);
        }
        return e;
    }

    private static String c(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            return ((ByteString) obj).f();
        }
        return Internal.b((byte[]) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString d(Object obj) {
        if (obj instanceof ByteString) {
            return (ByteString) obj;
        }
        if (obj instanceof String) {
            return ByteString.a((String) obj);
        }
        return ByteString.a((byte[]) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] e(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return Internal.a((String) obj);
        }
        return ((ByteString) obj).d();
    }

    @Override // com.uqm.crashsight.protobuf.LazyStringList
    public final List<?> d() {
        return Collections.unmodifiableList(this.c);
    }

    @Override // com.uqm.crashsight.protobuf.LazyStringList
    public final LazyStringList e() {
        return super.a() ? new UnmodifiableLazyStringList(this) : this;
    }
}
