package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.f;

/* loaded from: classes3.dex */
public abstract class Random {

    /* renamed from: a, reason: collision with root package name */
    public static final Default f6975a = new Default(null);
    private static final Random b = kotlin.b.b.f6938a.a();

    public abstract int a(int i);

    public int b() {
        return a(32);
    }

    /* loaded from: classes3.dex */
    public static final class Default extends Random implements Serializable {
        private Default() {
        }

        public /* synthetic */ Default(f fVar) {
            this();
        }

        /* loaded from: classes3.dex */
        private static final class Serialized implements Serializable {

            /* renamed from: a, reason: collision with root package name */
            public static final Serialized f6976a = new Serialized();
            private static final long serialVersionUID = 0;

            private Serialized() {
            }

            private final Object readResolve() {
                return Random.f6975a;
            }
        }

        private final Object writeReplace() {
            return Serialized.f6976a;
        }

        @Override // kotlin.random.Random
        public int a(int i) {
            return Random.b.a(i);
        }

        @Override // kotlin.random.Random
        public int b() {
            return Random.b.b();
        }
    }
}
