package com.subao.common.c;

import com.subao.common.e.an;
import com.subao.common.e.r;
import com.subao.common.intf.RequestBuyResult;
import com.subao.common.j.b;

/* loaded from: classes2.dex */
public class d extends g {

    /* renamed from: a, reason: collision with root package name */
    private final String f5941a;
    private final int b;
    private int c;
    private RequestBuyResult d;

    public d(String str, an anVar, String str2, String str3, int i) {
        super(str, anVar, str2);
        this.c = -1;
        this.f5941a = str3;
        this.b = i;
    }

    public int d() {
        return this.c;
    }

    public RequestBuyResult e() {
        return this.d;
    }

    @Override // com.subao.common.c.g
    protected void a(b.c cVar) {
        this.d = null;
        if (cVar == null) {
            this.c = 1006;
            return;
        }
        if (cVar.f6066a != 201) {
            this.c = 1008;
        } else if (this.b == 12) {
            this.d = a(cVar.b);
            this.c = this.d != null ? 0 : 1008;
        } else {
            this.c = 1011;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0073 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.subao.common.intf.RequestBuyResult a(byte[] r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L85
            int r1 = r7.length
            r2 = 2
            if (r1 > r2) goto L9
            goto L85
        L9:
            android.util.JsonReader r1 = new android.util.JsonReader     // Catch: java.lang.Throwable -> L61 java.lang.RuntimeException -> L64 java.io.IOException -> L66
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L61 java.lang.RuntimeException -> L64 java.io.IOException -> L66
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L61 java.lang.RuntimeException -> L64 java.io.IOException -> L66
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L61 java.lang.RuntimeException -> L64 java.io.IOException -> L66
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L61 java.lang.RuntimeException -> L64 java.io.IOException -> L66
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L61 java.lang.RuntimeException -> L64 java.io.IOException -> L66
            r1.beginObject()     // Catch: java.lang.RuntimeException -> L5b java.io.IOException -> L5d java.lang.Throwable -> L80
            r7 = r0
            r2 = r7
            r3 = r2
        L1e:
            boolean r4 = r1.hasNext()     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            if (r4 == 0) goto L53
            java.lang.String r4 = r1.nextName()     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            java.lang.String r5 = "productId"
            boolean r5 = r5.equals(r4)     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            if (r5 == 0) goto L35
            java.lang.String r7 = r1.nextString()     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            goto L1e
        L35:
            java.lang.String r5 = "accessKey"
            boolean r5 = r5.equals(r4)     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            if (r5 == 0) goto L42
            java.lang.String r2 = r1.nextString()     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            goto L1e
        L42:
            java.lang.String r5 = "transNo"
            boolean r4 = r5.equals(r4)     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            if (r4 == 0) goto L4f
            java.lang.String r3 = r1.nextString()     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            goto L1e
        L4f:
            r1.skipValue()     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            goto L1e
        L53:
            r1.endObject()     // Catch: java.lang.RuntimeException -> L57 java.io.IOException -> L59 java.lang.Throwable -> L80
            goto L6e
        L57:
            r4 = move-exception
            goto L6b
        L59:
            r4 = move-exception
            goto L6b
        L5b:
            r4 = move-exception
            goto L5e
        L5d:
            r4 = move-exception
        L5e:
            r7 = r0
            r2 = r7
            goto L6a
        L61:
            r7 = move-exception
            r1 = r0
            goto L81
        L64:
            r4 = move-exception
            goto L67
        L66:
            r4 = move-exception
        L67:
            r7 = r0
            r1 = r7
            r2 = r1
        L6a:
            r3 = r2
        L6b:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L80
        L6e:
            com.subao.common.e.a(r1)
            if (r7 == 0) goto L7f
            if (r2 == 0) goto L7f
            if (r3 == 0) goto L7f
            com.subao.common.intf.RequestBuyResultForViVo r0 = new com.subao.common.intf.RequestBuyResultForViVo
            java.lang.String r1 = r6.f5941a
            r0.<init>(r7, r1, r2, r3)
            return r0
        L7f:
            return r0
        L80:
            r7 = move-exception
        L81:
            com.subao.common.e.a(r1)
            throw r7
        L85:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.subao.common.c.d.a(byte[]):com.subao.common.intf.RequestBuyResult");
    }

    @Override // com.subao.common.c.g
    protected String c() {
        return String.format("/api/v1/%s/orders/%s/payment", f(), this.f5941a);
    }

    @Override // com.subao.common.c.g
    protected b.EnumC0172b a() {
        return b.EnumC0172b.POST;
    }

    @Override // com.subao.common.c.g
    protected byte[] b() {
        return String.format(r.f6001a, "{\"payType\":%d}", Integer.valueOf(this.b)).getBytes();
    }
}
