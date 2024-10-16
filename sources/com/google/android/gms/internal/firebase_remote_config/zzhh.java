package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhh;
import com.google.android.gms.internal.firebase_remote_config.zzhh.zza;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzhh<MessageType extends zzhh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfm<MessageType, BuilderType> {
    private static Map<Object, zzhh<?, ?>> zzti = new ConcurrentHashMap();
    protected zzjw zztg = zzjw.zziz();
    private int zzth = -1;

    /* loaded from: classes2.dex */
    public static class zzc<T extends zzhh<T, ?>> extends zzfo<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f4182a;

        public zzc(T t) {
            this.f4182a = t;
        }
    }

    /* loaded from: classes2.dex */
    public enum zzd {
        public static final int zztk = 1;
        public static final int zztl = 2;
        public static final int zztm = 3;
        public static final int zztn = 4;
        public static final int zzto = 5;
        public static final int zztp = 6;
        public static final int zztq = 7;

        /* renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ int[] f4183a = {zztk, zztl, zztm, zztn, zzto, zztp, zztq};
        public static final int zzts = 1;
        public static final int zztt = 2;
        private static final /* synthetic */ int[] b = {zzts, zztt};
        public static final int zztv = 1;
        public static final int zztw = 2;
        private static final /* synthetic */ int[] c = {zztv, zztw};

        public static int[] zzhd() {
            return (int[]) f4183a.clone();
        }
    }

    /* loaded from: classes2.dex */
    public static class zze<ContainingType extends zzim, Type> extends zzgs<ContainingType, Type> {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(int i, Object obj, Object obj2);

    /* loaded from: classes2.dex */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzhh<MessageType, BuilderType> implements zzio {
        protected cd<Object> zztj = cd.a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public final cd<Object> a() {
            if (this.zztj.c()) {
                this.zztj = (cd) this.zztj.clone();
            }
            return this.zztj;
        }
    }

    public String toString() {
        return da.a(this, super.toString());
    }

    public int hashCode() {
        if (this.zzoj != 0) {
            return this.zzoj;
        }
        this.zzoj = di.a().a((di) this).a(this);
        return this.zzoj;
    }

    /* loaded from: classes2.dex */
    public static abstract class zza<MessageType extends zzhh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzfp<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        private final MessageType f4181a;
        private MessageType b;
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.f4181a = messagetype;
            this.b = (MessageType) messagetype.a(zzd.zztn, null, null);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzio
        public final boolean isInitialized() {
            return zzhh.a(this.b, false);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzip
        /* renamed from: zzgt, reason: merged with bridge method [inline-methods] */
        public MessageType zzgv() {
            if (this.c) {
                return this.b;
            }
            this.b.c();
            this.c = true;
            return this.b;
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzip
        /* renamed from: zzgu, reason: merged with bridge method [inline-methods] */
        public final MessageType zzgw() {
            MessageType messagetype = (MessageType) zzgv();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzju(messagetype);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzfp
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final BuilderType a(MessageType messagetype) {
            if (this.c) {
                MessageType messagetype2 = (MessageType) this.b.a(zzd.zztn, null, null);
                a(messagetype2, this.b);
                this.b = messagetype2;
                this.c = false;
            }
            a(this.b, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            di.a().a((di) messagetype).b(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzfp
        /* renamed from: zzeq */
        public final /* synthetic */ zzfp clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.firebase_remote_config.zzio
        public final /* synthetic */ zzim zzgx() {
            return this.f4181a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzfp
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.f4181a.a(zzd.zzto, null, null);
            zzaVar.a((zza) zzgv());
            return zzaVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzhh) a(zzd.zztp, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return di.a().a((di) this).a(this, (zzhh<MessageType, BuilderType>) obj);
        }
        return false;
    }

    protected final void c() {
        di.a().a((di) this).c(this);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzio
    public final boolean isInitialized() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfm
    final int b() {
        return this.zzth;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzfm
    final void a(int i) {
        this.zzth = i;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzim
    public final void zzb(zzgo zzgoVar) throws IOException {
        di.a().a((Class) getClass()).a((dm) this, (eo) bv.a(zzgoVar));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzim
    public final int zzgy() {
        if (this.zzth == -1) {
            this.zzth = di.a().a((di) this).b(this);
        }
        return this.zzth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzhh<?, ?>> T a(Class<T> cls) {
        zzhh<?, ?> zzhhVar = zzti.get(cls);
        if (zzhhVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzhhVar = zzti.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzhhVar == null) {
            zzhhVar = (T) ((zzhh) eh.a(cls)).a(zzd.zztp, (Object) null, (Object) null);
            if (zzhhVar == null) {
                throw new IllegalStateException();
            }
            zzti.put(cls, zzhhVar);
        }
        return (T) zzhhVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzhh<?, ?>> void a(Class<T> cls, T t) {
        zzti.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(zzim zzimVar, String str, Object[] objArr) {
        return new dk(zzimVar, str, objArr);
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

    protected static final <T extends zzhh<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zzd.zztk, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d = di.a().a((di) t).d(t);
        if (z) {
            t.a(zzd.zztl, d ? t : null, null);
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <E> zzhn<E> d() {
        return dh.b();
    }

    private static <T extends zzhh<T, ?>> T a(T t, zzgj zzgjVar, zzgu zzguVar) throws zzhm {
        T t2 = (T) t.a(zzd.zztn, null, null);
        try {
            di.a().a((di) t2).a(t2, br.a(zzgjVar), zzguVar);
            t2.c();
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzhm) {
                throw ((zzhm) e.getCause());
            }
            throw new zzhm(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzhm) {
                throw ((zzhm) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzhh<T, ?>> T a(T t, byte[] bArr, int i, int i2, zzgu zzguVar) throws zzhm {
        T t2 = (T) t.a(zzd.zztn, null, null);
        try {
            di.a().a((di) t2).a(t2, bArr, 0, i2, new bd(zzguVar));
            t2.c();
            if (t2.zzoj == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzhm) {
                throw ((zzhm) e.getCause());
            }
            throw new zzhm(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzhm.a().zzg(t2);
        }
    }

    private static <T extends zzhh<T, ?>> T a(T t) throws zzhm {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzhm(new zzju(t).getMessage()).zzg(t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzhh<T, ?>> T a(T t, byte[] bArr) throws zzhm {
        return (T) a(a(t, bArr, 0, bArr.length, zzgu.zzgf()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzhh<T, ?>> T a(T t, InputStream inputStream) throws zzhm {
        zzgj bpVar;
        if (inputStream == null) {
            byte[] bArr = zzhi.zzty;
            bpVar = zzgj.a(bArr, 0, bArr.length, false);
        } else {
            bpVar = new bp(inputStream);
        }
        return (T) a(a(t, bpVar, zzgu.zzgf()));
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzim
    public final /* synthetic */ zzip zzha() {
        zza zzaVar = (zza) a(zzd.zzto, (Object) null, (Object) null);
        zzaVar.a((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzim
    public final /* synthetic */ zzip zzhb() {
        return (zza) a(zzd.zzto, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzio
    public final /* synthetic */ zzim zzgx() {
        return (zzhh) a(zzd.zztp, (Object) null, (Object) null);
    }
}
