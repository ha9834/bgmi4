package com.tencent.gcloud.apkchannel.v2;

import android.annotation.SuppressLint;
import android.util.Log;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.gcloud.apkchannel.ChannelComment;
import com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class ApkSignatureV2ChannelTool {
    private static final int APK_SIGNATURE_SCHEME_V2_BLOCK_ID = 1896449818;
    private static final String TAG = "ApkSignatureV2ChannelTool";
    private static final int YYB_COMMENT_BLOCK_ID = 1903261812;

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
    
        return com.tencent.gcloud.apkchannel.v2.Pair.create(r3, java.lang.Long.valueOf(r5));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.tencent.gcloud.apkchannel.v2.Pair<java.nio.ByteBuffer, java.lang.Long> genApkSigningBlockWithNewPair(java.nio.ByteBuffer r13, int r14, byte[] r15) throws com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException, java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gcloud.apkchannel.v2.ApkSignatureV2ChannelTool.genApkSigningBlockWithNewPair(java.nio.ByteBuffer, int, byte[]):com.tencent.gcloud.apkchannel.v2.Pair");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bb, code lost:
    
        throw new com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + r4 + " size out of range: " + r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.tencent.gcloud.apkchannel.v2.Pair<java.nio.ByteBuffer, java.lang.Long> genApkSigningBlockWithNewPair2(java.nio.ByteBuffer r13, int r14, byte[] r15) throws com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier.SignatureNotFoundException, java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.gcloud.apkchannel.v2.ApkSignatureV2ChannelTool.genApkSigningBlockWithNewPair2(java.nio.ByteBuffer, int, byte[]):com.tencent.gcloud.apkchannel.v2.Pair");
    }

    public static int getApkCurChannelId(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            return ApkSignatureSchemeV2Verifier.findChanelIdInSignBlock(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first);
        } finally {
            randomAccessFile.close();
        }
    }

    public static byte[] getApkCurChannelValue(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            ByteBuffer findApkChannelInfoBlock = ApkSignatureSchemeV2Verifier.findApkChannelInfoBlock(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first);
            byte[] bArr = new byte[findApkChannelInfoBlock.remaining()];
            findApkChannelInfoBlock.get(bArr, 0, bArr.length);
            return bArr;
        } finally {
            randomAccessFile.close();
        }
    }

    private static ByteBuffer getCdfh(RandomAccessFile randomAccessFile, long j, int i) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        return allocate;
    }

    private static long getCentralDirOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            return ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue);
        } finally {
            randomAccessFile.close();
        }
    }

    private static long getCentralDirSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            return ApkSignatureSchemeV2Verifier.getCentralDirSize(byteBuffer, longValue);
        } finally {
            randomAccessFile.close();
        }
    }

    private static long getEocdOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            long longValue = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile).second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            return longValue;
        } finally {
            randomAccessFile.close();
        }
    }

    private static long getEocdSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, eocd.second.longValue())) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            return byteBuffer.capacity();
        } finally {
            randomAccessFile.close();
        }
    }

    public static long getSignBlockOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getSigningBlockOffset(str);
    }

    public static long getSignBlockSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getSigningBlockSize(str);
    }

    private static long getSigningBlockOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            return ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).second.longValue();
        } finally {
            randomAccessFile.close();
        }
    }

    private static long getSigningBlockSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            return ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first != null ? r4.capacity() : 0L;
        } finally {
            randomAccessFile.close();
        }
    }

    public static boolean isSignatureV2Apk(String str) throws IOException {
        return ApkSignatureSchemeV2Verifier.hasSignature(str);
    }

    public static long readCDFHOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getCentralDirOffset(str);
    }

    public static long readCDFHSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getCentralDirSize(str);
    }

    @SuppressLint({"NewApi"})
    private static long readChannelInfoOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            Pair<ByteBuffer, Long> findApkSigningBlock = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue));
            return findApkSigningBlock.second.longValue() + ApkSignatureSchemeV2Verifier.findChannelBlockOffset(findApkSigningBlock.first);
        } finally {
            randomAccessFile.close();
        }
    }

    private static long readChannelInfoOffset(String str, int i) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            Pair<ByteBuffer, Long> findApkSigningBlock = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue));
            long longValue2 = findApkSigningBlock.second.longValue() + ApkSignatureSchemeV2Verifier.findChannelBlockOffset(findApkSigningBlock.first);
            ByteBuffer allocate = ByteBuffer.allocate((((int) readChannelInfoSize(str, 0)) - 4) - 8);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(8 + longValue2 + 4);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            byte[] bArr = new byte[allocate.remaining()];
            allocate.get(bArr, 0, bArr.length);
            ChannelComment channelComment = new ChannelComment();
            try {
                channelComment.decode(bArr);
                Log.d(TAG, "apollo0511 readChannelInfoOffset getOffset and channelId:" + channelComment.p.getProperty("channelId"));
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            return longValue2;
        } finally {
            randomAccessFile.close();
        }
    }

    private static long readChannelInfoSize(String str, int i) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            long apkSigningBlockChannelSize = ApkSignatureSchemeV2Verifier.getApkSigningBlockChannelSize(ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue)).first);
            long readChannelInfoOffset = readChannelInfoOffset(str);
            ByteBuffer allocate = ByteBuffer.allocate((((int) apkSigningBlockChannelSize) - 8) - 4);
            allocate.order(ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.seek(readChannelInfoOffset + 8 + 4);
            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
            byte[] bArr = new byte[allocate.remaining()];
            allocate.get(bArr, 0, bArr.length);
            ChannelComment channelComment = new ChannelComment();
            try {
                channelComment.decode(bArr);
                Log.d(TAG, "apollo0511 readChannelInfoSize getSize and channelId:" + channelComment.p.getProperty("channelId"));
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            return apkSigningBlockChannelSize;
        } finally {
            randomAccessFile.close();
        }
    }

    public static long readCommentOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readChannelInfoOffset(str, YYB_COMMENT_BLOCK_ID);
    }

    public static long readCommentSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readChannelInfoSize(str, YYB_COMMENT_BLOCK_ID);
    }

    public static long readEOCDOffset(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getEocdOffset(str);
    }

    public static long readEOCDSize(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return getEocdSize(str);
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
            return bArr;
        } finally {
            randomAccessFile.close();
        }
    }

    public static byte[] readYYBComment(String str) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        return readPairValueWithId(str, YYB_COMMENT_BLOCK_ID);
    }

    private static void updateApkWithPair(String str, int i, byte[] bArr) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        try {
            Pair<ByteBuffer, Long> eocd = ApkSignatureSchemeV2Verifier.getEocd(randomAccessFile);
            ByteBuffer byteBuffer = eocd.first;
            long longValue = eocd.second.longValue();
            if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
            }
            long centralDirOffset = ApkSignatureSchemeV2Verifier.getCentralDirOffset(byteBuffer, longValue);
            ByteBuffer cdfh = getCdfh(randomAccessFile, centralDirOffset, (int) (longValue - centralDirOffset));
            Pair<ByteBuffer, Long> findApkSigningBlock = ApkSignatureSchemeV2Verifier.findApkSigningBlock(randomAccessFile, centralDirOffset);
            ByteBuffer byteBuffer2 = findApkSigningBlock.first;
            long longValue2 = findApkSigningBlock.second.longValue();
            Pair<ByteBuffer, Long> genApkSigningBlockWithNewPair2 = genApkSigningBlockWithNewPair2(byteBuffer2, i, bArr);
            if (genApkSigningBlockWithNewPair2 == null) {
                return;
            }
            ByteBuffer byteBuffer3 = genApkSigningBlockWithNewPair2.first;
            long longValue3 = genApkSigningBlockWithNewPair2.second.longValue();
            ZipUtils.setZipEocdCentralDirectoryOffset(byteBuffer, centralDirOffset + longValue3);
            randomAccessFile.seek(longValue2);
            randomAccessFile.write(byteBuffer3.array(), byteBuffer3.arrayOffset() + byteBuffer3.position(), byteBuffer3.remaining());
            randomAccessFile.write(cdfh.array(), cdfh.arrayOffset() + cdfh.position(), cdfh.remaining());
            randomAccessFile.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            if (longValue3 < 0) {
                randomAccessFile.setLength(randomAccessFile.length() + longValue3);
            }
        } finally {
            randomAccessFile.close();
        }
    }

    public static void updateChannInfoBlock(String str, int i, byte[] bArr) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        updateApkWithPair(str, i, bArr);
    }

    public static void updateYYBComment(String str, byte[] bArr) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        updateApkWithPair(str, YYB_COMMENT_BLOCK_ID, bArr);
    }
}
