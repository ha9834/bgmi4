package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.imsdk.android.base.interfaces.IStat;
import com.tencent.midas.oversea.api.CocosPayHelper;

@KeepForSdk
@SafeParcelable.Class(creator = "FeatureCreator")
/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getName", id = 1)
    private final String f1278a;

    @SafeParcelable.Field(getter = "getOldVersion", id = 2)
    @Deprecated
    private final int b;

    @SafeParcelable.Field(defaultValue = CocosPayHelper.AP_MIDAS_RESP_RESULT_ERROR, getter = IStat.STAT_GET_VERSION, id = 3)
    private final long c;

    @KeepForSdk
    public Feature(String str, long j) {
        this.f1278a = str;
        this.c = j;
        this.b = -1;
    }

    @SafeParcelable.Constructor
    public Feature(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) long j) {
        this.f1278a = str;
        this.b = i;
        this.c = j;
    }

    @KeepForSdk
    public String getName() {
        return this.f1278a;
    }

    @KeepForSdk
    public long getVersion() {
        long j = this.c;
        return j == -1 ? this.b : j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.b);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) obj;
        return ((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion();
    }

    public int hashCode() {
        return Objects.hashCode(getName(), Long.valueOf(getVersion()));
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
    }
}
