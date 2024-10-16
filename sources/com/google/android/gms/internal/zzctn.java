package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzctn extends zzbgl {
    public static final Parcelable.Creator<zzctn> CREATOR = new zzcto();

    /* renamed from: a, reason: collision with root package name */
    private String f4692a;

    private zzctn() {
    }

    @Hide
    public zzctn(String str) {
        this.f4692a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzctn) {
            return zzbg.equal(this.f4692a, ((zzctn) obj).f4692a);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f4692a});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.f4692a, false);
        zzbgo.zzai(parcel, zze);
    }

    public final String zzbdi() {
        return this.f4692a;
    }
}
