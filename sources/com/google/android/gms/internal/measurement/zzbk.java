package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbk {

    /* loaded from: classes2.dex */
    public static final class zza extends zzey<zza, C0109zza> implements zzgk {
        private static final zza zzun = new zza();
        private static volatile zzgr<zza> zzuo;
        private int zzue;
        private int zzuf;
        private String zzug = "";
        private zzff<zzb> zzuh = g();
        private boolean zzui;
        private zzc zzuj;
        private boolean zzuk;
        private boolean zzul;
        private boolean zzum;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbk$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0109zza extends zzey.zza<zza, C0109zza> implements zzgk {
            private C0109zza() {
                super(zza.zzun);
            }

            public final String zzjz() {
                return ((zza) this.f4559a).zzjz();
            }

            public final C0109zza zzbs(String str) {
                a();
                ((zza) this.f4559a).a(str);
                return this;
            }

            public final int zzka() {
                return ((zza) this.f4559a).zzka();
            }

            public final zzb zze(int i) {
                return ((zza) this.f4559a).zze(i);
            }

            public final C0109zza zza(int i, zzb zzbVar) {
                a();
                ((zza) this.f4559a).a(i, zzbVar);
                return this;
            }

            /* synthetic */ C0109zza(aj ajVar) {
                this();
            }
        }

        public final boolean zzkb() {
            return (this.zzue & 1) != 0;
        }

        public final int getId() {
            return this.zzuf;
        }

        public final String zzjz() {
            return this.zzug;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 2;
            this.zzug = str;
        }

        public final List<zzb> zzkc() {
            return this.zzuh;
        }

        public final int zzka() {
            return this.zzuh.size();
        }

        public final zzb zze(int i) {
            return this.zzuh.get(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(int i, zzb zzbVar) {
            if (zzbVar == null) {
                throw new NullPointerException();
            }
            if (!this.zzuh.zzrx()) {
                this.zzuh = zzey.a(this.zzuh);
            }
            this.zzuh.set(i, zzbVar);
        }

        public final boolean zzkd() {
            return (this.zzue & 8) != 0;
        }

        public final zzc zzke() {
            zzc zzcVar = this.zzuj;
            return zzcVar == null ? zzc.zzle() : zzcVar;
        }

        public final boolean zzkf() {
            return this.zzuk;
        }

        public final boolean zzkg() {
            return this.zzul;
        }

        public final boolean zzkh() {
            return (this.zzue & 64) != 0;
        }

        public final boolean zzki() {
            return this.zzum;
        }

        public static zza zza(byte[] bArr, zzel zzelVar) throws zzfi {
            return (zza) zzey.a(zzun, bArr, zzelVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            aj ajVar = null;
            switch (aj.f4472a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0109zza(ajVar);
                case 3:
                    return a(zzun, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u001b\u0004\u0007\u0002\u0005\t\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\u0007\u0006", new Object[]{"zzue", "zzuf", "zzug", "zzuh", zzb.class, "zzui", "zzuj", "zzuk", "zzul", "zzum"});
                case 4:
                    return zzun;
                case 5:
                    zzgr<zza> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zza.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzun);
                                zzuo = zzgrVar;
                            }
                        }
                    }
                    return zzgrVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzgr<zza> zzkj() {
            return (zzgr) zzun.a(zzey.zzd.zzaij, (Object) null, (Object) null);
        }

        static {
            zzey.a((Class<zza>) zza.class, zzun);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzey<zzb, zza> implements zzgk {
        private static volatile zzgr<zzb> zzuo;
        private static final zzb zzut = new zzb();
        private int zzue;
        private zze zzup;
        private zzc zzuq;
        private boolean zzur;
        private String zzus = "";

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzb, zza> implements zzgk {
            private zza() {
                super(zzb.zzut);
            }

            public final zza zzbu(String str) {
                a();
                ((zzb) this.f4559a).a(str);
                return this;
            }

            /* synthetic */ zza(aj ajVar) {
                this();
            }
        }

        public final boolean zzkl() {
            return (this.zzue & 1) != 0;
        }

        public final zze zzkm() {
            zze zzeVar = this.zzup;
            return zzeVar == null ? zze.zzls() : zzeVar;
        }

        public final boolean zzkn() {
            return (this.zzue & 2) != 0;
        }

        public final zzc zzko() {
            zzc zzcVar = this.zzuq;
            return zzcVar == null ? zzc.zzle() : zzcVar;
        }

        public final boolean zzkp() {
            return (this.zzue & 4) != 0;
        }

        public final boolean zzkq() {
            return this.zzur;
        }

        public final String zzkr() {
            return this.zzus;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 8;
            this.zzus = str;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            aj ajVar = null;
            switch (aj.f4472a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(ajVar);
                case 3:
                    return a(zzut, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u0007\u0002\u0004\b\u0003", new Object[]{"zzue", "zzup", "zzuq", "zzur", "zzus"});
                case 4:
                    return zzut;
                case 5:
                    zzgr<zzb> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzb.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzut);
                                zzuo = zzgrVar;
                            }
                        }
                    }
                    return zzgrVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzb zzks() {
            return zzut;
        }

        static {
            zzey.a((Class<zzb>) zzb.class, zzut);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzey<zzc, zza> implements zzgk {
        private static volatile zzgr<zzc> zzuo;
        private static final zzc zzuz = new zzc();
        private int zzue;
        private int zzuu;
        private boolean zzuv;
        private String zzuw = "";
        private String zzux = "";
        private String zzuy = "";

        /* loaded from: classes2.dex */
        public enum zzb implements zzfc {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);


            /* renamed from: a, reason: collision with root package name */
            private static final zzfb<zzb> f4538a = new ak();
            private final int value;

            @Override // com.google.android.gms.internal.measurement.zzfc
            public final int zzlg() {
                return this.value;
            }

            public static zzb zzf(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_COMPARISON_TYPE;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return GREATER_THAN;
                    case 3:
                        return EQUAL;
                    case 4:
                        return BETWEEN;
                    default:
                        return null;
                }
            }

            public static zzfe zzlh() {
                return al.f4473a;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        private zzc() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzc, zza> implements zzgk {
            private zza() {
                super(zzc.zzuz);
            }

            /* synthetic */ zza(aj ajVar) {
                this();
            }
        }

        public final boolean zzku() {
            return (this.zzue & 1) != 0;
        }

        public final zzb zzkv() {
            zzb zzf = zzb.zzf(this.zzuu);
            return zzf == null ? zzb.UNKNOWN_COMPARISON_TYPE : zzf;
        }

        public final boolean zzkw() {
            return (this.zzue & 2) != 0;
        }

        public final boolean zzkx() {
            return this.zzuv;
        }

        public final boolean zzky() {
            return (this.zzue & 4) != 0;
        }

        public final String zzkz() {
            return this.zzuw;
        }

        public final boolean zzla() {
            return (this.zzue & 8) != 0;
        }

        public final String zzlb() {
            return this.zzux;
        }

        public final boolean zzlc() {
            return (this.zzue & 16) != 0;
        }

        public final String zzld() {
            return this.zzuy;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            aj ajVar = null;
            switch (aj.f4472a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(ajVar);
                case 3:
                    return a(zzuz, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"zzue", "zzuu", zzb.zzlh(), "zzuv", "zzuw", "zzux", "zzuy"});
                case 4:
                    return zzuz;
                case 5:
                    zzgr<zzc> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzc.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzuz);
                                zzuo = zzgrVar;
                            }
                        }
                    }
                    return zzgrVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzc zzle() {
            return zzuz;
        }

        static {
            zzey.a((Class<zzc>) zzc.class, zzuz);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzd extends zzey<zzd, zza> implements zzgk {
        private static volatile zzgr<zzd> zzuo;
        private static final zzd zzvj = new zzd();
        private int zzue;
        private int zzuf;
        private boolean zzuk;
        private boolean zzul;
        private boolean zzum;
        private String zzvh = "";
        private zzb zzvi;

        private zzd() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzd, zza> implements zzgk {
            private zza() {
                super(zzd.zzvj);
            }

            public final zza zzbw(String str) {
                a();
                ((zzd) this.f4559a).a(str);
                return this;
            }

            /* synthetic */ zza(aj ajVar) {
                this();
            }
        }

        public final boolean zzkb() {
            return (this.zzue & 1) != 0;
        }

        public final int getId() {
            return this.zzuf;
        }

        public final String getPropertyName() {
            return this.zzvh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 2;
            this.zzvh = str;
        }

        public final zzb zzli() {
            zzb zzbVar = this.zzvi;
            return zzbVar == null ? zzb.zzks() : zzbVar;
        }

        public final boolean zzkf() {
            return this.zzuk;
        }

        public final boolean zzkg() {
            return this.zzul;
        }

        public final boolean zzkh() {
            return (this.zzue & 32) != 0;
        }

        public final boolean zzki() {
            return this.zzum;
        }

        public static zzd zzb(byte[] bArr, zzel zzelVar) throws zzfi {
            return (zzd) zzey.a(zzvj, bArr, zzelVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            aj ajVar = null;
            switch (aj.f4472a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(ajVar);
                case 3:
                    return a(zzvj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\t\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzue", "zzuf", "zzvh", "zzvi", "zzuk", "zzul", "zzum"});
                case 4:
                    return zzvj;
                case 5:
                    zzgr<zzd> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzd.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzvj);
                                zzuo = zzgrVar;
                            }
                        }
                    }
                    return zzgrVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzgr<zzd> zzkj() {
            return (zzgr) zzvj.a(zzey.zzd.zzaij, (Object) null, (Object) null);
        }

        static {
            zzey.a((Class<zzd>) zzd.class, zzvj);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zze extends zzey<zze, zzb> implements zzgk {
        private static volatile zzgr<zze> zzuo;
        private static final zze zzvp = new zze();
        private int zzue;
        private int zzvl;
        private boolean zzvn;
        private String zzvm = "";
        private zzff<String> zzvo = zzey.g();

        /* loaded from: classes2.dex */
        public enum zza implements zzfc {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);


            /* renamed from: a, reason: collision with root package name */
            private static final zzfb<zza> f4539a = new an();
            private final int value;

            @Override // com.google.android.gms.internal.measurement.zzfc
            public final int zzlg() {
                return this.value;
            }

            public static zza zzh(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static zzfe zzlh() {
                return am.f4474a;
            }

            zza(int i) {
                this.value = i;
            }
        }

        private zze() {
        }

        /* loaded from: classes2.dex */
        public static final class zzb extends zzey.zza<zze, zzb> implements zzgk {
            private zzb() {
                super(zze.zzvp);
            }

            /* synthetic */ zzb(aj ajVar) {
                this();
            }
        }

        public final boolean zzlk() {
            return (this.zzue & 1) != 0;
        }

        public final zza zzll() {
            zza zzh = zza.zzh(this.zzvl);
            return zzh == null ? zza.UNKNOWN_MATCH_TYPE : zzh;
        }

        public final boolean zzlm() {
            return (this.zzue & 2) != 0;
        }

        public final String zzln() {
            return this.zzvm;
        }

        public final boolean zzlo() {
            return (this.zzue & 4) != 0;
        }

        public final boolean zzlp() {
            return this.zzvn;
        }

        public final List<String> zzlq() {
            return this.zzvo;
        }

        public final int zzlr() {
            return this.zzvo.size();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            aj ajVar = null;
            switch (aj.f4472a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zzb(ajVar);
                case 3:
                    return a(zzvp, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u001a", new Object[]{"zzue", "zzvl", zza.zzlh(), "zzvm", "zzvn", "zzvo"});
                case 4:
                    return zzvp;
                case 5:
                    zzgr<zze> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zze.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzvp);
                                zzuo = zzgrVar;
                            }
                        }
                    }
                    return zzgrVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zze zzls() {
            return zzvp;
        }

        static {
            zzey.a((Class<zze>) zze.class, zzvp);
        }
    }
}
