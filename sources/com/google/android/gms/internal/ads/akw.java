package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* loaded from: classes2.dex */
final class akw implements Handler.Callback, zzqk, zzqm, zzrq {
    private int A;
    private aky B;
    private long C;
    private akx D;
    private akx E;
    private akx F;
    private zzlr G;

    /* renamed from: a, reason: collision with root package name */
    private final zzlo[] f1943a;
    private final zzlp[] b;
    private final zzrp c;
    private final zzll d;
    private final zzsw e;
    private final Handler f;
    private final HandlerThread g;
    private final Handler h;
    private final zzkv i;
    private final zzlu j;
    private final zzlt k;
    private zzle l;
    private zzln m;
    private zzlo n;
    private zzso o;
    private zzql p;
    private zzlo[] q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int x;
    private int y;
    private long z;
    private int w = 0;
    private int v = 1;

    public akw(zzlo[] zzloVarArr, zzrp zzrpVar, zzll zzllVar, boolean z, int i, Handler handler, zzle zzleVar, zzkv zzkvVar) {
        this.f1943a = zzloVarArr;
        this.c = zzrpVar;
        this.d = zzllVar;
        this.s = z;
        this.h = handler;
        this.l = zzleVar;
        this.i = zzkvVar;
        this.b = new zzlp[zzloVarArr.length];
        for (int i2 = 0; i2 < zzloVarArr.length; i2++) {
            zzloVarArr[i2].setIndex(i2);
            this.b[i2] = zzloVarArr[i2].zzgi();
        }
        this.e = new zzsw();
        this.q = new zzlo[0];
        this.j = new zzlu();
        this.k = new zzlt();
        zzrpVar.zza(this);
        this.m = zzln.zzaug;
        this.g = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g.start();
        this.f = new Handler(this.g.getLooper(), this);
    }

    public final void a(zzql zzqlVar, boolean z) {
        this.f.obtainMessage(0, 1, 0, zzqlVar).sendToTarget();
    }

