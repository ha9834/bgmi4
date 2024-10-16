package com.ihoc.mgpa.f;

import android.content.Context;
import android.content.SharedPreferences;
import com.ihoc.mgpa.BuildConfig;
import com.ihoc.mgpa.download.BgDownloadProxy;
import com.ihoc.mgpa.notch.NotchManager;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.imsdk.android.tools.log.LogUtils;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public class C extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, String> f5517a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes2.dex */
    private class b {

        /* renamed from: a, reason: collision with root package name */
        private String f5518a;
        private a b;

        public b(String str, a aVar) {
            this.f5518a = str;
            this.b = aVar;
        }

        public void a() {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                com.ihoc.mgpa.n.m.a("TGPA_Init", String.format(Locale.US, "start async init task: %s , in thread: %s.", this.f5518a, Thread.currentThread().getName()));
                if (this.b != null) {
                    this.b.a();
                }
                if (C.this.f5517a != null) {
                    C.this.f5517a.put(String.valueOf(this.f5518a), "0");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                com.ihoc.mgpa.i.m.a(this.f5518a, th);
                if (C.this.f5517a != null) {
                    C.this.f5517a.put(String.valueOf(this.f5518a), CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR);
                }
                com.ihoc.mgpa.n.m.b(this.f5518a + " code run exception.", new Object[0]);
            }
            com.ihoc.mgpa.n.m.a("TGPA_Init", String.format(Locale.US, "end init task: %s , in thread: %s , run time: %d .", this.f5518a, Thread.currentThread().getName(), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        }
    }

    public C() {
        super("tgpa_init");
        this.f5517a = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        String str;
        String str2;
        String str3;
        String str4;
        com.ihoc.mgpa.i.f.l(com.ihoc.mgpa.n.f.b(com.ihoc.mgpa.n.a.a()));
        com.ihoc.mgpa.i.f.a(com.ihoc.mgpa.n.f.a(com.ihoc.mgpa.n.a.a()));
        if (com.ihoc.mgpa.n.i.b(com.ihoc.mgpa.n.a.e())) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "prepare tgpa dir success! ", true);
            if (com.ihoc.mgpa.n.i.b(com.ihoc.mgpa.n.a.f())) {
                str3 = "TGPA_Init";
                str4 = "prepare tgpa log dir success! ";
            } else {
                str3 = "TGPA_Init";
                str4 = "prepare tgpa log dir failed! ";
            }
            com.ihoc.mgpa.n.m.a(str3, str4, true);
            if (com.ihoc.mgpa.n.i.b(com.ihoc.mgpa.n.a.g())) {
                str = "TGPA_Init";
                str2 = "prepare tgpa predownload dir success! ";
            } else {
                str = "TGPA_Init";
                str2 = "prepare tgpa predownload dir failed! ";
            }
        } else {
            str = "TGPA_Init";
            str2 = "prepare tgpa dir failed! ";
        }
        com.ihoc.mgpa.n.m.a(str, str2, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        String str;
        String str2;
        com.ihoc.mgpa.g.i iVar = new com.ihoc.mgpa.g.i();
        com.ihoc.mgpa.i.g a2 = iVar.a();
        this.f5517a.put("config_cloud_result", a2.a());
        if (a2 != com.ihoc.mgpa.i.g.VMP_SUCCESS) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "request cloud config failed. ");
            a2 = iVar.b();
            if (a2 == com.ihoc.mgpa.i.g.VMP_SUCCESS) {
                str = "TGPA_Init";
                str2 = "get local config success. ";
            } else {
                str = "TGPA_Init";
                str2 = "get local config failed. ";
            }
        } else {
            str = "TGPA_Init";
            str2 = "request cloud config success.";
        }
        com.ihoc.mgpa.n.m.a(str, str2);
        this.f5517a.put("config_check_result", a2.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        String str = com.ihoc.mgpa.n.a.f() + File.separator + "vmpdebug.log";
        if (!com.ihoc.mgpa.g.o.b().b.b || com.ihoc.mgpa.n.i.a(str)) {
            return;
        }
        com.ihoc.mgpa.n.m.b(true);
        com.ihoc.mgpa.n.m.a();
        com.ihoc.mgpa.n.m.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (C0243i.a().a("TGPA_DEBUG")) {
            com.ihoc.mgpa.n.m.a(true);
            com.ihoc.mgpa.n.m.a("enable log from config file", new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Context a2 = com.ihoc.mgpa.n.a.a();
        if (a2 == null) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "context is null when check device info.", true);
        } else if (com.ihoc.mgpa.i.f.N()) {
            new com.ihoc.mgpa.c.d(a2).a();
        } else {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "Perf_init: device check func is not open. ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        String str = com.ihoc.mgpa.n.a.e() + "/vmpdebug";
        if (com.ihoc.mgpa.n.i.a(str)) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "found debug file. debugfile path: " + str, true);
            com.ihoc.mgpa.i.f.a(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        String str = com.ihoc.mgpa.n.a.f() + File.separator + "vmpdebug.log";
        if (com.ihoc.mgpa.n.i.a(str)) {
            com.ihoc.mgpa.n.m.b(true);
            com.ihoc.mgpa.n.m.a();
            com.ihoc.mgpa.n.m.b();
            com.ihoc.mgpa.n.m.a("found log file. logfile path: %s", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (com.ihoc.mgpa.i.f.qa()) {
            new com.ihoc.mgpa.h.p().a();
        } else {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "get oaid failed!, func is not open.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (com.ihoc.mgpa.i.f.X()) {
            com.ihoc.mgpa.c.m.c().a();
        } else {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "Perf_init:checkPredownFile: func is not open.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (com.ihoc.mgpa.n.a.a() == null) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "context is null when check vendor server.", true);
            return;
        }
        com.ihoc.mgpa.j.z.c().a();
        if (!com.ihoc.mgpa.i.f.aa()) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "ssp func is not open.");
        } else {
            C0240f.b().c();
            C0240f.b().d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (com.ihoc.mgpa.i.f.na()) {
            String d = com.ihoc.mgpa.d.a.d();
            if (d.length() != 64) {
                com.ihoc.mgpa.n.m.b("TGPA_Init", "get uid failed!, uid: " + d);
            }
        } else {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "get uid failed!, func is not open.");
        }
        if (com.ihoc.mgpa.i.f.ca()) {
            String b2 = com.ihoc.mgpa.d.a.b();
            if (b2.length() != 64) {
                com.ihoc.mgpa.n.m.b("TGPA_Init", "get xid failed!, xid: " + b2);
            } else {
                com.ihoc.mgpa.i.l.a().a(DeviceInfoName.XID_STRING, b2);
            }
        } else {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "get xid failed!, func is not open.");
        }
        if (com.ihoc.mgpa.i.f.L()) {
            com.ihoc.mgpa.n.o.b("DebugID", com.ihoc.mgpa.d.a.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (com.ihoc.mgpa.n.a.a() == null) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "context is null when init predownload.", true);
        } else if (com.ihoc.mgpa.i.f.I()) {
            BgDownloadProxy.getInstance().cleanFile();
            BgDownloadProxy.getInstance().checkCloudCtlConfig();
            com.ihoc.mgpa.n.m.a("TGPA_Init", "checkBgPreDownloadNewTask is doing ");
            BgDownloadProxy.getInstance().initAndCheck();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        Context a2 = com.ihoc.mgpa.n.a.a();
        if (a2 == null) {
            com.ihoc.mgpa.n.m.b("context is null when init bugly.", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = a2.getSharedPreferences(APMidasPayNewAPI.BUGLY_SP_NAME, 0).edit();
        edit.putString("7f7b152a32", BuildConfig.VERSION_NAME);
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (com.ihoc.mgpa.i.f.R()) {
            com.ihoc.mgpa.c.f.a().c();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("haptic_support", String.valueOf(com.ihoc.mgpa.c.f.a().d()));
        hashMap.put("am_support", String.valueOf(com.ihoc.mgpa.c.f.a().f()));
        hashMap.put(com.helpshift.BuildConfig.FLAVOR_supportDimension, String.valueOf(com.ihoc.mgpa.c.f.a().e()));
        com.ihoc.mgpa.i.m.d(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        com.ihoc.mgpa.n.m.a("TGPA_Init", "reportNotchInfo start.");
        Context a2 = com.ihoc.mgpa.n.a.a();
        if (a2 == null) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "context is null when report notch info.", true);
            return;
        }
        String notchInfo = NotchManager.getInstance().getNotchInfo();
        if (notchInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("notch", notchInfo);
            com.ihoc.mgpa.i.m.f(hashMap);
        } else if (com.ihoc.mgpa.i.f.U()) {
            NotchManager.getInstance().notchProbe(a2);
            String notchInfo2 = NotchManager.getInstance().getNotchInfo();
            if (notchInfo2 != null) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("notch_probe", notchInfo2);
                com.ihoc.mgpa.i.m.f(hashMap2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        String str = com.ihoc.mgpa.n.a.f() + File.separator + "vmpdebug-1.log";
        if (!com.ihoc.mgpa.g.o.b().b.c || !com.ihoc.mgpa.n.i.a(str)) {
            com.ihoc.mgpa.n.m.a("TGPA_Init", "do not need to upload log file.");
            return;
        }
        String str2 = com.ihoc.mgpa.n.a.c() + "_Android_" + com.ihoc.mgpa.n.d.a(com.ihoc.mgpa.n.i.e(str), "yyyyMMddHHmmss") + LogUtils.LOG_EXT;
        String str3 = com.ihoc.mgpa.g.g.a() + "/predown/upload";
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("openid", com.ihoc.mgpa.i.f.q());
        hashMap.put(DeviceInfoName.XID_STRING, com.ihoc.mgpa.c.r.c());
        hashMap.put("plat_type", "Android");
        new com.ihoc.mgpa.n.c(new s(this)).a(str3, hashMap, str, str2);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        new b("Task_Base", new t(this)).a();
        new b("Task_VmpHandler", new u(this)).a();
        new b("Task_CloudCheck", new v(this)).a();
        new b("Task_SubHandler", new w(this)).a();
        new b("Task_UploadLog", new x(this)).a();
        new b("Task_RegisterObserver", new y(this)).a();
        new b("Task_VendorServerCheck", new z(this)).a();
        new b("Task_BgPreDownload", new A(this)).a();
        new b("Task_TuringShield", new B(this)).a();
        new b("Task_OAID", new j(this)).a();
        new b("Task_XID", new k(this)).a();
        new b("Task_Notch", new l(this)).a();
        new b("Task_DeviceCheck", new m(this)).a();
        new b("Task_PredownFileCheck", new n(this)).a();
        new b("Task_Haptic", new o(this)).a();
        new b("Task_Transceiver", new p(this)).a();
        new b("Task_DataForward", new q(this)).a();
        new b("Task_Report", new r(this, currentTimeMillis)).a();
        com.ihoc.mgpa.n.m.c("tgpa sdk init over!", new Object[0]);
    }
}
