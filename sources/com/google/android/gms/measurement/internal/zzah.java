package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Iterator;

@SafeParcelable.Class(creator = "EventParamsCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzah extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzah> CREATOR = new zzaj();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(getter = "z", id = 2)
    private final Bundle f4925a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzah(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f4925a = bundle;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzcv(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object a(String str) {
        return this.f4925a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long b(String str) {
        return Long.valueOf(this.f4925a.getLong(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double c(String str) {
        return Double.valueOf(this.f4925a.getDouble(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String d(String str) {
        return this.f4925a.getString(str);
    }

    public final int size() {
        return this.f4925a.size();
    }

    public final String toString() {
        return this.f4925a.toString();
    }

    public final Bundle zzcv() {
        return new Bundle(this.f4925a);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new d(this);
    }
}
