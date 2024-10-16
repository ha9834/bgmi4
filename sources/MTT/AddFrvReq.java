package MTT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public final class AddFrvReq extends JceStruct implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static FrvUserBase f3a;
    static ArrayList<AddFrvInfo> b;
    public FrvUserBase fub = null;
    public int eFvrType = EFvrFvrType.f5a.a();
    public String sCookie = "";
    public String sHttpHeader = "";
    public ArrayList<AddFrvInfo> vURLInfo = null;
    public int iAsyncFlag = 0;

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        FrvUserBase frvUserBase = this.fub;
        if (frvUserBase != null) {
            jceOutputStream.write((JceStruct) frvUserBase, 0);
        }
        jceOutputStream.write(this.eFvrType, 1);
        String str = this.sCookie;
        if (str != null) {
            jceOutputStream.write(str, 2);
        }
        String str2 = this.sHttpHeader;
        if (str2 != null) {
            jceOutputStream.write(str2, 3);
        }
        ArrayList<AddFrvInfo> arrayList = this.vURLInfo;
        if (arrayList != null) {
            jceOutputStream.write((Collection) arrayList, 4);
        }
        jceOutputStream.write(this.iAsyncFlag, 5);
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        if (f3a == null) {
            f3a = new FrvUserBase();
        }
        this.fub = (FrvUserBase) jceInputStream.read((JceStruct) f3a, 0, false);
        this.eFvrType = jceInputStream.read(this.eFvrType, 1, false);
        this.sCookie = jceInputStream.readString(2, false);
        this.sHttpHeader = jceInputStream.readString(3, false);
        if (b == null) {
            b = new ArrayList<>();
            b.add(new AddFrvInfo());
        }
        this.vURLInfo = (ArrayList) jceInputStream.read((JceInputStream) b, 4, false);
        this.iAsyncFlag = jceInputStream.read(this.iAsyncFlag, 5, false);
    }
}
