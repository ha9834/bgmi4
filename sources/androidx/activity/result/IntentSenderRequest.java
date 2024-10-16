package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new Parcelable.Creator<IntentSenderRequest>() { // from class: androidx.activity.result.IntentSenderRequest.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i) {
            return new IntentSenderRequest[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final IntentSender f129a;
    private final Intent b;
    private final int c;
    private final int d;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    IntentSenderRequest(IntentSender intentSender, Intent intent, int i, int i2) {
        this.f129a = intentSender;
        this.b = intent;
        this.c = i;
        this.d = i2;
    }

    public IntentSender a() {
        return this.f129a;
    }

    public Intent b() {
        return this.b;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    IntentSenderRequest(Parcel parcel) {
        this.f129a = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.b = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.c = parcel.readInt();
        this.d = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f129a, i);
        parcel.writeParcelable(this.b, i);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
    }

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private IntentSender f130a;
        private Intent b;
        private int c;
        private int d;

        public a(IntentSender intentSender) {
            this.f130a = intentSender;
        }

        public a a(Intent intent) {
            this.b = intent;
            return this;
        }

        public a a(int i, int i2) {
            this.d = i;
            this.c = i2;
            return this;
        }

        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.f130a, this.b, this.c, this.d);
        }
    }
}
