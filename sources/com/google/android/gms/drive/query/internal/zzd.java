package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

@SafeParcelable.Class(creator = "FieldOnlyFilterCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes.dex */
public final class zzd extends zza {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final MetadataBundle f1567a;
    private final MetadataField<?> b;

    public zzd(SearchableMetadataField<?> searchableMetadataField) {
        this(MetadataBundle.zza(searchableMetadataField, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(id = 1) MetadataBundle metadataBundle) {
        this.f1567a = metadataBundle;
        this.b = a.a(metadataBundle);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f1567a, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // com.google.android.gms.drive.query.Filter
    public final <T> T zza(zzj<T> zzjVar) {
        return zzjVar.zze(this.b);
    }
}
