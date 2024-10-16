package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzard;

@zzard
@SafeParcelable.Class(creator = "InterstitialAdParameterParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class zzh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 4)
    private final String f1163a;

    @SafeParcelable.Field(id = 2)
    public final boolean zzbre;

    @SafeParcelable.Field(id = 3)
    public final boolean zzbrf;

    @SafeParcelable.Field(id = 5)
    public final boolean zzbrh;

    @SafeParcelable.Field(id = 6)
    public final float zzbri;

    @SafeParcelable.Field(id = 7)
    public final int zzbrj;

    @SafeParcelable.Field(id = 8)
    public final boolean zzbrk;

    @SafeParcelable.Field(id = 9)
    public final boolean zzbrl;

    @SafeParcelable.Field(id = 10)
    public final boolean zzbrm;

    public zzh(boolean z, boolean z2, boolean z3, float f, int i, boolean z4, boolean z5, boolean z6) {
        this(false, z2, null, false, 0.0f, -1, z4, z5, z6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzh(@SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) boolean z2, @SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 6) float f, @SafeParcelable.Param(id = 7) int i, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) boolean z5, @SafeParcelable.Param(id = 10) boolean z6) {
        this.zzbre = z;
        this.zzbrf = z2;
        this.f1163a = str;
        this.zzbrh = z3;
        this.zzbri = f;
        this.zzbrj = i;
        this.zzbrk = z4;
        this.zzbrl = z5;
        this.zzbrm = z6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzbre);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbrf);
        SafeParcelWriter.writeString(parcel, 4, this.f1163a, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzbrh);
        SafeParcelWriter.writeFloat(parcel, 6, this.zzbri);
        SafeParcelWriter.writeInt(parcel, 7, this.zzbrj);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbrk);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbrl);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzbrm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
