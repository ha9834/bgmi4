package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.MapEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
public class MapField<K, V> implements ad {

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f6743a;
    private volatile StorageMode b;
    private c<K, V> c;
    private List<Message> d;
    private final a<K, V> e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public enum StorageMode {
        MAP,
        LIST,
        BOTH
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface a<K, V> {
        Message a();

        Message a(K k, V v);

        void a(Message message, Map<K, V> map);
    }

    /* loaded from: classes3.dex */
    static class b<K, V> implements a<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final MapEntry<K, V> f6745a;

        public b(MapEntry<K, V> mapEntry) {
            this.f6745a = mapEntry;
        }

        @Override // com.uqm.crashsight.protobuf.MapField.a
        public final Message a(K k, V v) {
            return this.f6745a.f().a((MapEntry.Builder<K, V>) k).b((MapEntry.Builder<K, V>) v).c();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.uqm.crashsight.protobuf.MapField.a
        public final void a(Message message, Map<K, V> map) {
            MapEntry mapEntry = (MapEntry) message;
            map.put(mapEntry.c(), mapEntry.e());
        }

        @Override // com.uqm.crashsight.protobuf.MapField.a
        public final Message a() {
            return this.f6745a;
        }
    }

    private MapField(a<K, V> aVar, StorageMode storageMode, Map<K, V> map) {
        this.e = aVar;
        this.f6743a = true;
        this.b = storageMode;
        this.c = new c<>(this, map);
        this.d = null;
    }

    private MapField(MapEntry<K, V> mapEntry, StorageMode storageMode, Map<K, V> map) {
        this(new b(mapEntry), storageMode, map);
    }

    public static <K, V> MapField<K, V> a(MapEntry<K, V> mapEntry) {
        return new MapField<>(mapEntry, StorageMode.MAP, new LinkedHashMap());
    }

    private List<Message> a(c<K, V> cVar) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<K, V> entry : cVar.entrySet()) {
            arrayList.add(this.e.a((a<K, V>) entry.getKey(), (K) entry.getValue()));
        }
        return arrayList;
    }

    private c<K, V> a(List<Message> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Message> it = list.iterator();
        while (it.hasNext()) {
            this.e.a(it.next(), (Map) linkedHashMap);
        }
        return new c<>(this, linkedHashMap);
    }

    public final Map<K, V> a() {
        if (this.b == StorageMode.LIST) {
            synchronized (this) {
                if (this.b == StorageMode.LIST) {
                    this.c = a(this.d);
                    this.b = StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableMap(this.c);
    }

    public final Map<K, V> b() {
        if (this.b != StorageMode.MAP) {
            if (this.b == StorageMode.LIST) {
                this.c = a(this.d);
            }
            this.d = null;
            this.b = StorageMode.MAP;
        }
        return this.c;
    }

    public final void a(MapField<K, V> mapField) {
        b().putAll(MapFieldLite.b(mapField.a()));
    }

    public boolean equals(Object obj) {
        if (obj instanceof MapField) {
            return MapFieldLite.a(a(), ((MapField) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return MapFieldLite.a((Map) a());
    }

    public final MapField<K, V> c() {
        return new MapField<>(this.e, StorageMode.MAP, MapFieldLite.b(a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Message> d() {
        if (this.b == StorageMode.MAP) {
            synchronized (this) {
                if (this.b == StorageMode.MAP) {
                    this.d = a(this.c);
                    this.b = StorageMode.BOTH;
                }
            }
        }
        return Collections.unmodifiableList(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Message> e() {
        if (this.b != StorageMode.LIST) {
            if (this.b == StorageMode.MAP) {
                this.d = a(this.c);
            }
            this.c = null;
            this.b = StorageMode.LIST;
        }
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Message f() {
        return this.e.a();
    }

    public final void g() {
        this.f6743a = false;
    }

    public final boolean h() {
        return this.f6743a;
    }

    @Override // com.uqm.crashsight.protobuf.ad
    public final void i() {
        if (!this.f6743a) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c<K, V> implements Map<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final ad f6746a;
        private final Map<K, V> b;

        c(ad adVar, Map<K, V> map) {
            this.f6746a = adVar;
            this.b = map;
        }

        @Override // java.util.Map
        public int size() {
            return this.b.size();
        }

        @Override // java.util.Map
        public boolean isEmpty() {
            return this.b.isEmpty();
        }

        @Override // java.util.Map
        public boolean containsKey(Object obj) {
            return this.b.containsKey(obj);
        }

        @Override // java.util.Map
        public boolean containsValue(Object obj) {
            return this.b.containsValue(obj);
        }

        @Override // java.util.Map
        public V get(Object obj) {
            return this.b.get(obj);
        }

        @Override // java.util.Map
        public V put(K k, V v) {
            this.f6746a.i();
            Internal.a(k);
            Internal.a(v);
            return this.b.put(k, v);
        }

        @Override // java.util.Map
        public V remove(Object obj) {
            this.f6746a.i();
            return this.b.remove(obj);
        }

        @Override // java.util.Map
        public void putAll(Map<? extends K, ? extends V> map) {
            this.f6746a.i();
            for (K k : map.keySet()) {
                Internal.a(k);
                Internal.a(map.get(k));
            }
            this.b.putAll(map);
        }

        @Override // java.util.Map
        public void clear() {
            this.f6746a.i();
            this.b.clear();
        }

        @Override // java.util.Map
        public Set<K> keySet() {
            return new C0218c(this.f6746a, this.b.keySet());
        }

        @Override // java.util.Map
        public Collection<V> values() {
            return new a(this.f6746a, this.b.values());
        }

        @Override // java.util.Map
        public Set<Map.Entry<K, V>> entrySet() {
            return new C0218c(this.f6746a, this.b.entrySet());
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return this.b.equals(obj);
        }

        @Override // java.util.Map
        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return this.b.toString();
        }

        /* loaded from: classes3.dex */
        static class a<E> implements Collection<E> {

            /* renamed from: a, reason: collision with root package name */
            private final ad f6747a;
            private final Collection<E> b;

            a(ad adVar, Collection<E> collection) {
                this.f6747a = adVar;
                this.b = collection;
            }

            @Override // java.util.Collection
            public int size() {
                return this.b.size();
            }

            @Override // java.util.Collection
            public boolean isEmpty() {
                return this.b.isEmpty();
            }

            @Override // java.util.Collection
            public boolean contains(Object obj) {
                return this.b.contains(obj);
            }

            @Override // java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f6747a, this.b.iterator());
            }

            @Override // java.util.Collection
            public Object[] toArray() {
                return this.b.toArray();
            }

            @Override // java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.b.toArray(tArr);
            }

            @Override // java.util.Collection
            public boolean add(E e) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean remove(Object obj) {
                this.f6747a.i();
                return this.b.remove(obj);
            }

            @Override // java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.b.containsAll(collection);
            }

            @Override // java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.f6747a.i();
                return this.b.removeAll(collection);
            }

            @Override // java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.f6747a.i();
                return this.b.retainAll(collection);
            }

            @Override // java.util.Collection
            public void clear() {
                this.f6747a.i();
                this.b.clear();
            }

            @Override // java.util.Collection
            public boolean equals(Object obj) {
                return this.b.equals(obj);
            }

            @Override // java.util.Collection
            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return this.b.toString();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.uqm.crashsight.protobuf.MapField$c$c, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static class C0218c<E> implements Set<E> {

            /* renamed from: a, reason: collision with root package name */
            private final ad f6749a;
            private final Set<E> b;

            C0218c(ad adVar, Set<E> set) {
                this.f6749a = adVar;
                this.b = set;
            }

            @Override // java.util.Set, java.util.Collection
            public int size() {
                return this.b.size();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean isEmpty() {
                return this.b.isEmpty();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean contains(Object obj) {
                return this.b.contains(obj);
            }

            @Override // java.util.Set, java.util.Collection, java.lang.Iterable
            public Iterator<E> iterator() {
                return new b(this.f6749a, this.b.iterator());
            }

            @Override // java.util.Set, java.util.Collection
            public Object[] toArray() {
                return this.b.toArray();
            }

            @Override // java.util.Set, java.util.Collection
            public <T> T[] toArray(T[] tArr) {
                return (T[]) this.b.toArray(tArr);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean add(E e) {
                this.f6749a.i();
                return this.b.add(e);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean remove(Object obj) {
                this.f6749a.i();
                return this.b.remove(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean containsAll(Collection<?> collection) {
                return this.b.containsAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean addAll(Collection<? extends E> collection) {
                this.f6749a.i();
                return this.b.addAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean retainAll(Collection<?> collection) {
                this.f6749a.i();
                return this.b.retainAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public boolean removeAll(Collection<?> collection) {
                this.f6749a.i();
                return this.b.removeAll(collection);
            }

            @Override // java.util.Set, java.util.Collection
            public void clear() {
                this.f6749a.i();
                this.b.clear();
            }

            @Override // java.util.Set, java.util.Collection
            public boolean equals(Object obj) {
                return this.b.equals(obj);
            }

            @Override // java.util.Set, java.util.Collection
            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return this.b.toString();
            }
        }

        /* loaded from: classes3.dex */
        static class b<E> implements Iterator<E> {

            /* renamed from: a, reason: collision with root package name */
            private final ad f6748a;
            private final Iterator<E> b;

            b(ad adVar, Iterator<E> it) {
                this.f6748a = adVar;
                this.b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b.hasNext();
            }

            @Override // java.util.Iterator
            public E next() {
                return this.b.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f6748a.i();
                this.b.remove();
            }

            public boolean equals(Object obj) {
                return this.b.equals(obj);
            }

            public int hashCode() {
                return this.b.hashCode();
            }

            public String toString() {
                return this.b.toString();
            }
        }
    }
}
