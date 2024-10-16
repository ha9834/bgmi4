package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.amazonaws.services.s3.Headers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbs;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzey;
import com.google.android.gms.nearby.messages.BleSignal;
import com.tencent.connect.common.Constants;
import com.tencent.smtt.sdk.TbsListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class zzjg implements eg {

    /* renamed from: a, reason: collision with root package name */
    private static volatile zzjg f4952a;
    private zzfd b;
    private zzej c;
    private he d;
    private cx e;
    private zzjc f;
    private hb g;
    private final zzjo h;
    private ff i;
    private final zzfj j;
    private boolean k;
    private boolean l;
    private boolean m;

    @VisibleForTesting
    private long n;
    private List<Runnable> o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private FileLock u;
    private FileChannel v;
    private List<Long> w;
    private List<Long> x;
    private long y;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements hg {

        /* renamed from: a, reason: collision with root package name */
        zzbs.zzg f4953a;
        List<Long> b;
        List<zzbs.zzc> c;
        private long d;

        private a() {
        }

        @Override // com.google.android.gms.measurement.internal.hg
        public final void a(zzbs.zzg zzgVar) {
            Preconditions.checkNotNull(zzgVar);
            this.f4953a = zzgVar;
        }

        @Override // com.google.android.gms.measurement.internal.hg
        public final boolean a(long j, zzbs.zzc zzcVar) {
            Preconditions.checkNotNull(zzcVar);
            if (this.c == null) {
                this.c = new ArrayList();
            }
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (this.c.size() > 0 && a(this.c.get(0)) != a(zzcVar)) {
                return false;
            }
            long zzuk = this.d + zzcVar.zzuk();
            if (zzuk >= Math.max(0, zzak.zzgn.get(null).intValue())) {
                return false;
            }
            this.d = zzuk;
            this.c.add(zzcVar);
            this.b.add(Long.valueOf(j));
            return this.c.size() < Math.max(1, zzak.zzgo.get(null).intValue());
        }

        private static long a(zzbs.zzc zzcVar) {
            return ((zzcVar.getTimestampMillis() / 1000) / 60) / 60;
        }

        /* synthetic */ a(zzjg zzjgVar, gs gsVar) {
            this();
        }
    }

    public static zzjg zzm(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f4952a == null) {
            synchronized (zzjg.class) {
                if (f4952a == null) {
                    f4952a = new zzjg(new zzjm(context));
                }
            }
        }
        return f4952a;
    }

    private zzjg(zzjm zzjmVar) {
        this(zzjmVar, null);
    }

    private zzjg(zzjm zzjmVar, zzfj zzfjVar) {
        this.k = false;
        Preconditions.checkNotNull(zzjmVar);
        this.j = zzfj.zza(zzjmVar.f4954a, null);
        this.y = -1L;
        zzjo zzjoVar = new zzjo(this);
        zzjoVar.initialize();
        this.h = zzjoVar;
        zzej zzejVar = new zzej(this);
        zzejVar.initialize();
        this.c = zzejVar;
        zzfd zzfdVar = new zzfd(this);
        zzfdVar.initialize();
        this.b = zzfdVar;
        this.j.zzaa().zza(new gs(this, zzjmVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(zzjm zzjmVar) {
        this.j.zzaa().zzo();
        he heVar = new he(this);
        heVar.initialize();
        this.d = heVar;
        this.j.zzad().a(this.b);
        hb hbVar = new hb(this);
        hbVar.initialize();
        this.g = hbVar;
        ff ffVar = new ff(this);
        ffVar.initialize();
        this.i = ffVar;
        zzjc zzjcVar = new zzjc(this);
        zzjcVar.initialize();
        this.f = zzjcVar;
        this.e = new cx(this);
        if (this.p != this.q) {
            this.j.zzab().zzgk().zza("Not all upload components initialized", Integer.valueOf(this.p), Integer.valueOf(this.q));
        }
        this.k = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a() {
        this.j.zzaa().zzo();
        zzgy().j();
        if (this.j.zzac().c.get() == 0) {
            this.j.zzac().c.set(this.j.zzx().currentTimeMillis());
        }
        l();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final zzr zzae() {
        return this.j.zzae();
    }

    public final zzs zzad() {
        return this.j.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final zzef zzab() {
        return this.j.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final zzfc zzaa() {
        return this.j.zzaa();
    }

    public final zzfd zzgz() {
        b(this.b);
        return this.b;
    }

    public final zzej zzjf() {
        b(this.c);
        return this.c;
    }

    public final he zzgy() {
        b(this.d);
        return this.d;
    }

    private final cx g() {
        cx cxVar = this.e;
        if (cxVar != null) {
            return cxVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjc h() {
        b(this.f);
        return this.f;
    }

    public final hb zzgx() {
        b(this.g);
        return this.g;
    }

    public final ff zzji() {
        b(this.i);
        return this.i;
    }

    public final zzjo zzgw() {
        b(this.h);
        return this.h;
    }

    public final zzed zzy() {
        return this.j.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final Context getContext() {
        return this.j.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.eg
    public final Clock zzx() {
        return this.j.zzx();
    }

    public final zzjs zzz() {
        return this.j.zzz();
    }

    private final void i() {
        this.j.zzaa().zzo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        if (!this.k) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void b(gq gqVar) {
        if (gqVar == null) {
            throw new IllegalStateException("Upload Component not created");
        }
        if (gqVar.b()) {
            return;
        }
        String valueOf = String.valueOf(gqVar.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzn zznVar) {
        i();
        b();
        Preconditions.checkNotEmpty(zznVar.packageName);
        e(zznVar);
    }

    private final long j() {
        long currentTimeMillis = this.j.zzx().currentTimeMillis();
        cz zzac = this.j.zzac();
        zzac.l();
        zzac.zzo();
        long j = zzac.g.get();
        if (j == 0) {
            j = 1 + zzac.zzz().c().nextInt(86400000);
            zzac.g.set(j);
        }
        return ((((currentTimeMillis + j) / 1000) / 60) / 60) / 24;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzai zzaiVar, String str) {
        de b = zzgy().b(str);
        if (b == null || TextUtils.isEmpty(b.j())) {
            this.j.zzab().zzgr().zza("No app data available; dropping event", str);
            return;
        }
        Boolean b2 = b(b);
        if (b2 == null) {
            if (!"_ui".equals(zzaiVar.name)) {
                this.j.zzab().zzgn().zza("Could not find package. appId", zzef.a(str));
            }
        } else if (!b2.booleanValue()) {
            this.j.zzab().zzgk().zza("App version does not match; dropping event. appId", zzef.a(str));
            return;
        }
        a(zzaiVar, new zzn(str, b.d(), b.j(), b.k(), b.l(), b.m(), b.n(), (String) null, b.p(), false, b.g(), b.C(), 0L, 0, b.D(), b.E(), false, b.e(), b.F(), b.o(), b.G()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(zzai zzaiVar, zzn zznVar) {
        List<zzq> a2;
        List<zzq> a3;
        List<zzq> a4;
        zzai zzaiVar2 = zzaiVar;
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.packageName);
        i();
        b();
        String str = zznVar.packageName;
        long j = zzaiVar2.zzfu;
        if (zzgw().a(zzaiVar2, zznVar)) {
            if (!zznVar.zzcq) {
                e(zznVar);
                return;
            }
            if (this.j.zzad().zze(str, zzak.zzix) && zznVar.zzcw != null) {
                if (zznVar.zzcw.contains(zzaiVar2.name)) {
                    Bundle zzcv = zzaiVar2.zzfq.zzcv();
                    zzcv.putLong("ga_safelisted", 1L);
                    zzaiVar2 = new zzai(zzaiVar2.name, new zzah(zzcv), zzaiVar2.origin, zzaiVar2.zzfu);
                } else {
                    this.j.zzab().zzgr().zza("Dropping non-safelisted event. appId, event name, origin", str, zzaiVar2.name, zzaiVar2.origin);
                    return;
                }
            }
            zzgy().d();
            try {
                he zzgy = zzgy();
                Preconditions.checkNotEmpty(str);
                zzgy.zzo();
                zzgy.c();
                if (j < 0) {
                    zzgy.zzab().zzgn().zza("Invalid time querying timed out conditional properties", zzef.a(str), Long.valueOf(j));
                    a2 = Collections.emptyList();
                } else {
                    a2 = zzgy.a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzq zzqVar : a2) {
                    if (zzqVar != null) {
                        this.j.zzab().zzgr().zza("User property timed out", zzqVar.packageName, this.j.zzy().c(zzqVar.zzdw.name), zzqVar.zzdw.getValue());
                        if (zzqVar.zzdx != null) {
                            b(new zzai(zzqVar.zzdx, j), zznVar);
                        }
                        zzgy().e(str, zzqVar.zzdw.name);
                    }
                }
                he zzgy2 = zzgy();
                Preconditions.checkNotEmpty(str);
                zzgy2.zzo();
                zzgy2.c();
                if (j < 0) {
                    zzgy2.zzab().zzgn().zza("Invalid time querying expired conditional properties", zzef.a(str), Long.valueOf(j));
                    a3 = Collections.emptyList();
                } else {
                    a3 = zzgy2.a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(a3.size());
                for (zzq zzqVar2 : a3) {
                    if (zzqVar2 != null) {
                        this.j.zzab().zzgr().zza("User property expired", zzqVar2.packageName, this.j.zzy().c(zzqVar2.zzdw.name), zzqVar2.zzdw.getValue());
                        zzgy().b(str, zzqVar2.zzdw.name);
                        if (zzqVar2.zzdz != null) {
                            arrayList.add(zzqVar2.zzdz);
                        }
                        zzgy().e(str, zzqVar2.zzdw.name);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    b(new zzai((zzai) obj, j), zznVar);
                }
                he zzgy3 = zzgy();
                String str2 = zzaiVar2.name;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zzgy3.zzo();
                zzgy3.c();
                if (j < 0) {
                    zzgy3.zzab().zzgn().zza("Invalid time querying triggered conditional properties", zzef.a(str), zzgy3.zzy().a(str2), Long.valueOf(j));
                    a4 = Collections.emptyList();
                } else {
                    a4 = zzgy3.a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(a4.size());
                for (zzq zzqVar3 : a4) {
                    if (zzqVar3 != null) {
                        zzjn zzjnVar = zzqVar3.zzdw;
                        gv gvVar = new gv(zzqVar3.packageName, zzqVar3.origin, zzjnVar.name, j, zzjnVar.getValue());
                        if (zzgy().a(gvVar)) {
                            this.j.zzab().zzgr().zza("User property triggered", zzqVar3.packageName, this.j.zzy().c(gvVar.c), gvVar.e);
                        } else {
                            this.j.zzab().zzgk().zza("Too many active user properties, ignoring", zzef.a(zzqVar3.packageName), this.j.zzy().c(gvVar.c), gvVar.e);
                        }
                        if (zzqVar3.zzdy != null) {
                            arrayList3.add(zzqVar3.zzdy);
                        }
                        zzqVar3.zzdw = new zzjn(gvVar);
                        zzqVar3.active = true;
                        zzgy().a(zzqVar3);
                    }
                }
                b(zzaiVar2, zznVar);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    b(new zzai((zzai) obj2, j), zznVar);
                }
                zzgy().e();
            } finally {
                zzgy().f();
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:220|(1:222)(1:257)|223|(3:228|229|(1:231))|237|238|239|240|241|242|243|244|245|246|229|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x0241, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x024b, code lost:
    
        r6.zzab().zzgk().zza("Error pruning currencies. appId", com.google.android.gms.measurement.internal.zzef.a(r15), r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0243, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x0245, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0281 A[Catch: all -> 0x08d4, TryCatch #0 {all -> 0x08d4, blocks: (B:35:0x0104, B:37:0x0111, B:41:0x02cd, B:43:0x030d, B:45:0x0312, B:46:0x032b, B:50:0x033c, B:52:0x0352, B:54:0x0357, B:55:0x0372, B:60:0x0396, B:64:0x03bc, B:65:0x03d5, B:68:0x03e5, B:70:0x0404, B:71:0x0422, B:73:0x042c, B:75:0x043a, B:77:0x0448, B:79:0x044e, B:80:0x045b, B:82:0x0465, B:84:0x0475, B:86:0x0483, B:87:0x048e, B:89:0x049a, B:90:0x04b1, B:92:0x04d5, B:95:0x04e5, B:98:0x0521, B:99:0x0549, B:101:0x0583, B:102:0x0588, B:104:0x0590, B:105:0x0595, B:107:0x059d, B:108:0x05a2, B:110:0x05ab, B:111:0x05b1, B:113:0x05be, B:114:0x05c3, B:116:0x05d1, B:118:0x05db, B:120:0x05e3, B:121:0x05f6, B:123:0x05fe, B:124:0x0603, B:126:0x0618, B:128:0x0622, B:129:0x0625, B:131:0x0633, B:133:0x063d, B:135:0x0641, B:137:0x064c, B:138:0x06ba, B:140:0x0702, B:142:0x0708, B:144:0x0712, B:145:0x0715, B:147:0x0721, B:148:0x0788, B:150:0x0792, B:151:0x0799, B:153:0x07a3, B:154:0x07aa, B:155:0x07b5, B:157:0x07bb, B:160:0x07ec, B:161:0x07fc, B:163:0x0804, B:164:0x080a, B:166:0x0810, B:170:0x0859, B:172:0x085f, B:173:0x087b, B:175:0x088f, B:180:0x081f, B:182:0x0844, B:188:0x0863, B:189:0x0658, B:191:0x066a, B:193:0x066e, B:195:0x0680, B:196:0x06b7, B:197:0x069a, B:199:0x06a0, B:200:0x05e9, B:202:0x05f1, B:203:0x053b, B:205:0x0122, B:207:0x0134, B:209:0x014d, B:215:0x016b, B:216:0x019a, B:218:0x01a0, B:220:0x01ae, B:222:0x01be, B:223:0x01c8, B:225:0x01d3, B:228:0x01da, B:229:0x0277, B:231:0x0281, B:234:0x02be, B:237:0x020b, B:239:0x0226, B:242:0x0233, B:245:0x023b, B:246:0x025c, B:250:0x024b, B:257:0x01c3, B:260:0x0170, B:261:0x018e), top: B:34:0x0104, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02be A[Catch: all -> 0x08d4, TRY_LEAVE, TryCatch #0 {all -> 0x08d4, blocks: (B:35:0x0104, B:37:0x0111, B:41:0x02cd, B:43:0x030d, B:45:0x0312, B:46:0x032b, B:50:0x033c, B:52:0x0352, B:54:0x0357, B:55:0x0372, B:60:0x0396, B:64:0x03bc, B:65:0x03d5, B:68:0x03e5, B:70:0x0404, B:71:0x0422, B:73:0x042c, B:75:0x043a, B:77:0x0448, B:79:0x044e, B:80:0x045b, B:82:0x0465, B:84:0x0475, B:86:0x0483, B:87:0x048e, B:89:0x049a, B:90:0x04b1, B:92:0x04d5, B:95:0x04e5, B:98:0x0521, B:99:0x0549, B:101:0x0583, B:102:0x0588, B:104:0x0590, B:105:0x0595, B:107:0x059d, B:108:0x05a2, B:110:0x05ab, B:111:0x05b1, B:113:0x05be, B:114:0x05c3, B:116:0x05d1, B:118:0x05db, B:120:0x05e3, B:121:0x05f6, B:123:0x05fe, B:124:0x0603, B:126:0x0618, B:128:0x0622, B:129:0x0625, B:131:0x0633, B:133:0x063d, B:135:0x0641, B:137:0x064c, B:138:0x06ba, B:140:0x0702, B:142:0x0708, B:144:0x0712, B:145:0x0715, B:147:0x0721, B:148:0x0788, B:150:0x0792, B:151:0x0799, B:153:0x07a3, B:154:0x07aa, B:155:0x07b5, B:157:0x07bb, B:160:0x07ec, B:161:0x07fc, B:163:0x0804, B:164:0x080a, B:166:0x0810, B:170:0x0859, B:172:0x085f, B:173:0x087b, B:175:0x088f, B:180:0x081f, B:182:0x0844, B:188:0x0863, B:189:0x0658, B:191:0x066a, B:193:0x066e, B:195:0x0680, B:196:0x06b7, B:197:0x069a, B:199:0x06a0, B:200:0x05e9, B:202:0x05f1, B:203:0x053b, B:205:0x0122, B:207:0x0134, B:209:0x014d, B:215:0x016b, B:216:0x019a, B:218:0x01a0, B:220:0x01ae, B:222:0x01be, B:223:0x01c8, B:225:0x01d3, B:228:0x01da, B:229:0x0277, B:231:0x0281, B:234:0x02be, B:237:0x020b, B:239:0x0226, B:242:0x0233, B:245:0x023b, B:246:0x025c, B:250:0x024b, B:257:0x01c3, B:260:0x0170, B:261:0x018e), top: B:34:0x0104, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x030d A[Catch: all -> 0x08d4, TryCatch #0 {all -> 0x08d4, blocks: (B:35:0x0104, B:37:0x0111, B:41:0x02cd, B:43:0x030d, B:45:0x0312, B:46:0x032b, B:50:0x033c, B:52:0x0352, B:54:0x0357, B:55:0x0372, B:60:0x0396, B:64:0x03bc, B:65:0x03d5, B:68:0x03e5, B:70:0x0404, B:71:0x0422, B:73:0x042c, B:75:0x043a, B:77:0x0448, B:79:0x044e, B:80:0x045b, B:82:0x0465, B:84:0x0475, B:86:0x0483, B:87:0x048e, B:89:0x049a, B:90:0x04b1, B:92:0x04d5, B:95:0x04e5, B:98:0x0521, B:99:0x0549, B:101:0x0583, B:102:0x0588, B:104:0x0590, B:105:0x0595, B:107:0x059d, B:108:0x05a2, B:110:0x05ab, B:111:0x05b1, B:113:0x05be, B:114:0x05c3, B:116:0x05d1, B:118:0x05db, B:120:0x05e3, B:121:0x05f6, B:123:0x05fe, B:124:0x0603, B:126:0x0618, B:128:0x0622, B:129:0x0625, B:131:0x0633, B:133:0x063d, B:135:0x0641, B:137:0x064c, B:138:0x06ba, B:140:0x0702, B:142:0x0708, B:144:0x0712, B:145:0x0715, B:147:0x0721, B:148:0x0788, B:150:0x0792, B:151:0x0799, B:153:0x07a3, B:154:0x07aa, B:155:0x07b5, B:157:0x07bb, B:160:0x07ec, B:161:0x07fc, B:163:0x0804, B:164:0x080a, B:166:0x0810, B:170:0x0859, B:172:0x085f, B:173:0x087b, B:175:0x088f, B:180:0x081f, B:182:0x0844, B:188:0x0863, B:189:0x0658, B:191:0x066a, B:193:0x066e, B:195:0x0680, B:196:0x06b7, B:197:0x069a, B:199:0x06a0, B:200:0x05e9, B:202:0x05f1, B:203:0x053b, B:205:0x0122, B:207:0x0134, B:209:0x014d, B:215:0x016b, B:216:0x019a, B:218:0x01a0, B:220:0x01ae, B:222:0x01be, B:223:0x01c8, B:225:0x01d3, B:228:0x01da, B:229:0x0277, B:231:0x0281, B:234:0x02be, B:237:0x020b, B:239:0x0226, B:242:0x0233, B:245:0x023b, B:246:0x025c, B:250:0x024b, B:257:0x01c3, B:260:0x0170, B:261:0x018e), top: B:34:0x0104, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x033a  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void b(com.google.android.gms.measurement.internal.zzai r25, com.google.android.gms.measurement.internal.zzn r26) {
        /*
            Method dump skipped, instructions count: 2271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.b(com.google.android.gms.measurement.internal.zzai, com.google.android.gms.measurement.internal.zzn):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c() {
        de b;
        String str;
        i();
        b();
        this.t = true;
        try {
            this.j.zzae();
            Boolean g = this.j.zzs().g();
            if (g == null) {
                this.j.zzab().zzgn().zzao("Upload data called on the client side before use of service was decided");
                return;
            }
            if (g.booleanValue()) {
                this.j.zzab().zzgk().zzao("Upload called in the client side when service should be used");
                return;
            }
            if (this.n > 0) {
                l();
                return;
            }
            i();
            if (this.w != null) {
                this.j.zzab().zzgs().zzao("Uploading requested multiple times");
                return;
            }
            if (!zzjf().zzgv()) {
                this.j.zzab().zzgs().zzao("Network not connected, ignoring upload request");
                l();
                return;
            }
            long currentTimeMillis = this.j.zzx().currentTimeMillis();
            a((String) null, currentTimeMillis - zzs.zzbt());
            long j = this.j.zzac().c.get();
            if (j != 0) {
                this.j.zzab().zzgr().zza("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
            }
            String h = zzgy().h();
            if (!TextUtils.isEmpty(h)) {
                if (this.y == -1) {
                    this.y = zzgy().o();
                }
                List<Pair<zzbs.zzg, Long>> a2 = zzgy().a(h, this.j.zzad().zzb(h, zzak.zzgl), Math.max(0, this.j.zzad().zzb(h, zzak.zzgm)));
                if (!a2.isEmpty()) {
                    Iterator<Pair<zzbs.zzg, Long>> it = a2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        zzbs.zzg zzgVar = (zzbs.zzg) it.next().first;
                        if (!TextUtils.isEmpty(zzgVar.zzot())) {
                            str = zzgVar.zzot();
                            break;
                        }
                    }
                    if (str != null) {
                        int i = 0;
                        while (true) {
                            if (i >= a2.size()) {
                                break;
                            }
                            zzbs.zzg zzgVar2 = (zzbs.zzg) a2.get(i).first;
                            if (!TextUtils.isEmpty(zzgVar2.zzot()) && !zzgVar2.zzot().equals(str)) {
                                a2 = a2.subList(0, i);
                                break;
                            }
                            i++;
                        }
                    }
                    zzbs.zzf.zza zznj = zzbs.zzf.zznj();
                    int size = a2.size();
                    ArrayList arrayList = new ArrayList(a2.size());
                    boolean z = zzs.zzbv() && this.j.zzad().zzl(h);
                    for (int i2 = 0; i2 < size; i2++) {
                        zzbs.zzg.zza zzuj = ((zzbs.zzg) a2.get(i2).first).zzuj();
                        arrayList.add((Long) a2.get(i2).second);
                        zzbs.zzg.zza zzan = zzuj.zzat(this.j.zzad().zzao()).zzan(currentTimeMillis);
                        this.j.zzae();
                        zzan.zzn(false);
                        if (!z) {
                            zzuj.zznw();
                        }
                        if (this.j.zzad().zze(h, zzak.zzis)) {
                            zzuj.zzay(zzgw().a(((zzbs.zzg) ((zzey) zzuj.zzug())).toByteArray()));
                        }
                        zznj.zza(zzuj);
                    }
                    String a3 = this.j.zzab().a(2) ? zzgw().a((zzbs.zzf) ((zzey) zznj.zzug())) : null;
                    zzgw();
                    byte[] byteArray = ((zzbs.zzf) ((zzey) zznj.zzug())).toByteArray();
                    String str2 = zzak.zzgv.get(null);
                    try {
                        URL url = new URL(str2);
                        Preconditions.checkArgument(!arrayList.isEmpty());
                        if (this.w != null) {
                            this.j.zzab().zzgk().zzao("Set uploading progress before finishing the previous upload");
                        } else {
                            this.w = new ArrayList(arrayList);
                        }
                        this.j.zzac().d.set(currentTimeMillis);
                        this.j.zzab().zzgs().zza("Uploading data. app, uncompressed size, data", size > 0 ? zznj.zzo(0).zzag() : "?", Integer.valueOf(byteArray.length), a3);
                        this.s = true;
                        zzej zzjf = zzjf();
                        gr grVar = new gr(this, h);
                        zzjf.zzo();
                        zzjf.c();
                        Preconditions.checkNotNull(url);
                        Preconditions.checkNotNull(byteArray);
                        Preconditions.checkNotNull(grVar);
                        zzjf.zzaa().zzb(new cy(zzjf, h, url, byteArray, null, grVar));
                    } catch (MalformedURLException unused) {
                        this.j.zzab().zzgk().zza("Failed to parse upload URL. Not uploading. appId", zzef.a(h), str2);
                    }
                }
            } else {
                this.y = -1L;
                String a4 = zzgy().a(currentTimeMillis - zzs.zzbt());
                if (!TextUtils.isEmpty(a4) && (b = zzgy().b(a4)) != null) {
                    a(b);
                }
            }
        } finally {
            this.t = false;
            m();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:5|(3:6|7|8)|(7:10|(2:575|576)(1:12)|13|(1:15)(1:574)|16|17|(5:(1:20)|21|(2:26|(32:28|(4:31|(6:33|(4:38|(1:42)|43|44)|46|(2:40|42)|43|44)(21:47|(2:49|(2:51|(5:53|(3:146|57|(1:60)(9:61|62|(1:142)(5:65|(4:68|(2:70|71)(2:73|(2:75|76)(1:77))|72|66)|78|79|(1:141)(2:81|(3:123|(1:125)(2:128|(1:130)(2:131|(2:132|(2:134|(2:137|138)(1:136))(2:139|140))))|(1:127))(1:85)))|86|(2:88|(2:90|(2:(2:95|(1:97))|98))(2:99|(2:101|(2:(2:106|(1:108))|109))))|(2:113|(1:115)(2:116|(1:118)(3:119|120|121)))|122|120|121))|56|57|(0)(0))(5:147|(3:149|57|(0)(0))|56|57|(0)(0)))(5:150|(3:152|57|(0)(0))|56|57|(0)(0)))|153|(4:156|(2:158|159)(2:161|(2:163|164)(1:165))|160|154)|166|167|(1:170)|(1:172)|173|(1:175)(1:204)|176|(1:203)(2:179|(5:181|(4:184|(2:186|187)(2:189|(2:191|192)(1:193))|188|182)|194|195|(1:(1:200)(1:201))(1:198))(1:202))|62|(0)|142|86|(0)|(3:111|113|(0)(0))|122|120|121)|45|29)|205|206|(4:208|(7:210|(2:212|(3:214|215|216))|217|(3:219|(1:221)(1:227)|(3:225|226|216))|228|229|216)|230|231)(1:491)|232|(4:234|(2:235|(2:237|(2:239|240)(1:485))(2:486|487))|(1:242)(1:484)|243)(2:488|(1:490))|244|(2:246|(3:254|(2:255|(2:257|(2:260|261)(1:259))(2:264|265))|(1:263)))|266|(9:353|354|(4:357|(7:359|(1:361)|362|(5:364|(1:366)|367|(1:371)|372)|373|374|375)(4:378|(1:474)(2:381|(2:382|(2:384|(3:387|388|(1:471)(1:392))(1:386))(2:472|473)))|(1:394)(1:462)|(3:396|397|398)(7:399|(2:401|(2:403|(1:405)(2:406|407)))(1:461)|408|(1:410)(1:460)|411|412|(5:414|(1:422)|423|424|425)(4:426|(4:428|(1:430)|431|432)(4:435|436|(4:438|(2:440|441)(1:455)|442|(1:444)(1:454))(2:456|(1:458)(1:459))|(3:446|(1:448)|449)(2:450|(1:452)(1:453)))|433|434)))|376|355)|475|476|(1:478)|479|(2:482|480)|483)(1:268)|269|270|271|(6:274|(1:276)|277|(2:279|280)(1:282)|281|272)|289|290|291|(2:293|294)(2:330|(9:332|(1:334)(1:348)|335|(1:337)(1:347)|338|(1:340)(1:346)|341|(1:343)(1:345)|344))|295|(5:297|(2:302|303)|304|(1:306)(1:307)|303)|308|(3:(2:312|313)(1:315)|314|309)|316|317|(1:319)|320|321|322|323|324|325)(4:492|493|494|495))|496|(0)(0))(4:497|498|499|500))(7:580|(1:582)(1:594)|583|(1:585)(1:593)|586|587|(5:(1:590)|21|(3:23|26|(0)(0))|496|(0)(0))(2:591|592))|501|502|504|505|(2:507|(1:509))(12:510|511|512|513|(1:515)|516|(1:518)(1:558)|519|520|521|(2:523|(1:525))|(7:526|527|528|529|(2:537|(1:539))|531|(2:533|(1:535))(1:536)))|21|(0)|496|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(19:1|2|3|4|5|6|7|8|(7:10|(2:575|576)(1:12)|13|(1:15)(1:574)|16|17|(5:(1:20)|21|(2:26|(32:28|(4:31|(6:33|(4:38|(1:42)|43|44)|46|(2:40|42)|43|44)(21:47|(2:49|(2:51|(5:53|(3:146|57|(1:60)(9:61|62|(1:142)(5:65|(4:68|(2:70|71)(2:73|(2:75|76)(1:77))|72|66)|78|79|(1:141)(2:81|(3:123|(1:125)(2:128|(1:130)(2:131|(2:132|(2:134|(2:137|138)(1:136))(2:139|140))))|(1:127))(1:85)))|86|(2:88|(2:90|(2:(2:95|(1:97))|98))(2:99|(2:101|(2:(2:106|(1:108))|109))))|(2:113|(1:115)(2:116|(1:118)(3:119|120|121)))|122|120|121))|56|57|(0)(0))(5:147|(3:149|57|(0)(0))|56|57|(0)(0)))(5:150|(3:152|57|(0)(0))|56|57|(0)(0)))|153|(4:156|(2:158|159)(2:161|(2:163|164)(1:165))|160|154)|166|167|(1:170)|(1:172)|173|(1:175)(1:204)|176|(1:203)(2:179|(5:181|(4:184|(2:186|187)(2:189|(2:191|192)(1:193))|188|182)|194|195|(1:(1:200)(1:201))(1:198))(1:202))|62|(0)|142|86|(0)|(3:111|113|(0)(0))|122|120|121)|45|29)|205|206|(4:208|(7:210|(2:212|(3:214|215|216))|217|(3:219|(1:221)(1:227)|(3:225|226|216))|228|229|216)|230|231)(1:491)|232|(4:234|(2:235|(2:237|(2:239|240)(1:485))(2:486|487))|(1:242)(1:484)|243)(2:488|(1:490))|244|(2:246|(3:254|(2:255|(2:257|(2:260|261)(1:259))(2:264|265))|(1:263)))|266|(9:353|354|(4:357|(7:359|(1:361)|362|(5:364|(1:366)|367|(1:371)|372)|373|374|375)(4:378|(1:474)(2:381|(2:382|(2:384|(3:387|388|(1:471)(1:392))(1:386))(2:472|473)))|(1:394)(1:462)|(3:396|397|398)(7:399|(2:401|(2:403|(1:405)(2:406|407)))(1:461)|408|(1:410)(1:460)|411|412|(5:414|(1:422)|423|424|425)(4:426|(4:428|(1:430)|431|432)(4:435|436|(4:438|(2:440|441)(1:455)|442|(1:444)(1:454))(2:456|(1:458)(1:459))|(3:446|(1:448)|449)(2:450|(1:452)(1:453)))|433|434)))|376|355)|475|476|(1:478)|479|(2:482|480)|483)(1:268)|269|270|271|(6:274|(1:276)|277|(2:279|280)(1:282)|281|272)|289|290|291|(2:293|294)(2:330|(9:332|(1:334)(1:348)|335|(1:337)(1:347)|338|(1:340)(1:346)|341|(1:343)(1:345)|344))|295|(5:297|(2:302|303)|304|(1:306)(1:307)|303)|308|(3:(2:312|313)(1:315)|314|309)|316|317|(1:319)|320|321|322|323|324|325)(4:492|493|494|495))|496|(0)(0))(4:497|498|499|500))(7:580|(1:582)(1:594)|583|(1:585)(1:593)|586|587|(5:(1:590)|21|(3:23|26|(0)(0))|496|(0)(0))(2:591|592))|501|502|504|505|(2:507|(1:509))(12:510|511|512|513|(1:515)|516|(1:518)(1:558)|519|520|521|(2:523|(1:525))|(7:526|527|528|529|(2:537|(1:539))|531|(2:533|(1:535))(1:536)))|21|(0)|496|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:565:0x0248, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:566:0x0249, code lost:
    
        r7 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:567:0x0251, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:568:0x0252, code lost:
    
        r7 = r3;
        r8 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:569:0x024c, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:570:0x024d, code lost:
    
        r8 = r22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0764 A[Catch: all -> 0x0f1d, TryCatch #18 {all -> 0x0f1d, blocks: (B:3:0x0009, B:20:0x0088, B:21:0x027c, B:23:0x0280, B:28:0x028e, B:29:0x02b9, B:31:0x02c1, B:33:0x02e5, B:35:0x0320, B:40:0x0336, B:42:0x0342, B:45:0x07ca, B:47:0x0361, B:49:0x0379, B:57:0x03b6, B:62:0x05bb, B:65:0x05cf, B:66:0x05db, B:68:0x05e1, B:72:0x0608, B:73:0x05f5, B:81:0x060e, B:83:0x061a, B:85:0x0626, B:86:0x069f, B:88:0x06b3, B:90:0x06c1, B:93:0x06d6, B:95:0x06e8, B:97:0x06f6, B:99:0x0703, B:101:0x070f, B:104:0x0724, B:106:0x0736, B:108:0x0744, B:111:0x0752, B:113:0x075e, B:115:0x0764, B:116:0x077e, B:118:0x0793, B:119:0x07ad, B:120:0x07b6, B:127:0x067c, B:128:0x064d, B:132:0x0661, B:134:0x0667, B:136:0x0673, B:144:0x0397, B:147:0x03a1, B:150:0x03ab, B:154:0x03c8, B:156:0x03ce, B:158:0x03e0, B:160:0x0431, B:161:0x0401, B:163:0x0413, B:170:0x0440, B:172:0x0472, B:173:0x04a2, B:175:0x04d5, B:176:0x04de, B:179:0x04ea, B:181:0x051f, B:182:0x053c, B:184:0x0542, B:186:0x0554, B:188:0x056b, B:189:0x055e, B:198:0x0576, B:200:0x057c, B:201:0x059c, B:210:0x07df, B:212:0x07ef, B:214:0x07fa, B:216:0x0832, B:217:0x0803, B:219:0x080e, B:221:0x0814, B:223:0x0820, B:225:0x082a, B:232:0x0839, B:234:0x084e, B:235:0x0856, B:237:0x085c, B:242:0x0873, B:243:0x0883, B:244:0x08a6, B:246:0x08b8, B:248:0x08d7, B:250:0x08e5, B:252:0x08eb, B:254:0x08f5, B:255:0x0927, B:257:0x092d, B:261:0x093d, B:263:0x0948, B:259:0x0942, B:266:0x094b, B:359:0x09ae, B:361:0x09c9, B:362:0x09da, B:364:0x09de, B:366:0x09ea, B:367:0x09f4, B:369:0x09f8, B:371:0x0a00, B:372:0x0a0e, B:373:0x0a19, B:381:0x0a57, B:382:0x0a5f, B:384:0x0a65, B:388:0x0a77, B:390:0x0a7b, B:394:0x0ab5, B:396:0x0acb, B:401:0x0b03, B:403:0x0b19, B:405:0x0b46, B:406:0x0b6d, B:414:0x0bb3, B:416:0x0bc4, B:418:0x0bc8, B:420:0x0bcc, B:422:0x0bd0, B:423:0x0bdc, B:428:0x0bec, B:430:0x0c0d, B:431:0x0c16, B:440:0x0c43, B:463:0x0a89, B:465:0x0a8d, B:467:0x0a97, B:469:0x0a9b, B:488:0x0887, B:490:0x0899, B:509:0x0136, B:525:0x01c7, B:539:0x0202, B:535:0x0222, B:549:0x0279, B:564:0x0244, B:590:0x00ea, B:512:0x013f), top: B:2:0x0009, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x077e A[Catch: all -> 0x0f1d, TryCatch #18 {all -> 0x0f1d, blocks: (B:3:0x0009, B:20:0x0088, B:21:0x027c, B:23:0x0280, B:28:0x028e, B:29:0x02b9, B:31:0x02c1, B:33:0x02e5, B:35:0x0320, B:40:0x0336, B:42:0x0342, B:45:0x07ca, B:47:0x0361, B:49:0x0379, B:57:0x03b6, B:62:0x05bb, B:65:0x05cf, B:66:0x05db, B:68:0x05e1, B:72:0x0608, B:73:0x05f5, B:81:0x060e, B:83:0x061a, B:85:0x0626, B:86:0x069f, B:88:0x06b3, B:90:0x06c1, B:93:0x06d6, B:95:0x06e8, B:97:0x06f6, B:99:0x0703, B:101:0x070f, B:104:0x0724, B:106:0x0736, B:108:0x0744, B:111:0x0752, B:113:0x075e, B:115:0x0764, B:116:0x077e, B:118:0x0793, B:119:0x07ad, B:120:0x07b6, B:127:0x067c, B:128:0x064d, B:132:0x0661, B:134:0x0667, B:136:0x0673, B:144:0x0397, B:147:0x03a1, B:150:0x03ab, B:154:0x03c8, B:156:0x03ce, B:158:0x03e0, B:160:0x0431, B:161:0x0401, B:163:0x0413, B:170:0x0440, B:172:0x0472, B:173:0x04a2, B:175:0x04d5, B:176:0x04de, B:179:0x04ea, B:181:0x051f, B:182:0x053c, B:184:0x0542, B:186:0x0554, B:188:0x056b, B:189:0x055e, B:198:0x0576, B:200:0x057c, B:201:0x059c, B:210:0x07df, B:212:0x07ef, B:214:0x07fa, B:216:0x0832, B:217:0x0803, B:219:0x080e, B:221:0x0814, B:223:0x0820, B:225:0x082a, B:232:0x0839, B:234:0x084e, B:235:0x0856, B:237:0x085c, B:242:0x0873, B:243:0x0883, B:244:0x08a6, B:246:0x08b8, B:248:0x08d7, B:250:0x08e5, B:252:0x08eb, B:254:0x08f5, B:255:0x0927, B:257:0x092d, B:261:0x093d, B:263:0x0948, B:259:0x0942, B:266:0x094b, B:359:0x09ae, B:361:0x09c9, B:362:0x09da, B:364:0x09de, B:366:0x09ea, B:367:0x09f4, B:369:0x09f8, B:371:0x0a00, B:372:0x0a0e, B:373:0x0a19, B:381:0x0a57, B:382:0x0a5f, B:384:0x0a65, B:388:0x0a77, B:390:0x0a7b, B:394:0x0ab5, B:396:0x0acb, B:401:0x0b03, B:403:0x0b19, B:405:0x0b46, B:406:0x0b6d, B:414:0x0bb3, B:416:0x0bc4, B:418:0x0bc8, B:420:0x0bcc, B:422:0x0bd0, B:423:0x0bdc, B:428:0x0bec, B:430:0x0c0d, B:431:0x0c16, B:440:0x0c43, B:463:0x0a89, B:465:0x0a8d, B:467:0x0a97, B:469:0x0a9b, B:488:0x0887, B:490:0x0899, B:509:0x0136, B:525:0x01c7, B:539:0x0202, B:535:0x0222, B:549:0x0279, B:564:0x0244, B:590:0x00ea, B:512:0x013f), top: B:2:0x0009, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0280 A[Catch: all -> 0x0f1d, TryCatch #18 {all -> 0x0f1d, blocks: (B:3:0x0009, B:20:0x0088, B:21:0x027c, B:23:0x0280, B:28:0x028e, B:29:0x02b9, B:31:0x02c1, B:33:0x02e5, B:35:0x0320, B:40:0x0336, B:42:0x0342, B:45:0x07ca, B:47:0x0361, B:49:0x0379, B:57:0x03b6, B:62:0x05bb, B:65:0x05cf, B:66:0x05db, B:68:0x05e1, B:72:0x0608, B:73:0x05f5, B:81:0x060e, B:83:0x061a, B:85:0x0626, B:86:0x069f, B:88:0x06b3, B:90:0x06c1, B:93:0x06d6, B:95:0x06e8, B:97:0x06f6, B:99:0x0703, B:101:0x070f, B:104:0x0724, B:106:0x0736, B:108:0x0744, B:111:0x0752, B:113:0x075e, B:115:0x0764, B:116:0x077e, B:118:0x0793, B:119:0x07ad, B:120:0x07b6, B:127:0x067c, B:128:0x064d, B:132:0x0661, B:134:0x0667, B:136:0x0673, B:144:0x0397, B:147:0x03a1, B:150:0x03ab, B:154:0x03c8, B:156:0x03ce, B:158:0x03e0, B:160:0x0431, B:161:0x0401, B:163:0x0413, B:170:0x0440, B:172:0x0472, B:173:0x04a2, B:175:0x04d5, B:176:0x04de, B:179:0x04ea, B:181:0x051f, B:182:0x053c, B:184:0x0542, B:186:0x0554, B:188:0x056b, B:189:0x055e, B:198:0x0576, B:200:0x057c, B:201:0x059c, B:210:0x07df, B:212:0x07ef, B:214:0x07fa, B:216:0x0832, B:217:0x0803, B:219:0x080e, B:221:0x0814, B:223:0x0820, B:225:0x082a, B:232:0x0839, B:234:0x084e, B:235:0x0856, B:237:0x085c, B:242:0x0873, B:243:0x0883, B:244:0x08a6, B:246:0x08b8, B:248:0x08d7, B:250:0x08e5, B:252:0x08eb, B:254:0x08f5, B:255:0x0927, B:257:0x092d, B:261:0x093d, B:263:0x0948, B:259:0x0942, B:266:0x094b, B:359:0x09ae, B:361:0x09c9, B:362:0x09da, B:364:0x09de, B:366:0x09ea, B:367:0x09f4, B:369:0x09f8, B:371:0x0a00, B:372:0x0a0e, B:373:0x0a19, B:381:0x0a57, B:382:0x0a5f, B:384:0x0a65, B:388:0x0a77, B:390:0x0a7b, B:394:0x0ab5, B:396:0x0acb, B:401:0x0b03, B:403:0x0b19, B:405:0x0b46, B:406:0x0b6d, B:414:0x0bb3, B:416:0x0bc4, B:418:0x0bc8, B:420:0x0bcc, B:422:0x0bd0, B:423:0x0bdc, B:428:0x0bec, B:430:0x0c0d, B:431:0x0c16, B:440:0x0c43, B:463:0x0a89, B:465:0x0a8d, B:467:0x0a97, B:469:0x0a9b, B:488:0x0887, B:490:0x0899, B:509:0x0136, B:525:0x01c7, B:539:0x0202, B:535:0x0222, B:549:0x0279, B:564:0x0244, B:590:0x00ea, B:512:0x013f), top: B:2:0x0009, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x028e A[Catch: all -> 0x0f1d, TryCatch #18 {all -> 0x0f1d, blocks: (B:3:0x0009, B:20:0x0088, B:21:0x027c, B:23:0x0280, B:28:0x028e, B:29:0x02b9, B:31:0x02c1, B:33:0x02e5, B:35:0x0320, B:40:0x0336, B:42:0x0342, B:45:0x07ca, B:47:0x0361, B:49:0x0379, B:57:0x03b6, B:62:0x05bb, B:65:0x05cf, B:66:0x05db, B:68:0x05e1, B:72:0x0608, B:73:0x05f5, B:81:0x060e, B:83:0x061a, B:85:0x0626, B:86:0x069f, B:88:0x06b3, B:90:0x06c1, B:93:0x06d6, B:95:0x06e8, B:97:0x06f6, B:99:0x0703, B:101:0x070f, B:104:0x0724, B:106:0x0736, B:108:0x0744, B:111:0x0752, B:113:0x075e, B:115:0x0764, B:116:0x077e, B:118:0x0793, B:119:0x07ad, B:120:0x07b6, B:127:0x067c, B:128:0x064d, B:132:0x0661, B:134:0x0667, B:136:0x0673, B:144:0x0397, B:147:0x03a1, B:150:0x03ab, B:154:0x03c8, B:156:0x03ce, B:158:0x03e0, B:160:0x0431, B:161:0x0401, B:163:0x0413, B:170:0x0440, B:172:0x0472, B:173:0x04a2, B:175:0x04d5, B:176:0x04de, B:179:0x04ea, B:181:0x051f, B:182:0x053c, B:184:0x0542, B:186:0x0554, B:188:0x056b, B:189:0x055e, B:198:0x0576, B:200:0x057c, B:201:0x059c, B:210:0x07df, B:212:0x07ef, B:214:0x07fa, B:216:0x0832, B:217:0x0803, B:219:0x080e, B:221:0x0814, B:223:0x0820, B:225:0x082a, B:232:0x0839, B:234:0x084e, B:235:0x0856, B:237:0x085c, B:242:0x0873, B:243:0x0883, B:244:0x08a6, B:246:0x08b8, B:248:0x08d7, B:250:0x08e5, B:252:0x08eb, B:254:0x08f5, B:255:0x0927, B:257:0x092d, B:261:0x093d, B:263:0x0948, B:259:0x0942, B:266:0x094b, B:359:0x09ae, B:361:0x09c9, B:362:0x09da, B:364:0x09de, B:366:0x09ea, B:367:0x09f4, B:369:0x09f8, B:371:0x0a00, B:372:0x0a0e, B:373:0x0a19, B:381:0x0a57, B:382:0x0a5f, B:384:0x0a65, B:388:0x0a77, B:390:0x0a7b, B:394:0x0ab5, B:396:0x0acb, B:401:0x0b03, B:403:0x0b19, B:405:0x0b46, B:406:0x0b6d, B:414:0x0bb3, B:416:0x0bc4, B:418:0x0bc8, B:420:0x0bcc, B:422:0x0bd0, B:423:0x0bdc, B:428:0x0bec, B:430:0x0c0d, B:431:0x0c16, B:440:0x0c43, B:463:0x0a89, B:465:0x0a8d, B:467:0x0a97, B:469:0x0a9b, B:488:0x0887, B:490:0x0899, B:509:0x0136, B:525:0x01c7, B:539:0x0202, B:535:0x0222, B:549:0x0279, B:564:0x0244, B:590:0x00ea, B:512:0x013f), top: B:2:0x0009, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0f00  */
    /* JADX WARN: Removed duplicated region for block: B:549:0x0279 A[Catch: all -> 0x0f1d, TRY_ENTER, TryCatch #18 {all -> 0x0f1d, blocks: (B:3:0x0009, B:20:0x0088, B:21:0x027c, B:23:0x0280, B:28:0x028e, B:29:0x02b9, B:31:0x02c1, B:33:0x02e5, B:35:0x0320, B:40:0x0336, B:42:0x0342, B:45:0x07ca, B:47:0x0361, B:49:0x0379, B:57:0x03b6, B:62:0x05bb, B:65:0x05cf, B:66:0x05db, B:68:0x05e1, B:72:0x0608, B:73:0x05f5, B:81:0x060e, B:83:0x061a, B:85:0x0626, B:86:0x069f, B:88:0x06b3, B:90:0x06c1, B:93:0x06d6, B:95:0x06e8, B:97:0x06f6, B:99:0x0703, B:101:0x070f, B:104:0x0724, B:106:0x0736, B:108:0x0744, B:111:0x0752, B:113:0x075e, B:115:0x0764, B:116:0x077e, B:118:0x0793, B:119:0x07ad, B:120:0x07b6, B:127:0x067c, B:128:0x064d, B:132:0x0661, B:134:0x0667, B:136:0x0673, B:144:0x0397, B:147:0x03a1, B:150:0x03ab, B:154:0x03c8, B:156:0x03ce, B:158:0x03e0, B:160:0x0431, B:161:0x0401, B:163:0x0413, B:170:0x0440, B:172:0x0472, B:173:0x04a2, B:175:0x04d5, B:176:0x04de, B:179:0x04ea, B:181:0x051f, B:182:0x053c, B:184:0x0542, B:186:0x0554, B:188:0x056b, B:189:0x055e, B:198:0x0576, B:200:0x057c, B:201:0x059c, B:210:0x07df, B:212:0x07ef, B:214:0x07fa, B:216:0x0832, B:217:0x0803, B:219:0x080e, B:221:0x0814, B:223:0x0820, B:225:0x082a, B:232:0x0839, B:234:0x084e, B:235:0x0856, B:237:0x085c, B:242:0x0873, B:243:0x0883, B:244:0x08a6, B:246:0x08b8, B:248:0x08d7, B:250:0x08e5, B:252:0x08eb, B:254:0x08f5, B:255:0x0927, B:257:0x092d, B:261:0x093d, B:263:0x0948, B:259:0x0942, B:266:0x094b, B:359:0x09ae, B:361:0x09c9, B:362:0x09da, B:364:0x09de, B:366:0x09ea, B:367:0x09f4, B:369:0x09f8, B:371:0x0a00, B:372:0x0a0e, B:373:0x0a19, B:381:0x0a57, B:382:0x0a5f, B:384:0x0a65, B:388:0x0a77, B:390:0x0a7b, B:394:0x0ab5, B:396:0x0acb, B:401:0x0b03, B:403:0x0b19, B:405:0x0b46, B:406:0x0b6d, B:414:0x0bb3, B:416:0x0bc4, B:418:0x0bc8, B:420:0x0bcc, B:422:0x0bd0, B:423:0x0bdc, B:428:0x0bec, B:430:0x0c0d, B:431:0x0c16, B:440:0x0c43, B:463:0x0a89, B:465:0x0a8d, B:467:0x0a97, B:469:0x0a9b, B:488:0x0887, B:490:0x0899, B:509:0x0136, B:525:0x01c7, B:539:0x0202, B:535:0x0222, B:549:0x0279, B:564:0x0244, B:590:0x00ea, B:512:0x013f), top: B:2:0x0009, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:555:0x0f17 A[Catch: all -> 0x0f1b, TRY_ENTER, TryCatch #15 {all -> 0x0f1b, blocks: (B:294:0x0d7e, B:295:0x0df5, B:297:0x0dfb, B:299:0x0e10, B:302:0x0e15, B:303:0x0e4a, B:304:0x0e1f, B:306:0x0e2b, B:307:0x0e31, B:308:0x0e5b, B:309:0x0e72, B:312:0x0e7a, B:314:0x0e7f, B:317:0x0e8f, B:319:0x0ea9, B:320:0x0ec2, B:322:0x0eca, B:323:0x0eec, B:329:0x0edb, B:330:0x0d98, B:332:0x0da0, B:334:0x0daa, B:335:0x0db1, B:340:0x0dc1, B:341:0x0dc8, B:343:0x0de7, B:344:0x0dee, B:345:0x0deb, B:346:0x0dc5, B:348:0x0dae, B:493:0x0f01, B:555:0x0f17, B:556:0x0f1a), top: B:5:0x0023, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:557:? A[Catch: all -> 0x0f1b, SYNTHETIC, TRY_LEAVE, TryCatch #15 {all -> 0x0f1b, blocks: (B:294:0x0d7e, B:295:0x0df5, B:297:0x0dfb, B:299:0x0e10, B:302:0x0e15, B:303:0x0e4a, B:304:0x0e1f, B:306:0x0e2b, B:307:0x0e31, B:308:0x0e5b, B:309:0x0e72, B:312:0x0e7a, B:314:0x0e7f, B:317:0x0e8f, B:319:0x0ea9, B:320:0x0ec2, B:322:0x0eca, B:323:0x0eec, B:329:0x0edb, B:330:0x0d98, B:332:0x0da0, B:334:0x0daa, B:335:0x0db1, B:340:0x0dc1, B:341:0x0dc8, B:343:0x0de7, B:344:0x0dee, B:345:0x0deb, B:346:0x0dc5, B:348:0x0dae, B:493:0x0f01, B:555:0x0f17, B:556:0x0f1a), top: B:5:0x0023, inners: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x06b3 A[Catch: all -> 0x0f1d, TryCatch #18 {all -> 0x0f1d, blocks: (B:3:0x0009, B:20:0x0088, B:21:0x027c, B:23:0x0280, B:28:0x028e, B:29:0x02b9, B:31:0x02c1, B:33:0x02e5, B:35:0x0320, B:40:0x0336, B:42:0x0342, B:45:0x07ca, B:47:0x0361, B:49:0x0379, B:57:0x03b6, B:62:0x05bb, B:65:0x05cf, B:66:0x05db, B:68:0x05e1, B:72:0x0608, B:73:0x05f5, B:81:0x060e, B:83:0x061a, B:85:0x0626, B:86:0x069f, B:88:0x06b3, B:90:0x06c1, B:93:0x06d6, B:95:0x06e8, B:97:0x06f6, B:99:0x0703, B:101:0x070f, B:104:0x0724, B:106:0x0736, B:108:0x0744, B:111:0x0752, B:113:0x075e, B:115:0x0764, B:116:0x077e, B:118:0x0793, B:119:0x07ad, B:120:0x07b6, B:127:0x067c, B:128:0x064d, B:132:0x0661, B:134:0x0667, B:136:0x0673, B:144:0x0397, B:147:0x03a1, B:150:0x03ab, B:154:0x03c8, B:156:0x03ce, B:158:0x03e0, B:160:0x0431, B:161:0x0401, B:163:0x0413, B:170:0x0440, B:172:0x0472, B:173:0x04a2, B:175:0x04d5, B:176:0x04de, B:179:0x04ea, B:181:0x051f, B:182:0x053c, B:184:0x0542, B:186:0x0554, B:188:0x056b, B:189:0x055e, B:198:0x0576, B:200:0x057c, B:201:0x059c, B:210:0x07df, B:212:0x07ef, B:214:0x07fa, B:216:0x0832, B:217:0x0803, B:219:0x080e, B:221:0x0814, B:223:0x0820, B:225:0x082a, B:232:0x0839, B:234:0x084e, B:235:0x0856, B:237:0x085c, B:242:0x0873, B:243:0x0883, B:244:0x08a6, B:246:0x08b8, B:248:0x08d7, B:250:0x08e5, B:252:0x08eb, B:254:0x08f5, B:255:0x0927, B:257:0x092d, B:261:0x093d, B:263:0x0948, B:259:0x0942, B:266:0x094b, B:359:0x09ae, B:361:0x09c9, B:362:0x09da, B:364:0x09de, B:366:0x09ea, B:367:0x09f4, B:369:0x09f8, B:371:0x0a00, B:372:0x0a0e, B:373:0x0a19, B:381:0x0a57, B:382:0x0a5f, B:384:0x0a65, B:388:0x0a77, B:390:0x0a7b, B:394:0x0ab5, B:396:0x0acb, B:401:0x0b03, B:403:0x0b19, B:405:0x0b46, B:406:0x0b6d, B:414:0x0bb3, B:416:0x0bc4, B:418:0x0bc8, B:420:0x0bcc, B:422:0x0bd0, B:423:0x0bdc, B:428:0x0bec, B:430:0x0c0d, B:431:0x0c16, B:440:0x0c43, B:463:0x0a89, B:465:0x0a8d, B:467:0x0a97, B:469:0x0a9b, B:488:0x0887, B:490:0x0899, B:509:0x0136, B:525:0x01c7, B:539:0x0202, B:535:0x0222, B:549:0x0279, B:564:0x0244, B:590:0x00ea, B:512:0x013f), top: B:2:0x0009, inners: #5 }] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v87 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean a(java.lang.String r58, long r59) {
        /*
            Method dump skipped, instructions count: 3892
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.a(java.lang.String, long):boolean");
    }

    @VisibleForTesting
    private final void a(zzbs.zzg.zza zzaVar, long j, boolean z) {
        gv gvVar;
        String str = z ? "_se" : "_lte";
        gv c = zzgy().c(zzaVar.zzag(), str);
        if (c == null || c.e == null) {
            gvVar = new gv(zzaVar.zzag(), "auto", str, this.j.zzx().currentTimeMillis(), Long.valueOf(j));
        } else {
            gvVar = new gv(zzaVar.zzag(), "auto", str, this.j.zzx().currentTimeMillis(), Long.valueOf(((Long) c.e).longValue() + j));
        }
        zzbs.zzk zzkVar = (zzbs.zzk) ((zzey) zzbs.zzk.zzqu().zzdb(str).zzbk(this.j.zzx().currentTimeMillis()).zzbl(((Long) gvVar.e).longValue()).zzug());
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= zzaVar.zznp()) {
                break;
            }
            if (str.equals(zzaVar.zzs(i).getName())) {
                zzaVar.zza(i, zzkVar);
                z2 = true;
                break;
            }
            i++;
        }
        if (!z2) {
            zzaVar.zza(zzkVar);
        }
        if (j > 0) {
            zzgy().a(gvVar);
            this.j.zzab().zzgr().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", gvVar.e);
        }
    }

    private final boolean a(zzbs.zzc.zza zzaVar, zzbs.zzc.zza zzaVar2) {
        Preconditions.checkArgument("_e".equals(zzaVar.getName()));
        zzgw();
        zzbs.zze a2 = zzjo.a((zzbs.zzc) ((zzey) zzaVar.zzug()), "_sc");
        String zzmy = a2 == null ? null : a2.zzmy();
        zzgw();
        zzbs.zze a3 = zzjo.a((zzbs.zzc) ((zzey) zzaVar2.zzug()), "_pc");
        String zzmy2 = a3 != null ? a3.zzmy() : null;
        if (zzmy2 == null || !zzmy2.equals(zzmy)) {
            return false;
        }
        zzgw();
        zzbs.zze a4 = zzjo.a((zzbs.zzc) ((zzey) zzaVar.zzug()), "_et");
        if (!a4.zzna() || a4.zznb() <= 0) {
            return true;
        }
        long zznb = a4.zznb();
        zzgw();
        zzbs.zze a5 = zzjo.a((zzbs.zzc) ((zzey) zzaVar2.zzug()), "_et");
        if (a5 != null && a5.zznb() > 0) {
            zznb += a5.zznb();
        }
        zzgw();
        zzjo.a(zzaVar2, "_et", Long.valueOf(zznb));
        zzgw();
        zzjo.a(zzaVar, "_fr", (Object) 1L);
        return true;
    }

    @VisibleForTesting
    private static void a(zzbs.zzc.zza zzaVar, String str) {
        List<zzbs.zze> zzmj = zzaVar.zzmj();
        for (int i = 0; i < zzmj.size(); i++) {
            if (str.equals(zzmj.get(i).getName())) {
                zzaVar.zzm(i);
                return;
            }
        }
    }

    @VisibleForTesting
    private static void a(zzbs.zzc.zza zzaVar, int i, String str) {
        List<zzbs.zze> zzmj = zzaVar.zzmj();
        for (int i2 = 0; i2 < zzmj.size(); i2++) {
            if ("_err".equals(zzmj.get(i2).getName())) {
                return;
            }
        }
        zzaVar.zza((zzbs.zze) ((zzey) zzbs.zze.zzng().zzbz("_err").zzam(Long.valueOf(i).longValue()).zzug())).zza((zzbs.zze) ((zzey) zzbs.zze.zzng().zzbz("_ev").zzca(str).zzug()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0158, code lost:
    
        r8.j.zzac().e.set(r8.j.zzx().currentTimeMillis());
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r9, java.lang.Throwable r10, byte[] r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.a(int, java.lang.Throwable, byte[], java.lang.String):void");
    }

    private final boolean k() {
        i();
        b();
        return zzgy().m() || !TextUtils.isEmpty(zzgy().h());
    }

    private final void a(de deVar) {
        androidx.b.a aVar;
        i();
        if (TextUtils.isEmpty(deVar.d()) && (!zzs.c() || TextUtils.isEmpty(deVar.e()))) {
            a(deVar.b(), TbsListener.ErrorCode.APK_INVALID, null, null, null);
            return;
        }
        zzs zzad = this.j.zzad();
        Uri.Builder builder = new Uri.Builder();
        String d = deVar.d();
        if (TextUtils.isEmpty(d) && zzs.c()) {
            d = deVar.e();
        }
        Uri.Builder encodedAuthority = builder.scheme(zzak.zzgj.get(null)).encodedAuthority(zzak.zzgk.get(null));
        String valueOf = String.valueOf(d);
        encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", deVar.c()).appendQueryParameter(Constants.PARAM_PLATFORM, "android").appendQueryParameter("gmp_version", String.valueOf(zzad.zzao()));
        String uri = builder.build().toString();
        try {
            URL url = new URL(uri);
            this.j.zzab().zzgs().zza("Fetching remote configuration", deVar.b());
            zzbw a2 = zzgz().a(deVar.b());
            String b = zzgz().b(deVar.b());
            if (a2 == null || TextUtils.isEmpty(b)) {
                aVar = null;
            } else {
                androidx.b.a aVar2 = new androidx.b.a();
                aVar2.put(Headers.GET_OBJECT_IF_MODIFIED_SINCE, b);
                aVar = aVar2;
            }
            this.r = true;
            zzej zzjf = zzjf();
            String b2 = deVar.b();
            gu guVar = new gu(this);
            zzjf.zzo();
            zzjf.c();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(guVar);
            zzjf.zzaa().zzb(new cy(zzjf, b2, url, null, aVar, guVar));
        } catch (MalformedURLException unused) {
            this.j.zzab().zzgk().zza("Failed to parse config URL. Not fetching. appId", zzef.a(deVar.b()), uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b0, code lost:
    
        r6.j.zzac().e.set(r6.j.zzx().currentTimeMillis());
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014a A[Catch: all -> 0x018d, TryCatch #1 {all -> 0x018d, blocks: (B:5:0x0029, B:12:0x0045, B:13:0x0179, B:23:0x0061, B:30:0x00b0, B:31:0x00c5, B:34:0x00cd, B:36:0x00d9, B:38:0x00df, B:42:0x00ec, B:47:0x0124, B:49:0x013a, B:50:0x0162, B:52:0x016c, B:54:0x0172, B:55:0x0176, B:56:0x014a, B:57:0x0103, B:59:0x010d), top: B:4:0x0029, outer: #0 }] */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            Method dump skipped, instructions count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjg.a(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    private final void l() {
        long max;
        long j;
        i();
        b();
        if (o() || this.j.zzad().zza(zzak.zzim)) {
            if (this.n > 0) {
                long abs = 3600000 - Math.abs(this.j.zzx().elapsedRealtime() - this.n);
                if (abs > 0) {
                    this.j.zzab().zzgs().zza("Upload has been suspended. Will update scheduling later in approximately ms", Long.valueOf(abs));
                    g().b();
                    h().cancel();
                    return;
                }
                this.n = 0L;
            }
            if (!this.j.g() || !k()) {
                this.j.zzab().zzgs().zzao("Nothing to upload or uploading impossible");
                g().b();
                h().cancel();
                return;
            }
            long currentTimeMillis = this.j.zzx().currentTimeMillis();
            long max2 = Math.max(0L, zzak.zzhf.get(null).longValue());
            boolean z = zzgy().n() || zzgy().i();
            if (z) {
                String zzbu = this.j.zzad().zzbu();
                if (!TextUtils.isEmpty(zzbu) && !".none.".equals(zzbu)) {
                    max = Math.max(0L, zzak.zzha.get(null).longValue());
                } else {
                    max = Math.max(0L, zzak.zzgz.get(null).longValue());
                }
            } else {
                max = Math.max(0L, zzak.zzgy.get(null).longValue());
            }
            long j2 = this.j.zzac().c.get();
            long j3 = this.j.zzac().d.get();
            long j4 = max;
            long max3 = Math.max(zzgy().k(), zzgy().l());
            if (max3 == 0) {
                j = 0;
            } else {
                long abs2 = currentTimeMillis - Math.abs(max3 - currentTimeMillis);
                long abs3 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
                long abs4 = currentTimeMillis - Math.abs(j3 - currentTimeMillis);
                long max4 = Math.max(abs3, abs4);
                long j5 = abs2 + max2;
                if (z && max4 > 0) {
                    j5 = Math.min(abs2, max4) + j4;
                }
                j = !zzgw().a(max4, j4) ? max4 + j4 : j5;
                if (abs4 != 0 && abs4 >= abs2) {
                    int i = 0;
                    while (true) {
                        if (i >= Math.min(20, Math.max(0, zzak.zzhh.get(null).intValue()))) {
                            j = 0;
                            break;
                        }
                        j += Math.max(0L, zzak.zzhg.get(null).longValue()) * (1 << i);
                        if (j > abs4) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
            }
            if (j == 0) {
                this.j.zzab().zzgs().zzao("Next upload time is 0");
                g().b();
                h().cancel();
                return;
            }
            if (!zzjf().zzgv()) {
                this.j.zzab().zzgs().zzao("No network");
                g().a();
                h().cancel();
                return;
            }
            long j6 = this.j.zzac().e.get();
            long max5 = Math.max(0L, zzak.zzgw.get(null).longValue());
            if (!zzgw().a(j6, max5)) {
                j = Math.max(j, j6 + max5);
            }
            g().b();
            long currentTimeMillis2 = j - this.j.zzx().currentTimeMillis();
            if (currentTimeMillis2 <= 0) {
                currentTimeMillis2 = Math.max(0L, zzak.zzhb.get(null).longValue());
                this.j.zzac().c.set(this.j.zzx().currentTimeMillis());
            }
            this.j.zzab().zzgs().zza("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis2));
            h().zzv(currentTimeMillis2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Runnable runnable) {
        i();
        if (this.o == null) {
            this.o = new ArrayList();
        }
        this.o.add(runnable);
    }

    private final void m() {
        i();
        if (this.r || this.s || this.t) {
            this.j.zzab().zzgs().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.r), Boolean.valueOf(this.s), Boolean.valueOf(this.t));
            return;
        }
        this.j.zzab().zzgs().zzao("Stopping uploading service(s)");
        List<Runnable> list = this.o;
        if (list == null) {
            return;
        }
        Iterator<Runnable> it = list.iterator();
        while (it.hasNext()) {
            it.next().run();
        }
        this.o.clear();
    }

    private final Boolean b(de deVar) {
        try {
            if (deVar.k() != -2147483648L) {
                if (deVar.k() == Wrappers.packageManager(this.j.getContext()).getPackageInfo(deVar.b(), 0).versionCode) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.j.getContext()).getPackageInfo(deVar.b(), 0).versionName;
                if (deVar.j() != null && deVar.j().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @VisibleForTesting
    private final boolean n() {
        FileLock fileLock;
        i();
        if (this.j.zzad().zza(zzak.zzjh) && (fileLock = this.u) != null && fileLock.isValid()) {
            this.j.zzab().zzgs().zzao("Storage concurrent access okay");
            return true;
        }
        try {
            this.v = new RandomAccessFile(new File(this.j.getContext().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
            this.u = this.v.tryLock();
            if (this.u != null) {
                this.j.zzab().zzgs().zzao("Storage concurrent access okay");
                return true;
            }
            this.j.zzab().zzgk().zzao("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            this.j.zzab().zzgk().zza("Failed to acquire storage lock", e);
            return false;
        } catch (IOException e2) {
            this.j.zzab().zzgk().zza("Failed to access storage lock file", e2);
            return false;
        } catch (OverlappingFileLockException e3) {
            this.j.zzab().zzgn().zza("Storage lock already acquired", e3);
            return false;
        }
    }

    @VisibleForTesting
    private final int a(FileChannel fileChannel) {
        i();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.j.zzab().zzgk().zzao("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0L);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            }
            if (read != -1) {
                this.j.zzab().zzgn().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
            }
            return 0;
        } catch (IOException e) {
            this.j.zzab().zzgk().zza("Failed to read from channel", e);
            return 0;
        }
    }

    @VisibleForTesting
    private final boolean a(int i, FileChannel fileChannel) {
        i();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.j.zzab().zzgk().zzao("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0L);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.j.zzab().zzgk().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.j.zzab().zzgk().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        i();
        b();
        if (!this.m) {
            this.m = true;
            i();
            b();
            if ((this.j.zzad().zza(zzak.zzim) || o()) && n()) {
                int a2 = a(this.v);
                int f = this.j.zzr().f();
                i();
                if (a2 > f) {
                    this.j.zzab().zzgk().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a2), Integer.valueOf(f));
                } else if (a2 < f) {
                    if (a(f, this.v)) {
                        this.j.zzab().zzgs().zza("Storage version upgraded. Previous, current version", Integer.valueOf(a2), Integer.valueOf(f));
                    } else {
                        this.j.zzab().zzgk().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(a2), Integer.valueOf(f));
                    }
                }
            }
        }
        if (this.l || this.j.zzad().zza(zzak.zzim)) {
            return;
        }
        this.j.zzab().zzgq().zzao("This instance being marked as an uploader");
        this.l = true;
        l();
    }

    private final boolean o() {
        i();
        b();
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final void b(zzn zznVar) {
        if (this.w != null) {
            this.x = new ArrayList();
            this.x.addAll(this.w);
        }
        he zzgy = zzgy();
        String str = zznVar.packageName;
        Preconditions.checkNotEmpty(str);
        zzgy.zzo();
        zzgy.c();
        try {
            SQLiteDatabase g = zzgy.g();
            String[] strArr = {str};
            int delete = g.delete("apps", "app_id=?", strArr) + 0 + g.delete("events", "app_id=?", strArr) + g.delete("user_attributes", "app_id=?", strArr) + g.delete("conditional_properties", "app_id=?", strArr) + g.delete("raw_events", "app_id=?", strArr) + g.delete("raw_events_metadata", "app_id=?", strArr) + g.delete("queue", "app_id=?", strArr) + g.delete("audience_filter_values", "app_id=?", strArr) + g.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zzgy.zzab().zzgs().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzgy.zzab().zzgk().zza("Error resetting analytics data. appId, error", zzef.a(str), e);
        }
        zzn a2 = a(this.j.getContext(), zznVar.packageName, zznVar.zzcg, zznVar.zzcq, zznVar.zzcs, zznVar.zzct, zznVar.zzdr, zznVar.zzcu);
        if (zznVar.zzcq) {
            c(a2);
        }
    }

    private final zzn a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        String str5;
        String str6;
        int i;
        String str7 = "Unknown";
        str4 = "Unknown";
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.j.zzab().zzgk().zzao("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str7 = packageManager.getInstallerPackageName(str);
        } catch (IllegalArgumentException unused) {
            this.j.zzab().zzgk().zza("Error retrieving installer package name. appId", zzef.a(str));
        }
        if (str7 == null) {
            str5 = "manual_install";
        } else {
            str5 = "com.android.vending".equals(str7) ? "" : str7;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str);
                str4 = TextUtils.isEmpty(applicationLabel) ? "Unknown" : applicationLabel.toString();
                str6 = packageInfo.versionName;
                i = packageInfo.versionCode;
            } else {
                str6 = "Unknown";
                i = BleSignal.UNKNOWN_TX_POWER;
            }
            this.j.zzae();
            return new zzn(str, str2, str6, i, str5, this.j.zzad().zzao(), this.j.zzz().a(context, str), (String) null, z, false, "", 0L, this.j.zzad().g(str) ? j : 0L, 0, z2, z3, false, str3, (Boolean) null, 0L, (List<String>) null);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.j.zzab().zzgk().zza("Error retrieving newly installed package info. appId, appName", zzef.a(str), str4);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzjn zzjnVar, zzn zznVar) {
        c a2;
        i();
        b();
        if (TextUtils.isEmpty(zznVar.zzcg) && TextUtils.isEmpty(zznVar.zzcu)) {
            return;
        }
        if (!zznVar.zzcq) {
            e(zznVar);
            return;
        }
        int c = this.j.zzz().c(zzjnVar.name);
        if (c != 0) {
            this.j.zzz();
            this.j.zzz().a(zznVar.packageName, c, "_ev", zzjs.zza(zzjnVar.name, 24, true), zzjnVar.name != null ? zzjnVar.name.length() : 0);
            return;
        }
        int b = this.j.zzz().b(zzjnVar.name, zzjnVar.getValue());
        if (b != 0) {
            this.j.zzz();
            String zza = zzjs.zza(zzjnVar.name, 24, true);
            Object value = zzjnVar.getValue();
            this.j.zzz().a(zznVar.packageName, b, "_ev", zza, (value == null || !((value instanceof String) || (value instanceof CharSequence))) ? 0 : String.valueOf(value).length());
            return;
        }
        Object c2 = this.j.zzz().c(zzjnVar.name, zzjnVar.getValue());
        if (c2 == null) {
            return;
        }
        if ("_sid".equals(zzjnVar.name) && this.j.zzad().l(zznVar.packageName)) {
            long j = zzjnVar.zztr;
            String str = zzjnVar.origin;
            long j2 = 0;
            gv c3 = zzgy().c(zznVar.packageName, "_sno");
            if (c3 != null && (c3.e instanceof Long)) {
                j2 = ((Long) c3.e).longValue();
            } else {
                if (c3 != null) {
                    this.j.zzab().zzgn().zza("Retrieved last session number from database does not contain a valid (long) value", c3.e);
                }
                if (this.j.zzad().zze(zznVar.packageName, zzak.zzie) && (a2 = zzgy().a(zznVar.packageName, "_s")) != null) {
                    j2 = a2.c;
                    this.j.zzab().zzgs().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                }
            }
            a(new zzjn("_sno", j, Long.valueOf(j2 + 1), str), zznVar);
        }
        gv gvVar = new gv(zznVar.packageName, zzjnVar.origin, zzjnVar.name, zzjnVar.zztr, c2);
        this.j.zzab().zzgr().zza("Setting user property", this.j.zzy().c(gvVar.c), c2);
        zzgy().d();
        try {
            e(zznVar);
            boolean a3 = zzgy().a(gvVar);
            zzgy().e();
            if (a3) {
                this.j.zzab().zzgr().zza("User property set", this.j.zzy().c(gvVar.c), gvVar.e);
            } else {
                this.j.zzab().zzgk().zza("Too many unique user properties are set. Ignoring user property", this.j.zzy().c(gvVar.c), gvVar.e);
                this.j.zzz().a(zznVar.packageName, 9, (String) null, (String) null, 0);
            }
        } finally {
            zzgy().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzjn zzjnVar, zzn zznVar) {
        i();
        b();
        if (TextUtils.isEmpty(zznVar.zzcg) && TextUtils.isEmpty(zznVar.zzcu)) {
            return;
        }
        if (!zznVar.zzcq) {
            e(zznVar);
            return;
        }
        if (this.j.zzad().zze(zznVar.packageName, zzak.zzij)) {
            if ("_npa".equals(zzjnVar.name) && zznVar.zzcv != null) {
                this.j.zzab().zzgr().zzao("Falling back to manifest metadata value for ad personalization");
                a(new zzjn("_npa", this.j.zzx().currentTimeMillis(), Long.valueOf(zznVar.zzcv.booleanValue() ? 1L : 0L), "auto"), zznVar);
                return;
            }
            this.j.zzab().zzgr().zza("Removing user property", this.j.zzy().c(zzjnVar.name));
            zzgy().d();
            try {
                e(zznVar);
                zzgy().b(zznVar.packageName, zzjnVar.name);
                zzgy().e();
                this.j.zzab().zzgr().zza("User property removed", this.j.zzy().c(zzjnVar.name));
                return;
            } finally {
            }
        }
        this.j.zzab().zzgr().zza("Removing user property", this.j.zzy().c(zzjnVar.name));
        zzgy().d();
        try {
            e(zznVar);
            zzgy().b(zznVar.packageName, zzjnVar.name);
            zzgy().e();
            this.j.zzab().zzgr().zza("User property removed", this.j.zzy().c(zzjnVar.name));
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(gq gqVar) {
        this.p++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        this.q++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzfj f() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(zzn zznVar) {
        int i;
        c a2;
        long j;
        PackageInfo packageInfo;
        boolean z;
        gv c;
        i();
        b();
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.packageName);
        if (TextUtils.isEmpty(zznVar.zzcg) && TextUtils.isEmpty(zznVar.zzcu)) {
            return;
        }
        de b = zzgy().b(zznVar.packageName);
        if (b != null && TextUtils.isEmpty(b.d()) && !TextUtils.isEmpty(zznVar.zzcg)) {
            b.h(0L);
            zzgy().a(b);
            zzgz().d(zznVar.packageName);
        }
        if (!zznVar.zzcq) {
            e(zznVar);
            return;
        }
        long j2 = zznVar.zzdr;
        if (j2 == 0) {
            j2 = this.j.zzx().currentTimeMillis();
        }
        if (this.j.zzad().zze(zznVar.packageName, zzak.zzij)) {
            this.j.zzw().c();
        }
        int i2 = zznVar.zzds;
        if (i2 == 0 || i2 == 1) {
            i = i2;
        } else {
            this.j.zzab().zzgn().zza("Incorrect app type, assuming installed app. appId, appType", zzef.a(zznVar.packageName), Integer.valueOf(i2));
            i = 0;
        }
        zzgy().d();
        try {
            if (this.j.zzad().zze(zznVar.packageName, zzak.zzij) && ((c = zzgy().c(zznVar.packageName, "_npa")) == null || "auto".equals(c.b))) {
                if (zznVar.zzcv != null) {
                    zzjn zzjnVar = new zzjn("_npa", j2, Long.valueOf(zznVar.zzcv.booleanValue() ? 1L : 0L), "auto");
                    if (c == null || !c.e.equals(zzjnVar.zzts)) {
                        a(zzjnVar, zznVar);
                    }
                } else if (c != null) {
                    b(new zzjn("_npa", j2, null, "auto"), zznVar);
                }
            }
            de b2 = zzgy().b(zznVar.packageName);
            ApplicationInfo applicationInfo = null;
            if (b2 != null) {
                this.j.zzz();
                if (zzjs.a(zznVar.zzcg, b2.d(), zznVar.zzcu, b2.e())) {
                    this.j.zzab().zzgn().zza("New GMP App Id passed in. Removing cached database data. appId", zzef.a(b2.b()));
                    he zzgy = zzgy();
                    String b3 = b2.b();
                    zzgy.c();
                    zzgy.zzo();
                    Preconditions.checkNotEmpty(b3);
                    try {
                        SQLiteDatabase g = zzgy.g();
                        String[] strArr = {b3};
                        int delete = g.delete("events", "app_id=?", strArr) + 0 + g.delete("user_attributes", "app_id=?", strArr) + g.delete("conditional_properties", "app_id=?", strArr) + g.delete("apps", "app_id=?", strArr) + g.delete("raw_events", "app_id=?", strArr) + g.delete("raw_events_metadata", "app_id=?", strArr) + g.delete("event_filters", "app_id=?", strArr) + g.delete("property_filters", "app_id=?", strArr) + g.delete("audience_filter_values", "app_id=?", strArr);
                        if (delete > 0) {
                            zzgy.zzab().zzgs().zza("Deleted application data. app, records", b3, Integer.valueOf(delete));
                        }
                    } catch (SQLiteException e) {
                        zzgy.zzab().zzgk().zza("Error deleting application data. appId, error", zzef.a(b3), e);
                    }
                    b2 = null;
                }
            }
            if (b2 != null) {
                if (b2.k() != -2147483648L) {
                    if (b2.k() != zznVar.zzcn) {
                        Bundle bundle = new Bundle();
                        bundle.putString("_pv", b2.j());
                        a(new zzai("_au", new zzah(bundle), "auto", j2), zznVar);
                    }
                } else if (b2.j() != null && !b2.j().equals(zznVar.zzcm)) {
                    Bundle bundle2 = new Bundle();
                    bundle2.putString("_pv", b2.j());
                    a(new zzai("_au", new zzah(bundle2), "auto", j2), zznVar);
                }
            }
            e(zznVar);
            if (i == 0) {
                a2 = zzgy().a(zznVar.packageName, "_f");
            } else {
                a2 = i == 1 ? zzgy().a(zznVar.packageName, "_v") : null;
            }
            if (a2 == null) {
                long j3 = ((j2 / 3600000) + 1) * 3600000;
                if (i == 0) {
                    j = 1;
                    a(new zzjn("_fot", j2, Long.valueOf(j3), "auto"), zznVar);
                    if (this.j.zzad().i(zznVar.zzcg)) {
                        i();
                        this.j.zzht().a(zznVar.packageName);
                    }
                    i();
                    b();
                    Bundle bundle3 = new Bundle();
                    bundle3.putLong("_c", 1L);
                    bundle3.putLong("_r", 1L);
                    bundle3.putLong("_uwa", 0L);
                    bundle3.putLong("_pfo", 0L);
                    bundle3.putLong("_sys", 0L);
                    bundle3.putLong("_sysu", 0L);
                    if (this.j.zzad().o(zznVar.packageName)) {
                        bundle3.putLong("_et", 1L);
                    }
                    if (zznVar.zzdt) {
                        bundle3.putLong("_dac", 1L);
                    }
                    if (this.j.getContext().getPackageManager() == null) {
                        this.j.zzab().zzgk().zza("PackageManager is null, first open report might be inaccurate. appId", zzef.a(zznVar.packageName));
                    } else {
                        try {
                            packageInfo = Wrappers.packageManager(this.j.getContext()).getPackageInfo(zznVar.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e2) {
                            this.j.zzab().zzgk().zza("Package info is null, first open report might be inaccurate. appId", zzef.a(zznVar.packageName), e2);
                            packageInfo = null;
                        }
                        if (packageInfo != null && packageInfo.firstInstallTime != 0) {
                            if (packageInfo.firstInstallTime != packageInfo.lastUpdateTime) {
                                bundle3.putLong("_uwa", 1L);
                                z = false;
                            } else {
                                z = true;
                            }
                            a(new zzjn("_fi", j2, Long.valueOf(z ? 1L : 0L), "auto"), zznVar);
                        }
                        try {
                            applicationInfo = Wrappers.packageManager(this.j.getContext()).getApplicationInfo(zznVar.packageName, 0);
                        } catch (PackageManager.NameNotFoundException e3) {
                            this.j.zzab().zzgk().zza("Application info is null, first open report might be inaccurate. appId", zzef.a(zznVar.packageName), e3);
                        }
                        if (applicationInfo != null) {
                            if ((applicationInfo.flags & 1) != 0) {
                                bundle3.putLong("_sys", 1L);
                            }
                            if ((applicationInfo.flags & 128) != 0) {
                                bundle3.putLong("_sysu", 1L);
                            }
                        }
                    }
                    he zzgy2 = zzgy();
                    String str = zznVar.packageName;
                    Preconditions.checkNotEmpty(str);
                    zzgy2.zzo();
                    zzgy2.c();
                    long h = zzgy2.h(str, "first_open_count");
                    if (h >= 0) {
                        bundle3.putLong("_pfo", h);
                    }
                    a(new zzai("_f", new zzah(bundle3), "auto", j2), zznVar);
                } else {
                    j = 1;
                    if (i == 1) {
                        a(new zzjn("_fvt", j2, Long.valueOf(j3), "auto"), zznVar);
                        i();
                        b();
                        Bundle bundle4 = new Bundle();
                        bundle4.putLong("_c", 1L);
                        bundle4.putLong("_r", 1L);
                        if (this.j.zzad().o(zznVar.packageName)) {
                            bundle4.putLong("_et", 1L);
                        }
                        if (zznVar.zzdt) {
                            bundle4.putLong("_dac", 1L);
                        }
                        a(new zzai("_v", new zzah(bundle4), "auto", j2), zznVar);
                    }
                }
                if (!this.j.zzad().zze(zznVar.packageName, zzak.zzii)) {
                    Bundle bundle5 = new Bundle();
                    bundle5.putLong("_et", j);
                    if (this.j.zzad().o(zznVar.packageName)) {
                        bundle5.putLong("_fr", j);
                    }
                    a(new zzai("_e", new zzah(bundle5), "auto", j2), zznVar);
                }
            } else if (zznVar.zzdq) {
                a(new zzai("_cd", new zzah(new Bundle()), "auto", j2), zznVar);
            }
            zzgy().e();
        } finally {
            zzgy().f();
        }
    }

    private final zzn a(String str) {
        de b = zzgy().b(str);
        if (b == null || TextUtils.isEmpty(b.j())) {
            this.j.zzab().zzgr().zza("No app data available; dropping", str);
            return null;
        }
        Boolean b2 = b(b);
        if (b2 != null && !b2.booleanValue()) {
            this.j.zzab().zzgk().zza("App version does not match; dropping. appId", zzef.a(str));
            return null;
        }
        return new zzn(str, b.d(), b.j(), b.k(), b.l(), b.m(), b.n(), (String) null, b.p(), false, b.g(), b.C(), 0L, 0, b.D(), b.E(), false, b.e(), b.F(), b.o(), b.G());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzq zzqVar) {
        zzn a2 = a(zzqVar.packageName);
        if (a2 != null) {
            a(zzqVar, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzq zzqVar, zzn zznVar) {
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.packageName);
        Preconditions.checkNotNull(zzqVar.origin);
        Preconditions.checkNotNull(zzqVar.zzdw);
        Preconditions.checkNotEmpty(zzqVar.zzdw.name);
        i();
        b();
        if (TextUtils.isEmpty(zznVar.zzcg) && TextUtils.isEmpty(zznVar.zzcu)) {
            return;
        }
        if (!zznVar.zzcq) {
            e(zznVar);
            return;
        }
        zzq zzqVar2 = new zzq(zzqVar);
        boolean z = false;
        zzqVar2.active = false;
        zzgy().d();
        try {
            zzq d = zzgy().d(zzqVar2.packageName, zzqVar2.zzdw.name);
            if (d != null && !d.origin.equals(zzqVar2.origin)) {
                this.j.zzab().zzgn().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.j.zzy().c(zzqVar2.zzdw.name), zzqVar2.origin, d.origin);
            }
            if (d != null && d.active) {
                zzqVar2.origin = d.origin;
                zzqVar2.creationTimestamp = d.creationTimestamp;
                zzqVar2.triggerTimeout = d.triggerTimeout;
                zzqVar2.triggerEventName = d.triggerEventName;
                zzqVar2.zzdy = d.zzdy;
                zzqVar2.active = d.active;
                zzqVar2.zzdw = new zzjn(zzqVar2.zzdw.name, d.zzdw.zztr, zzqVar2.zzdw.getValue(), d.zzdw.origin);
            } else if (TextUtils.isEmpty(zzqVar2.triggerEventName)) {
                zzqVar2.zzdw = new zzjn(zzqVar2.zzdw.name, zzqVar2.creationTimestamp, zzqVar2.zzdw.getValue(), zzqVar2.zzdw.origin);
                zzqVar2.active = true;
                z = true;
            }
            if (zzqVar2.active) {
                zzjn zzjnVar = zzqVar2.zzdw;
                gv gvVar = new gv(zzqVar2.packageName, zzqVar2.origin, zzjnVar.name, zzjnVar.zztr, zzjnVar.getValue());
                if (zzgy().a(gvVar)) {
                    this.j.zzab().zzgr().zza("User property updated immediately", zzqVar2.packageName, this.j.zzy().c(gvVar.c), gvVar.e);
                } else {
                    this.j.zzab().zzgk().zza("(2)Too many active user properties, ignoring", zzef.a(zzqVar2.packageName), this.j.zzy().c(gvVar.c), gvVar.e);
                }
                if (z && zzqVar2.zzdy != null) {
                    b(new zzai(zzqVar2.zzdy, zzqVar2.creationTimestamp), zznVar);
                }
            }
            if (zzgy().a(zzqVar2)) {
                this.j.zzab().zzgr().zza("Conditional property added", zzqVar2.packageName, this.j.zzy().c(zzqVar2.zzdw.name), zzqVar2.zzdw.getValue());
            } else {
                this.j.zzab().zzgk().zza("Too many conditional properties, ignoring", zzef.a(zzqVar2.packageName), this.j.zzy().c(zzqVar2.zzdw.name), zzqVar2.zzdw.getValue());
            }
            zzgy().e();
        } finally {
            zzgy().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzq zzqVar) {
        zzn a2 = a(zzqVar.packageName);
        if (a2 != null) {
            b(zzqVar, a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(zzq zzqVar, zzn zznVar) {
        Preconditions.checkNotNull(zzqVar);
        Preconditions.checkNotEmpty(zzqVar.packageName);
        Preconditions.checkNotNull(zzqVar.zzdw);
        Preconditions.checkNotEmpty(zzqVar.zzdw.name);
        i();
        b();
        if (TextUtils.isEmpty(zznVar.zzcg) && TextUtils.isEmpty(zznVar.zzcu)) {
            return;
        }
        if (!zznVar.zzcq) {
            e(zznVar);
            return;
        }
        zzgy().d();
        try {
            e(zznVar);
            zzq d = zzgy().d(zzqVar.packageName, zzqVar.zzdw.name);
            if (d != null) {
                this.j.zzab().zzgr().zza("Removing conditional user property", zzqVar.packageName, this.j.zzy().c(zzqVar.zzdw.name));
                zzgy().e(zzqVar.packageName, zzqVar.zzdw.name);
                if (d.active) {
                    zzgy().b(zzqVar.packageName, zzqVar.zzdw.name);
                }
                if (zzqVar.zzdz != null) {
                    b(this.j.zzz().a(zzqVar.packageName, zzqVar.zzdz.name, zzqVar.zzdz.zzfq != null ? zzqVar.zzdz.zzfq.zzcv() : null, d.origin, zzqVar.zzdz.zzfu, true, false), zznVar);
                }
            } else {
                this.j.zzab().zzgn().zza("Conditional user property doesn't exist", zzef.a(zzqVar.packageName), this.j.zzy().c(zzqVar.zzdw.name));
            }
            zzgy().e();
        } finally {
            zzgy().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final de e(zzn zznVar) {
        boolean z;
        i();
        b();
        Preconditions.checkNotNull(zznVar);
        Preconditions.checkNotEmpty(zznVar.packageName);
        de b = zzgy().b(zznVar.packageName);
        String b2 = this.j.zzac().b(zznVar.packageName);
        if (b == null) {
            b = new de(this.j, zznVar.packageName);
            b.a(this.j.zzz().e());
            b.d(b2);
            z = true;
        } else if (b2.equals(b.f())) {
            z = false;
        } else {
            b.d(b2);
            b.a(this.j.zzz().e());
            z = true;
        }
        if (!TextUtils.equals(zznVar.zzcg, b.d())) {
            b.b(zznVar.zzcg);
            z = true;
        }
        if (!TextUtils.equals(zznVar.zzcu, b.e())) {
            b.c(zznVar.zzcu);
            z = true;
        }
        if (!TextUtils.isEmpty(zznVar.zzci) && !zznVar.zzci.equals(b.g())) {
            b.e(zznVar.zzci);
            z = true;
        }
        if (zznVar.zzr != 0 && zznVar.zzr != b.m()) {
            b.d(zznVar.zzr);
            z = true;
        }
        if (!TextUtils.isEmpty(zznVar.zzcm) && !zznVar.zzcm.equals(b.j())) {
            b.f(zznVar.zzcm);
            z = true;
        }
        if (zznVar.zzcn != b.k()) {
            b.c(zznVar.zzcn);
            z = true;
        }
        if (zznVar.zzco != null && !zznVar.zzco.equals(b.l())) {
            b.g(zznVar.zzco);
            z = true;
        }
        if (zznVar.zzcp != b.n()) {
            b.e(zznVar.zzcp);
            z = true;
        }
        if (zznVar.zzcq != b.p()) {
            b.a(zznVar.zzcq);
            z = true;
        }
        if (!TextUtils.isEmpty(zznVar.zzdp) && !zznVar.zzdp.equals(b.A())) {
            b.h(zznVar.zzdp);
            z = true;
        }
        if (zznVar.zzcr != b.C()) {
            b.p(zznVar.zzcr);
            z = true;
        }
        if (zznVar.zzcs != b.D()) {
            b.b(zznVar.zzcs);
            z = true;
        }
        if (zznVar.zzct != b.E()) {
            b.c(zznVar.zzct);
            z = true;
        }
        if (this.j.zzad().zze(zznVar.packageName, zzak.zzij) && zznVar.zzcv != b.F()) {
            b.a(zznVar.zzcv);
            z = true;
        }
        if (zznVar.zzs != 0 && zznVar.zzs != b.o()) {
            b.f(zznVar.zzs);
            z = true;
        }
        if (z) {
            zzgy().a(b);
        }
        return b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d(zzn zznVar) {
        try {
            return (String) this.j.zzaa().zza(new gt(this, zznVar)).get(30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.j.zzab().zzgk().zza("Failed to get app instance id. appId", zzef.a(zznVar.packageName), e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(boolean z) {
        l();
    }
}
