package com.helpshift.support.imageloader;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.helpshift.util.AndroidFileUtil;
import com.helpshift.util.Callback;
import com.helpshift.util.HSLogger;
import com.helpshift.util.ImageUtil;

/* loaded from: classes2.dex */
class FilePathBitmapProvider implements BitmapProvider {
    private static final String TAG = "Helpshift_FilePthPrvdr";
    private String path;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilePathBitmapProvider(String str) {
        this.path = str;
    }

    @Override // com.helpshift.support.imageloader.BitmapProvider
    public void getBitmap(int i, boolean z, Callback<Bitmap, String> callback) {
        Bitmap decodeFile = decodeFile(this.path, i);
        if (decodeFile != null) {
            int exifRotation = getExifRotation(this.path);
            if (exifRotation != 0) {
                Matrix matrix = new Matrix();
                matrix.preRotate(exifRotation);
                decodeFile = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, false);
            }
            callback.onSuccess(decodeFile);
            HSLogger.d(TAG, "Image loaded from filepath: " + this.path);
            return;
        }
        callback.onFailure("Error in creating bitmap for given file path: " + this.path);
    }

    @Override // com.helpshift.support.imageloader.BitmapProvider
    public String getSource() {
        return this.path;
    }

    protected Bitmap decodeFile(String str, int i) {
        return ImageUtil.decodeFile(str, i);
    }

    private static int getExifRotation(String str) {
        try {
            String mimeType = AndroidFileUtil.getMimeType(str);
            if (mimeType != null && mimeType.contains("jpeg")) {
                int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
                if (attributeInt == 6) {
                    return 90;
                }
                if (attributeInt == 3) {
                    return 180;
                }
                return attributeInt == 8 ? 270 : 0;
            }
        } catch (Exception e) {
            HSLogger.e("", "Exception in getting exif rotation", e);
        }
        return 0;
    }
}
