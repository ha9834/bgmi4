package kotlin.collections;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class EmptyMap implements Serializable, Map {

    /* renamed from: a, reason: collision with root package name */
    public static final EmptyMap f6940a = new EmptyMap();
    private static final long serialVersionUID = 8246714829545688274L;

    public int a() {
        return 0;
    }

    public Void a(Object obj) {
        return null;
    }

    public boolean a(Void r2) {
        kotlin.jvm.internal.h.b(r2, "value");
        return false;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return false;
    }

    @Override // java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public String toString() {
        return "{}";
    }

    private EmptyMap() {
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        if (obj instanceof Void) {
            return a((Void) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final Set<Map.Entry> entrySet() {
        return b();
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return a(obj);
    }

    @Override // java.util.Map
    public final Set<Object> keySet() {
        return c();
    }

    @Override // java.util.Map
    public final int size() {
        return a();
    }

    @Override // java.util.Map
    public final Collection values() {
        return d();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && ((Map) obj).isEmpty();
    }

    public Set<Map.Entry> b() {
        return EmptySet.f6941a;
    }

    public Set<Object> c() {
        return EmptySet.f6941a;
    }

    public Collection d() {
        return EmptyList.f6939a;
    }

    private final Object readResolve() {
        return f6940a;
    }
}
