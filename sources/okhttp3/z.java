package okhttp3;

import com.amazonaws.services.s3.Headers;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import okhttp3.s;

/* loaded from: classes.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    final t f7168a;
    final String b;
    final s c;

    @Nullable
    final aa d;
    final Map<Class<?>, Object> e;

    @Nullable
    private volatile d f;

    z(a aVar) {
        this.f7168a = aVar.f7169a;
        this.b = aVar.b;
        this.c = aVar.c.a();
        this.d = aVar.d;
        this.e = okhttp3.internal.c.a(aVar.e);
    }

    public t a() {
        return this.f7168a;
    }

    public String b() {
        return this.b;
    }

    public s c() {
        return this.c;
    }

    @Nullable
    public String a(String str) {
        return this.c.a(str);
    }

    @Nullable
    public aa d() {
        return this.d;
    }

    @Nullable
    public <T> T a(Class<? extends T> cls) {
        return cls.cast(this.e.get(cls));
    }

    public a e() {
        return new a(this);
    }

    public d f() {
        d dVar = this.f;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.c);
        this.f = a2;
        return a2;
    }

    public boolean g() {
        return this.f7168a.c();
    }

    public String toString() {
        return "Request{method=" + this.b + ", url=" + this.f7168a + ", tags=" + this.e + '}';
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        @Nullable
        t f7169a;
        String b;
        s.a c;

        @Nullable
        aa d;
        Map<Class<?>, Object> e;

        public a() {
            this.e = Collections.emptyMap();
            this.b = "GET";
            this.c = new s.a();
        }

        a(z zVar) {
            Map<Class<?>, Object> linkedHashMap;
            this.e = Collections.emptyMap();
            this.f7169a = zVar.f7168a;
            this.b = zVar.b;
            this.d = zVar.d;
            if (zVar.e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(zVar.e);
            }
            this.e = linkedHashMap;
            this.c = zVar.c.b();
        }

        public a a(t tVar) {
            if (tVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f7169a = tVar;
            return this;
        }

        public a a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return a(t.f(str));
        }

        public a a(String str, String str2) {
            this.c.d(str, str2);
            return this;
        }

        public a b(String str, String str2) {
            this.c.a(str, str2);
            return this;
        }

        public a b(String str) {
            this.c.b(str);
            return this;
        }

        public a a(s sVar) {
            this.c = sVar.b();
            return this;
        }

        public a a(d dVar) {
            String dVar2 = dVar.toString();
            return dVar2.isEmpty() ? b(Headers.CACHE_CONTROL) : a(Headers.CACHE_CONTROL, dVar2);
        }

        public a a() {
            return a("GET", (aa) null);
        }

        public a a(aa aaVar) {
            return a("POST", aaVar);
        }

        public a a(String str, @Nullable aa aaVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (aaVar != null && !okhttp3.internal.b.f.c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (aaVar == null && okhttp3.internal.b.f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.b = str;
            this.d = aaVar;
            return this;
        }

        public <T> a a(Class<? super T> cls, @Nullable T t) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t == null) {
                this.e.remove(cls);
            } else {
                if (this.e.isEmpty()) {
                    this.e = new LinkedHashMap();
                }
                this.e.put(cls, cls.cast(t));
            }
            return this;
        }

        public z b() {
            if (this.f7169a == null) {
                throw new IllegalStateException("url == null");
            }
            return new z(this);
        }
    }
}
