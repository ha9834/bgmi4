package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
final class and implements Parcelable.Creator<zzpw> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpw[] newArray(int i) {
        return new zzpw[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpw createFromParcel(Parcel parcel) {
        return new zzpw(parcel);
    }
}
