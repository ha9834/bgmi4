package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzc {

    /* loaded from: classes2.dex */
    public static final class zza extends zzrc<zza, C0107zza> implements zzsm {
        private static final zza zznv = new zza();
        private static volatile zzsu<zza> zznw;
        private int zznr;
        private int zzns = 1;
        private int zznt;
        private int zznu;

        /* loaded from: classes2.dex */
        public enum zzb implements zzrf {
            NO_CACHE(1),
            PRIVATE(2),
            PUBLIC(3);

            private static final zzrg<zzb> d = new ao();
            private final int value;

            @Override // com.google.android.gms.internal.gtm.zzrf
            public final int zzc() {
                return this.value;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 1:
                        return NO_CACHE;
                    case 2:
                        return PRIVATE;
                    case 3:
                        return PUBLIC;
                    default:
                        return null;
                }
            }

            public static zzrh zzd() {
                return ap.f4302a;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.gtm.zzc$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0107zza extends zzrc.zza<zza, C0107zza> implements zzsm {
            private C0107zza() {
                super(zza.zznv);
            }

            /* synthetic */ C0107zza(ak akVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.gtm.zzrc
        public final Object a(int i, Object obj, Object obj2) {
            ak akVar = null;
            switch (ak.f4300a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0107zza(akVar);
                case 3:
                    return a(zznv, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0000\u0002\u0004\u0001\u0003\u0004\u0002", new Object[]{"zznr", "zzns", zzb.zzd(), "zznt", "zznu"});
                case 4:
                    return zznv;
                case 5:
                    zzsu<zza> zzsuVar = zznw;
                    if (zzsuVar == null) {
                        synchronized (zza.class) {
                            zzsuVar = zznw;
                            if (zzsuVar == null) {
                                zzsuVar = new zzrc.zzb<>(zznv);
                                zznw = zzsuVar;
                            }
                        }
                    }
                    return zzsuVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzsu<zza> zza() {
            return (zzsu) zznv.a(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        static {
            zzrc.a((Class<zza>) zza.class, zznv);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzrc<zzb, zza> implements zzsm {
        private static volatile zzsu<zzb> zznw;
        private static final zzb zzoj = new zzb();
        private int zznr;
        private int zzoe;
        private int zzof;
        private boolean zzog;
        private boolean zzoh;
        private byte zzoi = 2;
        private zzri zzod = d();

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzrc.zza<zzb, zza> implements zzsm {
            private zza() {
                super(zzb.zzoj);
            }

            /* synthetic */ zza(ak akVar) {
                this();
            }
        }

        public final List<Integer> zze() {
            return this.zzod;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.gtm.zzrc
        public final Object a(int i, Object obj, Object obj2) {
            ak akVar = null;
            switch (ak.f4300a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(akVar);
                case 3:
                    return a(zzoj, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0001\u0001\u0007\u0003\u0002Ԅ\u0000\u0003\u0016\u0004\u0004\u0001\u0006\u0007\u0002", new Object[]{"zznr", "zzoh", "zzoe", "zzod", "zzof", "zzog"});
                case 4:
                    return zzoj;
                case 5:
                    zzsu<zzb> zzsuVar = zznw;
                    if (zzsuVar == null) {
                        synchronized (zzb.class) {
                            zzsuVar = zznw;
                            if (zzsuVar == null) {
                                zzsuVar = new zzrc.zzb<>(zzoj);
                                zznw = zzsuVar;
                            }
                        }
                    }
                    return zzsuVar;
                case 6:
                    return Byte.valueOf(this.zzoi);
                case 7:
                    this.zzoi = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzsu<zzb> zza() {
            return (zzsu) zzoj.a(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        static {
            zzrc.a((Class<zzb>) zzb.class, zzoj);
        }
    }

    /* renamed from: com.google.android.gms.internal.gtm.zzc$zzc, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0108zzc extends zzrc<C0108zzc, zza> implements zzsm {
        private static volatile zzsu<C0108zzc> zznw;
        private static final C0108zzc zzop = new C0108zzc();
        private int zznr;
        private long zzol;
        private boolean zzon;
        private long zzoo;
        private String zzok = "";
        private long zzom = 2147483647L;

        private C0108zzc() {
        }

        /* renamed from: com.google.android.gms.internal.gtm.zzc$zzc$zza */
        /* loaded from: classes2.dex */
        public static final class zza extends zzrc.zza<C0108zzc, zza> implements zzsm {
            private zza() {
                super(C0108zzc.zzop);
            }

            /* synthetic */ zza(ak akVar) {
                this();
            }
        }

        public final boolean hasKey() {
            return (this.zznr & 1) != 0;
        }

        public final String getKey() {
            return this.zzok;
        }

        public final long zzg() {
            return this.zzol;
        }

        public final long zzh() {
            return this.zzom;
        }

        public final boolean zzi() {
            return this.zzon;
        }

        public final long zzj() {
            return this.zzoo;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.gtm.zzrc
        public final Object a(int i, Object obj, Object obj2) {
            ak akVar = null;
            switch (ak.f4300a[i - 1]) {
                case 1:
                    return new C0108zzc();
                case 2:
                    return new zza(akVar);
                case 3:
                    return a(zzop, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\u0002\u0002\u0004\u0007\u0003\u0005\u0002\u0004", new Object[]{"zznr", "zzok", "zzol", "zzom", "zzon", "zzoo"});
                case 4:
                    return zzop;
                case 5:
                    zzsu<C0108zzc> zzsuVar = zznw;
                    if (zzsuVar == null) {
                        synchronized (C0108zzc.class) {
                            zzsuVar = zznw;
                            if (zzsuVar == null) {
                                zzsuVar = new zzrc.zzb<>(zzop);
                                zznw = zzsuVar;
                            }
                        }
                    }
                    return zzsuVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzsu<C0108zzc> zza() {
            return (zzsu) zzop.a(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        static {
            zzrc.a((Class<C0108zzc>) C0108zzc.class, zzop);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzd extends zzrc<zzd, zza> implements zzsm {
        private static volatile zzsu<zzd> zznw;
        private static final zzd zzos = new zzd();
        private int zznr;
        private byte zzoi = 2;
        private int zzoq;
        private int zzor;

        private zzd() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzrc.zza<zzd, zza> implements zzsm {
            private zza() {
                super(zzd.zzos);
            }

            /* synthetic */ zza(ak akVar) {
                this();
            }
        }

        public final int zzl() {
            return this.zzoq;
        }

        public final int getValue() {
            return this.zzor;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.gtm.zzrc
        public final Object a(int i, Object obj, Object obj2) {
            ak akVar = null;
            switch (ak.f4300a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(akVar);
                case 3:
                    return a(zzos, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001Ԅ\u0000\u0002Ԅ\u0001", new Object[]{"zznr", "zzoq", "zzor"});
                case 4:
                    return zzos;
                case 5:
                    zzsu<zzd> zzsuVar = zznw;
                    if (zzsuVar == null) {
                        synchronized (zzd.class) {
                            zzsuVar = zznw;
                            if (zzsuVar == null) {
                                zzsuVar = new zzrc.zzb<>(zzos);
                                zznw = zzsuVar;
                            }
                        }
                    }
                    return zzsuVar;
                case 6:
                    return Byte.valueOf(this.zzoi);
                case 7:
                    this.zzoi = (byte) (obj != null ? 1 : 0);
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzsu<zzd> zza() {
            return (zzsu) zzos.a(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        static {
            zzrc.a((Class<zzd>) zzd.class, zzos);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zze extends zzrc<zze, zza> implements zzsm {
        private static volatile zzsu<zze> zznw;
        private static final zze zzpd = new zze();
        private zzri zzot = d();
        private zzri zzou = d();
        private zzri zzov = d();
        private zzri zzow = d();
        private zzri zzox = d();
        private zzri zzoy = d();
        private zzri zzoz = d();
        private zzri zzpa = d();
        private zzri zzpb = d();
        private zzri zzpc = d();

        private zze() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzrc.zza<zze, zza> implements zzsm {
            private zza() {
                super(zze.zzpd);
            }

            /* synthetic */ zza(ak akVar) {
                this();
            }
        }

        public final List<Integer> zzn() {
            return this.zzot;
        }

        public final List<Integer> zzo() {
            return this.zzou;
        }

        public final List<Integer> zzp() {
            return this.zzov;
        }

        public final List<Integer> zzq() {
            return this.zzow;
        }

        public final List<Integer> zzr() {
            return this.zzox;
        }

        public final List<Integer> zzs() {
            return this.zzoy;
        }

        public final List<Integer> zzt() {
            return this.zzoz;
        }

        public final List<Integer> zzu() {
            return this.zzpa;
        }

        public final List<Integer> zzv() {
            return this.zzpb;
        }

        public final List<Integer> zzw() {
            return this.zzpc;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.gtm.zzrc
        public final Object a(int i, Object obj, Object obj2) {
            ak akVar = null;
            switch (ak.f4300a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(akVar);
                case 3:
                    return a(zzpd, "\u0001\n\u0000\u0000\u0001\n\n\u0000\n\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004\u0016\u0005\u0016\u0006\u0016\u0007\u0016\b\u0016\t\u0016\n\u0016", new Object[]{"zzot", "zzou", "zzov", "zzow", "zzox", "zzoy", "zzoz", "zzpa", "zzpb", "zzpc"});
                case 4:
                    return zzpd;
                case 5:
                    zzsu<zze> zzsuVar = zznw;
                    if (zzsuVar == null) {
                        synchronized (zze.class) {
                            zzsuVar = zznw;
                            if (zzsuVar == null) {
                                zzsuVar = new zzrc.zzb<>(zzpd);
                                zznw = zzsuVar;
                            }
                        }
                    }
                    return zzsuVar;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzsu<zze> zza() {
            return (zzsu) zzpd.a(zzrc.zze.zzbax, (Object) null, (Object) null);
        }

        static {
            zzrc.a((Class<zze>) zze.class, zzpd);
        }
    }
}
