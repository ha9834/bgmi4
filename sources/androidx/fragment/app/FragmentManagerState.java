package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class FragmentManagerState implements Parcelable {
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() { // from class: androidx.fragment.app.FragmentManagerState.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState createFromParcel(Parcel parcel) {
            return new FragmentManagerState(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FragmentManagerState[] newArray(int i) {
            return new FragmentManagerState[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    ArrayList<FragmentState> f627a;
    ArrayList<String> b;
    BackStackState[] c;
    int d;
    String e;
    ArrayList<String> f;
    ArrayList<Bundle> g;
    ArrayList<FragmentManager.LaunchedFragmentInfo> h;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FragmentManagerState() {
        this.e = null;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
    }

    public FragmentManagerState(Parcel parcel) {
        this.e = null;
        this.f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.f627a = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.b = parcel.createStringArrayList();
        this.c = (BackStackState[]) parcel.createTypedArray(BackStackState.CREATOR);
        this.d = parcel.readInt();
        this.e = parcel.readString();
        this.f = parcel.createStringArrayList();
        this.g = parcel.createTypedArrayList(Bundle.CREATOR);
        this.h = parcel.createTypedArrayList(FragmentManager.LaunchedFragmentInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f627a);
        parcel.writeStringList(this.b);
        parcel.writeTypedArray(this.c, i);
        parcel.writeInt(this.d);
        parcel.writeString(this.e);
        parcel.writeStringList(this.f);
        parcel.writeTypedList(this.g);
        parcel.writeTypedList(this.h);
    }
}
