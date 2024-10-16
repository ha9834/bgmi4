package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import com.helpshift.common.domain.network.NetworkConstants;

@zzard
/* loaded from: classes2.dex */
public final class zzbez implements zzll {

    /* renamed from: a, reason: collision with root package name */
    private final zzrz f2864a;
    private long b;
    private long c;
    private long d;
    private long e;
    private int f;
    private boolean g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbez() {
        this(15000, NetworkConstants.UPLOAD_CONNECT_TIMEOUT, 2500L, 5000L);
    }

    private zzbez(int i, int i2, long j, long j2) {
        this.f2864a = new zzrz(true, 65536);
        this.b = 15000000L;
        this.c = 30000000L;
        this.d = 2500000L;
        this.e = 5000000L;
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void zzhd() {
        a(false);
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void zza(zzlo[] zzloVarArr, zzrb zzrbVar, zzro zzroVar) {
        this.f = 0;
        for (int i = 0; i < zzloVarArr.length; i++) {
            if (zzroVar.zzbi(i) != null) {
                this.f += zzsy.zzbt(zzloVarArr[i].getTrackType());
            }
        }
        this.f2864a.zzbl(this.f);
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void onStopped() {
        a(true);
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final void zzee() {
        a(true);
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final zzrt zzhe() {
        return this.f2864a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzll
    public final synchronized boolean zzf(long j, boolean z) {
        long j2;
        j2 = z ? this.e : this.d;
        return j2 <= 0 || j >= j2;
    }

    @Override // com.google.android.gms.internal.ads.zzll
    public final synchronized boolean zzee(long j) {
        boolean z = false;
        char c = j > this.c ? (char) 0 : j < this.b ? (char) 2 : (char) 1;
        boolean z2 = this.f2864a.zzga() >= this.f;
        if (c == 2 || (c == 1 && this.g && !z2)) {
            z = true;
        }
        this.g = z;
        return this.g;
    }

    public final synchronized void zzdg(int i) {
        this.b = i * 1000;
    }

    public final synchronized void zzdh(int i) {
        this.c = i * 1000;
    }

    public final synchronized void zzda(int i) {
        this.d = i * 1000;
    }

    public final synchronized void zzdb(int i) {
        this.e = i * 1000;
    }

    @VisibleForTesting
    private final void a(boolean z) {
        this.f = 0;
        this.g = false;
        if (z) {
            this.f2864a.reset();
        }
    }
}
