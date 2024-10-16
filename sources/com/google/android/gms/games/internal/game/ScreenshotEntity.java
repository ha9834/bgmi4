package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.internal.zzd;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "ScreenshotEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class ScreenshotEntity extends zzd implements Parcelable, Freezable {
    public static final Parcelable.Creator<ScreenshotEntity> CREATOR = new zzc();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getUri", id = 1)
    private final Uri f1670a;

    @SafeParcelable.Field(getter = "getWidth", id = 2)
    private final int b;

    @SafeParcelable.Field(getter = "getHeight", id = 3)
    private final int c;

    @SafeParcelable.Constructor
    public ScreenshotEntity(@SafeParcelable.Param(id = 1) Uri uri, @SafeParcelable.Param(id = 2) int i, @SafeParcelable.Param(id = 3) int i2) {
        this.f1670a = uri;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f1670a, Integer.valueOf(this.b), Integer.valueOf(this.c));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ScreenshotEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ScreenshotEntity screenshotEntity = (ScreenshotEntity) obj;
        return Objects.equal(screenshotEntity.f1670a, this.f1670a) && Objects.equal(Integer.valueOf(screenshotEntity.b), Integer.valueOf(this.b)) && Objects.equal(Integer.valueOf(screenshotEntity.c), Integer.valueOf(this.c));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Uri", this.f1670a).add("Width", Integer.valueOf(this.b)).add("Height", Integer.valueOf(this.c)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f1670a, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.b);
        SafeParcelWriter.writeInt(parcel, 3, this.c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
