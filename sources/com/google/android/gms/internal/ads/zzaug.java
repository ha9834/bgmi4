package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaug {

    /* renamed from: a, reason: collision with root package name */
    private final zzatt f2803a;
    private final Context b;

    public zzaug(Context context, String str) {
        this.b = context.getApplicationContext();
        this.f2803a = zzyt.zzpb().zzc(context, str, new zzamo());
    }

    public final void zza(zzaaz zzaazVar, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.f2803a.zza(zzyc.zza(this.b, zzaazVar), new zzaul(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.f2803a.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.f2803a.zza(new zzaum(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.f2803a.zza(new zzabz(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            return this.f2803a.getAdMetadata();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final boolean isLoaded() {
        try {
            return this.f2803a.isLoaded();
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.f2803a.zza(new zzaui(rewardedAdCallback));
            this.f2803a.zzj(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.f2803a.zza(new zzaui(rewardedAdCallback));
            this.f2803a.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
        }
    }

    @Nullable
    public final RewardItem getRewardItem() {
        try {
            zzatq zzqh = this.f2803a.zzqh();
            if (zzqh == null) {
                return null;
            }
            return new zzauh(zzqh);
        } catch (RemoteException e) {
            zzbad.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
