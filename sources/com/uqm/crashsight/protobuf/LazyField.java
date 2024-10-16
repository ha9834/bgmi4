package com.uqm.crashsight.protobuf;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class LazyField extends LazyFieldLite {

    /* renamed from: a, reason: collision with root package name */
    private final MessageLite f6734a;

    public LazyField(MessageLite messageLite, ExtensionRegistryLite extensionRegistryLite, ByteString byteString) {
        super(extensionRegistryLite, byteString);
        this.f6734a = messageLite;
    }

    public final MessageLite a() {
        return a(this.f6734a);
    }

    @Override // com.uqm.crashsight.protobuf.LazyFieldLite
    public int hashCode() {
        return a(this.f6734a).hashCode();
    }

    @Override // com.uqm.crashsight.protobuf.LazyFieldLite
    public boolean equals(Object obj) {
        return a(this.f6734a).equals(obj);
    }

    public String toString() {
        return a(this.f6734a).toString();
    }

    /* loaded from: classes3.dex */
    static class a<K> implements Map.Entry<K, Object> {

        /* renamed from: a, reason: collision with root package name */
        private Map.Entry<K, LazyField> f6735a;

        /* synthetic */ a(Map.Entry entry, byte b) {
            this(entry);
        }

        private a(Map.Entry<K, LazyField> entry) {
            this.f6735a = entry;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return this.f6735a.getKey();
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            LazyField value = this.f6735a.getValue();
            if (value == null) {
                return null;
            }
            return value.a();
        }

        public final LazyField a() {
            return this.f6735a.getValue();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (!(obj instanceof MessageLite)) {
                throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
            }
            return this.f6735a.getValue().b((MessageLite) obj);
        }
    }

    /* loaded from: classes3.dex */
    static class b<K> implements Iterator<Map.Entry<K, Object>> {

        /* renamed from: a, reason: collision with root package name */
        private Iterator<Map.Entry<K, Object>> f6736a;

        @Override // java.util.Iterator
        public /* synthetic */ Object next() {
            Map.Entry<K, Object> next = this.f6736a.next();
            return next.getValue() instanceof LazyField ? new a(next, (byte) 0) : next;
        }

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.f6736a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f6736a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f6736a.remove();
        }
    }
}
