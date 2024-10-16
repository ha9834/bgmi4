package com.google.android.gms.ads.internal.overlay;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzagx;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzbai;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzxr;

@zzard
@SafeParcelable.Class(creator = "AdOverlayInfoCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes.dex */
public final class AdOverlayInfoParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<AdOverlayInfoParcel> CREATOR = new zzn();

    @SafeParcelable.Field(id = 11)
    public final int orientation;

    @SafeParcelable.Field(id = 13)
    public final String url;

    @SafeParcelable.Field(id = 14)
    public final zzbai zzbtc;

    @SafeParcelable.Field(getter = "getAdClickListenerAsBinder", id = 3, type = "android.os.IBinder")
    public final zzxr zzcgi;

    @SafeParcelable.Field(getter = "getAdMetadataGmsgListenerAsBinder", id = 18, type = "android.os.IBinder")
    public final zzagv zzczo;

    @SafeParcelable.Field(getter = "getAppEventGmsgListenerAsBinder", id = 6, type = "android.os.IBinder")
    public final zzagx zzczp;

    @SafeParcelable.Field(getter = "getAdWebViewAsBinder", id = 5, type = "android.os.IBinder")
    public final zzbgz zzdbs;

    @SafeParcelable.Field(id = 2)
    public final zzc zzdkl;

    @SafeParcelable.Field(getter = "getAdOverlayListenerAsBinder", id = 4, type = "android.os.IBinder")
    public final zzo zzdkm;

    @SafeParcelable.Field(id = 7)
    public final String zzdkn;

    @SafeParcelable.Field(id = 8)
    public final boolean zzdko;

    @SafeParcelable.Field(id = 9)
    public final String zzdkp;

    @SafeParcelable.Field(getter = "getLeaveApplicationListenerAsBinder", id = 10, type = "android.os.IBinder")
    public final zzu zzdkq;

    @SafeParcelable.Field(id = 12)
    public final int zzdkr;

    @SafeParcelable.Field(id = 16)
    public final String zzdks;

    @SafeParcelable.Field(id = 17)
    public final com.google.android.gms.ads.internal.zzh zzdkt;

    public static void zza(Intent intent, AdOverlayInfoParcel adOverlayInfoParcel) {
        Bundle bundle = new Bundle(1);
        bundle.putParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", adOverlayInfoParcel);
        intent.putExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo", bundle);
    }

    public static AdOverlayInfoParcel zzc(Intent intent) {
        try {
            Bundle bundleExtra = intent.getBundleExtra("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
            bundleExtra.setClassLoader(AdOverlayInfoParcel.class.getClassLoader());
            return (AdOverlayInfoParcel) bundleExtra.getParcelable("com.google.android.gms.ads.inernal.overlay.AdOverlayInfo");
        } catch (Exception unused) {
            return null;
        }
    }

    public AdOverlayInfoParcel(zzxr zzxrVar, zzo zzoVar, zzu zzuVar, zzbgz zzbgzVar, int i, zzbai zzbaiVar, String str, com.google.android.gms.ads.internal.zzh zzhVar) {
        this.zzdkl = null;
        this.zzcgi = null;
        this.zzdkm = zzoVar;
        this.zzdbs = zzbgzVar;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = false;
        this.zzdkp = null;
        this.zzdkq = null;
        this.orientation = i;
        this.zzdkr = 1;
        this.url = null;
        this.zzbtc = zzbaiVar;
        this.zzdks = str;
        this.zzdkt = zzhVar;
    }

    public AdOverlayInfoParcel(zzxr zzxrVar, zzo zzoVar, zzu zzuVar, zzbgz zzbgzVar, boolean z, int i, zzbai zzbaiVar) {
        this.zzdkl = null;
        this.zzcgi = zzxrVar;
        this.zzdkm = zzoVar;
        this.zzdbs = zzbgzVar;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = z;
        this.zzdkp = null;
        this.zzdkq = zzuVar;
        this.orientation = i;
        this.zzdkr = 2;
        this.url = null;
        this.zzbtc = zzbaiVar;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzxr zzxrVar, zzo zzoVar, zzagv zzagvVar, zzagx zzagxVar, zzu zzuVar, zzbgz zzbgzVar, boolean z, int i, String str, zzbai zzbaiVar) {
        this.zzdkl = null;
        this.zzcgi = zzxrVar;
        this.zzdkm = zzoVar;
        this.zzdbs = zzbgzVar;
        this.zzczo = zzagvVar;
        this.zzczp = zzagxVar;
        this.zzdkn = null;
        this.zzdko = z;
        this.zzdkp = null;
        this.zzdkq = zzuVar;
        this.orientation = i;
        this.zzdkr = 3;
        this.url = str;
        this.zzbtc = zzbaiVar;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzxr zzxrVar, zzo zzoVar, zzagv zzagvVar, zzagx zzagxVar, zzu zzuVar, zzbgz zzbgzVar, boolean z, int i, String str, String str2, zzbai zzbaiVar) {
        this.zzdkl = null;
        this.zzcgi = zzxrVar;
        this.zzdkm = zzoVar;
        this.zzdbs = zzbgzVar;
        this.zzczo = zzagvVar;
        this.zzczp = zzagxVar;
        this.zzdkn = str2;
        this.zzdko = z;
        this.zzdkp = str;
        this.zzdkq = zzuVar;
        this.orientation = i;
        this.zzdkr = 3;
        this.url = null;
        this.zzbtc = zzbaiVar;
        this.zzdks = null;
        this.zzdkt = null;
    }

    public AdOverlayInfoParcel(zzc zzcVar, zzxr zzxrVar, zzo zzoVar, zzu zzuVar, zzbai zzbaiVar) {
        this.zzdkl = zzcVar;
        this.zzcgi = zzxrVar;
        this.zzdkm = zzoVar;
        this.zzdbs = null;
        this.zzczo = null;
        this.zzczp = null;
        this.zzdkn = null;
        this.zzdko = false;
        this.zzdkp = null;
        this.zzdkq = zzuVar;
        this.orientation = -1;
        this.zzdkr = 4;
        this.url = null;
        this.zzbtc = zzbaiVar;
        this.zzdks = null;
        this.zzdkt = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AdOverlayInfoParcel(@SafeParcelable.Param(id = 2) zzc zzcVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @SafeParcelable.Param(id = 4) IBinder iBinder2, @SafeParcelable.Param(id = 5) IBinder iBinder3, @SafeParcelable.Param(id = 6) IBinder iBinder4, @SafeParcelable.Param(id = 7) String str, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) String str2, @SafeParcelable.Param(id = 10) IBinder iBinder5, @SafeParcelable.Param(id = 11) int i, @SafeParcelable.Param(id = 12) int i2, @SafeParcelable.Param(id = 13) String str3, @SafeParcelable.Param(id = 14) zzbai zzbaiVar, @SafeParcelable.Param(id = 16) String str4, @SafeParcelable.Param(id = 17) com.google.android.gms.ads.internal.zzh zzhVar, @SafeParcelable.Param(id = 18) IBinder iBinder6) {
        this.zzdkl = zzcVar;
        this.zzcgi = (zzxr) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder));
        this.zzdkm = (zzo) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder2));
        this.zzdbs = (zzbgz) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder3));
        this.zzczo = (zzagv) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder6));
        this.zzczp = (zzagx) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder4));
        this.zzdkn = str;
        this.zzdko = z;
        this.zzdkp = str2;
        this.zzdkq = (zzu) ObjectWrapper.unwrap(IObjectWrapper.Stub.asInterface(iBinder5));
        this.orientation = i;
        this.zzdkr = i2;
        this.url = str3;
        this.zzbtc = zzbaiVar;
        this.zzdks = str4;
        this.zzdkt = zzhVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdkl, i, false);
        SafeParcelWriter.writeIBinder(parcel, 3, ObjectWrapper.wrap(this.zzcgi).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 4, ObjectWrapper.wrap(this.zzdkm).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 5, ObjectWrapper.wrap(this.zzdbs).asBinder(), false);
        SafeParcelWriter.writeIBinder(parcel, 6, ObjectWrapper.wrap(this.zzczp).asBinder(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzdkn, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdko);
        SafeParcelWriter.writeString(parcel, 9, this.zzdkp, false);
        SafeParcelWriter.writeIBinder(parcel, 10, ObjectWrapper.wrap(this.zzdkq).asBinder(), false);
        SafeParcelWriter.writeInt(parcel, 11, this.orientation);
        SafeParcelWriter.writeInt(parcel, 12, this.zzdkr);
        SafeParcelWriter.writeString(parcel, 13, this.url, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzbtc, i, false);
        SafeParcelWriter.writeString(parcel, 16, this.zzdks, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.zzdkt, i, false);
        SafeParcelWriter.writeIBinder(parcel, 18, ObjectWrapper.wrap(this.zzczo).asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
