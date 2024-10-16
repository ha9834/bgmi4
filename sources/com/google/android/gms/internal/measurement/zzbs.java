package com.google.android.gms.internal.measurement;

import com.amazonaws.event.ProgressEvent;
import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.BleSignal;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.tencent.mtt.spcialcall.SpecialCallActivity;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbs {

    /* loaded from: classes2.dex */
    public static final class zza extends zzey<zza, C0111zza> implements zzgk {
        private static volatile zzgr<zza> zzuo;
        private static final zza zzwf = new zza();
        private int zzue;
        private int zzwb;
        private zzi zzwc;
        private zzi zzwd;
        private boolean zzwe;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbs$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0111zza extends zzey.zza<zza, C0111zza> implements zzgk {
            private C0111zza() {
                super(zza.zzwf);
            }

            public final C0111zza zzi(int i) {
                a();
                ((zza) this.f4559a).b(i);
                return this;
            }

            public final zzi zzlv() {
                return ((zza) this.f4559a).zzlv();
            }

            public final C0111zza zza(zzi.zza zzaVar) {
                a();
                ((zza) this.f4559a).a(zzaVar);
                return this;
            }

            public final boolean zzlw() {
                return ((zza) this.f4559a).zzlw();
            }

            public final zzi zzlx() {
                return ((zza) this.f4559a).zzlx();
            }

            public final C0111zza zza(zzi zziVar) {
                a();
                ((zza) this.f4559a).a(zziVar);
                return this;
            }

            public final C0111zza zzk(boolean z) {
                a();
                ((zza) this.f4559a).a(z);
                return this;
            }

            /* synthetic */ C0111zza(ap apVar) {
                this();
            }
        }

        public final boolean zzly() {
            return (this.zzue & 1) != 0;
        }

        public final int zzlz() {
            return this.zzwb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzue |= 1;
            this.zzwb = i;
        }

        public final zzi zzlv() {
            zzi zziVar = this.zzwc;
            return zziVar == null ? zzi.zzqi() : zziVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzi.zza zzaVar) {
            this.zzwc = (zzi) ((zzey) zzaVar.zzug());
            this.zzue |= 2;
        }

        public final boolean zzlw() {
            return (this.zzue & 4) != 0;
        }

        public final zzi zzlx() {
            zzi zziVar = this.zzwd;
            return zziVar == null ? zzi.zzqi() : zziVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzi zziVar) {
            if (zziVar == null) {
                throw new NullPointerException();
            }
            this.zzwd = zziVar;
            this.zzue |= 4;
        }

        public final boolean zzma() {
            return (this.zzue & 8) != 0;
        }

        public final boolean zzmb() {
            return this.zzwe;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(boolean z) {
            this.zzue |= 8;
            this.zzwe = z;
        }

        public static C0111zza zzmc() {
            return zzwf.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0111zza(apVar);
                case 3:
                    return a(zzwf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzue", "zzwb", "zzwc", "zzwd", "zzwe"});
                case 4:
                    return zzwf;
                case 5:
                    zzgr<zza> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zza.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzwf);
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

        static {
            zzey.a((Class<zza>) zza.class, zzwf);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzey<zzb, zza> implements zzgk {
        private static volatile zzgr<zzb> zzuo;
        private static final zzb zzwi = new zzb();
        private int zzue;
        private int zzwg;
        private long zzwh;

        private zzb() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzb, zza> implements zzgk {
            private zza() {
                super(zzb.zzwi);
            }

            public final zza zzk(int i) {
                a();
                ((zzb) this.f4559a).b(i);
                return this;
            }

            public final zza zzae(long j) {
                a();
                ((zzb) this.f4559a).a(j);
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        public final boolean zzme() {
            return (this.zzue & 1) != 0;
        }

        public final int getIndex() {
            return this.zzwg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzue |= 1;
            this.zzwg = i;
        }

        public final boolean zzmf() {
            return (this.zzue & 2) != 0;
        }

        public final long zzmg() {
            return this.zzwh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzue |= 2;
            this.zzwh = j;
        }

        public static zza zzmh() {
            return zzwi.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzwi, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001", new Object[]{"zzue", "zzwg", "zzwh"});
                case 4:
                    return zzwi;
                case 5:
                    zzgr<zzb> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzb.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzwi);
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

        static {
            zzey.a((Class<zzb>) zzb.class, zzwi);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzey<zzc, zza> implements zzgk {
        private static volatile zzgr<zzc> zzuo;
        private static final zzc zzwo = new zzc();
        private int zzue;
        private zzff<zze> zzwj = g();
        private String zzwk = "";
        private long zzwl;
        private long zzwm;
        private int zzwn;

        private zzc() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzc, zza> implements zzgk {
            private zza() {
                super(zzc.zzwo);
            }

            public final List<zze> zzmj() {
                return Collections.unmodifiableList(((zzc) this.f4559a).zzmj());
            }

            public final int zzmk() {
                return ((zzc) this.f4559a).zzmk();
            }

            public final zze zzl(int i) {
                return ((zzc) this.f4559a).zzl(i);
            }

            public final zza zza(int i, zze zzeVar) {
                a();
                ((zzc) this.f4559a).a(i, zzeVar);
                return this;
            }

            public final zza zza(int i, zze.zza zzaVar) {
                a();
                ((zzc) this.f4559a).a(i, zzaVar);
                return this;
            }

            public final zza zza(zze zzeVar) {
                a();
                ((zzc) this.f4559a).a(zzeVar);
                return this;
            }

            public final zza zza(zze.zza zzaVar) {
                a();
                ((zzc) this.f4559a).a(zzaVar);
                return this;
            }

            public final zza zzm(int i) {
                a();
                ((zzc) this.f4559a).b(i);
                return this;
            }

            public final String getName() {
                return ((zzc) this.f4559a).getName();
            }

            public final zza zzbx(String str) {
                a();
                ((zzc) this.f4559a).a(str);
                return this;
            }

            public final boolean zzml() {
                return ((zzc) this.f4559a).zzml();
            }

            public final long getTimestampMillis() {
                return ((zzc) this.f4559a).getTimestampMillis();
            }

            public final zza zzag(long j) {
                a();
                ((zzc) this.f4559a).a(j);
                return this;
            }

            public final long zzmm() {
                return ((zzc) this.f4559a).zzmm();
            }

            public final zza zzah(long j) {
                a();
                ((zzc) this.f4559a).b(j);
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        public final List<zze> zzmj() {
            return this.zzwj;
        }

        public final int zzmk() {
            return this.zzwj.size();
        }

        public final zze zzl(int i) {
            return this.zzwj.get(i);
        }

        private final void h() {
            if (this.zzwj.zzrx()) {
                return;
            }
            this.zzwj = zzey.a(this.zzwj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(int i, zze zzeVar) {
            if (zzeVar == null) {
                throw new NullPointerException();
            }
            h();
            this.zzwj.set(i, zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(int i, zze.zza zzaVar) {
            h();
            this.zzwj.set(i, (zze) ((zzey) zzaVar.zzug()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zze zzeVar) {
            if (zzeVar == null) {
                throw new NullPointerException();
            }
            h();
            this.zzwj.add(zzeVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zze.zza zzaVar) {
            h();
            this.zzwj.add((zze) ((zzey) zzaVar.zzug()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            h();
            this.zzwj.remove(i);
        }

        public final String getName() {
            return this.zzwk;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 1;
            this.zzwk = str;
        }

        public final boolean zzml() {
            return (this.zzue & 2) != 0;
        }

        public final long getTimestampMillis() {
            return this.zzwl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzue |= 2;
            this.zzwl = j;
        }

        public final boolean zzmo() {
            return (this.zzue & 4) != 0;
        }

        public final long zzmm() {
            return this.zzwm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(long j) {
            this.zzue |= 4;
            this.zzwm = j;
        }

        public final boolean zzmp() {
            return (this.zzue & 8) != 0;
        }

        public final int getCount() {
            return this.zzwn;
        }

        public static zzc zzc(byte[] bArr, zzel zzelVar) throws zzfi {
            return (zzc) zzey.a(zzwo, bArr, zzelVar);
        }

        public static zza zzmq() {
            return zzwo.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzwo, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\b\u0000\u0003\u0002\u0001\u0004\u0002\u0002\u0005\u0004\u0003", new Object[]{"zzue", "zzwj", zze.class, "zzwk", "zzwl", "zzwm", "zzwn"});
                case 4:
                    return zzwo;
                case 5:
                    zzgr<zzc> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzc.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzwo);
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

        static {
            zzey.a((Class<zzc>) zzc.class, zzwo);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzd extends zzey<zzd, zza> implements zzgk {
        private static volatile zzgr<zzd> zzuo;
        private static final zzd zzwq = new zzd();
        private int zzue;
        private String zzwk = "";
        private long zzwp;

        private zzd() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzd, zza> implements zzgk {
            private zza() {
                super(zzd.zzwq);
            }

            public final zza zzby(String str) {
                a();
                ((zzd) this.f4559a).a(str);
                return this;
            }

            public final zza zzak(long j) {
                a();
                ((zzd) this.f4559a).a(j);
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 1;
            this.zzwk = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzue |= 2;
            this.zzwp = j;
        }

        public static zza zzms() {
            return zzwq.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzwq, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zzue", "zzwk", "zzwp"});
                case 4:
                    return zzwq;
                case 5:
                    zzgr<zzd> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzd.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzwq);
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

        static {
            zzey.a((Class<zzd>) zzd.class, zzwq);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zze extends zzey<zze, zza> implements zzgk {
        private static volatile zzgr<zze> zzuo;
        private static final zze zzwu = new zze();
        private int zzue;
        private long zzwp;
        private float zzws;
        private double zzwt;
        private String zzwk = "";
        private String zzwr = "";

        private zze() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zze, zza> implements zzgk {
            private zza() {
                super(zze.zzwu);
            }

            public final zza zzbz(String str) {
                a();
                ((zze) this.f4559a).a(str);
                return this;
            }

            public final zza zzca(String str) {
                a();
                ((zze) this.f4559a).b(str);
                return this;
            }

            public final zza zzmu() {
                a();
                ((zze) this.f4559a).h();
                return this;
            }

            public final zza zzam(long j) {
                a();
                ((zze) this.f4559a).a(j);
                return this;
            }

            public final zza zzmv() {
                a();
                ((zze) this.f4559a).i();
                return this;
            }

            public final zza zza(double d) {
                a();
                ((zze) this.f4559a).a(d);
                return this;
            }

            public final zza zzmw() {
                a();
                ((zze) this.f4559a).j();
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        public final String getName() {
            return this.zzwk;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 1;
            this.zzwk = str;
        }

        public final boolean zzmx() {
            return (this.zzue & 2) != 0;
        }

        public final String zzmy() {
            return this.zzwr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 2;
            this.zzwr = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            this.zzue &= -3;
            this.zzwr = zzwu.zzwr;
        }

        public final boolean zzna() {
            return (this.zzue & 4) != 0;
        }

        public final long zznb() {
            return this.zzwp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzue |= 4;
            this.zzwp = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i() {
            this.zzue &= -5;
            this.zzwp = 0L;
        }

        public final boolean zznd() {
            return (this.zzue & 16) != 0;
        }

        public final double zzne() {
            return this.zzwt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(double d) {
            this.zzue |= 16;
            this.zzwt = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j() {
            this.zzue &= -17;
            this.zzwt = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public static zza zzng() {
            return zzwu.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzwu, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0001\u0003\u0005\u0000\u0004", new Object[]{"zzue", "zzwk", "zzwr", "zzwp", "zzws", "zzwt"});
                case 4:
                    return zzwu;
                case 5:
                    zzgr<zze> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zze.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzwu);
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

        static {
            zzey.a((Class<zze>) zze.class, zzwu);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzf extends zzey<zzf, zza> implements zzgk {
        private static volatile zzgr<zzf> zzuo;
        private static final zzf zzww = new zzf();
        private zzff<zzg> zzwv = g();

        private zzf() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzf, zza> implements zzgk {
            private zza() {
                super(zzf.zzww);
            }

            public final zzg zzo(int i) {
                return ((zzf) this.f4559a).zzo(0);
            }

            public final zza zza(zzg.zza zzaVar) {
                a();
                ((zzf) this.f4559a).a(zzaVar);
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        public final List<zzg> zzni() {
            return this.zzwv;
        }

        public final zzg zzo(int i) {
            return this.zzwv.get(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzg.zza zzaVar) {
            if (!this.zzwv.zzrx()) {
                this.zzwv = zzey.a(this.zzwv);
            }
            this.zzwv.add((zzg) ((zzey) zzaVar.zzug()));
        }

        public static zza zznj() {
            return zzww.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzww, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzwv", zzg.class});
                case 4:
                    return zzww;
                case 5:
                    zzgr<zzf> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzf.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzww);
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

        static {
            zzey.a((Class<zzf>) zzf.class, zzww);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzg extends zzey<zzg, zza> implements zzgk {
        private static volatile zzgr<zzg> zzuo;
        private static final zzg zzyo = new zzg();
        private int zzue;
        private int zzwx;
        private int zzwy;
        private long zzxb;
        private long zzxc;
        private long zzxd;
        private long zzxe;
        private long zzxf;
        private int zzxk;
        private long zzxo;
        private long zzxp;
        private boolean zzxr;
        private long zzxt;
        private int zzxu;
        private boolean zzxx;
        private int zzya;
        private int zzyb;
        private int zzyc;
        private long zzye;
        private long zzyf;
        private int zzyi;
        private zzh zzyk;
        private long zzym;
        private long zzyn;
        private zzff<zzc> zzwz = g();
        private zzff<zzk> zzxa = g();
        private String zzxg = "";
        private String zzxh = "";
        private String zzxi = "";
        private String zzxj = "";
        private String zzxl = "";
        private String zzxm = "";
        private String zzxn = "";
        private String zzxq = "";
        private String zzxs = "";
        private String zzxv = "";
        private String zzxw = "";
        private zzff<zza> zzxy = g();
        private String zzxz = "";
        private String zzyd = "";
        private String zzyg = "";
        private String zzyh = "";
        private String zzyj = "";
        private zzfd zzyl = e();

        private zzg() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzg, zza> implements zzgk {
            private zza() {
                super(zzg.zzyo);
            }

            public final zza zzp(int i) {
                a();
                ((zzg) this.f4559a).b(1);
                return this;
            }

            public final List<zzc> zznl() {
                return Collections.unmodifiableList(((zzg) this.f4559a).zznl());
            }

            public final int zznm() {
                return ((zzg) this.f4559a).zznm();
            }

            public final zzc zzq(int i) {
                return ((zzg) this.f4559a).zzq(i);
            }

            public final zza zza(int i, zzc.zza zzaVar) {
                a();
                ((zzg) this.f4559a).a(i, zzaVar);
                return this;
            }

            public final zza zza(zzc.zza zzaVar) {
                a();
                ((zzg) this.f4559a).a(zzaVar);
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                a();
                ((zzg) this.f4559a).a(iterable);
                return this;
            }

            public final zza zznn() {
                a();
                ((zzg) this.f4559a).i();
                return this;
            }

            public final zza zzr(int i) {
                a();
                ((zzg) this.f4559a).c(i);
                return this;
            }

            public final List<zzk> zzno() {
                return Collections.unmodifiableList(((zzg) this.f4559a).zzno());
            }

            public final int zznp() {
                return ((zzg) this.f4559a).zznp();
            }

            public final zzk zzs(int i) {
                return ((zzg) this.f4559a).zzs(i);
            }

            public final zza zza(int i, zzk zzkVar) {
                a();
                ((zzg) this.f4559a).a(i, zzkVar);
                return this;
            }

            public final zza zza(zzk zzkVar) {
                a();
                ((zzg) this.f4559a).a(zzkVar);
                return this;
            }

            public final zza zza(zzk.zza zzaVar) {
                a();
                ((zzg) this.f4559a).a(zzaVar);
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                a();
                ((zzg) this.f4559a).b(iterable);
                return this;
            }

            public final zza zzan(long j) {
                a();
                ((zzg) this.f4559a).a(j);
                return this;
            }

            public final long zznq() {
                return ((zzg) this.f4559a).zznq();
            }

            public final zza zzao(long j) {
                a();
                ((zzg) this.f4559a).b(j);
                return this;
            }

            public final long zznr() {
                return ((zzg) this.f4559a).zznr();
            }

            public final zza zzap(long j) {
                a();
                ((zzg) this.f4559a).c(j);
                return this;
            }

            public final zza zzaq(long j) {
                a();
                ((zzg) this.f4559a).d(j);
                return this;
            }

            public final zza zzns() {
                a();
                ((zzg) this.f4559a).k();
                return this;
            }

            public final zza zzar(long j) {
                a();
                ((zzg) this.f4559a).e(j);
                return this;
            }

            public final zza zznt() {
                a();
                ((zzg) this.f4559a).l();
                return this;
            }

            public final zza zzcc(String str) {
                a();
                ((zzg) this.f4559a).a(str);
                return this;
            }

            public final zza zzcd(String str) {
                a();
                ((zzg) this.f4559a).b(str);
                return this;
            }

            public final zza zzce(String str) {
                a();
                ((zzg) this.f4559a).c(str);
                return this;
            }

            public final zza zzcf(String str) {
                a();
                ((zzg) this.f4559a).d(str);
                return this;
            }

            public final zza zzt(int i) {
                a();
                ((zzg) this.f4559a).d(i);
                return this;
            }

            public final zza zzcg(String str) {
                a();
                ((zzg) this.f4559a).e(str);
                return this;
            }

            public final String zzag() {
                return ((zzg) this.f4559a).zzag();
            }

            public final zza zzch(String str) {
                a();
                ((zzg) this.f4559a).f(str);
                return this;
            }

            public final zza zzci(String str) {
                a();
                ((zzg) this.f4559a).g(str);
                return this;
            }

            public final zza zzas(long j) {
                a();
                ((zzg) this.f4559a).f(j);
                return this;
            }

            public final zza zzat(long j) {
                a();
                ((zzg) this.f4559a).g(j);
                return this;
            }

            public final zza zzcj(String str) {
                a();
                ((zzg) this.f4559a).h(str);
                return this;
            }

            public final zza zzm(boolean z) {
                a();
                ((zzg) this.f4559a).a(z);
                return this;
            }

            public final zza zzck(String str) {
                a();
                ((zzg) this.f4559a).i(str);
                return this;
            }

            public final zza zzau(long j) {
                a();
                ((zzg) this.f4559a).h(j);
                return this;
            }

            public final zza zzu(int i) {
                a();
                ((zzg) this.f4559a).e(i);
                return this;
            }

            public final zza zzcl(String str) {
                a();
                ((zzg) this.f4559a).j(str);
                return this;
            }

            public final zza zznu() {
                a();
                ((zzg) this.f4559a).m();
                return this;
            }

            public final String getGmpAppId() {
                return ((zzg) this.f4559a).getGmpAppId();
            }

            public final zza zzcm(String str) {
                a();
                ((zzg) this.f4559a).k(str);
                return this;
            }

            public final zza zzn(boolean z) {
                a();
                ((zzg) this.f4559a).b(z);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                a();
                ((zzg) this.f4559a).c(iterable);
                return this;
            }

            public final zza zznv() {
                a();
                ((zzg) this.f4559a).n();
                return this;
            }

            public final zza zzcn(String str) {
                a();
                ((zzg) this.f4559a).l(str);
                return this;
            }

            public final zza zzv(int i) {
                a();
                ((zzg) this.f4559a).f(i);
                return this;
            }

            public final zza zzco(String str) {
                a();
                ((zzg) this.f4559a).m(str);
                return this;
            }

            public final zza zzav(long j) {
                a();
                ((zzg) this.f4559a).i(j);
                return this;
            }

            public final zza zzaw(long j) {
                a();
                ((zzg) this.f4559a).j(j);
                return this;
            }

            public final zza zzcp(String str) {
                a();
                ((zzg) this.f4559a).n(null);
                return this;
            }

            public final zza zznw() {
                a();
                ((zzg) this.f4559a).o();
                return this;
            }

            public final zza zzw(int i) {
                a();
                ((zzg) this.f4559a).g(i);
                return this;
            }

            public final zza zzcq(String str) {
                a();
                ((zzg) this.f4559a).o(str);
                return this;
            }

            public final zza zza(zzh.zza zzaVar) {
                a();
                ((zzg) this.f4559a).a(zzaVar);
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                a();
                ((zzg) this.f4559a).d(iterable);
                return this;
            }

            public final zza zzax(long j) {
                a();
                ((zzg) this.f4559a).k(j);
                return this;
            }

            public final zza zzay(long j) {
                a();
                ((zzg) this.f4559a).l(j);
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        public final boolean zznx() {
            return (this.zzue & 1) != 0;
        }

        public final int zzny() {
            return this.zzwy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzue |= 1;
            this.zzwy = i;
        }

        public final List<zzc> zznl() {
            return this.zzwz;
        }

        public final int zznm() {
            return this.zzwz.size();
        }

        public final zzc zzq(int i) {
            return this.zzwz.get(i);
        }

        private final void h() {
            if (this.zzwz.zzrx()) {
                return;
            }
            this.zzwz = zzey.a(this.zzwz);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(int i, zzc.zza zzaVar) {
            h();
            this.zzwz.set(i, (zzc) ((zzey) zzaVar.zzug()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzc.zza zzaVar) {
            h();
            this.zzwz.add((zzc) ((zzey) zzaVar.zzug()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(Iterable<? extends zzc> iterable) {
            h();
            zzdf.a(iterable, this.zzwz);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i() {
            this.zzwz = g();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(int i) {
            h();
            this.zzwz.remove(i);
        }

        public final List<zzk> zzno() {
            return this.zzxa;
        }

        public final int zznp() {
            return this.zzxa.size();
        }

        public final zzk zzs(int i) {
            return this.zzxa.get(i);
        }

        private final void j() {
            if (this.zzxa.zzrx()) {
                return;
            }
            this.zzxa = zzey.a(this.zzxa);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(int i, zzk zzkVar) {
            if (zzkVar == null) {
                throw new NullPointerException();
            }
            j();
            this.zzxa.set(i, zzkVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzk zzkVar) {
            if (zzkVar == null) {
                throw new NullPointerException();
            }
            j();
            this.zzxa.add(zzkVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzk.zza zzaVar) {
            j();
            this.zzxa.add((zzk) ((zzey) zzaVar.zzug()));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(Iterable<? extends zzk> iterable) {
            j();
            zzdf.a(iterable, this.zzxa);
        }

        public final boolean zzoc() {
            return (this.zzue & 2) != 0;
        }

        public final long zzod() {
            return this.zzxb;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzue |= 2;
            this.zzxb = j;
        }

        public final boolean zzoe() {
            return (this.zzue & 4) != 0;
        }

        public final long zznq() {
            return this.zzxc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(long j) {
            this.zzue |= 4;
            this.zzxc = j;
        }

        public final boolean zzof() {
            return (this.zzue & 8) != 0;
        }

        public final long zznr() {
            return this.zzxd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(long j) {
            this.zzue |= 8;
            this.zzxd = j;
        }

        public final boolean zzog() {
            return (this.zzue & 16) != 0;
        }

        public final long zzoh() {
            return this.zzxe;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(long j) {
            this.zzue |= 16;
            this.zzxe = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k() {
            this.zzue &= -17;
            this.zzxe = 0L;
        }

        public final boolean zzoj() {
            return (this.zzue & 32) != 0;
        }

        public final long zzok() {
            return this.zzxf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(long j) {
            this.zzue |= 32;
            this.zzxf = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l() {
            this.zzue &= -33;
            this.zzxf = 0L;
        }

        public final String zzom() {
            return this.zzxg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 64;
            this.zzxg = str;
        }

        public final String getOsVersion() {
            return this.zzxh;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 128;
            this.zzxh = str;
        }

        public final String zzon() {
            return this.zzxi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 256;
            this.zzxi = str;
        }

        public final String zzcr() {
            return this.zzxj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 512;
            this.zzxj = str;
        }

        public final boolean zzoo() {
            return (this.zzue & 1024) != 0;
        }

        public final int zzop() {
            return this.zzxk;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(int i) {
            this.zzue |= 1024;
            this.zzxk = i;
        }

        public final String zzan() {
            return this.zzxl;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= ProgressEvent.PART_COMPLETED_EVENT_CODE;
            this.zzxl = str;
        }

        public final String zzag() {
            return this.zzxm;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 4096;
            this.zzxm = str;
        }

        public final String zzal() {
            return this.zzxn;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 8192;
            this.zzxn = str;
        }

        public final boolean zzoq() {
            return (this.zzue & 16384) != 0;
        }

        public final long zzao() {
            return this.zzxo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(long j) {
            this.zzue |= 16384;
            this.zzxo = j;
        }

        public final boolean zzor() {
            return (this.zzue & Connections.MAX_BYTES_DATA_SIZE) != 0;
        }

        public final long zzos() {
            return this.zzxp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(long j) {
            this.zzue |= Connections.MAX_BYTES_DATA_SIZE;
            this.zzxp = j;
        }

        public final String zzot() {
            return this.zzxq;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 65536;
            this.zzxq = str;
        }

        public final boolean zzou() {
            return (this.zzue & 131072) != 0;
        }

        public final boolean zzov() {
            return this.zzxr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(boolean z) {
            this.zzue |= 131072;
            this.zzxr = z;
        }

        public final String getAppInstanceId() {
            return this.zzxs;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 262144;
            this.zzxs = str;
        }

        public final boolean zzow() {
            return (this.zzue & 524288) != 0;
        }

        public final long zzap() {
            return this.zzxt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(long j) {
            this.zzue |= 524288;
            this.zzxt = j;
        }

        public final boolean zzox() {
            return (this.zzue & Constants.MB) != 0;
        }

        public final int zzoy() {
            return this.zzxu;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(int i) {
            this.zzue |= Constants.MB;
            this.zzxu = i;
        }

        public final String zzoz() {
            return this.zzxv;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 2097152;
            this.zzxv = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void m() {
            this.zzue &= -2097153;
            this.zzxv = zzyo.zzxv;
        }

        public final String getGmpAppId() {
            return this.zzxw;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 4194304;
            this.zzxw = str;
        }

        public final boolean zzpb() {
            return (this.zzue & 8388608) != 0;
        }

        public final boolean zzpc() {
            return this.zzxx;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(boolean z) {
            this.zzue |= 8388608;
            this.zzxx = z;
        }

        public final List<zza> zzpd() {
            return this.zzxy;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(Iterable<? extends zza> iterable) {
            if (!this.zzxy.zzrx()) {
                this.zzxy = zzey.a(this.zzxy);
            }
            zzdf.a(iterable, this.zzxy);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n() {
            this.zzxy = g();
        }

        public final String getFirebaseInstanceId() {
            return this.zzxz;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= SpecialCallActivity.FLAG_HARDWARE_ACCELERATED;
            this.zzxz = str;
        }

        public final boolean zzpf() {
            return (this.zzue & 33554432) != 0;
        }

        public final int zzpg() {
            return this.zzya;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void f(int i) {
            this.zzue |= 33554432;
            this.zzya = i;
        }

        public final String zzph() {
            return this.zzyd;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void m(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= DriveFile.MODE_READ_ONLY;
            this.zzyd = str;
        }

        public final boolean zzpi() {
            return (this.zzue & DriveFile.MODE_WRITE_ONLY) != 0;
        }

        public final long zzpj() {
            return this.zzye;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i(long j) {
            this.zzue |= DriveFile.MODE_WRITE_ONLY;
            this.zzye = j;
        }

        public final boolean zzpk() {
            return (this.zzue & 1073741824) != 0;
        }

        public final long zzbd() {
            return this.zzyf;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j(long j) {
            this.zzue |= 1073741824;
            this.zzyf = j;
        }

        public final String zzpl() {
            return this.zzyg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void n(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= BleSignal.UNKNOWN_TX_POWER;
            this.zzyg = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o() {
            this.zzue &= Integer.MAX_VALUE;
            this.zzyg = zzyo.zzyg;
        }

        public final boolean zzpn() {
            return (this.zzwx & 2) != 0;
        }

        public final int zzpo() {
            return this.zzyi;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g(int i) {
            this.zzwx |= 2;
            this.zzyi = i;
        }

        public final String zzpp() {
            return this.zzyj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzwx |= 4;
            this.zzyj = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzh.zza zzaVar) {
            this.zzyk = (zzh) ((zzey) zzaVar.zzug());
            this.zzwx |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(Iterable<? extends Integer> iterable) {
            if (!this.zzyl.zzrx()) {
                zzfd zzfdVar = this.zzyl;
                int size = zzfdVar.size();
                this.zzyl = zzfdVar.zzap(size == 0 ? 10 : size << 1);
            }
            zzdf.a(iterable, this.zzyl);
        }

        public final boolean zzpq() {
            return (this.zzwx & 16) != 0;
        }

        public final long zzaq() {
            return this.zzym;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void k(long j) {
            this.zzwx |= 16;
            this.zzym = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void l(long j) {
            this.zzwx |= 32;
            this.zzyn = j;
        }

        public static zzg zzd(byte[] bArr, zzel zzelVar) throws zzfi {
            return (zzg) zzey.a(zzyo, bArr, zzelVar);
        }

        public static zza zzpr() {
            return zzyo.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzyo, "\u0001*\u0000\u0002\u0001/*\u0000\u0004\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0002\u0001\u0005\u0002\u0002\u0006\u0002\u0003\u0007\u0002\u0005\b\b\u0006\t\b\u0007\n\b\b\u000b\b\t\f\u0004\n\r\b\u000b\u000e\b\f\u0010\b\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\u0002\u0013\u0017\u0004\u0014\u0018\b\u0015\u0019\b\u0016\u001a\u0002\u0004\u001c\u0007\u0017\u001d\u001b\u001e\b\u0018\u001f\u0004\u0019 \u0004\u001a!\u0004\u001b\"\b\u001c#\u0002\u001d$\u0002\u001e%\b\u001f&\b '\u0004!)\b\",\t#-\u001d.\u0002$/\u0002%", new Object[]{"zzue", "zzwx", "zzwy", "zzwz", zzc.class, "zzxa", zzk.class, "zzxb", "zzxc", "zzxd", "zzxf", "zzxg", "zzxh", "zzxi", "zzxj", "zzxk", "zzxl", "zzxm", "zzxn", "zzxo", "zzxp", "zzxq", "zzxr", "zzxs", "zzxt", "zzxu", "zzxv", "zzxw", "zzxe", "zzxx", "zzxy", zza.class, "zzxz", "zzya", "zzyb", "zzyc", "zzyd", "zzye", "zzyf", "zzyg", "zzyh", "zzyi", "zzyj", "zzyk", "zzyl", "zzym", "zzyn"});
                case 4:
                    return zzyo;
                case 5:
                    zzgr<zzg> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzg.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzyo);
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

        static {
            zzey.a((Class<zzg>) zzg.class, zzyo);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzh extends zzey<zzh, zza> implements zzgk {
        private static volatile zzgr<zzh> zzuo;
        private static final zzh zzyr = new zzh();
        private int zzue;
        private int zzyp = 1;
        private zzff<zzd> zzyq = g();

        /* loaded from: classes2.dex */
        public enum zzb implements zzfc {
            RADS(1),
            PROVISIONING(2);

            private static final zzfb<zzb> c = new aq();
            private final int value;

            @Override // com.google.android.gms.internal.measurement.zzfc
            public final int zzlg() {
                return this.value;
            }

            public static zzb zzad(int i) {
                switch (i) {
                    case 1:
                        return RADS;
                    case 2:
                        return PROVISIONING;
                    default:
                        return null;
                }
            }

            public static zzfe zzlh() {
                return ar.f4477a;
            }

            zzb(int i) {
                this.value = i;
            }
        }

        private zzh() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzh, zza> implements zzgk {
            private zza() {
                super(zzh.zzyr);
            }

            public final zza zza(zzd.zza zzaVar) {
                a();
                ((zzh) this.f4559a).a(zzaVar);
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(zzd.zza zzaVar) {
            if (!this.zzyq.zzrx()) {
                this.zzyq = zzey.a(this.zzyq);
            }
            this.zzyq.add((zzd) ((zzey) zzaVar.zzug()));
        }

        public static zza zzpt() {
            return zzyr.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzyr, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzue", "zzyp", zzb.zzlh(), "zzyq", zzd.class});
                case 4:
                    return zzyr;
                case 5:
                    zzgr<zzh> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzh.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzyr);
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

        static {
            zzey.a((Class<zzh>) zzh.class, zzyr);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzi extends zzey<zzi, zza> implements zzgk {
        private static volatile zzgr<zzi> zzuo;
        private static final zzi zzyz = new zzi();
        private zzfg zzyv = f();
        private zzfg zzyw = f();
        private zzff<zzb> zzyx = g();
        private zzff<zzj> zzyy = g();

        private zzi() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzi, zza> implements zzgk {
            private zza() {
                super(zzi.zzyz);
            }

            public final zza zzn(Iterable<? extends Long> iterable) {
                a();
                ((zzi) this.f4559a).a(iterable);
                return this;
            }

            public final zza zzqq() {
                a();
                ((zzi) this.f4559a).h();
                return this;
            }

            public final zza zzo(Iterable<? extends Long> iterable) {
                a();
                ((zzi) this.f4559a).b(iterable);
                return this;
            }

            public final zza zzqr() {
                a();
                ((zzi) this.f4559a).i();
                return this;
            }

            public final zza zzp(Iterable<? extends zzb> iterable) {
                a();
                ((zzi) this.f4559a).c(iterable);
                return this;
            }

            public final zza zzaj(int i) {
                a();
                ((zzi) this.f4559a).b(i);
                return this;
            }

            public final zza zzq(Iterable<? extends zzj> iterable) {
                a();
                ((zzi) this.f4559a).d(iterable);
                return this;
            }

            public final zza zzak(int i) {
                a();
                ((zzi) this.f4559a).c(i);
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        public final List<Long> zzpv() {
            return this.zzyv;
        }

        public final int zzpw() {
            return this.zzyv.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(Iterable<? extends Long> iterable) {
            if (!this.zzyv.zzrx()) {
                this.zzyv = zzey.a(this.zzyv);
            }
            zzdf.a(iterable, this.zzyv);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            this.zzyv = f();
        }

        public final List<Long> zzpy() {
            return this.zzyw;
        }

        public final int zzpz() {
            return this.zzyw.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(Iterable<? extends Long> iterable) {
            if (!this.zzyw.zzrx()) {
                this.zzyw = zzey.a(this.zzyw);
            }
            zzdf.a(iterable, this.zzyw);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i() {
            this.zzyw = f();
        }

        public final List<zzb> zzqb() {
            return this.zzyx;
        }

        public final int zzqc() {
            return this.zzyx.size();
        }

        public final zzb zzae(int i) {
            return this.zzyx.get(i);
        }

        private final void j() {
            if (this.zzyx.zzrx()) {
                return;
            }
            this.zzyx = zzey.a(this.zzyx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(Iterable<? extends zzb> iterable) {
            j();
            zzdf.a(iterable, this.zzyx);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            j();
            this.zzyx.remove(i);
        }

        public final List<zzj> zzqe() {
            return this.zzyy;
        }

        public final int zzqf() {
            return this.zzyy.size();
        }

        public final zzj zzag(int i) {
            return this.zzyy.get(i);
        }

        private final void k() {
            if (this.zzyy.zzrx()) {
                return;
            }
            this.zzyy = zzey.a(this.zzyy);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d(Iterable<? extends zzj> iterable) {
            k();
            zzdf.a(iterable, this.zzyy);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void c(int i) {
            k();
            this.zzyy.remove(i);
        }

        public static zzi zze(byte[] bArr, zzel zzelVar) throws zzfi {
            return (zzi) zzey.a(zzyz, bArr, zzelVar);
        }

        public static zza zzqh() {
            return zzyz.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzyz, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzyv", "zzyw", "zzyx", zzb.class, "zzyy", zzj.class});
                case 4:
                    return zzyz;
                case 5:
                    zzgr<zzi> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzi.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzyz);
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

        public static zzi zzqi() {
            return zzyz;
        }

        static {
            zzey.a((Class<zzi>) zzi.class, zzyz);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzj extends zzey<zzj, zza> implements zzgk {
        private static volatile zzgr<zzj> zzuo;
        private static final zzj zzzb = new zzj();
        private int zzue;
        private int zzwg;
        private zzfg zzza = f();

        private zzj() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzj, zza> implements zzgk {
            private zza() {
                super(zzj.zzzb);
            }

            public final zza zzal(int i) {
                a();
                ((zzj) this.f4559a).b(i);
                return this;
            }

            public final zza zzbj(long j) {
                a();
                ((zzj) this.f4559a).a(j);
                return this;
            }

            public final zza zzr(Iterable<? extends Long> iterable) {
                a();
                ((zzj) this.f4559a).a(iterable);
                return this;
            }

            public final zza zzqw() {
                a();
                ((zzj) this.f4559a).i();
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        public final boolean zzme() {
            return (this.zzue & 1) != 0;
        }

        public final int getIndex() {
            return this.zzwg;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(int i) {
            this.zzue |= 1;
            this.zzwg = i;
        }

        public final List<Long> zzqk() {
            return this.zzza;
        }

        public final int zzql() {
            return this.zzza.size();
        }

        public final long zzai(int i) {
            return this.zzza.getLong(i);
        }

        private final void h() {
            if (this.zzza.zzrx()) {
                return;
            }
            this.zzza = zzey.a(this.zzza);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            h();
            this.zzza.zzby(j);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(Iterable<? extends Long> iterable) {
            h();
            zzdf.a(iterable, this.zzza);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i() {
            this.zzza = f();
        }

        public static zza zzqo() {
            return zzzb.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0014", new Object[]{"zzue", "zzwg", "zzza"});
                case 4:
                    return zzzb;
                case 5:
                    zzgr<zzj> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzj.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzzb);
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

        static {
            zzey.a((Class<zzj>) zzj.class, zzzb);
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzk extends zzey<zzk, zza> implements zzgk {
        private static volatile zzgr<zzk> zzuo;
        private static final zzk zzzd = new zzk();
        private int zzue;
        private long zzwp;
        private float zzws;
        private double zzwt;
        private long zzzc;
        private String zzwk = "";
        private String zzwr = "";

        private zzk() {
        }

        /* loaded from: classes2.dex */
        public static final class zza extends zzey.zza<zzk, zza> implements zzgk {
            private zza() {
                super(zzk.zzzd);
            }

            public final zza zzbk(long j) {
                a();
                ((zzk) this.f4559a).a(j);
                return this;
            }

            public final zza zzdb(String str) {
                a();
                ((zzk) this.f4559a).a(str);
                return this;
            }

            public final zza zzdc(String str) {
                a();
                ((zzk) this.f4559a).b(str);
                return this;
            }

            public final zza zzqz() {
                a();
                ((zzk) this.f4559a).h();
                return this;
            }

            public final zza zzbl(long j) {
                a();
                ((zzk) this.f4559a).b(j);
                return this;
            }

            public final zza zzra() {
                a();
                ((zzk) this.f4559a).i();
                return this;
            }

            public final zza zzc(double d) {
                a();
                ((zzk) this.f4559a).a(d);
                return this;
            }

            public final zza zzrb() {
                a();
                ((zzk) this.f4559a).j();
                return this;
            }

            /* synthetic */ zza(ap apVar) {
                this();
            }
        }

        public final boolean zzqs() {
            return (this.zzue & 1) != 0;
        }

        public final long zzqt() {
            return this.zzzc;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(long j) {
            this.zzue |= 1;
            this.zzzc = j;
        }

        public final String getName() {
            return this.zzwk;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 2;
            this.zzwk = str;
        }

        public final boolean zzmx() {
            return (this.zzue & 4) != 0;
        }

        public final String zzmy() {
            return this.zzwr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(String str) {
            if (str == null) {
                throw new NullPointerException();
            }
            this.zzue |= 4;
            this.zzwr = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            this.zzue &= -5;
            this.zzwr = zzzd.zzwr;
        }

        public final boolean zzna() {
            return (this.zzue & 8) != 0;
        }

        public final long zznb() {
            return this.zzwp;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void b(long j) {
            this.zzue |= 8;
            this.zzwp = j;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i() {
            this.zzue &= -9;
            this.zzwp = 0L;
        }

        public final boolean zznd() {
            return (this.zzue & 32) != 0;
        }

        public final double zzne() {
            return this.zzwt;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void a(double d) {
            this.zzue |= 32;
            this.zzwt = d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void j() {
            this.zzue &= -33;
            this.zzwt = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public static zza zzqu() {
            return zzzd.d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.measurement.zzey
        public final Object a(int i, Object obj, Object obj2) {
            ap apVar = null;
            switch (ap.f4476a[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza(apVar);
                case 3:
                    return a(zzzd, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0001\u0004\u0006\u0000\u0005", new Object[]{"zzue", "zzzc", "zzwk", "zzwr", "zzwp", "zzws", "zzwt"});
                case 4:
                    return zzzd;
                case 5:
                    zzgr<zzk> zzgrVar = zzuo;
                    if (zzgrVar == null) {
                        synchronized (zzk.class) {
                            zzgrVar = zzuo;
                            if (zzgrVar == null) {
                                zzgrVar = new zzey.zzc<>(zzzd);
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

        static {
            zzey.a((Class<zzk>) zzk.class, zzzd);
        }
    }
}
