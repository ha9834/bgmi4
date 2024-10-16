package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.session.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class MediaSessionCompat {
    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() { // from class: android.support.v4.media.session.MediaSessionCompat.Token.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                Object readStrongBinder;
                if (Build.VERSION.SDK_INT >= 21) {
                    readStrongBinder = parcel.readParcelable(null);
                } else {
                    readStrongBinder = parcel.readStrongBinder();
                }
                return new Token(readStrongBinder);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i) {
                return new Token[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final Object f93a;
        private b b;
        private Bundle c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        Token(Object obj, b bVar) {
            this(obj, bVar, null);
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f93a = obj;
            this.b = bVar;
            this.c = bundle;
        }

        public static Token a(Object obj) {
            return a(obj, null);
        }

        public static Token a(Object obj, b bVar) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(d.a(obj), bVar);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f93a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f93a);
            }
        }

        public int hashCode() {
            Object obj = this.f93a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f93a;
            if (obj2 == null) {
                return token.f93a == null;
            }
            Object obj3 = token.f93a;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public Object a() {
            return this.f93a;
        }

        public b b() {
            return this.b;
        }

        public void a(b bVar) {
            this.b = bVar;
        }

        public void a(Bundle bundle) {
            this.c = bundle;
        }
    }

    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() { // from class: android.support.v4.media.session.MediaSessionCompat.QueueItem.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        private final MediaDescriptionCompat f91a;
        private final long b;
        private Object c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f91a = mediaDescriptionCompat;
            this.b = j;
            this.c = obj;
        }

        QueueItem(Parcel parcel) {
            this.f91a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.b = parcel.readLong();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.f91a.writeToParcel(parcel, i);
            parcel.writeLong(this.b);
        }

        public static QueueItem a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.a(d.a.a(obj)), d.a.b(obj));
        }

        public static List<QueueItem> a(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f91a + ", Id=" + this.b + " }";
        }
    }

    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() { // from class: android.support.v4.media.session.MediaSessionCompat.ResultReceiverWrapper.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        };

        /* renamed from: a, reason: collision with root package name */
        ResultReceiver f92a;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f92a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.f92a.writeToParcel(parcel, i);
        }
    }
}
