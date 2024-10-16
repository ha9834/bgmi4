package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.zzbg;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.internal.zzcuw;
import com.google.android.gms.internal.zzcux;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class Update extends zzbgl implements ReflectedParcelable {
    public static final Parcelable.Creator<Update> CREATOR = new zzci();

    /* renamed from: a, reason: collision with root package name */
    private int f4993a;
    private int b;
    private byte[] c;
    public final Message zzkda;
    public final zze zzkeo;
    public final zza zzkep;
    public final zzcux zzkeq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Update(int i, int i2, Message message, zze zzeVar, zza zzaVar, zzcux zzcuxVar, byte[] bArr) {
        this.f4993a = i;
        int i3 = 2;
        if (a(i2, 2)) {
            zzeVar = null;
            zzaVar = null;
            zzcuxVar = null;
            bArr = null;
        } else {
            i3 = i2;
        }
        this.b = i3;
        this.zzkda = message;
        this.zzkeo = zzeVar;
        this.zzkep = zzaVar;
        this.zzkeq = zzcuxVar;
        this.c = bArr;
    }

    private static boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.b == update.b && zzbg.equal(this.zzkda, update.zzkda) && zzbg.equal(this.zzkeo, update.zzkeo) && zzbg.equal(this.zzkep, update.zzkep) && zzbg.equal(this.zzkeq, update.zzkeq) && Arrays.equals(this.c, update.c);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.b), this.zzkda, this.zzkeo, this.zzkep, this.zzkeq, this.c});
    }

    public String toString() {
        androidx.b.b bVar = new androidx.b.b();
        if (zzeu(1)) {
            bVar.add("FOUND");
        }
        if (zzeu(2)) {
            bVar.add("LOST");
        }
        if (zzeu(4)) {
            bVar.add("DISTANCE");
        }
        if (zzeu(8)) {
            bVar.add("BLE_SIGNAL");
        }
        if (zzeu(16)) {
            bVar.add("DEVICE");
        }
        if (zzeu(32)) {
            bVar.add("BLE_RECORD");
        }
        String valueOf = String.valueOf(bVar);
        String valueOf2 = String.valueOf(this.zzkda);
        String valueOf3 = String.valueOf(this.zzkeo);
        String valueOf4 = String.valueOf(this.zzkep);
        String valueOf5 = String.valueOf(this.zzkeq);
        String valueOf6 = String.valueOf(zzcuw.zzu(this.c));
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 68 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length());
        sb.append("Update{types=");
        sb.append(valueOf);
        sb.append(", message=");
        sb.append(valueOf2);
        sb.append(", distance=");
        sb.append(valueOf3);
        sb.append(", bleSignal=");
        sb.append(valueOf4);
        sb.append(", device=");
        sb.append(valueOf5);
        sb.append(", bleRecord=");
        sb.append(valueOf6);
        sb.append("}");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f4993a);
        zzbgo.zzc(parcel, 2, this.b);
        zzbgo.zza(parcel, 3, this.zzkda, i, false);
        zzbgo.zza(parcel, 4, this.zzkeo, i, false);
        zzbgo.zza(parcel, 5, this.zzkep, i, false);
        zzbgo.zza(parcel, 6, this.zzkeq, i, false);
        zzbgo.zza(parcel, 7, this.c, false);
        zzbgo.zzai(parcel, zze);
    }

    public final boolean zzeu(int i) {
        return a(this.b, i);
    }
}
