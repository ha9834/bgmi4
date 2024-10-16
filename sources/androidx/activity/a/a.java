package androidx.activity.a;

import android.content.Context;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f125a = new CopyOnWriteArraySet();
    private volatile Context b;

    public Context a() {
        return this.b;
    }

    public void a(b bVar) {
        if (this.b != null) {
            bVar.a(this.b);
        }
        this.f125a.add(bVar);
    }

    public void b(b bVar) {
        this.f125a.remove(bVar);
    }

    public void a(Context context) {
        this.b = context;
        Iterator<b> it = this.f125a.iterator();
        while (it.hasNext()) {
            it.next().a(context);
        }
    }

    public void b() {
        this.b = null;
    }
}
