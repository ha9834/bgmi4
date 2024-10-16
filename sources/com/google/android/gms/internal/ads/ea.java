package com.google.android.gms.internal.ads;

import java.io.OutputStream;

/* loaded from: classes2.dex */
final class ea implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ OutputStream f2139a;
    private final /* synthetic */ byte[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(zzaru zzaruVar, OutputStream outputStream, byte[] bArr) {
        this.f2139a = outputStream;
        this.b = bArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
            java.io.DataOutputStream r1 = new java.io.DataOutputStream     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
            java.io.OutputStream r2 = r5.f2139a     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L19 java.io.IOException -> L1e
            byte[] r0 = r5.b     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            int r0 = r0.length     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            r1.writeInt(r0)     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            byte[] r0 = r5.b     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            r1.write(r0)     // Catch: java.io.IOException -> L17 java.lang.Throwable -> L3c
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
            return
        L17:
            r0 = move-exception
            goto L22
        L19:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
            goto L3d
        L1e:
            r1 = move-exception
            r4 = r1
            r1 = r0
            r0 = r4
        L22:
            java.lang.String r2 = "Error transporting the ad response"
            com.google.android.gms.internal.ads.zzawz.zzc(r2, r0)     // Catch: java.lang.Throwable -> L3c
            com.google.android.gms.internal.ads.zzawm r2 = com.google.android.gms.ads.internal.zzk.zzlk()     // Catch: java.lang.Throwable -> L3c
            java.lang.String r3 = "LargeParcelTeleporter.pipeData.1"
            r2.zza(r0, r3)     // Catch: java.lang.Throwable -> L3c
            if (r1 != 0) goto L38
            java.io.OutputStream r0 = r5.f2139a
            com.google.android.gms.common.util.IOUtils.closeQuietly(r0)
            return
        L38:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
            return
        L3c:
            r0 = move-exception
        L3d:
            if (r1 != 0) goto L45
            java.io.OutputStream r1 = r5.f2139a
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
            goto L48
        L45:
            com.google.android.gms.common.util.IOUtils.closeQuietly(r1)
        L48:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.ea.run():void");
    }
}
