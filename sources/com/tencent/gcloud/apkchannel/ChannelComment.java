package com.tencent.gcloud.apkchannel;

import android.util.Log;
import com.tencent.gcloud.apkchannel.v1.ZipShort;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

/* loaded from: classes2.dex */
public class ChannelComment {
    private static final String TAG = "ChannelComment";
    private static final ZipShort protoHead = new ZipShort(38650);
    public byte[] otherData;
    public Properties p = new Properties();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void decode(byte[] bArr) throws IOException, ProtocolException {
        String str;
        String str2;
        if (bArr == null) {
            str = TAG;
            str2 = "apollo0511 WARNING:[ChannelComment]decode data=null and return";
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = protoHead.getBytes().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!protoHead.equals(new ZipShort(bArr2))) {
                Log.e(TAG, "apollo0511 ERROR:[ChannelComment]decode|unknow protocol|exit");
                throw new ProtocolException("[ChannelComment] unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                str = TAG;
                str2 = "apollo0511 ERROR:[ChannelComment]decode|data.length - headLength <= 2|1|exit";
            } else {
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int value = new ZipShort(bArr3).getValue();
                if ((bArr.length - length) - 2 >= value) {
                    byte[] bArr4 = new byte[value];
                    wrap.get(bArr4);
                    this.p.load(new InputStreamReader(new ByteArrayInputStream(bArr4), "UTF-8"));
                    int length2 = ((bArr.length - length) - value) - 2;
                    if (length2 > 0) {
                        this.otherData = new byte[length2];
                        wrap.get(this.otherData);
                        return;
                    }
                    return;
                }
                str = TAG;
                str2 = "apollo0511 ERROR:[ChannelComment]decode|data.length - headLength <= 2|2|exit";
            }
        }
        Log.e(str, str2);
    }

    public byte[] encode() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(protoHead.getBytes());
        String str = "";
        for (Object obj : this.p.keySet()) {
            str = str + obj + "=" + this.p.getProperty((String) obj) + APLogFileUtil.SEPARATOR_LINE;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byteArrayOutputStream.write(new ZipShort(bytes.length).getBytes());
        byteArrayOutputStream.write(bytes);
        byte[] bArr = this.otherData;
        if (bArr != null) {
            byteArrayOutputStream.write(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] encode(String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(protoHead.getBytes());
        byte[] bytes = str.getBytes("UTF-8");
        byteArrayOutputStream.write(new ZipShort(bytes.length).getBytes());
        byteArrayOutputStream.write(bytes);
        byte[] bArr = this.otherData;
        if (bArr != null) {
            byteArrayOutputStream.write(bArr);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getValue(byte[] bArr) throws IOException, ProtocolException {
        String str;
        String str2;
        if (bArr == null) {
            str = TAG;
            str2 = "apollo0511 WARNING:[Comment]decode|data=null|exit";
        } else {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = protoHead.getBytes().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!protoHead.equals(new ZipShort(bArr2))) {
                Log.e(TAG, "apollo0511 ERROR:[ChannelComment]decode|unknow protocol|exit");
                throw new ProtocolException("[ChannelComment] unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                str = TAG;
                str2 = "apollo0511 ERROR:[ChannelComment]decode|data.length - headLength <= 2|1|exit";
            } else {
                byte[] bArr3 = new byte[2];
                wrap.get(bArr3);
                int value = new ZipShort(bArr3).getValue();
                if ((bArr.length - length) - 2 >= value) {
                    byte[] bArr4 = new byte[value];
                    wrap.get(bArr4);
                    String str3 = new String(bArr4);
                    int length2 = ((bArr.length - length) - value) - 2;
                    if (length2 > 0) {
                        this.otherData = new byte[length2];
                        wrap.get(this.otherData);
                    }
                    return str3;
                }
                str = TAG;
                str2 = "apollo0511 ERROR:[ChannelComment]decode|data.length - headLength <= 2|2|exit";
            }
        }
        Log.e(str, str2);
        return null;
    }

    public String toString() {
        return "ChannelComment [p=" + this.p + ", otherData=" + Arrays.toString(this.otherData) + "]";
    }
}
