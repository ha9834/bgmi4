package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaar;
import com.google.android.gms.internal.ads.zzacc;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbad;
import javax.annotation.concurrent.GuardedBy;

@zzard
/* loaded from: classes.dex */
public final class VideoController {

    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;

    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;

    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;

    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;

    /* renamed from: a, reason: collision with root package name */
    private final Object f1128a = new Object();

    @GuardedBy("lock")
    private zzaar b;

    @GuardedBy("lock")
    private VideoLifecycleCallbacks c;

    /* loaded from: classes.dex */
    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    public final void zza(zzaar zzaarVar) {
        synchronized (this.f1128a) {
            this.b = zzaarVar;
            if (this.c != null) {
                setVideoLifecycleCallbacks(this.c);
            }
        }
    }

    public final zzaar zzdh() {
        zzaar zzaarVar;
        synchronized (this.f1128a) {
            zzaarVar = this.b;
        }
        return zzaarVar;
    }

    public final void play() {
        synchronized (this.f1128a) {
            if (this.b == null) {
                return;
            }
            try {
                this.b.play();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call play on video controller.", e);
            }
        }
    }

    public final void pause() {
        synchronized (this.f1128a) {
            if (this.b == null) {
                return;
            }
            try {
                this.b.pause();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call pause on video controller.", e);
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.f1128a) {
            if (this.b == null) {
                return;
            }
            try {
                this.b.mute(z);
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call mute on video controller.", e);
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.f1128a) {
            if (this.b == null) {
                return true;
            }
            try {
                return this.b.isMuted();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.f1128a) {
            if (this.b == null) {
                return 0;
            }
            try {
                return this.b.getPlaybackState();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.f1128a) {
            if (this.b == null) {
                return false;
            }
            try {
                return this.b.isCustomControlsEnabled();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.f1128a) {
            if (this.b == null) {
                return false;
            }
            try {
                return this.b.isClickToExpandEnabled();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.f1128a) {
            this.c = videoLifecycleCallbacks;
            if (this.b == null) {
                return;
            }
            try {
                this.b.zza(new zzacc(videoLifecycleCallbacks));
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
            }
        }
    }

    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.f1128a) {
            videoLifecycleCallbacks = this.c;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.f1128a) {
            z = this.b != null;
        }
        return z;
    }

    public final float getAspectRatio() {
        synchronized (this.f1128a) {
            if (this.b == null) {
                return 0.0f;
            }
            try {
                return this.b.getAspectRatio();
            } catch (RemoteException e) {
                zzbad.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }
}
