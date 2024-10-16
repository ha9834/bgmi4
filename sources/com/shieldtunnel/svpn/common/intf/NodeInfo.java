package com.shieldtunnel.svpn.common.intf;

import android.os.Parcel;
import android.os.Parcelable;
import com.shieldtunnel.svpn.common.c;
import com.shieldtunnel.svpn.common.f.f;
import com.shieldtunnel.svpn.common.k.e;
import java.util.List;

/* loaded from: classes2.dex */
public class NodeInfo implements Parcelable {
    public static final Parcelable.Creator<NodeInfo> CREATOR = new Parcelable.Creator<NodeInfo>() { // from class: com.shieldtunnel.svpn.common.intf.NodeInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NodeInfo createFromParcel(Parcel parcel) {
            return new NodeInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NodeInfo[] newArray(int i) {
            return new NodeInfo[i];
        }
    };
    private final String area;
    private final int flags;
    private final int id;
    private final String region;
    private final List<String> tags;

    public NodeInfo(int i, int i2, String str, String str2, List<String> list) {
        this.id = i;
        this.flags = i2;
        this.region = str;
        this.area = str2;
        this.tags = list;
    }

    private boolean isTagsEqual(NodeInfo nodeInfo) {
        List<String> list = this.tags;
        List<String> list2 = nodeInfo.tags;
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != nodeInfo.tags.size()) {
            return false;
        }
        int size = this.tags.size();
        for (int i = 0; i < size; i++) {
            if (!c.a(this.tags.get(i), nodeInfo.tags.get(i))) {
                return false;
            }
        }
        return true;
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
        if (!(obj instanceof NodeInfo)) {
            return false;
        }
        NodeInfo nodeInfo = (NodeInfo) obj;
        return this.id == nodeInfo.id && this.flags == nodeInfo.flags && c.a(this.region, nodeInfo.region) && c.a(this.area, nodeInfo.area) && isTagsEqual(nodeInfo);
    }

    public String getArea() {
        return this.area;
    }

    public int getFlags() {
        return this.flags;
    }

    public int getId() {
        return this.id;
    }

    public String getRegion() {
        return this.region;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        return ((this.id | (this.flags << 16)) ^ this.region.hashCode()) ^ this.area.hashCode();
    }

    public String toString() {
        return String.format(f.b, "[id=%d,flags=%d,'%s':'%s']", Integer.valueOf(this.id), Integer.valueOf(this.flags), this.region, this.area);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(-1);
        parcel.writeInt(this.id);
        parcel.writeInt(this.flags);
        parcel.writeString(this.region);
        parcel.writeString(this.area);
        parcel.writeStringList(this.tags);
    }

    protected NodeInfo(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt < 0) {
            this.id = parcel.readInt();
        } else {
            this.id = readInt;
        }
        this.flags = parcel.readInt();
        this.region = e.b(parcel.readString());
        this.area = e.b(parcel.readString());
        if (readInt < 0) {
            this.tags = parcel.createStringArrayList();
        } else {
            this.tags = null;
        }
    }
}
