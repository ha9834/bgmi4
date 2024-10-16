package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;

/* loaded from: classes2.dex */
public class zzc {

    /* renamed from: a, reason: collision with root package name */
    private static final ClassLoader f3788a = zzc.class.getClassLoader();

    private zzc() {
    }

    public static void zza(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean zza(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
