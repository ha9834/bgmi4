package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "DeviceMetaDataCreator")
/* loaded from: classes.dex */
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new zzv();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f1226a;

    @SafeParcelable.Field(getter = "isLockScreenSolved", id = 2)
    private boolean b;

    @SafeParcelable.Field(getter = "getMinAgeOfLockScreen", id = 3)
    private long c;

    @SafeParcelable.Field(getter = "isChallengeAllowed", id = 4)
    private final boolean d;

    public boolean isLockScreenSolved() {
        return this.b;
    }

    public long getMinAgeOfLockScreen() {
        return this.c;
    }

    public boolean isChallengeAllowed() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DeviceMetaData(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) boolean z, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) boolean z2) {
        this.f1226a = i;
        this.b = z;
        this.c = j;
        this.d = z2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f1226a);
        SafeParcelWriter.writeBoolean(parcel, 2, isLockScreenSolved());
        SafeParcelWriter.writeLong(parcel, 3, getMinAgeOfLockScreen());
        SafeParcelWriter.writeBoolean(parcel, 4, isChallengeAllowed());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
