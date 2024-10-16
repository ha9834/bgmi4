package a;

import a.a;
import a.c;
import a.e;
import a.n;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import okhttp3.aa;
import okhttp3.ac;
import okhttp3.e;
import okhttp3.t;
import okhttp3.x;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Method, n> f48a = new LinkedHashMap();
    private final e.a b;
    private final t c;
    private final List<e.a> d;
    private final List<c.a> e;
    private final Executor f;
    private final boolean g;

    m(e.a aVar, t tVar, List<e.a> list, List<c.a> list2, Executor executor, boolean z) {
        this.b = aVar;
        this.c = tVar;
        this.d = Collections.unmodifiableList(list);
        this.e = Collections.unmodifiableList(list2);
        this.f = executor;
        this.g = z;
    }

    public <T> T a(final Class<T> cls) {
        o.a((Class) cls);
        if (this.g) {
            b(cls);
        }
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() { // from class: a.m.1
            private final j c = j.a();

            @Override // java.lang.reflect.InvocationHandler
            public Object invoke(Object obj, Method method, Object... objArr) throws Throwable {
                if (method.getDeclaringClass() == Object.class) {
                    return method.invoke(this, objArr);
                }
                if (this.c.a(method)) {
                    return this.c.a(method, cls, obj, objArr);
                }
                n a2 = m.this.a(method);
                return a2.d.a(new h(a2, objArr));
            }
        });
    }

    private void b(Class<?> cls) {
        j a2 = j.a();
        for (Method method : cls.getDeclaredMethods()) {
            if (!a2.a(method)) {
                a(method);
            }
        }
    }

    n a(Method method) {
        n nVar;
        synchronized (this.f48a) {
            nVar = this.f48a.get(method);
            if (nVar == null) {
                nVar = new n.a(this, method).a();
                this.f48a.put(method, nVar);
            }
        }
        return nVar;
    }

    public e.a a() {
        return this.b;
    }

    public t b() {
        return this.c;
    }

    public c<?> a(Type type, Annotation[] annotationArr) {
        return a((c.a) null, type, annotationArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public c<?> a(c.a aVar, Type type, Annotation[] annotationArr) {
        o.a(type, "returnType == null");
        o.a(annotationArr, "annotations == null");
        int indexOf = this.e.indexOf(aVar) + 1;
        int size = this.e.size();
        for (int i = indexOf; i < size; i++) {
            c<?> a2 = this.e.get(i).a(type, annotationArr, this);
            if (a2 != null) {
                return a2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.e.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.e.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.e.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return a(null, type, annotationArr, annotationArr2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> e<T, aa> a(e.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        o.a(type, "type == null");
        o.a(annotationArr, "parameterAnnotations == null");
        o.a(annotationArr2, "methodAnnotations == null");
        int indexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = indexOf; i < size; i++) {
            e<T, aa> eVar = (e<T, aa>) this.d.get(i).a(type, annotationArr, annotationArr2, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<ac, T> b(Type type, Annotation[] annotationArr) {
        return a((e.a) null, type, annotationArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> e<ac, T> a(e.a aVar, Type type, Annotation[] annotationArr) {
        o.a(type, "type == null");
        o.a(annotationArr, "annotations == null");
        int indexOf = this.d.indexOf(aVar) + 1;
        int size = this.d.size();
        for (int i = indexOf; i < size; i++) {
            e<ac, T> eVar = (e<ac, T>) this.d.get(i).a(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        if (aVar != null) {
            sb.append("  Skipped:");
            for (int i2 = 0; i2 < indexOf; i2++) {
                sb.append("\n   * ");
                sb.append(this.d.get(i2).getClass().getName());
            }
            sb.append('\n');
        }
        sb.append("  Tried:");
        int size2 = this.d.size();
        while (indexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.d.get(indexOf).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    public <T> e<T, String> c(Type type, Annotation[] annotationArr) {
        o.a(type, "type == null");
        o.a(annotationArr, "annotations == null");
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            e<T, String> eVar = (e<T, String>) this.d.get(i).b(type, annotationArr, this);
            if (eVar != null) {
                return eVar;
            }
        }
        return a.e.f14a;
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private j f50a;
        private e.a b;
        private t c;
        private List<e.a> d;
        private List<c.a> e;
        private Executor f;
        private boolean g;

        a(j jVar) {
            this.d = new ArrayList();
            this.e = new ArrayList();
            this.f50a = jVar;
            this.d.add(new a.a());
        }

        public a() {
            this(j.a());
        }

        public a a(x xVar) {
            return a((e.a) o.a(xVar, "client == null"));
        }

        public a a(e.a aVar) {
            this.b = (e.a) o.a(aVar, "factory == null");
            return this;
        }

        public a a(String str) {
            o.a(str, "baseUrl == null");
            t e = t.e(str);
            if (e == null) {
                throw new IllegalArgumentException("Illegal URL: " + str);
            }
            return a(e);
        }

        public a a(t tVar) {
            o.a(tVar, "baseUrl == null");
            if (!"".equals(tVar.j().get(r0.size() - 1))) {
                throw new IllegalArgumentException("baseUrl must end in /: " + tVar);
            }
            this.c = tVar;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a a(e.a aVar) {
            this.d.add(o.a(aVar, "factory == null"));
            return this;
        }

        public m a() {
            if (this.c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            e.a aVar = this.b;
            e.a xVar = aVar == null ? new x() : aVar;
            Executor executor = this.f;
            Executor b = executor == null ? this.f50a.b() : executor;
            ArrayList arrayList = new ArrayList(this.e);
            arrayList.add(this.f50a.a(b));
            return new m(xVar, this.c, new ArrayList(this.d), arrayList, b, this.g);
        }
    }
}
