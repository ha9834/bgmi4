package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzne;

/* loaded from: classes2.dex */
final class alt implements Parcelable.Creator<zzne.zza> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzne.zza[] newArray(int i) {
        return new zzne.zza[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzne.zza createFromParcel(Parcel parcel) {
        return new zzne.zza(parcel);
    }
}
