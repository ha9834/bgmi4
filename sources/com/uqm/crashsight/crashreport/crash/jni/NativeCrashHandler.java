package com.uqm.crashsight.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.facebook.internal.ServerProtocol;
import com.helpshift.util.ErrorReportProvider;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.uqm.crashsight.CrashSight;
import com.uqm.crashsight.crashreport.CrashReport;
import com.uqm.crashsight.crashreport.common.info.c;
import com.uqm.crashsight.crashreport.common.info.d;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.crashreport.crash.CrashDetailBean;
import com.uqm.crashsight.proguard.k;
import com.uqm.crashsight.proguard.l;
import com.uqm.crashsight.proguard.m;
import com.uqm.crashsight.proguard.q;
import com.uqm.crashsight.proguard.v;
import com.uqm.crashsight.proguard.w;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class NativeCrashHandler implements com.uqm.crashsight.crashreport.a {

    /* renamed from: a, reason: collision with root package name */
    private static NativeCrashHandler f6600a = null;
    private static int b = 1;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean p = true;
    private final Context c;
    private final com.uqm.crashsight.crashreport.common.info.a d;
    private final k e;
    private NativeExceptionHandler f;
    private String g;
    private final boolean h;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private com.uqm.crashsight.crashreport.crash.b o;

    public static native void nativeDaemonInit(String str, String str2, String str3, String str4, String str5, long j);

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    public native void gpmProcessInfoGetPerfData();

    public native long gpmProcessInfoGetSmapsMem();

    public native void gpmProcessInfoInit(int i);

    protected native boolean putNativeKeyValue(String str, String str2);

    public native String readOomScore();

    public native String readStringFromMmap(String str);

    protected native String regist(String str, boolean z, int i, long j);

    protected native String removeNativeKeyValue(String str);

    public native void setAbortMsgOpen(boolean z);

    public native void setAnrDumpNativeEnable(boolean z);

    public native void setCatchMonoStackOpen(boolean z);

    public native void setIsModuleNameOmit(boolean z);

    public native void setLrTraceOpen(boolean z);

    public native void setMmkvliteOpen(boolean z);

    protected native void setNativeInfo(int i, String str);

    public native void setSmallestDumpOpen(boolean z);

    protected native void testCrash();

    protected native void testLogcat();

    protected native void testLogcatStat();

    protected native void testMalloc1GNative();

    protected native void testMmkvlite();

    protected native void testNativeOom();

    protected native void testRegistSignalHandler();

    protected native String unregist();

    public native String uploadNativeStack();

    public native void writeStringToMmap(String str, String str2);

    private static void a(String str) {
        m.c("[Native] Check extra jni for CrashSight NDK v%s", str);
        String replace = "2.1.1".replace(".", "");
        String replace2 = "2.3.0".replace(".", "");
        String replace3 = str.replace(".", "");
        if (replace3.length() == 2) {
            replace3 = replace3 + "0";
        } else if (replace3.length() == 1) {
            replace3 = replace3 + "00";
        }
        try {
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace)) {
                m = true;
            }
            if (Integer.parseInt(replace3) >= Integer.parseInt(replace2)) {
                n = true;
            }
        } catch (Throwable unused) {
        }
        if (n) {
            m.a("[Native] Info setting jni can be accessed.", new Object[0]);
        } else {
            m.d("[Native] Info setting jni can not be accessed.", new Object[0]);
        }
        if (m) {
            m.a("[Native] Extra jni can be accessed.", new Object[0]);
        } else {
            m.d("[Native] Extra jni can not be accessed.", new Object[0]);
        }
    }

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, com.uqm.crashsight.crashreport.common.info.a aVar, com.uqm.crashsight.crashreport.crash.b bVar, k kVar, boolean z, String str) {
        this.c = q.a(context);
        try {
            if (q.a(str)) {
                str = context.getDir("crashSight", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + com.uqm.crashsight.crashreport.common.info.a.a(context).c + "/app_crashSight";
        }
        this.o = bVar;
        this.g = str;
        this.d = aVar;
        this.e = kVar;
        this.h = z;
        this.f = new a(context, aVar, bVar, com.uqm.crashsight.crashreport.common.strategy.a.a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, com.uqm.crashsight.crashreport.common.info.a aVar, com.uqm.crashsight.crashreport.crash.b bVar, com.uqm.crashsight.crashreport.common.strategy.a aVar2, k kVar, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f6600a == null) {
                f6600a = new NativeCrashHandler(context, aVar, bVar, kVar, z, str);
            }
            nativeCrashHandler = f6600a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f6600a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.g;
    }

    public synchronized void setDumpFilePath(String str) {
        this.g = str;
    }

    public synchronized String getMemInfoMmapPath() {
        return this.g + "/mmkvlite_log_uncatched_mem_info.mmkv";
    }

    public synchronized String getAppStateMmapPath() {
        return this.g + "/mmkvlite_log_app_state.mmkv";
    }

    public static void setShouldHandleInJava(boolean z) {
        p = z;
        NativeCrashHandler nativeCrashHandler = f6600a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            nativeCrashHandler.a(999, sb.toString());
        }
    }

    public static boolean isShouldHandleInJava() {
        return p;
    }

    public void setHandleAnrSigQuit(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(20, sb.toString());
    }

    public void setSigkillEnable(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(21, sb.toString());
    }

    private synchronized void a(boolean z) {
        if (this.k) {
            m.d("[Native] Native crash report has already registered.", new Object[0]);
            return;
        }
        if (this.j) {
            try {
                m.c("SDK INT IS %d", Integer.valueOf(Build.VERSION.SDK_INT));
                if (Build.VERSION.SDK_INT <= 29 && Build.VERSION.SDK_INT >= 26 && c.c(this.c).contains("Oppo")) {
                    b = 3;
                }
                String regist = regist(this.g, z, b, com.uqm.crashsight.crashreport.common.info.a.a(this.c).M());
                if (regist != null) {
                    m.a("[Native] Native Crash Report enable.", new Object[0]);
                    a(regist);
                    this.d.o = regist;
                    if (!this.d.f.contains("-".concat(this.d.o))) {
                        this.d.f = this.d.f.concat("-").concat(this.d.o);
                    }
                    m.a("comInfo.sdkVersion %s", this.d.f);
                    this.k = true;
                    return;
                }
            } catch (Throwable unused) {
                m.c("[Native] Failed to load CrashSight SO file.", new Object[0]);
            }
        } else if (this.i) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = this.g;
                objArr[1] = c.a(this.c, false);
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str = (String) q.a("", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str == null) {
                    Class[] clsArr2 = {String.class, String.class, Integer.TYPE};
                    com.uqm.crashsight.crashreport.common.info.a.b();
                    str = (String) q.a("", "registNativeExceptionHandler", null, clsArr2, new Object[]{this.g, c.a(this.c, false), Integer.valueOf(com.uqm.crashsight.crashreport.common.info.a.H())});
                }
                if (str != null) {
                    this.k = true;
                    this.d.o = str;
                    Boolean bool = (Boolean) q.a("", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str});
                    if (bool != null) {
                        m = bool.booleanValue();
                    }
                    q.a("", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{true});
                    q.a("", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.j = false;
        this.i = false;
    }

    public synchronized void startNativeMonitor() {
        if (!this.j && !this.i) {
            String str = "CrashSight";
            boolean z = !q.a(this.d.n);
            String str2 = this.d.n;
            if (z) {
                str = str2;
            } else {
                this.d.getClass();
            }
            this.j = tryLoadSo(str, z);
            if (this.j || this.i) {
                a(this.h);
                if (m) {
                    setNativeAppVersion(this.d.k);
                    setNativeAppChannel(this.d.m);
                    setNativeAppPackage(this.d.c);
                    com.uqm.crashsight.crashreport.common.info.a aVar = this.d;
                    setNativeUserId(com.uqm.crashsight.crashreport.common.info.a.g());
                    setNativeIsAppForeground(this.d.a());
                    setNativeLaunchTime(this.d.f6569a);
                }
                return;
            }
            return;
        }
        a(this.h);
    }

    private synchronized void b(boolean z) {
        if (this.j) {
            try {
                m.c("SDK INT IS %d", Integer.valueOf(Build.VERSION.SDK_INT));
                if (Build.VERSION.SDK_INT <= 29 && Build.VERSION.SDK_INT >= 26 && c.c(this.c).contains("Oppo")) {
                    b = 3;
                }
                String regist = regist(this.g, z, b, com.uqm.crashsight.crashreport.common.info.a.a(this.c).M());
                if (regist != null) {
                    m.a("[Native] Native Crash Report enable.", new Object[0]);
                    a(regist);
                    this.d.o = regist;
                    if (!this.d.f.contains("-".concat(this.d.o))) {
                        this.d.f = this.d.f.concat("-").concat(this.d.o);
                    }
                    m.a("comInfo.sdkVersion %s", this.d.f);
                    this.k = true;
                    return;
                }
            } catch (Throwable unused) {
                m.c("[Native] Failed to load CrashSight SO file.", new Object[0]);
            }
        } else if (this.i) {
            try {
                Class[] clsArr = {String.class, String.class, Integer.TYPE, Integer.TYPE};
                Object[] objArr = new Object[4];
                objArr[0] = this.g;
                objArr[1] = c.a(this.c, false);
                objArr[2] = Integer.valueOf(z ? 1 : 5);
                objArr[3] = 1;
                String str = (String) q.a("", "registNativeExceptionHandler2", null, clsArr, objArr);
                if (str == null) {
                    Class[] clsArr2 = {String.class, String.class, Integer.TYPE};
                    com.uqm.crashsight.crashreport.common.info.a.b();
                    str = (String) q.a("", "registNativeExceptionHandler", null, clsArr2, new Object[]{this.g, c.a(this.c, false), Integer.valueOf(com.uqm.crashsight.crashreport.common.info.a.H())});
                }
                if (str != null) {
                    this.k = true;
                    this.d.o = str;
                    Boolean bool = (Boolean) q.a("", "checkExtraJni", null, new Class[]{String.class}, new Object[]{str});
                    if (bool != null) {
                        m = bool.booleanValue();
                    }
                    q.a("", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{true});
                    q.a("", "setLogMode", null, new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(z ? 1 : 5)});
                    return;
                }
            } catch (Throwable unused2) {
            }
        }
        this.j = false;
        this.i = false;
    }

    public synchronized void reStartNativeMonitor() {
        if (!this.j && !this.i) {
            String str = "CrashSight";
            boolean z = !q.a(this.d.n);
            String str2 = this.d.n;
            if (z) {
                str = str2;
            } else {
                this.d.getClass();
            }
            this.j = tryLoadSo(str, z);
            if (this.j || this.i) {
                b(this.h);
                if (m) {
                    setNativeAppVersion(this.d.k);
                    setNativeAppChannel(this.d.m);
                    setNativeAppPackage(this.d.c);
                    com.uqm.crashsight.crashreport.common.info.a aVar = this.d;
                    setNativeUserId(com.uqm.crashsight.crashreport.common.info.a.g());
                    setNativeIsAppForeground(this.d.a());
                    setNativeLaunchTime(this.d.f6569a);
                }
                return;
            }
            return;
        }
        b(this.h);
    }

    public void checkUploadRecordCrash() {
        this.e.a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (q.a(NativeCrashHandler.this.c, "native_record_lock", LogUtils.LOG_FUSE_TIME)) {
                    if (!NativeCrashHandler.p) {
                        NativeCrashHandler.this.a(999, CrashSight.SDK_IS_DEV);
                    }
                    CrashDetailBean a2 = b.a(NativeCrashHandler.this.c, NativeCrashHandler.this.g, NativeCrashHandler.this.f);
                    if (a2 != null) {
                        m.a("[Native] Get crash from native record.", new Object[0]);
                        l.d("[Native] Get crash from native record.", new Object[0]);
                        if (!NativeCrashHandler.this.o.a(a2)) {
                            NativeCrashHandler.this.o.a(a2, 3000L, false);
                        }
                        b.a(false, NativeCrashHandler.this.g);
                    }
                    NativeCrashHandler.this.a();
                    q.b(NativeCrashHandler.this.c, "native_record_lock");
                    return;
                }
                m.a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
                l.d("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            }
        });
    }

    public void checkUploadMmkvliteRecordCrash() {
        this.e.a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler.2
            @Override // java.lang.Runnable
            public final void run() {
                if (q.a(NativeCrashHandler.this.c, "native_mmkvlite_record_lock", LogUtils.LOG_FUSE_TIME)) {
                    byte[] b2 = v.a(NativeCrashHandler.this.c).b();
                    if (b2 != null && b2.length > 0) {
                        m.a("[Native] Get crash from native mmkvlite.", new Object[0]);
                        l.d("[Native] Get crash from native mmkvlite.", new Object[0]);
                        NativeCrashHandler.this.o.a(b2, 3000L, false, false, false);
                    }
                    q.b(NativeCrashHandler.this.c, "native_mmkvlite_record_lock");
                    return;
                }
                m.a("[Native] Failed to lock file for handling native mmkvlite record.", new Object[0]);
                l.d("[Native] Failed to lock file for handling native mmkvlite record.", new Object[0]);
            }
        });
    }

    public void checkUploadOomMmkvliteRecordCrash() {
        this.e.a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler.3
            @Override // java.lang.Runnable
            public final void run() {
                String readMemInfo;
                if (!q.a(NativeCrashHandler.this.c, "native_oom_mmkvlite_record_lock", LogUtils.LOG_FUSE_TIME)) {
                    m.a("[Native] Failed to lock file for handling oom mmkvlite record.", new Object[0]);
                    l.d("[Native] Failed to lock file for handling oom mmkvlite record.", new Object[0]);
                    return;
                }
                m.a("[Native] read uncaught oom mmkvlite file.", new Object[0]);
                d a2 = d.a();
                if (a2 != null) {
                    if (a2.c() && (readMemInfo = NativeCrashHandler.getInstance().readMemInfo()) != null && !readMemInfo.isEmpty()) {
                        HashMap hashMap = new HashMap(1);
                        hashMap.put("com.crashsight.crashSight.memoryinfo", readMemInfo);
                        CrashReport.postException(9, "last crash maybe caused by oom", null, null, hashMap);
                    }
                    a2.b();
                    com.uqm.crashsight.service.b.a().b();
                } else {
                    l.d("oomInfoManager is null", new Object[0]);
                }
                q.b(NativeCrashHandler.this.c, "native_oom_mmkvlite_record_lock");
            }
        });
    }

    public void checkUploadOomRecordCrash() {
        this.e.a(new Runnable() { // from class: com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler.4
            @Override // java.lang.Runnable
            public final void run() {
                if (!q.a(NativeCrashHandler.this.c, "native_oom_record_lock", LogUtils.LOG_FUSE_TIME)) {
                    l.d("[Native] Failed to lock file for handling native mmkvlite record.", new Object[0]);
                    return;
                }
                String c = w.a().c();
                if (c != null && !c.isEmpty()) {
                    l.d("[Native] Get crash from oom file.", new Object[0]);
                    CrashReport.postException(9, "last crash maybe caused by oom", c, "", null);
                    w.a().b();
                }
                q.b(NativeCrashHandler.this.c, "native_oom_record_lock");
            }
        });
    }

    public boolean tryLoadSo(String str, boolean z) {
        boolean z2;
        try {
            m.a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
            try {
                m.a("[Native] Successfully loaded SO: %s", str);
                return true;
            } catch (Throwable th) {
                th = th;
                z2 = true;
                m.d(th.getMessage(), new Object[0]);
                m.d("[Native] Failed to load so: %s", str);
                return z2;
            }
        } catch (Throwable th2) {
            th = th2;
            z2 = false;
        }
    }

    private synchronized void c() {
        if (!this.k) {
            m.d("[Native] Native crash report has already unregistered.", new Object[0]);
            return;
        }
        try {
            if (unregist() != null) {
                m.a("[Native] Successfully closed native crash report.", new Object[0]);
                this.k = false;
                return;
            }
        } catch (Throwable unused) {
            m.c("[Native] Failed to close native crash report.", new Object[0]);
        }
        try {
            q.a("", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.k = false;
            m.a("[Native] Successfully closed native crash report.", new Object[0]);
        } catch (Throwable unused2) {
            m.c("[Native] Failed to close native crash report.", new Object[0]);
            this.j = false;
            this.i = false;
        }
    }

    public void testNativeCrash() {
        if (!this.j) {
            m.d("[Native] CrashSight SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2);
        a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z3);
        a(18, sb3.toString());
        testNativeCrash();
    }

    public void testNativeOomCrash() {
        if (!this.j) {
            m.d("[Native] CrashSight SO file has not been load.", new Object[0]);
        } else {
            testNativeOom();
        }
    }

    public void testMalloc1GNativeCrash() {
        if (!this.j) {
            m.d("[Native] CrashSight SO file has not been load.", new Object[0]);
        } else {
            testMalloc1GNative();
        }
    }

    public void testLogcatCrash() {
        if (!this.j) {
            m.d("[Native] CrashSight SO file has not been load.", new Object[0]);
        } else {
            testLogcat();
        }
    }

    public void testLogcatStatCrash() {
        if (!this.j) {
            m.d("[Native] CrashSight SO file has not been load.", new Object[0]);
        } else {
            testLogcatStat();
        }
    }

    public void testRegistSignalHandlerCrash() {
        testRegistSignalHandler();
    }

    public void testMmkvliteCrash() {
        testMmkvlite();
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f;
    }

    public void dumpAnrNativeStack() {
        a(19, "1");
    }

    protected final void a() {
        long b2 = q.b() - com.uqm.crashsight.crashreport.crash.c.g;
        long b3 = q.b() + ErrorReportProvider.BATCH_TIME;
        File file = new File(this.g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    int i2 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < b2 || lastModified >= b3) {
                            m.a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i++;
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                    m.c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i), Integer.valueOf(i2));
                }
            } catch (Throwable th) {
                m.a(th);
            }
        }
    }

    public void removeEmptyNativeRecordFiles() {
        b.c(this.g);
    }

    private synchronized void c(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            c();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.l;
    }

    private synchronized void d(boolean z) {
        if (this.l != z) {
            m.a("user change native %b", Boolean.valueOf(z));
            this.l = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        d(z);
        boolean isUserOpened = isUserOpened();
        com.uqm.crashsight.crashreport.common.strategy.a a2 = com.uqm.crashsight.crashreport.common.strategy.a.a();
        if (a2 != null) {
            isUserOpened = isUserOpened && a2.c().e;
        }
        if (isUserOpened != this.k) {
            m.a("native changed to %b", Boolean.valueOf(isUserOpened));
            c(isUserOpened);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.e != this.k) {
                m.d("server native changed to %b", Boolean.valueOf(strategyBean.e));
            }
        }
        boolean z = com.uqm.crashsight.crashreport.common.strategy.a.a().c().e && this.l;
        if (z != this.k) {
            m.a("native changed to %b", Boolean.valueOf(z));
            c(z);
        }
    }

    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((!this.i && !this.j) || !m || str == null || str2 == null || str3 == null) {
            return false;
        }
        try {
            if (this.j) {
                return appendNativeLog(str, str2, str3);
            }
            Boolean bool = (Boolean) q.a("", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (UnsatisfiedLinkError unused) {
            m = false;
            return false;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public String getLogFromNative() {
        if ((!this.i && !this.j) || !m) {
            return null;
        }
        try {
            if (this.j) {
                return getNativeLog();
            }
            return (String) q.a("", "getNativeLog", null, null, null);
        } catch (UnsatisfiedLinkError unused) {
            m = false;
            return null;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((!this.i && !this.j) || !m || str == null || str2 == null) {
            return false;
        }
        try {
            if (this.j) {
                return putNativeKeyValue(str, str2);
            }
            Boolean bool = (Boolean) q.a("", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (UnsatisfiedLinkError unused) {
            m = false;
            return false;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(int i, String str) {
        if (!this.j || !n) {
            m.c("Failed to put key value to native.", new Object[0]);
            return false;
        }
        try {
            setNativeInfo(i, str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            m.c("Failed to put key value to native because of UnsatisfiedLinkError.", new Object[0]);
            n = false;
            return false;
        } catch (Throwable th) {
            if (!m.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    public boolean filterSigabrtSysLog() {
        return a(998, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
    }

    public boolean setNativeAppVersion(String str) {
        return a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return a(11, str);
    }

    @Override // com.uqm.crashsight.crashreport.a
    public boolean setNativeIsAppForeground(boolean z) {
        return a(14, z ? ServerProtocol.DIALOG_RETURN_SCOPES_TRUE : CrashSight.SDK_IS_DEV);
    }

    public synchronized void updateMemInfo(String str) {
        writeStringToMmap(getMemInfoMmapPath(), str);
    }

    public synchronized String readMemInfo() {
        return readStringFromMmap(getMemInfoMmapPath());
    }

    @Override // com.uqm.crashsight.crashreport.a
    public synchronized void updateAppState(String str) {
        writeStringToMmap(getAppStateMmapPath(), str);
    }

    @Override // com.uqm.crashsight.crashreport.a
    public synchronized String readAppState() {
        return readStringFromMmap(getAppStateMmapPath());
    }

    @Override // com.uqm.crashsight.crashreport.a
    public void gpmProcessInfoInitFromNative(int i) {
        gpmProcessInfoInit(i);
    }

    @Override // com.uqm.crashsight.crashreport.a
    public void gpmProcessInfoGetPerfDataFromNative() {
        gpmProcessInfoGetPerfData();
    }

    @Override // com.uqm.crashsight.crashreport.a
    public long gpmProcessInfoGetSmapsMemFromNative() {
        return gpmProcessInfoGetSmapsMem();
    }

    @Override // com.uqm.crashsight.crashreport.a
    public int readOomScoreFromNative() {
        String readOomScore = readOomScore();
        if (readOomScore != null) {
            try {
                return Integer.parseInt(readOomScore.trim());
            } catch (Exception e) {
                m.e(e.toString(), new Object[0]);
            }
        }
        return 0;
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (m.a(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }

    public void enableCatchAnrTrace() {
        if (Build.VERSION.SDK_INT > 30 || Build.VERSION.SDK_INT < 23) {
            return;
        }
        b |= 2;
    }

    public boolean isEnableCatchAnrTrace() {
        return (b & 2) == 2;
    }

    public void setCrashHandleTimeout(int i) {
        try {
            a(22, String.valueOf(i));
        } catch (NumberFormatException e) {
            if (m.a(e)) {
                return;
            }
            e.printStackTrace();
        }
    }
}
