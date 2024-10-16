package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzbhq extends zzaas {

    /* renamed from: a, reason: collision with root package name */
    private final zzbdf f2874a;
    private final boolean c;
    private final boolean d;

    @GuardedBy("lock")
    private int e;

    @GuardedBy("lock")
    private zzaau f;

    @GuardedBy("lock")
    private boolean g;

    @GuardedBy("lock")
    private float i;

    @GuardedBy("lock")
    private float j;

    @GuardedBy("lock")
    private float k;

    @GuardedBy("lock")
    private boolean l;

    @GuardedBy("lock")
    private boolean m;
    private final Object b = new Object();

    @GuardedBy("lock")
    private boolean h = true;

    public zzbhq(zzbdf zzbdfVar, float f, boolean z, boolean z2) {
        this.f2874a = zzbdfVar;
        this.i = f;
        this.c = z;
        this.d = z2;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void play() {
        a("play", null);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void pause() {
        a("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void mute(boolean z) {
        a(z ? "mute" : "unmute", null);
    }

    public final void zzb(zzacd zzacdVar) {
        boolean z = zzacdVar.zzaax;
        boolean z2 = zzacdVar.zzaay;
        boolean z3 = zzacdVar.zzaaz;
        synchronized (this.b) {
            this.l = z2;
            this.m = z3;
        }
        a("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    private final void a(String str, Map<String, String> map) {
        final HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzbbm.zzeae.execute(new Runnable(this, hashMap) { // from class: com.google.android.gms.internal.ads.lo

            /* renamed from: a, reason: collision with root package name */
            private final zzbhq f2322a;
            private final Map b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2322a = this;
                this.b = hashMap;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2322a.a(this.b);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isMuted() {
        boolean z;
        synchronized (this.b) {
            z = this.h;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final int getPlaybackState() {
        int i;
        synchronized (this.b) {
            i = this.e;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float getAspectRatio() {
        float f;
        synchronized (this.b) {
            f = this.k;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float zzpv() {
        float f;
        synchronized (this.b) {
            f = this.i;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final float zzpw() {
        float f;
        synchronized (this.b) {
            f = this.j;
        }
        return f;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final void zza(zzaau zzaauVar) {
        synchronized (this.b) {
            this.f = zzaauVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final zzaau zzpx() throws RemoteException {
        zzaau zzaauVar;
        synchronized (this.b) {
            zzaauVar = this.f;
        }
        return zzaauVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.b) {
            z = this.c && this.l;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaar
    public final boolean isClickToExpandEnabled() {
        boolean z;
        boolean isCustomControlsEnabled = isCustomControlsEnabled();
        synchronized (this.b) {
            if (!isCustomControlsEnabled) {
                try {
                    z = this.m && this.d;
                } finally {
                }
            }
        }
        return z;
    }

    public final void zze(float f) {
        synchronized (this.b) {
            this.j = f;
        }
    }

    public final void zzabs() {
        boolean z;
        int i;
        synchronized (this.b) {
            z = this.h;
            i = this.e;
            this.e = 3;
        }
        b(i, 3, z, z);
    }

    public final void zza(float f, float f2, int i, boolean z, float f3) {
        boolean z2;
        int i2;
        synchronized (this.b) {
            this.i = f2;
            this.j = f;
            z2 = this.h;
            this.h = z;
            i2 = this.e;
            this.e = i;
            float f4 = this.k;
            this.k = f3;
            if (Math.abs(this.k - f4) > 1.0E-4f) {
                this.f2874a.getView().invalidate();
            }
        }
        b(i2, i, z2, z);
    }

    private final void b(final int i, final int i2, final boolean z, final boolean z2) {
        zzbbm.zzeae.execute(new Runnable(this, i, i2, z, z2) { // from class: com.google.android.gms.internal.ads.lp

            /* renamed from: a, reason: collision with root package name */
            private final zzbhq f2323a;
            private final int b;
            private final int c;
            private final boolean d;
            private final boolean e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2323a = this;
                this.b = i;
                this.c = i2;
                this.d = z;
                this.e = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2323a.a(this.b, this.c, this.d, this.e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(int i, int i2, boolean z, boolean z2) {
        synchronized (this.b) {
            boolean z3 = i != i2;
            boolean z4 = !this.g && i2 == 1;
            boolean z5 = z3 && i2 == 1;
            boolean z6 = z3 && i2 == 2;
            boolean z7 = z3 && i2 == 3;
            boolean z8 = z != z2;
            this.g = this.g || z4;
            if (z4) {
                try {
                    if (this.f != null) {
                        this.f.onVideoStart();
                    }
                } catch (RemoteException e) {
                    zzbad.zze("#007 Could not call remote method.", e);
                }
            }
            if (z5 && this.f != null) {
                this.f.onVideoPlay();
            }
            if (z6 && this.f != null) {
                this.f.onVideoPause();
            }
            if (z7) {
                if (this.f != null) {
                    this.f.onVideoEnd();
                }
                this.f2874a.zzyk();
            }
            if (z8 && this.f != null) {
                this.f.onVideoMute(z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void a(Map map) {
        this.f2874a.zza("pubVideoCmd", (Map<String, ?>) map);
    }
}
