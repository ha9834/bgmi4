package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import java.util.ArrayList;

@Hide
/* loaded from: classes2.dex */
public final class zzd implements Parcelable.Creator<AppMetadata> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppMetadata createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            if ((65535 & readInt) != 1) {
                zzbgm.zzb(parcel, readInt);
            } else {
                arrayList = zzbgm.zzc(parcel, readInt, AppIdentifier.CREATOR);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new AppMetadata(arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AppMetadata[] newArray(int i) {
        return new AppMetadata[i];
    }
}
