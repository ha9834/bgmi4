package MTT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class AddFrvInfo extends JceStruct implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static ArrayList<FvrContentField> f2a;
    static byte[] b;
    static ArrayList<Integer> c;
    public String sURL = "";
    public String sTitle = "";
    public String sRefURL = "";
    public ArrayList<FvrContentField> vContentField = null;
    public byte[] vFileData = null;
    public String sFrom = "";
    public ArrayList<Integer> vTagId = null;
    public String sNewsId = "";
    public long iFrvTime = 0;
    public String sSummary = "";
    public String sImageUrl = "";

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        String str = this.sURL;
        if (str != null) {
            jceOutputStream.write(str, 0);
        }
        String str2 = this.sTitle;
        if (str2 != null) {
            jceOutputStream.write(str2, 1);
        }
        String str3 = this.sRefURL;
        if (str3 != null) {
            jceOutputStream.write(str3, 2);
        }
        ArrayList<FvrContentField> arrayList = this.vContentField;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 3);
        }
        byte[] bArr = this.vFileData;
        if (bArr != null) {
            jceOutputStream.write(bArr, 4);
        }
        String str4 = this.sFrom;
        if (str4 != null) {
            jceOutputStream.write(str4, 5);
        }
        ArrayList<Integer> arrayList2 = this.vTagId;
        if (arrayList2 != null) {
            jceOutputStream.write((Collection) arrayList2, 6);
        }
        String str5 = this.sNewsId;
        if (str5 != null) {
            jceOutputStream.write(str5, 7);
        }
        jceOutputStream.write(this.iFrvTime, 8);
        String str6 = this.sSummary;
        if (str6 != null) {
            jceOutputStream.write(str6, 9);
        }
        String str7 = this.sImageUrl;
        if (str7 != null) {
            jceOutputStream.write(str7, 10);
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.sURL = jceInputStream.readString(0, false);
        this.sTitle = jceInputStream.readString(1, false);
        this.sRefURL = jceInputStream.readString(2, false);
        if (f2a == null) {
            f2a = new ArrayList<>();
            f2a.add(new FvrContentField());
        }
        this.vContentField = (ArrayList) jceInputStream.read((JceInputStream) f2a, 3, false);
        if (b == null) {
            b = new byte[1];
            b[0] = 0;
        }
        this.vFileData = jceInputStream.read(b, 4, false);
        this.sFrom = jceInputStream.readString(5, false);
        if (c == null) {
            c = new ArrayList<>();
            c.add(0);
        }
        this.vTagId = (ArrayList) jceInputStream.read((JceInputStream) c, 6, false);
        this.sNewsId = jceInputStream.readString(7, false);
        this.iFrvTime = jceInputStream.read(this.iFrvTime, 8, false);
        this.sSummary = jceInputStream.readString(9, false);
        this.sImageUrl = jceInputStream.readString(10, false);
    }
}
