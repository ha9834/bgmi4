package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import com.google.android.gms.internal.ads.zzdob.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzdob<MessageType extends zzdob<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdmi<MessageType, BuilderType> {
    private static Map<Object, zzdob<?, ?>> zzhhf = new ConcurrentHashMap();
    protected zzdqu zzhhd = zzdqu.zzazz();
    private int zzhhe = -1;

    /* loaded from: classes2.dex */
    public static class zzb<T extends zzdob<T, ?>> extends zzdmk<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f3591a;

        public zzb(T t) {
            this.f3591a = t;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzdob<MessageType, BuilderType> implements zzdpm {
        protected afk<Object> zzhhj = afk.a();
    }

    /* loaded from: classes2.dex */
    public static class zzd<ContainingType extends zzdpk, Type> extends zzdnm<ContainingType, Type> {
    }

    /* loaded from: classes2.dex */
    public enum zze {
        public static final int zzhhk = 1;
        public static final int zzhhl = 2;
        public static final int zzhhm = 3;
        public static final int zzhhn = 4;
        public static final int zzhho = 5;
        public static final int zzhhp = 6;
        public static final int zzhhq = 7;

        /* renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ int[] f3592a = {zzhhk, zzhhl, zzhhm, zzhhn, zzhho, zzhhp, zzhhq};
        public static final int zzhhs = 1;
        public static final int zzhht = 2;
        private static final /* synthetic */ int[] b = {zzhhs, zzhht};
        public static final int zzhhv = 1;
        public static final int zzhhw = 2;
        private static final /* synthetic */ int[] c = {zzhhv, zzhhw};

        public static int[] zzayb() {
            return (int[]) f3592a.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(int i, Object obj, Object obj2);

    public String toString() {
        return agk.a(this, super.toString());
    }

    public int hashCode() {
        if (this.zzhcf != 0) {
            return this.zzhcf;
        }
        this.zzhcf = ags.a().a((ags) this).a(this);
        return this.zzhcf;
    }

    /* loaded from: classes2.dex */
    public static abstract class zza<MessageType extends zzdob<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdmj<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        protected MessageType f3590a;
        private final MessageType b;
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.b = messagetype;
            this.f3590a = (MessageType) messagetype.a(zze.zzhhn, null, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void a() {
            if (this.c) {
                MessageType messagetype = (MessageType) this.f3590a.a(zze.zzhhn, null, null);
                a(messagetype, this.f3590a);
                this.f3590a = messagetype;
                this.c = false;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdpm
        public final boolean isInitialized() {
            return zzdob.a(this.f3590a, false);
        }

        @Override // com.google.android.gms.internal.ads.zzdpl
        /* renamed from: zzaxx, reason: merged with bridge method [inline-methods] */
        public MessageType zzaxz() {
            if (this.c) {
                return this.f3590a;
            }
            MessageType messagetype = this.f3590a;
            ags.a().a((ags) messagetype).c(messagetype);
            this.c = true;
            return this.f3590a;
        }

        @Override // com.google.android.gms.internal.ads.zzdpl
        /* renamed from: zzaxy, reason: merged with bridge method [inline-methods] */
        public final MessageType zzaya() {
            MessageType messagetype = (MessageType) zzaxz();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.a(zze.zzhhk, null, null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = ags.a().a((ags) messagetype).d(messagetype);
                    if (booleanValue) {
                        messagetype.a(zze.zzhhl, z ? messagetype : null, null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzdqs(messagetype);
        }

        @Override // com.google.android.gms.internal.ads.zzdmj
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final BuilderType a(MessageType messagetype) {
            a();
            a(this.f3590a, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            ags.a().a((ags) messagetype).b(messagetype, messagetype2);
        }

        private final BuilderType a(byte[] bArr, int i, int i2, zzdno zzdnoVar) throws zzdok {
            a();
            try {
                ags.a().a((ags) this.f3590a).a(this.f3590a, bArr, 0, i2 + 0, new aep(zzdnoVar));
                return this;
            } catch (zzdok e) {
                throw e;
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            } catch (IndexOutOfBoundsException unused) {
                throw zzdok.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.google.android.gms.internal.ads.zzdmj
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final BuilderType zza(zzdnd zzdndVar, zzdno zzdnoVar) throws IOException {
            a();
            try {
                ags.a().a((ags) this.f3590a).a(this.f3590a, afb.a(zzdndVar), zzdnoVar);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        @Override // com.google.android.gms.internal.ads.zzdmj
        public final /* synthetic */ zzdmj zza(byte[] bArr, int i, int i2, zzdno zzdnoVar) throws zzdok {
            return a(bArr, 0, i2, zzdnoVar);
        }

        @Override // com.google.android.gms.internal.ads.zzdmj
        /* renamed from: zzavh */
        public final /* synthetic */ zzdmj clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.ads.zzdpm
        public final /* synthetic */ zzdpk zzaxv() {
            return this.b;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.ads.zzdmj
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.b.a(zze.zzhho, null, null);
            zzaVar.a((zzdob) zzaxz());
            return zzaVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzdob) a(zze.zzhhp, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return ags.a().a((ags) this).a(this, (zzdob<MessageType, BuilderType>) obj);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdpm
    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) a(zze.zzhhk, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d = ags.a().a((ags) this).d(this);
        if (booleanValue) {
            a(zze.zzhhl, d ? this : null, (Object) null);
        }
        return d;
    }

    @Override // com.google.android.gms.internal.ads.zzdmi
    final int b() {
        return this.zzhhe;
    }

    @Override // com.google.android.gms.internal.ads.zzdmi
    final void a(int i) {
        this.zzhhe = i;
    }

    @Override // com.google.android.gms.internal.ads.zzdpk
    public final void zzb(zzdni zzdniVar) throws IOException {
        ags.a().a((Class) getClass()).a((agx) this, (aib) afe.a(zzdniVar));
    }

    @Override // com.google.android.gms.internal.ads.zzdpk
    public final int zzaxj() {
        if (this.zzhhe == -1) {
            this.zzhhe = ags.a().a((ags) this).b(this);
        }
        return this.zzhhe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzdob<?, ?>> T a(Class<T> cls) {
        zzdob<?, ?> zzdobVar = zzhhf.get(cls);
        if (zzdobVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzdobVar = zzhhf.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzdobVar == null) {
            zzdobVar = (T) ((zzdob) ahs.a(cls)).a(zze.zzhhp, (Object) null, (Object) null);
            if (zzdobVar == null) {
                throw new IllegalStateException();
            }
            zzhhf.put(cls, zzdobVar);
        }
        return (T) zzdobVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzdob<?, ?>> void a(Class<T> cls, T t) {
        zzhhf.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(zzdpk zzdpkVar, String str, Object[] objArr) {
        return new agu(zzdpkVar, str, objArr);
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

    protected static final <T extends zzdob<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zze.zzhhk, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return ags.a().a((ags) t).d(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static zzdoh c() {
        return afr.b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzdoj<E> d() {
        return agt.b();
    }

    private static <T extends zzdob<T, ?>> T a(T t, zzdnd zzdndVar, zzdno zzdnoVar) throws zzdok {
        T t2 = (T) t.a(zze.zzhhn, null, null);
        try {
            ags.a().a((ags) t2).a(t2, afb.a(zzdndVar), zzdnoVar);
            ags.a().a((ags) t2).c(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzdok) {
                throw ((zzdok) e.getCause());
            }
            throw new zzdok(e.getMessage()).zzo(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzdok) {
                throw ((zzdok) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzdob<T, ?>> T a(T t, byte[] bArr, int i, int i2, zzdno zzdnoVar) throws zzdok {
        T t2 = (T) t.a(zze.zzhhn, null, null);
        try {
            ags.a().a((ags) t2).a(t2, bArr, 0, i2, new aep(zzdnoVar));
            ags.a().a((ags) t2).c(t2);
            if (t2.zzhcf == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzdok) {
                throw ((zzdok) e.getCause());
            }
            throw new zzdok(e.getMessage()).zzo(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzdok.a().zzo(t2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzdob<T, ?>> T a(T t, zzdmr zzdmrVar) throws zzdok {
        boolean d;
        T t2 = (T) a(t, zzdmrVar, zzdno.zzaxd());
        boolean z = false;
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.a(zze.zzhhk, null, null)).byteValue();
            if (byteValue == 1) {
                d = true;
            } else if (byteValue == 0) {
                d = false;
            } else {
                d = ags.a().a((ags) t2).d(t2);
                if (booleanValue) {
                    t2.a(zze.zzhhl, d ? t2 : null, null);
                }
            }
            if (!d) {
                throw new zzdqs(t2).zzazx().zzo(t2);
            }
        }
        if (t2 != null) {
            boolean booleanValue2 = Boolean.TRUE.booleanValue();
            byte byteValue2 = ((Byte) t2.a(zze.zzhhk, null, null)).byteValue();
            if (byteValue2 == 1) {
                z = true;
            } else if (byteValue2 != 0) {
                z = ags.a().a((ags) t2).d(t2);
                if (booleanValue2) {
                    t2.a(zze.zzhhl, z ? t2 : null, null);
                }
            }
            if (!z) {
                throw new zzdqs(t2).zzazx().zzo(t2);
            }
        }
        return t2;
    }

    private static <T extends zzdob<T, ?>> T a(T t, zzdmr zzdmrVar, zzdno zzdnoVar) throws zzdok {
        try {
            zzdnd zzavp = zzdmrVar.zzavp();
            T t2 = (T) a(t, zzavp, zzdnoVar);
            try {
                zzavp.zzfp(0);
                return t2;
            } catch (zzdok e) {
                throw e.zzo(t2);
            }
        } catch (zzdok e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzdob<T, ?>> T a(T t, byte[] bArr) throws zzdok {
        boolean z = false;
        T t2 = (T) a(t, bArr, 0, bArr.length, zzdno.zzaxd());
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.a(zze.zzhhk, null, null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue != 0) {
                z = ags.a().a((ags) t2).d(t2);
                if (booleanValue) {
                    t2.a(zze.zzhhl, z ? t2 : null, null);
                }
            }
            if (!z) {
                throw new zzdqs(t2).zzazx().zzo(t2);
            }
        }
        return t2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzdob<T, ?>> T a(T t, byte[] bArr, zzdno zzdnoVar) throws zzdok {
        boolean z = false;
        T t2 = (T) a(t, bArr, 0, bArr.length, zzdnoVar);
        if (t2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) t2.a(zze.zzhhk, null, null)).byteValue();
            if (byteValue == 1) {
                z = true;
            } else if (byteValue != 0) {
                z = ags.a().a((ags) t2).d(t2);
                if (booleanValue) {
                    t2.a(zze.zzhhl, z ? t2 : null, null);
                }
            }
            if (!z) {
                throw new zzdqs(t2).zzazx().zzo(t2);
            }
        }
        return t2;
    }

    @Override // com.google.android.gms.internal.ads.zzdpk
    public final /* synthetic */ zzdpl zzaxt() {
        zza zzaVar = (zza) a(zze.zzhho, (Object) null, (Object) null);
        zzaVar.a(this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdpk
    public final /* synthetic */ zzdpl zzaxu() {
        return (zza) a(zze.zzhho, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.ads.zzdpm
    public final /* synthetic */ zzdpk zzaxv() {
        return (zzdob) a(zze.zzhhp, (Object) null, (Object) null);
    }
}
