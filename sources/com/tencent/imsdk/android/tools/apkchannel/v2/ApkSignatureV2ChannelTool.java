package com.tencent.imsdk.android.tools.apkchannel.v2;

import android.annotation.SuppressLint;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class ApkSignatureV2ChannelTool {
    private static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    private static final int APK_SIGNATURE_SCHEME_V3_BLOCK_ID = -262969152;
    private static final int MSDK_COMMENT_BLOCK_ID = 1903261812;

    public static boolean isSignatureV2Apk(String str) throws IOException {
        return ApkSignatureSchemeV2Verifier.hasSignature(str, APK_SIGNATURE_SCHEME_V2_BLOCK_ID);
    }

    public static boolean isSignatureV3Apk(String str) throws IOException {
        return ApkSignatureSchemeV2Verifier.hasSignature(str, APK_SIGNATURE_SCHEME_V3_BLOCK_ID);
    }

    public static byte[] readMsdkComment(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readPairValueWithId(str, MSDK_COMMENT_BLOCK_ID);
    }

    private static byte[] readPairValueWithId(String str, int i) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            ByteBuffer findApkSigningBlockWithId = ApkSignatureSchemeV2Verifier.findApkSigningBlockWithId(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first, i);
            byte[] bArr = new byte[findApkSigningBlockWithId.remaining()];
            findApkSigningBlockWithId.get(bArr, 0, bArr.length);
            randomAccessFile.close();
            return bArr;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    randomAccessFile.close();
                } catch (Throwable unused) {
                }
            } else {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static ByteBuffer getCdfh(RandomAccessFile randomAccessFile, long j, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        return allocate;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x00fb, code lost:
    
        if (r5 != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00fd, code lost:
    
        r3.putLong(r15.length + 4);
        r3.putInt(r14);
        r3.put(r15);
        r5 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x010b, code lost:
    
        r14 = r13.getLong() + r5;
        r3.putLong(r14);
        r3.put(r13.array(), r13.array().length - 16, 16);
        r3.position(0);
        r3.putLong(r14);
        r3.position(0);
        r3.limit(((int) r14) + 8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0138, code lost:
    
        return com.tencent.imsdk.android.tools.apkchannel.v2.Pair.create(r3, java.lang.Long.valueOf(r5));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.tencent.imsdk.android.tools.apkchannel.v2.Pair<java.nio.ByteBuffer, java.lang.Long> genApkSigningBlockWithNewPair(java.nio.ByteBuffer r13, int r14, byte[] r15) throws com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException, java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.tools.apkchannel.v2.ApkSignatureV2ChannelTool.genApkSigningBlockWithNewPair(java.nio.ByteBuffer, int, byte[]):com.tencent.imsdk.android.tools.apkchannel.v2.Pair");
    }
}
