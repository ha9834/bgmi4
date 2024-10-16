package okhttp3.internal;

/* loaded from: classes3.dex */
public abstract class b implements Runnable {
    protected final String c;

    protected abstract void c();

    public b(String str, Object... objArr) {
        this.c = c.a(str, objArr);
    }

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread.currentThread().setName(this.c);
        try {
            c();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
