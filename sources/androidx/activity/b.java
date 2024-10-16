package androidx.activity;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f126a;
    private CopyOnWriteArrayList<a> b = new CopyOnWriteArrayList<>();

    public abstract void c();

    public b(boolean z) {
        this.f126a = z;
    }

    public final void a(boolean z) {
        this.f126a = z;
    }

    public final boolean a() {
        return this.f126a;
    }

    public final void b() {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.b.add(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(a aVar) {
        this.b.remove(aVar);
    }
}
