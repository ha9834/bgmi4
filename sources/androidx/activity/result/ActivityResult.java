package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new Parcelable.Creator<ActivityResult>() { // from class: androidx.activity.result.ActivityResult.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResult[] newArray(int i) {
            return new ActivityResult[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f127a;
    private final Intent b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityResult(int i, Intent intent) {
        this.f127a = i;
        this.b = intent;
    }

    ActivityResult(Parcel parcel) {
        this.f127a = parcel.readInt();
        this.b = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }

    public int a() {
        return this.f127a;
    }

    public Intent b() {
        return this.b;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + a(this.f127a) + ", data=" + this.b + '}';
    }

    public static String a(int i) {
        switch (i) {
            case -1:
                return "RESULT_OK";
            case 0:
                return "RESULT_CANCELED";
            default:
                return String.valueOf(i);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f127a);
        parcel.writeInt(this.b == null ? 0 : 1);
        Intent intent = this.b;
        if (intent != null) {
            intent.writeToParcel(parcel, i);
        }
    }
}
