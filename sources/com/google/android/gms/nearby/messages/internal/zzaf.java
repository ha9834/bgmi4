package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class zzaf extends zzbgl {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzag();

    /* renamed from: a, reason: collision with root package name */
    private int f5025a;
    private Message b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(int i, Message message) {
        this.f5025a = i;
        this.b = (Message) zzbq.checkNotNull(message);
    }

    public static final zzaf zza(Message message) {
        return new zzaf(1, message);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzaf) {
            return zzbg.equal(this.b, ((zzaf) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.b});
    }

    public final String toString() {
        String message = this.b.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 24);
        sb.append("MessageWrapper{message=");
        sb.append(message);
        sb.append("}");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zza(parcel, 1, this.b, i, false);
        zzbgo.zzc(parcel, 1000, this.f5025a);
        zzbgo.zzai(parcel, zze);
    }
}
