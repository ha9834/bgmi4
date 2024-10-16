package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
final class anb implements Parcelable.Creator<zzpq> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpq[] newArray(int i) {
        return new zzpq[i];
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzpq createFromParcel(Parcel parcel) {
        return new zzpq(parcel);
    }
}
