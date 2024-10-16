package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConnectionInfoCreator")
/* loaded from: classes.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    Bundle f1476a;

    @SafeParcelable.Field(id = 2)
    Feature[] b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) Feature[] featureArr) {
        this.f1476a = bundle;
        this.b = featureArr;
    }

    public zzb() {
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.f1476a, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.b, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
