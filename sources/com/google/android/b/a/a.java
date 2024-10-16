package com.google.android.b.a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.a.b;
import com.google.android.a.c;

/* loaded from: classes.dex */
public interface a extends IInterface {

    /* renamed from: com.google.android.b.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0088a extends b implements a {

        /* renamed from: com.google.android.b.a.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0089a extends com.google.android.a.a implements a {
            C0089a(IBinder iBinder) {
                super(iBinder);
            }

            @Override // com.google.android.b.a.a
            public final Bundle a(Bundle bundle) throws RemoteException {
                Parcel a2 = a();
                c.a(a2, bundle);
                Parcel a3 = a(a2);
                Bundle bundle2 = (Bundle) c.a(a3, Bundle.CREATOR);
                a3.recycle();
                return bundle2;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            if (queryLocalInterface instanceof a) {
                return (a) queryLocalInterface;
            }
            return new C0089a(iBinder);
        }

        @Override // com.google.android.a.b
        protected final boolean a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            Bundle a2 = a((Bundle) c.a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            c.b(parcel2, a2);
            return true;
        }
    }

    Bundle a(Bundle bundle) throws RemoteException;
}
