package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcjg implements zzbro, zzbsr {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f3281a = new Object();
    private static int b = 0;
    private final zzcjm c;

    public zzcjg(zzcjm zzcjmVar) {
        this.c = zzcjmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbsr
    public final void onAdLoaded() {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && b()) {
            this.c.zzba(true);
            a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i) {
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwt)).booleanValue() && b()) {
            this.c.zzba(false);
            a();
        }
    }

    private static void a() {
        synchronized (f3281a) {
            b++;
        }
    }

    private static boolean b() {
        boolean z;
        synchronized (f3281a) {
            z = b < ((Integer) zzyt.zzpe().zzd(zzacu.zzcwu)).intValue();
        }
        return z;
    }
}