    public final void a(boolean z) {
        this.f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void a(zzlr zzlrVar, int i, long j) {
        this.f.obtainMessage(3, new aky(zzlrVar, i, j)).sendToTarget();
    }

    public final void a() {
        this.f.sendEmptyMessage(5);
    }

    public final void a(zzky... zzkyVarArr) {
        if (this.r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            this.x++;
            this.f.obtainMessage(11, zzkyVarArr).sendToTarget();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void b(zzky... zzkyVarArr) {
        if (this.r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.x;
        this.x = i + 1;
        this.f.obtainMessage(11, zzkyVarArr).sendToTarget();
        while (this.y <= i) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void b() {
        if (this.r) {
            return;
        }
        this.f.sendEmptyMessage(6);
        while (!this.r) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.g.quit();
    }

    @Override // com.google.android.gms.internal.ads.zzqm
    public final void zzb(zzlr zzlrVar, Object obj) {
        this.f.obtainMessage(7, Pair.create(zzlrVar, obj)).sendToTarget();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzqk
    public final void zza(zzqj zzqjVar) {
        this.f.obtainMessage(8, zzqjVar).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzrq
    public final void zzgv() {
        this.f.sendEmptyMessage(10);
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x028f A[Catch: IOException -> 0x08b9, zzku -> 0x08be, RuntimeException -> 0x08c3, TryCatch #4 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04cb, B:401:0x04d3, B:402:0x05b1, B:404:0x05b5, B:407:0x05be, B:409:0x05c2, B:411:0x05c6, B:412:0x05cd, B:414:0x05d1, B:416:0x05d7, B:418:0x05e3, B:420:0x060e, B:423:0x0615, B:425:0x061a, B:427:0x0626, B:429:0x062c, B:431:0x0632, B:433:0x0635, B:439:0x0639, B:441:0x063e, B:444:0x0650, B:449:0x0658, B:453:0x065b, B:455:0x0661, B:457:0x0669, B:461:0x068c, B:463:0x0691, B:466:0x069f, B:468:0x06a5, B:470:0x06b5, B:472:0x06bb, B:473:0x06c2, B:475:0x06c5, B:477:0x06ce, B:481:0x06de, B:479:0x06e1, B:487:0x05ca, B:488:0x04db, B:490:0x04df, B:491:0x053b, B:493:0x053f, B:494:0x055d, B:497:0x056b, B:499:0x059f, B:500:0x05a3, B:501:0x0564, B:502:0x0546, B:503:0x04e5, B:506:0x04f7, B:508:0x052a, B:509:0x0487, B:511:0x0491, B:513:0x0499, B:516:0x04aa, B:518:0x04ae, B:522:0x04bf, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0296 A[Catch: IOException -> 0x08b9, zzku -> 0x08be, RuntimeException -> 0x08c3, TryCatch #4 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04cb, B:401:0x04d3, B:402:0x05b1, B:404:0x05b5, B:407:0x05be, B:409:0x05c2, B:411:0x05c6, B:412:0x05cd, B:414:0x05d1, B:416:0x05d7, B:418:0x05e3, B:420:0x060e, B:423:0x0615, B:425:0x061a, B:427:0x0626, B:429:0x062c, B:431:0x0632, B:433:0x0635, B:439:0x0639, B:441:0x063e, B:444:0x0650, B:449:0x0658, B:453:0x065b, B:455:0x0661, B:457:0x0669, B:461:0x068c, B:463:0x0691, B:466:0x069f, B:468:0x06a5, B:470:0x06b5, B:472:0x06bb, B:473:0x06c2, B:475:0x06c5, B:477:0x06ce, B:481:0x06de, B:479:0x06e1, B:487:0x05ca, B:488:0x04db, B:490:0x04df, B:491:0x053b, B:493:0x053f, B:494:0x055d, B:497:0x056b, B:499:0x059f, B:500:0x05a3, B:501:0x0564, B:502:0x0546, B:503:0x04e5, B:506:0x04f7, B:508:0x052a, B:509:0x0487, B:511:0x0491, B:513:0x0499, B:516:0x04aa, B:518:0x04ae, B:522:0x04bf, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0292 A[Catch: IOException -> 0x08b9, zzku -> 0x08be, RuntimeException -> 0x08c3, TryCatch #4 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04cb, B:401:0x04d3, B:402:0x05b1, B:404:0x05b5, B:407:0x05be, B:409:0x05c2, B:411:0x05c6, B:412:0x05cd, B:414:0x05d1, B:416:0x05d7, B:418:0x05e3, B:420:0x060e, B:423:0x0615, B:425:0x061a, B:427:0x0626, B:429:0x062c, B:431:0x0632, B:433:0x0635, B:439:0x0639, B:441:0x063e, B:444:0x0650, B:449:0x0658, B:453:0x065b, B:455:0x0661, B:457:0x0669, B:461:0x068c, B:463:0x0691, B:466:0x069f, B:468:0x06a5, B:470:0x06b5, B:472:0x06bb, B:473:0x06c2, B:475:0x06c5, B:477:0x06ce, B:481:0x06de, B:479:0x06e1, B:487:0x05ca, B:488:0x04db, B:490:0x04df, B:491:0x053b, B:493:0x053f, B:494:0x055d, B:497:0x056b, B:499:0x059f, B:500:0x05a3, B:501:0x0564, B:502:0x0546, B:503:0x04e5, B:506:0x04f7, B:508:0x052a, B:509:0x0487, B:511:0x0491, B:513:0x0499, B:516:0x04aa, B:518:0x04ae, B:522:0x04bf, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0733 A[Catch: IOException -> 0x08b9, zzku -> 0x08be, RuntimeException -> 0x08c3, TryCatch #4 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04cb, B:401:0x04d3, B:402:0x05b1, B:404:0x05b5, B:407:0x05be, B:409:0x05c2, B:411:0x05c6, B:412:0x05cd, B:414:0x05d1, B:416:0x05d7, B:418:0x05e3, B:420:0x060e, B:423:0x0615, B:425:0x061a, B:427:0x0626, B:429:0x062c, B:431:0x0632, B:433:0x0635, B:439:0x0639, B:441:0x063e, B:444:0x0650, B:449:0x0658, B:453:0x065b, B:455:0x0661, B:457:0x0669, B:461:0x068c, B:463:0x0691, B:466:0x069f, B:468:0x06a5, B:470:0x06b5, B:472:0x06bb, B:473:0x06c2, B:475:0x06c5, B:477:0x06ce, B:481:0x06de, B:479:0x06e1, B:487:0x05ca, B:488:0x04db, B:490:0x04df, B:491:0x053b, B:493:0x053f, B:494:0x055d, B:497:0x056b, B:499:0x059f, B:500:0x05a3, B:501:0x0564, B:502:0x0546, B:503:0x04e5, B:506:0x04f7, B:508:0x052a, B:509:0x0487, B:511:0x0491, B:513:0x0499, B:516:0x04aa, B:518:0x04ae, B:522:0x04bf, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x07ec  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x05d1 A[Catch: IOException -> 0x08b9, zzku -> 0x08be, RuntimeException -> 0x08c3, LOOP:9: B:414:0x05d1->B:418:0x05e3, LOOP_START, TryCatch #4 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04cb, B:401:0x04d3, B:402:0x05b1, B:404:0x05b5, B:407:0x05be, B:409:0x05c2, B:411:0x05c6, B:412:0x05cd, B:414:0x05d1, B:416:0x05d7, B:418:0x05e3, B:420:0x060e, B:423:0x0615, B:425:0x061a, B:427:0x0626, B:429:0x062c, B:431:0x0632, B:433:0x0635, B:439:0x0639, B:441:0x063e, B:444:0x0650, B:449:0x0658, B:453:0x065b, B:455:0x0661, B:457:0x0669, B:461:0x068c, B:463:0x0691, B:466:0x069f, B:468:0x06a5, B:470:0x06b5, B:472:0x06bb, B:473:0x06c2, B:475:0x06c5, B:477:0x06ce, B:481:0x06de, B:479:0x06e1, B:487:0x05ca, B:488:0x04db, B:490:0x04df, B:491:0x053b, B:493:0x053f, B:494:0x055d, B:497:0x056b, B:499:0x059f, B:500:0x05a3, B:501:0x0564, B:502:0x0546, B:503:0x04e5, B:506:0x04f7, B:508:0x052a, B:509:0x0487, B:511:0x0491, B:513:0x0499, B:516:0x04aa, B:518:0x04ae, B:522:0x04bf, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            Method dump skipped, instructions count: 2354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.akw.handleMessage(android.os.Message):boolean");
    }

    private final void a(int i) {
        if (this.v != i) {
            this.v = i;
            this.h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void b(boolean z) {
        if (this.u != z) {
            this.u = z;
            this.h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void c() throws zzku {
        this.t = false;
        this.e.start();
        for (zzlo zzloVar : this.q) {
            zzloVar.start();
        }
    }

    private final void d() throws zzku {
        this.e.stop();
        for (zzlo zzloVar : this.q) {
            a(zzloVar);
        }
    }

    private final void e() throws zzku {
        akx akxVar = this.F;
        if (akxVar == null) {
            return;
        }
        long zzja = akxVar.f1944a.zzja();
        if (zzja != -9223372036854775807L) {
            a(zzja);
        } else {
            zzlo zzloVar = this.n;
            if (zzloVar != null && !zzloVar.zzdx()) {
                this.C = this.o.zzdv();
                this.e.zzdj(this.C);
            } else {
                this.C = this.e.zzdv();
            }
            zzja = this.C - this.F.a();
        }
        this.l.zzacl = zzja;
        this.z = SystemClock.elapsedRealtime() * 1000;
        long zzdu = this.q.length == 0 ? Long.MIN_VALUE : this.F.f1944a.zzdu();
        zzle zzleVar = this.l;
        if (zzdu == Long.MIN_VALUE) {
            zzdu = this.G.zza(this.F.f, this.k, false).zzack;
        }
        zzleVar.zzacm = zzdu;
    }

    private final void a(long j, long j2) {
        this.f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f.sendEmptyMessage(2);
        } else {
            this.f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final long a(int i, long j) throws zzku {
        akx akxVar;
        d();
        this.t = false;
        a(2);
        akx akxVar2 = this.F;
        if (akxVar2 == null) {
            akx akxVar3 = this.D;
            if (akxVar3 != null) {
                akxVar3.d();
            }
            akxVar = null;
        } else {
            akxVar = null;
            while (akxVar2 != null) {
                if (akxVar2.f == i && akxVar2.i) {
                    akxVar = akxVar2;
                } else {
                    akxVar2.d();
                }
                akxVar2 = akxVar2.k;
            }
        }
        akx akxVar4 = this.F;
        if (akxVar4 != akxVar || akxVar4 != this.E) {
            for (zzlo zzloVar : this.q) {
                zzloVar.disable();
            }
            this.q = new zzlo[0];
            this.o = null;
            this.n = null;
            this.F = null;
        }
        if (akxVar != null) {
            akxVar.k = null;
            this.D = akxVar;
            this.E = akxVar;
            b(akxVar);
            if (this.F.j) {
                j = this.F.f1944a.zzen(j);
            }
            a(j);
            h();
        } else {
            this.D = null;
            this.E = null;
            this.F = null;
            a(j);
        }
        this.f.sendEmptyMessage(2);
        return j;
    }

    private final void a(long j) throws zzku {
        akx akxVar = this.F;
        this.C = akxVar == null ? j + 60000000 : j + akxVar.a();
        this.e.zzdj(this.C);
        for (zzlo zzloVar : this.q) {
            zzloVar.zzdx(this.C);
        }
    }

    private final void f() {
        c(true);
        this.d.onStopped();
        a(1);
    }

    private final void c(boolean z) {
        this.f.removeMessages(2);
        this.t = false;
        this.e.stop();
        this.o = null;
        this.n = null;
        this.C = 60000000L;
        for (zzlo zzloVar : this.q) {
            try {
                a(zzloVar);
                zzloVar.disable();
            } catch (zzku | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.q = new zzlo[0];
        akx akxVar = this.F;
        if (akxVar == null) {
            akxVar = this.D;
        }
        a(akxVar);
        this.D = null;
        this.E = null;
        this.F = null;
        b(false);
        if (z) {
            zzql zzqlVar = this.p;
            if (zzqlVar != null) {
                zzqlVar.zzjg();
                this.p = null;
            }
            this.G = null;
        }
    }

    private static void a(zzlo zzloVar) throws zzku {
        if (zzloVar.getState() == 2) {
            zzloVar.stop();
        }
    }

    private final boolean b(long j) {
        if (j == -9223372036854775807L || this.l.zzacl < j) {
            return true;
        }
        return this.F.k != null && this.F.k.i;
    }

    private final void g() throws IOException {
        akx akxVar = this.D;
        if (akxVar == null || akxVar.i) {
            return;
        }
        akx akxVar2 = this.E;
        if (akxVar2 == null || akxVar2.k == this.D) {
            for (zzlo zzloVar : this.q) {
                if (!zzloVar.zzgl()) {
                    return;
                }
            }
            this.D.f1944a.zziy();
        }
    }

    private final void a(Object obj, int i) {
        this.l = new zzle(0, 0L);
        b(obj, i);
        this.l = new zzle(0, -9223372036854775807L);
        a(4);
        c(false);
    }

    private final void b(Object obj, int i) {
        this.h.obtainMessage(6, new zzlg(this.G, obj, this.l, i)).sendToTarget();
    }

    private final int a(int i, zzlr zzlrVar, zzlr zzlrVar2) {
        int zzhg = zzlrVar.zzhg();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < zzhg && i3 == -1; i4++) {
            i2 = zzlrVar.zza(i2, this.k, this.j, this.w);
            i3 = zzlrVar2.zzc(zzlrVar.zza(i2, this.k, true).zzasx);
        }
        return i3;
    }

    private final boolean b(int i) {
        this.G.zza(i, this.k, false);
        return !this.G.zza(0, this.j, false).zzaut && this.G.zza(i, this.k, this.j, this.w) == -1;
    }

    private final Pair<Integer, Long> a(aky akyVar) {
        zzlr zzlrVar = akyVar.f1945a;
        if (zzlrVar.isEmpty()) {
            zzlrVar = this.G;
        }
        try {
            Pair<Integer, Long> b = b(zzlrVar, akyVar.b, akyVar.c);
            zzlr zzlrVar2 = this.G;
            if (zzlrVar2 == zzlrVar) {
                return b;
            }
            int zzc = zzlrVar2.zzc(zzlrVar.zza(((Integer) b.first).intValue(), this.k, true).zzasx);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) b.second);
            }
            int a2 = a(((Integer) b.first).intValue(), zzlrVar, this.G);
            if (a2 == -1) {
                return null;
            }
            this.G.zza(a2, this.k, false);
            return b(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzlk(this.G, akyVar.b, akyVar.c);
        }
    }

    private final Pair<Integer, Long> b(int i, long j) {
        return b(this.G, i, -9223372036854775807L);
    }

    private final Pair<Integer, Long> b(zzlr zzlrVar, int i, long j) {
        return a(zzlrVar, i, j, 0L);
    }

    private final Pair<Integer, Long> a(zzlr zzlrVar, int i, long j, long j2) {
        zzsk.zzc(i, 0, zzlrVar.zzhf());
        zzlrVar.zza(i, this.j, false, j2);
        if (j == -9223372036854775807L) {
            j = this.j.zzauw;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.j.zzaux + j;
        zzlrVar.zza(0, this.k, false);
        return Pair.create(0, Long.valueOf(j3));
    }

    private final void h() {
        long zzix = !this.D.i ? 0L : this.D.f1944a.zzix();
        if (zzix == Long.MIN_VALUE) {
            b(false);
            return;
        }
        long a2 = this.C - this.D.a();
        boolean zzee = this.d.zzee(zzix - a2);
        b(zzee);
        if (zzee) {
            this.D.f1944a.zzel(a2);
        }
    }

    private static void a(akx akxVar) {
        while (akxVar != null) {
            akxVar.d();
            akxVar = akxVar.k;
        }
    }

    private final void b(akx akxVar) throws zzku {
        if (this.F == akxVar) {
            return;
        }
        boolean[] zArr = new boolean[this.f1943a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            zzlo[] zzloVarArr = this.f1943a;
            if (i < zzloVarArr.length) {
                zzlo zzloVar = zzloVarArr[i];
                zArr[i] = zzloVar.getState() != 0;
                zzrm zzbi = akxVar.l.zzblz.zzbi(i);
                if (zzbi != null) {
                    i2++;
                }
                if (zArr[i] && (zzbi == null || (zzloVar.zzgn() && zzloVar.zzgk() == this.F.d[i]))) {
                    if (zzloVar == this.n) {
                        this.e.zza(this.o);
                        this.o = null;
                        this.n = null;
                    }
                    a(zzloVar);
                    zzloVar.disable();
                }
                i++;
            } else {
                this.F = akxVar;
                this.h.obtainMessage(3, akxVar.l).sendToTarget();
                a(zArr, i2);
                return;
            }
        }
    }

    private final void a(boolean[] zArr, int i) throws zzku {
        this.q = new zzlo[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzlo[] zzloVarArr = this.f1943a;
            if (i2 >= zzloVarArr.length) {
                return;
            }
            zzlo zzloVar = zzloVarArr[i2];
            zzrm zzbi = this.F.l.zzblz.zzbi(i2);
            if (zzbi != null) {
                int i4 = i3 + 1;
                this.q[i3] = zzloVar;
                if (zzloVar.getState() == 0) {
                    zzlq zzlqVar = this.F.l.zzbmb[i2];
                    boolean z = this.s && this.v == 3;
                    boolean z2 = !zArr[i2] && z;
                    zzlh[] zzlhVarArr = new zzlh[zzbi.length()];
                    for (int i5 = 0; i5 < zzlhVarArr.length; i5++) {
                        zzlhVarArr[i5] = zzbi.zzbf(i5);
                    }
                    zzloVar.zza(zzlqVar, zzlhVarArr, this.F.d[i2], this.C, z2, this.F.a());
                    zzso zzgj = zzloVar.zzgj();
                    if (zzgj != null) {
                        if (this.o != null) {
                            throw zzku.a(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                        this.o = zzgj;
                        this.n = zzloVar;
                        this.o.zzb(this.m);
                    }
                    if (z) {
                        zzloVar.start();
                    }
                }
                i3 = i4;
            }
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqy
    public final /* synthetic */ void zza(zzqj zzqjVar) {
        this.f.obtainMessage(9, zzqjVar).sendToTarget();
    }
}
