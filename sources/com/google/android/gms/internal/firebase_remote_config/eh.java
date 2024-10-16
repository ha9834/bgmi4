package com.google.android.gms.internal.firebase_remote_config;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class eh {

    /* renamed from: a, reason: collision with root package name */
    static final boolean f4090a;
    private static final Logger b = Logger.getLogger(eh.class.getName());
    private static final Unsafe c = c();
    private static final Class<?> d = bb.b();
    private static final boolean e = d(Long.TYPE);
    private static final boolean f = d(Integer.TYPE);
    private static final c g;
    private static final boolean h;
    private static final boolean i;
    private static final long j;
    private static final long k;
    private static final long l;
    private static final long m;
    private static final long n;
    private static final long o;
    private static final long p;
    private static final long q;
    private static final long r;
    private static final long s;
    private static final long t;
    private static final long u;
    private static final long v;
    private static final long w;
    private static final int x;

    private eh() {
    }

    /* loaded from: classes2.dex */
    static final class a extends c {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final byte a(Object obj, long j) {
            if (eh.f4090a) {
                return eh.k(obj, j);
            }
            return eh.l(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, byte b) {
            if (eh.f4090a) {
                eh.c(obj, j, b);
            } else {
                eh.d(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final boolean b(Object obj, long j) {
            if (eh.f4090a) {
                return eh.m(obj, j);
            }
            return eh.n(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, boolean z) {
            if (eh.f4090a) {
                eh.d(obj, j, z);
            } else {
                eh.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* loaded from: classes2.dex */
    static final class b extends c {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final byte a(Object obj, long j) {
            if (eh.f4090a) {
                return eh.k(obj, j);
            }
            return eh.l(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, byte b) {
            if (eh.f4090a) {
                eh.c(obj, j, b);
            } else {
                eh.d(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final boolean b(Object obj, long j) {
            if (eh.f4090a) {
                return eh.m(obj, j);
            }
            return eh.n(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, boolean z) {
            if (eh.f4090a) {
                eh.d(obj, j, z);
            } else {
                eh.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* loaded from: classes2.dex */
    static final class d extends c {
        d(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final byte a(Object obj, long j) {
            return this.f4091a.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, byte b) {
            this.f4091a.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final boolean b(Object obj, long j) {
            return this.f4091a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, boolean z) {
            this.f4091a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final float c(Object obj, long j) {
            return this.f4091a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, float f) {
            this.f4091a.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final double d(Object obj, long j) {
            return this.f4091a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.eh.c
        public final void a(Object obj, long j, double d) {
            this.f4091a.putDouble(obj, j, d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class c {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f4091a;

        c(Unsafe unsafe) {
            this.f4091a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void a(Object obj, long j, byte b);

        public abstract void a(Object obj, long j, double d);

        public abstract void a(Object obj, long j, float f);

        public abstract void a(Object obj, long j, boolean z);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        public final int e(Object obj, long j) {
            return this.f4091a.getInt(obj, j);
        }

        public final void a(Object obj, long j, int i) {
            this.f4091a.putInt(obj, j, i);
        }

        public final long f(Object obj, long j) {
            return this.f4091a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.f4091a.putLong(obj, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Class<T> cls) {
        try {
            return (T) c.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int b(Class<?> cls) {
        if (i) {
            return g.f4091a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int c(Class<?> cls) {
        if (i) {
            return g.f4091a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Object obj, long j2) {
        return g.e(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, int i2) {
        g.a(obj, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(Object obj, long j2) {
        return g.f(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, long j3) {
        g.a(obj, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Object obj, long j2) {
        return g.b(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, boolean z) {
        g.a(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(Object obj, long j2) {
        return g.c(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, float f2) {
        g.a(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double e(Object obj, long j2) {
        return g.d(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, double d2) {
        g.a(obj, j2, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object f(Object obj, long j2) {
        return g.f4091a.getObject(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, Object obj2) {
        g.f4091a.putObject(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j2) {
        return g.a(bArr, j + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j2, byte b2) {
        g.a((Object) bArr, j + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new eg());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean d() {
        Unsafe unsafe = c;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("arrayBaseOffset", Class.class);
            cls.getMethod("arrayIndexScale", Class.class);
            cls.getMethod("getInt", Object.class, Long.TYPE);
            cls.getMethod("putInt", Object.class, Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            cls.getMethod("putLong", Object.class, Long.TYPE, Long.TYPE);
            cls.getMethod("getObject", Object.class, Long.TYPE);
            cls.getMethod("putObject", Object.class, Long.TYPE, Object.class);
            if (bb.a()) {
                return true;
            }
            cls.getMethod("getByte", Object.class, Long.TYPE);
            cls.getMethod("putByte", Object.class, Long.TYPE, Byte.TYPE);
            cls.getMethod("getBoolean", Object.class, Long.TYPE);
            cls.getMethod("putBoolean", Object.class, Long.TYPE, Boolean.TYPE);
            cls.getMethod("getFloat", Object.class, Long.TYPE);
            cls.getMethod("putFloat", Object.class, Long.TYPE, Float.TYPE);
            cls.getMethod("getDouble", Object.class, Long.TYPE);
            cls.getMethod("putDouble", Object.class, Long.TYPE, Double.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = b;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean e() {
        Unsafe unsafe = c;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (f() == null) {
                return false;
            }
            if (bb.a()) {
                return true;
            }
            cls.getMethod("getByte", Long.TYPE);
            cls.getMethod("putByte", Long.TYPE, Byte.TYPE);
            cls.getMethod("getInt", Long.TYPE);
            cls.getMethod("putInt", Long.TYPE, Integer.TYPE);
            cls.getMethod("getLong", Long.TYPE);
            cls.getMethod("putLong", Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Long.TYPE, Long.TYPE, Long.TYPE);
            cls.getMethod("copyMemory", Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE);
            return true;
        } catch (Throwable th) {
            Logger logger = b;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean d(Class<?> cls) {
        if (!bb.a()) {
            return false;
        }
        try {
            Class<?> cls2 = d;
            cls2.getMethod("peekLong", cls, Boolean.TYPE);
            cls2.getMethod("pokeLong", cls, Long.TYPE, Boolean.TYPE);
            cls2.getMethod("pokeInt", cls, Integer.TYPE, Boolean.TYPE);
            cls2.getMethod("peekInt", cls, Boolean.TYPE);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            cls2.getMethod("peekByteArray", cls, byte[].class, Integer.TYPE, Integer.TYPE);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field f() {
        Field a2;
        if (bb.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return a2;
        }
        Field a3 = a((Class<?>) Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int numberOfTrailingZeros;
        if (i2 < 0 || i3 < 0 || i4 < 0 || i2 + i4 > bArr.length || i3 + i4 > bArr2.length) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        if (i) {
            for (int i6 = (x + i2) & 7; i5 < i4 && (i6 & 7) != 0; i6++) {
                if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                    return i5;
                }
                i5++;
            }
            int i7 = ((i4 - i5) & (-8)) + i5;
            while (i5 < i7) {
                long j2 = i5;
                long b2 = b(bArr, j + i2 + j2);
                long b3 = b(bArr2, j + i3 + j2);
                if (b2 != b3) {
                    if (f4090a) {
                        numberOfTrailingZeros = Long.numberOfLeadingZeros(b2 ^ b3);
                    } else {
                        numberOfTrailingZeros = Long.numberOfTrailingZeros(b2 ^ b3);
                    }
                    return i5 + (numberOfTrailingZeros >> 3);
                }
                i5 += 8;
            }
        }
        while (i5 < i4) {
            if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private static Field a(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte k(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) (((j2 ^ (-1)) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte l(Object obj, long j2) {
        return (byte) (a(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((((int) j2) ^ (-1)) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        a(obj, j3, ((255 & b2) << i2) | (a(obj, j3) & ((255 << i2) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(Object obj, long j2) {
        return l(obj, j2) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j2, boolean z) {
        c(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static {
        c cVar;
        c cVar2 = null;
        if (c != null) {
            if (bb.a()) {
                if (e) {
                    cVar2 = new a(c);
                } else if (f) {
                    cVar2 = new b(c);
                }
            } else {
                cVar2 = new d(c);
            }
        }
        g = cVar2;
        h = e();
        i = d();
        j = b(byte[].class);
        k = b(boolean[].class);
        l = c(boolean[].class);
        m = b(int[].class);
        n = c(int[].class);
        o = b(long[].class);
        p = c(long[].class);
        q = b(float[].class);
        r = c(float[].class);
        s = b(double[].class);
        t = c(double[].class);
        u = b(Object[].class);
        v = c(Object[].class);
        Field f2 = f();
        w = (f2 == null || (cVar = g) == null) ? -1L : cVar.f4091a.objectFieldOffset(f2);
        x = (int) (j & 7);
        f4090a = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
