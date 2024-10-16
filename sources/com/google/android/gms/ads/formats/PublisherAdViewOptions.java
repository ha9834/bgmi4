package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzaga;
import com.google.android.gms.internal.ads.zzagb;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzyf;
import com.google.android.gms.internal.ads.zzzs;
import com.google.android.gms.internal.ads.zzzt;

@zzard
@SafeParcelable.Class(creator = "PublisherAdViewOptionsCreator")
/* loaded from: classes.dex */
public final class PublisherAdViewOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getManualImpressionsEnabled", id = 1)
    private final boolean f1140a;

    @SafeParcelable.Field(getter = "getAppEventListenerBinder", id = 2, type = "android.os.IBinder")
    private final zzzs b;
    private AppEventListener c;

    @SafeParcelable.Field(getter = "getDelayedBannerAdListenerBinder", id = 3)
    private final IBinder d;

    private PublisherAdViewOptions(Builder builder) {
        this.f1140a = builder.f1141a;
        this.c = builder.b;
        AppEventListener appEventListener = this.c;
        this.b = appEventListener != null ? new zzyf(appEventListener) : null;
        this.d = null;
    }

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private boolean f1141a = false;
        private AppEventListener b;

        public final Builder setManualImpressionsEnabled(boolean z) {
            this.f1141a = z;
            return this;
        }

        public final Builder setAppEventListener(AppEventListener appEventListener) {
            this.b = appEventListener;
            return this;
        }

        public final PublisherAdViewOptions build() {
            return new PublisherAdViewOptions(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PublisherAdViewOptions(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) IBinder iBinder2) {
        this.f1140a = z;
        this.b = iBinder != null ? zzzt.zzd(iBinder) : null;
        this.d = iBinder2;
    }

    public final AppEventListener getAppEventListener() {
        return this.c;
    }

    public final boolean getManualImpressionsEnabled() {
        return this.f1140a;
    }

    public final zzzs zzkt() {
        return this.b;
    }

    public final zzaga zzku() {
        return zzagb.zzu(this.d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getManualImpressionsEnabled());
        zzzs zzzsVar = this.b;
        SafeParcelWriter.writeIBinder(parcel, 2, zzzsVar == null ? null : zzzsVar.asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.d, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
