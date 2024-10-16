package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.nearby.messages.Strategy;

/* loaded from: classes2.dex */
public final class zzbz extends zzbgl {
    public static final Parcelable.Creator<zzbz> CREATOR = new zzca();

    /* renamed from: a, reason: collision with root package name */
    private int f5028a;
    private zzaf b;
    private Strategy c;
    private zzp d;

    @Deprecated
    private String e;

    @Deprecated
    private String f;

    @Deprecated
    private boolean g;
    private zzu h;

    @Deprecated
    private boolean i;

    @Deprecated
    private ClientAppContext j;
    private int k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbz(int i, zzaf zzafVar, Strategy strategy, IBinder iBinder, String str, String str2, boolean z, IBinder iBinder2, boolean z2, ClientAppContext clientAppContext, int i2) {
        zzp zzrVar;
        this.f5028a = i;
        this.b = zzafVar;
        this.c = strategy;
        zzu zzuVar = null;
        if (iBinder == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.d = zzrVar;
        this.e = str;
        this.f = str2;
        this.g = z;
        if (iBinder2 != null && iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            zzuVar = queryLocalInterface2 instanceof zzu ? (zzu) queryLocalInterface2 : new zzw(iBinder2);
        }
        this.h = zzuVar;
        this.i = z2;
        this.j = ClientAppContext.a(clientAppContext, str2, str, z2);
        this.k = i2;
    }

    public zzbz(zzaf zzafVar, Strategy strategy, IBinder iBinder, IBinder iBinder2, int i) {
        this(2, zzafVar, strategy, iBinder, null, null, false, iBinder2, false, null, i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f5028a);
        zzbgo.zza(parcel, 2, this.b, i, false);
        zzbgo.zza(parcel, 3, this.c, i, false);
        zzbgo.zza(parcel, 4, this.d.asBinder(), false);
        zzbgo.zza(parcel, 5, this.e, false);
        zzbgo.zza(parcel, 6, this.f, false);
        zzbgo.zza(parcel, 7, this.g);
        zzu zzuVar = this.h;
        zzbgo.zza(parcel, 8, zzuVar == null ? null : zzuVar.asBinder(), false);
        zzbgo.zza(parcel, 9, this.i);
        zzbgo.zza(parcel, 10, this.j, i, false);
        zzbgo.zzc(parcel, 11, this.k);
        zzbgo.zzai(parcel, zze);
    }
}
