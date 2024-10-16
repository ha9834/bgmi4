package androidx.core.e;

/* loaded from: classes.dex */
public final class d {

    /* loaded from: classes.dex */
    public interface a<T> {
        T a();

        boolean a(T t);
    }

    /* loaded from: classes.dex */
    public static class b<T> implements a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object[] f515a;
        private int b;

        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f515a = new Object[i];
        }

        @Override // androidx.core.e.d.a
        public T a() {
            int i = this.b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.f515a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.b = i - 1;
            return t;
        }

        @Override // androidx.core.e.d.a
        public boolean a(T t) {
            if (b(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.b;
            Object[] objArr = this.f515a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.b = i + 1;
            return true;
        }

        private boolean b(T t) {
            for (int i = 0; i < this.b; i++) {
                if (this.f515a[i] == t) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c<T> extends b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object f516a;

        public c(int i) {
            super(i);
            this.f516a = new Object();
        }

        @Override // androidx.core.e.d.b, androidx.core.e.d.a
        public T a() {
            T t;
            synchronized (this.f516a) {
                t = (T) super.a();
            }
            return t;
        }

        @Override // androidx.core.e.d.b, androidx.core.e.d.a
        public boolean a(T t) {
            boolean a2;
            synchronized (this.f516a) {
                a2 = super.a(t);
            }
            return a2;
        }
    }
}
