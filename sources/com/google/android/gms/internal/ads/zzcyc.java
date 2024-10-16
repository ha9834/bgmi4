package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class zzcyc {
    public static ParcelFileDescriptor zze(final InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        final ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
        zzaxg.zzdvp.execute(new Runnable(inputStream, parcelFileDescriptor2) { // from class: com.google.android.gms.internal.ads.aai

            /* renamed from: a, reason: collision with root package name */
            private final InputStream f1759a;
            private final ParcelFileDescriptor b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f1759a = inputStream;
                this.b = parcelFileDescriptor2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcyc.a(this.f1759a, this.b);
            }
        });
        return parcelFileDescriptor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0027 A[Catch: all -> 0x002b, Throwable -> 0x002d, Merged into TryCatch #5 {all -> 0x002b, blocks: (B:4:0x0001, B:7:0x0009, B:20:0x001e, B:18:0x002a, B:17:0x0027, B:24:0x0023, B:34:0x002f), top: B:3:0x0001, outer: #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x001e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void a(java.io.InputStream r4, android.os.ParcelFileDescriptor r5) {
        /*
            r0 = 0
            android.os.ParcelFileDescriptor$AutoCloseOutputStream r1 = new android.os.ParcelFileDescriptor$AutoCloseOutputStream     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L2d
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L2d
            com.google.android.gms.common.util.IOUtils.copyStream(r4, r1)     // Catch: java.lang.Throwable -> L13 java.lang.Throwable -> L16
            r1.close()     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L2d
            if (r4 == 0) goto L12
            a(r0, r4)     // Catch: java.io.IOException -> L36
            return
        L12:
            return
        L13:
            r5 = move-exception
            r2 = r0
            goto L1c
        L16:
            r5 = move-exception
            throw r5     // Catch: java.lang.Throwable -> L18
        L18:
            r2 = move-exception
            r3 = r2
            r2 = r5
            r5 = r3
        L1c:
            if (r2 == 0) goto L27
            r1.close()     // Catch: java.lang.Throwable -> L22 java.lang.Throwable -> L2b
            goto L2a
        L22:
            r1 = move-exception
            com.google.android.gms.internal.ads.zzdmb.zza(r2, r1)     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L2d
            goto L2a
        L27:
            r1.close()     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L2d
        L2a:
            throw r5     // Catch: java.lang.Throwable -> L2b java.lang.Throwable -> L2d
        L2b:
            r5 = move-exception
            goto L30
        L2d:
            r5 = move-exception
            r0 = r5
            throw r0     // Catch: java.lang.Throwable -> L2b
        L30:
            if (r4 == 0) goto L35
            a(r0, r4)     // Catch: java.io.IOException -> L36
        L35:
            throw r5     // Catch: java.io.IOException -> L36
        L36:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcyc.a(java.io.InputStream, android.os.ParcelFileDescriptor):void");
    }

    private static /* synthetic */ void a(Throwable th, InputStream inputStream) {
        if (th == null) {
            inputStream.close();
            return;
        }
        try {
            inputStream.close();
        } catch (Throwable th2) {
            zzdmb.zza(th, th2);
        }
    }
}
