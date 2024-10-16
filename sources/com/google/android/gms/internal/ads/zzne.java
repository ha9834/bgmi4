package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzne implements Parcelable, Comparator<zza> {
    public static final Parcelable.Creator<zzne> CREATOR = new als();

    /* renamed from: a, reason: collision with root package name */
    private final zza[] f3691a;
    private int b;
    public final int zzazg;

    public zzne(zza... zzaVarArr) {
        this(true, zzaVarArr);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* loaded from: classes2.dex */
    public static final class zza implements Parcelable {
        public static final Parcelable.Creator<zza> CREATOR = new alt();

        /* renamed from: a, reason: collision with root package name */
        private int f3692a;
        private final UUID b;
        private final String c;
        private final byte[] d;
        public final boolean zzazh;

        public zza(UUID uuid, String str, byte[] bArr) {
            this(uuid, str, bArr, false);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        private zza(UUID uuid, String str, byte[] bArr, boolean z) {
            this.b = (UUID) zzsk.checkNotNull(uuid);
            this.c = (String) zzsk.checkNotNull(str);
            this.d = (byte[]) zzsk.checkNotNull(bArr);
            this.zzazh = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public zza(Parcel parcel) {
            this.b = new UUID(parcel.readLong(), parcel.readLong());
            this.c = parcel.readString();
            this.d = parcel.createByteArray();
            this.zzazh = parcel.readByte() != 0;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            zza zzaVar = (zza) obj;
            return this.c.equals(zzaVar.c) && zzsy.zza(this.b, zzaVar.b) && Arrays.equals(this.d, zzaVar.d);
        }

        public final int hashCode() {
            if (this.f3692a == 0) {
                this.f3692a = (((this.b.hashCode() * 31) + this.c.hashCode()) * 31) + Arrays.hashCode(this.d);
            }
            return this.f3692a;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.b.getMostSignificantBits());
            parcel.writeLong(this.b.getLeastSignificantBits());
            parcel.writeString(this.c);
            parcel.writeByteArray(this.d);
            parcel.writeByte(this.zzazh ? (byte) 1 : (byte) 0);
        }
    }

    private zzne(boolean z, zza... zzaVarArr) {
        zza[] zzaVarArr2 = (zza[]) zzaVarArr.clone();
        Arrays.sort(zzaVarArr2, this);
        for (int i = 1; i < zzaVarArr2.length; i++) {
            if (zzaVarArr2[i - 1].b.equals(zzaVarArr2[i].b)) {
                String valueOf = String.valueOf(zzaVarArr2[i].b);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 25);
                sb.append("Duplicate data for uuid: ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        this.f3691a = zzaVarArr2;
        this.zzazg = zzaVarArr2.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzne(Parcel parcel) {
        this.f3691a = (zza[]) parcel.createTypedArray(zza.CREATOR);
        this.zzazg = this.f3691a.length;
    }

    public final zza zzap(int i) {
        return this.f3691a[i];
    }

    public final int hashCode() {
        if (this.b == 0) {
            this.b = Arrays.hashCode(this.f3691a);
        }
        return this.b;
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f3691a, ((zzne) obj).f3691a);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f3691a, 0);
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zza zzaVar, zza zzaVar2) {
        zza zzaVar3 = zzaVar;
        zza zzaVar4 = zzaVar2;
        if (zzkt.zzarg.equals(zzaVar3.b)) {
            return zzkt.zzarg.equals(zzaVar4.b) ? 0 : 1;
        }
        return zzaVar3.b.compareTo(zzaVar4.b);
    }
}
