package androidx.versionedparcelable;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() { // from class: androidx.versionedparcelable.ParcelImpl.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final c f918a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ParcelImpl(Parcel parcel) {
        this.f918a = new b(parcel).j();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new b(parcel).a(this.f918a);
    }
}
