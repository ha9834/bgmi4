package com.google.android.gms.internal.gtm;

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
public final class dv {

    /* renamed from: a, reason: collision with root package name */
    static final long f4354a;
    static final boolean b;
    private static final Logger c = Logger.getLogger(dv.class.getName());
    private static final Unsafe d = c();
    private static final Class<?> e = ay.b();
    private static final boolean f = d(Long.TYPE);
    private static final boolean g = d(Integer.TYPE);
    private static final d h;
    private static final boolean i;
    private static final boolean j;
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

    private dv() {
    }

    /* loaded from: classes2.dex */
    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(long j, byte b) {
            Memory.pokeByte(j, b);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final byte a(Object obj, long j) {
            if (dv.b) {
                return dv.k(obj, j);
            }
            return dv.l(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, byte b) {
            if (dv.b) {
                dv.c(obj, j, b);
            } else {
                dv.d(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final boolean b(Object obj, long j) {
            if (dv.b) {
                return dv.m(obj, j);
            }
            return dv.n(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, boolean z) {
            if (dv.b) {
                dv.d(obj, j, z);
            } else {
                dv.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray(j2, bArr, (int) j, (int) j3);
        }
    }

    /* loaded from: classes2.dex */
    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(long j, byte b) {
            this.f4355a.putByte(j, b);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final byte a(Object obj, long j) {
            return this.f4355a.getByte(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, byte b) {
            this.f4355a.putByte(obj, j, b);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final boolean b(Object obj, long j) {
            return this.f4355a.getBoolean(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, boolean z) {
            this.f4355a.putBoolean(obj, j, z);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final float c(Object obj, long j) {
            return this.f4355a.getFloat(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, float f) {
            this.f4355a.putFloat(obj, j, f);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final double d(Object obj, long j) {
            return this.f4355a.getDouble(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, double d) {
            this.f4355a.putDouble(obj, j, d);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            this.f4355a.copyMemory(bArr, dv.f4354a + j, (Object) null, j2, j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f4355a;

        d(Unsafe unsafe) {
            this.f4355a = unsafe;
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
            return this.f4355a.getInt(obj, j);
        }

        public final void a(Object obj, long j, int i) {
            this.f4355a.putInt(obj, j, i);
        }

        public final long f(Object obj, long j) {
            return this.f4355a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.f4355a.putLong(obj, j, j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return i;
    }

    /* loaded from: classes2.dex */
    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(long j, byte b) {
            Memory.pokeByte((int) (j & (-1)), b);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final byte a(Object obj, long j) {
            if (dv.b) {
                return dv.k(obj, j);
            }
            return dv.l(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, byte b) {
            if (dv.b) {
                dv.c(obj, j, b);
            } else {
                dv.d(obj, j, b);
            }
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final boolean b(Object obj, long j) {
            if (dv.b) {
                return dv.m(obj, j);
            }
            return dv.n(obj, j);
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, boolean z) {
            if (dv.b) {
                dv.d(obj, j, z);
            } else {
                dv.e(obj, j, z);
            }
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(e(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, float f) {
            a(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(f(obj, j));
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(Object obj, long j, double d) {
            a(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.google.android.gms.internal.gtm.dv.d
        public final void a(byte[] bArr, long j, long j2, long j3) {
            Memory.pokeByteArray((int) (j2 & (-1)), bArr, (int) j, (int) j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Class<T> cls) {
        try {
            return (T) d.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private static int b(Class<?> cls) {
        if (j) {
            return h.f4355a.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int c(Class<?> cls) {
        if (j) {
            return h.f4355a.arrayIndexScale(cls);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Object obj, long j2) {
        return h.e(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, int i2) {
        h.a(obj, j2, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long b(Object obj, long j2) {
        return h.f(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, long j3) {
        h.a(obj, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(Object obj, long j2) {
        return h.b(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, boolean z) {
        h.a(obj, j2, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float d(Object obj, long j2) {
        return h.c(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, float f2) {
        h.a(obj, j2, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double e(Object obj, long j2) {
        return h.d(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, double d2) {
        h.a(obj, j2, d2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object f(Object obj, long j2) {
        return h.f4355a.getObject(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, Object obj2) {
        h.f4355a.putObject(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j2) {
        return h.a(bArr, f4354a + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j2, byte b2) {
        h.a((Object) bArr, f4354a + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j2, long j3, long j4) {
        h.a(bArr, j2, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j2, byte b2) {
        h.a(j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(ByteBuffer byteBuffer) {
        return h.f(byteBuffer, w);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new dw());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean d() {
        Unsafe unsafe = d;
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
            if (ay.a()) {
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
            Logger logger = c;
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
        Unsafe unsafe = d;
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
            if (ay.a()) {
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
            Logger logger = c;
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
        if (!ay.a()) {
            return false;
        }
        try {
            Class<?> cls2 = e;
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
        if (ay.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
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
        if (j) {
            for (int i6 = (x + i2) & 7; i5 < i4 && (i6 & 7) != 0; i6++) {
                if (bArr[i2 + i5] != bArr2[i3 + i5]) {
                    return i5;
                }
                i5++;
            }
            int i7 = ((i4 - i5) & (-8)) + i5;
            while (i5 < i7) {
                long j2 = i5;
                long b2 = b(bArr, f4354a + i2 + j2);
                long b3 = b(bArr2, f4354a + i3 + j2);
                if (b2 != b3) {
                    if (b) {
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
        d dVar;
        d dVar2 = null;
        if (d != null) {
            if (ay.a()) {
                if (f) {
                    dVar2 = new b(d);
                } else if (g) {
                    dVar2 = new a(d);
                }
            } else {
                dVar2 = new c(d);
            }
        }
        h = dVar2;
        i = e();
        j = d();
        f4354a = b(byte[].class);
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
        w = (f2 == null || (dVar = h) == null) ? -1L : dVar.f4355a.objectFieldOffset(f2);
        x = (int) (f4354a & 7);
        b = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }
}
