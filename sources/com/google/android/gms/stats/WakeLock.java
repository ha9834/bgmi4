package com.google.android.gms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.ThreadSafe;

@ShowFirstParty
@ThreadSafe
@KeepForSdk
/* loaded from: classes2.dex */
public class WakeLock {
    private static ScheduledExecutorService n;
    private static volatile zza o = new a();

    /* renamed from: a, reason: collision with root package name */
    private final Object f5059a;
    private final PowerManager.WakeLock b;
    private WorkSource c;
    private final int d;
    private final String e;
    private final String f;
    private final String g;
    private final Context h;
    private boolean i;
    private final Map<String, Integer[]> j;
    private final Set<Future<?>> k;
    private int l;
    private AtomicInteger m;

    /* loaded from: classes2.dex */
    public interface zza {
    }

    @KeepForSdk
    public WakeLock(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    private WakeLock(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, null, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    private WakeLock(Context context, int i, String str, String str2, String str3, String str4) {
        this.f5059a = this;
        this.i = true;
        this.j = new HashMap();
        this.k = Collections.synchronizedSet(new HashSet());
        this.m = new AtomicInteger(0);
        Preconditions.checkNotNull(context, "WakeLock: context must not be null");
        Preconditions.checkNotEmpty(str, "WakeLock: wakeLockName must not be empty");
        this.d = i;
        this.f = null;
        this.g = null;
        this.h = context.getApplicationContext();
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            String valueOf = String.valueOf("*gcore*:");
            String valueOf2 = String.valueOf(str);
            this.e = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        } else {
            this.e = str;
        }
        this.b = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (WorkSourceUtil.hasWorkSourcePermission(context)) {
            this.c = WorkSourceUtil.fromPackage(context, Strings.isEmptyOrWhitespace(str3) ? context.getPackageName() : str3);
            WorkSource workSource = this.c;
            if (workSource != null && WorkSourceUtil.hasWorkSourcePermission(this.h)) {
                WorkSource workSource2 = this.c;
                if (workSource2 != null) {
                    workSource2.add(workSource);
                } else {
                    this.c = workSource;
                }
                try {
                    this.b.setWorkSource(this.c);
                } catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
                    Log.wtf("WakeLock", e.toString());
                }
            }
        }
        if (n == null) {
            n = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
        }
    }

