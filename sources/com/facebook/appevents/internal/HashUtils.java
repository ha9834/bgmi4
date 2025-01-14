package com.facebook.appevents.internal;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/* loaded from: classes.dex */
final class HashUtils {
    private static final String MD5 = "MD5";

    HashUtils() {
    }

    public static final String computeChecksum(String str) throws Exception {
        return computeFileMd5(new File(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String computeFileMd5(File file) throws Exception {
        int read;
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1024);
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[1024];
            do {
                read = bufferedInputStream.read(bArr);
                if (read > 0) {
                    messageDigest.update(bArr, 0, read);
                }
            } while (read != -1);
            String bigInteger = new BigInteger(1, messageDigest.digest()).toString(16);
            bufferedInputStream.close();
            return bigInteger;
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    bufferedInputStream.close();
                } catch (Throwable unused) {
                }
            } else {
                bufferedInputStream.close();
            }
            throw th;
        }
    }
}
