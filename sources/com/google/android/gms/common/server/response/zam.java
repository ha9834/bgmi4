package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMapPairCreator")
/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zaj();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 2)
    final String f1493a;

    @SafeParcelable.Field(id = 3)
    final FastJsonResponse.Field<?, ?> b;

    @SafeParcelable.VersionField(id = 1)
    private final int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zam(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) FastJsonResponse.Field<?, ?> field) {
        this.c = i;
        this.f1493a = str;
        this.b = field;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.c = 1;
        this.f1493a = str;
        this.b = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.c);
        SafeParcelWriter.writeString(parcel, 2, this.f1493a, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.b, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
