package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes2.dex */
public class zzm implements Parcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzl();
    private Messenger zzao;
    private zzu zzap;

    /* loaded from: classes2.dex */
    public static final class zza extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                if (FirebaseInstanceId.zzm()) {
                    Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
                    return zzm.class;
                }
                return zzm.class;
            }
            return super.loadClass(str, z);
        }
    }

    public zzm(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.zzao = new Messenger(iBinder);
        } else {
            this.zzap = new zzw(iBinder);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final void send(Message message) throws RemoteException {
        Messenger messenger = this.zzao;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzap.send(message);
        }
    }

    private final IBinder getBinder() {
        Messenger messenger = this.zzao;
        return messenger != null ? messenger.getBinder() : this.zzap.asBinder();
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return getBinder().equals(((zzm) obj).getBinder());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Messenger messenger = this.zzao;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzap.asBinder());
        }
    }
}
