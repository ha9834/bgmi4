package com.google.android.gms.internal.drive;

import android.content.IntentSender;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzep extends zza implements zzeo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.drive.internal.IDriveService");
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final IntentSender zza(zzgg zzggVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzggVar);
        Parcel a3 = a(10, a2);
        IntentSender intentSender = (IntentSender) zzc.zza(a3, IntentSender.CREATOR);
        a3.recycle();
        return intentSender;
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final IntentSender zza(zzu zzuVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzuVar);
        Parcel a3 = a(11, a2);
        IntentSender intentSender = (IntentSender) zzc.zza(a3, IntentSender.CREATOR);
        a3.recycle();
        return intentSender;
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final zzec zza(zzgd zzgdVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzgdVar);
        zzc.zza(a2, zzeqVar);
        Parcel a3 = a(7, a2);
        zzec zzecVar = (zzec) zzc.zza(a3, zzec.CREATOR);
        a3.recycle();
        return zzecVar;
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzab zzabVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzabVar);
        zzc.zza(a2, zzeqVar);
        b(24, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzad zzadVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzadVar);
        b(16, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzek zzekVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzekVar);
        zzc.zza(a2, zzeqVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzeqVar);
        b(9, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzex zzexVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzexVar);
        zzc.zza(a2, zzeqVar);
        b(13, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgk zzgkVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzgkVar);
        zzc.zza(a2, zzeqVar);
        b(2, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgm zzgmVar, zzes zzesVar, String str, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzgmVar);
        zzc.zza(a2, zzesVar);
        a2.writeString(null);
        zzc.zza(a2, zzeqVar);
        b(15, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgo zzgoVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzgoVar);
        zzc.zza(a2, zzeqVar);
        b(36, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgq zzgqVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzgqVar);
        zzc.zza(a2, zzeqVar);
        b(28, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgv zzgvVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzgvVar);
        zzc.zza(a2, zzeqVar);
        b(17, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgx zzgxVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzgxVar);
        zzc.zza(a2, zzeqVar);
        b(38, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzgz zzgzVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzgzVar);
        zzc.zza(a2, zzeqVar);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzj zzjVar, zzes zzesVar, String str, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzjVar);
        zzc.zza(a2, zzesVar);
        a2.writeString(null);
        zzc.zza(a2, zzeqVar);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzm zzmVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzmVar);
        zzc.zza(a2, zzeqVar);
        b(18, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzo zzoVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzoVar);
        zzc.zza(a2, zzeqVar);
        b(8, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzr zzrVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzrVar);
        zzc.zza(a2, zzeqVar);
        b(4, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzw zzwVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzwVar);
        zzc.zza(a2, zzeqVar);
        b(5, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zza(zzy zzyVar, zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzyVar);
        zzc.zza(a2, zzeqVar);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.drive.zzeo
    public final void zzb(zzeq zzeqVar) throws RemoteException {
        Parcel a2 = a();
        zzc.zza(a2, zzeqVar);
        b(35, a2);
    }
}
