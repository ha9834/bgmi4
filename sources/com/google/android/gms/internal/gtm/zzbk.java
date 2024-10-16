package com.google.android.gms.internal.gtm;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public final class zzbk implements Parcelable {

    @Deprecated
    public static final Parcelable.Creator<zzbk> CREATOR = new u();

    /* renamed from: a, reason: collision with root package name */
    private String f4397a;
    private String b;
    private String c;

    @Override // android.os.Parcelable
    @Deprecated
    public final int describeContents() {
        return 0;
    }

    public final String getId() {
        return this.f4397a;
    }

    public final String getValue() {
        return this.c;
    }

    @Deprecated
    public zzbk() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public zzbk(Parcel parcel) {
        this.f4397a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    @Deprecated
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f4397a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
