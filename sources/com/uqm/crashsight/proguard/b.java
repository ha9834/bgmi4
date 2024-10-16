package com.uqm.crashsight.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.helpshift.util.ErrorReportProvider;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final long f6608a = System.currentTimeMillis();
    private static b b;
    private Context c;
    private SharedPreferences f;
    private Map<Integer, Map<String, a>> e = new HashMap();
    private String d = com.uqm.crashsight.crashreport.common.info.a.b().d;

    private b(Context context) {
        this.c = context;
        this.f = context.getSharedPreferences("crashrecord", 0);
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (b == null) {
                b = new b(context);
            }
            bVar = b;
        }
        return bVar;
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            bVar = b;
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean b(int i) {
        try {
            List<a> c = c(i);
            if (c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (a aVar : c) {
                if (aVar.b != null && aVar.b.equalsIgnoreCase(this.d) && aVar.d > 0) {
                    arrayList.add(aVar);
                }
                if (aVar.c + ErrorReportProvider.BATCH_TIME < currentTimeMillis) {
                    arrayList2.add(aVar);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((a) arrayList.get(arrayList.size() - 1)).c + ErrorReportProvider.BATCH_TIME >= currentTimeMillis) {
                    return true;
                }
                c.clear();
                a(i, (int) c);
                return false;
            }
            c.removeAll(arrayList2);
            a(i, (int) c);
            return false;
        } catch (Exception unused) {
            m.e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    public final void a(int i, final int i2) {
        final int i3 = 1004;
        k.a().a(new Runnable() { // from class: com.uqm.crashsight.proguard.b.1
            @Override // java.lang.Runnable
            public final void run() {
                a aVar;
                try {
                    if (TextUtils.isEmpty(b.this.d)) {
                        return;
                    }
                    List<a> c = b.this.c(i3);
                    if (c == null) {
                        c = new ArrayList();
                    }
                    if (b.this.e.get(Integer.valueOf(i3)) == null) {
                        b.this.e.put(Integer.valueOf(i3), new HashMap());
                    }
                    if (((Map) b.this.e.get(Integer.valueOf(i3))).get(b.this.d) != null) {
                        aVar = (a) ((Map) b.this.e.get(Integer.valueOf(i3))).get(b.this.d);
                        aVar.d = i2;
                    } else {
                        aVar = new a();
                        aVar.f6607a = i3;
                        aVar.g = b.f6608a;
                        aVar.b = b.this.d;
                        aVar.f = com.uqm.crashsight.crashreport.common.info.a.b().k;
                        aVar.e = com.uqm.crashsight.crashreport.common.info.a.b().f;
                        aVar.c = System.currentTimeMillis();
                        aVar.d = i2;
                        ((Map) b.this.e.get(Integer.valueOf(i3))).put(b.this.d, aVar);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (a aVar2 : c) {
                        if (aVar2.g == aVar.g && aVar2.b != null && aVar2.b.equalsIgnoreCase(aVar.b)) {
                            z = true;
                            aVar2.d = aVar.d;
                        }
                        if ((aVar2.e != null && !aVar2.e.equalsIgnoreCase(aVar.e)) || ((aVar2.f != null && !aVar2.f.equalsIgnoreCase(aVar.f)) || aVar2.d <= 0)) {
                            arrayList.add(aVar2);
                        }
                    }
                    c.removeAll(arrayList);
                    if (!z) {
                        c.add(aVar);
                    }
                    b.this.a(i3, (int) c);
                } catch (Exception unused) {
                    m.e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0052, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0046, code lost:
    
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0044, code lost:
    
        if (r6 == null) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized <T extends java.util.List<?>> T c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            android.content.Context r3 = r5.c     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.<init>()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.append(r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            if (r6 != 0) goto L24
            monitor-exit(r5)
            return r0
        L24:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b java.lang.Throwable -> L55
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b java.lang.Throwable -> L55
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            monitor-exit(r5)
            return r2
        L39:
            r2 = move-exception
            r6 = r0
            goto L56
        L3c:
            r6 = r0
        L3d:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.uqm.crashsight.proguard.m.a(r2, r3)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L65
        L46:
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            goto L65
        L4a:
            r6 = r0
        L4b:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.uqm.crashsight.proguard.m.a(r2, r3)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L65
            goto L46
        L55:
            r2 = move-exception
        L56:
            if (r6 == 0) goto L5b
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L5b:
            throw r2     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L5c:
            r6 = move-exception
            goto L67
        L5e:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5c
            com.uqm.crashsight.proguard.m.e(r6, r1)     // Catch: java.lang.Throwable -> L5c
        L65:
            monitor-exit(r5)
            return r0
        L67:
            monitor-exit(r5)
            throw r6
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uqm.crashsight.proguard.b.c(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized <T extends List<?>> void a(int i, T t) {
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2;
        if (t == null) {
            return;
        }
        try {
            File dir = this.c.getDir("crashrecord", 0);
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            objectOutputStream = null;
            try {
                try {
                    objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(dir, sb.toString())));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (IOException e) {
                e = e;
            }
        } catch (Exception unused) {
            m.e("writeCrashRecord error", new Object[0]);
        }
        try {
            objectOutputStream2.writeObject(t);
            objectOutputStream2.close();
        } catch (IOException e2) {
            e = e2;
            objectOutputStream = objectOutputStream2;
            e.printStackTrace();
            m.a("open record file error", new Object[0]);
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
        } catch (Throwable th2) {
            th = th2;
            objectOutputStream = objectOutputStream2;
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            throw th;
        }
    }

    public final synchronized boolean a(final int i) {
        boolean z;
        z = true;
        try {
            z = this.f.getBoolean(i + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.d, true);
            k.a().a(new Runnable() { // from class: com.uqm.crashsight.proguard.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean b2 = b.this.b(i);
                    b.this.f.edit().putBoolean(i + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + b.this.d, !b2).commit();
                }
            });
        } catch (Exception unused) {
            m.e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
