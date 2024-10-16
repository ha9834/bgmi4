package com.tdatamaster.tdm.device.apkchannel.v2;

import android.annotation.SuppressLint;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes2.dex */
public class ApkSignatureSchemeV2Verifier {
    private static final long APK_SIG_BLOCK_MAGIC_HI = 3617552046287187010L;
    private static final long APK_SIG_BLOCK_MAGIC_LO = 2334950737559900225L;
    private static final int APK_SIG_BLOCK_MIN_SIZE = 32;
    static final int SF_ATTRIBUTE_ANDROID_APK_SIGNED_ID = 2;
    static final String SF_ATTRIBUTE_ANDROID_APK_SIGNED_NAME = "X-Android-APK-Signed";

    @SuppressLint({"NewApi"})
    public static boolean hasSignature(String str, int i) throws IOException {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            try {
                Pair<ByteBuffer, Long> eocd = getEocd(randomAccessFile);
                ByteBuffer byteBuffer = eocd.first;
                long longValue = eocd.second.longValue();
                if (ZipUtils.isZip64EndOfCentralDirectoryLocatorPresent(randomAccessFile, longValue)) {
                    throw new SignatureNotFoundException("ZIP64 APK not supported");
                }
                findApkSignatureSchemeBlock(findApkSigningBlock(randomAccessFile, getCentralDirOffset(byteBuffer, longValue)).first, i);
                randomAccessFile.close();
                return true;
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
        } catch (SignatureNotFoundException unused2) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> getEocd(RandomAccessFile randomAccessFile) throws IOException, SignatureNotFoundException {
        Pair<ByteBuffer, Long> findZipEndOfCentralDirectoryRecord = ZipUtils.findZipEndOfCentralDirectoryRecord(randomAccessFile);
        if (findZipEndOfCentralDirectoryRecord != null) {
            return findZipEndOfCentralDirectoryRecord;
        }
        throw new SignatureNotFoundException("Not an APK file: ZIP End of Central Directory record not found");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getCentralDirOffset(ByteBuffer byteBuffer, long j) throws SignatureNotFoundException {
        long zipEocdCentralDirectoryOffset = ZipUtils.getZipEocdCentralDirectoryOffset(byteBuffer);
        if (zipEocdCentralDirectoryOffset < j) {
            if (ZipUtils.getZipEocdCentralDirectorySizeBytes(byteBuffer) + zipEocdCentralDirectoryOffset == j) {
                return zipEocdCentralDirectoryOffset;
            }
            throw new SignatureNotFoundException("ZIP Central Directory is not immediately followed by End of Central Directory");
        }
        throw new SignatureNotFoundException("ZIP Central Directory offset out of range: " + zipEocdCentralDirectoryOffset + ". ZIP End of Central Directory offset: " + j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer sliceFromTo(ByteBuffer byteBuffer, int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("start: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("end < start: " + i2 + " < " + i);
        }
        int capacity = byteBuffer.capacity();
        if (i2 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i2 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            byteBuffer.position(i);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer getByteBuffer(ByteBuffer byteBuffer, int i) throws BufferUnderflowException {
        if (i < 0) {
            throw new IllegalArgumentException("size: " + i);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i2 = i + position;
        if (i2 < position || i2 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i2);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i2);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<ByteBuffer, Long> findApkSigningBlock(RandomAccessFile randomAccessFile, long j) throws IOException, SignatureNotFoundException {
        if (j < 32) {
            throw new SignatureNotFoundException("APK too small for APK Signing Block. ZIP Central Directory offset: " + j);
        }
        ByteBuffer allocate = ByteBuffer.allocate(24);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j - allocate.capacity());
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        if (allocate.getLong(8) != APK_SIG_BLOCK_MAGIC_LO || allocate.getLong(16) != APK_SIG_BLOCK_MAGIC_HI) {
            throw new SignatureNotFoundException("No APK Signing Block before ZIP Central Directory");
        }
        long j2 = allocate.getLong(0);
        if (j2 < allocate.capacity() || j2 > 2147483639) {
            throw new SignatureNotFoundException("APK Signing Block size out of range: " + j2);
        }
        int i = (int) (8 + j2);
        long j3 = j - i;
        if (j3 < 0) {
            throw new SignatureNotFoundException("APK Signing Block offset out of range: " + j3);
        }
        ByteBuffer allocate2 = ByteBuffer.allocate(i);
        allocate2.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(allocate2.array(), allocate2.arrayOffset(), allocate2.capacity());
        long j4 = allocate2.getLong(0);
        if (j4 != j2) {
            throw new SignatureNotFoundException("APK Signing Block sizes in header and footer do not match: " + j4 + " vs " + j2);
        }
        return Pair.create(allocate2, Long.valueOf(j3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static ByteBuffer findApkSignatureSchemeBlock(ByteBuffer byteBuffer, int i) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (sliceFromTo.hasRemaining()) {
            i2++;
            if (sliceFromTo.remaining() < 8) {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j = sliceFromTo.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int position = sliceFromTo.position() + i3;
            if (i3 > sliceFromTo.remaining()) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + sliceFromTo.remaining());
            }
            if (sliceFromTo.getInt() == i) {
                return getByteBuffer(sliceFromTo, i3 - 4);
            }
            sliceFromTo.position(position);
        }
        throw new SignatureNotFoundException("No APK Signature Scheme block with id : " + i + " in APK Signing Block");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ByteBuffer findApkSigningBlockWithId(ByteBuffer byteBuffer, int i) throws SignatureNotFoundException {
        checkByteOrderLittleEndian(byteBuffer);
        ByteBuffer sliceFromTo = sliceFromTo(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i2 = 0;
        while (sliceFromTo.hasRemaining()) {
            i2++;
            if (sliceFromTo.remaining() < 8) {
                throw new SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i2);
            }
            long j = sliceFromTo.getLong();
            if (j < 4 || j > 2147483647L) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + j);
            }
            int i3 = (int) j;
            int position = sliceFromTo.position() + i3;
            if (i3 > sliceFromTo.remaining()) {
                throw new SignatureNotFoundException("APK Signing Block entry #" + i2 + " size out of range: " + i3 + ", available: " + sliceFromTo.remaining());
            }
            if (sliceFromTo.getInt() == i) {
                return getByteBuffer(sliceFromTo, i3 - 4);
            }
            sliceFromTo.position(position);
        }
        throw new SignatureNotFoundException("No Channel block in APK Signing Block");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkByteOrderLittleEndian(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    /* loaded from: classes2.dex */
    public static class SignatureNotFoundException extends Exception {
        private static final long serialVersionUID = 1;

        public SignatureNotFoundException(String str) {
            super(str);
        }

        public SignatureNotFoundException(String str, Throwable th) {
            super(str, th);
        }
    }
}
