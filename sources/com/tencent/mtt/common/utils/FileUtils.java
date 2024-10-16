package com.tencent.mtt.common.utils;

import android.os.Environment;
import com.tencent.mtt.engine.AppEngine;
import java.io.File;

/* loaded from: classes.dex */
public class FileUtils {
    private static final String DIR_DATA = "data";
    private static final String DIR_EXT_MAIN = "QQBrowser";

    public static File getShareCacheDir() {
        File file;
        if (isExtStorageReady()) {
            file = new File(getExternalRootDir(), ".TempShare");
        } else {
            file = new File(getDataDir(), "TempShare");
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    private static boolean isExtStorageReady() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static File getExternalRootDir() {
        File file = new File(Environment.getExternalStorageDirectory(), DIR_EXT_MAIN);
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File getDir(File file, String str) {
        if (file == null || str == null || str.length() == 0) {
            return null;
        }
        File file2 = new File(file, str);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static File getDataDir() {
        return getDir(getFilesDir(), "data");
    }

    public static File getFilesDir() {
        return AppEngine.getInstance().getContext().getFilesDir();
    }
}
