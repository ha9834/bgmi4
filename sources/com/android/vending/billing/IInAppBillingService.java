package com.android.vending.billing;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* loaded from: classes.dex */
public interface IInAppBillingService extends IInterface {

    /* loaded from: classes.dex */
    public static class Default implements IInAppBillingService {
        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle acknowledgePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public int consumePurchase(int i, String str, String str2) throws RemoteException {
            return 0;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle consumePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getPurchasesExtraParams(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getSkuDetailsExtraParams(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public Bundle getSubscriptionManagementIntent(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
            return null;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public int isBillingSupported(int i, String str, String str2) throws RemoteException {
            return 0;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
            return 0;
        }

        @Override // com.android.vending.billing.IInAppBillingService
        public int stub(int i, String str, String str2) throws RemoteException {
            return 0;
        }
    }

    Bundle acknowledgePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int consumePurchase(int i, String str, String str2) throws RemoteException;

    Bundle consumePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException;

    Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException;

    Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException;

    Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException;

    Bundle getPurchasesExtraParams(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException;

    Bundle getSkuDetailsExtraParams(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException;

    Bundle getSubscriptionManagementIntent(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException;

    int isBillingSupported(int i, String str, String str2) throws RemoteException;

    int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException;

    int stub(int i, String str, String str2) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class Stub extends Binder implements IInAppBillingService {
        private static final String DESCRIPTOR = "com.android.vending.billing.IInAppBillingService";
        static final int TRANSACTION_acknowledgePurchaseExtraParams = 902;
        static final int TRANSACTION_consumePurchase = 5;
        static final int TRANSACTION_consumePurchaseExtraParams = 12;
        static final int TRANSACTION_getBuyIntent = 3;
        static final int TRANSACTION_getBuyIntentExtraParams = 8;
        static final int TRANSACTION_getBuyIntentToReplaceSkus = 7;
        static final int TRANSACTION_getPurchaseHistory = 9;
        static final int TRANSACTION_getPurchases = 4;
        static final int TRANSACTION_getPurchasesExtraParams = 11;
        static final int TRANSACTION_getSkuDetails = 2;
        static final int TRANSACTION_getSkuDetailsExtraParams = 901;
        static final int TRANSACTION_getSubscriptionManagementIntent = 801;
        static final int TRANSACTION_isBillingSupported = 1;
        static final int TRANSACTION_isBillingSupportedExtraParams = 10;
        static final int TRANSACTION_stub = 6;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IInAppBillingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IInAppBillingService)) {
                return (IInAppBillingService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 801) {
                parcel.enforceInterface(DESCRIPTOR);
                Bundle subscriptionManagementIntent = getSubscriptionManagementIntent(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (subscriptionManagementIntent != null) {
                    parcel2.writeInt(1);
                    subscriptionManagementIntent.writeToParcel(parcel2, 1);
                } else {
                    parcel2.writeInt(0);
                }
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    int isBillingSupported = isBillingSupported(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(isBillingSupported);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle skuDetails = getSkuDetails(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (skuDetails != null) {
                        parcel2.writeInt(1);
                        skuDetails.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle buyIntent = getBuyIntent(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (buyIntent != null) {
                        parcel2.writeInt(1);
                        buyIntent.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle purchases = getPurchases(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (purchases != null) {
                        parcel2.writeInt(1);
                        purchases.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    int consumePurchase = consumePurchase(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(consumePurchase);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    int stub = stub(parcel.readInt(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(stub);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle buyIntentToReplaceSkus = getBuyIntentToReplaceSkus(parcel.readInt(), parcel.readString(), parcel.createStringArrayList(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    if (buyIntentToReplaceSkus != null) {
                        parcel2.writeInt(1);
                        buyIntentToReplaceSkus.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle buyIntentExtraParams = getBuyIntentExtraParams(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (buyIntentExtraParams != null) {
                        parcel2.writeInt(1);
                        buyIntentExtraParams.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle purchaseHistory = getPurchaseHistory(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (purchaseHistory != null) {
                        parcel2.writeInt(1);
                        purchaseHistory.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    int isBillingSupportedExtraParams = isBillingSupportedExtraParams(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(isBillingSupportedExtraParams);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle purchasesExtraParams = getPurchasesExtraParams(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (purchasesExtraParams != null) {
                        parcel2.writeInt(1);
                        purchasesExtraParams.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    Bundle consumePurchaseExtraParams = consumePurchaseExtraParams(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (consumePurchaseExtraParams != null) {
                        parcel2.writeInt(1);
                        consumePurchaseExtraParams.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                default:
                    switch (i) {
                        case 901:
                            parcel.enforceInterface(DESCRIPTOR);
                            Bundle skuDetailsExtraParams = getSkuDetailsExtraParams(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            if (skuDetailsExtraParams != null) {
                                parcel2.writeInt(1);
                                skuDetailsExtraParams.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        case 902:
                            parcel.enforceInterface(DESCRIPTOR);
                            Bundle acknowledgePurchaseExtraParams = acknowledgePurchaseExtraParams(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                            parcel2.writeNoException();
                            if (acknowledgePurchaseExtraParams != null) {
                                parcel2.writeInt(1);
                                acknowledgePurchaseExtraParams.writeToParcel(parcel2, 1);
                            } else {
                                parcel2.writeInt(0);
                            }
                            return true;
                        default:
                            return super.onTransact(i, parcel, parcel2, i2);
                    }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class Proxy implements IInAppBillingService {
            public static IInAppBillingService sDefaultImpl;
            private IBinder mRemote;

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public int isBillingSupported(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isBillingSupported(i, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getSkuDetails(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(2, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSkuDetails(i, str, str2, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getBuyIntent(int i, String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (!this.mRemote.transact(3, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getBuyIntent(i, str, str2, str3, str4);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getPurchases(int i, String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (!this.mRemote.transact(4, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPurchases(i, str, str2, str3);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public int consumePurchase(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(5, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().consumePurchase(i, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public int stub(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (!this.mRemote.transact(6, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().stub(i, str, str2);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getBuyIntentToReplaceSkus(int i, String str, List<String> list, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStringList(list);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    try {
                        if (!this.mRemote.transact(7, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Bundle buyIntentToReplaceSkus = Stub.getDefaultImpl().getBuyIntentToReplaceSkus(i, str, list, str2, str3, str4);
                            obtain2.recycle();
                            obtain.recycle();
                            return buyIntentToReplaceSkus;
                        }
                        obtain2.readException();
                        Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                        obtain2.recycle();
                        obtain.recycle();
                        return bundle;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getBuyIntentExtraParams(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
                Proxy proxy;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                        proxy = this;
                    } else {
                        obtain.writeInt(0);
                        proxy = this;
                    }
                    try {
                        if (!proxy.mRemote.transact(8, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                            Bundle buyIntentExtraParams = Stub.getDefaultImpl().getBuyIntentExtraParams(i, str, str2, str3, str4, bundle);
                            obtain2.recycle();
                            obtain.recycle();
                            return buyIntentExtraParams;
                        }
                        obtain2.readException();
                        Bundle bundle2 = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                        obtain2.recycle();
                        obtain.recycle();
                        return bundle2;
                    } catch (Throwable th) {
                        th = th;
                        obtain2.recycle();
                        obtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getPurchaseHistory(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(9, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPurchaseHistory(i, str, str2, str3, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public int isBillingSupportedExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(10, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().isBillingSupportedExtraParams(i, str, str2, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getSubscriptionManagementIntent(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(801, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSubscriptionManagementIntent(i, str, str2, str3, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getPurchasesExtraParams(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(11, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getPurchasesExtraParams(i, str, str2, str3, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle consumePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(12, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().consumePurchaseExtraParams(i, str, str2, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle getSkuDetailsExtraParams(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (bundle2 != null) {
                        obtain.writeInt(1);
                        bundle2.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(901, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getSkuDetailsExtraParams(i, str, str2, bundle, bundle2);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.android.vending.billing.IInAppBillingService
            public Bundle acknowledgePurchaseExtraParams(int i, String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.mRemote.transact(902, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().acknowledgePurchaseExtraParams(i, str, str2, bundle);
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static boolean setDefaultImpl(IInAppBillingService iInAppBillingService) {
            if (Proxy.sDefaultImpl != null || iInAppBillingService == null) {
                return false;
            }
            Proxy.sDefaultImpl = iInAppBillingService;
            return true;
        }

        public static IInAppBillingService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }
    }
}
