package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
final class akz implements Parcelable.Creator<zzlh> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzlh[] newArray(int i) {
        return new zzlh[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzlh createFromParcel(Parcel parcel) {
        return new zzlh(parcel);
    }
}
