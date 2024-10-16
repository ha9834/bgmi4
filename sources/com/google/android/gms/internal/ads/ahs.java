package com.google.android.gms.internal.ads;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ahs {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f1883a = Logger.getLogger(ahs.class.getName());
    private static final Unsafe b = c();
    private static final Class<?> c = aen.b();
    private static final boolean d = d(Long.TYPE);
    private static final boolean e = d(Integer.TYPE);
    private static final d f;
    private static final boolean g;
    private static final boolean h;
    private static final long i;
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
    private static final boolean w;

    private ahs() {
    }

    /* loaded from: classes2.dex */
    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final byte a(Object obj, long j) {
            if (ahs.w) {
                return ahs.k(obj, j);
            }
            return ahs.l(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, byte b) {
            if (ahs.w) {
                ahs.c(obj, j, b);
            } else {
                ahs.d(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final boolean b(Object obj, long j) {
            if (ahs.w) {
                return ahs.m(obj, j);
            }
            return ahs.n(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, boolean z) {
            if (ahs.w) {
                ahs.d(obj, j, z);
            } else {
                ahs.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    /* loaded from: classes2.dex */
    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(long j, byte b) {
            this.f1884a.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final byte a(Object obj, long j) {
            return this.f1884a.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, byte b) {
            this.f1884a.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final boolean b(Object obj, long j) {
            return this.f1884a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, boolean z) {
            this.f1884a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final float c(Object obj, long j) {
            return this.f1884a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, float f) {
            this.f1884a.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final double d(Object obj, long j) {
            return this.f1884a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, double d) {
            this.f1884a.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            this.f1884a.copyMemory(bArr, ahs.i + j, (Object) null, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f1884a;

        d(Unsafe unsafe) {
            this.f1884a = unsafe;
        }

        public abstract byte a(Object obj, long j);

        public abstract void a(long j, byte b);

        public abstract void a(Object obj, long j, byte b);

        public abstract void a(Object obj, long j, double d);

        public abstract void a(Object obj, long j, float f);

        public abstract void a(Object obj, long j, boolean z);

        public abstract void a(byte[] bArr, long j, long j2, long j3);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        public final int e(Object obj, long j) {
            return this.f1884a.getInt(obj, j);
        }

        public final void a(Object obj, long j, int i) {
            this.f1884a.putInt(obj, j, i);
        }

        public final long f(Object obj, long j) {
            return this.f1884a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.f1884a.putLong(obj, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return g;
    }

    /* loaded from: classes2.dex */
    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(long j, byte b) {
            Memory.pokeByte((int) (j & (-1)), b);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final byte a(Object obj, long j) {
            if (ahs.w) {
                return ahs.k(obj, j);
            }
            return ahs.l(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, byte b) {
            if (ahs.w) {
                ahs.c(obj, j, b);
            } else {
                ahs.d(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final boolean b(Object obj, long j) {
            if (ahs.w) {
                return ahs.m(obj, j);
            }
            return ahs.n(obj, j);
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, boolean z) {
            if (ahs.w) {
                ahs.d(obj, j, z);
            } else {
                ahs.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.ads.ahs.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & (-1)), bArr, (int) j, (int) j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Class<T> cls) {
        try {
            return (T) b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int b(Class<?> cls) {
        if (h) {
            return f.f1884a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int c(Class<?> cls) {
        if (h) {
            return f.f1884a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Object obj, long j2) {
        return f.e(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, int i2) {
        f.a(obj, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(Object obj, long j2) {
        return f.f(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, long j3) {
        f.a(obj, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Object obj, long j2) {
        return f.b(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, boolean z) {
        f.a(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(Object obj, long j2) {
        return f.c(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, float f2) {
        f.a(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double e(Object obj, long j2) {
        return f.d(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, double d2) {
        f.a(obj, j2, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object f(Object obj, long j2) {
        return f.f1884a.getObject(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, Object obj2) {
        f.f1884a.putObject(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j2) {
        return f.a(bArr, i + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j2, byte b2) {
        f.a((Object) bArr, i + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j2, long j3, long j4) {
        f.a(bArr, j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j2, byte b2) {
        f.a(j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(ByteBuffer byteBuffer) {
        return f.f(byteBuffer, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new ahu());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean f() {
        Unsafe unsafe = b;
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
            if (aen.a()) {
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
            Logger logger = f1883a;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean g() {
        Unsafe unsafe = b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", Field.class);
            cls.getMethod("getLong", Object.class, Long.TYPE);
            if (h() == null) {
                return false;
            }
            if (aen.a()) {
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
            Logger logger = f1883a;
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
        if (!aen.a()) {
            return false;
        }
        try {
            Class<?> cls2 = c;
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

    private static Field h() {
        Field a2;
        if (aen.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
            return a2;
        }
        Field a3 = a((Class<?>) Buffer.class, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        if (a3 == null || a3.getType() != Long.TYPE) {
            return null;
        }
        return a3;
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
        d dVar;
        d dVar2 = null;
        if (b != null) {
            if (aen.a()) {
                if (d) {
                    dVar2 = new b(b);
                } else if (e) {
                    dVar2 = new a(b);
                }
            } else {
                dVar2 = new c(b);
            }
        }
        f = dVar2;
        g = g();
        h = f();
        i = b(byte[].class);
        j = b(boolean[].class);
        k = c(boolean[].class);
        l = b(int[].class);
        m = c(int[].class);
        n = b(long[].class);
        o = c(long[].class);
        p = b(float[].class);
        q = c(float[].class);
        r = b(double[].class);
        s = c(double[].class);
        t = b(Object[].class);
        u = c(Object[].class);
        Field h2 = h();
        v = (h2 == null || (dVar = f) == null) ? -1L : dVar.f1884a.objectFieldOffset(h2);
        w = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
