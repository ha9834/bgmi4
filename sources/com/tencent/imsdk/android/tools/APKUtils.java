package com.tencent.imsdk.android.tools;

import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* loaded from: classes.dex */
public final class APKUtils {
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final String CHANNEL_ID = "channelId";
    private static final int MIN_EOCD_SIZE = 22;
    private static String mPackageChannelId;
    protected static final ZipLong CODE_SIG = new ZipLong(101010256);
    private static ZipShort protoHead = new ZipShort(38650);

    /* JADX WARN: Code restructure failed: missing block: B:10:0x000d, code lost:
    
        if (r2.length() == 0) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getPackageChannelId(android.content.Context r1, java.lang.String r2) {
        /*
            java.lang.String r0 = com.tencent.imsdk.android.tools.APKUtils.mPackageChannelId
            if (r0 == 0) goto L5
            return r0
        L5:
            if (r1 == 0) goto L13
            if (r2 == 0) goto Lf
            int r0 = r2.length()     // Catch: java.io.IOException -> L28
            if (r0 != 0) goto L13
        Lf:
            java.lang.String r2 = r1.getPackageCodePath()     // Catch: java.io.IOException -> L28
        L13:
            java.lang.String r1 = com.tencent.imsdk.android.tools.apkchannel.v2.ApkChannelTool.readChannel(r2)     // Catch: java.io.IOException -> L28
            if (r1 == 0) goto L1c
            com.tencent.imsdk.android.tools.APKUtils.mPackageChannelId = r1     // Catch: java.io.IOException -> L28
            goto L47
        L1c:
            java.io.File r1 = new java.io.File     // Catch: java.io.IOException -> L28
            r1.<init>(r2)     // Catch: java.io.IOException -> L28
            java.lang.String r1 = readChannelId(r1)     // Catch: java.io.IOException -> L28
            com.tencent.imsdk.android.tools.APKUtils.mPackageChannelId = r1     // Catch: java.io.IOException -> L28
            goto L47
        L28:
            r1 = move-exception
            r2 = 0
            com.tencent.imsdk.android.tools.APKUtils.mPackageChannelId = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "read apk file for channelId exception : "
            r2.append(r0)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.tencent.imsdk.android.tools.log.IMLogger.e(r1, r2)
        L47:
            java.lang.String r1 = com.tencent.imsdk.android.tools.APKUtils.mPackageChannelId
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.tools.APKUtils.getPackageChannelId(android.content.Context, java.lang.String):java.lang.String");
    }

    /* loaded from: classes.dex */
    public static final class ZipLong implements Cloneable {
        private long value;

        public ZipLong(byte[] bArr) {
            this(bArr, 0);
        }

        public ZipLong(byte[] bArr, int i) {
            this.value = (bArr[i + 3] << 24) & 4278190080L;
            this.value += (bArr[i + 2] << 16) & 16711680;
            this.value += (bArr[i + 1] << 8) & 65280;
            this.value += bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        }

        public ZipLong(long j) {
            this.value = j;
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof ZipLong) && this.value == ((ZipLong) obj).getValue();
        }

        public byte[] getBytes() {
            long j = this.value;
            return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
        }

        public long getValue() {
            return this.value;
        }

        public int hashCode() {
            return (int) this.value;
        }
    }

    /* loaded from: classes.dex */
    public static final class ZipShort implements Cloneable {
        private int value;

        public ZipShort(byte[] bArr) {
            this(bArr, 0);
        }

        public ZipShort(byte[] bArr, int i) {
            this.value = (bArr[i + 1] << 8) & 65280;
            this.value += bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
        }

        public ZipShort(int i) {
            this.value = i;
        }

        public boolean equals(Object obj) {
            return obj != null && (obj instanceof ZipShort) && this.value == ((ZipShort) obj).getValue();
        }

        public byte[] getBytes() {
            int i = this.value;
            return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
        }

        public int getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ApkExternalInfo {
        byte[] otherData;
        Properties p;

        private ApkExternalInfo() {
            this.p = new Properties();
        }

        void decode(byte[] bArr) throws IOException {
            if (bArr == null) {
                return;
            }
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = APKUtils.protoHead.getBytes().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!APKUtils.protoHead.equals(new ZipShort(bArr2))) {
                throw new ProtocolException("unknown protocol [" + Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            wrap.get(bArr3);
            int value = new ZipShort(bArr3).getValue();
            if ((bArr.length - length) - 2 < value) {
                return;
            }
            byte[] bArr4 = new byte[value];
            wrap.get(bArr4);
            this.p.load(new ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - value) - 2;
            if (length2 > 0) {
                this.otherData = new byte[length2];
                wrap.get(this.otherData);
            }
        }

        public String toString() {
            return "ApkExternalInfo [p=" + this.p + ", otherData=" + Arrays.toString(this.otherData) + "]";
        }
    }

    public static String read(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(file, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
            try {
                byte[] readComment = readComment(randomAccessFile);
                if (readComment != null) {
                    ApkExternalInfo apkExternalInfo = new ApkExternalInfo();
                    apkExternalInfo.decode(readComment);
                    String property = apkExternalInfo.p.getProperty(str);
                    randomAccessFile.close();
                    return property;
                }
                randomAccessFile.close();
                return null;
            } catch (Throwable th) {
                th = th;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile = null;
        }
    }

    public static String readChannelId(File file) throws IOException {
        return read(file, "channelId");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] readComment(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = CODE_SIG.getBytes();
        int read = randomAccessFile.read();
        while (true) {
            z = true;
            if (read == -1) {
                z = false;
                break;
            }
            if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
            read = randomAccessFile.read();
        }
        if (!z) {
            throw new ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek(length + 16 + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        int value = new ZipShort(bArr).getValue();
        if (value == 0) {
            return null;
        }
        byte[] bArr2 = new byte[value];
        randomAccessFile.read(bArr2);
        return bArr2;
    }
}
