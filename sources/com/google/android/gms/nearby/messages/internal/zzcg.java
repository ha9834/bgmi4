package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

/* loaded from: classes2.dex */
public final class zzcg extends zzbgl {
    public static final Parcelable.Creator<zzcg> CREATOR = new zzch();

    /* renamed from: a, reason: collision with root package name */
    private int f5032a;
    private zzm b;
    private zzp c;
    private PendingIntent d;

    @Deprecated
    private int e;

    @Deprecated
    private String f;

    @Deprecated
    private String g;

    @Deprecated
    private boolean h;

    @Deprecated
    private ClientAppContext i;

    public zzcg(int i, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, int i2, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        zzm zzoVar;
        this.f5032a = i;
        zzp zzpVar = null;
        if (iBinder == null) {
            zzoVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzoVar = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
        }
        this.b = zzoVar;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzpVar = queryLocalInterface2 instanceof zzp ? (zzp) queryLocalInterface2 : new zzr(iBinder2);
        }
        this.c = zzpVar;
        this.d = pendingIntent;
        this.e = i2;
        this.f = str;
        this.g = str2;
        this.h = z;
        this.i = ClientAppContext.a(clientAppContext, str2, str, z);
    }

    public zzcg(IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent) {
        this(1, iBinder, iBinder2, pendingIntent, 0, null, null, false, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f5032a);
        zzm zzmVar = this.b;
        zzbgo.zza(parcel, 2, zzmVar == null ? null : zzmVar.asBinder(), false);
        zzbgo.zza(parcel, 3, this.c.asBinder(), false);
        zzbgo.zza(parcel, 4, this.d, i, false);
        zzbgo.zzc(parcel, 5, this.e);
        zzbgo.zza(parcel, 6, this.f, false);
        zzbgo.zza(parcel, 7, this.g, false);
        zzbgo.zza(parcel, 8, this.h);
        zzbgo.zza(parcel, 9, this.i, i, false);
        zzbgo.zzai(parcel, zze);
    }
}
