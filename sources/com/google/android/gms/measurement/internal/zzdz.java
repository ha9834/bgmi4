package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzd;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdz extends zzb implements zzdx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzai zzaiVar, zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzaiVar);
        zzd.zza(a2, zznVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzjn zzjnVar, zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzjnVar);
        zzd.zza(a2, zznVar);
        b(2, a2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zznVar);
        b(4, a2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzai zzaiVar, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzaiVar);
        a2.writeString(str);
        a2.writeString(str2);
        b(5, a2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzb(zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zznVar);
        b(6, a2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzjn> zza(zzn zznVar, boolean z) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zznVar);
        zzd.writeBoolean(a2, z);
        Parcel a3 = a(7, a2);
        ArrayList createTypedArrayList = a3.createTypedArrayList(zzjn.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final byte[] zza(zzai zzaiVar, String str) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzaiVar);
        a2.writeString(str);
        Parcel a3 = a(9, a2);
        byte[] createByteArray = a3.createByteArray();
        a3.recycle();
        return createByteArray;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel a2 = a();
        a2.writeLong(j);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        b(10, a2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final String zzc(zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zznVar);
        Parcel a3 = a(11, a2);
        String readString = a3.readString();
        a3.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zza(zzq zzqVar, zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzqVar);
        zzd.zza(a2, zznVar);
        b(12, a2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzb(zzq zzqVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zzqVar);
        b(13, a2);
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzjn> zza(String str, String str2, boolean z, zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.writeBoolean(a2, z);
        zzd.zza(a2, zznVar);
        Parcel a3 = a(14, a2);
        ArrayList createTypedArrayList = a3.createTypedArrayList(zzjn.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzjn> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        zzd.writeBoolean(a2, z);
        Parcel a3 = a(15, a2);
        ArrayList createTypedArrayList = a3.createTypedArrayList(zzjn.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzq> zza(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzd.zza(a2, zznVar);
        Parcel a3 = a(16, a2);
        ArrayList createTypedArrayList = a3.createTypedArrayList(zzq.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final List<zzq> zzc(String str, String str2, String str3) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        Parcel a3 = a(17, a2);
        ArrayList createTypedArrayList = a3.createTypedArrayList(zzq.CREATOR);
        a3.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzdx
    public final void zzd(zzn zznVar) throws RemoteException {
        Parcel a2 = a();
        zzd.zza(a2, zznVar);
        b(18, a2);
    }
}
