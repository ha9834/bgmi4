package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;

/* loaded from: classes2.dex */
public final class zzce extends zzbgl {
    public static final Parcelable.Creator<zzce> CREATOR = new zzcf();

    /* renamed from: a, reason: collision with root package name */
    private int f5031a;
    private zzaf b;
    private zzp c;

    @Deprecated
    private String d;

    @Deprecated
    private String e;

    @Deprecated
    private boolean f;

    @Deprecated
    private ClientAppContext g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzce(int i, zzaf zzafVar, IBinder iBinder, String str, String str2, boolean z, ClientAppContext clientAppContext) {
        zzp zzrVar;
        this.f5031a = i;
        this.b = zzafVar;
        if (iBinder == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzr(iBinder);
        }
        this.c = zzrVar;
        this.d = str;
        this.e = str2;
        this.f = z;
        this.g = ClientAppContext.a(clientAppContext, str2, str, z);
    }

    public zzce(zzaf zzafVar, IBinder iBinder) {
        this(1, zzafVar, iBinder, null, null, false, null);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f5031a);
        zzbgo.zza(parcel, 2, this.b, i, false);
        zzbgo.zza(parcel, 3, this.c.asBinder(), false);
        zzbgo.zza(parcel, 4, this.d, false);
        zzbgo.zza(parcel, 5, this.e, false);
        zzbgo.zza(parcel, 6, this.f);
        zzbgo.zza(parcel, 7, this.g, i, false);
        zzbgo.zzai(parcel, zze);
    }
}
