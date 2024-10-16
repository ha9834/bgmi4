package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.internal.zzbgm;
import com.google.android.gms.internal.zzcuu;
import com.google.android.gms.internal.zzcuz;
import com.google.android.gms.nearby.messages.internal.zzad;
import java.util.ArrayList;

@Hide
/* loaded from: classes2.dex */
public final class zzc implements Parcelable.Creator<MessageFilter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter createFromParcel(Parcel parcel) {
        int zzd = zzbgm.zzd(parcel);
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzd) {
            int readInt = parcel.readInt();
            int i3 = 65535 & readInt;
            if (i3 != 1000) {
                switch (i3) {
                    case 1:
                        arrayList = zzbgm.zzc(parcel, readInt, zzad.CREATOR);
                        break;
                    case 2:
                        arrayList2 = zzbgm.zzc(parcel, readInt, zzcuz.CREATOR);
                        break;
                    case 3:
                        z = zzbgm.zzc(parcel, readInt);
                        break;
                    case 4:
                        arrayList3 = zzbgm.zzc(parcel, readInt, zzcuu.CREATOR);
                        break;
                    case 5:
                        i2 = zzbgm.zzg(parcel, readInt);
                        break;
                    default:
                        zzbgm.zzb(parcel, readInt);
                        break;
                }
            } else {
                i = zzbgm.zzg(parcel, readInt);
            }
        }
        zzbgm.zzaf(parcel, zzd);
        return new MessageFilter(i, arrayList, arrayList2, z, arrayList3, i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ MessageFilter[] newArray(int i) {
        return new MessageFilter[i];
    }
}
