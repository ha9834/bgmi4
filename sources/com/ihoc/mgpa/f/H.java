package com.ihoc.mgpa.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tdatamaster.tdm.device.DeviceInfoName;
import com.tencent.smtt.sdk.QbSdk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class H {

    /* renamed from: a, reason: collision with root package name */
    private static volatile H f5521a;
    private com.ihoc.mgpa.b.c c;
    private a d;
    private final ArrayList<com.ihoc.mgpa.b.h> b = new ArrayList<>();
    private HandlerThread e = new HandlerThread("tgpa_mainhandler");

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            try {
                switch (message.what) {
                    case 1:
                        H.this.c(message.arg2, String.valueOf(message.obj));
                        return;
                    case 2:
                        H.this.b(message.arg2, (float[]) message.obj);
                        return;
                    case 3:
                        HashMap hashMap = (HashMap) message.obj;
                        HashMap hashMap2 = new HashMap();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            hashMap2.put(String.valueOf(entry.getKey()), entry.getValue());
                        }
                        H.this.b((HashMap<String, String>) hashMap2);
                        return;
                    case 4:
                        H.this.b(String.valueOf(message.obj));
                        return;
                    case 5:
                        if (com.ihoc.mgpa.i.f.ia()) {
                            com.ihoc.mgpa.c.o.a().a(message.arg1, message.arg2);
                            return;
                        }
                        return;
                    case 6:
                        if (com.ihoc.mgpa.i.f.ma()) {
                            com.ihoc.mgpa.m.b.b().a(String.valueOf(message.obj));
                            return;
                        }
                        return;
                    case 7:
                        if (com.ihoc.mgpa.i.f.I() && com.ihoc.mgpa.g.o.b().b.O && H.this.c != null) {
                            H.this.c.a(message.arg2, String.valueOf(message.obj));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                com.ihoc.mgpa.i.m.a("VmpHandler", th);
                com.ihoc.mgpa.n.m.b("handleMessage: exception. msg what: %d.", Integer.valueOf(message.what));
            }
        }
    }

    private H() {
    }

    private void a(com.ihoc.mgpa.b.h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("The observer is null.");
        }
        synchronized (this.b) {
            if (this.b.contains(hVar)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Observer ");
                sb.append(hVar.getClass());
                sb.append(" is already registered.");
                throw new IllegalStateException(sb.toString());
            }
            this.b.add(hVar);
        }
    }

    public static H b() {
        if (f5521a == null) {
            synchronized (H.class) {
                if (f5521a == null) {
                    f5521a = new H();
                }
            }
        }
        return f5521a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b(int i, float[] fArr) {
        com.ihoc.mgpa.n.m.a("TGPA", "handleMessage: 2 key:  " + i + " , value: Fps");
        synchronized (this.b) {
            Iterator<com.ihoc.mgpa.b.h> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(i, fArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        com.ihoc.mgpa.n.m.a("TGPA", "handleMessage: 4 ApmKey.");
        HashMap<String, String> a2 = com.ihoc.mgpa.g.o.b().c.f.a(str);
        if (a2 != null) {
            b(a2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b(HashMap<String, String> hashMap) {
        com.ihoc.mgpa.n.m.a("TGPA", "handleMessage: 3 hashmap.");
        synchronized (this.b) {
            Iterator<com.ihoc.mgpa.b.h> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(hashMap);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void c(int i, String str) {
        com.ihoc.mgpa.n.m.a("TGPA", "handleMessage: 1 key:  " + i + " , value: " + str);
        synchronized (this.b) {
            Iterator<com.ihoc.mgpa.b.h> it = this.b.iterator();
            while (it.hasNext()) {
                it.next().a(i, str);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void d() {
        synchronized (this.b) {
            Iterator<com.ihoc.mgpa.b.h> it = this.b.iterator();
            while (it.hasNext()) {
                com.ihoc.mgpa.b.h next = it.next();
                StringBuilder sb = new StringBuilder();
                sb.append("VmpHandler: ");
                sb.append(next.getClass());
                sb.append(" observer has registered!");
                com.ihoc.mgpa.n.m.a("TGPA", sb.toString());
            }
        }
    }

    private synchronized void e() {
        synchronized (this.b) {
            this.b.clear();
        }
    }

    public void a() {
        e();
        a(new com.ihoc.mgpa.b.p());
        a(new com.ihoc.mgpa.b.f());
        a(new com.ihoc.mgpa.b.k());
        if (com.ihoc.mgpa.i.f.la()) {
            a(new com.ihoc.mgpa.b.n());
        }
        if (com.ihoc.mgpa.i.f.ma()) {
            a(new com.ihoc.mgpa.b.o());
        }
        if (com.ihoc.mgpa.g.o.b().b.L) {
            a(new com.ihoc.mgpa.b.i());
        }
        if (com.ihoc.mgpa.i.f.W()) {
            a(new com.ihoc.mgpa.b.j());
        }
        if (com.ihoc.mgpa.i.f.ia()) {
            a(new com.ihoc.mgpa.b.l());
        }
        if (com.ihoc.mgpa.g.o.b().c.r > 0) {
            a(new com.ihoc.mgpa.b.m());
        }
        if (com.ihoc.mgpa.g.o.b().b.N) {
            a(new com.ihoc.mgpa.b.g());
        }
        if (com.ihoc.mgpa.g.o.b().b.O || com.ihoc.mgpa.i.f.I()) {
            this.c = new com.ihoc.mgpa.b.c();
            a(this.c);
        }
        if (com.ihoc.mgpa.g.o.b().b.f) {
            a(new com.ihoc.mgpa.b.d());
        }
        if (com.ihoc.mgpa.n.m.c()) {
            d();
        }
    }

    public void a(int i, int i2) {
        a aVar = this.d;
        if (aVar != null) {
            this.d.sendMessageDelayed(Message.obtain(aVar, 5, i, i2), 2000L);
        }
    }

    public void a(int i, String str) {
        a aVar = this.d;
        if (aVar != null) {
            Message.obtain(aVar, 7, 0, i, str).sendToTarget();
        }
    }

    public void a(int i, float[] fArr) {
        a aVar = this.d;
        if (aVar != null) {
            Message.obtain(aVar, 2, 0, i, fArr).sendToTarget();
        }
    }

    public void a(RunnableC0236b runnableC0236b) {
        a aVar = this.d;
        if (aVar != null) {
            Message.obtain(aVar, runnableC0236b).sendToTarget();
        }
    }

    public void a(String str) {
        a aVar = this.d;
        if (aVar != null) {
            Message.obtain(aVar, 4, str).sendToTarget();
        }
    }

    public void a(String str, long j) {
        a aVar = this.d;
        if (aVar != null) {
            this.d.sendMessageDelayed(Message.obtain(aVar, 6, str), j);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void a(String str, String str2) {
        char c;
        com.ihoc.mgpa.b.c cVar;
        com.ihoc.mgpa.b.c cVar2;
        switch (str.hashCode()) {
            case -1926713083:
                if (str.equals("OpenID")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1520863277:
                if (str.equals("DeviceBind")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1411182751:
                if (str.equals("apmKey")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1389266710:
                if (str.equals("StartShowNotification")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 113025891:
                if (str.equals("EndShowNotification")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 608620555:
                if (str.equals("Predownload")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 673264683:
                if (str.equals("PreDownload")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 768444149:
                if (str.equals("MultiGameData")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 1967651713:
                if (str.equals("ApmKey")) {
                    c = 1;
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
                com.ihoc.mgpa.i.f.d(String.valueOf(str2));
                a(String.valueOf(str2));
                return;
            case 2:
                com.ihoc.mgpa.n.o.b("TGPAOID", str2);
                com.ihoc.mgpa.i.f.q(String.valueOf(str2));
                com.ihoc.mgpa.k.c.a().b();
                return;
            case 3:
            case 4:
            case 5:
                HashMap<String, String> hashMap = new HashMap<>();
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.getString(next));
                    }
                    a(str, hashMap);
                    return;
                } catch (Exception e) {
                    com.ihoc.mgpa.n.m.a("Parse game data to json exception, ple check!", e);
                    return;
                }
            case 6:
                HashMap<Object, String> hashMap2 = new HashMap<>();
                try {
                    JSONObject jSONObject2 = new JSONObject(str2);
                    Iterator<String> keys2 = jSONObject2.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        hashMap2.put(next2, jSONObject2.getString(next2));
                    }
                    a(hashMap2);
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 7:
                if (!com.ihoc.mgpa.g.o.b().b.O || (cVar = this.c) == null) {
                    return;
                }
                cVar.b();
                return;
            case '\b':
                if (!com.ihoc.mgpa.g.o.b().b.O || (cVar2 = this.c) == null) {
                    return;
                }
                cVar2.a();
                return;
            default:
                try {
                    b(Integer.parseInt(str), str2);
                    return;
                } catch (Exception unused) {
                    com.ihoc.mgpa.n.m.b("Game data key " + str + " is not found, ple check!", new Object[0]);
                    return;
                }
        }
    }

    public void a(String str, HashMap<String, String> hashMap) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1520863277) {
            if (str.equals("DeviceBind")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 608620555) {
            if (hashCode == 673264683 && str.equals("PreDownload")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("Predownload")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            com.ihoc.mgpa.c.r.a(hashMap);
            return;
        }
        if (c == 1 || c == 2) {
            if (!hashMap.containsKey("BusinessID")) {
                hashMap.put("BusinessID", com.ihoc.mgpa.i.f.a());
            }
            if (!hashMap.containsKey("ErrStage")) {
                hashMap.put("ErrStage", "99");
            }
            if (!hashMap.containsKey("TotalFilecount")) {
                hashMap.put("TotalFilecount", "1");
            }
            if (!hashMap.containsKey("ExtractFilecount")) {
                hashMap.put("ExtractFilecount", "1");
            }
            String str2 = hashMap.get("Patchfile");
            hashMap.put("UsedCloudChannel", com.ihoc.mgpa.c.m.c().d(str2));
            hashMap.put("ChannelName", String.valueOf(com.ihoc.mgpa.c.m.c().c(str2)));
            hashMap.put(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, String.valueOf(com.ihoc.mgpa.i.f.f()));
            hashMap.put(DeviceInfoName.APP_VERSION_STRING, String.valueOf(com.ihoc.mgpa.i.f.i()));
            com.ihoc.mgpa.i.m.h(hashMap);
        }
    }

    public void a(HashMap<Object, String> hashMap) {
        a aVar = this.d;
        if (aVar != null) {
            Message.obtain(aVar, 3, 0, 0, hashMap).sendToTarget();
        }
    }

    public void b(int i, String str) {
        a aVar = this.d;
        if (aVar != null) {
            Message.obtain(aVar, 1, 0, i, str).sendToTarget();
        }
    }

    public void c() {
        if (this.e.isAlive()) {
            com.ihoc.mgpa.n.m.a("VmpHandler: vmp handler thread is already alive, do not need create again!", new Object[0]);
        } else {
            this.e.start();
            this.d = new a(this.e.getLooper());
        }
    }
}
