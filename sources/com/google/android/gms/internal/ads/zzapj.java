package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "RtbVersionInfoParcelCreator")
/* loaded from: classes.dex */
public final class zzapj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzapj> CREATOR = new zzapk();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final int f2773a;

    @SafeParcelable.Field(id = 2)
    private final int b;

    @SafeParcelable.Field(id = 3)
    private final int c;

    public static zzapj zza(VersionInfo versionInfo) {
        return new zzapj(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzapj(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) int i2, @SafeParcelable.Param(id = 3) int i3) {
        this.f2773a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f2773a);
        SafeParcelWriter.writeInt(parcel, 2, this.b);
        SafeParcelWriter.writeInt(parcel, 3, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String toString() {
        int i = this.f2773a;
        int i2 = this.b;
        int i3 = this.c;
        StringBuilder sb = new StringBuilder(35);
        sb.append(i);
        sb.append(".");
        sb.append(i2);
        sb.append(".");
        sb.append(i3);
        return sb.toString();
    }
}
