package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzpo implements Parcelable {
    public static final Parcelable.Creator<zzpo> CREATOR = new ana();

    /* renamed from: a, reason: collision with root package name */
    private final zza[] f3706a;

    /* loaded from: classes2.dex */
    public interface zza extends Parcelable {
    }

    public zzpo(List<? extends zza> list) {
        this.f3706a = new zza[list.size()];
        list.toArray(this.f3706a);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpo(Parcel parcel) {
        this.f3706a = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaVarArr = this.f3706a;
            if (i >= zzaVarArr.length) {
                return;
            }
            zzaVarArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
            i++;
        }
    }

    public final int length() {
        return this.f3706a.length;
    }

    public final zza zzbc(int i) {
        return this.f3706a[i];
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f3706a, ((zzpo) obj).f3706a);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.f3706a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3706a.length);
        for (zza zzaVar : this.f3706a) {
            parcel.writeParcelable(zzaVar, 0);
        }
    }
}
