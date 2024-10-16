package com.tencent.hawk.bridge;

import android.app.Activity;
import com.tencent.hawk.utils.CocosHelper;

/* loaded from: classes2.dex */
public class PerfSightCocos {
    static {
        System.loadLibrary("TDataMaster");
        System.loadLibrary("cubehawk");
    }

    private static void runTaskInUiThread(Runnable runnable) {
        Activity cocosActivity = CocosHelper.getCocosActivity();
        if (cocosActivity != null) {
            cocosActivity.runOnUiThread(runnable);
        } else {
            new Thread(runnable).start();
        }
    }

    public static void setGlobalQuality(final int i) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.1
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.setGlobalQuality(i);
            }
        });
    }

    public static void setUserId(final String str) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.2
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.setUserId(str);
            }
        });
    }

    public static void markLevelLoad(final String str, final int i) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.3
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.markLevelLoad(str, i);
            }
        });
    }

    public static void markLevelLoadCompleted() {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.4
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.markLevelLoadCompleted();
            }
        });
    }

    public static void markLevelFin() {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.5
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.markLevelFin();
            }
        });
    }

    public static void beginTag(final String str) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.6
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.beginTag(str);
            }
        });
    }

    public static void endTag() {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.7
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.endTag();
            }
        });
    }

    public static void setDefinedDeviceClass(final int i) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.8
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.setDefinedDeviceClass(i);
            }
        });
    }

    public static void setTargetFramerate(final int i) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.9
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.setTargetFramerate(i);
            }
        });
    }

    public static void postEvent(final int i, final String str) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.10
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.postEvent(i, str);
            }
        });
    }

    public static synchronized int hawkInitForCocos(final String str, final String str2, final String str3, final String str4) {
        synchronized (PerfSightCocos.class) {
            runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.11
                @Override // java.lang.Runnable
                public void run() {
                    HawkAgent.hawkInitForCocos(str, str2, str3, str4);
                }
            });
        }
        return 0;
    }

    public static int checkDCLSByQccSync(String str, String str2, String str3) {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.12
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.beignExclude();
            }
        });
        return 0;
    }

    public static void beignExclude() {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.13
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.beignExclude();
            }
        });
    }

    public static void endExclude() {
        runTaskInUiThread(new Runnable() { // from class: com.tencent.hawk.bridge.PerfSightCocos.14
            @Override // java.lang.Runnable
            public void run() {
                HawkAgent.endExclude();
            }
        });
    }
}
