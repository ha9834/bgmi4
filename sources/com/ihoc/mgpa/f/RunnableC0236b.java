package com.ihoc.mgpa.f;

import com.ihoc.mgpa.MgpaCallback;

/* renamed from: com.ihoc.mgpa.f.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC0236b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static MgpaCallback f5526a;
    private com.ihoc.mgpa.a.a b;
    private String c;

    public RunnableC0236b(com.ihoc.mgpa.a.a aVar, String str) {
        this.b = aVar;
        this.c = str;
    }

    public static void a(MgpaCallback mgpaCallback) {
        f5526a = mgpaCallback;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x003d. Please report as an issue. */
    @Override // java.lang.Runnable
    public void run() {
        Object[] objArr;
        String str;
        MgpaCallback mgpaCallback;
        String str2;
        Object[] objArr2;
        String str3;
        if (f5526a == null) {
            objArr2 = new Object[]{this.b.a()};
            str3 = "no game' callback is registered, ple check! key: %s .";
        } else {
            if (this.c != null) {
                com.ihoc.mgpa.n.m.a("start to handle callback data. key: %s , value: %s .", this.b.a(), this.c);
                switch (C0235a.f5525a[this.b.ordinal()]) {
                    case 1:
                    case 4:
                    default:
                        return;
                    case 2:
                        if (!com.ihoc.mgpa.i.f.P()) {
                            objArr = new Object[0];
                            str = "fps strategy func is not open, ple check!";
                            com.ihoc.mgpa.n.m.a(str, objArr);
                            return;
                        }
                        f5526a.notifySystemInfo(this.c);
                        return;
                    case 3:
                        if (!com.ihoc.mgpa.i.f.J()) {
                            objArr = new Object[0];
                            str = "low power callback func is not open, ple check!";
                            com.ihoc.mgpa.n.m.a(str, objArr);
                            return;
                        }
                        f5526a.notifySystemInfo(this.c);
                        return;
                    case 5:
                        if (!com.ihoc.mgpa.i.f.J()) {
                            objArr = new Object[0];
                            str = "yolo data forward func is not open, ple check!";
                            com.ihoc.mgpa.n.m.a(str, objArr);
                            return;
                        }
                        f5526a.notifySystemInfo(this.c);
                        return;
                    case 6:
                        if (!com.ihoc.mgpa.g.o.b().b.f) {
                            objArr = new Object[0];
                            str = "cpu lock check func is not open, ple check!";
                            com.ihoc.mgpa.n.m.a(str, objArr);
                            return;
                        }
                        f5526a.notifySystemInfo(this.c);
                        return;
                    case 7:
                        if (!com.ihoc.mgpa.i.f.J() || (mgpaCallback = f5526a) == null || (str2 = this.c) == null) {
                            com.ihoc.mgpa.n.m.a("vacant download callback func is not open, or no game' callback is registered, ple check!", new Object[0]);
                        } else {
                            mgpaCallback.notifySystemInfo(str2);
                        }
                        f5526a.notifySystemInfo(this.c);
                        return;
                    case 8:
                        f5526a.notifySystemInfo(this.c);
                        return;
                }
            }
            objArr2 = new Object[0];
            str3 = "no callback data, ple check!";
        }
        com.ihoc.mgpa.n.m.a(str3, objArr2);
    }
}
