package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserAttributeParcelCreator")
/* loaded from: classes2.dex */
public final class zzjn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjn> CREATOR = new zzjq();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.Field(id = 1)
    private final int f4955a;

    @SafeParcelable.Field(id = 5)
    private final Float b;

    @SafeParcelable.Field(id = 2)
    public final String name;

    @SafeParcelable.Field(id = 7)
    public final String origin;

    @SafeParcelable.Field(id = 6)
    public final String zzkr;

    @SafeParcelable.Field(id = 3)
    public final long zztr;

    @SafeParcelable.Field(id = 4)
    public final Long zzts;

    @SafeParcelable.Field(id = 8)
    public final Double zztu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(gv gvVar) {
        this(gvVar.c, gvVar.d, gvVar.e, gvVar.b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(String str, long j, Object obj, String str2) {
        Preconditions.checkNotEmpty(str);
        this.f4955a = 2;
        this.name = str;
        this.zztr = j;
        this.origin = str2;
        if (obj == null) {
            this.zzts = null;
            this.b = null;
            this.zztu = null;
            this.zzkr = null;
            return;
        }
        if (obj instanceof Long) {
            this.zzts = (Long) obj;
            this.b = null;
            this.zztu = null;
            this.zzkr = null;
            return;
        }
        if (obj instanceof String) {
            this.zzts = null;
            this.b = null;
            this.zztu = null;
            this.zzkr = (String) obj;
            return;
        }
        if (obj instanceof Double) {
            this.zzts = null;
            this.b = null;
            this.zztu = (Double) obj;
            this.zzkr = null;
            return;
        }
        throw new IllegalArgumentException("User attribute given of un-supported type");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjn(String str, long j, String str2) {
        Preconditions.checkNotEmpty(str);
        this.f4955a = 2;
        this.name = str;
        this.zztr = 0L;
        this.zzts = null;
        this.b = null;
        this.zztu = null;
        this.zzkr = null;
        this.origin = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzjn(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) Float f, @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) String str3, @SafeParcelable.Param(id = 8) Double d) {
        this.f4955a = i;
        this.name = str;
        this.zztr = j;
        this.zzts = l;
        this.b = null;
        if (i == 1) {
            this.zztu = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.zztu = d;
        }
        this.zzkr = str2;
        this.origin = str3;
    }

    public final Object getValue() {
        Long l = this.zzts;
        if (l != null) {
            return l;
        }
        Double d = this.zztu;
        if (d != null) {
            return d;
        }
        String str = this.zzkr;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f4955a);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zztr);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzts, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzkr, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zztu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
