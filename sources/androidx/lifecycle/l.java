package androidx.lifecycle;

import android.annotation.SuppressLint;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public class l extends Lifecycle {
    private androidx.a.a.b.a<j, a> b;
    private Lifecycle.State c;
    private final WeakReference<k> d;
    private int e;
    private boolean f;
    private boolean g;
    private ArrayList<Lifecycle.State> h;
    private final boolean i;

    public l(k kVar) {
        this(kVar, true);
    }

    private l(k kVar, boolean z) {
        this.b = new androidx.a.a.b.a<>();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = new ArrayList<>();
        this.d = new WeakReference<>(kVar);
        this.c = Lifecycle.State.INITIALIZED;
        this.i = z;
    }

    @Deprecated
    public void a(Lifecycle.State state) {
        a("markState");
        b(state);
    }

    public void b(Lifecycle.State state) {
        a("setCurrentState");
        c(state);
    }

    public void a(Lifecycle.Event event) {
        a("handleLifecycleEvent");
        c(event.a());
    }

    private void c(Lifecycle.State state) {
        if (this.c == state) {
            return;
        }
        this.c = state;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        d();
        this.f = false;
    }

    private boolean b() {
        if (this.b.a() == 0) {
            return true;
        }
        Lifecycle.State state = this.b.d().getValue().f787a;
        Lifecycle.State state2 = this.b.e().getValue().f787a;
        return state == state2 && this.c == state2;
    }

    private Lifecycle.State c(j jVar) {
        Map.Entry<j, a> d = this.b.d(jVar);
        Lifecycle.State state = null;
        Lifecycle.State state2 = d != null ? d.getValue().f787a : null;
        if (!this.h.isEmpty()) {
            state = this.h.get(r0.size() - 1);
        }
        return a(a(this.c, state2), state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void a(j jVar) {
        k kVar;
        a("addObserver");
        a aVar = new a(jVar, this.c == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED);
        if (this.b.a(jVar, aVar) == null && (kVar = this.d.get()) != null) {
            boolean z = this.e != 0 || this.f;
            Lifecycle.State c = c(jVar);
            this.e++;
            while (aVar.f787a.compareTo(c) < 0 && this.b.c(jVar)) {
                d(aVar.f787a);
                Lifecycle.Event b = Lifecycle.Event.b(aVar.f787a);
                if (b == null) {
                    throw new IllegalStateException("no event up from " + aVar.f787a);
                }
                aVar.a(kVar, b);
                c();
                c = c(jVar);
            }
            if (!z) {
                d();
            }
            this.e--;
        }
    }

    private void c() {
        this.h.remove(r0.size() - 1);
    }

    private void d(Lifecycle.State state) {
        this.h.add(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void b(j jVar) {
        a("removeObserver");
        this.b.b(jVar);
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State a() {
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(k kVar) {
        androidx.a.a.b.b<j, a>.d c = this.b.c();
        while (c.hasNext() && !this.g) {
            Map.Entry next = c.next();
            a aVar = (a) next.getValue();
            while (aVar.f787a.compareTo(this.c) < 0 && !this.g && this.b.c(next.getKey())) {
                d(aVar.f787a);
                Lifecycle.Event b = Lifecycle.Event.b(aVar.f787a);
                if (b == null) {
                    throw new IllegalStateException("no event up from " + aVar.f787a);
                }
                aVar.a(kVar, b);
                c();
            }
        }
    }

    private void b(k kVar) {
        Iterator<Map.Entry<j, a>> b = this.b.b();
        while (b.hasNext() && !this.g) {
            Map.Entry<j, a> next = b.next();
            a value = next.getValue();
            while (value.f787a.compareTo(this.c) > 0 && !this.g && this.b.c(next.getKey())) {
                Lifecycle.Event a2 = Lifecycle.Event.a(value.f787a);
                if (a2 == null) {
                    throw new IllegalStateException("no event down from " + value.f787a);
                }
                d(a2.a());
                value.a(kVar, a2);
                c();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void d() {
        k kVar = this.d.get();
        if (kVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (!b()) {
            this.g = false;
            if (this.c.compareTo(this.b.d().getValue().f787a) < 0) {
                b(kVar);
            }
            Map.Entry<j, a> e = this.b.e();
            if (!this.g && e != null && this.c.compareTo(e.getValue().f787a) > 0) {
                a(kVar);
            }
        }
        this.g = false;
    }

    @SuppressLint({"RestrictedApi"})
    private void a(String str) {
        if (!this.i || androidx.a.a.a.a.a().b()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    static Lifecycle.State a(Lifecycle.State state, Lifecycle.State state2) {
        return (state2 == null || state2.compareTo(state) >= 0) ? state : state2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        Lifecycle.State f787a;
        i b;

        a(j jVar, Lifecycle.State state) {
            this.b = n.a(jVar);
            this.f787a = state;
        }

        void a(k kVar, Lifecycle.Event event) {
            Lifecycle.State a2 = event.a();
            this.f787a = l.a(this.f787a, a2);
            this.b.a(kVar, event);
            this.f787a = a2;
        }
    }
}
