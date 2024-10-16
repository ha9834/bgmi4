package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.support.v4.os.a;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new Parcelable.Creator<ResultReceiver>() { // from class: android.support.v4.os.ResultReceiver.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    final boolean f100a = false;
    final Handler b = null;
    android.support.v4.os.a c;

    protected void a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final int f102a;
        final Bundle b;

        b(int i, Bundle bundle) {
            this.f102a = i;
            this.b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f102a, this.b);
        }
    }

    /* loaded from: classes.dex */
    class a extends a.AbstractBinderC0018a {
        a() {
        }

        @Override // android.support.v4.os.a
        public void a(int i, Bundle bundle) {
            if (ResultReceiver.this.b != null) {
                ResultReceiver.this.b.post(new b(i, bundle));
            } else {
                ResultReceiver.this.a(i, bundle);
            }
        }
    }

    public void b(int i, Bundle bundle) {
        if (this.f100a) {
            Handler handler = this.b;
            if (handler != null) {
                handler.post(new b(i, bundle));
                return;
            } else {
                a(i, bundle);
                return;
            }
        }
        android.support.v4.os.a aVar = this.c;
        if (aVar != null) {
            try {
                aVar.a(i, bundle);
            } catch (RemoteException unused) {
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.c == null) {
                this.c = new a();
            }
            parcel.writeStrongBinder(this.c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.c = a.AbstractBinderC0018a.a(parcel.readStrongBinder());
    }
}
