package com.shieldtunnel.svpn.common.intf;

import android.os.Parcel;
import android.os.Parcelable;
import com.shieldtunnel.svpn.common.c;
import com.shieldtunnel.svpn.common.f.f;

/* loaded from: classes2.dex */
public class NodeState implements Parcelable {
    public static final Parcelable.Creator<NodeState> CREATOR = new Parcelable.Creator<NodeState>() { // from class: com.shieldtunnel.svpn.common.intf.NodeState.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NodeState createFromParcel(Parcel parcel) {
            return new NodeState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public NodeState[] newArray(int i) {
            return new NodeState[i];
        }
    };
    private final NetDelay netDelay;
    private final int nodeId;
    private final int score;

    public NodeState(int i, int i2, NetDelay netDelay) {
        this.nodeId = i;
        this.score = i2;
        this.netDelay = netDelay;
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
        if (!(obj instanceof NodeState)) {
            return false;
        }
        NodeState nodeState = (NodeState) obj;
        return this.nodeId == nodeState.nodeId && this.score == nodeState.score && c.a(this.netDelay, nodeState.netDelay);
    }

    public NetDelay getNetDelay() {
        return this.netDelay;
    }

    public int getNodeId() {
        return this.nodeId;
    }

    public int getScore() {
        return this.score;
    }

    public int hashCode() {
        return (this.score << 24) | (this.nodeId << 8) | this.netDelay.hashCode();
    }

    public String toString() {
        return String.format(f.b, "[id=%d,score=%d,%s]", Integer.valueOf(this.nodeId), Integer.valueOf(this.score), this.netDelay);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.nodeId);
        parcel.writeInt(this.score);
        this.netDelay.writeToParcel(parcel, i);
    }

    protected NodeState(Parcel parcel) {
        this.nodeId = parcel.readInt();
        this.score = parcel.readInt();
        this.netDelay = NetDelay.CREATOR.createFromParcel(parcel);
    }
}
