package com.uqm.crashsight.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* loaded from: classes3.dex */
public final class Internal {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f6726a = Charset.forName("UTF-8");
    static final Charset b = Charset.forName("ISO-8859-1");
    public static final byte[] c;

    /* loaded from: classes3.dex */
    public interface BooleanList extends ProtobufList<Boolean> {
        BooleanList a(int i);
    }

    /* loaded from: classes3.dex */
    public interface DoubleList extends ProtobufList<Double> {
        DoubleList a(int i);
    }

    /* loaded from: classes3.dex */
    public interface EnumLite {
        int a();
    }

    /* loaded from: classes3.dex */
    public interface EnumLiteMap<T extends EnumLite> {
        T a(int i);
    }

    /* loaded from: classes3.dex */
    public interface EnumVerifier {
        boolean a(int i);
    }

    /* loaded from: classes3.dex */
    public interface FloatList extends ProtobufList<Float> {
        FloatList a(int i);
    }

    /* loaded from: classes3.dex */
    public interface IntList extends ProtobufList<Integer> {
        IntList a(int i);

        int b(int i);

        void d(int i);
    }

    /* loaded from: classes3.dex */
    public interface LongList extends ProtobufList<Long> {
        LongList a(int i);
    }

    /* loaded from: classes3.dex */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        boolean a();

        void b();

        ProtobufList<E> c(int i);
    }

    public static int a(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int a(boolean z) {
        return z ? 1231 : 1237;
    }

    private Internal() {
    }

    static {
        byte[] bArr = new byte[0];
        c = bArr;
        ByteBuffer.wrap(bArr);
        CodedInputStream.a(c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean a(byte[] bArr) {
        return Utf8.a(bArr);
    }

    public static byte[] a(String str) {
        return str.getBytes(f6726a);
    }

    public static String b(byte[] bArr) {
        return new String(bArr, f6726a);
    }

    public static int a(EnumLite enumLite) {
        return enumLite.a();
    }

    public static int a(List<? extends EnumLite> list) {
        Iterator<? extends EnumLite> it = list.iterator();
        int i = 1;
        while (it.hasNext()) {
            i = (i * 31) + it.next().a();
        }
        return i;
    }

    public static int c(byte[] bArr) {
        int length = bArr.length;
        int i = length;
        for (int i2 = 0; i2 < 0 + length; i2++) {
            i = (i * 31) + bArr[i2];
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, Object obj2) {
        return ((MessageLite) obj).toBuilder().mergeFrom((MessageLite) obj2).buildPartial();
    }

    /* loaded from: classes3.dex */
    public static class ListAdapter<F, T> extends AbstractList<T> {

        /* renamed from: a, reason: collision with root package name */
        private final List<F> f6727a;
        private final Converter<F, T> b;

        /* loaded from: classes3.dex */
        public interface Converter<F, T> {
            T a();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            Converter<F, T> converter = this.b;
            this.f6727a.get(i);
            return converter.a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f6727a.size();
        }
    }

    /* loaded from: classes3.dex */
    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final Map<K, RealValue> f6728a;
        private final Converter<RealValue, V> b;

        /* loaded from: classes3.dex */
        public interface Converter<A, B> {
            A a(B b);

            B b(A a2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            RealValue realvalue = this.f6728a.get(obj);
            if (realvalue == null) {
                return null;
            }
            return this.b.b(realvalue);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public V put(K k, V v) {
            Object put = this.f6728a.put(k, this.b.a(v));
            if (put == null) {
                return null;
            }
            return (V) this.b.b(put);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new c(this.f6728a.entrySet());
        }

        /* loaded from: classes3.dex */
        class c extends AbstractSet<Map.Entry<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            private final Set<Map.Entry<K, RealValue>> f6731a;

            public c(Set<Map.Entry<K, RealValue>> set) {
                this.f6731a = set;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, V>> iterator() {
                return new b(this.f6731a.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f6731a.size();
            }
        }

        /* loaded from: classes3.dex */
        class b implements Iterator<Map.Entry<K, V>> {

            /* renamed from: a, reason: collision with root package name */
            private final Iterator<Map.Entry<K, RealValue>> f6730a;

            @Override // java.util.Iterator
            public /* synthetic */ Object next() {
                return new a(this.f6730a.next());
            }

            public b(Iterator<Map.Entry<K, RealValue>> it) {
                this.f6730a = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f6730a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f6730a.remove();
            }
        }

        /* loaded from: classes3.dex */
        class a implements Map.Entry<K, V> {

            /* renamed from: a, reason: collision with root package name */
            private final Map.Entry<K, RealValue> f6729a;

            public a(Map.Entry<K, RealValue> entry) {
                this.f6729a = entry;
            }

            @Override // java.util.Map.Entry
            public K getKey() {
                return this.f6729a.getKey();
            }

            @Override // java.util.Map.Entry
            public V getValue() {
                return (V) MapAdapter.this.b.b(this.f6729a.getValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public V setValue(V v) {
                Object value = this.f6729a.setValue(MapAdapter.this.b.a(v));
                if (value == null) {
                    return null;
                }
                return (V) MapAdapter.this.b.b(value);
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                return (obj instanceof Map.Entry) && getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue());
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.f6729a.hashCode();
            }
        }
    }
}
