package com.ihoc.mgpa.n;

import com.tencent.mtt.engine.http.HttpUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: classes2.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f5672a = "0123456789ABCDEF".toCharArray();

    public static String a(String str, String str2) {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        String str3 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, HttpUtils.DEFAULT_ENCODE_NAME));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.contains(str2)) {
                    str3 = readLine.trim();
                    break;
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        fileInputStream.close();
        return str3;
    }

    public static boolean a(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean a(File file, File file2) {
        if (file == null || !file.exists() || file2 == null || file2.exists() || file.getName().equals(file2.getName())) {
            return false;
        }
        return file.renameTo(file2);
    }

    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean b(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean b(String str) {
        return a(d(str));
    }

    public static boolean b(String str, String str2) {
        return a(d(str), d(str2));
    }

    public static long c(File file) {
        return file.lastModified();
    }

    public static void c(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                try {
                    fileOutputStream = new FileOutputStream(str);
                } catch (Exception unused) {
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(str2.getBytes());
                fileOutputStream.close();
            } catch (Exception unused2) {
                fileOutputStream2 = fileOutputStream;
                m.b("TGPA", "FileUtil:saveFile: exception.");
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean c(String str) {
        return str != null && b(d(str));
    }

    public static File d(String str) {
        if (str == null) {
            return null;
        }
        return new File(str);
    }

    public static String d(File file) {
        if (file != null) {
            return file.getName();
        }
        return null;
    }

    public static long e(File file) {
        long j = 0;
        if (!file.isDirectory()) {
            return 0 + file.length();
        }
        for (File file2 : file.listFiles()) {
            j += e(file2);
        }
        return j;
    }

    public static long e(String str) {
        return c(d(str));
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        return d(d(str));
    }

    public static boolean f(File file) {
        return file != null && file.exists();
    }

    public static String g(String str) {
        int lastIndexOf;
        return (str == null || str.length() <= 0 || (lastIndexOf = str.lastIndexOf(46)) <= -1 || lastIndexOf >= str.length()) ? str : str.substring(0, lastIndexOf);
    }

    public static boolean h(String str) {
        return f(d(str));
    }

    public static String i(String str) {
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bArr = new byte[1024];
        StringBuilder sb = new StringBuilder("");
        while (true) {
            try {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    sb.append(new String(bArr, 0, read));
                } catch (Exception unused) {
                    m.b("TGPA", "FileUtil:readFile: exception.");
                }
            } finally {
                fileInputStream.close();
            }
        }
        return sb.toString();
    }

    public static String j(String str) {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        String readLine = bufferedReader.readLine();
        bufferedReader.close();
        if (readLine != null) {
            return readLine.trim();
        }
        return null;
    }
}
