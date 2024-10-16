package com.tdatamaster.tdm.defines;

/* loaded from: classes2.dex */
public class DBEvent {
    public byte[] Data;
    public int DataLen;
    public int EventID;
    public long ID;
    public int SrcId;

    public DBEvent() {
    }

    public DBEvent(long j, int i, int i2, int i3, byte[] bArr) {
        this.Data = bArr;
        this.EventID = i;
        this.SrcId = i2;
        this.DataLen = i3;
        this.ID = j;
    }
}
