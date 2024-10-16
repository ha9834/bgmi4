package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class zzrg extends zzrj {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3719a = new int[0];
    private final zzrn b;
    private final AtomicReference<zzrh> c;

    public zzrg() {
        this(null);
    }

    private static int a(int i, int i2) {
        if (i == -1) {
            return i2 == -1 ? 0 : -1;
        }
        if (i2 == -1) {
            return 1;
        }
        return i - i2;
    }

    private static boolean a(int i, boolean z) {
        int i2 = i & 3;
        if (i2 != 3) {
            return z && i2 == 2;
        }
        return true;
    }

    private zzrg(zzrn zzrnVar) {
        this.b = null;
        this.c = new AtomicReference<>(new zzrh());
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0185, code lost:
    
        if (r9.zzatm <= r15) goto L81;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01b7  */
    @Override // com.google.android.gms.internal.ads.zzrj
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final com.google.android.gms.internal.ads.zzrm[] a(com.google.android.gms.internal.ads.zzlp[] r36, com.google.android.gms.internal.ads.zzrb[] r37, int[][][] r38) throws com.google.android.gms.internal.ads.zzku {
        /*
            Method dump skipped, instructions count: 1146
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrg.a(com.google.android.gms.internal.ads.zzlp[], com.google.android.gms.internal.ads.zzrb[], int[][][]):com.google.android.gms.internal.ads.zzrm[]");
    }

    private static boolean a(zzlh zzlhVar, String str) {
        return str != null && TextUtils.equals(str, zzsy.zzbg(zzlhVar.zzauc));
    }
}
