package a;

import a.b.v;
import a.e;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.aa;
import okhttp3.ac;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a extends e.a {
    @Override // a.e.a
    public a.e<ac, ?> a(Type type, Annotation[] annotationArr, m mVar) {
        if (type == ac.class) {
            if (o.a(annotationArr, (Class<? extends Annotation>) v.class)) {
                return c.f12a;
            }
            return C0000a.f7a;
        }
        if (type == Void.class) {
            return f.f15a;
        }
        return null;
    }

    @Override // a.e.a
    public a.e<?, aa> a(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, m mVar) {
        if (aa.class.isAssignableFrom(o.a(type))) {
            return b.f11a;
        }
        return null;
    }

    @Override // a.e.a
    public a.e<?, String> b(Type type, Annotation[] annotationArr, m mVar) {
        if (type == String.class) {
            return d.f13a;
        }
        return null;
    }

    /* loaded from: classes.dex */
    static final class d implements a.e<String, String> {

        /* renamed from: a, reason: collision with root package name */
        static final d f13a = new d();

        @Override // a.e
        public String a(String str) throws IOException {
            return str;
        }

        d() {
        }
    }

    /* loaded from: classes.dex */
    static final class f implements a.e<ac, Void> {

        /* renamed from: a, reason: collision with root package name */
        static final f f15a = new f();

        f() {
        }

        @Override // a.e
        public Void a(ac acVar) throws IOException {
            acVar.close();
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class b implements a.e<aa, aa> {

        /* renamed from: a, reason: collision with root package name */
        static final b f11a = new b();

        @Override // a.e
        public aa a(aa aaVar) throws IOException {
            return aaVar;
        }

        b() {
        }
    }

    /* loaded from: classes.dex */
    static final class c implements a.e<ac, ac> {

        /* renamed from: a, reason: collision with root package name */
        static final c f12a = new c();

        @Override // a.e
        public ac a(ac acVar) throws IOException {
            return acVar;
        }

        c() {
        }
    }

    /* renamed from: a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static final class C0000a implements a.e<ac, ac> {

        /* renamed from: a, reason: collision with root package name */
        static final C0000a f7a = new C0000a();

        C0000a() {
        }

        @Override // a.e
        public ac a(ac acVar) throws IOException {
            try {
                return o.a(acVar);
            } finally {
                acVar.close();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e implements a.e<Object, String> {

        /* renamed from: a, reason: collision with root package name */
        static final e f14a = new e();

        e() {
        }

        @Override // a.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            return obj.toString();
        }
    }
}
