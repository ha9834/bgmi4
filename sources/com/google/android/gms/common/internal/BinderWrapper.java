package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new j();

    /* renamed from: a, reason: collision with root package name */
    private IBinder f1443a;

    public BinderWrapper() {
        this.f1443a = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @KeepForSdk
    public BinderWrapper(IBinder iBinder) {
        this.f1443a = null;
        this.f1443a = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.f1443a = null;
        this.f1443a = parcel.readStrongBinder();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f1443a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ BinderWrapper(Parcel parcel, j jVar) {
        this(parcel);
    }
}
