package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes2.dex */
public final class zzabe {

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("lock")
    private static zzabe f2687a;
    private static final Object b = new Object();
    private zzaab c;
    private RewardedVideoAd d;
    private zztw e;

    public static zzabe zzqf() {
        zzabe zzabeVar;
        synchronized (b) {
            if (f2687a == null) {
                f2687a = new zzabe();
            }
            zzabeVar = f2687a;
        }
        return zzabeVar;
    }

    /* JADX WARN: Type inference failed for: r3v8, types: [com.google.android.gms.internal.ads.zztw, com.google.android.gms.internal.ads.c] */
    public final void zza(final Context context, String str, zzabi zzabiVar, zztx zztxVar) {
        synchronized (b) {
            if (this.c != null) {
                return;
            }
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null.");
            }
            try {
                zzami.initialize(context, str);
                boolean z = false;
                this.c = new aqj(zzyt.zzpb(), context).a(context, false);
                this.c.zza(new zzamo());
                this.c.zza();
                this.c.zzb(str, ObjectWrapper.wrap(new Runnable(this, context) { // from class: com.google.android.gms.internal.ads.b

                    /* renamed from: a, reason: collision with root package name */
                    private final zzabe f2064a;
                    private final Context b;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f2064a = this;
                        this.b = context;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2064a.getRewardedVideoAdInstance(this.b);
                    }
                }));
                zzacu.initialize(context);
                if (!((Boolean) zzyt.zzpe().zzd(zzacu.zzcuw)).booleanValue()) {
                    if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcvc)).booleanValue()) {
                        z = true;
                    }
                }
                if (!z) {
                    zzbad.zzen("Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                    this.e = new Object(this) { // from class: com.google.android.gms.internal.ads.c

                        /* renamed from: a, reason: collision with root package name */
                        private final zzabe f2090a;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.f2090a = this;
                        }
                    };
                }
            } catch (RemoteException e) {
                zzbad.zzd("MobileAdsSettingManager initialization failed", e);
            }
        }
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (b) {
            if (this.d != null) {
                return this.d;
            }
            this.d = new zzatj(context, new aqm(zzyt.zzpb(), context, new zzamo()).a(context, false));
            return this.d;
        }
    }

    public final void setAppVolume(float f) {
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        Preconditions.checkState(this.c != null, "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.c.setAppVolume(f);
        } catch (RemoteException e) {
            zzbad.zzc("Unable to set app volume.", e);
        }
    }

    public final float zzpq() {
        zzaab zzaabVar = this.c;
        if (zzaabVar == null) {
            return 1.0f;
        }
        try {
            return zzaabVar.zzpq();
        } catch (RemoteException e) {
            zzbad.zzc("Unable to get app volume.", e);
            return 1.0f;
        }
    }

    public final void setAppMuted(boolean z) {
        Preconditions.checkState(this.c != null, "MobileAds.initialize() must be called prior to setting app muted state.");
        try {
            this.c.setAppMuted(z);
        } catch (RemoteException e) {
            zzbad.zzc("Unable to set app mute state.", e);
        }
    }

    public final boolean zzpr() {
        zzaab zzaabVar = this.c;
        if (zzaabVar == null) {
            return false;
        }
        try {
            return zzaabVar.zzpr();
        } catch (RemoteException e) {
            zzbad.zzc("Unable to get app mute state.", e);
            return false;
        }
    }

    public final void openDebugMenu(Context context, String str) {
        Preconditions.checkState(this.c != null, "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.c.zzc(ObjectWrapper.wrap(context), str);
        } catch (RemoteException e) {
            zzbad.zzc("Unable to open debug menu.", e);
        }
    }

    public final String getVersionString() {
        Preconditions.checkState(this.c != null, "MobileAds.initialize() must be called prior to getting version string.");
        try {
            return this.c.getVersionString();
        } catch (RemoteException e) {
            zzbad.zzc("Unable to get version string.", e);
            return "";
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        try {
            this.c.zzbv(cls.getCanonicalName());
        } catch (RemoteException e) {
            zzbad.zzc("Unable to register RtbAdapter", e);
        }
    }

    private zzabe() {
    }
}
