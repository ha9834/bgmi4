package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public final class AppMetadata extends zzbgl {
    public static final Parcelable.Creator<AppMetadata> CREATOR = new zzd();

    /* renamed from: a, reason: collision with root package name */
    private final List<AppIdentifier> f4965a;

    public AppMetadata(List<AppIdentifier> list) {
        this.f4965a = (List) zzbq.checkNotNull(list, "Must specify application identifiers");
        zzbq.zza(list.size(), "Application identifiers cannot be empty");
    }

    public final List<AppIdentifier> getAppIdentifiers() {
        return this.f4965a;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, getAppIdentifiers(), false);
        zzbgo.zzai(parcel, zze);
    }
}
