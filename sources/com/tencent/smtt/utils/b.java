package com.tencent.smtt.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;

@SuppressLint({"NewApi"})
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f6539a;
    public static final a b = new a() { // from class: com.tencent.smtt.utils.b.1
    };
    private static RandomAccessFile c;

    /* loaded from: classes2.dex */
    public interface a {
    }

    public static String a(Context context, int i) {
        return a(context, context.getApplicationInfo().packageName, i, true);
    }

    public static String a(Context context, String str, int i, boolean z) {
        if (context == null) {
            return "";
        }
        String str2 = "";
        try {
            str2 = Environment.getExternalStorageDirectory() + File.separator;
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (i) {
            case 1:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + File.separator + "tbs" + File.separator + str;
            case 2:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tbs" + File.separator + "backup" + File.separator + str;
            case 3:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
            case 4:
                if (str2.equals("")) {
                    return a(context, "backup");
                }
                String str3 = str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + str;
                if (!z) {
                    return str3;
                }
                File file = new File(str3);
                if (file.exists() && file.canWrite()) {
                    return str3;
                }
                if (!file.exists()) {
                    file.mkdirs();
                    return !file.canWrite() ? a(context, "backup") : str3;
                }
                return a(context, "backup");
            case 5:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + File.separator + "tbs" + File.separator + str;
            case 6:
                String str4 = f6539a;
                if (str4 != null) {
                    return str4;
                }
                f6539a = a(context, "tbslog");
                return f6539a;
            case 7:
                if (str2.equals("")) {
                    return str2;
                }
                return str2 + "tencent" + File.separator + "tbs" + File.separator + "backup" + File.separator + "core";
            default:
                return "";
        }
    }

    private static String a(Context context, String str) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        try {
            return context.getExternalFilesDir(str).getAbsolutePath();
        } catch (Throwable th) {
            th.printStackTrace();
            try {
                return Environment.getExternalStorageDirectory() + File.separator + "Android" + File.separator + "data" + File.separator + context.getApplicationInfo().packageName + File.separator + "files" + File.separator + str;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    public static void a(File file, boolean z) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            a(file2, z);
        }
        if (z) {
            return;
        }
        file.delete();
    }

    public static void a(File file, boolean z, String str) {
        TbsLog.i("FileUtils", "delete file,ignore=" + z + "except" + str + file + Log.getStackTraceString(new Throwable()));
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            if (!file2.getName().equals(str)) {
                a(file2, z);
            }
        }
        if (z) {
            return;
        }
        file.delete();
    }

    public static String a(Context context) {
        return Environment.getExternalStorageDirectory() + File.separator + "tbs" + File.separator + "file_locks";
    }

    static String b(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_private");
        if (file.isDirectory() || file.mkdir()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static File a(Context context, boolean z, String str) {
        String a2;
        if (z) {
            a2 = b(context);
        } else {
            a2 = a(context);
        }
        if (a2 == null) {
            return null;
        }
        File file = new File(a2);
        if (!file.exists()) {
            file.mkdirs();
        }
        if (!file.canWrite()) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return file2;
    }

    public static FileOutputStream b(Context context, boolean z, String str) {
        Log.d("FileHelper", "TbsInstaller--getLockFos of filename: " + str);
        File a2 = a(context, z, str);
        if (a2 == null) {
            return null;
        }
        try {
            return new FileOutputStream(a2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static FileLock a(Context context, FileOutputStream fileOutputStream) {
        FileLock tryLock;
        if (fileOutputStream == null) {
            return null;
        }
        try {
            tryLock = fileOutputStream.getChannel().tryLock();
        } catch (OverlappingFileLockException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (tryLock.isValid()) {
            return tryLock;
        }
        return null;
    }

    public static void a(FileLock fileLock, FileOutputStream fileOutputStream) {
        if (fileLock != null) {
            try {
                FileChannel channel = fileLock.channel();
                if (channel != null && channel.isOpen()) {
                    fileLock.release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
