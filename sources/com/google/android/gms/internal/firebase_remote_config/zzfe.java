package com.google.android.gms.internal.firebase_remote_config;

import com.google.android.gms.internal.firebase_remote_config.zzhh;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzfe {

    /* loaded from: classes2.dex */
    public static final class zza extends zzhh<zza, C0105zza> implements zzio {
        private static final zza zzmj = new zza();
        private static volatile zziz<zza> zzmk;
        private int zzmf;
        private long zzmh;
        private zzhn<zzd> zzmg = d();
        private zzhn<zzfx> zzmi = d();

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_remote_config.zzfe$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0105zza extends zzhh.zza<zza, C0105zza> implements zzio {
            private C0105zza() {
                super(zza.zzmj);
            }

            /* synthetic */ C0105zza(az azVar) {
                this();
            }
        }

        public final List<zzd> zzdk() {
            return this.zzmg;
        }

        public final long getTimestamp() {
            return this.zzmh;
        }

        public final List<zzfx> zzdl() {
            return this.zzmi;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfe$zza>, com.google.android.gms.internal.firebase_remote_config.zzhh$zzc] */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzhh
        public final Object a(int i, Object obj, Object obj2) {
            zziz<zza> zzizVar;
            az azVar = null;
            switch (az.f4038a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0105zza(azVar);
                case 3:
                    return a(zzmj, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u0005\u0000\u0003\u001c", new Object[]{"zzmf", "zzmg", zzd.class, "zzmh", "zzmi"});
                case 4:
                    return zzmj;
                case 5:
                    zziz<zza> zzizVar2 = zzmk;
                    zziz<zza> zzizVar3 = zzizVar2;
                    if (zzizVar2 == null) {
                        synchronized (zza.class) {
                            zziz<zza> zzizVar4 = zzmk;
                            zzizVar = zzizVar4;
                            if (zzizVar4 == null) {
                                ?? zzcVar = new zzhh.zzc(zzmj);
                                zzmk = zzcVar;
                                zzizVar = zzcVar;
                            }
                        }
                        zzizVar3 = zzizVar;
                    }
                    return zzizVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zza zzdm() {
            return zzmj;
        }

        static {
            zzhh.a((Class<zza>) zza.class, zzmj);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzhh<zzb, zza> implements zzio {
        private static volatile zziz<zzb> zzmk;
        private static final zzb zzmo = new zzb();
        private int zzmf;
        private String zzmm = "";
        private zzfx zzmn = zzfx.zzow;

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzhh.zza<zzb, zza> implements zzio {
            private zza() {
                super(zzb.zzmo);
            }

            /* synthetic */ zza(az azVar) {
                this();
            }
        }

        public final String getKey() {
            return this.zzmm;
        }

        public final zzfx zzdo() {
            return this.zzmn;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfe$zzb>, com.google.android.gms.internal.firebase_remote_config.zzhh$zzc] */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzhh
        public final Object a(int i, Object obj, Object obj2) {
            zziz<zzb> zzizVar;
            az azVar = null;
            switch (az.f4038a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(azVar);
                case 3:
                    return a(zzmo, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\n\u0001", new Object[]{"zzmf", "zzmm", "zzmn"});
                case 4:
                    return zzmo;
                case 5:
                    zziz<zzb> zzizVar2 = zzmk;
                    zziz<zzb> zzizVar3 = zzizVar2;
                    if (zzizVar2 == null) {
                        synchronized (zzb.class) {
                            zziz<zzb> zzizVar4 = zzmk;
                            zzizVar = zzizVar4;
                            if (zzizVar4 == null) {
                                ?? zzcVar = new zzhh.zzc(zzmo);
                                zzmk = zzcVar;
                                zzizVar = zzcVar;
                            }
                        }
                        zzizVar3 = zzizVar;
                    }
                    return zzizVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhh.a((Class<zzb>) zzb.class, zzmo);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzhh<zzc, zza> implements zzio {
        private static volatile zziz<zzc> zzmk;
        private static final zzc zzms = new zzc();
        private int zzmf;
        private int zzmp;
        private boolean zzmq;
        private long zzmr;

        private zzc() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzhh.zza<zzc, zza> implements zzio {
            private zza() {
                super(zzc.zzms);
            }

            /* synthetic */ zza(az azVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfe$zzc>, com.google.android.gms.internal.firebase_remote_config.zzhh$zzc] */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzhh
        public final Object a(int i, Object obj, Object obj2) {
            zziz<zzc> zzizVar;
            az azVar = null;
            switch (az.f4038a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(azVar);
                case 3:
                    return a(zzms, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0007\u0001\u0003\u0005\u0002", new Object[]{"zzmf", "zzmp", "zzmq", "zzmr"});
                case 4:
                    return zzms;
                case 5:
                    zziz<zzc> zzizVar2 = zzmk;
                    zziz<zzc> zzizVar3 = zzizVar2;
                    if (zzizVar2 == null) {
                        synchronized (zzc.class) {
                            zziz<zzc> zzizVar4 = zzmk;
                            zzizVar = zzizVar4;
                            if (zzizVar4 == null) {
                                ?? zzcVar = new zzhh.zzc(zzms);
                                zzmk = zzcVar;
                                zzizVar = zzcVar;
                            }
                        }
                        zzizVar3 = zzizVar;
                    }
                    return zzizVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhh.a((Class<zzc>) zzc.class, zzms);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzd extends zzhh<zzd, zza> implements zzio {
        private static volatile zziz<zzd> zzmk;
        private static final zzd zzmv = new zzd();
        private int zzmf;
        private String zzmt = "";
        private zzhn<zzb> zzmu = d();

        private zzd() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzhh.zza<zzd, zza> implements zzio {
            private zza() {
                super(zzd.zzmv);
            }

            /* synthetic */ zza(az azVar) {
                this();
            }
        }

        public final String getNamespace() {
            return this.zzmt;
        }

        public final List<zzb> zzdr() {
            return this.zzmu;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfe$zzd>, com.google.android.gms.internal.firebase_remote_config.zzhh$zzc] */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzhh
        public final Object a(int i, Object obj, Object obj2) {
            zziz<zzd> zzizVar;
            az azVar = null;
            switch (az.f4038a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(azVar);
                case 3:
                    return a(zzmv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\b\u0000\u0002\u001b", new Object[]{"zzmf", "zzmt", "zzmu", zzb.class});
                case 4:
                    return zzmv;
                case 5:
                    zziz<zzd> zzizVar2 = zzmk;
                    zziz<zzd> zzizVar3 = zzizVar2;
                    if (zzizVar2 == null) {
                        synchronized (zzd.class) {
                            zziz<zzd> zzizVar4 = zzmk;
                            zzizVar = zzizVar4;
                            if (zzizVar4 == null) {
                                ?? zzcVar = new zzhh.zzc(zzmv);
                                zzmk = zzcVar;
                                zzizVar = zzcVar;
                            }
                        }
                        zzizVar3 = zzizVar;
                    }
                    return zzizVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhh.a((Class<zzd>) zzd.class, zzmv);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zze extends zzhh<zze, zza> implements zzio {
        private static volatile zziz<zze> zzmk;
        private static final zze zznb = new zze();
        private int zzmf;
        private zza zzmw;
        private zza zzmx;
        private zza zzmy;
        private zzc zzmz;
        private zzhn<zzf> zzna = d();

        private zze() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzhh.zza<zze, zza> implements zzio {
            private zza() {
                super(zze.zznb);
            }

            /* synthetic */ zza(az azVar) {
                this();
            }
        }

        public final zza zzdt() {
            zza zzaVar = this.zzmw;
            return zzaVar == null ? zza.zzdm() : zzaVar;
        }

        public final zza zzdu() {
            zza zzaVar = this.zzmx;
            return zzaVar == null ? zza.zzdm() : zzaVar;
        }

        public final zza zzdv() {
            zza zzaVar = this.zzmy;
            return zzaVar == null ? zza.zzdm() : zzaVar;
        }

        public static zze zzb(InputStream inputStream) throws IOException {
            return (zze) zzhh.a(zznb, inputStream);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfe$zze>, com.google.android.gms.internal.firebase_remote_config.zzhh$zzc] */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzhh
        public final Object a(int i, Object obj, Object obj2) {
            zziz<zze> zzizVar;
            az azVar = null;
            switch (az.f4038a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(azVar);
                case 3:
                    return a(zznb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\t\u0000\u0002\t\u0001\u0003\t\u0002\u0004\t\u0003\u0005\u001b", new Object[]{"zzmf", "zzmw", "zzmx", "zzmy", "zzmz", "zzna", zzf.class});
                case 4:
                    return zznb;
                case 5:
                    zziz<zze> zzizVar2 = zzmk;
                    zziz<zze> zzizVar3 = zzizVar2;
                    if (zzizVar2 == null) {
                        synchronized (zze.class) {
                            zziz<zze> zzizVar4 = zzmk;
                            zzizVar = zzizVar4;
                            if (zzizVar4 == null) {
                                ?? zzcVar = new zzhh.zzc(zznb);
                                zzmk = zzcVar;
                                zzizVar = zzcVar;
                            }
                        }
                        zzizVar3 = zzizVar;
                    }
                    return zzizVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhh.a((Class<zze>) zze.class, zznb);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzf extends zzhh<zzf, zza> implements zzio {
        private static volatile zziz<zzf> zzmk;
        private static final zzf zzne = new zzf();
        private int zzmf;
        private String zzmt = "";
        private int zznc;
        private long zznd;

        private zzf() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzhh.zza<zzf, zza> implements zzio {
            private zza() {
                super(zzf.zzne);
            }

            /* synthetic */ zza(az azVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Type inference failed for: r2v14, types: [com.google.android.gms.internal.firebase_remote_config.zzhh$zzc, com.google.android.gms.internal.firebase_remote_config.zziz<com.google.android.gms.internal.firebase_remote_config.zzfe$zzf>] */
        @Override // com.google.android.gms.internal.firebase_remote_config.zzhh
        public final Object a(int i, Object obj, Object obj2) {
            zziz<zzf> zzizVar;
            az azVar = null;
            switch (az.f4038a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(azVar);
                case 3:
                    return a(zzne, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0005\u0001\u0003\b\u0002", new Object[]{"zzmf", "zznc", "zznd", "zzmt"});
                case 4:
                    return zzne;
                case 5:
                    zziz<zzf> zzizVar2 = zzmk;
                    zziz<zzf> zzizVar3 = zzizVar2;
                    if (zzizVar2 == null) {
                        synchronized (zzf.class) {
                            zziz<zzf> zzizVar4 = zzmk;
                            zzizVar = zzizVar4;
                            if (zzizVar4 == null) {
                                ?? zzcVar = new zzhh.zzc(zzne);
                                zzmk = zzcVar;
                                zzizVar = zzcVar;
                            }
                        }
                        zzizVar3 = zzizVar;
                    }
                    return zzizVar3;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzhh.a((Class<zzf>) zzf.class, zzne);
        }
    }
}
