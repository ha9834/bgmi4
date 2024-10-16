package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzpq extends zzpv {
    public static final Parcelable.Creator<zzpq> CREATOR = new anb();

    /* renamed from: a, reason: collision with root package name */
    private final String f3707a;
    private final String b;
    private final int c;
    private final byte[] d;

    public zzpq(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.f3707a = str;
        this.b = null;
        this.c = 3;
        this.d = bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpq(Parcel parcel) {
        super("APIC");
        this.f3707a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzpq zzpqVar = (zzpq) obj;
        return this.c == zzpqVar.c && zzsy.zza(this.f3707a, zzpqVar.f3707a) && zzsy.zza(this.b, zzpqVar.b) && Arrays.equals(this.d, zzpqVar.d);
    }

    public final int hashCode() {
        int i = (this.c + 527) * 31;
        String str = this.f3707a;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Arrays.hashCode(this.d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f3707a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeByteArray(this.d);
    }
}
