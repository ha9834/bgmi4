package com.ihoc.mgpa.n;

import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private Map<Integer, String> f5678a = new HashMap(32);
    private a b;

    /* loaded from: classes2.dex */
    private static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        private int f5679a;
        private int b;
        WeakReference<r> c;
        private boolean d;

        a(r rVar, int i, int i2) {
            super("ThreadObserve");
            this.d = false;
            this.c = new WeakReference<>(rVar);
            this.f5679a = i;
            this.b = i2;
        }

        void a() {
            this.d = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            r rVar;
            while (this.d && (rVar = this.c.get()) != null) {
                Map<Integer, String> a2 = rVar.a(this.f5679a);
                if (a2 != null && a2.size() > 0) {
                    rVar.a(a2);
                }
                try {
                    Thread.sleep(this.b);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    public r(int i, int i2) {
        if (i2 >= 2000) {
            this.b = new a(this, i, i2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r0 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a(int r4, int r5) {
        /*
            r3 = this;
            java.util.Locale r0 = java.util.Locale.US
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2 = 0
            r1[r2] = r5
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 1
            r1[r5] = r4
            java.lang.String r4 = "/proc/%d/task/%d/status"
            java.lang.String r4 = java.lang.String.format(r0, r4, r1)
            r5 = 0
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L44
            java.lang.String r1 = "r"
            r0.<init>(r4, r1)     // Catch: java.lang.Throwable -> L3d java.io.IOException -> L44
            java.lang.String r4 = r0.readLine()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L45
            java.lang.String r1 = "Name:"
            boolean r1 = r4.startsWith(r1)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L45
            if (r1 == 0) goto L47
            r1 = 5
            java.lang.String r4 = r4.substring(r1)     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L45
            java.lang.String r4 = r4.trim()     // Catch: java.lang.Throwable -> L3a java.io.IOException -> L45
            r0.close()     // Catch: java.io.IOException -> L39
        L39:
            return r4
        L3a:
            r4 = move-exception
            r5 = r0
            goto L3e
        L3d:
            r4 = move-exception
        L3e:
            if (r5 == 0) goto L43
            r5.close()     // Catch: java.io.IOException -> L43
        L43:
            throw r4
        L44:
            r0 = r5
        L45:
            if (r0 == 0) goto L4a
        L47:
            r0.close()     // Catch: java.io.IOException -> L4a
        L4a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.n.r.a(int, int):java.lang.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Integer, String> a(int i) {
        File[] listFiles;
        String a2;
        File file = new File(String.format(Locale.US, "/proc/%s/task/", Integer.valueOf(i)));
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return null;
        }
        HashMap hashMap = new HashMap(8);
        for (File file2 : listFiles) {
            int parseInt = Integer.parseInt(file2.getName());
            if (!this.f5678a.containsKey(Integer.valueOf(parseInt)) && (a2 = a(parseInt, i)) != null) {
                hashMap.put(Integer.valueOf(parseInt), a2);
                this.f5678a.put(Integer.valueOf(parseInt), a2);
            }
        }
        return hashMap;
    }

    public void a() {
        a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b.start();
        }
    }

    public abstract void a(Map<Integer, String> map);
}
