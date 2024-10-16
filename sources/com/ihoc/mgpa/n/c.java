package com.ihoc.mgpa.n;

import android.os.AsyncTask;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private a f5666a;

    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void a(String str);
    }

    /* loaded from: classes2.dex */
    private class b extends AsyncTask<String, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        private String f5667a;
        private String b;
        private HashMap<String, String> c;
        private String d;
        private HashMap<String, String> e;
        private String f;
        private String g;

        b(String str, String str2, HashMap<String, String> hashMap, String str3, String str4) {
            this.f5667a = str;
            this.b = str2;
            this.e = hashMap;
            this.f = str3;
            this.g = str4;
        }

        b(String str, String str2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
            this.f5667a = str;
            this.b = str2;
            this.c = hashMap;
            this.e = hashMap2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004a A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:3:0x0002, B:13:0x0020, B:16:0x0047, B:17:0x004a, B:18:0x007b, B:20:0x0080, B:30:0x004d, B:32:0x0053, B:33:0x005c, B:34:0x0067, B:35:0x0072, B:38:0x002a, B:42:0x0034, B:46:0x003e), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:30:0x004d A[Catch: Exception -> 0x0096, TRY_LEAVE, TryCatch #0 {Exception -> 0x0096, blocks: (B:3:0x0002, B:13:0x0020, B:16:0x0047, B:17:0x004a, B:18:0x007b, B:20:0x0080, B:30:0x004d, B:32:0x0053, B:33:0x005c, B:34:0x0067, B:35:0x0072, B:38:0x002a, B:42:0x0034, B:46:0x003e), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x005c A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:3:0x0002, B:13:0x0020, B:16:0x0047, B:17:0x004a, B:18:0x007b, B:20:0x0080, B:30:0x004d, B:32:0x0053, B:33:0x005c, B:34:0x0067, B:35:0x0072, B:38:0x002a, B:42:0x0034, B:46:0x003e), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0067 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:3:0x0002, B:13:0x0020, B:16:0x0047, B:17:0x004a, B:18:0x007b, B:20:0x0080, B:30:0x004d, B:32:0x0053, B:33:0x005c, B:34:0x0067, B:35:0x0072, B:38:0x002a, B:42:0x0034, B:46:0x003e), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0072 A[Catch: Exception -> 0x0096, TryCatch #0 {Exception -> 0x0096, blocks: (B:3:0x0002, B:13:0x0020, B:16:0x0047, B:17:0x004a, B:18:0x007b, B:20:0x0080, B:30:0x004d, B:32:0x0053, B:33:0x005c, B:34:0x0067, B:35:0x0072, B:38:0x002a, B:42:0x0034, B:46:0x003e), top: B:2:0x0002 }] */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void doInBackground(java.lang.String... r7) {
            /*
                r6 = this;
                r7 = 0
                r0 = 0
                java.lang.String r1 = r6.b     // Catch: java.lang.Exception -> L96
                r2 = -1
                int r3 = r1.hashCode()     // Catch: java.lang.Exception -> L96
                r4 = 70454(0x11336, float:9.8727E-41)
                if (r3 == r4) goto L3c
                r4 = 2461856(0x2590a0, float:3.449795E-39)
                if (r3 == r4) goto L32
                r4 = 242582301(0xe75831d, float:3.026171E-30)
                if (r3 == r4) goto L28
                r4 = 1540179300(0x5bcd4564, float:1.15557332E17)
                if (r3 == r4) goto L1e
                goto L46
            L1e:
                java.lang.String r3 = "POSTFORM"
                boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L96
                if (r1 == 0) goto L46
                r1 = 2
                goto L47
            L28:
                java.lang.String r3 = "UPLOADFile"
                boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L96
                if (r1 == 0) goto L46
                r1 = 3
                goto L47
            L32:
                java.lang.String r3 = "POST"
                boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L96
                if (r1 == 0) goto L46
                r1 = 1
                goto L47
            L3c:
                java.lang.String r3 = "GET"
                boolean r1 = r1.equals(r3)     // Catch: java.lang.Exception -> L96
                if (r1 == 0) goto L46
                r1 = 0
                goto L47
            L46:
                r1 = -1
            L47:
                switch(r1) {
                    case 0: goto L72;
                    case 1: goto L67;
                    case 2: goto L5c;
                    case 3: goto L4d;
                    default: goto L4a;
                }     // Catch: java.lang.Exception -> L96
            L4a:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L96
                goto L7b
            L4d:
                java.lang.String r1 = r6.f5667a     // Catch: java.lang.Exception -> L96
                java.util.HashMap<java.lang.String, java.lang.String> r2 = r6.e     // Catch: java.lang.Exception -> L96
                java.lang.String r3 = "text/plain"
                java.lang.String r4 = r6.f     // Catch: java.lang.Exception -> L96
                java.lang.String r5 = r6.g     // Catch: java.lang.Exception -> L96
                java.lang.String r1 = com.ihoc.mgpa.n.l.a(r1, r2, r3, r4, r5)     // Catch: java.lang.Exception -> L96
                goto La2
            L5c:
                java.lang.String r1 = r6.f5667a     // Catch: java.lang.Exception -> L96
                java.util.HashMap<java.lang.String, java.lang.String> r2 = r6.e     // Catch: java.lang.Exception -> L96
                java.util.HashMap<java.lang.String, java.lang.String> r3 = r6.c     // Catch: java.lang.Exception -> L96
                java.lang.String r1 = com.ihoc.mgpa.n.l.a(r1, r2, r3)     // Catch: java.lang.Exception -> L96
                goto La2
            L67:
                java.lang.String r1 = r6.f5667a     // Catch: java.lang.Exception -> L96
                java.lang.String r2 = r6.d     // Catch: java.lang.Exception -> L96
                java.util.HashMap<java.lang.String, java.lang.String> r3 = r6.c     // Catch: java.lang.Exception -> L96
                java.lang.String r1 = com.ihoc.mgpa.n.l.a(r1, r2, r3)     // Catch: java.lang.Exception -> L96
                goto La2
            L72:
                java.lang.String r1 = r6.f5667a     // Catch: java.lang.Exception -> L96
                java.util.HashMap<java.lang.String, java.lang.String> r2 = r6.c     // Catch: java.lang.Exception -> L96
                java.lang.String r1 = com.ihoc.mgpa.n.l.a(r1, r2)     // Catch: java.lang.Exception -> L96
                goto La2
            L7b:
                r1.<init>()     // Catch: java.lang.Exception -> L96
                java.lang.String r2 = "can not find  http request type: "
                r1.append(r2)     // Catch: java.lang.Exception -> L96
                java.lang.String r2 = r6.b     // Catch: java.lang.Exception -> L96
                java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L96
                r1.append(r2)     // Catch: java.lang.Exception -> L96
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L96
                java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch: java.lang.Exception -> L96
                com.ihoc.mgpa.n.m.b(r1, r2)     // Catch: java.lang.Exception -> L96
                goto La1
            L96:
                r1 = move-exception
                r1.printStackTrace()
                java.lang.Object[] r1 = new java.lang.Object[r0]
                java.lang.String r2 = "http request exception. ple check it."
                com.ihoc.mgpa.n.m.b(r2, r1)
            La1:
                r1 = r7
            La2:
                com.ihoc.mgpa.n.c r2 = com.ihoc.mgpa.n.c.this
                com.ihoc.mgpa.n.c$a r2 = com.ihoc.mgpa.n.c.a(r2)
                if (r2 == 0) goto Lc0
                if (r1 == 0) goto Lb6
                com.ihoc.mgpa.n.c r0 = com.ihoc.mgpa.n.c.this
                com.ihoc.mgpa.n.c$a r0 = com.ihoc.mgpa.n.c.a(r0)
                r0.a(r1)
                goto Lc7
            Lb6:
                com.ihoc.mgpa.n.c r0 = com.ihoc.mgpa.n.c.this
                com.ihoc.mgpa.n.c$a r0 = com.ihoc.mgpa.n.c.a(r0)
                r0.a()
                goto Lc7
            Lc0:
                java.lang.Object[] r0 = new java.lang.Object[r0]
                java.lang.String r1 = "You should set callback for asynchttp."
                com.ihoc.mgpa.n.m.b(r1, r0)
            Lc7:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.n.c.b.doInBackground(java.lang.String[]):java.lang.Void");
        }
    }

    public c(a aVar) {
        this.f5666a = aVar;
    }

    public void a(String str, HashMap<String, String> hashMap) {
        new b(str, "POSTFORM", null, hashMap).execute(new String[0]);
    }

    public void a(String str, HashMap<String, String> hashMap, String str2, String str3) {
        new b(str, "UPLOADFile", hashMap, str2, str3).execute(new String[0]);
    }
}
