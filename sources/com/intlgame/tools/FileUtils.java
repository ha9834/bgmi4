package com.intlgame.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.amazonaws.event.ProgressEvent;
import com.helpshift.db.conversation.tables.ConversationTable;
import com.intlgame.INTLApp;
import com.intlgame.foundation.INTLLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class FileUtils {
    private static final String INTL_SHARE_PREFERENCE_FILE_NAME = "INTL";

    private File getAbsoluteFilePath(String str, boolean z) {
        File file = new File(str);
        if (file.isFile()) {
            return file;
        }
        return new File(filePathForINTL(z) + File.separator + str);
    }

    public String filePathForINTL(boolean z) {
        File externalFilesDir;
        Context appContext = INTLApp.getInstance().getAppContext();
        if (z) {
            externalFilesDir = appContext.getFilesDir();
        } else {
            externalFilesDir = appContext.getExternalFilesDir(INTL_SHARE_PREFERENCE_FILE_NAME);
            if (externalFilesDir == null) {
                externalFilesDir = appContext.getFilesDir();
            }
        }
        externalFilesDir.exists();
        externalFilesDir.isDirectory();
        externalFilesDir.mkdirs();
        return externalFilesDir.toString();
    }

    public String isFileExist(String str, boolean z, boolean z2) {
        try {
            File absoluteFilePath = getAbsoluteFilePath(str, z);
            return (absoluteFilePath.exists() || (z2 && absoluteFilePath.createNewFile())) ? absoluteFilePath.getAbsolutePath() : "";
        } catch (IOException e) {
            e.getMessage();
            INTLLog.e(e.getMessage());
            return "";
        }
    }

    public static boolean isFileExist(String str) {
        if (str == null || str.trim().length() == 0) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public boolean writeFile(String str, byte[] bArr, boolean z) {
        StringBuilder sb;
        FileOutputStream fileOutputStream;
        if (isFileExist(str, z, true).isEmpty()) {
            return false;
        }
        File absoluteFilePath = getAbsoluteFilePath(str, z);
        FileOutputStream fileOutputStream2 = null;
        INTLLog.d("data length = " + bArr.length);
        try {
            try {
                fileOutputStream = new FileOutputStream(absoluteFilePath);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
        } catch (IOException e2) {
            e = e2;
        }
        try {
            fileOutputStream.write(bArr);
            try {
                fileOutputStream.close();
                return true;
            } catch (IOException e3) {
                INTLLog.e("error occur while close file " + e3.getMessage());
                return true;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            INTLLog.e(e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    e = e5;
                    sb = new StringBuilder();
                    sb.append("error occur while close file ");
                    sb.append(e.getMessage());
                    INTLLog.e(sb.toString());
                    return false;
                }
            }
            return false;
        } catch (IOException e6) {
            e = e6;
            fileOutputStream2 = fileOutputStream;
            INTLLog.e(e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e7) {
                    e = e7;
                    sb = new StringBuilder();
                    sb.append("error occur while close file ");
                    sb.append(e.getMessage());
                    INTLLog.e(sb.toString());
                    return false;
                }
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e8) {
                    INTLLog.e("error occur while close file " + e8.getMessage());
                }
            }
            throw th;
        }
    }

    public byte[] readFile(String str, boolean z) {
        byte[] bArr;
        StringBuilder sb;
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        r1 = null;
        byte[] bArr2 = null;
        FileInputStream fileInputStream3 = null;
        FileInputStream fileInputStream4 = null;
        if (isFileExist(str, z, false).isEmpty()) {
            return null;
        }
        File absoluteFilePath = getAbsoluteFilePath(str, z);
        new StringBuilder();
        try {
            try {
                fileInputStream = new FileInputStream(absoluteFilePath);
            } catch (Throwable th) {
                th = th;
            }
        } catch (FileNotFoundException e) {
            e = e;
            bArr = null;
        } catch (IOException e2) {
            e = e2;
            bArr = null;
        }
        try {
            bArr2 = new byte[fileInputStream.available()];
            if (fileInputStream.read(bArr2) == -1) {
                INTLLog.e("read from file error");
            }
            try {
                fileInputStream.close();
            } catch (IOException e3) {
                INTLLog.e("error occur while close file " + e3.getMessage());
            }
            bArr = bArr2;
            fileInputStream2 = bArr2;
        } catch (FileNotFoundException e4) {
            e = e4;
            byte[] bArr3 = bArr2;
            fileInputStream3 = fileInputStream;
            bArr = bArr3;
            INTLLog.e(e.getMessage());
            fileInputStream2 = fileInputStream3;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                    fileInputStream2 = fileInputStream3;
                } catch (IOException e5) {
                    e = e5;
                    sb = new StringBuilder();
                    sb.append("error occur while close file ");
                    sb.append(e.getMessage());
                    INTLLog.e(sb.toString());
                    return bArr;
                }
            }
            return bArr;
        } catch (IOException e6) {
            e = e6;
            byte[] bArr4 = bArr2;
            fileInputStream4 = fileInputStream;
            bArr = bArr4;
            INTLLog.e("error occur while file read " + e.getMessage());
            fileInputStream2 = fileInputStream4;
            if (fileInputStream4 != null) {
                try {
                    fileInputStream4.close();
                    fileInputStream2 = fileInputStream4;
                } catch (IOException e7) {
                    e = e7;
                    sb = new StringBuilder();
                    sb.append("error occur while close file ");
                    sb.append(e.getMessage());
                    INTLLog.e(sb.toString());
                    return bArr;
                }
            }
            return bArr;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e8) {
                    INTLLog.e("error occur while close file " + e8.getMessage());
                }
            }
            throw th;
        }
        return bArr;
    }

    public boolean renameFile(String str, String str2, boolean z) {
        File absoluteFilePath = getAbsoluteFilePath(str, z);
        return absoluteFilePath.exists() && absoluteFilePath.renameTo(getAbsoluteFilePath(str2, z));
    }

    public boolean deleteFile(String str, boolean z) {
        File absoluteFilePath = getAbsoluteFilePath(str, z);
        return absoluteFilePath.exists() && absoluteFilePath.delete();
    }

    public boolean deleteDir(File file) {
        File file2;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isFile()) {
            return file.delete();
        }
        if (file.isDirectory()) {
            if (file.list() == null) {
                INTLLog.e(file.getAbsolutePath() + " is not a path");
                return false;
            }
            if (file.list().length == 0) {
                return file.delete();
            }
        }
        String[] list = file.list();
        String absolutePath = file.getAbsolutePath();
        for (int i = 0; i < list.length; i++) {
            if (absolutePath.endsWith(File.separator)) {
                file2 = new File(absolutePath + list[i]);
            } else {
                file2 = new File(absolutePath + File.separator + list[i]);
            }
            if (!deleteDir(file2)) {
                return false;
            }
        }
        return true;
    }

    public boolean setSharePreference(String str, String str2, boolean z) {
        return setSharePreference(INTL_SHARE_PREFERENCE_FILE_NAME, str, str2, z);
    }

    public boolean setSharePreference(String str, String str2, String str3, boolean z) {
        SharedPreferences.Editor edit = INTLApp.getInstance().getAppContext().getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
        return true;
    }

    public String getSharePreferenceByKey(String str, boolean z) {
        return getSharePreferenceByKey(INTL_SHARE_PREFERENCE_FILE_NAME, str, z);
    }

    public String getSharePreferenceByKey(String str, String str2, boolean z) {
        return INTLApp.getInstance().getAppContext().getSharedPreferences(str, 0).getString(str2, "");
    }

    public String getiTopOneGuestInfo() {
        return INTLApp.getInstance().getAppContext().getSharedPreferences("device_id", 0).getString(ConversationTable.Columns.LOCAL_UUID, "");
    }

    public void deleteSharePreferenceItem(String str, boolean z) {
        deleteSharePreferenceItem(INTL_SHARE_PREFERENCE_FILE_NAME, str, z);
    }

    public void deleteSharePreferenceItem(String str, String str2, boolean z) {
        SharedPreferences.Editor edit = INTLApp.getInstance().getAppContext().getSharedPreferences(str, 0).edit();
        edit.remove(str2);
        edit.apply();
    }

    public void deleteSharePreference(boolean z) {
        deleteSharePreference(INTL_SHARE_PREFERENCE_FILE_NAME, z);
    }

    public void deleteSharePreference(String str, boolean z) {
        SharedPreferences.Editor edit = INTLApp.getInstance().getAppContext().getSharedPreferences(str, 0).edit();
        edit.clear();
        edit.apply();
    }

    public byte[] readFileFromAssets(String str) {
        byte[] bArr = null;
        try {
            InputStream open = INTLApp.getInstance().getAppContext().getAssets().open(str);
            bArr = new byte[open.available()];
            if (open.read(bArr) == -1) {
                INTLLog.e("read from asset error");
            }
        } catch (IOException e) {
            INTLLog.e(e.getMessage());
        }
        return bArr;
    }

    public boolean copyFileFromAssets(String str, String str2) {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            INTLLog.e("path is null or empty");
            return false;
        }
        Context appContext = INTLApp.getInstance().getAppContext();
        FileOutputStream fileOutputStream2 = null;
        try {
            File file = new File(str2);
            inputStream = appContext.getAssets().open(str);
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                byte[] bArr = new byte[ProgressEvent.PART_COMPLETED_EVENT_CODE];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                fileOutputStream.close();
                inputStream.close();
                try {
                    fileOutputStream.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
                return true;
            } catch (IOException e3) {
                e = e3;
                fileOutputStream2 = fileOutputStream;
                INTLLog.w("file copy exception, msg: " + e.getMessage());
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                        return false;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream2 = fileOutputStream;
                if (fileOutputStream2 != null) {
                    try {
                        fileOutputStream2.close();
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        throw th;
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (IOException e6) {
            e = e6;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
        }
    }

    public String getExternalStorageDirectory(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (!"mounted".equals(Environment.getExternalStorageState())) {
            INTLLog.e("SD卡没有挂载");
            return null;
        }
        if (INTLApp.getInstance().getAppContext() == null) {
            INTLLog.e("INTL没有初始化，获取包名失败");
            return null;
        }
        if (str == null) {
            str = "";
        }
        File file = new File(externalStorageDirectory, INTLApp.getInstance().getAppContext().getPackageName() + "/" + str);
        StringBuilder sb = new StringBuilder();
        sb.append("Sdcard filepath:");
        sb.append(file.getAbsolutePath());
        INTLLog.d(sb.toString());
        if (!file.exists() && !file.mkdir()) {
            INTLLog.e("创建文件目录失败，请检查权限！");
            return null;
        }
        return file.getAbsolutePath();
    }

    public String readText(String str) {
        FileInputStream fileInputStream;
        byte[] bArr;
        if (str == null || "".equals(str)) {
            return "";
        }
        File file = new File(str);
        if (!file.exists() || !file.canRead()) {
            return "";
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
            }
        } catch (IOException e2) {
            INTLLog.e(e2.getMessage());
        }
        try {
            bArr = new byte[fileInputStream.available()];
        } catch (Exception e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            INTLLog.e(e.getMessage());
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    INTLLog.e(e4.getMessage());
                }
            }
            throw th;
        }
        if (fileInputStream.read(bArr) <= 0) {
            fileInputStream.close();
            return "";
        }
        String str2 = new String(bArr);
        try {
            fileInputStream.close();
        } catch (IOException e5) {
            INTLLog.e(e5.getMessage());
        }
        return str2;
    }

    public boolean writeText(String str, String str2) {
        FileOutputStream fileOutputStream;
        INTLLog.d("path:" + str + "  text:" + str2);
        if (str == null || "".equals(str) || str2 == null) {
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    return false;
                }
            } catch (Exception e) {
                INTLLog.e(e.getMessage());
                return false;
            }
        }
        if (!file.exists() || !file.canRead()) {
            return false;
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(str);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e2) {
            e = e2;
        }
        try {
            fileOutputStream.write(str2.getBytes());
            try {
                fileOutputStream.close();
            } catch (IOException e3) {
                INTLLog.e(e3.getMessage());
            }
            return true;
        } catch (Exception e4) {
            e = e4;
            fileOutputStream2 = fileOutputStream;
            INTLLog.e(e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e5) {
                    INTLLog.e(e5.getMessage());
                }
            }
            return true;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException e6) {
                    INTLLog.e(e6.getMessage());
                }
            }
            throw th;
        }
    }
}
