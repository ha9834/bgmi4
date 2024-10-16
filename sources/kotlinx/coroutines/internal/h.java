package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes3.dex */
public final class h<E> {
    private volatile Object _next;
    private volatile long _state;
    private final int c;
    private AtomicReferenceArray f;
    private final int g;
    private final boolean h;
    public static final a b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public static final m f7011a = new m("REMOVE_FROZEN");
    private static final AtomicReferenceFieldUpdater d = AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "_next");
    private static final AtomicLongFieldUpdater e = AtomicLongFieldUpdater.newUpdater(h.class, "_state");

    public h(int i, boolean z) {
        this.g = i;
        this.h = z;
        int i2 = this.g;
        this.c = i2 - 1;
        this._next = null;
        this._state = 0L;
        this.f = new AtomicReferenceArray(i2);
        if (!(this.c <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((this.g & this.c) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final boolean a() {
        a aVar = b;
        long j = this._state;
        return ((int) ((1073741823 & j) >> 0)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final int b() {
        a aVar = b;
        long j = this._state;
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j) >> 0)));
    }

    private final h<E> a(int i, E e2) {
        Object obj = this.f.get(this.c & i);
        if (!(obj instanceof b) || ((b) obj).f7012a != i) {
            return null;
        }
        this.f.set(i & this.c, e2);
        return this;
    }

    public final h<E> e() {
        return a(f());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final h<E> b(long j) {
        h<E> hVar = new h<>(this.g * 2, this.h);
        a aVar = b;
        int i = (int) ((1073741823 & j) >> 0);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.c;
            if ((i & i3) != (i2 & i3)) {
                Object obj = this.f.get(i3 & i);
                if (obj == null) {
                    obj = new b(i);
                }
                hVar.f.set(hVar.c & i, obj);
                i++;
            } else {
                hVar._state = b.a(j, 1152921504606846976L);
                return hVar;
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f7012a;

        public b(int i) {
            this.f7012a = i;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public final int a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long a(long j, long j2) {
            return j & (j2 ^ (-1));
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final long a(long j, int i) {
            return a(j, 1073741823L) | (i << 0);
        }

        public final long b(long j, int i) {
            return a(j, 1152921503533105152L) | (i << 30);
        }
    }

    public final boolean c() {
        long j;
        do {
            j = this._state;
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!e.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(E r13) {
        /*
            r12 = this;
        L0:
            long r2 = r12._state
            r0 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r0 = r0 & r2
            r6 = 0
            int r4 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r4 == 0) goto L12
            kotlinx.coroutines.internal.h$a r13 = kotlinx.coroutines.internal.h.b
            int r13 = r13.a(r2)
            return r13
        L12:
            kotlinx.coroutines.internal.h$a r0 = kotlinx.coroutines.internal.h.b
            r0 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r0 = r0 & r2
            r8 = 0
            long r0 = r0 >> r8
            int r1 = (int) r0
            r4 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r4 = r4 & r2
            r0 = 30
            long r4 = r4 >> r0
            int r9 = (int) r4
            int r10 = r12.c
            int r0 = r9 + 2
            r0 = r0 & r10
            r4 = r1 & r10
            r5 = 1
            if (r0 != r4) goto L30
            return r5
        L30:
            boolean r0 = r12.h
            r4 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f
            r11 = r9 & r10
            java.lang.Object r0 = r0.get(r11)
            if (r0 == 0) goto L4f
            int r0 = r12.g
            r2 = 1024(0x400, float:1.435E-42)
            if (r0 < r2) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r4
            int r0 = r0 >> 1
            if (r1 <= r0) goto L0
        L4e:
            return r5
        L4f:
            int r0 = r9 + 1
            r0 = r0 & r4
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = kotlinx.coroutines.internal.h.e
            kotlinx.coroutines.internal.h$a r4 = kotlinx.coroutines.internal.h.b
            long r4 = r4.b(r2, r0)
            r0 = r1
            r1 = r12
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L0
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
            kotlinx.coroutines.internal.h r0 = (kotlinx.coroutines.internal.h) r0
        L6c:
            long r1 = r0._state
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L76
            goto L81
        L76:
            kotlinx.coroutines.internal.h r0 = r0.e()
            kotlinx.coroutines.internal.h r0 = r0.a(r9, r13)
            if (r0 == 0) goto L81
            goto L6c
        L81:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.h.a(java.lang.Object):int");
    }

    public final Object d() {
        while (true) {
            long j = this._state;
            if ((1152921504606846976L & j) != 0) {
                return f7011a;
            }
            a aVar = b;
            int i = (int) ((1073741823 & j) >> 0);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if ((i2 & i3) == (i & i3)) {
                return null;
            }
            Object obj = this.f.get(i3 & i);
            if (obj == null) {
                if (this.h) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i4 = (i + 1) & 1073741823;
                if (e.compareAndSet(this, j, b.a(j, i4))) {
                    this.f.set(this.c & i, null);
                    return obj;
                }
                if (this.h) {
                    h<E> hVar = this;
                    do {
                        hVar = hVar.a(i, i4);
                    } while (hVar != null);
                    return obj;
                }
            }
        }
    }

    private final h<E> a(int i, int i2) {
        long j;
        int i3;
        do {
            j = this._state;
            a aVar = b;
            i3 = (int) ((1073741823 & j) >> 0);
            if (kotlinx.coroutines.n.a()) {
                if (!(i3 == i)) {
                    throw new AssertionError();
                }
            }
            if ((1152921504606846976L & j) != 0) {
                return e();
            }
        } while (!e.compareAndSet(this, j, b.a(j, i2)));
        this.f.set(this.c & i3, null);
        return null;
    }

    private final long f() {
        long j;
        long j2;
        do {
            j = this._state;
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!e.compareAndSet(this, j, j2));
        return j2;
    }

    private final h<E> a(long j) {
        while (true) {
            h<E> hVar = (h) this._next;
            if (hVar != null) {
                return hVar;
            }
            d.compareAndSet(this, null, b(j));
        }
    }
}
