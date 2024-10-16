package MTT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class FrvUserBase extends JceStruct implements Cloneable {
    public String sUin = "";
    public String sSID = "";
    public String sGUID = "";
    public String sQUA = "";
    public int eChannel = EFvrChannel.f4a.a();
    public String sUserIP = "";
    public String sST = "";
    public String sKey = "";
    public String APN = "";

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sUin;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sSID;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sGUID;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        String str4 = this.sQUA;
        if (str4 != null) {
            jceOutputStream.write(str4, 3);
        }
        jceOutputStream.write(this.eChannel, 4);
        String str5 = this.sUserIP;
        if (str5 != null) {
            jceOutputStream.write(str5, 5);
        }
        String str6 = this.sST;
        if (str6 != null) {
            jceOutputStream.write(str6, 6);
        }
        String str7 = this.sKey;
        if (str7 != null) {
            jceOutputStream.write(str7, 7);
        }
        String str8 = this.APN;
        if (str8 != null) {
            jceOutputStream.write(str8, 8);
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sUin = jceInputStream.readString(0, false);
        this.sSID = jceInputStream.readString(1, false);
        this.sGUID = jceInputStream.readString(2, false);
        this.sQUA = jceInputStream.readString(3, false);
        this.eChannel = jceInputStream.read(this.eChannel, 4, false);
        this.sUserIP = jceInputStream.readString(5, false);
        this.sST = jceInputStream.readString(6, false);
        this.sKey = jceInputStream.readString(7, false);
        this.APN = jceInputStream.readString(8, false);
    }
}
