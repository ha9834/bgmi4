package com.uqm.crashsight.crashreport.crash.anr;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.crashreport.common.info.AppInfo;
import com.uqm.crashsight.crashreport.common.info.c;
import com.uqm.crashsight.crashreport.crash.CrashDetailBean;
import com.uqm.crashsight.crashreport.crash.anr.TraceFileHelper;
import com.uqm.crashsight.proguard.d;
import com.uqm.crashsight.proguard.k;
import com.uqm.crashsight.proguard.l;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.o;
import com.uqm.crashsight.proguard.q;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class b {
    private static b k;
    private final Context c;
    private final com.uqm.crashsight.crashreport.common.info.a d;
    private final k e;
    private String f;
    private final com.uqm.crashsight.crashreport.crash.b g;
    private FileObserver h;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f6585a = new AtomicInteger(0);
    private long b = -1;
    private boolean i = true;
    private boolean l = true;
    private int m = 10;
    private ActivityManager.ProcessErrorStateInfo j = new ActivityManager.ProcessErrorStateInfo();

    public static b a(Context context, com.uqm.crashsight.crashreport.common.strategy.a aVar, com.uqm.crashsight.crashreport.common.info.a aVar2, k kVar, d dVar, com.uqm.crashsight.crashreport.crash.b bVar, CrashSightStrategy.a aVar3) {
        if (k == null) {
            k = new b(context, aVar, aVar2, kVar, bVar);
        }
        return k;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            bVar = k;
        }
        return bVar;
    }

    private b(Context context, com.uqm.crashsight.crashreport.common.strategy.a aVar, com.uqm.crashsight.crashreport.common.info.a aVar2, k kVar, com.uqm.crashsight.crashreport.crash.b bVar) {
        this.c = q.a(context);
        this.f = context.getDir("crashSight", 0).getAbsolutePath();
        this.d = aVar2;
        this.e = kVar;
        this.g = bVar;
    }

    private ActivityManager.ProcessErrorStateInfo a(Context context, long j) {
        try {
            m.c("[AnrHandler] waiting for process state!", new Object[0]);
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            int i = 0;
            while (true) {
                m.c("[AnrHandler] waiting!", new Object[0]);
                List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                if (processesInErrorState != null) {
                    for (ActivityManager.ProcessErrorStateInfo processErrorStateInfo : processesInErrorState) {
                        m.c("[AnrHandler] state info is %s %d", processErrorStateInfo.processName, Integer.valueOf(processErrorStateInfo.condition));
                        if (processErrorStateInfo.condition == 2) {
                            m.c("[AnrHandler] find not responding state!", new Object[0]);
                            return processErrorStateInfo;
                        }
                    }
                }
                q.b(500L);
                int i2 = i + 1;
                if (i >= 20) {
                    m.c("end!", new Object[0]);
                    break;
                }
                i = i2;
            }
        } catch (Exception e) {
            m.b(e);
        } catch (OutOfMemoryError e2) {
            this.j.pid = Process.myPid();
            this.j.shortMsg = "crashSight sdk waitForAnrProcessStateChanged encount error:" + e2.getMessage();
            return this.j;
        }
        return this.j;
    }

    private CrashDetailBean a(a aVar) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.D = c.k();
            crashDetailBean.E = c.h();
            crashDetailBean.F = c.m();
            crashDetailBean.G = this.d.o();
            crashDetailBean.H = this.d.n();
            crashDetailBean.I = this.d.p();
            Context context = this.c;
            if (!c.q()) {
                crashDetailBean.x = q.a(this.c, com.uqm.crashsight.crashreport.crash.c.e, (String) null);
            }
            crashDetailBean.b = 3;
            crashDetailBean.e = this.d.h();
            crashDetailBean.f = this.d.k;
            crashDetailBean.g = this.d.u();
            com.uqm.crashsight.crashreport.common.info.a aVar2 = this.d;
            crashDetailBean.m = com.uqm.crashsight.crashreport.common.info.a.g();
            crashDetailBean.n = "ANR_EXCEPTION";
            crashDetailBean.o = aVar.f;
            crashDetailBean.q = aVar.g;
            crashDetailBean.Q = new HashMap();
            crashDetailBean.Q.put("CS_CR_01", aVar.e);
            int indexOf = crashDetailBean.q != null ? crashDetailBean.q.indexOf("\n") : -1;
            crashDetailBean.p = indexOf > 0 ? crashDetailBean.q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.s = aVar.c;
            if (crashDetailBean.q != null) {
                crashDetailBean.v = q.a(crashDetailBean.q.getBytes());
            }
            crashDetailBean.A = aVar.b;
            crashDetailBean.B = aVar.f6584a;
            crashDetailBean.C = "main(1)";
            crashDetailBean.J = this.d.w();
            crashDetailBean.h = this.d.t();
            crashDetailBean.i = this.d.G();
            crashDetailBean.w = aVar.d;
            crashDetailBean.M = this.d.o;
            crashDetailBean.N = this.d.f6569a;
            crashDetailBean.O = this.d.a();
            Context context2 = this.c;
            if (!c.q()) {
                this.g.d(crashDetailBean);
            }
            crashDetailBean.R = this.d.E();
            crashDetailBean.S = this.d.F();
            crashDetailBean.T = this.d.x();
            crashDetailBean.U = this.d.C();
            crashDetailBean.z = o.a();
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    private static boolean a(String str, String str2, String str3) {
        BufferedWriter bufferedWriter;
        TraceFileHelper.a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.d == null || readTargetDumpInfo.d.size() <= 0) {
            m.e("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                m.e("backup file create fail %s", str2);
                return false;
            }
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                bufferedWriter = bufferedWriter2;
            }
            try {
                String[] strArr = readTargetDumpInfo.d.get("main");
                if (strArr != null && strArr.length >= 3) {
                    String str4 = strArr[0];
                    String str5 = strArr[1];
                    bufferedWriter.write("\"main\" tid=" + strArr[2] + " :\n" + str4 + "\n" + str5 + "\n\n");
                    bufferedWriter.flush();
                }
                for (Map.Entry<String, String[]> entry : readTargetDumpInfo.d.entrySet()) {
                    if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                        String str6 = entry.getValue()[0];
                        String str7 = entry.getValue()[1];
                        bufferedWriter.write("\"" + entry.getKey() + "\" tid=" + entry.getValue()[2] + " :\n" + str6 + "\n" + str7 + "\n\n");
                        bufferedWriter.flush();
                    }
                }
                try {
                    bufferedWriter.close();
                } catch (IOException e2) {
                    if (!m.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                return true;
            } catch (IOException e3) {
                e = e3;
                bufferedWriter2 = bufferedWriter;
                if (!m.a(e)) {
                    e.printStackTrace();
                }
                m.e("dump trace fail %s", e.getClass().getName() + CertificateUtil.DELIMITER + e.getMessage());
                if (bufferedWriter2 != null) {
                    try {
                        bufferedWriter2.close();
                    } catch (IOException e4) {
                        if (!m.a(e4)) {
                            e4.printStackTrace();
                        }
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedWriter != null) {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e5) {
                        if (!m.a(e5)) {
                            e5.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        } catch (Exception e6) {
            if (!m.a(e6)) {
                e6.printStackTrace();
            }
            m.e("backup file create error! %s  %s", e6.getClass().getName() + CertificateUtil.DELIMITER + e6.getMessage(), str2);
            return false;
        }
    }

    public final boolean b() {
        return this.f6585a.get() != 0;
    }

    public final boolean a(Context context) {
        boolean z;
        boolean z2;
        Map<String, String> map;
        if (this.m > 0) {
            com.uqm.crashsight.crashreport.common.info.a aVar = this.d;
            if (com.uqm.crashsight.crashreport.common.info.a.H() >= 23) {
                z = b(this.m);
            } else {
                com.uqm.crashsight.crashreport.common.info.a aVar2 = this.d;
                m.c("[AnrHandler] Current api level is %d, which is not support isMainThreadStuck check.", Integer.valueOf(com.uqm.crashsight.crashreport.common.info.a.H()));
                z = false;
            }
        } else {
            z = false;
        }
        if (this.l) {
            this.j = a(context, LogUtils.LOG_FUSE_TIME);
            if (this.j.condition == 2) {
                z2 = true;
            } else {
                m.c("proc state is unvisiable!", new Object[0]);
                z2 = false;
            }
        } else {
            z2 = false;
        }
        if (this.m == 0 && !this.l) {
            m.c("[AnrHandler] Both controllers are close which lead to upload anr.", new Object[0]);
            z = true;
            z2 = true;
        }
        if (!z && !z2) {
            m.c("[AnrHandler] This is not a anr.", new Object[0]);
            return false;
        }
        HashMap hashMap = new HashMap();
        try {
            map = q.a(200000, false);
        } catch (Throwable th) {
            m.b(th);
            hashMap.put("main", th.getMessage());
            map = hashMap;
        }
        a(context, "", this.j, System.currentTimeMillis(), map);
        return true;
    }

    private boolean a(Context context, String str, ActivityManager.ProcessErrorStateInfo processErrorStateInfo, long j, Map<String, String> map) {
        a aVar = new a();
        aVar.c = j;
        aVar.f6584a = processErrorStateInfo != null ? processErrorStateInfo.processName : AppInfo.a(Process.myPid());
        aVar.f = processErrorStateInfo != null ? processErrorStateInfo.shortMsg : "";
        aVar.e = processErrorStateInfo != null ? processErrorStateInfo.longMsg : "";
        aVar.b = map;
        Thread thread = Looper.getMainLooper().getThread();
        if (map != null) {
            Iterator<String> it = map.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String next = it.next();
                if (next.startsWith(thread.getName())) {
                    aVar.g = map.get(next);
                    break;
                }
            }
        }
        if (TextUtils.isEmpty(aVar.g)) {
            aVar.g = "main stack is null , some error may be encountered.";
        }
        Object[] objArr = new Object[7];
        objArr[0] = Long.valueOf(aVar.c);
        objArr[1] = aVar.d;
        objArr[2] = aVar.f6584a;
        objArr[3] = aVar.g;
        objArr[4] = aVar.f;
        objArr[5] = aVar.e;
        objArr[6] = Integer.valueOf(aVar.b == null ? 0 : aVar.b.size());
        m.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
        m.a("found visiable anr , start to upload!", new Object[0]);
        CrashDetailBean a2 = a(aVar);
        if (a2 == null) {
            m.e("pack anr fail!", new Object[0]);
            return false;
        }
        com.uqm.crashsight.crashreport.crash.c.a().a(a2);
        if (a2.f6577a >= 0) {
            m.a("backup anr record success!", new Object[0]);
        } else {
            m.d("backup anr record fail!", new Object[0]);
        }
        if (str != null && new File(str).exists()) {
            aVar.d = new File(this.f, "crashSight_trace_" + j + ".txt").getAbsolutePath();
            this.f6585a.set(3);
            if (a(str, aVar.d, aVar.f6584a)) {
                m.a("backup trace success", new Object[0]);
            }
        } else {
            File i = i();
            m.a("traceFile is %s", i);
            if (i != null) {
                a2.w = i.getAbsolutePath();
            }
        }
        com.uqm.crashsight.crashreport.crash.b.a("ANR", q.a(), aVar.f6584a, "main", aVar.g, a2);
        if (!this.g.a(a2)) {
            this.g.a(a2, 3000L, true);
        }
        this.g.c(a2);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(String str) {
        long j;
        synchronized (this) {
            if (this.f6585a.get() != 0) {
                m.c("trace started return ", new Object[0]);
                return;
            }
            this.f6585a.set(1);
            try {
                try {
                    m.c("read trace first dump for create time!", new Object[0]);
                    TraceFileHelper.a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                    long j2 = readFirstDumpInfo != null ? readFirstDumpInfo.c : -1L;
                    if (j2 == -1) {
                        m.d("trace dump fail could not get time!", new Object[0]);
                        j = System.currentTimeMillis();
                    } else {
                        j = j2;
                    }
                } catch (Throwable th) {
                    if (!m.a(th)) {
                        th.printStackTrace();
                    }
                    m.e("handle anr error %s", th.getClass().toString());
                }
                if (Math.abs(j - this.b) < LogUtils.LOG_FUSE_TIME) {
                    m.d("should not process ANR too Fre in %d", 10000);
                } else {
                    this.b = j;
                    this.f6585a.set(1);
                    try {
                        Map<String, String> a2 = q.a(com.uqm.crashsight.crashreport.crash.c.f, false);
                        if (a2 != null && a2.size() > 0) {
                            this.j = a(this.c, LogUtils.LOG_FUSE_TIME);
                            if (this.j == null) {
                                m.c("proc state is unvisiable!", new Object[0]);
                            } else if (this.j.pid != Process.myPid()) {
                                m.c("not mind proc!", this.j.processName);
                            } else {
                                m.a("found visiable anr , start to process!", new Object[0]);
                                a(this.c, str, this.j, j, a2);
                                return;
                            }
                        }
                        m.d("can't get all thread skip this anr", new Object[0]);
                    } catch (Throwable th2) {
                        m.a(th2);
                        m.e("get all thread stack fail!", new Object[0]);
                    }
                }
            } finally {
                this.f6585a.set(0);
            }
        }
    }

    private synchronized void e() {
        if (g()) {
            m.d("start when started!", new Object[0]);
            return;
        }
        this.h = new FileObserver("/data/anr/", 8) { // from class: com.uqm.crashsight.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str == null) {
                    return;
                }
                final String str2 = "/data/anr/" + str;
                m.d("watching file %s", str2);
                if (str2.contains("trace")) {
                    b.this.e.a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.anr.b.1.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            b.this.a(str2);
                        }
                    });
                } else {
                    m.d("not anr file %s", str2);
                }
            }
        };
        try {
            this.h.startWatching();
            l.a("start anr monitor!", new Object[0]);
            this.e.a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.anr.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c();
                }
            });
        } catch (Throwable th) {
            this.h = null;
            m.d("start anr monitor failed!", new Object[0]);
            if (m.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized void f() {
        if (!g()) {
            m.d("close when closed!", new Object[0]);
            return;
        }
        try {
            l.a("stop anr monitor!", new Object[0]);
            this.h.stopWatching();
            this.h = null;
            m.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            m.d("stop anr monitor failed!", new Object[0]);
            if (m.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized boolean g() {
        return this.h != null;
    }

    private synchronized void c(boolean z) {
        if (Build.VERSION.SDK_INT > 19) {
            if (!z) {
                j();
            }
        } else if (z) {
            e();
        } else {
            f();
        }
    }

    private synchronized boolean h() {
        return this.i;
    }

    private synchronized void d(boolean z) {
        if (this.i != z) {
            m.a("user change anr %b", Boolean.valueOf(z));
            this.i = z;
        }
    }

    public final void a(boolean z) {
        d(z);
        boolean h = h();
        com.uqm.crashsight.crashreport.common.strategy.a a2 = com.uqm.crashsight.crashreport.common.strategy.a.a();
        if (a2 != null) {
            h = h && a2.c().e;
        }
        if (h != g()) {
            m.a("anr changed to %b", Boolean.valueOf(h));
            c(h);
        }
    }

    protected final void c() {
        long b = q.b() - com.uqm.crashsight.crashreport.crash.c.g;
        File file = new File(this.f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int length = listFiles.length;
                    int i = 0;
                    int i2 = 0;
                    int i3 = 0;
                    while (i < length) {
                        File file2 = listFiles[i];
                        String name = file2.getName();
                        boolean z = true;
                        if (name.startsWith("crashSight_trace_")) {
                            i3 = 17;
                        } else if (name.startsWith("crashSight")) {
                            i3 = 10;
                        } else {
                            z = false;
                        }
                        File[] fileArr = listFiles;
                        m.c("Number Trace file : " + name, new Object[0]);
                        if (z) {
                            try {
                                int indexOf = name.indexOf(".txt");
                                if (indexOf > 0 && Long.parseLong(name.substring(i3, indexOf)) >= b) {
                                }
                            } catch (Throwable unused) {
                                m.c("Trace file that has invalid format: " + name, new Object[0]);
                            }
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                        i++;
                        listFiles = fileArr;
                    }
                    m.c("Number of overdue trace files that has deleted: " + i2, new Object[0]);
                }
            } catch (Throwable th) {
                m.a(th);
            }
        }
    }

    public final synchronized void d() {
        m.d("customer decides whether to open or close.", new Object[0]);
    }

    @TargetApi(23)
    private static boolean b(int i) {
        try {
            MessageQueue queue = Looper.getMainLooper().getQueue();
            Field declaredField = queue.getClass().getDeclaredField("mMessages");
            declaredField.setAccessible(true);
            Message message = (Message) declaredField.get(queue);
            if (message == null) {
                return false;
            }
            long when = message.getWhen();
            m.c("waiting time when is %d", Long.valueOf(when));
            m.c("current time when is %d", Long.valueOf(SystemClock.uptimeMillis()));
            if (when == 0) {
                return false;
            }
            return when - SystemClock.uptimeMillis() < ((long) (i * 1000));
        } catch (Exception unused) {
            return false;
        }
    }

    private File i() {
        long currentTimeMillis = System.currentTimeMillis();
        File file = new File(this.f);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        try {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                int i = 17;
                int length = listFiles.length;
                int i2 = 0;
                while (i2 < length) {
                    File file2 = listFiles[i2];
                    String name = file2.getName();
                    if (name.startsWith("crashSight_trace_")) {
                        try {
                            int indexOf = name.indexOf(".txt");
                            if (indexOf > 0) {
                                long parseLong = Long.parseLong(name.substring(i, indexOf));
                                long j = (currentTimeMillis - parseLong) / 1000;
                                m.c("current time %d trace time is %d s", Long.valueOf(currentTimeMillis), Long.valueOf(parseLong));
                                m.c("current time minus trace time is %d s", Long.valueOf(j));
                                if (j < 30) {
                                    return file2;
                                }
                            } else {
                                continue;
                            }
                        } catch (Throwable unused) {
                            m.c("Trace file that has invalid format: " + name, new Object[0]);
                        }
                    }
                    i2++;
                    i = 17;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            m.a(th);
            return null;
        }
    }

    private synchronized void j() {
        if (!g()) {
            m.d("close when closed!", new Object[0]);
            return;
        }
        l.a("stop anr monitor!", new Object[0]);
        l.a("WatchDog stopping...", new Object[0]);
        try {
            this.h.stopWatching();
            this.h = null;
            m.d("close anr monitor!", new Object[0]);
        } catch (Throwable th) {
            m.d("stop anr monitor failed!", new Object[0]);
            if (m.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void b(boolean z) {
        this.l = z;
    }

    public final void a(int i) {
        this.m = i;
    }
}
