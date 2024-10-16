package com.tencent.imsdk.android.tools;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.adjust.sdk.Constants;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Keep
/* loaded from: classes.dex */
public class FileUtils {
    public static final String FILE_EXTENSION_SEPARATOR = ".";
    private static final String GZ_EXT = ".gz";
    public static final String LOG_TAG = "iMSDK";
    protected static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private FileUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x019b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x017a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0159 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void insert(java.lang.String r6, long r7, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 444
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.tools.FileUtils.insert(java.lang.String, long, java.lang.String):void");
    }

    public static String getMd5ByFile(File file) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(new FileInputStream(file).getChannel().map(FileChannel.MapMode.READ_ONLY, 0L, file.length()));
            return bufferToHex(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static String bufferToHex(byte[] bArr) {
        return bufferToHex(bArr, 0, bArr.length);
    }

    private static String bufferToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer(i2 * 2);
        int i3 = i2 + i;
        while (i < i3) {
            appendHexPair(bArr[i], stringBuffer);
            i++;
        }
        return stringBuffer.toString();
    }

    private static void appendHexPair(byte b, StringBuffer stringBuffer) {
        char[] cArr = hexDigits;
        char c = cArr[(b & 240) >> 4];
        char c2 = cArr[b & 15];
        stringBuffer.append(c);
        stringBuffer.append(c2);
    }

