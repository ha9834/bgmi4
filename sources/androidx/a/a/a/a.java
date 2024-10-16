package androidx.a.a.a;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class a extends c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f104a;
    private static final Executor d = new Executor() { // from class: androidx.a.a.a.a.1
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().b(runnable);
        }
    };
    private static final Executor e = new Executor() { // from class: androidx.a.a.a.a.2
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.a().a(runnable);
        }
    };
    private c c = new b();
    private c b = this.c;

    private a() {
    }

    public static a a() {
        if (f104a != null) {
            return f104a;
        }
        synchronized (a.class) {
            if (f104a == null) {
                f104a = new a();
            }
        }
        return f104a;
    }

    @Override // androidx.a.a.a.c
    public void a(Runnable runnable) {
        this.b.a(runnable);
    }

    @Override // androidx.a.a.a.c
    public void b(Runnable runnable) {
        this.b.b(runnable);
    }

    @Override // androidx.a.a.a.c
    public boolean b() {
        return this.b.b();
    }
}
