package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class zzps extends zzpv {
    public static final Parcelable.Creator<zzps> CREATOR = new anc();

    /* renamed from: a, reason: collision with root package name */
    private final String f3708a;
    public final String description;
    public final String zzbhy;

    public zzps(String str, String str2, String str3) {
        super("COMM");
        this.f3708a = str;
        this.description = str2;
        this.zzbhy = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzps(Parcel parcel) {
        super("COMM");
        this.f3708a = parcel.readString();
        this.description = parcel.readString();
        this.zzbhy = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzps zzpsVar = (zzps) obj;
        return zzsy.zza(this.description, zzpsVar.description) && zzsy.zza(this.f3708a, zzpsVar.f3708a) && zzsy.zza(this.zzbhy, zzpsVar.zzbhy);
    }

    public final int hashCode() {
        String str = this.f3708a;
        int hashCode = ((str != null ? str.hashCode() : 0) + 527) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.zzbhy;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzatl);
        parcel.writeString(this.f3708a);
        parcel.writeString(this.zzbhy);
    }
}
