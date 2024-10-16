package com.uqm.crashsight.protobuf;

import com.facebook.appevents.integrity.IntegrityManager;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: classes3.dex */
final class aw {

    /* renamed from: a, reason: collision with root package name */
    static final long f6804a;
    static final boolean b;
    private static final Logger c = Logger.getLogger(aw.class.getName());
    private static final Unsafe d = c();
    private static final Class<?> e = com.uqm.crashsight.protobuf.b.b();
    private static final boolean f = b((Class<?>) Long.TYPE);
    private static final boolean g = b((Class<?>) Integer.TYPE);
    private static final d h;
    private static final boolean i;
    private static final boolean j;
    private static final long k;

    static /* synthetic */ void b(Object obj, long j2, boolean z) {
        c(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static /* synthetic */ void c(Object obj, long j2, boolean z) {
        d(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    static /* synthetic */ boolean i(Object obj, long j2) {
        return k(obj, j2) != 0;
    }

    static /* synthetic */ boolean j(Object obj, long j2) {
        return l(obj, j2) != 0;
    }

    static {
        d dVar;
        d dVar2 = null;
        if (d != null) {
            if (!com.uqm.crashsight.protobuf.b.a()) {
                dVar2 = new c(d);
            } else if (f) {
                dVar2 = new b(d);
            } else if (g) {
                dVar2 = new a(d);
            }
        }
        h = dVar2;
        i = e();
        j = d();
        f6804a = j ? h.a(byte[].class) : -1;
        if (j) {
            h.a(boolean[].class);
        }
        if (j) {
            h.b(boolean[].class);
        }
        if (j) {
            h.a(int[].class);
        }
        if (j) {
            h.b(int[].class);
        }
        if (j) {
            h.a(long[].class);
        }
        if (j) {
            h.b(long[].class);
        }
        if (j) {
            h.a(float[].class);
        }
        if (j) {
            h.b(float[].class);
        }
        if (j) {
            h.a(double[].class);
        }
        if (j) {
            h.b(double[].class);
        }
        if (j) {
            h.a(Object[].class);
        }
        if (j) {
            h.b(Object[].class);
        }
        Field f2 = f();
        k = (f2 == null || (dVar = h) == null) ? -1L : dVar.b(f2);
        long j2 = f6804a;
        b = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private aw() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b() {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(Class<T> cls) {
        try {
            return (T) d.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(Field field) {
        return h.b(field);
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
        return h.g(obj, j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, long j2, Object obj2) {
        h.a(obj, j2, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(byte[] bArr, long j2) {
        return h.a(bArr, f6804a + j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j2, byte b2) {
        h.a((Object) bArr, f6804a + j2, b2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(long j2, byte[] bArr, long j3, long j4) {
        h.a(j2, bArr, j3, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte a(long j2) {
        return h.a(j2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(ByteBuffer byteBuffer) {
        return h.f(byteBuffer, k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object b(Field field) {
        return h.a(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe c() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: com.uqm.crashsight.protobuf.aw.1
                @Override // java.security.PrivilegedExceptionAction
                public final /* synthetic */ Unsafe run() throws Exception {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
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
            if (com.uqm.crashsight.protobuf.b.a()) {
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
            c.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
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
            if (com.uqm.crashsight.protobuf.b.a()) {
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
            c.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    private static boolean b(Class<?> cls) {
        if (!com.uqm.crashsight.protobuf.b.a()) {
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
        if (com.uqm.crashsight.protobuf.b.a() && (a2 = a((Class<?>) Buffer.class, "effectiveDirectAddress")) != null) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        Unsafe f6805a;

        public abstract byte a(long j);

        public abstract byte a(Object obj, long j);

        public abstract Object a(Field field);

        public abstract void a(long j, byte[] bArr, long j2, long j3);

        public abstract void a(Object obj, long j, byte b);

        public abstract void a(Object obj, long j, double d);

        public abstract void a(Object obj, long j, float f);

        public abstract void a(Object obj, long j, boolean z);

        public abstract boolean b(Object obj, long j);

        public abstract float c(Object obj, long j);

        public abstract double d(Object obj, long j);

        d(Unsafe unsafe) {
            this.f6805a = unsafe;
        }

        public final long b(Field field) {
            return this.f6805a.objectFieldOffset(field);
        }

        public final int e(Object obj, long j) {
            return this.f6805a.getInt(obj, j);
        }

        public final void a(Object obj, long j, int i) {
            this.f6805a.putInt(obj, j, i);
        }

        public final long f(Object obj, long j) {
            return this.f6805a.getLong(obj, j);
        }

        public final void a(Object obj, long j, long j2) {
            this.f6805a.putLong(obj, j, j2);
        }

        public final Object g(Object obj, long j) {
            return this.f6805a.getObject(obj, j);
        }

        public final void a(Object obj, long j, Object obj2) {
            this.f6805a.putObject(obj, j, obj2);
        }

        public final int a(Class<?> cls) {
            return this.f6805a.arrayBaseOffset(cls);
        }

        public final int b(Class<?> cls) {
            return this.f6805a.arrayIndexScale(cls);
        }
    }

    /* loaded from: classes3.dex */
    static final class c extends d {
        c(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final byte a(long j) {
            return this.f6805a.getByte(j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final byte a(Object obj, long j) {
            return this.f6805a.getByte(obj, j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, byte b) {
            this.f6805a.putByte(obj, j, b);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final boolean b(Object obj, long j) {
            return this.f6805a.getBoolean(obj, j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, boolean z) {
            this.f6805a.putBoolean(obj, j, z);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final float c(Object obj, long j) {
            return this.f6805a.getFloat(obj, j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, float f) {
            this.f6805a.putFloat(obj, j, f);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final double d(Object obj, long j) {
            return this.f6805a.getDouble(obj, j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, double d) {
            this.f6805a.putDouble(obj, j, d);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(long j, byte[] bArr, long j2, long j3) {
            this.f6805a.copyMemory((Object) null, j, bArr, aw.f6804a + j2, j3);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final Object a(Field field) {
            return this.f6805a.getObject(this.f6805a.staticFieldBase(field), this.f6805a.staticFieldOffset(field));
        }
    }

    /* loaded from: classes3.dex */
    static final class b extends d {
        b(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final byte a(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final byte a(Object obj, long j) {
            return aw.b ? aw.k(obj, j) : aw.l(obj, j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, byte b) {
            if (aw.b) {
                aw.c(obj, j, b);
            } else {
                aw.d(obj, j, b);
            }
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final boolean b(Object obj, long j) {
            if (aw.b) {
                return aw.i(obj, j);
            }
            return aw.j(obj, j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, boolean z) {
            if (aw.b) {
                aw.b(obj, j, z);
            } else {
                aw.c(obj, j, z);
            }
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(this.f6805a.getInt(obj, j));
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, float f) {
            this.f6805a.putInt(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(this.f6805a.getLong(obj, j));
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, double d) {
            this.f6805a.putLong(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final Object a(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class a extends d {
        a(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final byte a(long j) {
            throw new UnsupportedOperationException();
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final byte a(Object obj, long j) {
            return aw.b ? aw.k(obj, j) : aw.l(obj, j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, byte b) {
            if (aw.b) {
                aw.c(obj, j, b);
            } else {
                aw.d(obj, j, b);
            }
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final boolean b(Object obj, long j) {
            if (aw.b) {
                return aw.i(obj, j);
            }
            return aw.j(obj, j);
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, boolean z) {
            if (aw.b) {
                aw.b(obj, j, z);
            } else {
                aw.c(obj, j, z);
            }
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final float c(Object obj, long j) {
            return Float.intBitsToFloat(this.f6805a.getInt(obj, j));
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, float f) {
            this.f6805a.putInt(obj, j, Float.floatToIntBits(f));
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final double d(Object obj, long j) {
            return Double.longBitsToDouble(this.f6805a.getLong(obj, j));
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(Object obj, long j, double d) {
            this.f6805a.putLong(obj, j, Double.doubleToLongBits(d));
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final void a(long j, byte[] bArr, long j2, long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.uqm.crashsight.protobuf.aw.d
        public final Object a(Field field) {
            try {
                return field.get(null);
            } catch (IllegalAccessException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte k(Object obj, long j2) {
        return (byte) (h.e(obj, (-4) & j2) >>> ((int) (((j2 ^ (-1)) & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte l(Object obj, long j2) {
        return (byte) (h.e(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((((int) j2) ^ (-1)) & 3) << 3;
        h.a(obj, j3, ((255 & b2) << i2) | (h.e(obj, j3) & ((255 << i2) ^ (-1))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void d(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        h.a(obj, j3, ((255 & b2) << i2) | (h.e(obj, j3) & ((255 << i2) ^ (-1))));
    }
}
