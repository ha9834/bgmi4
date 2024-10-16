package com.google.android.gms.internal.play_billing;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class zzg {

    /* renamed from: a, reason: collision with root package name */
    private static final ClassLoader f4651a = zzg.class.getClassLoader();

    private zzg() {
    }

    public static <T extends Parcelable> T zza(Parcel parcel, Parcelable.Creator<T> creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return creator.createFromParcel(parcel);
    }

    public static void zzb(Parcel parcel, Parcelable parcelable) {
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}