    private final List<String> a() {
        return WorkSourceUtil.getNames(this.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        if (r2 == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
    
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r13.h, com.google.android.gms.common.stats.StatsUtils.getEventKey(r13.b, r6), 7, r13.e, r6, null, r13.d, a(), r14);
        r13.l++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r13.l == 0) goto L22;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void acquire(long r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r13.m
            r0.incrementAndGet()
            r0 = 0
            java.lang.String r6 = r13.a(r0)
            java.lang.Object r0 = r13.f5059a
            monitor-enter(r0)
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.j     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L96
            r2 = 0
            if (r1 == 0) goto L1a
            int r1 = r13.l     // Catch: java.lang.Throwable -> L96
            if (r1 <= 0) goto L29
        L1a:
            android.os.PowerManager$WakeLock r1 = r13.b     // Catch: java.lang.Throwable -> L96
            boolean r1 = r1.isHeld()     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L29
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.j     // Catch: java.lang.Throwable -> L96
            r1.clear()     // Catch: java.lang.Throwable -> L96
            r13.l = r2     // Catch: java.lang.Throwable -> L96
        L29:
            boolean r1 = r13.i     // Catch: java.lang.Throwable -> L96
            r12 = 1
            if (r1 == 0) goto L56
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.j     // Catch: java.lang.Throwable -> L96
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L47
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r13.j     // Catch: java.lang.Throwable -> L96
            java.lang.Integer[] r3 = new java.lang.Integer[r12]     // Catch: java.lang.Throwable -> L96
            java.lang.Integer r4 = java.lang.Integer.valueOf(r12)     // Catch: java.lang.Throwable -> L96
            r3[r2] = r4     // Catch: java.lang.Throwable -> L96
            r1.put(r6, r3)     // Catch: java.lang.Throwable -> L96
            r2 = 1
            goto L54
        L47:
            r3 = r1[r2]     // Catch: java.lang.Throwable -> L96
            int r3 = r3.intValue()     // Catch: java.lang.Throwable -> L96
            int r3 = r3 + r12
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L96
            r1[r2] = r3     // Catch: java.lang.Throwable -> L96
        L54:
            if (r2 != 0) goto L5e
        L56:
            boolean r1 = r13.i     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
            int r1 = r13.l     // Catch: java.lang.Throwable -> L96
            if (r1 != 0) goto L7d
        L5e:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch: java.lang.Throwable -> L96
            android.content.Context r2 = r13.h     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r3 = r13.b     // Catch: java.lang.Throwable -> L96
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.getEventKey(r3, r6)     // Catch: java.lang.Throwable -> L96
            r4 = 7
            java.lang.String r5 = r13.e     // Catch: java.lang.Throwable -> L96
            r7 = 0
            int r8 = r13.d     // Catch: java.lang.Throwable -> L96
            java.util.List r9 = r13.a()     // Catch: java.lang.Throwable -> L96
            r10 = r14
            r1.registerEvent(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L96
            int r1 = r13.l     // Catch: java.lang.Throwable -> L96
            int r1 = r1 + r12
            r13.l = r1     // Catch: java.lang.Throwable -> L96
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            android.os.PowerManager$WakeLock r0 = r13.b
            r0.acquire()
            r0 = 0
            int r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1))
            if (r2 <= 0) goto L95
            java.util.concurrent.ScheduledExecutorService r0 = com.google.android.gms.stats.WakeLock.n
            com.google.android.gms.stats.b r1 = new com.google.android.gms.stats.b
            r1.<init>(r13)
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS
            r0.schedule(r1, r14, r2)
        L95:
            return
        L96:
            r14 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L96
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.acquire(long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0050, code lost:
    
        if (r1 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x005a, code lost:
    
        com.google.android.gms.common.stats.WakeLockTracker.getInstance().registerEvent(r12.h, com.google.android.gms.common.stats.StatsUtils.getEventKey(r12.b, r6), 8, r12.e, r6, null, r12.d, a());
        r12.l--;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        if (r12.l == 1) goto L21;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void release() {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicInteger r0 = r12.m
            int r0 = r0.decrementAndGet()
            if (r0 >= 0) goto L19
            java.lang.String r0 = "WakeLock"
            java.lang.String r1 = r12.e
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = " release without a matched acquire!"
            java.lang.String r1 = r1.concat(r2)
            android.util.Log.e(r0, r1)
        L19:
            r0 = 0
            java.lang.String r6 = r12.a(r0)
            java.lang.Object r0 = r12.f5059a
            monitor-enter(r0)
            boolean r1 = r12.i     // Catch: java.lang.Throwable -> L7e
            r10 = 1
            r11 = 0
            if (r1 == 0) goto L52
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.j     // Catch: java.lang.Throwable -> L7e
            java.lang.Object r1 = r1.get(r6)     // Catch: java.lang.Throwable -> L7e
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L33
            r1 = 0
            goto L50
        L33:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            if (r2 != r10) goto L42
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.j     // Catch: java.lang.Throwable -> L7e
            r1.remove(r6)     // Catch: java.lang.Throwable -> L7e
            r1 = 1
            goto L50
        L42:
            r2 = r1[r11]     // Catch: java.lang.Throwable -> L7e
            int r2 = r2.intValue()     // Catch: java.lang.Throwable -> L7e
            int r2 = r2 - r10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L7e
            r1[r11] = r2     // Catch: java.lang.Throwable -> L7e
            r1 = 0
        L50:
            if (r1 != 0) goto L5a
        L52:
            boolean r1 = r12.i     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L79
            int r1 = r12.l     // Catch: java.lang.Throwable -> L7e
            if (r1 != r10) goto L79
        L5a:
            com.google.android.gms.common.stats.WakeLockTracker r1 = com.google.android.gms.common.stats.WakeLockTracker.getInstance()     // Catch: java.lang.Throwable -> L7e
            android.content.Context r2 = r12.h     // Catch: java.lang.Throwable -> L7e
            android.os.PowerManager$WakeLock r3 = r12.b     // Catch: java.lang.Throwable -> L7e
            java.lang.String r3 = com.google.android.gms.common.stats.StatsUtils.getEventKey(r3, r6)     // Catch: java.lang.Throwable -> L7e
            r4 = 8
            java.lang.String r5 = r12.e     // Catch: java.lang.Throwable -> L7e
            r7 = 0
            int r8 = r12.d     // Catch: java.lang.Throwable -> L7e
            java.util.List r9 = r12.a()     // Catch: java.lang.Throwable -> L7e
            r1.registerEvent(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L7e
            int r1 = r12.l     // Catch: java.lang.Throwable -> L7e
            int r1 = r1 - r10
            r12.l = r1     // Catch: java.lang.Throwable -> L7e
        L79:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            r12.a(r11)
            return
        L7e:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7e
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.stats.WakeLock.release():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i) {
        if (this.b.isHeld()) {
            try {
                this.b.release();
            } catch (RuntimeException e) {
                if (e.getClass().equals(RuntimeException.class)) {
                    Log.e("WakeLock", String.valueOf(this.e).concat(" was already released!"), e);
                } else {
                    throw e;
                }
            }
            this.b.isHeld();
        }
    }

    private final String a(String str) {
        return (!this.i || TextUtils.isEmpty(str)) ? this.f : str;
    }

    @KeepForSdk
    public void setReferenceCounted(boolean z) {
        this.b.setReferenceCounted(z);
        this.i = z;
    }

    @KeepForSdk
    public boolean isHeld() {
        return this.b.isHeld();
    }
}
