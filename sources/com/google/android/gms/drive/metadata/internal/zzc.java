package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;

@SafeParcelable.Class(creator = "CustomPropertyCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    final CustomPropertyKey f1555a;

    @SafeParcelable.Field(id = 3)
    final String b;

    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 2) CustomPropertyKey customPropertyKey, @SafeParcelable.Param(id = 3) String str) {
        Preconditions.checkNotNull(customPropertyKey, "key");
        this.f1555a = customPropertyKey;
        this.b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == getClass()) {
            zzc zzcVar = (zzc) obj;
            if (Objects.equal(this.f1555a, zzcVar.f1555a) && Objects.equal(this.b, zzcVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f1555a, this.b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f1555a, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.b, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
