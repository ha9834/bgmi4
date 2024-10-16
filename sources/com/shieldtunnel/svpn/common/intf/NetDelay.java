package com.shieldtunnel.svpn.common.intf;

import android.os.Parcel;
import android.os.Parcelable;
import com.shieldtunnel.svpn.common.f.f;

/* loaded from: classes2.dex */
public class NetDelay implements Parcelable {
    public static final Parcelable.Creator<NetDelay> CREATOR = new Parcelable.Creator<NetDelay>() { // from class: com.shieldtunnel.svpn.common.intf.NetDelay.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetDelay createFromParcel(Parcel parcel) {
            return new NetDelay(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NetDelay[] newArray(int i) {
            return new NetDelay[i];
        }
    };
    private final int average;
    private final int lostPercent;
    private final int variance;

    public NetDelay(int i, int i2, int i3) {
        this.average = i;
        this.variance = i2;
        this.lostPercent = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NetDelay)) {
            return false;
        }
        NetDelay netDelay = (NetDelay) obj;
        return this.average == netDelay.average && this.variance == netDelay.variance && this.lostPercent == netDelay.lostPercent;
    }

    public int getAverage() {
        return this.average;
    }

    public int getLostPercent() {
        return this.lostPercent;
    }

    public int getVariance() {
        return this.variance;
    }

    public int hashCode() {
        return (this.lostPercent << 24) | (this.average << 16) | this.variance;
    }

    public String toString() {
        return String.format(f.b, "[a=%d,v=%d,l=%d]", Integer.valueOf(this.average), Integer.valueOf(this.variance), Integer.valueOf(this.lostPercent));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.average);
        parcel.writeInt(this.variance);
        parcel.writeInt(this.lostPercent);
    }

    protected NetDelay(Parcel parcel) {
        this.average = parcel.readInt();
        this.variance = parcel.readInt();
        this.lostPercent = parcel.readInt();
    }
}
