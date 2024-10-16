package com.tencent.quantum.mtr;

/* loaded from: classes.dex */
public class PingInfo {
    public int executeSeq;
    public int icmpSeq;
    public String nodeIP;
    public float time;
    public int ttl;

    public PingInfo(String str, int i, int i2, int i3, float f) {
        this.nodeIP = "";
        this.executeSeq = 0;
        this.icmpSeq = 0;
        this.nodeIP = str;
        this.executeSeq = i;
        this.icmpSeq = i2;
        this.ttl = i3;
        this.time = f;
    }

    public String toString() {
        return "{\"IP\":\"" + this.nodeIP + "\", \"ExeSeq\":" + String.valueOf(this.executeSeq) + ",\"ICMPSeq\":" + String.valueOf(this.icmpSeq) + ",\"TTL\":" + String.valueOf(this.ttl) + ",\"Time\":" + String.valueOf(this.time) + "}";
    }
}
