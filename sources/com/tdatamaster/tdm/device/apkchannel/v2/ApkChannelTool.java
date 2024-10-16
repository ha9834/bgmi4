package com.tdatamaster.tdm.device.apkchannel.v2;

import com.tdatamaster.tdm.system.TDMLog;
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
public final class ApkChannelTool {
    public static final String ADJUST_TRACKER_TOKEN = "adjustTrackerToken";
    public static final String CHANNEL_ID = "channelId";
    private static final String TAG = "ApkChannelTool";

    public static String readChannel(String str) throws IOException {
        TDMLog.d(TAG, "read apk Channel");
        MSDKComment readMsdkComment = readMsdkComment(str);
        if (readMsdkComment == null) {
            return null;
        }
        return readMsdkComment.p.getProperty("channelId");
    }

    public static String readAdjustTrackerToken(String str) throws IOException {
        TDMLog.d(TAG, "read apk adjust traker token");
        MSDKComment readMsdkComment = readMsdkComment(str);
        if (readMsdkComment == null) {
            return null;
        }
        return readMsdkComment.p.getProperty("adjustTrackerToken");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.tdatamaster.tdm.device.apkchannel.v2.ApkChannelTool.MSDKComment readMsdkComment(java.lang.String r6) throws java.io.IOException {
        /*
            boolean r0 = com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureV2ChannelTool.isSignatureV3Apk(r6)
            boolean r1 = com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureV2ChannelTool.isSignatureV2Apk(r6)
            r2 = 0
            if (r1 != 0) goto L16
            if (r0 == 0) goto Le
            goto L16
        Le:
            java.lang.String r3 = "ApkChannelTool"
            java.lang.String r4 = "is v1 signature"
            com.tdatamaster.tdm.system.TDMLog.d(r3, r4)
            goto L39
        L16:
            java.lang.String r3 = "ApkChannelTool"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            r4.<init>()     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            java.lang.String r5 = "is v2 signature : "
            r4.append(r5)     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            r4.append(r1)     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            java.lang.String r5 = ", is v3 signature : "
            r4.append(r5)     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            r4.append(r0)     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            java.lang.String r4 = r4.toString()     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            com.tdatamaster.tdm.system.TDMLog.d(r3, r4)     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            byte[] r3 = com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureV2ChannelTool.readMsdkComment(r6)     // Catch: com.tdatamaster.tdm.device.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L39
            goto L3a
        L39:
            r3 = r2
        L3a:
            if (r3 != 0) goto L65
            byte[] r3 = com.tdatamaster.tdm.device.apkchannel.v2.ZipEocdCommentTool.readComment(r6)
            if (r1 == 0) goto L53
            if (r3 == 0) goto L53
            java.lang.String r6 = "ApkChannelTool"
            java.lang.String r0 = "you are use v2 signature but use v1 channel modle"
            com.tdatamaster.tdm.system.TDMLog.d(r6, r0)
            java.lang.String r6 = "ApkChannelTool"
            java.lang.String r0 = "this apk will can't install in 7.0 system"
            com.tdatamaster.tdm.system.TDMLog.d(r6, r0)
            goto L65
        L53:
            if (r0 == 0) goto L65
            if (r3 == 0) goto L65
            java.lang.String r6 = "ApkChannelTool"
            java.lang.String r0 = "you are use v3 signature but use v1 channel modle"
            com.tdatamaster.tdm.system.TDMLog.d(r6, r0)
            java.lang.String r6 = "ApkChannelTool"
            java.lang.String r0 = "this apk will can't install in 9.0 system"
            com.tdatamaster.tdm.system.TDMLog.d(r6, r0)
        L65:
            if (r3 != 0) goto L68
            return r2
        L68:
            com.tdatamaster.tdm.device.apkchannel.v2.ApkChannelTool$MSDKComment r6 = new com.tdatamaster.tdm.device.apkchannel.v2.ApkChannelTool$MSDKComment
            r6.<init>()
            r6.decode(r3)     // Catch: java.net.ProtocolException -> L71
            return r6
        L71:
            r6 = move-exception
            r6.printStackTrace()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tdatamaster.tdm.device.apkchannel.v2.ApkChannelTool.readMsdkComment(java.lang.String):com.tdatamaster.tdm.device.apkchannel.v2.ApkChannelTool$MSDKComment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class MSDKComment {
        private static final int CHANNEL_HEAD = 38650;
        private static final ZipShort protoHead = new ZipShort(CHANNEL_HEAD);
        byte[] otherData;
        Properties p;

        private MSDKComment() {
            this.p = new Properties();
        }

        void decode(byte[] bArr) throws IOException, ProtocolException {
            if (bArr == null) {
                System.out.println("WARNING:[YYBComment]decode|data=null|exit");
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = protoHead.getBytes().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!protoHead.equals(new ZipShort(bArr2))) {
                System.out.println("ERROR:[YYBComment]decode|unknow protocol|exit");
                throw new ProtocolException("[YYBComment] unknow protocl [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|1|exit");
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int value = new ZipShort(bArr3).getValue();
            if ((bArr.length - length) - 2 < value) {
                System.out.println("ERROR:[YYBComment]decode|data.length - headLength <= 2|2|exit");
                return;
            }
            byte[] bArr4 = new byte[value];
            wrap.get(bArr4);
            this.p.load(new InputStreamReader(new ByteArrayInputStream(bArr4), "UTF-8"));
            int length2 = ((bArr.length - length) - value) - 2;
            if (length2 > 0) {
                this.otherData = new byte[length2];
                wrap.get(this.otherData);
            }
        }

        byte[] encode() throws IOException {
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

        public String toString() {
            return "YYBComment [p=" + this.p + ", otherData=" + Arrays.toString(this.otherData) + "]";
        }
    }
}
