package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

/* loaded from: classes.dex */
public interface IFragmentWrapper extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class Stub extends zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        /* loaded from: classes.dex */
        public static class zza extends com.google.android.gms.internal.common.zza implements IFragmentWrapper {
            zza(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamic.IFragmentWrapper");
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zzae() throws RemoteException {
                Parcel a2 = a(2, a());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
                a2.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final Bundle getArguments() throws RemoteException {
                Parcel a2 = a(3, a());
                Bundle bundle = (Bundle) zzc.zza(a2, Bundle.CREATOR);
                a2.recycle();
                return bundle;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int getId() throws RemoteException {
                Parcel a2 = a(4, a());
                int readInt = a2.readInt();
                a2.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IFragmentWrapper zzaf() throws RemoteException {
                Parcel a2 = a(5, a());
                IFragmentWrapper asInterface = Stub.asInterface(a2.readStrongBinder());
                a2.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zzag() throws RemoteException {
                Parcel a2 = a(6, a());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
                a2.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean getRetainInstance() throws RemoteException {
                Parcel a2 = a(7, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final String getTag() throws RemoteException {
                Parcel a2 = a(8, a());
                String readString = a2.readString();
                a2.recycle();
                return readString;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IFragmentWrapper zzah() throws RemoteException {
                Parcel a2 = a(9, a());
                IFragmentWrapper asInterface = Stub.asInterface(a2.readStrongBinder());
                a2.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final int getTargetRequestCode() throws RemoteException {
                Parcel a2 = a(10, a());
                int readInt = a2.readInt();
                a2.recycle();
                return readInt;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean getUserVisibleHint() throws RemoteException {
                Parcel a2 = a(11, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final IObjectWrapper zzai() throws RemoteException {
                Parcel a2 = a(12, a());
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(a2.readStrongBinder());
                a2.recycle();
                return asInterface;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isAdded() throws RemoteException {
                Parcel a2 = a(13, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isDetached() throws RemoteException {
                Parcel a2 = a(14, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isHidden() throws RemoteException {
                Parcel a2 = a(15, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isInLayout() throws RemoteException {
                Parcel a2 = a(16, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isRemoving() throws RemoteException {
                Parcel a2 = a(17, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isResumed() throws RemoteException {
                Parcel a2 = a(18, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final boolean isVisible() throws RemoteException {
                Parcel a2 = a(19, a());
                boolean zza = zzc.zza(a2);
                a2.recycle();
                return zza;
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zza(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel a2 = a();
                zzc.zza(a2, iObjectWrapper);
                b(20, a2);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void setHasOptionsMenu(boolean z) throws RemoteException {
                Parcel a2 = a();
                zzc.writeBoolean(a2, z);
                b(21, a2);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void setMenuVisibility(boolean z) throws RemoteException {
                Parcel a2 = a();
                zzc.writeBoolean(a2, z);
                b(22, a2);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void setRetainInstance(boolean z) throws RemoteException {
                Parcel a2 = a();
                zzc.writeBoolean(a2, z);
                b(23, a2);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void setUserVisibleHint(boolean z) throws RemoteException {
                Parcel a2 = a();
                zzc.writeBoolean(a2, z);
                b(24, a2);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void startActivity(Intent intent) throws RemoteException {
                Parcel a2 = a();
                zzc.zza(a2, intent);
                b(25, a2);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void startActivityForResult(Intent intent, int i) throws RemoteException {
                Parcel a2 = a();
                zzc.zza(a2, intent);
                a2.writeInt(i);
                b(26, a2);
            }

            @Override // com.google.android.gms.dynamic.IFragmentWrapper
            public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
                Parcel a2 = a();
                zzc.zza(a2, iObjectWrapper);
                b(27, a2);
            }
        }

        public static IFragmentWrapper asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IFragmentWrapper");
            if (queryLocalInterface instanceof IFragmentWrapper) {
                return (IFragmentWrapper) queryLocalInterface;
            }
            return new zza(iBinder);
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean a(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 2:
                    IObjectWrapper zzae = zzae();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzae);
                    return true;
                case 3:
                    Bundle arguments = getArguments();
                    parcel2.writeNoException();
                    zzc.zzb(parcel2, arguments);
                    return true;
                case 4:
                    int id = getId();
                    parcel2.writeNoException();
                    parcel2.writeInt(id);
                    return true;
                case 5:
                    IFragmentWrapper zzaf = zzaf();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzaf);
                    return true;
                case 6:
                    IObjectWrapper zzag = zzag();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzag);
                    return true;
                case 7:
                    boolean retainInstance = getRetainInstance();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, retainInstance);
                    return true;
                case 8:
                    String tag = getTag();
                    parcel2.writeNoException();
                    parcel2.writeString(tag);
                    return true;
                case 9:
                    IFragmentWrapper zzah = zzah();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzah);
                    return true;
                case 10:
                    int targetRequestCode = getTargetRequestCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(targetRequestCode);
                    return true;
                case 11:
                    boolean userVisibleHint = getUserVisibleHint();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, userVisibleHint);
                    return true;
                case 12:
                    IObjectWrapper zzai = zzai();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, zzai);
                    return true;
                case 13:
                    boolean isAdded = isAdded();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isAdded);
                    return true;
                case 14:
                    boolean isDetached = isDetached();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isDetached);
                    return true;
                case 15:
                    boolean isHidden = isHidden();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isHidden);
                    return true;
                case 16:
                    boolean isInLayout = isInLayout();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isInLayout);
                    return true;
                case 17:
                    boolean isRemoving = isRemoving();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isRemoving);
                    return true;
                case 18:
                    boolean isResumed = isResumed();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isResumed);
                    return true;
                case 19:
                    boolean isVisible = isVisible();
                    parcel2.writeNoException();
                    zzc.writeBoolean(parcel2, isVisible);
                    return true;
                case 20:
                    zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 21:
                    setHasOptionsMenu(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 22:
                    setMenuVisibility(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 23:
                    setRetainInstance(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 24:
                    setUserVisibleHint(zzc.zza(parcel));
                    parcel2.writeNoException();
                    return true;
                case 25:
                    startActivity((Intent) zzc.zza(parcel, Intent.CREATOR));
                    parcel2.writeNoException();
                    return true;
                case 26:
                    startActivityForResult((Intent) zzc.zza(parcel, Intent.CREATOR), parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 27:
                    zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    Bundle getArguments() throws RemoteException;

    int getId() throws RemoteException;

    boolean getRetainInstance() throws RemoteException;

    String getTag() throws RemoteException;

    int getTargetRequestCode() throws RemoteException;

    boolean getUserVisibleHint() throws RemoteException;

    boolean isAdded() throws RemoteException;

    boolean isDetached() throws RemoteException;

    boolean isHidden() throws RemoteException;

    boolean isInLayout() throws RemoteException;

    boolean isRemoving() throws RemoteException;

    boolean isResumed() throws RemoteException;

    boolean isVisible() throws RemoteException;

    void setHasOptionsMenu(boolean z) throws RemoteException;

    void setMenuVisibility(boolean z) throws RemoteException;

    void setRetainInstance(boolean z) throws RemoteException;

    void setUserVisibleHint(boolean z) throws RemoteException;

    void startActivity(Intent intent) throws RemoteException;

    void startActivityForResult(Intent intent, int i) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzae() throws RemoteException;

    IFragmentWrapper zzaf() throws RemoteException;

    IObjectWrapper zzag() throws RemoteException;

    IFragmentWrapper zzah() throws RemoteException;

    IObjectWrapper zzai() throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper) throws RemoteException;
}
