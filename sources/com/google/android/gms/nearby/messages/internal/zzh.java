package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

@Deprecated
/* loaded from: classes2.dex */
public final class zzh extends zzbgl {
    public static final Parcelable.Creator<zzh> CREATOR = new zzi();

    /* renamed from: a, reason: collision with root package name */
    private int f5034a;
    private zzp b;

    @Deprecated
    private String c;

    @Deprecated
    private ClientAppContext d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(int i, IBinder iBinder, String str, ClientAppContext clientAppContext) {
        zzp zzrVar;
        this.f5034a = i;
        if (iBinder == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.b = zzrVar;
        this.c = str;
        this.d = ClientAppContext.a(clientAppContext, null, str, false);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f5034a);
        zzbgo.zza(parcel, 2, this.b.asBinder(), false);
        zzbgo.zza(parcel, 3, this.c, false);
        zzbgo.zza(parcel, 4, this.d, i, false);
        zzbgo.zzai(parcel, zze);
    }
}
