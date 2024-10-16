package com.tencent.imsdk.android.tools.apkchannel.v2;

import com.tencent.imsdk.android.tools.log.IMLogger;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

/* loaded from: classes.dex */
public final class ApkChannelTool {
    public static final String ADJUST_TRACKER_TOKEN = "adjustTrackerToken";
    public static final String CHANNEL_ID = "channelId";

    public static String readChannel(String str) throws IOException {
        IMLogger.d("read apk Channel");
        MSDKComment readMsdkComment = readMsdkComment(str);
        if (readMsdkComment == null) {
            return null;
        }
        return readMsdkComment.p.getProperty("channelId");
    }

    public static String readAdjustTrackerToken(String str) throws IOException {
        IMLogger.d("read apk adjust traker token");
        MSDKComment readMsdkComment = readMsdkComment(str);
        if (readMsdkComment == null) {
            return null;
        }
        return readMsdkComment.p.getProperty("adjustTrackerToken");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0038  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.tencent.imsdk.android.tools.apkchannel.v2.ApkChannelTool.MSDKComment readMsdkComment(java.lang.String r5) throws java.io.IOException {
        /*
            boolean r0 = com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureV2ChannelTool.isSignatureV3Apk(r5)
            boolean r1 = com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureV2ChannelTool.isSignatureV2Apk(r5)
            r2 = 0
            if (r1 != 0) goto L14
            if (r0 == 0) goto Le
            goto L14
        Le:
            java.lang.String r3 = "is v1 signature"
            com.tencent.imsdk.android.tools.log.IMLogger.d(r3)
            goto L35
        L14:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            r3.<init>()     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            java.lang.String r4 = "is v2 signature : "
            r3.append(r4)     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            r3.append(r1)     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            java.lang.String r4 = ", is v3 signature : "
            r3.append(r4)     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            r3.append(r0)     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            java.lang.String r3 = r3.toString()     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            com.tencent.imsdk.android.tools.log.IMLogger.d(r3)     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            byte[] r3 = com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureV2ChannelTool.readMsdkComment(r5)     // Catch: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException -> L35
            goto L36
        L35:
            r3 = r2
        L36:
            if (r3 != 0) goto L59
            byte[] r3 = com.tencent.imsdk.android.tools.apkchannel.v2.ZipEocdCommentTool.readComment(r5)
            if (r1 == 0) goto L4b
            if (r3 == 0) goto L4b
            java.lang.String r5 = "you are use v2 signature but use v1 channel modle"
            com.tencent.imsdk.android.tools.log.IMLogger.d(r5)
            java.lang.String r5 = "this apk will can't install in 7.0 system"
            com.tencent.imsdk.android.tools.log.IMLogger.d(r5)
            goto L59
        L4b:
            if (r0 == 0) goto L59
            if (r3 == 0) goto L59
            java.lang.String r5 = "you are use v3 signature but use v1 channel modle"
            com.tencent.imsdk.android.tools.log.IMLogger.d(r5)
            java.lang.String r5 = "this apk will can't install in 9.0 system"
            com.tencent.imsdk.android.tools.log.IMLogger.d(r5)
        L59:
            if (r3 != 0) goto L5c
            return r2
        L5c:
            com.tencent.imsdk.android.tools.apkchannel.v2.ApkChannelTool$MSDKComment r5 = new com.tencent.imsdk.android.tools.apkchannel.v2.ApkChannelTool$MSDKComment
            r5.<init>()
            r5.decode(r3)     // Catch: java.net.ProtocolException -> L65
            return r5
        L65:
            r5 = move-exception
            r5.printStackTrace()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.tools.apkchannel.v2.ApkChannelTool.readMsdkComment(java.lang.String):com.tencent.imsdk.android.tools.apkchannel.v2.ApkChannelTool$MSDKComment");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
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
