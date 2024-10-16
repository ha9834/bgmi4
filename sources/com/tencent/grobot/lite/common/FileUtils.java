package com.tencent.grobot.lite.common;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.tencent.grobot.lite.GRobotApplication;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes2.dex */
public class FileUtils {
    public static final String GLOBAL_BASE_DIRECTORY = Environment.getExternalStorageDirectory().getAbsolutePath();
    protected static final String TAG = "FileUtils";
    private static String sPhotoRootDir;

    @TargetApi(8)
    private static String getPathRootDir(String str) {
        File file;
        Context self = GRobotApplication.self();
        String str2 = null;
        if (self == null) {
            return null;
        }
        if (isSDCardExistAndCanWrite()) {
            if (Build.VERSION.SDK_INT < 23) {
                file = Environment.getExternalStorageDirectory();
            } else {
                try {
                    file = (File) self.getClass().getMethod("getExternalFilesDir", String.class).invoke(self, "");
                } catch (Exception e) {
                    TLog.e(TAG, "getExternalFilesDir Exception" + e);
                    file = null;
                }
            }
            if (file != null) {
                str2 = file.getAbsolutePath() + str;
            }
        } else {
            str2 = self.getFilesDir().getAbsolutePath() + str;
        }
        createNewDir(str2);
        return str2;
    }

    public static void createNewDir(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        try {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists()) {
                parentFile.mkdirs();
            }
            file.mkdirs();
        } catch (Exception e) {
            TLog.e(TAG, "createNewFile Exception " + e);
        }
    }

    public static boolean isSDCardExistAndCanWrite() {
        return "mounted".equals(Environment.getExternalStorageState());
    }

    public static String getTmpPhotoRootDir() {
        if (TextUtils.isEmpty(sPhotoRootDir)) {
            String pathRootDir = getPathRootDir("/grobot/tmppic");
            File file = new File(pathRootDir);
            if (!file.exists()) {
                try {
                    file.mkdirs();
                } catch (Exception e) {
                    TLog.d(TAG, "mkdir failed, dir=" + pathRootDir + ", " + e.getMessage());
                }
            }
            sPhotoRootDir = pathRootDir;
        }
        return sPhotoRootDir;
    }

    public static boolean saveBitmapToCamera(Context context, Bitmap bitmap, String str, Bitmap.CompressFormat compressFormat) {
        String str2 = GLOBAL_BASE_DIRECTORY + File.separator + "DCIM" + File.separator + "Camera" + File.separator + str;
        if (compressFormat == Bitmap.CompressFormat.JPEG) {
            str2 = str2 + ".jpg";
        } else if (compressFormat == Bitmap.CompressFormat.PNG) {
            str2 = str2 + ".png";
        }
        return saveBitmapToSDFile(context, bitmap, str2, str, compressFormat);
    }

    public static boolean saveBitmapToSDFile(Context context, Bitmap bitmap, String str, String str2, Bitmap.CompressFormat compressFormat) {
        try {
            createNewFile(str, false);
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            boolean compress = bitmap.compress(compressFormat, 100, fileOutputStream);
            fileOutputStream.close();
            if (!compress) {
                return compress;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("title", str2);
            contentValues.put("description", "");
            contentValues.put("mime_type", "image/jpeg");
            context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + str)));
            return compress;
        } catch (Exception unused) {
            TLog.e(TAG, "saveBitmapToSDFile fail");
            return false;
        }
    }

    public static File createNewFile(String str, boolean z) {
        File file = new File(str);
        if (!z && file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                File parentFile = file.getParentFile();
                if (parentFile != null && !parentFile.exists()) {
                    parentFile.mkdirs();
                }
                file.createNewFile();
            } catch (Exception e) {
                TLog.e(TAG, "createNewFile Exception " + e);
            }
        }
        return file;
    }
}
