package com.ihoc.mgpa.download;

import android.app.Activity;
import com.ihoc.mgpa.f.H;
import com.ihoc.mgpa.f.RunnableC0236b;
import com.ihoc.mgpa.g.C0246c;
import com.ihoc.mgpa.g.o;
import com.ihoc.mgpa.i.a;
import com.ihoc.mgpa.i.f;
import com.ihoc.mgpa.n.h;
import com.ihoc.mgpa.n.m;
import com.ihoc.mgpa.n.p;
import com.nostra13.universalimageloader.core.d;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class BgDownloadModuleAdapter {
    private static volatile BgDownloadModuleAdapter mInstance;

    public static BgDownloadModuleAdapter getInstance() {
        if (mInstance == null) {
            synchronized (BgDownloadModuleAdapter.class) {
                if (mInstance == null) {
                    mInstance = new BgDownloadModuleAdapter();
                }
            }
        }
        return mInstance;
    }

    public int getBatteryMin() {
        return o.b().c.o.e;
    }

    public C0246c getBgPreDownloadConfig() {
        return o.b().c.o;
    }

    public String getCurrentSceneId() {
        return f.c();
    }

    public int getFileOverdueTime() {
        return o.b().c.o.f;
    }

    public Activity getGameMainActivity() {
        return h.a();
    }

    public boolean getNotifyProgress() {
        return o.b().c.o.c;
    }

    public String getNotifyTitle() {
        return o.b().c.o.d;
    }

    public boolean isBgCloseNotifyInFore() {
        return o.b().b.P;
    }

    public boolean isBgPreDownloadFuncOpen() {
        return f.I();
    }

    public boolean isCallbackFucOpen() {
        return f.J();
    }

    public boolean isDebug() {
        return false;
    }

    public boolean isNeedWifi() {
        return o.b().c.o.b;
    }

    public void printLog(String str, String str2, String str3) {
        if (p.a(str2) || p.a(str3)) {
            return;
        }
        char c = 65535;
        int hashCode = str3.hashCode();
        if (hashCode != 100) {
            if (hashCode != 101) {
                if (hashCode != 105) {
                    if (hashCode == 119 && str3.equals("w")) {
                        c = 2;
                    }
                } else if (str3.equals("i")) {
                    c = 0;
                }
            } else if (str3.equals("e")) {
                c = 3;
            }
        } else if (str3.equals(d.f5744a)) {
            c = 1;
        }
        switch (c) {
            case 0:
                m.c(str, str2);
                return;
            case 1:
                m.a(str, str2);
                return;
            case 2:
                m.d(str, str2);
                return;
            case 3:
                m.b(str, str2);
                return;
            default:
                return;
        }
    }

    public void reportInGamePreDownload(HashMap<String, String> hashMap) {
        com.ihoc.mgpa.i.m.a(a.VMP_IN_GAME_PRE_DOWNLOAD, hashMap);
    }

    public void sendBgDownloadCallbackDataToHandler(String str) {
        H.b().a(new RunnableC0236b(com.ihoc.mgpa.a.a.VACANT_DOWNLOAD, str));
    }

    public void sendBgDownloadDataToHandler(int i, String str) {
        H.b().a(i, str);
    }

    public String whoCtrl() {
        return o.b().c.o.f5558a;
    }
}
