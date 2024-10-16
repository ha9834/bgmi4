package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.ads.zzbp;

@SafeParcelable.Class(creator = "GassResponseParcelCreator")
/* loaded from: classes2.dex */
public final class zzdbd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdbd> CREATOR = new zzdbe();

    /* renamed from: a, reason: collision with root package name */
    @SafeParcelable.VersionField(id = 1)
    private final int f3533a;

    @SafeParcelable.Field(getter = "getAfmaSignalsAsBytes", id = 2, type = "byte[]")
    private zzbp.zza b = null;
    private byte[] c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzdbd(@SafeParcelable.Param(id = 1) int i, @SafeParcelable.Param(id = 2) byte[] bArr) {
        this.f3533a = i;
        this.c = bArr;
        a();
    }

    public final zzbp.zza zzann() {
        if (!(this.b != null)) {
            try {
                this.b = zzbp.zza.zzb(this.c, zzdno.zzaxe());
                this.c = null;
            } catch (zzdok e) {
                throw new IllegalStateException(e);
            }
        }
        a();
        return this.b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f3533a);
        byte[] bArr = this.c;
        if (bArr == null) {
            bArr = this.b.toByteArray();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private final void a() {
        if (this.b != null || this.c == null) {
            if (this.b == null || this.c != null) {
                if (this.b != null && this.c != null) {
                    throw new IllegalStateException("Invalid internal representation - full");
                }
                if (this.b == null && this.c == null) {
                    throw new IllegalStateException("Invalid internal representation - empty");
                }
                throw new IllegalStateException("Impossible");
            }
        }
    }
}
