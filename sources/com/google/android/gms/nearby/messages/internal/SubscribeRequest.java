package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.internal.zzbgl;
import com.google.android.gms.internal.zzbgo;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

/* loaded from: classes2.dex */
public final class SubscribeRequest extends zzbgl implements ReflectedParcelable {
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzcd();

    /* renamed from: a, reason: collision with root package name */
    private int f4992a;
    private zzm b;
    private Strategy c;
    private zzp d;
    private MessageFilter e;
    private PendingIntent f;

    @Deprecated
    private int g;

    @Deprecated
    private String h;

    @Deprecated
    private String i;
    private byte[] j;

    @Deprecated
    private boolean k;
    private zzaa l;

    @Deprecated
    private boolean m;

    @Deprecated
    private ClientAppContext n;
    private boolean o;
    private int p;
    private int q;

    public SubscribeRequest(int i, IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, int i2, String str, String str2, byte[] bArr, boolean z, IBinder iBinder3, boolean z2, ClientAppContext clientAppContext, boolean z3, int i3, int i4) {
        zzm zzoVar;
        zzp zzrVar;
        this.f4992a = i;
        zzaa zzaaVar = null;
        if (iBinder == null) {
            zzoVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzoVar = queryLocalInterface instanceof zzm ? (zzm) queryLocalInterface : new zzo(iBinder);
        }
        this.b = zzoVar;
        this.c = strategy;
        if (iBinder2 == null) {
            zzrVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface2 instanceof zzp ? (zzp) queryLocalInterface2 : new zzr(iBinder2);
        }
        this.d = zzrVar;
        this.e = messageFilter;
        this.f = pendingIntent;
        this.g = i2;
        this.h = str;
        this.i = str2;
        this.j = bArr;
        this.k = z;
        if (iBinder3 != null && iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            zzaaVar = queryLocalInterface3 instanceof zzaa ? (zzaa) queryLocalInterface3 : new zzac(iBinder3);
        }
        this.l = zzaaVar;
        this.m = z2;
        this.n = ClientAppContext.a(clientAppContext, str2, str, z2);
        this.o = z3;
        this.p = i3;
        this.q = i4;
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i) {
        this(iBinder, strategy, iBinder2, messageFilter, null, bArr, iBinder3, z, 0, i);
    }

    public SubscribeRequest(IBinder iBinder, Strategy strategy, IBinder iBinder2, MessageFilter messageFilter, PendingIntent pendingIntent, byte[] bArr, IBinder iBinder3, boolean z, int i, int i2) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, 0, null, null, bArr, false, iBinder3, false, null, z, i, i2);
    }

    public final String toString() {
        String sb;
        String valueOf = String.valueOf(this.b);
        String valueOf2 = String.valueOf(this.c);
        String valueOf3 = String.valueOf(this.d);
        String valueOf4 = String.valueOf(this.e);
        String valueOf5 = String.valueOf(this.f);
        byte[] bArr = this.j;
        if (bArr == null) {
            sb = null;
        } else {
            int length = bArr.length;
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("<");
            sb2.append(length);
            sb2.append(" bytes>");
            sb = sb2.toString();
        }
        String valueOf6 = String.valueOf(this.l);
        boolean z = this.m;
        String valueOf7 = String.valueOf(this.n);
        boolean z2 = this.o;
        String str = this.h;
        String str2 = this.i;
        boolean z3 = this.k;
        int i = this.q;
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 291 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(sb).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str).length() + String.valueOf(str2).length());
        sb3.append("SubscribeRequest{messageListener=");
        sb3.append(valueOf);
        sb3.append(", strategy=");
        sb3.append(valueOf2);
        sb3.append(", callback=");
        sb3.append(valueOf3);
        sb3.append(", filter=");
        sb3.append(valueOf4);
        sb3.append(", pendingIntent=");
        sb3.append(valueOf5);
        sb3.append(", hint=");
        sb3.append(sb);
        sb3.append(", subscribeCallback=");
        sb3.append(valueOf6);
        sb3.append(", useRealClientApiKey=");
        sb3.append(z);
        sb3.append(", clientAppContext=");
        sb3.append(valueOf7);
        sb3.append(", isDiscardPendingIntent=");
        sb3.append(z2);
        sb3.append(", zeroPartyPackageName=");
        sb3.append(str);
        sb3.append(", realClientPackageName=");
        sb3.append(str2);
        sb3.append(", isIgnoreNearbyPermission=");
        sb3.append(z3);
        sb3.append(", callingContext=");
        sb3.append(i);
        sb3.append("}");
        return sb3.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int zze = zzbgo.zze(parcel);
        zzbgo.zzc(parcel, 1, this.f4992a);
        zzm zzmVar = this.b;
        zzbgo.zza(parcel, 2, zzmVar == null ? null : zzmVar.asBinder(), false);
        zzbgo.zza(parcel, 3, this.c, i, false);
        zzp zzpVar = this.d;
        zzbgo.zza(parcel, 4, zzpVar == null ? null : zzpVar.asBinder(), false);
        zzbgo.zza(parcel, 5, this.e, i, false);
        zzbgo.zza(parcel, 6, this.f, i, false);
        zzbgo.zzc(parcel, 7, this.g);
        zzbgo.zza(parcel, 8, this.h, false);
        zzbgo.zza(parcel, 9, this.i, false);
        zzbgo.zza(parcel, 10, this.j, false);
        zzbgo.zza(parcel, 11, this.k);
        zzaa zzaaVar = this.l;
        zzbgo.zza(parcel, 12, zzaaVar != null ? zzaaVar.asBinder() : null, false);
        zzbgo.zza(parcel, 13, this.m);
        zzbgo.zza(parcel, 14, this.n, i, false);
        zzbgo.zza(parcel, 15, this.o);
        zzbgo.zzc(parcel, 16, this.p);
        zzbgo.zzc(parcel, 17, this.q);
        zzbgo.zzai(parcel, zze);
    }
}
