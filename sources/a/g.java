package a;

import a.c;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g extends c.a {

    /* renamed from: a, reason: collision with root package name */
    final Executor f18a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(Executor executor) {
        this.f18a = executor;
    }

    @Override // a.c.a
    public c<b<?>> a(Type type, Annotation[] annotationArr, m mVar) {
        if (a(type) != b.class) {
            return null;
        }
        final Type e = o.e(type);
        return new c<b<?>>() { // from class: a.g.1
            @Override // a.c
            public Type a() {
                return e;
            }

            @Override // a.c
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public <R> b<R> a(b<R> bVar) {
                return new a(g.this.f18a, bVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a<T> implements b<T> {

        /* renamed from: a, reason: collision with root package name */
        final Executor f20a;
        final b<T> b;

        a(Executor executor, b<T> bVar) {
            this.f20a = executor;
            this.b = bVar;
        }

        @Override // a.b
        public void a(final d<T> dVar) {
            if (dVar == null) {
                throw new NullPointerException("callback == null");
            }
            this.b.a(new d<T>() { // from class: a.g.a.1
                @Override // a.d
                public void onResponse(b<T> bVar, final l<T> lVar) {
                    a.this.f20a.execute(new Runnable() { // from class: a.g.a.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (a.this.b.b()) {
                                dVar.onFailure(a.this, new IOException("Canceled"));
                            } else {
                                dVar.onResponse(a.this, lVar);
                            }
                        }
                    });
                }

                @Override // a.d
                public void onFailure(b<T> bVar, final Throwable th) {
                    a.this.f20a.execute(new Runnable() { // from class: a.g.a.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            dVar.onFailure(a.this, th);
                        }
                    });
                }
            });
        }

        @Override // a.b
        public l<T> a() throws IOException {
            return this.b.a();
        }

        @Override // a.b
        public boolean b() {
            return this.b.b();
        }

        @Override // a.b
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public b<T> clone() {
            return new a(this.f20a, this.b.clone());
        }
    }
}
