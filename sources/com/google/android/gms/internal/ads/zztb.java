package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zztb implements Parcelable {
    public static final Parcelable.Creator<zztb> CREATOR = new anw();

    /* renamed from: a, reason: collision with root package name */
    private int f3742a;
    public final int zzbbo;
    public final int zzbbp;
    public final int zzbbq;
    public final byte[] zzbnt;

    public zztb(int i, int i2, int i3, byte[] bArr) {
        this.zzbbo = i;
        this.zzbbq = i2;
        this.zzbbp = i3;
        this.zzbnt = bArr;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zztb(Parcel parcel) {
        this.zzbbo = parcel.readInt();
        this.zzbbq = parcel.readInt();
        this.zzbbp = parcel.readInt();
        this.zzbnt = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zztb zztbVar = (zztb) obj;
        return this.zzbbo == zztbVar.zzbbo && this.zzbbq == zztbVar.zzbbq && this.zzbbp == zztbVar.zzbbp && Arrays.equals(this.zzbnt, zztbVar.zzbnt);
    }

    public final String toString() {
        int i = this.zzbbo;
        int i2 = this.zzbbq;
        int i3 = this.zzbbp;
        boolean z = this.zzbnt != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final int hashCode() {
        if (this.f3742a == 0) {
            this.f3742a = ((((((this.zzbbo + 527) * 31) + this.zzbbq) * 31) + this.zzbbp) * 31) + Arrays.hashCode(this.zzbnt);
        }
        return this.f3742a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzbbo);
        parcel.writeInt(this.zzbbq);
        parcel.writeInt(this.zzbbp);
        parcel.writeInt(this.zzbnt != null ? 1 : 0);
        byte[] bArr = this.zzbnt;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
