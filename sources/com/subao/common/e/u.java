package com.subao.common.e;

import android.util.JsonReader;
import com.subao.common.e.v;
import com.subao.common.j.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class u extends v {

    /* renamed from: a, reason: collision with root package name */
    private final a f6005a;
    private final boolean d;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i, List<n> list);
    }

    @Override // com.subao.common.e.v
    protected int a() {
        return 0;
    }

    public u(v.a aVar, v.d dVar, a aVar2, boolean z) {
        super(aVar, dVar, b.EnumC0172b.GET, null);
        this.f6005a = aVar2;
        this.d = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0057 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.subao.common.e.n> a(byte[] r7) {
        /*
            r0 = 0
            android.util.JsonReader r1 = new android.util.JsonReader     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 java.io.IOException -> L78
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 java.io.IOException -> L78
            java.io.ByteArrayInputStream r3 = new java.io.ByteArrayInputStream     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 java.io.IOException -> L78
            r3.<init>(r7)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 java.io.IOException -> L78
            java.lang.String r7 = "UTF-8"
            r2.<init>(r3, r7)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 java.io.IOException -> L78
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L73 java.lang.RuntimeException -> L76 java.io.IOException -> L78
            r1.beginObject()     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            r7 = -1
            r2 = r0
            r3 = -1
        L18:
            boolean r4 = r1.hasNext()     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            if (r4 == 0) goto L67
            java.lang.String r4 = r1.nextName()     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            int r5 = r4.hashCode()     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            r6 = -572353622(0xffffffffdde293aa, float:-2.0408225E18)
            if (r5 == r6) goto L3b
            r6 = 609384932(0x245279e4, float:4.5639737E-17)
            if (r5 == r6) goto L31
            goto L45
        L31:
            java.lang.String r5 = "couponList"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            if (r4 == 0) goto L45
            r4 = 1
            goto L46
        L3b:
            java.lang.String r5 = "resultCode"
            boolean r4 = r4.equals(r5)     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            if (r4 == 0) goto L45
            r4 = 0
            goto L46
        L45:
            r4 = -1
        L46:
            switch(r4) {
                case 0: goto L57;
                case 1: goto L4d;
                default: goto L49;
            }     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
        L49:
            r1.skipValue()     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            goto L18
        L4d:
            java.util.List r2 = a(r1)     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            if (r3 != 0) goto L18
            com.subao.common.e.a(r1)
            return r2
        L57:
            int r3 = r1.nextInt()     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            if (r3 != 0) goto L63
            if (r2 == 0) goto L18
            com.subao.common.e.a(r1)
            return r2
        L63:
            com.subao.common.e.a(r1)
            return r0
        L67:
            r1.endObject()     // Catch: java.lang.RuntimeException -> L6f java.io.IOException -> L71 java.lang.Throwable -> L81
            com.subao.common.e.a(r1)
            r0 = r2
            goto L80
        L6f:
            r7 = move-exception
            goto L7a
        L71:
            r7 = move-exception
            goto L7a
        L73:
            r7 = move-exception
            r1 = r0
            goto L82
        L76:
            r7 = move-exception
            goto L79
        L78:
            r7 = move-exception
        L79:
            r1 = r0
        L7a:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L81
            com.subao.common.e.a(r1)
        L80:
            return r0
        L81:
            r7 = move-exception
        L82:
            com.subao.common.e.a(r1)
            throw r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.subao.common.e.u.a(byte[]):java.util.List");
    }

    private static List<n> a(JsonReader jsonReader) {
        ArrayList arrayList = new ArrayList(32);
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(n.a(jsonReader));
        }
        jsonReader.endArray();
        return arrayList;
    }

    @Override // com.subao.common.e.v
    protected String b() {
        StringBuilder sb = new StringBuilder(512);
        sb.append("/api/v2/");
        sb.append(this.b.f6011a);
        sb.append("/coupons");
        if (this.d) {
            sb.append("?user=");
            sb.append(com.subao.common.e.a(this.c.f6010a));
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.subao.common.e.v
    public void a(v.b bVar) {
        byte[] bArr;
        super.a(bVar);
        int i = 1008;
        List<n> list = null;
        if (bVar == null || bVar.b == null) {
            i = 1006;
        } else if (200 == bVar.b.f6066a && (bArr = bVar.b.b) != null && bArr.length > 2 && (list = a(bArr)) != null) {
            i = 0;
        }
        this.f6005a.a(i, list);
    }
}
