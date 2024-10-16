package a;

import a.c;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f extends c.a {

    /* renamed from: a, reason: collision with root package name */
    static final c.a f16a = new f();

    f() {
    }

    @Override // a.c.a
    public c<?> a(Type type, Annotation[] annotationArr, m mVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type e = o.e(type);
        return new c<b<?>>() { // from class: a.f.1
            @Override // a.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public <R> b<R> a(b<R> bVar) {
                return bVar;
            }

            @Override // a.c
            public Type a() {
                return e;
            }
        };
    }
}
