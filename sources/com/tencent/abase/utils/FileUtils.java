package com.tencent.abase.utils;

import android.util.Log;
import com.adjust.sdk.Constants;
import com.helpshift.analytics.AnalyticsEventKey;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes.dex */
public class FileUtils {
    private static final String TAG = "ABase.FileUtils";
    private static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String fileToSHA1(String str) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
                int i = 0;
                while (i != -1) {
                    i = fileInputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    }
                }
                String convertHashToString = convertHashToString(messageDigest.digest());
                closeQuietly(fileInputStream);
                return convertHashToString;
            } catch (Exception unused) {
                closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                closeQuietly(fileInputStream);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
        }
    }

    public static String filePartToSHA1(String str, long j, long j2) {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        int read;
        RandomAccessFile randomAccessFile2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(Constants.SHA1);
                randomAccessFile = new RandomAccessFile(str, AnalyticsEventKey.SMART_INTENT_SEARCH_RANK);
                try {
                    byte[] bArr = new byte[1024];
                    randomAccessFile.seek(j);
                    for (int i = 0; i < j2 / 1024 && (read = randomAccessFile.read(bArr)) != -1; i++) {
                        messageDigest.update(bArr, 0, read);
                    }
                    String convertHashToString = convertHashToString(messageDigest.digest());
                    closeQuietly(randomAccessFile);
                    closeQuietly(fileInputStream);
                    return convertHashToString;
                } catch (Exception unused) {
                    closeQuietly(randomAccessFile);
                    closeQuietly(fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile2 = randomAccessFile;
                    closeQuietly(randomAccessFile2);
                    closeQuietly(fileInputStream);
                    throw th;
                }
            } catch (Exception unused2) {
                randomAccessFile = null;
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused3) {
            fileInputStream = null;
            randomAccessFile = null;
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    private static String convertHashToString(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + Integer.toString((b & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + 256, 16).substring(1);
        }
        return str.toLowerCase();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String readStreamToString(InputStream inputStream) {
        StringBuilder sb;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                sb = new StringBuilder(inputStream.available() + 10);
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read > 0) {
                    sb.append(cArr, 0, read);
                } else {
                    String sb2 = sb.toString();
                    closeQuietly(bufferedReader);
                    closeQuietly(inputStream);
                    return sb2;
                }
            }
        } catch (IOException e2) {
            e = e2;
            bufferedReader2 = bufferedReader;
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
            closeQuietly(bufferedReader2);
            closeQuietly(inputStream);
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            closeQuietly(bufferedReader2);
            closeQuietly(inputStream);
            throw th;
        }
    }

    public static String readFileToString(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e) {
            e = e;
        }
        try {
            String readStreamToString = readStreamToString(fileInputStream);
            closeQuietly(fileInputStream);
            return readStreamToString;
        } catch (IOException e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            e.printStackTrace();
            Log.e(TAG, e.getMessage());
            closeQuietly(fileInputStream2);
            return "";
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            closeQuietly(fileInputStream2);
            throw th;
        }
    }

    public static String getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(bArr);
            byte[] digest = messageDigest.digest();
            char[] cArr = new char[digest.length * 2];
            int i = 0;
            for (byte b : digest) {
                int i2 = i + 1;
                cArr[i] = hexDigits[(b >>> 4) & 15];
                i = i2 + 1;
                cArr[i2] = hexDigits[b & 15];
            }
            return new String(cArr);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final String getMD5(InputStream inputStream) {
        int i;
        if (inputStream == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            StringBuilder sb = new StringBuilder(32);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                messageDigest.update(bArr, 0, read);
            }
            for (byte b : messageDigest.digest()) {
                sb.append(Integer.toString((b & DeviceInfos.NETWORK_TYPE_UNCONNECTED) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String getMD5(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                String md5 = getMD5(fileInputStream);
                closeQuietly(fileInputStream);
                return md5;
            } catch (Exception unused) {
                closeQuietly(fileInputStream);
                return null;
            } catch (Throwable th) {
                th = th;
                fileInputStream2 = fileInputStream;
                closeQuietly(fileInputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean verifyFileMd5(File file, String str) {
        String md5;
        if (str == null || (md5 = getMD5(file)) == null) {
            return false;
        }
        return str.equals(md5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String loadDigestes(JarFile jarFile, JarEntry jarEntry) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedInputStream bufferedInputStream = null;
        try {
            InputStream inputStream = jarFile.getInputStream(jarEntry);
            byte[] bArr = new byte[16384];
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStream);
            while (true) {
                try {
                    int read = bufferedInputStream2.read(bArr);
                    if (read > 0) {
                        sb.append(new String(bArr, 0, read));
                    } else {
                        closeQuietly(bufferedInputStream2);
                        return sb.toString();
                    }
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    closeQuietly(bufferedInputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static final boolean isLegalFile(File file) {
        return file != null && file.exists() && file.canRead() && file.isFile() && file.length() > 0;
    }

    public static void copyFileUsingStream(File file, File file2) throws IOException {
        FileInputStream fileInputStream;
        if (!isLegalFile(file) || file2 == null || file.getAbsolutePath().equals(file2.getAbsolutePath())) {
            return;
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2, false);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read > 0) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            closeQuietly(fileInputStream);
                            closeQuietly(fileOutputStream2);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    closeQuietly(fileInputStream);
                    closeQuietly(fileOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    public static final boolean safeDeleteFile(File file) {
        if (file == null || !file.exists()) {
            return true;
        }
        Log.i(TAG, "safeDeleteFile, try to delete path: " + file.getPath());
        boolean delete = file.delete();
        if (!delete) {
            Log.e(TAG, "Failed to delete file, try to delete when exit. path: " + file.getPath());
            file.deleteOnExit();
        }
        return delete;
    }

    public static final boolean deleteDir(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            safeDeleteFile(file);
        } else if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteDir(file2);
            }
            safeDeleteFile(file);
        }
        return file.delete();
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
