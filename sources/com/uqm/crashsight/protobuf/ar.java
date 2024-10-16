package com.uqm.crashsight.protobuf;

import com.uqm.crashsight.protobuf.FieldSet;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ar<K extends Comparable<K>, V> extends AbstractMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final int f6795a;
    private List<ar<K, V>.d> b;
    private Map<K, V> c;
    private boolean d;
    private volatile ar<K, V>.f e;
    private Map<K, V> f;
    private volatile ar<K, V>.b g;

    /* synthetic */ ar(int i, byte b2) {
        this(i);
    }

    static /* synthetic */ void a(ar arVar) {
        if (arVar.d) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return a((ar<K, V>) obj, (Comparable) obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <FieldDescriptorType extends FieldSet.FieldDescriptorLite<FieldDescriptorType>> ar<FieldDescriptorType, Object> a(int i) {
        return (ar<FieldDescriptorType, Object>) new ar<FieldDescriptorType, Object>(i) { // from class: com.uqm.crashsight.protobuf.ar.1
            {
                byte b2 = 0;
            }

            @Override // com.uqm.crashsight.protobuf.ar, java.util.AbstractMap, java.util.Map
            public final /* synthetic */ Object put(Object obj, Object obj2) {
                return super.a((AnonymousClass1<FieldDescriptorType>) obj, (FieldSet.FieldDescriptorLite) obj2);
            }

            @Override // com.uqm.crashsight.protobuf.ar
            public final void a() {
                if (!b()) {
                    for (int i2 = 0; i2 < c(); i2++) {
                        Map.Entry<FieldDescriptorType, Object> b2 = b(i2);
                        if (((FieldSet.FieldDescriptorLite) b2.getKey()).o()) {
                            b2.setValue(Collections.unmodifiableList((List) b2.getValue()));
                        }
                    }
                    for (Map.Entry<FieldDescriptorType, Object> entry : d()) {
                        if (((FieldSet.FieldDescriptorLite) entry.getKey()).o()) {
                            entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                        }
                    }
                }
                super.a();
            }
        };
    }

    private ar(int i) {
        this.f6795a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    public void a() {
        if (this.d) {
            return;
        }
        this.c = this.c.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.c);
        this.f = this.f.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f);
        this.d = true;
    }

    public final boolean b() {
        return this.d;
    }

    public final int c() {
        return this.b.size();
    }

    public final Map.Entry<K, V> b(int i) {
        return this.b.get(i);
    }

    public final Iterable<Map.Entry<K, V>> d() {
        return this.c.isEmpty() ? c.a() : this.c.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.b.size() + this.c.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a((ar<K, V>) comparable) >= 0 || this.c.containsKey(comparable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a((ar<K, V>) comparable);
        if (a2 >= 0) {
            return this.b.get(a2).getValue();
        }
        return this.c.get(comparable);
    }

    public final V a(K k, V v) {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
        int a2 = a((ar<K, V>) k);
        if (a2 >= 0) {
            return this.b.get(a2).setValue(v);
        }
        if (this.d) {
            throw new UnsupportedOperationException();
        }
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.f6795a);
        }
        int i = -(a2 + 1);
        if (i >= this.f6795a) {
            return f().put(k, v);
        }
        int size = this.b.size();
        int i2 = this.f6795a;
        if (size == i2) {
            ar<K, V>.d remove = this.b.remove(i2 - 1);
            f().put(remove.a(), remove.getValue());
        }
        this.b.add(i, new d(k, v));
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (this.c.isEmpty()) {
            return;
        }
        this.c.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
        Comparable comparable = (Comparable) obj;
        int a2 = a((ar<K, V>) comparable);
        if (a2 >= 0) {
            return (V) c(a2);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V c(int i) {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
        V value = this.b.remove(i).getValue();
        if (!this.c.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = f().entrySet().iterator();
            this.b.add(new d(this, it.next()));
            it.remove();
        }
        return value;
    }

    private int a(K k) {
        int size = this.b.size() - 1;
        if (size >= 0) {
            int compareTo = k.compareTo(this.b.get(size).a());
            if (compareTo > 0) {
                return -(size + 2);
            }
            if (compareTo == 0) {
                return size;
            }
        }
        int i = 0;
        while (i <= size) {
            int i2 = (i + size) / 2;
            int compareTo2 = k.compareTo(this.b.get(i2).a());
            if (compareTo2 < 0) {
                size = i2 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i2;
                }
                i = i2 + 1;
            }
        }
        return -(i + 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new f(this, (byte) 0);
        }
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> e() {
        if (this.g == null) {
            this.g = new b(this, (byte) 0);
        }
        return this.g;
    }

    private SortedMap<K, V> f() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            this.c = new TreeMap();
            this.f = ((TreeMap) this.c).descendingMap();
        }
        return (SortedMap) this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements Comparable<ar<K, V>.d>, Map.Entry<K, V> {

        /* renamed from: a, reason: collision with root package name */
        private final K f6799a;
        private V b;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.f6799a.compareTo(((d) obj).f6799a);
        }

        @Override // java.util.Map.Entry
        public /* bridge */ /* synthetic */ Object getKey() {
            return this.f6799a;
        }

        d(ar arVar, Map.Entry<K, V> entry) {
            this(entry.getKey(), entry.getValue());
        }

        d(K k, V v) {
            this.f6799a = k;
            this.b = v;
        }

        public final K a() {
            return this.f6799a;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            return this.b;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            ar.a(ar.this);
            V v2 = this.b;
            this.b = v;
            return v2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.f6799a;
            Object key = entry.getKey();
            if (k == null ? key == null : k.equals(key)) {
                V v = this.b;
                Object value = entry.getValue();
                if (v == null ? value == null : v.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K k = this.f6799a;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.b;
            return hashCode ^ (v != null ? v.hashCode() : 0);
        }

        public String toString() {
            return this.f6799a + "=" + this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class f extends AbstractSet<Map.Entry<K, V>> {
        private f() {
        }

        /* synthetic */ f(ar arVar, byte b) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public /* synthetic */ boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            ar.this.a((ar) entry.getKey(), (Comparable) entry.getValue());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new e(ar.this, (byte) 0);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return ar.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = ar.this.get(entry.getKey());
            Object value = entry.getValue();
            if (obj2 != value) {
                return obj2 != null && obj2.equals(value);
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            ar.this.remove(entry.getKey());
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            ar.this.clear();
        }
    }

    /* loaded from: classes3.dex */
    class b extends ar<K, V>.f {
        private b() {
            super(ar.this, (byte) 0);
        }

        /* synthetic */ b(ar arVar, byte b) {
            this();
        }

        @Override // com.uqm.crashsight.protobuf.ar.f, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new a(ar.this, (byte) 0);
        }
    }

    /* loaded from: classes3.dex */
    class e implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private int f6800a;
        private boolean b;
        private Iterator<Map.Entry<K, V>> c;

        private e() {
            this.f6800a = -1;
        }

        /* synthetic */ e(ar arVar, byte b) {
            this();
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            this.b = true;
            int i = this.f6800a + 1;
            this.f6800a = i;
            return i < ar.this.b.size() ? (Map.Entry<K, V>) ar.this.b.get(this.f6800a) : a().next();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6800a + 1 < ar.this.b.size() || (!ar.this.c.isEmpty() && a().hasNext());
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.b) {
                throw new IllegalStateException("remove() was called before next()");
            }
            this.b = false;
            ar.a(ar.this);
            if (this.f6800a < ar.this.b.size()) {
                ar arVar = ar.this;
                int i = this.f6800a;
                this.f6800a = i - 1;
                arVar.c(i);
                return;
            }
            a().remove();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.c == null) {
                this.c = ar.this.c.entrySet().iterator();
            }
            return this.c;
        }
    }

    /* loaded from: classes3.dex */
    class a implements Iterator<Map.Entry<K, V>> {

        /* renamed from: a, reason: collision with root package name */
        private int f6796a;
        private Iterator<Map.Entry<K, V>> b;

        private a() {
            this.f6796a = ar.this.b.size();
        }

        /* synthetic */ a(ar arVar, byte b) {
            this();
        }

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            Map.Entry<K, V> entry;
            if (a().hasNext()) {
                entry = a().next();
            } else {
                List list = ar.this.b;
                int i = this.f6796a - 1;
                this.f6796a = i;
                entry = (Map.Entry<K, V>) list.get(i);
            }
            return entry;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            int i = this.f6796a;
            return (i > 0 && i <= ar.this.b.size()) || a().hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private Iterator<Map.Entry<K, V>> a() {
            if (this.b == null) {
                this.b = ar.this.f.entrySet().iterator();
            }
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private static final Iterator<Object> f6798a = new Iterator<Object>() { // from class: com.uqm.crashsight.protobuf.ar.c.1
            @Override // java.util.Iterator
            public final boolean hasNext() {
                return false;
            }

            @Override // java.util.Iterator
            public final Object next() {
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public final void remove() {
                throw new UnsupportedOperationException();
            }
        };
        private static final Iterable<Object> b = new Iterable<Object>() { // from class: com.uqm.crashsight.protobuf.ar.c.2
            @Override // java.lang.Iterable
            public final Iterator<Object> iterator() {
                return c.f6798a;
            }
        };

        static <T> Iterable<T> a() {
            return (Iterable<T>) b;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ar)) {
            return super.equals(obj);
        }
        ar arVar = (ar) obj;
        int size = size();
        if (size != arVar.size()) {
            return false;
        }
        int size2 = this.b.size();
        if (size2 != arVar.b.size()) {
            return entrySet().equals(arVar.entrySet());
        }
        for (int i = 0; i < size2; i++) {
            if (!this.b.get(i).equals(arVar.b.get(i))) {
                return false;
            }
        }
        if (size2 != size) {
            return this.c.equals(arVar.c);
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int size = this.b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.b.get(i2).hashCode();
        }
        return this.c.size() > 0 ? i + this.c.hashCode() : i;
    }
}
