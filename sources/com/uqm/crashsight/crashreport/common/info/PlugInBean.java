package com.uqm.crashsight.crashreport.common.info;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class PlugInBean implements Parcelable {
    public static final Parcelable.Creator<PlugInBean> CREATOR = new Parcelable.Creator<PlugInBean>() { // from class: com.uqm.crashsight.crashreport.common.info.PlugInBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ PlugInBean createFromParcel(Parcel parcel) {
            return new PlugInBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ PlugInBean[] newArray(int i) {
            return new PlugInBean[i];
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f6558a;
    public final String b;
    public final String c;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PlugInBean(String str, String str2, String str3) {
        this.f6558a = str;
        this.b = str2;
        this.c = str3;
    }

    public String toString() {
        return "plid:" + this.f6558a + " plV:" + this.b + " plUUID:" + this.c;
    }

    public PlugInBean(Parcel parcel) {
        this.f6558a = parcel.readString();
        this.b = parcel.readString();
        this.c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f6558a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
