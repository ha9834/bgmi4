package com.subao.common.e;

import com.subao.common.e.ad;

/* loaded from: classes2.dex */
public abstract class ag extends ad {
    protected abstract void a(String str, String str2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ag(ad.a aVar) {
        super(aVar);
    }

    public static void a(ag agVar) {
        ae k = agVar.k();
        if (k != null) {
            if (agVar.d(k)) {
                agVar.b(k);
            } else {
                k = null;
            }
        }
        agVar.e(k);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.ad
    public void a(ae aeVar) {
        super.a(aeVar);
        if (aeVar == null || !aeVar.d) {
            return;
        }
        b(aeVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        a("config is null");
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(com.subao.common.e.ae r10) {
        /*
            r9 = this;
            r0 = 1
            r1 = 0
            boolean r2 = i()     // Catch: java.lang.Throwable -> L72
            if (r10 == 0) goto L5f
            int r3 = r10.b()     // Catch: java.lang.Throwable -> L72
            r4 = 2
            if (r3 > r4) goto L10
            goto L5f
        L10:
            android.util.JsonReader r3 = new android.util.JsonReader     // Catch: java.lang.Throwable -> L72
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L72
            java.io.ByteArrayInputStream r6 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L72
            byte[] r7 = r10.c     // Catch: java.lang.Throwable -> L72
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L72
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L72
            r3.<init>(r5)     // Catch: java.lang.Throwable -> L72
            r3.beginObject()     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
        L24:
            boolean r5 = r3.hasNext()     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            if (r5 == 0) goto L47
            java.lang.String r5 = r3.nextName()     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            java.lang.String r6 = com.subao.common.n.g.b(r3)     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            if (r2 == 0) goto L43
            java.lang.String r7 = "process \"%s\":\"%s\""
            java.lang.Object[] r8 = new java.lang.Object[r4]     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            r8[r1] = r5     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            r8[r0] = r6     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            java.lang.String r7 = java.lang.String.format(r7, r8)     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            r9.a(r7)     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
        L43:
            r9.a(r5, r6)     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            goto L24
        L47:
            r3.endObject()     // Catch: java.lang.AssertionError -> L4b java.lang.RuntimeException -> L4d java.io.IOException -> L4f java.lang.Throwable -> L72
            goto L53
        L4b:
            r2 = move-exception
            goto L50
        L4d:
            r2 = move-exception
            goto L50
        L4f:
            r2 = move-exception
        L50:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L72
        L53:
            if (r10 == 0) goto L5a
            boolean r10 = r10.d
            if (r10 == 0) goto L5a
            goto L5b
        L5a:
            r0 = 0
        L5b:
            r9.a(r0)
            return
        L5f:
            if (r2 == 0) goto L66
            java.lang.String r2 = "config is null"
            r9.a(r2)     // Catch: java.lang.Throwable -> L72
        L66:
            if (r10 == 0) goto L6d
            boolean r10 = r10.d
            if (r10 == 0) goto L6d
            goto L6e
        L6d:
            r0 = 0
        L6e:
            r9.a(r0)
            return
        L72:
            r2 = move-exception
            if (r10 == 0) goto L7a
            boolean r10 = r10.d
            if (r10 == 0) goto L7a
            goto L7b
        L7a:
            r0 = 0
        L7b:
            r9.a(r0)
            throw r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.subao.common.e.ag.b(com.subao.common.e.ae):void");
    }
}
