package com.tdatamaster.a;

import android.content.Context;
import com.tdatamaster.a.b;
import com.tencent.tdmbeacon.event.open.BeaconReport;
import com.tencent.tdmbeacon.qimei.IAsyncQimeiListener;
import com.tencent.tdmbeacon.qimei.Qimei;
import java.util.Map;

/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, Object> f6148a;

    public a(Map<String, Object> map) {
        this.f6148a = map;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00bc, code lost:
    
        r6.onResult(1, "App id should not empty");
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cb, code lost:
    
        r6.onResult(1, null);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void a(android.content.Context r5, com.tdatamaster.a.b.a r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.lang.String r0 = "init beacon"
            com.tdatamaster.a.b.a(r0)     // Catch: java.lang.Throwable -> Ld5
            r0 = 1
            if (r5 == 0) goto Lc8
            java.util.Map<java.lang.String, java.lang.Object> r1 = r4.f6148a     // Catch: java.lang.Throwable -> Ld5
            if (r1 != 0) goto Lf
            goto Lc8
        Lf:
            com.tencent.tdmbeacon.event.open.BeaconConfig$Builder r1 = com.tencent.tdmbeacon.event.open.BeaconConfig.builder()     // Catch: java.lang.Throwable -> Ld5
            java.util.Map<java.lang.String, java.lang.Object> r2 = r4.f6148a     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "TEST_MODE"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> Ld5
            boolean r2 = r2 instanceof java.lang.Boolean     // Catch: java.lang.Throwable -> Ld5
            if (r2 == 0) goto L38
            java.util.Map<java.lang.String, java.lang.Object> r2 = r4.f6148a     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "TEST_MODE"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> Ld5
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> Ld5
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Ld5
            boolean r2 = r3.equals(r2)     // Catch: java.lang.Throwable -> Ld5
            if (r2 == 0) goto L38
            com.tencent.tdmbeacon.event.open.BeaconReport r2 = com.tencent.tdmbeacon.event.open.BeaconReport.getInstance()     // Catch: java.lang.Throwable -> Ld5
            r2.setLogAble(r0)     // Catch: java.lang.Throwable -> Ld5
        L38:
            java.util.Map<java.lang.String, java.lang.Object> r2 = r4.f6148a     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "APP_ID"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> Ld5
            boolean r3 = r2 instanceof java.lang.String     // Catch: java.lang.Throwable -> Ld5
            if (r3 == 0) goto Lba
            java.lang.String r3 = ""
            boolean r3 = r3.equals(r2)     // Catch: java.lang.Throwable -> Ld5
            if (r3 == 0) goto L4d
            goto Lba
        L4d:
            java.util.Map<java.lang.String, java.lang.Object> r6 = r4.f6148a     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r0 = "APP_VERSION"
            java.lang.Object r6 = r6.get(r0)     // Catch: java.lang.Throwable -> Ld5
            boolean r6 = r6 instanceof java.lang.String     // Catch: java.lang.Throwable -> Ld5
            if (r6 == 0) goto L86
            com.tencent.tdmbeacon.event.open.BeaconReport r6 = com.tencent.tdmbeacon.event.open.BeaconReport.getInstance()     // Catch: java.lang.Throwable -> Ld5
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.f6148a     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "APP_VERSION"
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Ld5
            r6.setAppVersion(r0)     // Catch: java.lang.Throwable -> Ld5
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            r6.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r0 = "AppVersion:"
            r6.append(r0)     // Catch: java.lang.Throwable -> Ld5
            java.util.Map<java.lang.String, java.lang.Object> r0 = r4.f6148a     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r3 = "APP_VERSION"
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> Ld5
            r6.append(r0)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> Ld5
            com.tdatamaster.a.b.a(r6)     // Catch: java.lang.Throwable -> Ld5
        L86:
            com.tencent.tdmbeacon.event.open.BeaconReport r6 = com.tencent.tdmbeacon.event.open.BeaconReport.getInstance()     // Catch: java.lang.Throwable -> Ld5
            r0 = r2
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> Ld5
            com.tencent.tdmbeacon.event.open.BeaconConfig r1 = r1.build()     // Catch: java.lang.Throwable -> Ld5
            r6.start(r5, r0, r1)     // Catch: java.lang.Throwable -> Ld5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ld5
            r5.<init>()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = "beacon id "
            r5.append(r6)     // Catch: java.lang.Throwable -> Ld5
            r5.append(r2)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = " sdk version : "
            r5.append(r6)     // Catch: java.lang.Throwable -> Ld5
            com.tencent.tdmbeacon.event.open.BeaconReport r6 = com.tencent.tdmbeacon.event.open.BeaconReport.getInstance()     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r6 = r6.getSDKVersion()     // Catch: java.lang.Throwable -> Ld5
            r5.append(r6)     // Catch: java.lang.Throwable -> Ld5
            java.lang.String r5 = r5.toString()     // Catch: java.lang.Throwable -> Ld5
            com.tdatamaster.a.b.a(r5)     // Catch: java.lang.Throwable -> Ld5
            monitor-exit(r4)
            return
        Lba:
            if (r6 == 0) goto Lc1
            java.lang.String r5 = "App id should not empty"
            r6.onResult(r0, r5)     // Catch: java.lang.Throwable -> Ld5
        Lc1:
            java.lang.String r5 = "beacon init error, App id should not empty"
            com.tdatamaster.a.b.b(r5)     // Catch: java.lang.Throwable -> Ld5
            monitor-exit(r4)
            return
        Lc8:
            if (r6 == 0) goto Lce
            r5 = 0
            r6.onResult(r0, r5)     // Catch: java.lang.Throwable -> Ld5
        Lce:
            java.lang.String r5 = "beacon init error"
            com.tdatamaster.a.b.b(r5)     // Catch: java.lang.Throwable -> Ld5
            monitor-exit(r4)
            return
        Ld5:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.a.a.a(android.content.Context, com.tdatamaster.a.b$a):void");
    }

    public void b(Context context, final b.a aVar) {
        b.a("start get qimei");
        a(context, aVar);
        Qimei qimei = BeaconReport.getInstance().getQimei();
        if (qimei == null || qimei.getQimeiOld() == null || qimei.getQimeiOld().isEmpty()) {
            BeaconReport.getInstance().getQimei(new IAsyncQimeiListener() { // from class: com.tdatamaster.a.a.1
            });
        } else if (aVar != null) {
            aVar.onResult(0, qimei.getQimeiOld());
        }
    }

    public void c(Context context, final b.a aVar) {
        b.a("start get qimei36");
        a(context, aVar);
        Qimei qimei = BeaconReport.getInstance().getQimei();
        if (qimei == null || qimei.getQimeiNew() == null || qimei.getQimeiNew().isEmpty()) {
            BeaconReport.getInstance().getQimei(new IAsyncQimeiListener() { // from class: com.tdatamaster.a.a.2
            });
        } else if (aVar != null) {
            aVar.onResult(0, qimei.getQimeiNew());
        }
    }
}
