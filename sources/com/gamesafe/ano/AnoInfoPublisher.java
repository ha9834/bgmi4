package com.gamesafe.ano;

import com.tencent.midas.oversea.api.CocosPayHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class AnoInfoPublisher implements Runnable {
    public static final int ANO_INFO_TYPE_DETECT_RESULT = 1;
    public static final int ANO_INFO_TYPE_HEARTBEAT = 2;

    /* renamed from: a, reason: collision with root package name */
    private static volatile AnoInfoPublisher f1090a;
    private static Thread b;
    private static volatile boolean c;
    private ArrayList d = new ArrayList();

    /* loaded from: classes.dex */
    public interface AnoInfoReceiver {
        void onReceive(int i, String str);
    }

    private AnoInfoPublisher() {
    }

    private static int a() {
        try {
            return Integer.parseInt(b.c(a.a("dgx_jkzi_kdkz")));
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void a(int i, String str) {
        if (str == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (AnoInfoPublisher.class) {
            arrayList.addAll(this.d);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((AnoInfoReceiver) it.next()).onReceive(i, str);
        }
    }

    private static void b() {
        try {
            b.c(a.a("dgx_xgjnz_kdkz"));
        } catch (Exception unused) {
        }
    }

    private static String c() {
        try {
            return b.c(a.a("dgx_mzxq_kdkz"));
        } catch (Exception unused) {
            return CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR;
        }
    }

    public static AnoInfoPublisher getInstance() {
        if (f1090a == null) {
            synchronized (AnoInfoPublisher.class) {
                if (f1090a == null) {
                    f1090a = new AnoInfoPublisher();
                }
            }
        }
        return f1090a;
    }

    public void registAnoInfoReceiver(AnoInfoReceiver anoInfoReceiver) {
        if (anoInfoReceiver == null) {
            return;
        }
        synchronized (AnoInfoPublisher.class) {
            this.d.add(anoInfoReceiver);
        }
        if (c) {
            return;
        }
        synchronized (AnoSdk.class) {
            if (!c) {
                c = true;
                b = new Thread(getInstance());
                b.start();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int indexOf;
        if (a() == -1) {
            c = false;
            return;
        }
        while (true) {
            try {
                try {
                    String c2 = c();
                    if (c2 == null || c2.equals(CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR) || (indexOf = c2.indexOf(124)) == -1) {
                        break;
                    }
                    int parseInt = Integer.parseInt(c2.substring(0, indexOf));
                    if (parseInt > 0) {
                        a(parseInt, c2.substring(indexOf + 1));
                    } else {
                        try {
                            Thread.sleep(1000L);
                        } catch (Exception unused) {
                        }
                    }
                } catch (Exception unused2) {
                }
            } finally {
                b();
                c = false;
            }
        }
    }
}