    public static File[] getZipFiles(File file) {
        return file.listFiles(new FilenameFilter() { // from class: com.tencent.imsdk.android.tools.FileUtils.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(FileUtils.GZ_EXT);
            }
        });
    }

    public static File[] getLogFiles(File file) {
        return file.listFiles(new FilenameFilter() { // from class: com.tencent.imsdk.android.tools.FileUtils.2
            @Override // java.io.FilenameFilter
            public boolean accept(File file2, String str) {
                return str.endsWith(LogUtils.LOG_EXT);
            }
        });
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                Log.d(LOG_TAG, "close got io error : " + e.getMessage());
            } catch (Exception e2) {
                Log.d(LOG_TAG, "close got error : " + e2.getMessage());
            }
        }
    }

    public static long calSize(String str) {
        return calSize(new File(str));
    }

    public static long calSize(File file) {
        long length;
        long j = 0;
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                if (file2.isDirectory()) {
                    length = calSize(file2);
                } else {
                    length = file2.length();
                }
                j += length;
            }
            return j;
        }
        if (file.isFile()) {
            return 0 + file.length();
        }
        return 0L;
    }

    public static void zipLogs(File file) {
        try {
            String absolutePath = file.getAbsolutePath();
            int lastIndexOf = absolutePath.lastIndexOf(46);
            if (lastIndexOf == -1) {
                return;
            }
            zip(absolutePath, absolutePath.substring(0, lastIndexOf) + GZ_EXT, true);
        } catch (Exception e) {
            Log.d(LOG_TAG, " zipLogs exception = " + e.getMessage());
        }
    }

    public static List<File> getConformFiles(String str, String str2, File[] fileArr) {
        try {
            ArrayList arrayList = new ArrayList();
            Long valueOf = Long.valueOf(Long.parseLong(str.trim()));
            Long valueOf2 = Long.valueOf(Long.parseLong(str2.trim()));
            for (int i = 0; i < fileArr.length; i++) {
                String name = fileArr[i].getName();
                if (name.length() > 53) {
                    long longValue = Long.valueOf(name.substring(name.length() - 17, name.length() - 5)).longValue();
                    if (longValue > valueOf.longValue() && longValue < valueOf2.longValue()) {
                        arrayList.add(fileArr[i]);
                    }
                }
            }
            return arrayList;
        } catch (Exception e) {
            Log.d(LOG_TAG, " getConformFiles exception = " + e.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zip(String str, String str2, boolean z) {
        String str3;
        StringBuilder sb;
        ZipOutputStream zipOutputStream;
        ZipOutputStream zipOutputStream2 = null;
        try {
            try {
                zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            File file = new File(str);
            zip(zipOutputStream, file, (String) null);
            if (z) {
                deleteFile(file.getAbsolutePath());
            }
            try {
                zipOutputStream.close();
            } catch (Exception e2) {
                e = e2;
                str3 = LOG_TAG;
                sb = new StringBuilder();
                sb.append(" zip zos exception = ");
                sb.append(e.getMessage());
                Log.d(str3, sb.toString());
            }
        } catch (Exception e3) {
            e = e3;
            zipOutputStream2 = zipOutputStream;
            Log.d(LOG_TAG, " zip deleteFile exception = " + e.getMessage());
            if (zipOutputStream2 != null) {
                try {
                    zipOutputStream2.close();
                } catch (Exception e4) {
                    e = e4;
                    str3 = LOG_TAG;
                    sb = new StringBuilder();
                    sb.append(" zip zos exception = ");
                    sb.append(e.getMessage());
                    Log.d(str3, sb.toString());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                try {
                    zipOutputStream2.close();
                } catch (Exception e5) {
                    Log.d(LOG_TAG, " zip zos exception = " + e5.getMessage());
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v20 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v22 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.io.BufferedInputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zip(ZipOutputStream zipOutputStream, File file, String str) {
        String str2;
        StringBuilder sb;
        byte[] bArr;
        BufferedInputStream bufferedInputStream;
        int read;
        String name = file.getName();
        if (!TextUtils.isEmpty(str)) {
            name = str + File.separator + file.getName();
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                zip(zipOutputStream, file2, name);
            }
            return;
        }
        ?? r7 = 0;
        BufferedInputStream bufferedInputStream2 = null;
        try {
            try {
                bArr = new byte[1024];
                bufferedInputStream = new BufferedInputStream(new FileInputStream(file), 1024);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            zipOutputStream.putNextEntry(new ZipEntry(name));
            while (true) {
                read = bufferedInputStream.read(bArr, 0, 1024);
                if (read == -1) {
                    break;
                } else {
                    zipOutputStream.write(bArr, 0, read);
                }
            }
            zipOutputStream.closeEntry();
            try {
                bufferedInputStream.close();
                r7 = read;
            } catch (Exception e2) {
                e = e2;
                str2 = LOG_TAG;
                sb = new StringBuilder();
                sb.append(" zip bis exception = ");
                sb.append(e.getMessage());
                Log.d(str2, sb.toString());
            }
        } catch (Exception e3) {
            e = e3;
            bufferedInputStream2 = bufferedInputStream;
            Log.d(LOG_TAG, " zip zos exception = " + e.getMessage());
            r7 = bufferedInputStream2;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                    r7 = bufferedInputStream2;
                } catch (Exception e4) {
                    e = e4;
                    str2 = LOG_TAG;
                    sb = new StringBuilder();
                    sb.append(" zip bis exception = ");
                    sb.append(e.getMessage());
                    Log.d(str2, sb.toString());
                }
            }
        } catch (Throwable th2) {
            th = th2;
            r7 = bufferedInputStream;
            if (r7 != 0) {
                try {
                    r7.close();
                } catch (Exception e5) {
                    Log.d(LOG_TAG, " zip bis exception = " + e5.getMessage());
                }
            }
            throw th;
        }
    }

    public static void sortByModifyDateDesc(File[] fileArr) {
        Arrays.sort(fileArr, new Comparator<File>() { // from class: com.tencent.imsdk.android.tools.FileUtils.3
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                long lastModified = file.lastModified() - file2.lastModified();
                if (lastModified > 0) {
                    return 1;
                }
                return lastModified == 0 ? 0 : -1;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.StringBuilder readFile(java.lang.String r4, java.lang.String r5) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r4.<init>(r1)
            boolean r1 = r0.isFile()
            r2 = 0
            if (r1 != 0) goto L14
            return r2
        L14:
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            r1.<init>(r3, r5)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L5e java.io.IOException -> L61
        L23:
            java.lang.String r0 = r5.readLine()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L8b
            if (r0 == 0) goto L3e
            java.lang.String r1 = r4.toString()     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L8b
            java.lang.String r3 = ""
            boolean r1 = r1.equals(r3)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L8b
            if (r1 != 0) goto L3a
            java.lang.String r1 = "\r\n"
            r4.append(r1)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L8b
        L3a:
            r4.append(r0)     // Catch: java.io.IOException -> L62 java.lang.Throwable -> L8b
            goto L23
        L3e:
            r5.close()     // Catch: java.lang.Exception -> L42
            goto L5d
        L42:
            r5 = move-exception
            java.lang.String r0 = "iMSDK"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = " StringBuilder reader exception = "
            r1.append(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            android.util.Log.d(r0, r5)
        L5d:
            return r4
        L5e:
            r4 = move-exception
            r5 = r2
            goto L8c
        L61:
            r5 = r2
        L62:
            java.lang.String r4 = "iMSDK"
            java.lang.String r0 = "IOException occurred. "
            android.util.Log.d(r4, r0)     // Catch: java.lang.Throwable -> L8b
            if (r5 == 0) goto L8a
            r5.close()     // Catch: java.lang.Exception -> L6f
            goto L8a
        L6f:
            r4 = move-exception
            java.lang.String r5 = "iMSDK"
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " StringBuilder reader exception = "
            r0.append(r1)
            java.lang.String r4 = r4.getMessage()
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            android.util.Log.d(r5, r4)
        L8a:
            return r2
        L8b:
            r4 = move-exception
        L8c:
            if (r5 == 0) goto Lad
            r5.close()     // Catch: java.lang.Exception -> L92
            goto Lad
        L92:
            r5 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = " StringBuilder reader exception = "
            r0.append(r1)
            java.lang.String r5 = r5.getMessage()
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "iMSDK"
            android.util.Log.d(r0, r5)
        Lad:
            throw r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.android.tools.FileUtils.readFile(java.lang.String, java.lang.String):java.lang.StringBuilder");
    }

    public static boolean writeFile(String str, String str2, boolean z) {
        FileWriter fileWriter;
        if (str2 == null || str2.length() == 0) {
            return false;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                makeDirs(str);
                fileWriter = new FileWriter(str, z);
            } catch (IOException e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(str2);
            try {
                fileWriter.close();
            } catch (Exception e2) {
                Log.d(LOG_TAG, " writeFile fileWriter exception = " + e2.getMessage());
            }
            return true;
        } catch (IOException e3) {
            e = e3;
            fileWriter2 = fileWriter;
            Log.d(LOG_TAG, " writeFile fileWriter exception = " + e.getMessage());
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (Exception e4) {
                    Log.d(LOG_TAG, " writeFile fileWriter exception = " + e4.getMessage());
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (Exception e5) {
                    Log.d(LOG_TAG, " writeFile fileWriter exception = " + e5.getMessage());
                }
            }
            throw th;
        }
    }

    public static String getFileNameWithoutExtension(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf2 == -1) {
            return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
        }
        if (lastIndexOf == -1) {
            return str.substring(lastIndexOf2 + 1);
        }
        return lastIndexOf2 < lastIndexOf ? str.substring(lastIndexOf2 + 1, lastIndexOf) : str.substring(lastIndexOf2 + 1);
    }

    public static String getFileName(String str) {
        int lastIndexOf;
        return ((str == null && str.length() == 0) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? str : str.substring(lastIndexOf + 1);
    }

    public static String getFolderName(String str) {
        if (str == null && str.length() == 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? "" : str.substring(0, lastIndexOf);
    }

    public static String getFileExtension(String str) {
        if (str == null || str.trim().length() == 0) {
            return str;
        }
        int lastIndexOf = str.lastIndexOf(".");
        return (lastIndexOf != -1 && str.lastIndexOf(File.separator) < lastIndexOf) ? str.substring(lastIndexOf + 1) : "";
    }

    public static boolean makeDirs(String str) {
        String folderName = getFolderName(str);
        if (str == null && str.length() == 0) {
            return false;
        }
        File file = new File(folderName);
        if (file.exists() && file.isDirectory()) {
            return true;
        }
        return file.mkdirs();
    }

    public static boolean isFileExist(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public static boolean isFolderExist(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isDirectory();
    }

    public static boolean deleteFile(String str) {
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    File file = new File(str);
                    if (!file.exists()) {
                        return true;
                    }
                    if (file.isFile()) {
                        return file.delete();
                    }
                    if (!file.isDirectory()) {
                        return false;
                    }
                    if (file.listFiles() != null) {
                        for (File file2 : file.listFiles()) {
                            if (file2.isFile()) {
                                file2.delete();
                            } else if (file2.isDirectory()) {
                                deleteFile(file2.getAbsolutePath());
                            }
                        }
                    } else {
                        Log.d(LOG_TAG, "not sub files in path : " + str);
                    }
                    return file.delete();
                }
            } catch (Exception e) {
                Log.d(LOG_TAG, " deleteFile file exception = " + e.getMessage());
                return false;
            }
        }
        return true;
    }
}
