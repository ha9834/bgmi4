package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* loaded from: classes2.dex */
public final class zzaox extends zzfm implements zzaov {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaox(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyd zzydVar, zzaoy zzaoyVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        a2.writeString(str);
        zzfo.zza(a2, bundle);
        zzfo.zza(a2, bundle2);
        zzfo.zza(a2, zzydVar);
        zzfo.zza(a2, zzaoyVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj zzsx() throws RemoteException {
        Parcel a2 = a(2, a());
        zzapj zzapjVar = (zzapj) zzfo.zza(a2, zzapj.CREATOR);
        a2.recycle();
        return zzapjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzapj zzsy() throws RemoteException {
        Parcel a2 = a(3, a());
        zzapj zzapjVar = (zzapj) zzfo.zza(a2, zzapj.CREATOR);
        a2.recycle();
        return zzapjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final zzaar getVideoController() throws RemoteException {
        Parcel a2 = a(5, a());
        zzaar zzh = zzaas.zzh(a2.readStrongBinder());
        a2.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zzx(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String[] strArr, Bundle[] bundleArr) throws RemoteException {
        Parcel a2 = a();
        a2.writeStringArray(strArr);
        a2.writeTypedArray(bundleArr, 0);
        b(11, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaoj zzaojVar, zzamv zzamvVar, zzyd zzydVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzfo.zza(a2, zzxzVar);
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzaojVar);
        zzfo.zza(a2, zzamvVar);
        zzfo.zza(a2, zzydVar);
        b(13, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaom zzaomVar, zzamv zzamvVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzfo.zza(a2, zzxzVar);
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzaomVar);
        zzfo.zza(a2, zzamvVar);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(15, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaos zzaosVar, zzamv zzamvVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzfo.zza(a2, zzxzVar);
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzaosVar);
        zzfo.zza(a2, zzamvVar);
        b(16, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final boolean zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        Parcel a3 = a(17, a2);
        boolean zza = zzfo.zza(a3);
        a3.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzaov
    public final void zza(String str, String str2, zzxz zzxzVar, IObjectWrapper iObjectWrapper, zzaop zzaopVar, zzamv zzamvVar) throws RemoteException {
        Parcel a2 = a();
        a2.writeString(str);
        a2.writeString(str2);
        zzfo.zza(a2, zzxzVar);
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzaopVar);
        zzfo.zza(a2, zzamvVar);
        b(18, a2);
    }
}
