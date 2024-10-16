package com.uqm.crashsight;

import android.content.Context;
import android.text.TextUtils;
import com.uqm.crashsight.CrashSightStrategy;
import com.uqm.crashsight.crashreport.common.info.SightPkg;
import com.uqm.crashsight.crashreport.common.strategy.StrategyBean;
import com.uqm.crashsight.crashreport.crash.c;
import com.uqm.crashsight.crashreport.crash.jni.NativeCrashHandler;
import com.uqm.crashsight.proguard.l;
import com.uqm.crashsight.proguard.m;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CrashModule extends a {
    public static int ANR_MSG_TIME_THRESHOLD = 10;
    public static int DUMP_MEMORY_INFO_MAX_COUNT = 30;
    public static boolean IS_ANR_CHECK_PROCESS_STATE = true;
    public static boolean IS_ANR_DUMP_NATIVE_STACK = true;
    public static boolean IS_OPEN_ABORT_MSG = false;
    public static boolean IS_OPEN_ANR = false;
    public static boolean IS_OPEN_CATCH_MONO_STACK = false;
    public static boolean IS_OPEN_HANDLE_ANR_SIG_QUIT = false;
    public static boolean IS_OPEN_LR_TRACE = false;
    public static boolean IS_OPEN_MODULE_NAME_OMIT = false;
    public static boolean IS_OPEN_READ_OOM_SCORE = false;
    public static boolean IS_OPEN_SIGKILL_MONITORING = false;
    public static boolean IS_OPEN_SMALLEST_DUMP = false;
    public static boolean IS_OPEN_UNITY_UP_CLOSE_JAVA = false;
    public static boolean IS_OPEN_UNITY_UP_JAVA_USE_FILTER = false;
    public static boolean IS_OPEN_UPLOAD_MMAP = false;
    public static final String KEY_ABORTMSG = "AOS_KEY_ABORT_MSG_ENABLE";
    public static final String KEY_ANR_CHECK_MSG_TIME = "AOS_KEY_ANR_CHECK_MSG_TIME";
    public static final String KEY_ANR_CHECK_PROCESS_STATE = "AOS_KEY_ANR_CHECK_STATE";
    public static final String KEY_ANR_DUMP_NATIVE = "AOS_KEY_ANR_DUMP_NATIVE";
    public static final String KEY_CATCH_MONO_STACK = "B32";
    public static final String KEY_DUMP_MEMORY_INFO_MAX_COUNT = "AOS_KEY_DUMP_MEMORY_INFO_MAX_COUNT";
    public static final String KEY_HANDLE_ANR_SIG_QUIT_ENABLE = "AOS_KEY_HANDLE_ANR_SIG_QUIT_ENABLE";
    public static final String KEY_LRTRACE = "AOS_KEY_LRTRACE_ENABLE";
    public static final String KEY_MODULE_NAME_OMIT = "AOS_KEY_MODULE_NAME_OMIT";
    public static final String KEY_OOM = "B33";
    public static final String KEY_READ_OOM_SCORE = "AOS_KEY_READ_OOM_SCORE";
    public static final String KEY_ROUTINE_INTERVAL_IN_SEC = "AOS_KEY_ROUTINE_INTERVAL_IN_SEC";
    public static final String KEY_SIGKILL = "AOS_KEY_SIGKILL_ENABLE";
    public static final String KEY_SMALLEST_DUMP = "AOS_KEY_SMALLEST_DUMP_ENABLE";
    public static final String KEY_TRIM_MEMORY_LEVEL_INTERVAL_IN_SEC = "AOS_KEY_TRIM_MEMORY_LEVEL_INTERVAL_IN_SEC";
    public static final String KEY_UNITY_UP_CLOSE_JAVA = "B30";
    public static final String KEY_UNITY_UP_JAVA_USE_FILTER = "B31";
    public static final String KEY_UPLOAD_MMAP = "B29";
    public static final int MODULE_ID = 1004;
    public static int ROUTINE_INTERVAL_IN_SEC = 10;
    public static int TRIM_MEMORY_LEVEL_INTERVAL_IN_SEC = 2;
    private static int c;
    private static CrashModule g = new CrashModule();

    /* renamed from: a, reason: collision with root package name */
    private long f6543a;
    private CrashSightStrategy.a b;
    private boolean d = false;
    private boolean e = false;
    private Context f;

    public static CrashModule getInstance() {
        CrashModule crashModule = g;
        crashModule.id = 1004;
        return crashModule;
    }

    public synchronized boolean hasInitialized() {
        return this.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063 A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0045, B:15:0x004c, B:17:0x0063, B:19:0x007e, B:20:0x0081, B:22:0x008a, B:23:0x0091, B:28:0x005e), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008a A[Catch: all -> 0x00b4, TryCatch #0 {, blocks: (B:7:0x0003, B:10:0x0009, B:12:0x0045, B:15:0x004c, B:17:0x0063, B:19:0x007e, B:20:0x0081, B:22:0x008a, B:23:0x0091, B:28:0x005e), top: B:6:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008f  */
    @Override // com.uqm.crashsight.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void init(android.content.Context r12, boolean r13, com.uqm.crashsight.CrashSightStrategy r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto Lb7
            boolean r0 = r11.d     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto L9
            goto Lb7
        L9:
            r11.f = r12     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.proguard.m.a(r0, r2)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r0 = "Initializing crash module."
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.proguard.l.d(r0, r2)     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.proguard.b r0 = com.uqm.crashsight.proguard.b.a()     // Catch: java.lang.Throwable -> Lb4
            int r2 = com.uqm.crashsight.CrashModule.c     // Catch: java.lang.Throwable -> Lb4
            r3 = 1
            int r2 = r2 + r3
            com.uqm.crashsight.CrashModule.c = r2     // Catch: java.lang.Throwable -> Lb4
            r4 = 1004(0x3ec, float:1.407E-42)
            r0.a(r4, r2)     // Catch: java.lang.Throwable -> Lb4
            r11.d = r3     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.crashreport.CrashReport.setContext(r12)     // Catch: java.lang.Throwable -> Lb4
            r11.a(r12, r14)     // Catch: java.lang.Throwable -> Lb4
            r5 = 1004(0x3ec, float:1.407E-42)
            com.uqm.crashsight.CrashSightStrategy$a r8 = r11.b     // Catch: java.lang.Throwable -> Lb4
            r9 = 0
            r10 = 0
            r6 = r12
            r7 = r13
            com.uqm.crashsight.crashreport.crash.c r13 = com.uqm.crashsight.crashreport.crash.c.a(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> Lb4
            r13.f()     // Catch: java.lang.Throwable -> Lb4
            r13.o()     // Catch: java.lang.Throwable -> Lb4
            if (r14 == 0) goto L5e
            boolean r0 = r14.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto L4c
            goto L5e
        L4c:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.proguard.m.a(r0, r2)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.proguard.l.d(r0, r2)     // Catch: java.lang.Throwable -> Lb4
            r13.g()     // Catch: java.lang.Throwable -> Lb4
            goto L61
        L5e:
            r13.h()     // Catch: java.lang.Throwable -> Lb4
        L61:
            if (r14 == 0) goto L88
            int r0 = r14.getCallBackType()     // Catch: java.lang.Throwable -> Lb4
            r13.b(r0)     // Catch: java.lang.Throwable -> Lb4
            boolean r0 = r14.getCloseErrorCallback()     // Catch: java.lang.Throwable -> Lb4
            r13.a(r0)     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r0 = "customStrategy is not null"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.proguard.l.d(r0, r1)     // Catch: java.lang.Throwable -> Lb4
            boolean r0 = r14.isEnableCatchAnrTrace()     // Catch: java.lang.Throwable -> Lb4
            if (r0 == 0) goto L81
            r13.i()     // Catch: java.lang.Throwable -> Lb4
        L81:
            int r0 = r14.getCrashHandleTimeout()     // Catch: java.lang.Throwable -> Lb4
            r13.a(r0)     // Catch: java.lang.Throwable -> Lb4
        L88:
            if (r14 == 0) goto L8f
            long r0 = r14.getAppReportDelay()     // Catch: java.lang.Throwable -> Lb4
            goto L91
        L8f:
            r0 = 0
        L91:
            r13.a(r0)     // Catch: java.lang.Throwable -> Lb4
            r13.l()     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.crashreport.crash.d.a(r12)     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.crashreport.crash.CrashSightBroadcastReceiver r13 = com.uqm.crashsight.crashreport.crash.CrashSightBroadcastReceiver.getInstance()     // Catch: java.lang.Throwable -> Lb4
            java.lang.String r14 = "android.net.conn.CONNECTIVITY_CHANGE"
            r13.addFilter(r14)     // Catch: java.lang.Throwable -> Lb4
            r13.register(r12)     // Catch: java.lang.Throwable -> Lb4
            com.uqm.crashsight.proguard.b r12 = com.uqm.crashsight.proguard.b.a()     // Catch: java.lang.Throwable -> Lb4
            int r13 = com.uqm.crashsight.CrashModule.c     // Catch: java.lang.Throwable -> Lb4
            int r13 = r13 - r3
            com.uqm.crashsight.CrashModule.c = r13     // Catch: java.lang.Throwable -> Lb4
            r12.a(r4, r13)     // Catch: java.lang.Throwable -> Lb4
            monitor-exit(r11)
            return
        Lb4:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        Lb7:
            monitor-exit(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.CrashModule.init(android.content.Context, boolean, com.uqm.crashsight.CrashSightStrategy):void");
    }

    private synchronized void a(Context context, CrashSightStrategy crashSightStrategy) {
        if (crashSightStrategy == null) {
            return;
        }
        String libCrashSightSOFilePath = crashSightStrategy.getLibCrashSightSOFilePath();
        if (!TextUtils.isEmpty(libCrashSightSOFilePath)) {
            com.uqm.crashsight.crashreport.common.info.a.a(context).n = libCrashSightSOFilePath;
            m.a("setted libCrashSight.so file path :%s", libCrashSightSOFilePath);
        }
        if (crashSightStrategy.getCrashHandleCallback() != null) {
            this.b = crashSightStrategy.getCrashHandleCallback();
            m.a("setted CrashHanldeCallback", new Object[0]);
        }
        if (crashSightStrategy.getAppReportDelay() > 0) {
            this.f6543a = crashSightStrategy.getAppReportDelay();
            m.a("setted delay: %d", Long.valueOf(this.f6543a));
        }
    }

    @Override // com.uqm.crashsight.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        c a2;
        if (strategyBean == null || (a2 = c.a()) == null) {
            return;
        }
        a2.a(strategyBean);
    }

    private static boolean a(Map<String, String> map, String str, boolean z) {
        String str2;
        return (map == null || map.size() == 0 || (str2 = map.get(str)) == null) ? z : str2.equals("1");
    }

    private static int a(Map<String, String> map, String str, int i) {
        String str2;
        int parseInt;
        if (map == null || map.size() == 0 || (str2 = map.get(str)) == null) {
            return i;
        }
        try {
            parseInt = Integer.parseInt(str2);
        } catch (Exception e) {
            m.e("parse key[%s] error: [%s]", str, e.toString());
        }
        return parseInt > 0 ? parseInt : i;
    }

    @Override // com.uqm.crashsight.a
    public void onSelfDefiedStrategyChanged(SightPkg.RqdStrategy rqdStrategy) {
        Map<String, String> valueMapMap = rqdStrategy.getValueMapMap();
        if (valueMapMap.size() > 0) {
            m.c("rqdStrategy.getValueMap: " + valueMapMap.toString(), new Object[0]);
            com.uqm.crashsight.crashreport.common.strategy.a.a().b(new JSONObject(valueMapMap).toString());
        } else {
            m.c("rqdStrategy.getValueMap: empty", new Object[0]);
        }
        IS_OPEN_UPLOAD_MMAP = a(valueMapMap, KEY_UPLOAD_MMAP, false);
        IS_OPEN_SIGKILL_MONITORING = a(valueMapMap, KEY_SIGKILL, false);
        IS_OPEN_UNITY_UP_CLOSE_JAVA = a(valueMapMap, KEY_UNITY_UP_CLOSE_JAVA, false);
        IS_OPEN_UNITY_UP_JAVA_USE_FILTER = a(valueMapMap, KEY_UNITY_UP_JAVA_USE_FILTER, false);
        IS_OPEN_CATCH_MONO_STACK = a(valueMapMap, KEY_CATCH_MONO_STACK, false);
        IS_OPEN_SMALLEST_DUMP = a(valueMapMap, KEY_SMALLEST_DUMP, false);
        IS_OPEN_ABORT_MSG = a(valueMapMap, KEY_ABORTMSG, false);
        IS_OPEN_LR_TRACE = a(valueMapMap, KEY_LRTRACE, false);
        ROUTINE_INTERVAL_IN_SEC = a(valueMapMap, KEY_ROUTINE_INTERVAL_IN_SEC, 10);
        TRIM_MEMORY_LEVEL_INTERVAL_IN_SEC = a(valueMapMap, KEY_TRIM_MEMORY_LEVEL_INTERVAL_IN_SEC, 2);
        IS_OPEN_HANDLE_ANR_SIG_QUIT = a(valueMapMap, KEY_HANDLE_ANR_SIG_QUIT_ENABLE, false);
        DUMP_MEMORY_INFO_MAX_COUNT = a(valueMapMap, KEY_DUMP_MEMORY_INFO_MAX_COUNT, 30);
        IS_OPEN_MODULE_NAME_OMIT = a(valueMapMap, KEY_MODULE_NAME_OMIT, false);
        IS_OPEN_READ_OOM_SCORE = a(valueMapMap, KEY_READ_OOM_SCORE, false);
        IS_ANR_CHECK_PROCESS_STATE = a(valueMapMap, KEY_ANR_CHECK_PROCESS_STATE, true);
        IS_ANR_DUMP_NATIVE_STACK = a(valueMapMap, KEY_ANR_DUMP_NATIVE, true);
        ANR_MSG_TIME_THRESHOLD = a(valueMapMap, KEY_ANR_CHECK_MSG_TIME, 10);
        NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
        if (nativeCrashHandler != null) {
            nativeCrashHandler.setCatchMonoStackOpen(IS_OPEN_CATCH_MONO_STACK);
            l.a("setCatchMonoStackOpen: " + IS_OPEN_CATCH_MONO_STACK, new Object[0]);
            nativeCrashHandler.setMmkvliteOpen(IS_OPEN_UPLOAD_MMAP);
            l.a("setMmkvliteOpen: " + IS_OPEN_UPLOAD_MMAP, new Object[0]);
            nativeCrashHandler.setSmallestDumpOpen(IS_OPEN_SMALLEST_DUMP);
            l.a("setSmallestDumpOpen: " + IS_OPEN_SMALLEST_DUMP, new Object[0]);
            nativeCrashHandler.setAbortMsgOpen(IS_OPEN_ABORT_MSG);
            l.a("setAbortMsgOpen: " + IS_OPEN_ABORT_MSG, new Object[0]);
            nativeCrashHandler.setLrTraceOpen(IS_OPEN_LR_TRACE);
            l.a("setLrTraceOpen: " + IS_OPEN_LR_TRACE, new Object[0]);
            nativeCrashHandler.setIsModuleNameOmit(IS_OPEN_MODULE_NAME_OMIT);
            l.a("setIsModuleNameOmit: " + IS_OPEN_MODULE_NAME_OMIT, new Object[0]);
            if (IS_OPEN_UPLOAD_MMAP) {
                l.b("Start to upload mmkv crash. ", new Object[0]);
                c.a().m();
                if (IS_OPEN_SIGKILL_MONITORING) {
                    if (!this.e) {
                        this.e = true;
                        com.uqm.crashsight.service.b.a(this.f, ROUTINE_INTERVAL_IN_SEC, TRIM_MEMORY_LEVEL_INTERVAL_IN_SEC, DUMP_MEMORY_INFO_MAX_COUNT, IS_OPEN_READ_OOM_SCORE);
                        c.a().n();
                    }
                    m.a("enabled process alive monitor", new Object[0]);
                } else {
                    m.a("disabled process alive monitor", new Object[0]);
                }
            }
            nativeCrashHandler.setHandleAnrSigQuit(IS_OPEN_HANDLE_ANR_SIG_QUIT);
            l.a("setHandleAnrSigQuit: " + IS_OPEN_HANDLE_ANR_SIG_QUIT, new Object[0]);
            if (IS_OPEN_HANDLE_ANR_SIG_QUIT) {
                nativeCrashHandler.setAnrDumpNativeEnable(IS_ANR_DUMP_NATIVE_STACK);
                com.uqm.crashsight.crashreport.crash.anr.b.a().a(ANR_MSG_TIME_THRESHOLD);
                com.uqm.crashsight.crashreport.crash.anr.b.a().b(IS_ANR_CHECK_PROCESS_STATE);
            }
            nativeCrashHandler.setSigkillEnable(IS_OPEN_UPLOAD_MMAP && IS_OPEN_SIGKILL_MONITORING);
            StringBuilder sb = new StringBuilder("setSigkillEnable: ");
            sb.append(IS_OPEN_UPLOAD_MMAP && IS_OPEN_SIGKILL_MONITORING);
            l.a(sb.toString(), new Object[0]);
            return;
        }
        l.d("onSelfDefiedStrategyChanged nativeCrashHandler is null", new Object[0]);
    }

    @Override // com.uqm.crashsight.a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }
}
