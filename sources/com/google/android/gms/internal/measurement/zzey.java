package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.internal.measurement.zzey.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzey<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdf<MessageType, BuilderType> {
    private static Map<Object, zzey<?, ?>> zzaib = new ConcurrentHashMap();
    protected zzhs zzahz = zzhs.zzwq();
    private int zzaia = -1;

    /* loaded from: classes2.dex */
    public enum zzd {
        public static final int zzaid = 1;
        public static final int zzaie = 2;
        public static final int zzaif = 3;
        public static final int zzaig = 4;
        public static final int zzaih = 5;
        public static final int zzaii = 6;
        public static final int zzaij = 7;

        /* renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ int[] f4561a = {zzaid, zzaie, zzaif, zzaig, zzaih, zzaii, zzaij};
        public static final int zzail = 1;
        public static final int zzaim = 2;
        private static final /* synthetic */ int[] b = {zzail, zzaim};
        public static final int zzaio = 1;
        public static final int zzaip = 2;
        private static final /* synthetic */ int[] c = {zzaio, zzaip};

        public static int[] zzur() {
            return (int[]) f4561a.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static class zze<ContainingType extends zzgi, Type> extends zzek<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(int i, Object obj, Object obj2);

    /* loaded from: classes2.dex */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzey<MessageType, BuilderType> implements zzgk {
        protected cb<Object> zzaic = cb.a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final cb<Object> a() {
            if (this.zzaic.c()) {
                this.zzaic = (cb) this.zzaic.clone();
            }
            return this.zzaic;
        }
    }

    /* loaded from: classes2.dex */
    public static class zzc<T extends zzey<T, ?>> extends zzdg<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f4560a;

        public zzc(T t) {
            this.f4560a = t;
        }

        @Override // com.google.android.gms.internal.measurement.zzgr
        public final /* synthetic */ Object zzc(zzeb zzebVar, zzel zzelVar) throws zzfi {
            return zzey.a(this.f4560a, zzebVar, zzelVar);
        }
    }

    public String toString() {
        return da.a(this, super.toString());
    }

    public int hashCode() {
        if (this.zzact != 0) {
            return this.zzact;
        }
        this.zzact = dh.a().a((dh) this).a(this);
        return this.zzact;
    }

    /* loaded from: classes2.dex */
    public static abstract class zza<MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdh<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        protected MessageType f4559a;
        private final MessageType b;
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.b = messagetype;
            this.f4559a = (MessageType) messagetype.a(zzd.zzaig, null, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a() {
            if (this.c) {
                MessageType messagetype = (MessageType) this.f4559a.a(zzd.zzaig, null, null);
                a(messagetype, this.f4559a);
                this.f4559a = messagetype;
                this.c = false;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzgk
        public final boolean isInitialized() {
            return zzey.a(this.f4559a, false);
        }

        @Override // com.google.android.gms.internal.measurement.zzgh
        /* renamed from: zzud, reason: merged with bridge method [inline-methods] */
        public MessageType zzuf() {
            if (this.c) {
                return this.f4559a;
            }
            this.f4559a.c();
            this.c = true;
            return this.f4559a;
        }

        @Override // com.google.android.gms.internal.measurement.zzgh
        /* renamed from: zzue, reason: merged with bridge method [inline-methods] */
        public final MessageType zzug() {
            MessageType messagetype = (MessageType) zzuf();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzhq(messagetype);
        }

        @Override // com.google.android.gms.internal.measurement.zzdh
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final BuilderType a(MessageType messagetype) {
            a();
            a(this.f4559a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            dh.a().a((dh) messagetype).b(messagetype, messagetype2);
        }

        private final BuilderType a(byte[] bArr, int i, int i2, zzel zzelVar) throws zzfi {
            a();
            try {
                dh.a().a((dh) this.f4559a).a(this.f4559a, bArr, 0, i2 + 0, new bh(zzelVar));
                return this;
            } catch (zzfi e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzfi.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.measurement.zzdh
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BuilderType zza(zzeb zzebVar, zzel zzelVar) throws IOException {
            a();
            try {
                dh.a().a((dh) this.f4559a).a(this.f4559a, bs.a(zzebVar), zzelVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.measurement.zzdh
        public final /* synthetic */ zzdh zza(byte[] bArr, int i, int i2, zzel zzelVar) throws zzfi {
            return a(bArr, 0, i2, zzelVar);
        }

        @Override // com.google.android.gms.internal.measurement.zzdh
        /* renamed from: zzru */
        public final /* synthetic */ zzdh clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.measurement.zzgk
        public final /* synthetic */ zzgi zzuh() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.measurement.zzdh
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.b.a(zzd.zzaih, null, null);
            zzaVar.a((zza) zzuf());
            return zzaVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzey) a(zzd.zzaii, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return dh.a().a((dh) this).a(this, (zzey<MessageType, BuilderType>) obj);
        }
        return false;
    }

    protected final void c() {
        dh.a().a((dh) this).c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <MessageType extends zzey<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType d() {
        return (BuilderType) a(zzd.zzaih, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgk
    public final boolean isInitialized() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzuj() {
        BuilderType buildertype = (BuilderType) a(zzd.zzaih, (Object) null, (Object) null);
        buildertype.a(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.measurement.zzdf
    final int b() {
        return this.zzaia;
    }

    @Override // com.google.android.gms.internal.measurement.zzdf
    final void a(int i) {
        this.zzaia = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzgi
    public final void zzb(zzee zzeeVar) throws IOException {
        dh.a().a((Class) getClass()).a((dl) this, (ep) bx.a(zzeeVar));
    }

    @Override // com.google.android.gms.internal.measurement.zzgi
    public final int zzuk() {
        if (this.zzaia == -1) {
            this.zzaia = dh.a().a((dh) this).b(this);
        }
        return this.zzaia;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzey<?, ?>> T a(Class<T> cls) {
        zzey<?, ?> zzeyVar = zzaib.get(cls);
        if (zzeyVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzeyVar = zzaib.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzeyVar == null) {
            zzeyVar = (T) ((zzey) eg.a(cls)).a(zzd.zzaii, (Object) null, (Object) null);
            if (zzeyVar == null) {
                throw new IllegalStateException();
            }
            zzaib.put(cls, zzeyVar);
        }
        return (T) zzeyVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzey<?, ?>> void a(Class<T> cls, T t) {
        zzaib.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(zzgi zzgiVar, String str, Object[] objArr) {
        return new dj(zzgiVar, str, objArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    protected static final <T extends zzey<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zzd.zzaid, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d = dh.a().a((dh) t).d(t);
        if (z) {
            t.a(zzd.zzaie, d ? t : null, null);
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzfd e() {
        return ci.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzfg f() {
        return cr.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzfg a(zzfg zzfgVar) {
        int size = zzfgVar.size();
        return zzfgVar.zzap(size == 0 ? 10 : size << 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzff<E> g() {
        return dk.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzff<E> a(zzff<E> zzffVar) {
        int size = zzffVar.size();
        return zzffVar.zzap(size == 0 ? 10 : size << 1);
    }

    static <T extends zzey<T, ?>> T a(T t, zzeb zzebVar, zzel zzelVar) throws zzfi {
        T t2 = (T) t.a(zzd.zzaig, null, null);
        try {
            dh.a().a((dh) t2).a(t2, bs.a(zzebVar), zzelVar);
            t2.c();
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzfi) {
                throw ((zzfi) e.getCause());
            }
            throw new zzfi(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzfi) {
                throw ((zzfi) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzey<T, ?>> T a(T t, byte[] bArr, int i, int i2, zzel zzelVar) throws zzfi {
        T t2 = (T) t.a(zzd.zzaig, null, null);
        try {
            dh.a().a((dh) t2).a(t2, bArr, 0, i2, new bh(zzelVar));
            t2.c();
            if (t2.zzact == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzfi) {
                throw ((zzfi) e.getCause());
            }
            throw new zzfi(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzfi.a().zzg(t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzey<T, ?>> T a(T t, byte[] bArr, zzel zzelVar) throws zzfi {
        T t2 = (T) a(t, bArr, 0, bArr.length, zzelVar);
        if (t2 == null || t2.isInitialized()) {
            return t2;
        }
        throw new zzfi(new zzhq(t2).getMessage()).zzg(t2);
    }

    @Override // com.google.android.gms.internal.measurement.zzgi
    public final /* synthetic */ zzgh zzuo() {
        zza zzaVar = (zza) a(zzd.zzaih, (Object) null, (Object) null);
        zzaVar.a((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzgi
    public final /* synthetic */ zzgh zzup() {
        return (zza) a(zzd.zzaih, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.measurement.zzgk
    public final /* synthetic */ zzgi zzuh() {
        return (zzey) a(zzd.zzaii, (Object) null, (Object) null);
    }
}
