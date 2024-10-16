package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
public abstract class LiveData<T> {
    static final Object b = new Object();
    private boolean f;
    private boolean i;
    private boolean j;

    /* renamed from: a, reason: collision with root package name */
    final Object f773a = new Object();
    private androidx.a.a.b.b<q<? super T>, LiveData<T>.b> e = new androidx.a.a.b.b<>();
    int c = 0;
    volatile Object d = b;
    private final Runnable k = new Runnable() { // from class: androidx.lifecycle.LiveData.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.f773a) {
                obj = LiveData.this.d;
                LiveData.this.d = LiveData.b;
            }
            LiveData.this.b((LiveData) obj);
        }
    };
    private volatile Object g = b;
    private int h = -1;

    protected void b() {
    }

    protected void c() {
    }

    private void b(LiveData<T>.b bVar) {
        if (bVar.d) {
            if (!bVar.a()) {
                bVar.a(false);
                return;
            }
            int i = bVar.e;
            int i2 = this.h;
            if (i >= i2) {
                return;
            }
            bVar.e = i2;
            bVar.c.a((Object) this.g);
        }
    }

    void a(LiveData<T>.b bVar) {
        if (this.i) {
            this.j = true;
            return;
        }
        this.i = true;
        do {
            this.j = false;
            if (bVar != null) {
                b((b) bVar);
                bVar = null;
            } else {
                androidx.a.a.b.b<q<? super T>, LiveData<T>.b>.d c = this.e.c();
                while (c.hasNext()) {
                    b((b) c.next().getValue());
                    if (this.j) {
                        break;
                    }
                }
            }
        } while (this.j);
        this.i = false;
    }

    public void a(k kVar, q<? super T> qVar) {
        a("observe");
        if (kVar.getLifecycle().a() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(kVar, qVar);
        LiveData<T>.b a2 = this.e.a(qVar, lifecycleBoundObserver);
        if (a2 != null && !a2.a(kVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (a2 != null) {
            return;
        }
        kVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void a(q<? super T> qVar) {
        a("observeForever");
        a aVar = new a(qVar);
        LiveData<T>.b a2 = this.e.a(qVar, aVar);
        if (a2 instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (a2 != null) {
            return;
        }
        aVar.a(true);
    }

    public void b(q<? super T> qVar) {
        a("removeObserver");
        LiveData<T>.b b2 = this.e.b(qVar);
        if (b2 == null) {
            return;
        }
        b2.b();
        b2.a(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(T t) {
        boolean z;
        synchronized (this.f773a) {
            z = this.d == b;
            this.d = t;
        }
        if (z) {
            androidx.a.a.a.a.a().b(this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(T t) {
        a("setValue");
        this.h++;
        this.g = t;
        a((b) null);
    }

    public T a() {
        T t = (T) this.g;
        if (t != b) {
            return t;
        }
        return null;
    }

    public boolean d() {
        return this.c > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void a(int i) {
        int i2 = this.c;
        this.c = i + i2;
        if (this.f) {
            return;
        }
        this.f = true;
        while (true) {
            try {
                if (i2 == this.c) {
                    return;
                }
                boolean z = i2 == 0 && this.c > 0;
                boolean z2 = i2 > 0 && this.c == 0;
                int i3 = this.c;
                if (z) {
                    b();
                } else if (z2) {
                    c();
                }
                i2 = i3;
            } finally {
                this.f = false;
            }
        }
    }

    /* loaded from: classes.dex */
    class LifecycleBoundObserver extends LiveData<T>.b implements i {

        /* renamed from: a, reason: collision with root package name */
        final k f775a;

        LifecycleBoundObserver(k kVar, q<? super T> qVar) {
            super(qVar);
            this.f775a = kVar;
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean a() {
            return this.f775a.getLifecycle().a().a(Lifecycle.State.STARTED);
        }

        @Override // androidx.lifecycle.i
        public void a(k kVar, Lifecycle.Event event) {
            Lifecycle.State a2 = this.f775a.getLifecycle().a();
            if (a2 == Lifecycle.State.DESTROYED) {
                LiveData.this.b((q) this.c);
                return;
            }
            Lifecycle.State state = null;
            while (state != a2) {
                a(a());
                state = a2;
                a2 = this.f775a.getLifecycle().a();
            }
        }

        @Override // androidx.lifecycle.LiveData.b
        boolean a(k kVar) {
            return this.f775a == kVar;
        }

        @Override // androidx.lifecycle.LiveData.b
        void b() {
            this.f775a.getLifecycle().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b {
        final q<? super T> c;
        boolean d;
        int e = -1;

        abstract boolean a();

        boolean a(k kVar) {
            return false;
        }

        void b() {
        }

        b(q<? super T> qVar) {
            this.c = qVar;
        }

        void a(boolean z) {
            if (z == this.d) {
                return;
            }
            this.d = z;
            LiveData.this.a(this.d ? 1 : -1);
            if (this.d) {
                LiveData.this.a(this);
            }
        }
    }

    /* loaded from: classes.dex */
    private class a extends LiveData<T>.b {
        @Override // androidx.lifecycle.LiveData.b
        boolean a() {
            return true;
        }

        a(q<? super T> qVar) {
            super(qVar);
        }
    }

    static void a(String str) {
        if (androidx.a.a.a.a.a().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
