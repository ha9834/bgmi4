package androidx.b;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class g<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f;
    Object[] g;
    int h;

    private static int a(int[] iArr, int i, int i2) {
        try {
            return c.a(iArr, i, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    int a(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a2 = a(this.f, i2, i);
        if (a2 < 0 || obj.equals(this.g[a2 << 1])) {
            return a2;
        }
        int i3 = a2 + 1;
        while (i3 < i2 && this.f[i3] == i) {
            if (obj.equals(this.g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = a2 - 1; i4 >= 0 && this.f[i4] == i; i4--) {
            if (obj.equals(this.g[i4 << 1])) {
                return i4;
            }
        }
        return i3 ^ (-1);
    }

    int a() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int a2 = a(this.f, i, 0);
        if (a2 < 0 || this.g[a2 << 1] == null) {
            return a2;
        }
        int i2 = a2 + 1;
        while (i2 < i && this.f[i2] == 0) {
            if (this.g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = a2 - 1; i3 >= 0 && this.f[i3] == 0; i3--) {
            if (this.g[i3 << 1] == null) {
                return i3;
            }
        }
        return i2 ^ (-1);
    }

    private void e(int i) {
        if (i == 8) {
            synchronized (g.class) {
                if (d != null) {
                    Object[] objArr = d;
                    this.g = objArr;
                    d = (Object[]) objArr[0];
                    this.f = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (g.class) {
                if (b != null) {
                    Object[] objArr2 = b;
                    this.g = objArr2;
                    b = (Object[]) objArr2[0];
                    this.f = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[i << 1];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (g.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                        objArr[i2] = null;
                    }
                    d = objArr;
                    e++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (g.class) {
                if (c < 10) {
                    objArr[0] = b;
                    objArr[1] = iArr;
                    for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                        objArr[i3] = null;
                    }
                    b = objArr;
                    c++;
                }
            }
        }
    }

    public g() {
        this.f = c.f378a;
        this.g = c.c;
        this.h = 0;
    }

    public g(int i) {
        if (i == 0) {
            this.f = c.f378a;
            this.g = c.c;
        } else {
            e(i);
        }
        this.h = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(g<K, V> gVar) {
        this();
        if (gVar != 0) {
            a((g) gVar);
        }
    }

    public void clear() {
        int i = this.h;
        if (i > 0) {
            int[] iArr = this.f;
            Object[] objArr = this.g;
            this.f = c.f378a;
            this.g = c.c;
            this.h = 0;
            a(iArr, objArr, i);
        }
        if (this.h > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public void a(int i) {
        int i2 = this.h;
        int[] iArr = this.f;
        if (iArr.length < i) {
            Object[] objArr = this.g;
            e(i);
            if (this.h > 0) {
                System.arraycopy(iArr, 0, this.f, 0, i2);
                System.arraycopy(objArr, 0, this.g, 0, i2 << 1);
            }
            a(iArr, objArr, i2);
        }
        if (this.h != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= 0;
    }

    public int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= 0;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v) {
        int a2 = a(obj);
        return a2 >= 0 ? (V) this.g[(a2 << 1) + 1] : v;
    }

    public K b(int i) {
        return (K) this.g[i << 1];
    }

    public V c(int i) {
        return (V) this.g[(i << 1) + 1];
    }

    public V a(int i, V v) {
        int i2 = (i << 1) + 1;
        Object[] objArr = this.g;
        V v2 = (V) objArr[i2];
        objArr[i2] = v;
        return v2;
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int i;
        int a2;
        int i2 = this.h;
        if (k == null) {
            a2 = a();
            i = 0;
        } else {
            int hashCode = k.hashCode();
            i = hashCode;
            a2 = a(k, hashCode);
        }
        if (a2 >= 0) {
            int i3 = (a2 << 1) + 1;
            Object[] objArr = this.g;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        int i4 = a2 ^ (-1);
        if (i2 >= this.f.length) {
            int i5 = 4;
            if (i2 >= 8) {
                i5 = (i2 >> 1) + i2;
            } else if (i2 >= 4) {
                i5 = 8;
            }
            int[] iArr = this.f;
            Object[] objArr2 = this.g;
            e(i5);
            if (i2 != this.h) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.g, 0, objArr2.length);
            }
            a(iArr, objArr2, i2);
        }
        if (i4 < i2) {
            int[] iArr3 = this.f;
            int i6 = i4 + 1;
            System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
            Object[] objArr3 = this.g;
            System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.h - i4) << 1);
        }
        int i7 = this.h;
        if (i2 == i7) {
            int[] iArr4 = this.f;
            if (i4 < iArr4.length) {
                iArr4[i4] = i;
                Object[] objArr4 = this.g;
                int i8 = i4 << 1;
                objArr4[i8] = k;
                objArr4[i8 + 1] = v;
                this.h = i7 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public void a(g<? extends K, ? extends V> gVar) {
        int i = gVar.h;
        a(this.h + i);
        if (this.h != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(gVar.b(i2), gVar.c(i2));
            }
        } else if (i > 0) {
            System.arraycopy(gVar.f, 0, this.f, 0, i);
            System.arraycopy(gVar.g, 0, this.g, 0, i << 1);
            this.h = i;
        }
    }

    public V putIfAbsent(K k, V v) {
        V v2 = get(k);
        return v2 == null ? put(k, v) : v2;
    }

    public V remove(Object obj) {
        int a2 = a(obj);
        if (a2 >= 0) {
            return d(a2);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int a2 = a(obj);
        if (a2 < 0) {
            return false;
        }
        V c2 = c(a2);
        if (obj2 != c2 && (obj2 == null || !obj2.equals(c2))) {
            return false;
        }
        d(a2);
        return true;
    }

    public V d(int i) {
        int i2;
        Object[] objArr = this.g;
        int i3 = i << 1;
        V v = (V) objArr[i3 + 1];
        int i4 = this.h;
        if (i4 <= 1) {
            a(this.f, objArr, i4);
            this.f = c.f378a;
            this.g = c.c;
            i2 = 0;
        } else {
            i2 = i4 - 1;
            int[] iArr = this.f;
            if (iArr.length > 8 && i4 < iArr.length / 3) {
                int i5 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                int[] iArr2 = this.f;
                Object[] objArr2 = this.g;
                e(i5);
                if (i4 != this.h) {
                    throw new ConcurrentModificationException();
                }
                if (i > 0) {
                    System.arraycopy(iArr2, 0, this.f, 0, i);
                    System.arraycopy(objArr2, 0, this.g, 0, i3);
                }
                if (i < i2) {
                    int i6 = i + 1;
                    int i7 = i2 - i;
                    System.arraycopy(iArr2, i6, this.f, i, i7);
                    System.arraycopy(objArr2, i6 << 1, this.g, i3, i7 << 1);
                }
            } else {
                if (i < i2) {
                    int[] iArr3 = this.f;
                    int i8 = i + 1;
                    int i9 = i2 - i;
                    System.arraycopy(iArr3, i8, iArr3, i, i9);
                    Object[] objArr3 = this.g;
                    System.arraycopy(objArr3, i8 << 1, objArr3, i3, i9 << 1);
                }
                Object[] objArr4 = this.g;
                int i10 = i2 << 1;
                objArr4[i10] = null;
                objArr4[i10 + 1] = null;
            }
        }
        if (i4 != this.h) {
            throw new ConcurrentModificationException();
        }
        this.h = i2;
        return v;
    }

    public V replace(K k, V v) {
        int a2 = a(k);
        if (a2 >= 0) {
            return a(a2, (int) v);
        }
        return null;
    }

    public boolean replace(K k, V v, V v2) {
        int a2 = a(k);
        if (a2 < 0) {
            return false;
        }
        V c2 = c(a2);
        if (c2 != v && (v == null || !v.equals(c2))) {
            return false;
        }
        a(a2, (int) v2);
        return true;
    }

    public int size() {
        return this.h;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (size() != gVar.size()) {
                return false;
            }
            for (int i = 0; i < this.h; i++) {
                try {
                    K b2 = b(i);
                    V c2 = c(i);
                    Object obj2 = gVar.get(b2);
                    if (c2 == null) {
                        if (obj2 != null || !gVar.containsKey(b2)) {
                            return false;
                        }
                    } else if (!c2.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException unused) {
                    return false;
                } catch (NullPointerException unused2) {
                    return false;
                }
            }
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (size() != map.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.h; i2++) {
            try {
                K b3 = b(i2);
                V c3 = c(i2);
                Object obj3 = map.get(b3);
                if (c3 == null) {
                    if (obj3 != null || !map.containsKey(b3)) {
                        return false;
                    }
                } else if (!c3.equals(obj3)) {
                    return false;
                }
            } catch (ClassCastException unused3) {
                return false;
            } catch (NullPointerException unused4) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < i) {
            Object obj = objArr[i4];
            i3 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i2];
            i2++;
            i4 += 2;
        }
        return i3;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.h * 28);
        sb.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            K b2 = b(i);
            if (b2 != this) {
                sb.append(b2);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V c2 = c(i);
            if (c2 != this) {
                sb.append(c2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
