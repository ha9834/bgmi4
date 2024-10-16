package android.os;

/* loaded from: classes.dex */
public interface a extends IInterface {
    void sendResult(Bundle bundle);

    /* renamed from: android.os.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0004a extends Binder implements a {
        private static final String DESCRIPTOR = "android.os.IRemoteCallback";
        static final int TRANSACTION_sendResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0004a() {
            attachInterface(this, DESCRIPTOR);
        }

        public static a asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0005a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i == 1598968902) {
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                }
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel.enforceInterface(DESCRIPTOR);
            sendResult(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }

        /* renamed from: android.os.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C0005a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f57a;

            C0005a(IBinder iBinder) {
                this.f57a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f57a;
            }

            @Override // android.os.a
            public void sendResult(Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0004a.DESCRIPTOR);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f57a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
