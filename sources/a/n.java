package a;

import a.b.p;
import a.b.q;
import a.b.r;
import a.b.u;
import a.b.w;
import a.i;
import com.amazonaws.services.s3.Headers;
import com.tencent.imsdk.android.tools.net.volley.upload.HttpClientStack;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.aa;
import okhttp3.ab;
import okhttp3.ac;
import okhttp3.e;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n<T> {

    /* renamed from: a, reason: collision with root package name */
    static final Pattern f51a = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");
    static final Pattern b = Pattern.compile("[a-zA-Z][a-zA-Z0-9_-]*");
    final e.a c;
    final c<?> d;
    private final t e;
    private final e<ac, T> f;
    private final String g;
    private final String h;
    private final s i;
    private final v j;
    private final boolean k;
    private final boolean l;
    private final boolean m;
    private final i<?>[] n;

    n(a<T> aVar) {
        this.c = aVar.f52a.a();
        this.d = aVar.w;
        this.e = aVar.f52a.b();
        this.f = aVar.v;
        this.g = aVar.m;
        this.h = aVar.q;
        this.i = aVar.r;
        this.j = aVar.s;
        this.k = aVar.n;
        this.l = aVar.o;
        this.m = aVar.p;
        this.n = aVar.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public z a(Object... objArr) throws IOException {
        k kVar = new k(this.g, this.e, this.h, this.i, this.j, this.k, this.l, this.m);
        i<?>[] iVarArr = this.n;
        int length = objArr != null ? objArr.length : 0;
        if (length != iVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + iVarArr.length + ")");
        }
        for (int i = 0; i < length; i++) {
            iVarArr[i].a(kVar, objArr[i]);
        }
        return kVar.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public T a(ac acVar) throws IOException {
        return this.f.a(acVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a<T> {

        /* renamed from: a, reason: collision with root package name */
        final m f52a;
        final Method b;
        final Annotation[] c;
        final Annotation[][] d;
        final Type[] e;
        Type f;
        boolean g;
        boolean h;
        boolean i;
        boolean j;
        boolean k;
        boolean l;
        String m;
        boolean n;
        boolean o;
        boolean p;
        String q;
        s r;
        v s;
        Set<String> t;
        i<?>[] u;
        e<ac, T> v;
        c<?> w;

        public a(m mVar, Method method) {
            this.f52a = mVar;
            this.b = method;
            this.c = method.getAnnotations();
            this.e = method.getGenericParameterTypes();
            this.d = method.getParameterAnnotations();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public n a() {
            this.w = b();
            this.f = this.w.a();
            Type type = this.f;
            if (type == l.class || type == ab.class) {
                throw a("'" + o.a(this.f).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
            }
            this.v = c();
            for (Annotation annotation : this.c) {
                a(annotation);
            }
            if (this.m == null) {
                throw a("HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.n) {
                if (this.p) {
                    throw a("Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.o) {
                    throw a("FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.d.length;
            this.u = new i[length];
            for (int i = 0; i < length; i++) {
                Type type2 = this.e[i];
                if (o.d(type2)) {
                    throw a(i, "Parameter type must not include a type variable or wildcard: %s", type2);
                }
                Annotation[] annotationArr = this.d[i];
                if (annotationArr == null) {
                    throw a(i, "No Retrofit annotation found.", new Object[0]);
                }
                this.u[i] = a(i, type2, annotationArr);
            }
            if (this.q == null && !this.l) {
                throw a("Missing either @%s URL or @Url parameter.", this.m);
            }
            if (!this.o && !this.p && !this.n && this.i) {
                throw a("Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (this.o && !this.g) {
                throw a("Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (this.p && !this.h) {
                throw a("Multipart method must contain at least one @Part.", new Object[0]);
            }
            return new n(this);
        }

        private c<?> b() {
            Type genericReturnType = this.b.getGenericReturnType();
            if (o.d(genericReturnType)) {
                throw a("Method return type must not include a type variable or wildcard: %s", genericReturnType);
            }
            if (genericReturnType == Void.TYPE) {
                throw a("Service methods cannot return void.", new Object[0]);
            }
            try {
                return this.f52a.a(genericReturnType, this.b.getAnnotations());
            } catch (RuntimeException e) {
                throw a(e, "Unable to create call adapter for %s", genericReturnType);
            }
        }

        private void a(Annotation annotation) {
            if (annotation instanceof a.b.b) {
                a("DELETE", ((a.b.b) annotation).a(), false);
                return;
            }
            if (annotation instanceof a.b.f) {
                a("GET", ((a.b.f) annotation).a(), false);
                return;
            }
            if (annotation instanceof a.b.g) {
                a("HEAD", ((a.b.g) annotation).a(), false);
                if (!Void.class.equals(this.f)) {
                    throw a("HEAD method must use Void as response type.", new Object[0]);
                }
                return;
            }
            if (annotation instanceof a.b.n) {
                a(HttpClientStack.HttpPatch.METHOD_NAME, ((a.b.n) annotation).a(), true);
                return;
            }
            if (annotation instanceof a.b.o) {
                a("POST", ((a.b.o) annotation).a(), true);
                return;
            }
            if (annotation instanceof p) {
                a("PUT", ((p) annotation).a(), true);
                return;
            }
            if (annotation instanceof a.b.m) {
                a("OPTIONS", ((a.b.m) annotation).a(), false);
                return;
            }
            if (annotation instanceof a.b.h) {
                a.b.h hVar = (a.b.h) annotation;
                a(hVar.a(), hVar.b(), hVar.c());
                return;
            }
            if (annotation instanceof a.b.k) {
                String[] a2 = ((a.b.k) annotation).a();
                if (a2.length == 0) {
                    throw a("@Headers annotation is empty.", new Object[0]);
                }
                this.r = a(a2);
                return;
            }
            if (annotation instanceof a.b.l) {
                if (this.o) {
                    throw a("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.p = true;
            } else if (annotation instanceof a.b.e) {
                if (this.p) {
                    throw a("Only one encoding annotation is allowed.", new Object[0]);
                }
                this.o = true;
            }
        }

        private void a(String str, String str2, boolean z) {
            String str3 = this.m;
            if (str3 != null) {
                throw a("Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.m = str;
            this.n = z;
            if (str2.isEmpty()) {
                return;
            }
            int indexOf = str2.indexOf(63);
            if (indexOf != -1 && indexOf < str2.length() - 1) {
                String substring = str2.substring(indexOf + 1);
                if (n.f51a.matcher(substring).find()) {
                    throw a("URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", substring);
                }
            }
            this.q = str2;
            this.t = n.a(str2);
        }

        private s a(String[] strArr) {
            s.a aVar = new s.a();
            for (String str : strArr) {
                int indexOf = str.indexOf(58);
                if (indexOf == -1 || indexOf == 0 || indexOf == str.length() - 1) {
                    throw a("@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String substring = str.substring(0, indexOf);
                String trim = str.substring(indexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(substring)) {
                    v b = v.b(trim);
                    if (b == null) {
                        throw a("Malformed content type: %s", trim);
                    }
                    this.s = b;
                } else {
                    aVar.a(substring, trim);
                }
            }
            return aVar.a();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private i<?> a(int i, Type type, Annotation[] annotationArr) {
            i<?> iVar = null;
            for (Annotation annotation : annotationArr) {
                i<?> a2 = a(i, type, annotationArr, annotation);
                if (a2 != null) {
                    if (iVar != null) {
                        throw a(i, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                    }
                    iVar = a2;
                }
            }
            if (iVar != null) {
                return iVar;
            }
            throw a(i, "No Retrofit annotation found.", new Object[0]);
        }

        private i<?> a(int i, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof w) {
                if (this.l) {
                    throw a(i, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.j) {
                    throw a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.k) {
                    throw a(i, "A @Url parameter must not come after a @Query", new Object[0]);
                }
                if (this.q != null) {
                    throw a(i, "@Url cannot be used with @%s URL", this.m);
                }
                this.l = true;
                if (type == t.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new i.l();
                }
                throw a(i, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof a.b.s) {
                if (this.k) {
                    throw a(i, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.l) {
                    throw a(i, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.q == null) {
                    throw a(i, "@Path can only be used with relative url on @%s", this.m);
                }
                this.j = true;
                a.b.s sVar = (a.b.s) annotation;
                String a2 = sVar.a();
                a(i, a2);
                return new i.h(a2, this.f52a.c(type, annotationArr), sVar.b());
            }
            if (annotation instanceof a.b.t) {
                a.b.t tVar = (a.b.t) annotation;
                String a3 = tVar.a();
                boolean b = tVar.b();
                Class<?> a4 = o.a(type);
                this.k = true;
                if (Iterable.class.isAssignableFrom(a4)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw a(i, a4.getSimpleName() + " must include generic type (e.g., " + a4.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new i.C0002i(a3, this.f52a.c(o.a(0, (ParameterizedType) type), annotationArr), b).a();
                }
                if (a4.isArray()) {
                    return new i.C0002i(a3, this.f52a.c(n.a(a4.getComponentType()), annotationArr), b).b();
                }
                return new i.C0002i(a3, this.f52a.c(type, annotationArr), b);
            }
            if (annotation instanceof u) {
                Class<?> a5 = o.a(type);
                if (!Map.class.isAssignableFrom(a5)) {
                    throw a(i, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type b2 = o.b(type, a5, Map.class);
                if (!(b2 instanceof ParameterizedType)) {
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) b2;
                Type a6 = o.a(0, parameterizedType);
                if (String.class != a6) {
                    throw a(i, "@QueryMap keys must be of type String: " + a6, new Object[0]);
                }
                return new i.j(this.f52a.c(o.a(1, parameterizedType), annotationArr), ((u) annotation).a());
            }
            if (annotation instanceof a.b.i) {
                String a7 = ((a.b.i) annotation).a();
                Class<?> a8 = o.a(type);
                if (Iterable.class.isAssignableFrom(a8)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw a(i, a8.getSimpleName() + " must include generic type (e.g., " + a8.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new i.d(a7, this.f52a.c(o.a(0, (ParameterizedType) type), annotationArr)).a();
                }
                if (a8.isArray()) {
                    return new i.d(a7, this.f52a.c(n.a(a8.getComponentType()), annotationArr)).b();
                }
                return new i.d(a7, this.f52a.c(type, annotationArr));
            }
            if (annotation instanceof a.b.j) {
                Class<?> a9 = o.a(type);
                if (!Map.class.isAssignableFrom(a9)) {
                    throw a(i, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type b3 = o.b(type, a9, Map.class);
                if (!(b3 instanceof ParameterizedType)) {
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) b3;
                Type a10 = o.a(0, parameterizedType2);
                if (String.class != a10) {
                    throw a(i, "@HeaderMap keys must be of type String: " + a10, new Object[0]);
                }
                return new i.e(this.f52a.c(o.a(1, parameterizedType2), annotationArr));
            }
            if (annotation instanceof a.b.c) {
                if (!this.o) {
                    throw a(i, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                a.b.c cVar = (a.b.c) annotation;
                String a11 = cVar.a();
                boolean b4 = cVar.b();
                this.g = true;
                Class<?> a12 = o.a(type);
                if (Iterable.class.isAssignableFrom(a12)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw a(i, a12.getSimpleName() + " must include generic type (e.g., " + a12.getSimpleName() + "<String>)", new Object[0]);
                    }
                    return new i.b(a11, this.f52a.c(o.a(0, (ParameterizedType) type), annotationArr), b4).a();
                }
                if (a12.isArray()) {
                    return new i.b(a11, this.f52a.c(n.a(a12.getComponentType()), annotationArr), b4).b();
                }
                return new i.b(a11, this.f52a.c(type, annotationArr), b4);
            }
            if (annotation instanceof a.b.d) {
                if (!this.o) {
                    throw a(i, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> a13 = o.a(type);
                if (!Map.class.isAssignableFrom(a13)) {
                    throw a(i, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type b5 = o.b(type, a13, Map.class);
                if (!(b5 instanceof ParameterizedType)) {
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) b5;
                Type a14 = o.a(0, parameterizedType3);
                if (String.class != a14) {
                    throw a(i, "@FieldMap keys must be of type String: " + a14, new Object[0]);
                }
                e<T, String> c = this.f52a.c(o.a(1, parameterizedType3), annotationArr);
                this.g = true;
                return new i.c(c, ((a.b.d) annotation).a());
            }
            if (annotation instanceof q) {
                if (!this.p) {
                    throw a(i, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                q qVar = (q) annotation;
                this.h = true;
                String a15 = qVar.a();
                Class<?> a16 = o.a(type);
                if (a15.isEmpty()) {
                    if (Iterable.class.isAssignableFrom(a16)) {
                        if (!(type instanceof ParameterizedType)) {
                            throw a(i, a16.getSimpleName() + " must include generic type (e.g., " + a16.getSimpleName() + "<String>)", new Object[0]);
                        }
                        if (!w.b.class.isAssignableFrom(o.a(o.a(0, (ParameterizedType) type)))) {
                            throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        return i.k.f41a.a();
                    }
                    if (a16.isArray()) {
                        if (!w.b.class.isAssignableFrom(a16.getComponentType())) {
                            throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        return i.k.f41a.b();
                    }
                    if (w.b.class.isAssignableFrom(a16)) {
                        return i.k.f41a;
                    }
                    throw a(i, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                }
                s a17 = s.a(Headers.CONTENT_DISPOSITION, "form-data; name=\"" + a15 + "\"", "Content-Transfer-Encoding", qVar.b());
                if (Iterable.class.isAssignableFrom(a16)) {
                    if (!(type instanceof ParameterizedType)) {
                        throw a(i, a16.getSimpleName() + " must include generic type (e.g., " + a16.getSimpleName() + "<String>)", new Object[0]);
                    }
                    Type a18 = o.a(0, (ParameterizedType) type);
                    if (w.b.class.isAssignableFrom(o.a(a18))) {
                        throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new i.f(a17, this.f52a.a(a18, annotationArr, this.c)).a();
                }
                if (a16.isArray()) {
                    Class<?> a19 = n.a(a16.getComponentType());
                    if (w.b.class.isAssignableFrom(a19)) {
                        throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new i.f(a17, this.f52a.a(a19, annotationArr, this.c)).b();
                }
                if (w.b.class.isAssignableFrom(a16)) {
                    throw a(i, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                }
                return new i.f(a17, this.f52a.a(type, annotationArr, this.c));
            }
            if (annotation instanceof r) {
                if (!this.p) {
                    throw a(i, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.h = true;
                Class<?> a20 = o.a(type);
                if (!Map.class.isAssignableFrom(a20)) {
                    throw a(i, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type b6 = o.b(type, a20, Map.class);
                if (!(b6 instanceof ParameterizedType)) {
                    throw a(i, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) b6;
                Type a21 = o.a(0, parameterizedType4);
                if (String.class != a21) {
                    throw a(i, "@PartMap keys must be of type String: " + a21, new Object[0]);
                }
                Type a22 = o.a(1, parameterizedType4);
                if (w.b.class.isAssignableFrom(o.a(a22))) {
                    throw a(i, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                }
                return new i.g(this.f52a.a(a22, annotationArr, this.c), ((r) annotation).a());
            }
            if (!(annotation instanceof a.b.a)) {
                return null;
            }
            if (this.o || this.p) {
                throw a(i, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
            }
            if (this.i) {
                throw a(i, "Multiple @Body method annotations found.", new Object[0]);
            }
            try {
                e<T, aa> a23 = this.f52a.a(type, annotationArr, this.c);
                this.i = true;
                return new i.a(a23);
            } catch (RuntimeException e) {
                throw a(e, i, "Unable to create @Body converter for %s", type);
            }
        }

        private void a(int i, String str) {
            if (!n.b.matcher(str).matches()) {
                throw a(i, "@Path parameter name must match %s. Found: %s", n.f51a.pattern(), str);
            }
            if (!this.t.contains(str)) {
                throw a(i, "URL \"%s\" does not contain \"{%s}\".", this.q, str);
            }
        }

        private e<ac, T> c() {
            try {
                return this.f52a.b(this.f, this.b.getAnnotations());
            } catch (RuntimeException e) {
                throw a(e, "Unable to create converter for %s", this.f);
            }
        }

        private RuntimeException a(String str, Object... objArr) {
            return a((Throwable) null, str, objArr);
        }

        private RuntimeException a(Throwable th, String str, Object... objArr) {
            return new IllegalArgumentException(String.format(str, objArr) + "\n    for method " + this.b.getDeclaringClass().getSimpleName() + "." + this.b.getName(), th);
        }

        private RuntimeException a(Throwable th, int i, String str, Object... objArr) {
            return a(th, str + " (parameter #" + (i + 1) + ")", objArr);
        }

        private RuntimeException a(int i, String str, Object... objArr) {
            return a(str + " (parameter #" + (i + 1) + ")", objArr);
        }
    }

    static Set<String> a(String str) {
        Matcher matcher = f51a.matcher(str);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (matcher.find()) {
            linkedHashSet.add(matcher.group(1));
        }
        return linkedHashSet;
    }

    static Class<?> a(Class<?> cls) {
        return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
    }
}
