package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

@zzard
@SafeParcelable.Class(creator = "AdRequestParcelCreator")
/* loaded from: classes.dex */
public final class zzxz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxz> CREATOR = new zzyb();

    @SafeParcelable.Field(id = 3)
    public final Bundle extras;

    @SafeParcelable.Field(id = 1)
    public final int versionCode;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbqn;

    @SafeParcelable.Field(id = 2)
    @Deprecated
    public final long zzcgn;

    @SafeParcelable.Field(id = 4)
    @Deprecated
    public final int zzcgo;

    @SafeParcelable.Field(id = 5)
    public final List<String> zzcgp;

    @SafeParcelable.Field(id = 6)
    public final boolean zzcgq;

    @SafeParcelable.Field(id = 7)
    public final int zzcgr;

    @SafeParcelable.Field(id = 9)
    public final String zzcgs;

    @SafeParcelable.Field(id = 10)
    public final zzaca zzcgt;

    @SafeParcelable.Field(id = 12)
    public final String zzcgu;

    @SafeParcelable.Field(id = 13)
    public final Bundle zzcgv;

    @SafeParcelable.Field(id = 14)
    public final Bundle zzcgw;

    @SafeParcelable.Field(id = 15)
    public final List<String> zzcgx;

    @SafeParcelable.Field(id = 16)
    public final String zzcgy;

    @SafeParcelable.Field(id = 17)
    public final String zzcgz;

    @SafeParcelable.Field(id = 18)
    @Deprecated
    public final boolean zzcha;

    @Nullable
    @SafeParcelable.Field(id = 19)
    public final zzxt zzchb;

    @SafeParcelable.Field(id = 20)
    public final int zzchc;

    @Nullable
    @SafeParcelable.Field(id = 21)
    public final String zzchd;

    @SafeParcelable.Field(id = 11)
    public final Location zzmw;

    @SafeParcelable.Constructor
    public zzxz(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) long j, @SafeParcelable.Param(id = 3) Bundle bundle, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) boolean z, @SafeParcelable.Param(id = 7) int i3, @SafeParcelable.Param(id = 8) boolean z2, @SafeParcelable.Param(id = 9) String str, @SafeParcelable.Param(id = 10) zzaca zzacaVar, @SafeParcelable.Param(id = 11) Location location, @SafeParcelable.Param(id = 12) String str2, @SafeParcelable.Param(id = 13) Bundle bundle2, @SafeParcelable.Param(id = 14) Bundle bundle3, @SafeParcelable.Param(id = 15) List<String> list2, @SafeParcelable.Param(id = 16) String str3, @SafeParcelable.Param(id = 17) String str4, @SafeParcelable.Param(id = 18) boolean z3, @SafeParcelable.Param(id = 19) zzxt zzxtVar, @SafeParcelable.Param(id = 20) int i4, @SafeParcelable.Param(id = 21) @Nullable String str5) {
        this.versionCode = i;
        this.zzcgn = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzcgo = i2;
        this.zzcgp = list;
        this.zzcgq = z;
        this.zzcgr = i3;
        this.zzbqn = z2;
        this.zzcgs = str;
        this.zzcgt = zzacaVar;
        this.zzmw = location;
        this.zzcgu = str2;
        this.zzcgv = bundle2 == null ? new Bundle() : bundle2;
        this.zzcgw = bundle3;
        this.zzcgx = list2;
        this.zzcgy = str3;
        this.zzcgz = str4;
        this.zzcha = z3;
        this.zzchb = zzxtVar;
        this.zzchc = i4;
        this.zzchd = str5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeLong(parcel, 2, this.zzcgn);
        SafeParcelWriter.writeBundle(parcel, 3, this.extras, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcgo);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzcgp, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzcgq);
        SafeParcelWriter.writeInt(parcel, 7, this.zzcgr);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbqn);
        SafeParcelWriter.writeString(parcel, 9, this.zzcgs, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzcgt, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzmw, i, false);
        SafeParcelWriter.writeString(parcel, 12, this.zzcgu, false);
        SafeParcelWriter.writeBundle(parcel, 13, this.zzcgv, false);
        SafeParcelWriter.writeBundle(parcel, 14, this.zzcgw, false);
        SafeParcelWriter.writeStringList(parcel, 15, this.zzcgx, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzcgy, false);
        SafeParcelWriter.writeString(parcel, 17, this.zzcgz, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzcha);
        SafeParcelWriter.writeParcelable(parcel, 19, this.zzchb, i, false);
        SafeParcelWriter.writeInt(parcel, 20, this.zzchc);
        SafeParcelWriter.writeString(parcel, 21, this.zzchd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzxz)) {
            return false;
        }
        zzxz zzxzVar = (zzxz) obj;
        return this.versionCode == zzxzVar.versionCode && this.zzcgn == zzxzVar.zzcgn && Objects.equal(this.extras, zzxzVar.extras) && this.zzcgo == zzxzVar.zzcgo && Objects.equal(this.zzcgp, zzxzVar.zzcgp) && this.zzcgq == zzxzVar.zzcgq && this.zzcgr == zzxzVar.zzcgr && this.zzbqn == zzxzVar.zzbqn && Objects.equal(this.zzcgs, zzxzVar.zzcgs) && Objects.equal(this.zzcgt, zzxzVar.zzcgt) && Objects.equal(this.zzmw, zzxzVar.zzmw) && Objects.equal(this.zzcgu, zzxzVar.zzcgu) && Objects.equal(this.zzcgv, zzxzVar.zzcgv) && Objects.equal(this.zzcgw, zzxzVar.zzcgw) && Objects.equal(this.zzcgx, zzxzVar.zzcgx) && Objects.equal(this.zzcgy, zzxzVar.zzcgy) && Objects.equal(this.zzcgz, zzxzVar.zzcgz) && this.zzcha == zzxzVar.zzcha && this.zzchc == zzxzVar.zzchc && Objects.equal(this.zzchd, zzxzVar.zzchd);
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzcgn), this.extras, Integer.valueOf(this.zzcgo), this.zzcgp, Boolean.valueOf(this.zzcgq), Integer.valueOf(this.zzcgr), Boolean.valueOf(this.zzbqn), this.zzcgs, this.zzcgt, this.zzmw, this.zzcgu, this.zzcgv, this.zzcgw, this.zzcgx, this.zzcgy, this.zzcgz, Boolean.valueOf(this.zzcha), Integer.valueOf(this.zzchc), this.zzchd);
    }
}
