package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fe implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final URL f4853a;
    private final byte[] b;
    private final fc c;
    private final String d;
    private final Map<String, String> e;
    private final /* synthetic */ zzhl f;

    public fe(zzhl zzhlVar, String str, URL url, byte[] bArr, Map<String, String> map, fc fcVar) {
        this.f = zzhlVar;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(url);
        Preconditions.checkNotNull(fcVar);
        this.f4853a = url;
        this.b = null;
        this.c = fcVar;
        this.d = str;
        this.e = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzhl r0 = r7.f
            r0.zzn()
            r0 = 0
            r1 = 0
            com.google.android.gms.measurement.internal.zzhl r2 = r7.f     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L77
            java.net.URL r3 = r7.f4853a     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L77
            java.net.HttpURLConnection r2 = r2.a(r3)     // Catch: java.lang.Throwable -> L6a java.io.IOException -> L77
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.e     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            if (r3 == 0) goto L39
            java.util.Map<java.lang.String, java.lang.String> r3 = r7.e     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.util.Set r3 = r3.entrySet()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
        L1d:
            boolean r4 = r3.hasNext()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            if (r4 == 0) goto L39
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.lang.Object r5 = r4.getKey()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.lang.Object r4 = r4.getValue()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            r2.addRequestProperty(r5, r4)     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            goto L1d
        L39:
            int r1 = r2.getResponseCode()     // Catch: java.lang.Throwable -> L64 java.io.IOException -> L67
            java.util.Map r3 = r2.getHeaderFields()     // Catch: java.lang.Throwable -> L5c java.io.IOException -> L60
            com.google.android.gms.measurement.internal.zzhl r4 = r7.f     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L56
            byte[] r4 = com.google.android.gms.measurement.internal.zzhl.a(r4, r2)     // Catch: java.lang.Throwable -> L50 java.io.IOException -> L56
            if (r2 == 0) goto L4c
            r2.disconnect()
        L4c:
            r7.b(r1, r0, r4, r3)
            return
        L50:
            r4 = move-exception
            r6 = r4
            r4 = r1
            r1 = r3
            r3 = r6
            goto L6e
        L56:
            r4 = move-exception
            r6 = r4
            r4 = r1
            r1 = r3
            r3 = r6
            goto L7b
        L5c:
            r3 = move-exception
            r4 = r1
            r1 = r0
            goto L6e
        L60:
            r3 = move-exception
            r4 = r1
            r1 = r0
            goto L7b
        L64:
            r3 = move-exception
            r1 = r0
            goto L6d
        L67:
            r3 = move-exception
            r1 = r0
            goto L7a
        L6a:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L6d:
            r4 = 0
        L6e:
            if (r2 == 0) goto L73
            r2.disconnect()
        L73:
            r7.b(r4, r0, r0, r1)
            throw r3
        L77:
            r3 = move-exception
            r1 = r0
            r2 = r1
        L7a:
            r4 = 0
        L7b:
            if (r2 == 0) goto L80
            r2.disconnect()
        L80:
            r7.b(r4, r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.fe.run():void");
    }

    private final void b(final int i, final Exception exc, final byte[] bArr, final Map<String, List<String>> map) {
        this.f.zzaa().zza(new Runnable(this, i, exc, bArr, map) { // from class: com.google.android.gms.measurement.internal.fd

            /* renamed from: a, reason: collision with root package name */
            private final fe f4852a;
            private final int b;
            private final Exception c;
            private final byte[] d;
            private final Map e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f4852a = this;
                this.b = i;
                this.c = exc;
                this.d = bArr;
                this.e = map;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f4852a.a(this.b, this.c, this.d, this.e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, Exception exc, byte[] bArr, Map map) {
        this.c.a(this.d, i, exc, bArr, map);
    }
}
