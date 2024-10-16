package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public abstract class zzu extends AbstractSafeParcelable {

    /* renamed from: a, reason: collision with root package name */
    private volatile transient boolean f1581a = false;

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkState(!this.f1581a);
        this.f1581a = true;
        zza(parcel, i);
    }

    protected abstract void zza(Parcel parcel, int i);
}
