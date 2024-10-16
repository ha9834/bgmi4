package com.google.android.gms.games.snapshot;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.apps.common.proguard.UsedByReflection;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@UsedByReflection("GamesClientImpl.java")
@SafeParcelable.Class(creator = "SnapshotEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class SnapshotEntity extends com.google.android.gms.games.internal.zzd implements Snapshot {
    public static final Parcelable.Creator<SnapshotEntity> CREATOR = new zzb();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "getMetadata", id = 1)
    private final SnapshotMetadataEntity f1737a;

    @SafeParcelable.Field(getter = "getSnapshotContents", id = 3)
    private final SnapshotContentsEntity b;

    @SafeParcelable.Constructor
    public SnapshotEntity(@SafeParcelable.Param(id = 1) SnapshotMetadata snapshotMetadata, @SafeParcelable.Param(id = 3) SnapshotContentsEntity snapshotContentsEntity) {
        this.f1737a = new SnapshotMetadataEntity(snapshotMetadata);
        this.b = snapshotContentsEntity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.data.Freezable
    public final Snapshot freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public final SnapshotMetadata getMetadata() {
        return this.f1737a;
    }

    @Override // com.google.android.gms.games.snapshot.Snapshot
    public final SnapshotContents getSnapshotContents() {
        if (this.b.isClosed()) {
            return null;
        }
        return this.b;
    }

    public final int hashCode() {
        return Objects.hashCode(getMetadata(), getSnapshotContents());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Snapshot)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Snapshot snapshot = (Snapshot) obj;
        return Objects.equal(snapshot.getMetadata(), getMetadata()) && Objects.equal(snapshot.getSnapshotContents(), getSnapshotContents());
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("Metadata", getMetadata()).add("HasContents", Boolean.valueOf(getSnapshotContents() != null)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getMetadata(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getSnapshotContents(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
