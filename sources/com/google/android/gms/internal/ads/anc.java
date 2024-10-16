package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
final class anc implements Parcelable.Creator<zzps> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzps[] newArray(int i) {
        return new zzps[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzps createFromParcel(Parcel parcel) {
        return new zzps(parcel);
    }
}
