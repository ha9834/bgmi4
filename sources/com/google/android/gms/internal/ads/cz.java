package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/* loaded from: classes2.dex */
final class cz {

    /* renamed from: a, reason: collision with root package name */
    long f2112a;
    final String b;
    final String c;
    final long d;
    final long e;
    final long f;
    final long g;
    final List<zzl> h;

    private cz(String str, String str2, long j, long j2, long j3, long j4, List<zzl> list) {
        this.b = str;
        this.c = "".equals(str2) ? null : str2;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = j4;
        this.h = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public cz(java.lang.String r14, com.google.android.gms.internal.ads.zzc r15) {
        /*
            r13 = this;
            java.lang.String r2 = r15.zza
            long r3 = r15.zzb
            long r5 = r15.zzc
            long r7 = r15.zzd
            long r9 = r15.zze
            java.util.List<com.google.android.gms.internal.ads.zzl> r0 = r15.zzg
            if (r0 == 0) goto L12
            java.util.List<com.google.android.gms.internal.ads.zzl> r15 = r15.zzg
            r11 = r15
            goto L47
        L12:
            java.util.Map<java.lang.String, java.lang.String> r15 = r15.zzf
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r15.size()
            r0.<init>(r1)
            java.util.Set r15 = r15.entrySet()
            java.util.Iterator r15 = r15.iterator()
        L25:
            boolean r1 = r15.hasNext()
            if (r1 == 0) goto L46
            java.lang.Object r1 = r15.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            com.google.android.gms.internal.ads.zzl r11 = new com.google.android.gms.internal.ads.zzl
            java.lang.Object r12 = r1.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            r11.<init>(r12, r1)
            r0.add(r11)
            goto L25
        L46:
            r11 = r0
        L47:
            r0 = r13
            r1 = r14
            r0.<init>(r1, r2, r3, r5, r7, r9, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.cz.<init>(java.lang.String, com.google.android.gms.internal.ads.zzc):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static cz a(dh dhVar) throws IOException {
        if (zzan.a((InputStream) dhVar) != 538247942) {
            throw new IOException();
        }
        return new cz(zzan.a(dhVar), zzan.a(dhVar), zzan.b((InputStream) dhVar), zzan.b((InputStream) dhVar), zzan.b((InputStream) dhVar), zzan.b((InputStream) dhVar), zzan.b(dhVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(OutputStream outputStream) {
        try {
            zzan.a(outputStream, 538247942);
            zzan.a(outputStream, this.b);
            zzan.a(outputStream, this.c == null ? "" : this.c);
            zzan.a(outputStream, this.d);
            zzan.a(outputStream, this.e);
            zzan.a(outputStream, this.f);
            zzan.a(outputStream, this.g);
            List<zzl> list = this.h;
            if (list != null) {
                zzan.a(outputStream, list.size());
                for (zzl zzlVar : list) {
                    zzan.a(outputStream, zzlVar.getName());
                    zzan.a(outputStream, zzlVar.getValue());
                }
            } else {
                zzan.a(outputStream, 0);
            }
            outputStream.flush();
            return true;
        } catch (IOException e) {
            zzag.d("%s", e.toString());
            return false;
        }
    }
}
