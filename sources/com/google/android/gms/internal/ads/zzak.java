package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class zzak implements zzm {

    /* renamed from: a, reason: collision with root package name */
    private static final boolean f2744a = zzag.DEBUG;

    @Deprecated
    private final zzas b;
    private final zzaj c;
    private final zzal d;

    @Deprecated
    public zzak(zzas zzasVar) {
        this(zzasVar, new zzal(4096));
    }

    @Deprecated
    private zzak(zzas zzasVar, zzal zzalVar) {
        this.b = zzasVar;
        this.c = new ao(zzasVar);
        this.d = zzalVar;
    }

    public zzak(zzaj zzajVar) {
        this(zzajVar, new zzal(4096));
    }

    private zzak(zzaj zzajVar, zzal zzalVar) {
        this.c = zzajVar;
        this.b = zzajVar;
        this.d = zzalVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0203 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.gms.internal.ads.zzp zzc(com.google.android.gms.internal.ads.zzr<?> r22) throws com.google.android.gms.internal.ads.zzaf {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzak.zzc(com.google.android.gms.internal.ads.zzr):com.google.android.gms.internal.ads.zzp");
    }

    private static void a(String str, zzr<?> zzrVar, zzaf zzafVar) throws zzaf {
        zzac zzj = zzrVar.zzj();
        int zzi = zzrVar.zzi();
        try {
            zzj.zza(zzafVar);
            zzrVar.zzb(String.format("%s-retry [timeout=%s]", str, Integer.valueOf(zzi)));
        } catch (zzaf e) {
            zzrVar.zzb(String.format("%s-timeout-giveup [timeout=%s]", str, Integer.valueOf(zzi)));
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final byte[] a(InputStream inputStream, int i) throws IOException, zzad {
        zzaw zzawVar = new zzaw(this.d, i);
        try {
            if (inputStream == null) {
                throw new zzad();
            }
            byte[] zzc = this.d.zzc(1024);
            while (true) {
                int read = inputStream.read(zzc);
                if (read == -1) {
                    break;
                }
                zzawVar.write(zzc, 0, read);
            }
            byte[] byteArray = zzawVar.toByteArray();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                    zzag.v("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.d.zza(zzc);
            zzawVar.close();
            return byteArray;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                    zzag.v("Error occurred when closing InputStream", new Object[0]);
                }
            }
            this.d.zza(null);
            zzawVar.close();
            throw th;
        }
    }
}
