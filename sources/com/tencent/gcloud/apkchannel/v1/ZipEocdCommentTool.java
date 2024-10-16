package com.tencent.gcloud.apkchannel.v1;

import android.util.Log;
import com.helpshift.analytics.AnalyticsEventKey;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.zip.ZipException;

/* loaded from: classes2.dex */
public final class ZipEocdCommentTool {
    private static final int CFD_LOCATOR_OFFSET = 16;
    private static final ZipLong EOCD_SIG = new ZipLong(101010256);
    private static final int MIN_EOCD_SIZE = 22;
    private static final String TAG = "ZipEocdCommentTool";

    public static boolean clearComment(String str) throws Exception {
        if (str == null || str.length() <= 0) {
            return false;
        }
        byte[] bArr = {0};
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            throw new Exception("Your file length is zero !!");
        }
        byte[] readComment = readComment(randomAccessFile);
        long length = readComment != null ? readComment.length : 0;
        long length2 = (randomAccessFile.length() - length) + bArr.length;
        randomAccessFile.seek((randomAccessFile.length() - 2) - length);
        randomAccessFile.write(0);
        randomAccessFile.write(bArr);
        randomAccessFile.setLength(length2);
        randomAccessFile.close();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] readComment(RandomAccessFile randomAccessFile) throws IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bytes = EOCD_SIG.getBytes();
        while (true) {
            int read = randomAccessFile.read();
            z = false;
            if (read != -1) {
                if (read == bytes[0] && randomAccessFile.read() == bytes[1] && randomAccessFile.read() == bytes[2] && randomAccessFile.read() == bytes[3]) {
                    z = true;
                    break;
                }
                length--;
                if (length < 0) {
                    break;
                }
                randomAccessFile.seek(length);
            } else {
                break;
            }
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

    public static byte[] readComment(String str) throws IOException {
        if (str == null || str.length() <= 0) {
            return null;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            Log.e(TAG, "apollo0511 readComment ERROR:[ZipEocdCommentTool]Your file length is zero!");
            return null;
        }
        byte[] readComment = readComment(randomAccessFile);
        randomAccessFile.close();
        return readComment;
    }

    public static boolean updateComment(String str, byte[] bArr) throws Exception {
        if (bArr == null || str == null || str.length() <= 0) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(str, "rw");
        if (randomAccessFile.length() == 0) {
            randomAccessFile.close();
            throw new Exception("Your file length is zero !!");
        }
        byte[] readComment = readComment(randomAccessFile);
        long length = readComment != null ? readComment.length : 0;
        long length2 = (randomAccessFile.length() - length) + bArr.length;
        randomAccessFile.seek((randomAccessFile.length() - 2) - length);
        randomAccessFile.write(new ZipShort(bArr.length).getBytes());
        randomAccessFile.write(bArr);
        randomAccessFile.setLength(length2);
        randomAccessFile.close();
        return true;
    }
}
