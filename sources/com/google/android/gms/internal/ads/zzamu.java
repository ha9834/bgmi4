package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzamu extends zzfm implements zzams {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzamu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzydVar);
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        zzfo.zza(a2, zzamvVar);
        b(1, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final IObjectWrapper zzse() throws RemoteException {
        Parcel a2 = a(2, a());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
        a2.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        zzfo.zza(a2, zzamvVar);
        b(3, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showInterstitial() throws RemoteException {
        b(4, a());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void destroy() throws RemoteException {
        b(5, a());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzyd zzydVar, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzydVar);
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        a2.writeString(str2);
        zzfo.zza(a2, zzamvVar);
        b(6, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        a2.writeString(str2);
        zzfo.zza(a2, zzamvVar);
        b(7, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void pause() throws RemoteException {
        b(8, a());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void resume() throws RemoteException {
        b(9, a());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzatk zzatkVar, String str2) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        zzfo.zza(a2, zzatkVar);
        a2.writeString(str2);
        b(10, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(zzxz zzxzVar, String str) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        b(11, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void showVideo() throws RemoteException {
        b(12, a());
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean isInitialized() throws RemoteException {
        Parcel a2 = a(13, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, String str2, zzamv zzamvVar, zzady zzadyVar, List<String> list) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        a2.writeString(str2);
        zzfo.zza(a2, zzamvVar);
        zzfo.zza(a2, zzadyVar);
        a2.writeStringList(list);
        b(14, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzana zzsf() throws RemoteException {
        zzana zzancVar;
        Parcel a2 = a(15, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzancVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            if (queryLocalInterface instanceof zzana) {
                zzancVar = (zzana) queryLocalInterface;
            } else {
                zzancVar = new zzanc(readStrongBinder);
            }
        }
        a2.recycle();
        return zzancVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzand zzsg() throws RemoteException {
        zzand zzanfVar;
        Parcel a2 = a(16, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzanfVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            if (queryLocalInterface instanceof zzand) {
                zzanfVar = (zzand) queryLocalInterface;
            } else {
                zzanfVar = new zzanf(readStrongBinder);
            }
        }
        a2.recycle();
        return zzanfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zzsh() throws RemoteException {
        Parcel a2 = a(17, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle getInterstitialAdapterInfo() throws RemoteException {
        Parcel a2 = a(18, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final Bundle zzsi() throws RemoteException {
        Parcel a2 = a(19, a());
        Bundle bundle = (Bundle) zzfo.zza(a2, Bundle.CREATOR);
        a2.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(zzxz zzxzVar, String str, String str2) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        a2.writeString(str2);
        b(20, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(21, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final boolean zzsj() throws RemoteException {
        Parcel a2 = a(22, a());
        boolean zza = zzfo.zza(a2);
        a2.recycle();
        return zza;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzatk zzatkVar, List<String> list) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzatkVar);
        a2.writeStringList(list);
        b(23, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzafe zzsk() throws RemoteException {
        Parcel a2 = a(24, a());
        zzafe zzn = zzaff.zzn(a2.readStrongBinder());
        a2.recycle();
        return zzn;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void setImmersiveMode(boolean z) throws RemoteException {
        Parcel a2 = a();
        zzfo.writeBoolean(a2, z);
        b(25, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzaar getVideoController() throws RemoteException {
        Parcel a2 = a(26, a());
        zzaar zzh = zzaas.zzh(a2.readStrongBinder());
        a2.recycle();
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final zzang zzsl() throws RemoteException {
        zzang zzaniVar;
        Parcel a2 = a(27, a());
        IBinder readStrongBinder = a2.readStrongBinder();
        if (readStrongBinder == null) {
            zzaniVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            if (queryLocalInterface instanceof zzang) {
                zzaniVar = (zzang) queryLocalInterface;
            } else {
                zzaniVar = new zzani(readStrongBinder);
            }
        }
        a2.recycle();
        return zzaniVar;
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzb(IObjectWrapper iObjectWrapper, zzxz zzxzVar, String str, zzamv zzamvVar) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzxzVar);
        a2.writeString(str);
        zzfo.zza(a2, zzamvVar);
        b(28, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        b(30, a2);
    }

    @Override // com.google.android.gms.internal.ads.zzams
    public final void zza(IObjectWrapper iObjectWrapper, zzaiq zzaiqVar, List<zzaiw> list) throws RemoteException {
        Parcel a2 = a();
        zzfo.zza(a2, iObjectWrapper);
        zzfo.zza(a2, zzaiqVar);
        a2.writeTypedList(list);
        b(31, a2);
    }
}
