package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public interface a extends IInterface {
    void a() throws RemoteException;

    void a(int i) throws RemoteException;

    void a(Bundle bundle) throws RemoteException;

    void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void a(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void a(CharSequence charSequence) throws RemoteException;

    void a(String str, Bundle bundle) throws RemoteException;

    void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void a(boolean z) throws RemoteException;

    void b() throws RemoteException;

    void b(int i) throws RemoteException;

    void b(boolean z) throws RemoteException;

    /* renamed from: android.support.v4.media.session.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0014a extends Binder implements a {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public AbstractBinderC0014a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C0015a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a();
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 4:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                    return true;
                case 6:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 7:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 8:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 9:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.readInt());
                    return true;
                case 10:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    a(parcel.readInt() != 0);
                    return true;
                case 11:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    b(parcel.readInt() != 0);
                    return true;
                case 12:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    b(parcel.readInt());
                    return true;
                case 13:
                    parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                    b();
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0015a implements a {

            /* renamed from: a, reason: collision with root package name */
            private IBinder f97a;

            C0015a(IBinder iBinder) {
                this.f97a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f97a;
            }

            @Override // android.support.v4.media.session.a
            public void a(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f97a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.f97a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (playbackStateCompat != null) {
                        obtain.writeInt(1);
                        playbackStateCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f97a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (mediaMetadataCompat != null) {
                        obtain.writeInt(1);
                        mediaMetadataCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f97a.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeTypedList(list);
                    this.f97a.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(CharSequence charSequence) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (charSequence != null) {
                        obtain.writeInt(1);
                        TextUtils.writeToParcel(charSequence, obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f97a.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f97a.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (parcelableVolumeInfo != null) {
                        obtain.writeInt(1);
                        parcelableVolumeInfo.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f97a.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(i);
                    this.f97a.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void a(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(z ? 1 : 0);
                    this.f97a.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void b(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(z ? 1 : 0);
                    this.f97a.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void b(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(i);
                    this.f97a.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.a
            public void b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    this.f97a.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
