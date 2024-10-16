package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzd;

@SafeParcelable.Class(creator = "VideoCapabilitiesCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class VideoCapabilities extends zzd {
    public static final Parcelable.Creator<VideoCapabilities> CREATOR = new zza();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "isCameraSupported", id = 1)
    private final boolean f1744a;

    @SafeParcelable.Field(getter = "isMicSupported", id = 2)
    private final boolean b;

    @SafeParcelable.Field(getter = "isWriteStorageSupported", id = 3)
    private final boolean c;

    @SafeParcelable.Field(getter = "getSupportedCaptureModes", id = 4)
    private final boolean[] d;

    @SafeParcelable.Field(getter = "getSupportedQualityLevels", id = 5)
    private final boolean[] e;

    @SafeParcelable.Constructor
    public VideoCapabilities(@SafeParcelable.Param(id = 1) boolean z, @SafeParcelable.Param(id = 2) boolean z2, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) boolean[] zArr, @SafeParcelable.Param(id = 5) boolean[] zArr2) {
        this.f1744a = z;
        this.b = z2;
        this.c = z3;
        this.d = zArr;
        this.e = zArr2;
    }

    public final boolean isMicSupported() {
        return this.b;
    }

    public final boolean isCameraSupported() {
        return this.f1744a;
    }

    public final boolean isWriteStorageSupported() {
        return this.c;
    }

    public final boolean[] getSupportedCaptureModes() {
        return this.d;
    }

    public final boolean[] getSupportedQualityLevels() {
        return this.e;
    }

    public final boolean supportsCaptureMode(int i) {
        Preconditions.checkState(VideoConfiguration.isValidCaptureMode(i, false));
        return this.d[i];
    }

    public final boolean supportsQualityLevel(int i) {
        Preconditions.checkState(VideoConfiguration.isValidQualityLevel(i, false));
        return this.e[i];
    }

    public final boolean isFullySupported(int i, int i2) {
        return this.f1744a && this.b && this.c && supportsCaptureMode(i) && supportsQualityLevel(i2);
    }

    public final int hashCode() {
        return Objects.hashCode(getSupportedCaptureModes(), getSupportedQualityLevels(), Boolean.valueOf(isCameraSupported()), Boolean.valueOf(isMicSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof VideoCapabilities)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        VideoCapabilities videoCapabilities = (VideoCapabilities) obj;
        return Objects.equal(videoCapabilities.getSupportedCaptureModes(), getSupportedCaptureModes()) && Objects.equal(videoCapabilities.getSupportedQualityLevels(), getSupportedQualityLevels()) && Objects.equal(Boolean.valueOf(videoCapabilities.isCameraSupported()), Boolean.valueOf(isCameraSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isMicSupported()), Boolean.valueOf(isMicSupported())) && Objects.equal(Boolean.valueOf(videoCapabilities.isWriteStorageSupported()), Boolean.valueOf(isWriteStorageSupported()));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("SupportedCaptureModes", getSupportedCaptureModes()).add("SupportedQualityLevels", getSupportedQualityLevels()).add("CameraSupported", Boolean.valueOf(isCameraSupported())).add("MicSupported", Boolean.valueOf(isMicSupported())).add("StorageWriteSupported", Boolean.valueOf(isWriteStorageSupported())).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, isCameraSupported());
        SafeParcelWriter.writeBoolean(parcel, 2, isMicSupported());
        SafeParcelWriter.writeBoolean(parcel, 3, isWriteStorageSupported());
        SafeParcelWriter.writeBooleanArray(parcel, 4, getSupportedCaptureModes(), false);
        SafeParcelWriter.writeBooleanArray(parcel, 5, getSupportedQualityLevels(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
