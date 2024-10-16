package a;

import com.amazonaws.services.s3.Headers;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.Map;
import okhttp3.aa;
import okhttp3.s;
import okhttp3.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class i<T> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(a.k kVar, T t) throws IOException;

    i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final i<Iterable<T>> a() {
        return new i<Iterable<T>>() { // from class: a.i.1
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // a.i
            public void a(a.k kVar, Iterable<T> iterable) throws IOException {
                if (iterable == null) {
                    return;
                }
                Iterator<T> it = iterable.iterator();
                while (it.hasNext()) {
                    i.this.a(kVar, it.next());
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final i<Object> b() {
        return new i<Object>() { // from class: a.i.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // a.i
            void a(a.k kVar, Object obj) throws IOException {
                if (obj == null) {
                    return;
                }
                int length = Array.getLength(obj);
                for (int i = 0; i < length; i++) {
                    i.this.a(kVar, Array.get(obj, i));
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class l extends i<Object> {
        @Override // a.i
        void a(a.k kVar, Object obj) {
            kVar.a(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d<T> extends i<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f34a;
        private final a.e<T, String> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(String str, a.e<T, String> eVar) {
            this.f34a = (String) o.a(str, "name == null");
            this.b = eVar;
        }

        @Override // a.i
        void a(a.k kVar, T t) throws IOException {
            if (t == null) {
                return;
            }
            kVar.a(this.f34a, this.b.a(t));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class h<T> extends i<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f38a;
        private final a.e<T, String> b;
        private final boolean c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(String str, a.e<T, String> eVar, boolean z) {
            this.f38a = (String) o.a(str, "name == null");
            this.b = eVar;
            this.c = z;
        }

        @Override // a.i
        void a(a.k kVar, T t) throws IOException {
            if (t == null) {
                throw new IllegalArgumentException("Path parameter \"" + this.f38a + "\" value must not be null.");
            }
            kVar.a(this.f38a, this.b.a(t), this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a.i$i, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0002i<T> extends i<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f39a;
        private final a.e<T, String> b;
        private final boolean c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0002i(String str, a.e<T, String> eVar, boolean z) {
            this.f39a = (String) o.a(str, "name == null");
            this.b = eVar;
            this.c = z;
        }

        @Override // a.i
        void a(a.k kVar, T t) throws IOException {
            if (t == null) {
                return;
            }
            kVar.b(this.f39a, this.b.a(t), this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class j<T> extends i<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final a.e<T, String> f40a;
        private final boolean b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public j(a.e<T, String> eVar, boolean z) {
            this.f40a = eVar;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // a.i
        public void a(a.k kVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Query map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Query map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Query map contained null value for key '" + key + "'.");
                }
                kVar.b(key, this.f40a.a(value), this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e<T> extends i<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final a.e<T, String> f35a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(a.e<T, String> eVar) {
            this.f35a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // a.i
        public void a(a.k kVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Header map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Header map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Header map contained null value for key '" + key + "'.");
                }
                kVar.a(key, this.f35a.a(value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b<T> extends i<T> {

        /* renamed from: a, reason: collision with root package name */
        private final String f32a;
        private final a.e<T, String> b;
        private final boolean c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str, a.e<T, String> eVar, boolean z) {
            this.f32a = (String) o.a(str, "name == null");
            this.b = eVar;
            this.c = z;
        }

        @Override // a.i
        void a(a.k kVar, T t) throws IOException {
            if (t == null) {
                return;
            }
            kVar.c(this.f32a, this.b.a(t), this.c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c<T> extends i<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final a.e<T, String> f33a;
        private final boolean b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(a.e<T, String> eVar, boolean z) {
            this.f33a = eVar;
            this.b = z;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // a.i
        public void a(a.k kVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Field map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Field map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Field map contained null value for key '" + key + "'.");
                }
                kVar.c(key, this.f33a.a(value), this.b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f<T> extends i<T> {

        /* renamed from: a, reason: collision with root package name */
        private final s f36a;
        private final a.e<T, aa> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public f(s sVar, a.e<T, aa> eVar) {
            this.f36a = sVar;
            this.b = eVar;
        }

        @Override // a.i
        void a(a.k kVar, T t) {
            if (t == null) {
                return;
            }
            try {
                kVar.a(this.f36a, this.b.a(t));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class k extends i<w.b> {

        /* renamed from: a, reason: collision with root package name */
        static final k f41a = new k();

        private k() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // a.i
        public void a(a.k kVar, w.b bVar) throws IOException {
            if (bVar != null) {
                kVar.a(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class g<T> extends i<Map<String, T>> {

        /* renamed from: a, reason: collision with root package name */
        private final a.e<T, aa> f37a;
        private final String b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(a.e<T, aa> eVar, String str) {
            this.f37a = eVar;
            this.b = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // a.i
        public void a(a.k kVar, Map<String, T> map) throws IOException {
            if (map == null) {
                throw new IllegalArgumentException("Part map was null.");
            }
            for (Map.Entry<String, T> entry : map.entrySet()) {
                String key = entry.getKey();
                if (key == null) {
                    throw new IllegalArgumentException("Part map contained null key.");
                }
                T value = entry.getValue();
                if (value == null) {
                    throw new IllegalArgumentException("Part map contained null value for key '" + key + "'.");
                }
                kVar.a(s.a(Headers.CONTENT_DISPOSITION, "form-data; name=\"" + key + "\"", "Content-Transfer-Encoding", this.b), this.f37a.a(value));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a<T> extends i<T> {

        /* renamed from: a, reason: collision with root package name */
        private final a.e<T, aa> f31a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(a.e<T, aa> eVar) {
            this.f31a = eVar;
        }

        @Override // a.i
        void a(a.k kVar, T t) {
            if (t == null) {
                throw new IllegalArgumentException("Body parameter value must not be null.");
            }
            try {
                kVar.a(this.f31a.a(t));
            } catch (IOException e) {
                throw new RuntimeException("Unable to convert " + t + " to RequestBody", e);
            }
        }
    }
}
