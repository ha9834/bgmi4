package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Hide;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class PayloadTransferUpdate extends zzbgl {
    public static final Parcelable.Creator<PayloadTransferUpdate> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    private long f4974a;
    private int b;
    private long c;
    private long d;

    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final PayloadTransferUpdate f4975a = new PayloadTransferUpdate();

        public Builder() {
        }

        public Builder(PayloadTransferUpdate payloadTransferUpdate) {
            this.f4975a.f4974a = payloadTransferUpdate.f4974a;
            this.f4975a.b = payloadTransferUpdate.b;
            this.f4975a.c = payloadTransferUpdate.c;
            this.f4975a.d = payloadTransferUpdate.d;
        }

        public final PayloadTransferUpdate build() {
            return this.f4975a;
        }

        public final Builder setBytesTransferred(long j) {
            this.f4975a.d = j;
            return this;
        }

        public final Builder setPayloadId(long j) {
            this.f4975a.f4974a = j;
            return this;
        }

        public final Builder setStatus(int i) {
            this.f4975a.b = i;
            return this;
        }

        public final Builder setTotalBytes(long j) {
            this.f4975a.c = j;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Status {
        public static final int CANCELED = 4;
        public static final int FAILURE = 2;
        public static final int IN_PROGRESS = 3;
        public static final int SUCCESS = 1;
    }

    private PayloadTransferUpdate() {
    }

    @Hide
    public PayloadTransferUpdate(long j, int i, long j2, long j3) {
        this.f4974a = j;
        this.b = i;
        this.c = j2;
        this.d = j3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate = (PayloadTransferUpdate) obj;
            if (zzbg.equal(Long.valueOf(this.f4974a), Long.valueOf(payloadTransferUpdate.f4974a)) && zzbg.equal(Integer.valueOf(this.b), Integer.valueOf(payloadTransferUpdate.b)) && zzbg.equal(Long.valueOf(this.c), Long.valueOf(payloadTransferUpdate.c)) && zzbg.equal(Long.valueOf(this.d), Long.valueOf(payloadTransferUpdate.d))) {
                return true;
            }
        }
        return false;
    }

    public final long getBytesTransferred() {
        return this.d;
    }

    public final long getPayloadId() {
        return this.f4974a;
    }

    public final int getStatus() {
        return this.b;
    }

    public final long getTotalBytes() {
        return this.c;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f4974a), Integer.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, getPayloadId());
        zzbgo.zzc(parcel, 2, getStatus());
        zzbgo.zza(parcel, 3, getTotalBytes());
        zzbgo.zza(parcel, 4, getBytesTransferred());
        zzbgo.zzai(parcel, zze);
    }
}
