package com.amazonaws.util;

import com.adjust.sdk.Constants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.logging.LogFactory;

/* loaded from: classes.dex */
public class Md5Utils {
    private static final int FOURTEEN = 14;
    private static final int SIXTEEN_K = 16384;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] computeMD5Hash(InputStream inputStream) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
                byte[] bArr = new byte[SIXTEEN_K];
                while (true) {
                    int read = bufferedInputStream.read(bArr, 0, bArr.length);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                byte[] digest = messageDigest.digest();
                try {
                    bufferedInputStream.close();
                } catch (Exception e) {
                    LogFactory.getLog(Md5Utils.class).debug("Unable to close input stream of hash candidate: " + e);
                }
                return digest;
            } catch (Throwable th) {
                try {
                    bufferedInputStream.close();
                } catch (Exception e2) {
                    LogFactory.getLog(Md5Utils.class).debug("Unable to close input stream of hash candidate: " + e2);
                }
                throw th;
            }
        } catch (NoSuchAlgorithmException e3) {
            throw new IllegalStateException(e3);
        }
    }

    public static String md5AsBase64(InputStream inputStream) throws IOException {
        return Base64.encodeAsString(computeMD5Hash(inputStream));
    }

    public static byte[] computeMD5Hash(byte[] bArr) {
        try {
            return MessageDigest.getInstance(Constants.MD5).digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    public static String md5AsBase64(byte[] bArr) {
        return Base64.encodeAsString(computeMD5Hash(bArr));
    }

    public static byte[] computeMD5Hash(File file) throws IOException {
        return computeMD5Hash(new FileInputStream(file));
    }

    public static String md5AsBase64(File file) throws IOException {
        return Base64.encodeAsString(computeMD5Hash(file));
    }
}
