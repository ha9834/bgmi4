package com.ihoc.mgpa.j;

import android.content.Context;
import com.ihoc.mgpa.MgpaCallback;
import com.samsung.android.game.compatibility.SharedMemory;
import com.samsung.android.game.gamelib.GameServiceHelper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class w extends C0249a {
    private static volatile w b;
    private GameServiceHelper e;
    private boolean c = false;
    private boolean d = false;
    private long f = 0;
    private int g = -1;
    private int h = -99;
    private MgpaCallback i = null;
    private SharedMemory j = null;
    private int k = 0;
    private int l = 0;

    private w() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(int i) {
        if (i == 0) {
            return 0;
        }
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    private void a(int i, int i2, int i3, int i4) {
        if (this.k >= 10) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: update data to spa exception times > 10. ");
            return;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("SamSungSdkProxy2:updateGameDataToSPA: value: ");
            sb.append(i);
            com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            this.j.writeBytes(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array(), i2, i3, i4);
        } catch (Exception unused) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: write spa data exception. ");
            this.k++;
        }
    }

    private void a(String str, int i, int i2, int i3) {
        if (this.k >= 10) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: update data to spa is not available, or exception times > 10. ");
            return;
        }
        if (i2 == 0) {
            try {
                if (str.length() > i3) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("samsung sdk2: value is long then required size. value: ");
                    sb.append(str);
                    com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: write spa data exception. ");
                this.k++;
                return;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SamSungSdkProxy2:updateGameDataToSPA: value: ");
        sb2.append(str);
        com.ihoc.mgpa.n.m.a("TGPA", sb2.toString());
        this.j.writeBytes(str.getBytes(Charset.forName("US-ASCII")), i, i2, str.length());
    }

    public static w g() {
        if (b == null) {
            synchronized (w.class) {
                if (b == null) {
                    b = new w();
                }
            }
        }
        return b;
    }

    private void j() {
        try {
            this.j = new SharedMemory("spa_tgpa", 256);
            if (this.e.initLowLatencyIPC("{\"1\":{\"name\":\"main version\",\"type\":\"string\",\"length\":\"16\"},\"2\":{\"name\":\"resource version\",\"type\":\"string\",\"length\":\"16\"},\"4\":{\"name\":\"scene\",\"type\":\"integer\",\"maximum\":\"1000\",\"minimum\":\"0\"},\"5\":{\"name\":\"fps\",\"type\":\"integer\",\"maximum\":\"60\",\"minimum\":\"0\"},\"6\":{\"name\":\"frame miss\",\"type\":\"integer\",\"maximum\":\"30\",\"minimum\":\"0\"},\"7\":{\"name\":\"limit fps\",\"type\":\"integer\",\"maximum\":\"60\",\"minimum\":\"0\"},\"8\":{\"name\":\"model quality\",\"type\":\"integer\"},\"9\":{\"name\":\"effect quality\",\"type\":\"integer\"},\"10\":{\"name\":\"resolution\",\"type\":\"label\",\"value\":{\"0\":\"720P\",\"1\":\"1080P\"}},\"11\":{\"name\":\"user count\",\"type\":\"integer\",\"maximum\":\"100\",\"minimum\":\"1\"},\"12\":{\"name\":\"network latency\",\"type\":\"integer\"},\"13\":{\"name\":\"record status\",\"type\":\"boolean\"},\"15\":{\"name\":\"server ip address\",\"type\":\"string\",\"length\":\"32\"},\"16\":{\"name\":\"role status\",\"type\":\"boolean\"},\"40\":{\"name\":\"scene type\",\"type\":\"integer\",\"maximum\":\"1000\",\"minimum\":\"0\"},\"41\":{\"name\":\"load map status\",\"type\":\"boolean\"},\"42\":{\"name\":\"bombing status\",\"type\":\"boolean\"},\"43\":{\"name\":\"multithread status\",\"type\":\"boolean\"},\"51\":{\"name\":\"heavy thread\",\"type\":\"integer\"},\"52\":{\"name\":\"role outline\",\"type\":\"boolean\"},\"53\":{\"name\":\"picture style\",\"type\":\"integer\"},\"54\":{\"name\":\"Anti-aliasing\",\"type\":\"integer\"},\"55\":{\"name\":\"Server IP port\",\"type\":\"integer\"},\"56\":{\"name\":\"protocol type\",\"type\":\"integer\"},\"57\":{\"name\":\"shadow\",\"type\":\"integer\"},\"80\":{\"name\":\"cpu level\",\"type\":\"integer\"},\"81\":{\"name\":\"gpu level\",\"type\":\"integer\"},\"82\":{\"name\":\"target fps\",\"type\":\"integer\"},\"83\":{\"name\":\"scene importance\",\"type\":\"integer\"},\"90\":{\"name\":\"tgpa version\",\"type\":\"string\",\"length\":\"16\"}}", this.j) != 0) {
                com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: init lowlatencyIPC failed. ");
                this.j.close();
            } else {
                this.d = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: check spa exception. ");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String k() {
        String valueOf = String.valueOf(this.e.getVersion());
        com.ihoc.mgpa.n.m.a("TGPA", "SamSungSdkProxy2:getGameSdkVersion: " + valueOf);
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        String str;
        String str2;
        if (this.e.registerListener(new C0268u(this))) {
            str = "TGPA";
            str2 = "registerGame: samsung2 gamesdk register callback success.";
        } else {
            str = "TGPA";
            str2 = "registerGame: samsung2 gamesdk register callback failed.";
        }
        com.ihoc.mgpa.n.m.a(str, str2);
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public void a() {
        a(com.ihoc.mgpa.n.a.a(), new r(this));
        new Thread(new RunnableC0266s(this)).start();
    }

    public void a(float f) {
        if (!this.d) {
            com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: sdk is not support or spa not support. ");
            return;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: spa register callback result: " + this.e.registerToTGPACallback(new C0269v(this), f));
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(int i, String str) {
        if (this.c) {
            a(com.ihoc.mgpa.f.G.a(i, str, b()));
        }
    }

    public void a(Context context, InterfaceC0250b interfaceC0250b) {
        com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: ready to bind samsung server.");
        if (this.e == null) {
            this.e = new GameServiceHelper();
        }
        this.e.registerBindListener(new C0267t(this, interfaceC0250b));
        this.e.bind(context);
    }

    public void a(String str) {
        if (!this.c || str == null || str.length() <= 2) {
            return;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "updateGameInfo: samsung2 json: " + str);
        this.e.updateGameInfo(str);
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void a(HashMap<String, String> hashMap) {
        if (this.c) {
            a(com.ihoc.mgpa.f.G.a(hashMap, b()));
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a, com.ihoc.mgpa.j.InterfaceC0253e
    public A b() {
        return A.SAMSUNG2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.RegionMaker.calcSwitchOut(RegionMaker.java:923)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:797)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processFallThroughCases(RegionMaker.java:841)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:800)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processFallThroughCases(RegionMaker.java:841)
        	at jadx.core.dex.visitors.regions.RegionMaker.processSwitch(RegionMaker.java:800)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:157)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:735)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:740)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:152)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:91)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x003a. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0040. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    @Override // com.ihoc.mgpa.j.C0249a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(int r7, java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.j.w.b(int, java.lang.String):void");
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public void b(HashMap<String, String> hashMap) {
        if (com.ihoc.mgpa.i.f.ca) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                b(Integer.parseInt(entry.getKey()), entry.getValue());
            }
        }
        if (com.ihoc.mgpa.i.f.ba) {
            a(hashMap);
        }
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public String d() {
        return this.d ? this.e.totgpa() : "ERROR";
    }

    @Override // com.ihoc.mgpa.j.C0249a
    public boolean e() {
        return this.d;
    }

    public String h() {
        String vendorSupportStrategy = this.e.getVendorSupportStrategy("{\"10000\":0}");
        com.ihoc.mgpa.n.m.a("TGPA", "SamSungSdkProxy2:getVendorSupportStrategy: " + String.valueOf(vendorSupportStrategy));
        if (vendorSupportStrategy != null) {
            return vendorSupportStrategy;
        }
        com.ihoc.mgpa.n.m.a("TGPA", "samsung sdk2: gamesdk get vendor strategy null.");
        return "ERROR";
    }

    public com.ihoc.mgpa.i.g i() {
        try {
            this.c = this.e.init();
            if (!this.e.init()) {
                com.ihoc.mgpa.n.m.a("[SamSungSdkProxy2]: game service init failed.", new Object[0]);
                return com.ihoc.mgpa.i.g.SAMSUNG2_GAME_SERVICE_HELPER_INIT_FAILED;
            }
            this.c = true;
            j();
            return com.ihoc.mgpa.i.g.VMP_SUCCESS;
        } catch (Exception e) {
            com.ihoc.mgpa.n.m.a("[SamSungSdkProxy2]: game service init exception.", e);
            return com.ihoc.mgpa.i.g.SAMSUNG2_GAME_SERVICE_HELPER_INIT_EXCEPTION;
        }
    }
}
