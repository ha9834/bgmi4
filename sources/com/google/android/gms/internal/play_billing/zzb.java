package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.vending.billing.util.IabHelper;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzb extends zze implements zzd {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final int zza(int i, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeString(str);
        a2.writeString(str2);
        Parcel a3 = a(1, a2);
        int readInt = a3.readInt();
        a3.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzb(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(3);
        a2.writeString(str);
        a2.writeString(str2);
        zzg.zzb(a2, bundle);
        Parcel a3 = a(2, a2);
        Bundle bundle2 = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzc(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(3);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        a2.writeString(null);
        Parcel a3 = a(3, a2);
        Bundle bundle = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzd(int i, String str, String str2, String str3) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(3);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        Parcel a3 = a(4, a2);
        Bundle bundle = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final int zze(int i, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(3);
        a2.writeString(str);
        a2.writeString(str2);
        Parcel a3 = a(5, a2);
        int readInt = a3.readInt();
        a3.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzf(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(5);
        a2.writeString(str);
        a2.writeStringList(list);
        a2.writeString(str2);
        a2.writeString(IabHelper.ITEM_TYPE_SUBS);
        a2.writeString(null);
        Parcel a3 = a(7, a2);
        Bundle bundle = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(i);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        a2.writeString(null);
        zzg.zzb(a2, bundle);
        Parcel a3 = a(8, a2);
        Bundle bundle2 = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzh(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(6);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        zzg.zzb(a2, bundle);
        Parcel a3 = a(9, a2);
        Bundle bundle2 = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final int zzi(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(7);
        a2.writeString(str);
        a2.writeString(str2);
        zzg.zzb(a2, bundle);
        Parcel a3 = a(10, a2);
        int readInt = a3.readInt();
        a3.recycle();
        return readInt;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzj(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(8);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(IabHelper.ITEM_TYPE_SUBS);
        zzg.zzb(a2, bundle);
        Parcel a3 = a(801, a2);
        Bundle bundle2 = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzk(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(9);
        a2.writeString(str);
        a2.writeString(str2);
        a2.writeString(str3);
        zzg.zzb(a2, bundle);
        Parcel a3 = a(11, a2);
        Bundle bundle2 = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzl(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(9);
        a2.writeString(str);
        a2.writeString(str2);
        zzg.zzb(a2, bundle);
        Parcel a3 = a(12, a2);
        Bundle bundle2 = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzm(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(10);
        a2.writeString(str);
        a2.writeString(str2);
        zzg.zzb(a2, bundle);
        zzg.zzb(a2, bundle2);
        Parcel a3 = a(901, a2);
        Bundle bundle3 = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzd
    public final Bundle zzn(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel a2 = a();
        a2.writeInt(9);
        a2.writeString(str);
        a2.writeString(str2);
        zzg.zzb(a2, bundle);
        Parcel a3 = a(902, a2);
        Bundle bundle2 = (Bundle) zzg.zza(a3, Bundle.CREATOR);
        a3.recycle();
        return bundle2;
    }
}
