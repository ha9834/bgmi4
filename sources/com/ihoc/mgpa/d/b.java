package com.ihoc.mgpa.d;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.ihoc.mgpa.n.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes2.dex */
public class b {
    public static File a(Context context) {
        return context.getDir("lib", 0);
    }

    public static boolean a(Context context, String str) {
        try {
            System.loadLibrary(str);
            return true;
        } catch (SecurityException | UnsatisfiedLinkError e) {
            m.a("load tgpa so lib by system failed!!!", e);
            return c(context, str);
        }
    }

    private static File b(Context context, String str) {
        return new File(a(context), System.mapLibraryName(str));
    }

    private static boolean c(Context context, String str) {
        if (context == null) {
            return false;
        }
        File b = b(context, str);
        if (!b.exists()) {
            m.b("can not find lib file && unzip lib file failed. lib path: " + b.getAbsolutePath(), new Object[0]);
            if (!d(context, str)) {
                m.b("can not unzip lib file. lib path: " + b.getAbsolutePath(), new Object[0]);
                return false;
            }
        }
        if (!b.canRead()) {
            m.b("can not read lib file: " + b.getAbsolutePath(), new Object[0]);
            return false;
        }
        try {
            System.load(b.getAbsolutePath());
            return true;
        } catch (SecurityException e) {
            m.a("load lib exception! ", e);
            return false;
        } catch (UnsatisfiedLinkError e2) {
            m.a("load lib exception! ", e2);
            return false;
        }
    }

    private static boolean d(Context context, String str) {
        Throwable th;
        InputStream inputStream;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            ZipFile zipFile = new ZipFile(new File(applicationInfo.sourceDir), 1);
            StringBuilder sb = new StringBuilder();
            sb.append("lib/");
            sb.append(Build.CPU_ABI);
            sb.append("/");
            sb.append(System.mapLibraryName(str));
            String sb2 = sb.toString();
            ZipEntry entry = zipFile.getEntry(sb2);
            if (entry == null) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(applicationInfo.sourceDir);
                sb3.append(" doesn't have file ");
                sb3.append(sb2);
                m.b(sb3.toString(), new Object[0]);
                zipFile.close();
                return false;
            }
            File b = b(context, str);
            if (!b.exists()) {
                return false;
            }
            try {
                if (!b.createNewFile()) {
                    throw new IOException();
                }
                FileOutputStream fileOutputStream = null;
                try {
                    inputStream = zipFile.getInputStream(entry);
                    try {
                        FileOutputStream fileOutputStream2 = new FileOutputStream(b);
                        try {
                            byte[] bArr = new byte[16384];
                            while (true) {
                                int read = inputStream.read(bArr);
                                if (read <= 0) {
                                    break;
                                }
                                fileOutputStream2.write(bArr, 0, read);
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    fileOutputStream2.close();
                                    throw th2;
                                }
                            }
                            fileOutputStream2.close();
                            b.setReadable(true, false);
                            b.setExecutable(true, false);
                            b.setWritable(true);
                            zipFile.close();
                            return true;
                        } catch (Throwable th3) {
                            th = th3;
                            fileOutputStream = fileOutputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } finally {
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = null;
                }
            } catch (IOException e) {
                if (b.exists() && !b.delete()) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Failed to delete ");
                    sb4.append(b.getAbsolutePath());
                    m.b(sb4.toString(), new Object[0]);
                }
                zipFile.close();
                throw e;
            }
        } catch (IOException e2) {
            m.a("Failed to unpack native libraries", e2);
            return false;
        }
    }
}
