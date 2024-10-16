package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import com.google.android.gms.internal.gtm.zzrc.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public abstract class zzrc<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpl<MessageType, BuilderType> {
    private static Map<Object, zzrc<?, ?>> zzbam = new ConcurrentHashMap();
    protected zzts zzbak = zzts.zzrj();
    private int zzbal = -1;

    /* loaded from: classes2.dex */
    public static abstract class zzc<MessageType extends zzc<MessageType, BuilderType>, BuilderType> extends zzrc<MessageType, BuilderType> implements zzsm {
        protected bs<Object> zzbaq = bs.a();
    }

    /* loaded from: classes2.dex */
    public static class zzd<ContainingType extends zzsk, Type> extends zzqn<ContainingType, Type> {
    }

    /* loaded from: classes2.dex */
    public enum zze {
        public static final int zzbar = 1;
        public static final int zzbas = 2;
        public static final int zzbat = 3;
        public static final int zzbau = 4;
        public static final int zzbav = 5;
        public static final int zzbaw = 6;
        public static final int zzbax = 7;

        /* renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ int[] f4442a = {zzbar, zzbas, zzbat, zzbau, zzbav, zzbaw, zzbax};
        public static final int zzbaz = 1;
        public static final int zzbba = 2;
        private static final /* synthetic */ int[] b = {zzbaz, zzbba};
        public static final int zzbbc = 1;
        public static final int zzbbd = 2;
        private static final /* synthetic */ int[] c = {zzbbc, zzbbd};

        public static int[] zzpn() {
            return (int[]) f4442a.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Object a(int i, Object obj, Object obj2);

    /* loaded from: classes2.dex */
    public static class zzb<T extends zzrc<T, ?>> extends zzpn<T> {

        /* renamed from: a, reason: collision with root package name */
        private final T f4441a;

        public zzb(T t) {
            this.f4441a = t;
        }

        @Override // com.google.android.gms.internal.gtm.zzsu
        public final /* synthetic */ Object zza(zzqe zzqeVar, zzqp zzqpVar) throws zzrk {
            return zzrc.a(this.f4441a, zzqeVar, zzqpVar);
        }
    }

    public String toString() {
        return cq.a(this, super.toString());
    }

    public int hashCode() {
        if (this.zzavp != 0) {
            return this.zzavp;
        }
        this.zzavp = cx.a().a((cx) this).a(this);
        return this.zzavp;
    }

    /* loaded from: classes2.dex */
    public static abstract class zza<MessageType extends zzrc<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzpm<MessageType, BuilderType> {

        /* renamed from: a, reason: collision with root package name */
        private final MessageType f4440a;
        private MessageType b;
        private boolean c = false;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(MessageType messagetype) {
            this.f4440a = messagetype;
            this.b = (MessageType) messagetype.a(zze.zzbau, null, null);
        }

        @Override // com.google.android.gms.internal.gtm.zzsm
        public final boolean isInitialized() {
            return zzrc.a(this.b, false);
        }

        @Override // com.google.android.gms.internal.gtm.zzsl
        /* renamed from: zzpj, reason: merged with bridge method [inline-methods] */
        public MessageType zzpl() {
            if (this.c) {
                return this.b;
            }
            this.b.c();
            this.c = true;
            return this.b;
        }

        @Override // com.google.android.gms.internal.gtm.zzsl
        /* renamed from: zzpk, reason: merged with bridge method [inline-methods] */
        public final MessageType zzpm() {
            MessageType messagetype = (MessageType) zzpl();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zztq(messagetype);
        }

        @Override // com.google.android.gms.internal.gtm.zzpm
        /* renamed from: zza, reason: merged with bridge method [inline-methods] */
        public final BuilderType a(MessageType messagetype) {
            if (this.c) {
                MessageType messagetype2 = (MessageType) this.b.a(zze.zzbau, null, null);
                a(messagetype2, this.b);
                this.b = messagetype2;
                this.c = false;
            }
            a(this.b, messagetype);
            return this;
        }

        private static void a(MessageType messagetype, MessageType messagetype2) {
            cx.a().a((cx) messagetype).b(messagetype, messagetype2);
        }

        @Override // com.google.android.gms.internal.gtm.zzpm
        /* renamed from: zzmx */
        public final /* synthetic */ zzpm clone() {
            return (zza) clone();
        }

        @Override // com.google.android.gms.internal.gtm.zzsm
        public final /* synthetic */ zzsk zzpi() {
            return this.f4440a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.gtm.zzpm
        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zzaVar = (zza) this.f4440a.a(zze.zzbav, null, null);
            zzaVar.a((zza) zzpl());
            return zzaVar;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (((zzrc) a(zze.zzbaw, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return cx.a().a((cx) this).a(this, (zzrc<MessageType, BuilderType>) obj);
        }
        return false;
    }

    protected final void c() {
        cx.a().a((cx) this).c(this);
    }

    @Override // com.google.android.gms.internal.gtm.zzsm
    public final boolean isInitialized() {
        return a(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzpd() {
        BuilderType buildertype = (BuilderType) a(zze.zzbav, (Object) null, (Object) null);
        buildertype.a(this);
        return buildertype;
    }

    @Override // com.google.android.gms.internal.gtm.zzpl
    final int b() {
        return this.zzbal;
    }

    @Override // com.google.android.gms.internal.gtm.zzpl
    final void a(int i) {
        this.zzbal = i;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final void zzb(zzqj zzqjVar) throws IOException {
        cx.a().a((Class) getClass()).a((da) this, (ed) bm.a(zzqjVar));
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final int zzpe() {
        if (this.zzbal == -1) {
            this.zzbal = cx.a().a((cx) this).b(this);
        }
        return this.zzbal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzrc<?, ?>> T a(Class<T> cls) {
        zzrc<?, ?> zzrcVar = zzbam.get(cls);
        if (zzrcVar == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                zzrcVar = zzbam.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (zzrcVar == null) {
            zzrcVar = (T) ((zzrc) dv.a(cls)).a(zze.zzbaw, (Object) null, (Object) null);
            if (zzrcVar == null) {
                throw new IllegalStateException();
            }
            zzbam.put(cls, zzrcVar);
        }
        return (T) zzrcVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends zzrc<?, ?>> void a(Class<T> cls, T t) {
        zzbam.put(cls, t);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(zzsk zzskVar, String str, Object[] objArr) {
        return new cy(zzskVar, str, objArr);
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

    protected static final <T extends zzrc<T, ?>> boolean a(T t, boolean z) {
        byte byteValue = ((Byte) t.a(zze.zzbar, null, null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean d = cx.a().a((cx) t).d(t);
        if (z) {
            t.a(zze.zzbas, d ? t : null, null);
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.gtm.by, com.google.android.gms.internal.gtm.zzri] */
    public static zzri d() {
        return by.b();
    }

    static <T extends zzrc<T, ?>> T a(T t, zzqe zzqeVar, zzqp zzqpVar) throws zzrk {
        T t2 = (T) t.a(zze.zzbau, null, null);
        try {
            cx.a().a((cx) t2).a(t2, bj.a(zzqeVar), zzqpVar);
            t2.c();
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzrk) {
                throw ((zzrk) e.getCause());
            }
            throw new zzrk(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzrk) {
                throw ((zzrk) e2.getCause());
            }
            throw e2;
        }
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final /* synthetic */ zzsl zzpg() {
        zza zzaVar = (zza) a(zze.zzbav, (Object) null, (Object) null);
        zzaVar.a((zza) this);
        return zzaVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzsk
    public final /* synthetic */ zzsl zzph() {
        return (zza) a(zze.zzbav, (Object) null, (Object) null);
    }

    @Override // com.google.android.gms.internal.gtm.zzsm
    public final /* synthetic */ zzsk zzpi() {
        return (zzrc) a(zze.zzbaw, (Object) null, (Object) null);
    }
}
