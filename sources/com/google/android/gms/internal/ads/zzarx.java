package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "NonagonRequestParcelCreator")
/* loaded from: classes.dex */
public final class zzarx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzarx> CREATOR = new zzary();

    @SafeParcelable.Field(id = 3)
    public final ApplicationInfo applicationInfo;

    @SafeParcelable.Field(id = 4)
    public final String packageName;

    @SafeParcelable.Field(id = 2)
    public final zzbai zzdld;

    @Nullable
    @SafeParcelable.Field(id = 6)
    public final PackageInfo zzdlm;

    @SafeParcelable.Field(id = 5)
    public final List<String> zzdly;

    @SafeParcelable.Field(id = 7)
    public final String zzdmi;

    @SafeParcelable.Field(id = 1)
    public final Bundle zzdot;

    @SafeParcelable.Field(id = 8)
    public final boolean zzdou;

    @SafeParcelable.Field(id = 9)
    public final String zzdov;

    @SafeParcelable.Constructor
    public zzarx(@SafeParcelable.Param(id = 1) Bundle bundle, @SafeParcelable.Param(id = 2) zzbai zzbaiVar, @SafeParcelable.Param(id = 3) ApplicationInfo applicationInfo, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) List<String> list, @SafeParcelable.Param(id = 6) @Nullable PackageInfo packageInfo, @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str3) {
        this.zzdot = bundle;
        this.zzdld = zzbaiVar;
        this.packageName = str;
        this.applicationInfo = applicationInfo;
        this.zzdly = list;
        this.zzdlm = packageInfo;
        this.zzdmi = str2;
        this.zzdou = z;
        this.zzdov = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zzdot, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdld, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.applicationInfo, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.packageName, false);
        SafeParcelWriter.writeStringList(parcel, 5, this.zzdly, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzdlm, i, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdmi, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdou);
        SafeParcelWriter.writeString(parcel, 9, this.zzdov, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
