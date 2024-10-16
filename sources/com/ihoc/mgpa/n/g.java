package com.ihoc.mgpa.n;

import com.adjust.sdk.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mtt.engine.http.HttpUtils;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f5670a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003a, code lost:
    
        if (r2 == null) goto L28;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0041: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:33:0x0041 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(java.io.File r5) {
        /*
            r0 = 2048(0x800, float:2.87E-42)
            byte[] r0 = new byte[r0]
            r1 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2b java.security.NoSuchAlgorithmException -> L2d java.io.IOException -> L35
            r2.<init>(r5)     // Catch: java.lang.Throwable -> L2b java.security.NoSuchAlgorithmException -> L2d java.io.IOException -> L35
            java.lang.String r5 = "MD5"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)     // Catch: java.security.NoSuchAlgorithmException -> L27 java.io.IOException -> L29 java.lang.Throwable -> L40
        L10:
            int r3 = r2.read(r0)     // Catch: java.security.NoSuchAlgorithmException -> L27 java.io.IOException -> L29 java.lang.Throwable -> L40
            if (r3 <= 0) goto L1b
            r4 = 0
            r5.update(r0, r4, r3)     // Catch: java.security.NoSuchAlgorithmException -> L27 java.io.IOException -> L29 java.lang.Throwable -> L40
            goto L10
        L1b:
            byte[] r5 = r5.digest()     // Catch: java.security.NoSuchAlgorithmException -> L27 java.io.IOException -> L29 java.lang.Throwable -> L40
            java.lang.String r5 = b(r5)     // Catch: java.security.NoSuchAlgorithmException -> L27 java.io.IOException -> L29 java.lang.Throwable -> L40
            r2.close()     // Catch: java.io.IOException -> L26
        L26:
            return r5
        L27:
            r5 = move-exception
            goto L2f
        L29:
            r5 = move-exception
            goto L37
        L2b:
            r5 = move-exception
            goto L42
        L2d:
            r5 = move-exception
            r2 = r1
        L2f:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L3f
            goto L3c
        L35:
            r5 = move-exception
            r2 = r1
        L37:
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L40
            if (r2 == 0) goto L3f
        L3c:
            r2.close()     // Catch: java.io.IOException -> L3f
        L3f:
            return r1
        L40:
            r5 = move-exception
            r1 = r2
        L42:
            if (r1 == 0) goto L47
            r1.close()     // Catch: java.io.IOException -> L47
        L47:
            throw r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ihoc.mgpa.n.g.a(java.io.File):java.lang.String");
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(str.getBytes(HttpUtils.DEFAULT_ENCODE_NAME));
            return c(new BigInteger(1, messageDigest.digest()).toString(16));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(f5670a[(b >> 4) & 15]);
            sb.append(f5670a[b & 15]);
        }
        return sb.toString();
    }

    private static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            int i = b & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
            if (i < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        return stringBuffer.toString();
    }

    public static byte[] b(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[charArray.length / 2];
        for (int i = 0; i < bArr.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("");
            int i2 = i * 2;
            sb.append(charArray[i2]);
            sb.append(charArray[i2 + 1]);
            bArr[i] = (byte) Integer.parseInt(sb.toString(), 16);
        }
        return bArr;
    }

    private static String c(String str) {
        if (str.length() == 32) {
            return str;
        }
        return c("0" + str);
    }
}
