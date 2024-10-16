package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.InputStream;
import javax.annotation.concurrent.GuardedBy;

@zzard
@SafeParcelable.Class(creator = "CacheEntryParcelCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes2.dex */
public final class zzvs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzvs> CREATOR = new zzvt();

    /* renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    @SafeParcelable.Field(getter = "getContentFileDescriptor", id = 2)
    private ParcelFileDescriptor f3763a;

    public zzvs() {
        this(null);
    }

    @SafeParcelable.Constructor
    public zzvs(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.f3763a = parcelFileDescriptor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean zznh() {
        return this.f3763a != null;
    }

    public final synchronized InputStream zzni() {
        if (this.f3763a == null) {
            return null;
        }
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(this.f3763a);
        this.f3763a = null;
        return autoCloseInputStream;
    }

    private final synchronized ParcelFileDescriptor a() {
        return this.f3763a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, a(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
