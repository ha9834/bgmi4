package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "AdSizeParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzyd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyd> CREATOR = new zzye();

    @SafeParcelable.Field(id = 3)
    public final int height;

    @SafeParcelable.Field(id = 4)
    public final int heightPixels;

    @SafeParcelable.Field(id = 6)
    public final int width;

    @SafeParcelable.Field(id = 7)
    public final int widthPixels;

    @SafeParcelable.Field(id = 2)
    public final String zzaap;

    @SafeParcelable.Field(id = 9)
    public final boolean zzbsz;

    @SafeParcelable.Field(id = 5)
    public final boolean zzchf;

    @SafeParcelable.Field(id = 8)
    public final zzyd[] zzchg;

    @SafeParcelable.Field(id = 10)
    public final boolean zzchh;

    @SafeParcelable.Field(id = 11)
    public boolean zzchi;

    public static int zzb(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzc(DisplayMetrics displayMetrics) {
        return (int) (a(displayMetrics) * displayMetrics.density);
    }

    private static int a(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static zzyd zzg(Context context) {
        return new zzyd("320x50_mb", 0, 0, false, 0, 0, null, true, false, false);
    }

    public static zzyd zzou() {
        return new zzyd("reward_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzyd() {
        this("interstitial_mb", 0, 0, true, 0, 0, null, false, false, false);
    }

    public zzyd(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zzyd(android.content.Context r13, com.google.android.gms.ads.AdSize[] r14) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyd.<init>(android.content.Context, com.google.android.gms.ads.AdSize[]):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzyd(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i, @SafeParcelable.Param(id = 4) int i2, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) int i3, @SafeParcelable.Param(id = 7) int i4, @SafeParcelable.Param(id = 8) zzyd[] zzydVarArr, @SafeParcelable.Param(id = 9) boolean z2, @SafeParcelable.Param(id = 10) boolean z3, @SafeParcelable.Param(id = 11) boolean z4) {
        this.zzaap = str;
        this.height = i;
        this.heightPixels = i2;
        this.zzchf = z;
        this.width = i3;
        this.widthPixels = i4;
        this.zzchg = zzydVarArr;
        this.zzbsz = z2;
        this.zzchh = z3;
        this.zzchi = z4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzaap, false);
        SafeParcelWriter.writeInt(parcel, 3, this.height);
        SafeParcelWriter.writeInt(parcel, 4, this.heightPixels);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzchf);
        SafeParcelWriter.writeInt(parcel, 6, this.width);
        SafeParcelWriter.writeInt(parcel, 7, this.widthPixels);
        SafeParcelWriter.writeTypedArray(parcel, 8, this.zzchg, i, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzbsz);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzchh);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzchi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
