package com.shieldtunnel.svpn.common.f;

import com.shieldtunnel.svpn.common.f.k;

/* loaded from: classes2.dex */
public abstract class n extends k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public n(k.b bVar) {
        super(bVar);
    }

    public static void a(n nVar, boolean z) {
        l n = nVar.n();
        if (n != null) {
            if (!nVar.c(n)) {
                n = null;
            } else if (z) {
                nVar.e(n);
            }
        }
        nVar.b(n);
    }

    private void a(boolean z) {
    }

    protected abstract void a(String str, String str2);

    @Override // com.shieldtunnel.svpn.common.f.k
    protected String e() {
        return "v4";
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007a, code lost:
    
        b("config is null");
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void e(com.shieldtunnel.svpn.common.f.l r10) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            boolean r2 = com.shieldtunnel.svpn.common.f.k.m()     // Catch: java.lang.Throwable -> L8b
            if (r10 == 0) goto L78
            int r3 = r10.c()     // Catch: java.lang.Throwable -> L8b
            r4 = 2
            if (r3 > r4) goto L10
            goto L78
        L10:
            byte[] r3 = r10.d     // Catch: java.lang.Throwable -> L8b
            byte[] r3 = com.shieldtunnel.svpn.common.f.j.c(r3)     // Catch: java.lang.Throwable -> L8b
            if (r3 != 0) goto L2b
            if (r2 == 0) goto L1f
            java.lang.String r2 = "Incorrect portal data"
            r9.b(r2)     // Catch: java.lang.Throwable -> L8b
        L1f:
            if (r10 == 0) goto L26
            boolean r10 = r10.e
            if (r10 == 0) goto L26
            goto L27
        L26:
            r0 = 0
        L27:
            r9.a(r0)
            return
        L2b:
            android.util.JsonReader r5 = new android.util.JsonReader     // Catch: java.lang.Throwable -> L8b
            java.io.InputStreamReader r6 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L8b
            java.io.ByteArrayInputStream r7 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L8b
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L8b
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L8b
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L8b
            r5.beginObject()     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
        L3d:
            boolean r3 = r5.hasNext()     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            if (r3 == 0) goto L60
            java.lang.String r3 = r5.nextName()     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            java.lang.String r6 = com.shieldtunnel.svpn.common.k.c.a(r5)     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            if (r2 == 0) goto L5c
            java.lang.String r7 = "process \"%s\":\"%s\""
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            r8[r1] = r3     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            r8[r0] = r6     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            r9.b(r7)     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
        L5c:
            r9.a(r3, r6)     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            goto L3d
        L60:
            r5.endObject()     // Catch: java.lang.AssertionError -> L64 java.lang.RuntimeException -> L66 java.io.IOException -> L68 java.lang.Throwable -> L8b
            goto L6c
        L64:
            r2 = move-exception
            goto L69
        L66:
            r2 = move-exception
            goto L69
        L68:
            r2 = move-exception
        L69:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L8b
        L6c:
            if (r10 == 0) goto L73
            boolean r10 = r10.e
            if (r10 == 0) goto L73
            goto L74
        L73:
            r0 = 0
        L74:
            r9.a(r0)
            return
        L78:
            if (r2 == 0) goto L7f
            java.lang.String r2 = "config is null"
            r9.b(r2)     // Catch: java.lang.Throwable -> L8b
        L7f:
            if (r10 == 0) goto L86
            boolean r10 = r10.e
            if (r10 == 0) goto L86
            goto L87
        L86:
            r0 = 0
        L87:
            r9.a(r0)
            return
        L8b:
            r2 = move-exception
            if (r10 == 0) goto L93
            boolean r10 = r10.e
            if (r10 == 0) goto L93
            goto L94
        L93:
            r0 = 0
        L94:
            r9.a(r0)
            throw r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.shieldtunnel.svpn.common.f.n.e(com.shieldtunnel.svpn.common.f.l):void");
    }

    public static void a(n nVar) {
        a(nVar, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.shieldtunnel.svpn.common.f.k
    public void a(k.c cVar) {
        super.a(cVar);
        l lVar = cVar.f5819a;
        if (lVar == null || !lVar.e) {
            return;
        }
        e(lVar);
    }
}
