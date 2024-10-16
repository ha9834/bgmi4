package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

/* loaded from: classes2.dex */
public final class zzcb extends zzbgl {
    public static final Parcelable.Creator<zzcb> CREATOR = new zzcc();

    /* renamed from: a, reason: collision with root package name */
    private int f5030a;
    private zzp b;
    private zzx c;

    @Deprecated
    private String d;

    @Deprecated
    private ClientAppContext e;
    public boolean zzkeh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcb(int i, IBinder iBinder, IBinder iBinder2, boolean z, String str, ClientAppContext clientAppContext) {
        zzp zzrVar;
        zzx zzzVar;
        this.f5030a = i;
        if (iBinder == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.b = zzrVar;
        if (iBinder2 == null) {
            zzzVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IStatusCallback");
            zzzVar = queryLocalInterface2 instanceof zzx ? (zzx) queryLocalInterface2 : new zzz(iBinder2);
        }
        this.c = zzzVar;
        this.zzkeh = z;
        this.d = str;
        this.e = ClientAppContext.a(clientAppContext, null, str, false);
    }

    public zzcb(IBinder iBinder, IBinder iBinder2) {
        this(1, iBinder, iBinder2, false, null, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f5030a);
        zzbgo.zza(parcel, 2, this.b.asBinder(), false);
        zzbgo.zza(parcel, 3, this.c.asBinder(), false);
        zzbgo.zza(parcel, 4, this.zzkeh);
        zzbgo.zza(parcel, 5, this.d, false);
        zzbgo.zza(parcel, 6, this.e, i, false);
        zzbgo.zzai(parcel, zze);
    }
}
