package androidx.constraintlayout.solver;

/* loaded from: classes.dex */
final class g {

    /* loaded from: classes.dex */
    interface a<T> {
        T a();

        void a(T[] tArr, int i);

        boolean a(T t);
    }

    /* loaded from: classes.dex */
    static class b<T> implements a<T> {

        /* renamed from: a, reason: collision with root package name */
        private final Object[] f424a;
        private int b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.f424a = new Object[i];
        }

        @Override // androidx.constraintlayout.solver.g.a
        public T a() {
            int i = this.b;
            if (i <= 0) {
                return null;
            }
            int i2 = i - 1;
            Object[] objArr = this.f424a;
            T t = (T) objArr[i2];
            objArr[i2] = null;
            this.b = i - 1;
            return t;
        }

        @Override // androidx.constraintlayout.solver.g.a
        public boolean a(T t) {
            int i = this.b;
            Object[] objArr = this.f424a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.b = i + 1;
            return true;
        }

        @Override // androidx.constraintlayout.solver.g.a
        public void a(T[] tArr, int i) {
            if (i > tArr.length) {
                i = tArr.length;
            }
            for (int i2 = 0; i2 < i; i2++) {
                T t = tArr[i2];
                int i3 = this.b;
                Object[] objArr = this.f424a;
                if (i3 < objArr.length) {
                    objArr[i3] = t;
                    this.b = i3 + 1;
                }
            }
        }
    }
}
