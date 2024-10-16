package com.tencent.smtt.utils;

import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public class LogFileUtils {

    /* renamed from: a, reason: collision with root package name */
    private static OutputStream f6535a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void writeDataToStorage(File file, String str, byte[] bArr, String str2, boolean z) {
        String str3;
        String str4;
        synchronized (LogFileUtils.class) {
            Log.d("LogFileUtils", "writeDataToStorage");
            byte[] encrypt = encrypt(str, str2);
            if (encrypt != null) {
                str2 = null;
            } else {
                encrypt = null;
            }
            try {
                try {
                    file.getParentFile().mkdirs();
                    if (file.isFile() && file.exists() && file.length() > 2097152) {
                        file.delete();
                        file.createNewFile();
                    }
                    if (f6535a == null) {
                        f6535a = new BufferedOutputStream(new FileOutputStream(file, z));
                    }
                    if (str2 != null) {
                        Log.d("LogFileUtils", "writeDataToStorage #1");
                        f6535a.write(str2.getBytes());
                        Log.d("LogFileUtils", "writeDataToStorage #2");
                    } else {
                        Log.d("LogFileUtils", "writeDataToStorage #3");
                        f6535a.write(bArr);
                        Log.d("LogFileUtils", "writeDataToStorage #4");
                        f6535a.write(encrypt);
                        Log.d("LogFileUtils", "writeDataToStorage #5");
                        f6535a.write(new byte[]{10, 10});
                        Log.d("LogFileUtils", "writeDataToStorage #6");
                    }
                    if (f6535a != null) {
                        try {
                            f6535a.flush();
                        } catch (Throwable th) {
                            str3 = "LOG_FILE";
                            str4 = "writeDataToStorage outputStream.flush() exception:" + th;
                            Log.i(str3, str4);
                        }
                    }
                } catch (Throwable th2) {
                    Log.d("LogFileUtils", "writeDataToStorage exception, swap_str:" + str2 + ",keyHeadText:" + bArr + ",swap_bytes:" + encrypt + ",append=" + z + ",detail:" + th2);
                    Log.i("LOG_FILE", "writeDataToStorage exception, swap_str:" + str2 + ",keyHeadText:" + bArr + ",swap_bytes:" + encrypt + ",append=" + z + ",detail:" + th2);
                    if (f6535a != null) {
                        try {
                            f6535a.flush();
                        } catch (Throwable th3) {
                            str3 = "LOG_FILE";
                            str4 = "writeDataToStorage outputStream.flush() exception:" + th3;
                            Log.i(str3, str4);
                        }
                    }
                }
            } finally {
            }
        }
    }

    public static void closeOutputStream(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                Log.e("LOG_FILE", "Couldn't close stream!", e);
            }
        }
    }

    public static byte[] encrypt(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static String createKey() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static byte[] encryptKey(String str, String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            Cipher cipher = Cipher.getInstance("RC4");
            cipher.init(1, new SecretKeySpec(str.getBytes("UTF-8"), "RC4"));
            return cipher.update(bytes);
        } catch (Throwable th) {
            Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static byte[] createHeaderText(String str, String str2) {
        try {
            byte[] encryptKey = encryptKey(str, str2);
            String format = String.format("%03d", Integer.valueOf(encryptKey.length));
            byte[] bArr = new byte[encryptKey.length + 3];
            bArr[0] = (byte) format.charAt(0);
            bArr[1] = (byte) format.charAt(1);
            bArr[2] = (byte) format.charAt(2);
            System.arraycopy(encryptKey, 0, bArr, 3, encryptKey.length);
            return bArr;
        } catch (Exception unused) {
            return null;
        }
    }
}
