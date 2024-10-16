package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@zzard
@SafeParcelable.Class(creator = "SearchAdRequestParcelCreator")
@SafeParcelable.Reserved({1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14})
/* loaded from: classes2.dex */
public final class zzaca extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaca> CREATOR = new zzacb();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 15)
    private final String f2694a;

    public zzaca(SearchAdRequest searchAdRequest) {
        this.f2694a = searchAdRequest.getQuery();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzaca(@SafeParcelable.Param(id = 15) String str) {
        this.f2694a = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 15, this.f2694a, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
