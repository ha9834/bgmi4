package MTT;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

/* loaded from: classes.dex */
public final class FvrContentField extends JceStruct implements Cloneable {
    public int eCff = 0;
    public String sVal = "";

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.eCff, 0);
        String str = this.sVal;
        if (str != null) {
            jceOutputStream.write(str, 1);
        }
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.eCff = jceInputStream.read(this.eCff, 0, false);
        this.sVal = jceInputStream.readString(1, false);
    }
}
