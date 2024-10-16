package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class zzpw extends zzpv {
    public static final Parcelable.Creator<zzpw> CREATOR = new and();

    /* renamed from: a, reason: collision with root package name */
    private final String f3709a;
    private final String b;

    public zzpw(String str, String str2, String str3) {
        super(str);
        this.f3709a = null;
        this.b = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpw(Parcel parcel) {
        super(parcel.readString());
        this.f3709a = parcel.readString();
        this.b = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzpw zzpwVar = (zzpw) obj;
        return this.zzatl.equals(zzpwVar.zzatl) && zzsy.zza(this.f3709a, zzpwVar.f3709a) && zzsy.zza(this.b, zzpwVar.b);
    }

    public final int hashCode() {
        int hashCode = (this.zzatl.hashCode() + 527) * 31;
        String str = this.f3709a;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzatl);
        parcel.writeString(this.f3709a);
        parcel.writeString(this.b);
    }
}
