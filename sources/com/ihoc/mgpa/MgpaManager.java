package com.ihoc.mgpa;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import com.ihoc.mgpa.IMGPAService;
import com.ihoc.mgpa.c.e;
import com.ihoc.mgpa.download.BgDownloadProxy;
import com.ihoc.mgpa.f.C;
import com.ihoc.mgpa.f.H;
import com.ihoc.mgpa.f.RunnableC0236b;
import com.ihoc.mgpa.g.g;
import com.ihoc.mgpa.i.f;
import com.ihoc.mgpa.j.B;
import com.ihoc.mgpa.j.z;
import com.ihoc.mgpa.k.c;
import com.ihoc.mgpa.m.b;
import com.ihoc.mgpa.n.a;
import com.ihoc.mgpa.n.h;
import com.ihoc.mgpa.n.m;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MgpaManager {
    private boolean hasInit = false;

    private String checkDeviceIsReal() {
        int o;
        if (f.o() == -1) {
            m.a("CheckDevice: you need init first.", new Object[0]);
        } else {
            if (f.N()) {
                o = f.o();
                m.a("CheckDevice: check result: " + o, new Object[0]);
                return "{\"result\":" + o + "}";
            }
            m.d("CheckDevice: device check func is not open.", new Object[0]);
        }
        o = 0;
        m.a("CheckDevice: check result: " + o, new Object[0]);
        return "{\"result\":" + o + "}";
    }

    private boolean saveGameDataToCache(Object obj, String str) {
        if (this.hasInit && z.b != B.NotCheck && z.b != B.CheckNow) {
            return false;
        }
        if (obj == null || !obj.equals("MultiGameData")) {
            f.a(obj, str);
            return true;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                f.a(Integer.valueOf(Integer.parseInt(next)), jSONObject.getString(next));
            }
            return true;
        } catch (Exception e) {
            m.a("SDK hasn't been initialized! Save multi game data to cache exception.", e);
            return true;
        }
    }

    public static void setTuringShieldMonitorWrapper(IMGPAService.TouchEventWrapper touchEventWrapper) {
        b.b().a(touchEventWrapper);
    }

    public boolean checkSdkCanWork() {
        return true;
    }

    public void enableDebugMode() {
        f.a(true);
    }

    public int getCurrentThreadTid() {
        int i;
        try {
            i = Process.myTid();
        } catch (Exception e) {
            e = e;
            i = -1;
        }
        try {
            m.c("TID: %d", Integer.valueOf(i));
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            m.a("get tid exception!", e);
            return i;
        }
        return i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00b5, code lost:
    
        if (r6.equals("GetOptCfg") != false) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String getDataFromTGPA(java.lang.String r6, java.lang.String r7) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.MgpaManager.getDataFromTGPA(java.lang.String, java.lang.String):java.lang.String");
    }

    public String getSdkType() {
        return z.c.a();
    }

    public int getVersionCode() {
        return BuildConfig.VERSION_CODE;
    }

    public String getVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    public String getVmpNumber() {
        return com.ihoc.mgpa.i.m.b();
    }

    public int hapticAmplitudeSupport() {
        return com.ihoc.mgpa.c.f.a().f();
    }

    public void hapticPlay(String str) {
        com.ihoc.mgpa.c.f.a().c(str);
    }

    public void hapticPlay(String str, int i, int i2, int i3) {
        com.ihoc.mgpa.c.f.a().b(str, i, i2, i3);
    }

    public void hapticPlayWithFile(String str) {
        com.ihoc.mgpa.c.f.a().b(str);
    }

    public void hapticPlayWithFile(String str, int i, int i2, int i3) {
        com.ihoc.mgpa.c.f.a().a(str, i, i2, i3);
    }

    public void hapticStop() {
        com.ihoc.mgpa.c.f.a().b();
    }

    public int hapticSupport() {
        return com.ihoc.mgpa.c.f.a().e();
    }

    public void init(Activity activity, String str) {
        f.t(str);
        if (activity == null) {
            m.b("Init failed, activity is null, ple check!", new Object[0]);
        } else {
            h.a(activity);
            init(activity.getApplicationContext());
        }
    }

    public synchronized void init(Context context) {
        m.c("Init start. tgpa sdk version name: %s", BuildConfig.VERSION_NAME);
        if (context == null) {
            m.b("Init failed, context is null, ple check!", new Object[0]);
            return;
        }
        a.a(context);
        if (this.hasInit) {
            m.d("SDK has been initialized, don't repeat to init!", new Object[0]);
        } else {
            new C().start();
            this.hasInit = true;
        }
    }

    public void init(Context context, String str) {
        f.t(str);
        init(context);
    }

    public void init(String str) {
        init(a.a(), str);
    }

    public void initForCocos() {
        init("Cocos");
    }

    public void initForUE4() {
        init("UE4");
    }

    public void initForUFO() {
        init("UFO");
    }

    public void initForUnity() {
        init("Unity");
    }

    public native void nativeNotifySystemInfo(String str);

    public void postGameMatchFPS(int i, ArrayList<Float> arrayList) {
        e.a().a(i, arrayList);
    }

    public void registerCallback() {
        m.c("Register VmpCallback start for UE4. ", new Object[0]);
        registerCallback(new MgpaCallback() { // from class: com.ihoc.mgpa.MgpaManager.2
            @Override // com.ihoc.mgpa.MgpaCallback
            public void notifySystemInfo(String str) {
                MgpaManager.this.nativeNotifySystemInfo(str);
            }
        });
    }

    public void registerCallback(MgpaCallback mgpaCallback) {
        m.c("Register MgpaCallback start.", new Object[0]);
        RunnableC0236b.a(mgpaCallback);
        c.a().a(mgpaCallback);
    }

    public void registerCallbackForUnity() {
        m.c("Register VmpCallback start for Unity. ", new Object[0]);
        registerCallback(new MgpaCallback() { // from class: com.ihoc.mgpa.MgpaManager.1
            @Override // com.ihoc.mgpa.MgpaCallback
            public void notifySystemInfo(String str) {
                h.a(str);
            }
        });
    }

    public void reportGameUserInfo(Context context, HashMap<String, String> hashMap) {
        m.a("Update: reportGameUserInfo start.", new Object[0]);
        H.b().a("DeviceBind", hashMap);
    }

    public void setLogAble(boolean z) {
        m.a(z);
    }

    public void updateGameInfo(int i, float f) {
        updateGameInfo(i, String.format(Locale.CHINA, "%.2f", Float.valueOf(f)));
        if (i == com.ihoc.mgpa.a.e.FPS.a()) {
            updateGameInfo(com.ihoc.mgpa.a.e.FPS.a(), new float[]{f});
        }
    }

    public void updateGameInfo(int i, int i2) {
        updateGameInfo(i, String.valueOf(i2));
    }

    public void updateGameInfo(int i, String str) {
        m.a("Update: int/string data, key: %d", Integer.valueOf(i));
        saveGameDataToCache(Integer.valueOf(i), str);
        H.b().b(i, str);
    }

    public void updateGameInfo(int i, float[] fArr) {
        if (f.ga() && f.Y()) {
            H.b().a(i, fArr);
        } else {
            m.a("Update: int/float[] sdk func or report is not open. ", new Object[0]);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void updateGameInfo(String str, String str2) {
        char c;
        boolean z = true;
        m.a("Update: string/string data, key: %s", str);
        switch (str.hashCode()) {
            case -1434056934:
                if (str.equals("TuringShield")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1100846426:
                if (str.equals("BgPreDownload")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -915806337:
                if (str.equals("OverseaDomain")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -883380647:
                if (str.equals("LocalTransceiver")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -829263554:
                if (str.equals(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -427062652:
                if (str.equals("Transceiver")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1722:
                if (str.equals("60")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1725:
                if (str.equals("63")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 69833:
                if (str.equals("FPS")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 70796:
                if (str.equals("GPU")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 63475420:
                if (str.equals("AppID")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 74110807:
                if (str.equals("MapID")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 95060634:
                if (str.equals("CleanPDFiles")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 1289166129:
                if (str.equals("DynamicSetting")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1640531463:
                if (str.equals("ServerDomain")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1776702049:
                if (str.equals("UseNonRichTap")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2127512017:
                if (str.equals("HEPlay")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 2127609503:
                if (str.equals("HEStop")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
                g.f5562a = str2;
                return;
            case 2:
                f.n(String.valueOf(str2));
                return;
            case 3:
                f.o(String.valueOf(str2));
                return;
            case 4:
                f.e(String.valueOf(str2));
                return;
            case 5:
                f.k(String.valueOf(str2));
                return;
            case 6:
                f.h(String.valueOf(str2));
                com.ihoc.mgpa.i.m.a(str2);
                return;
            case 7:
                com.ihoc.mgpa.c.m.c().b();
                return;
            case '\b':
                b.b().a(str2);
                return;
            case '\t':
            case '\n':
                c.a().a(str, str2);
                return;
            case 11:
                try {
                    H.b().b(com.ihoc.mgpa.a.e.FPS.a(), String.valueOf(str2));
                    H.b().a(com.ihoc.mgpa.a.e.FPS.a(), new float[]{Float.parseFloat(str2)});
                    return;
                } catch (Exception unused) {
                    m.a("Perf_update: update fps exception. value：%s", str2);
                    return;
                }
            case '\f':
                try {
                    if (Integer.parseInt(str2) <= 0) {
                        z = false;
                    }
                    f.b(z);
                    return;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    return;
                }
            case '\r':
                BgDownloadProxy.getInstance().handleStringData(str2);
                return;
            case 14:
            case 15:
                com.ihoc.mgpa.c.f.a().a(str2);
                return;
            case 16:
            case 17:
                com.ihoc.mgpa.c.f.a().b();
                return;
            default:
                if (saveGameDataToCache(str, str2)) {
                    m.a("SDK hasn't been initialized! Save k/v data to cache success, key: %s", String.valueOf(str));
                }
                H.b().a(str, str2);
                return;
        }
    }

    public void updateGameInfo(String str, HashMap<String, String> hashMap) {
        m.a("Update: string/Map data, key: %s", str);
        H.b().a(str, hashMap);
    }
}
