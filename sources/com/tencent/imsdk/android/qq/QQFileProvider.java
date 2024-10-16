package com.tencent.imsdk.android.qq;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.io.File;

/* loaded from: classes.dex */
public class QQFileProvider extends FileProvider {
    public static final String FILE_SCHEME = "file://";
    public static final String FILE_SCHEME_CONTENT = "content://";

    public static String getFileProviderAuthority(Context context) {
        return context.getPackageName() + ".QQFileProvider";
    }

    public static Uri getUriFromPath(Context context, String str) {
        try {
            if (context == null) {
                IMLogger.w("context is  null", new Object[0]);
                return null;
            }
            String fileProviderAuthority = getFileProviderAuthority(context);
            IMLogger.d("QQFileProvider is : " + fileProviderAuthority);
            if (str.startsWith("content://")) {
                return Uri.parse(str);
            }
            if (str.startsWith("file://")) {
                str = str.replaceFirst("file://", "");
            }
            File file = new File(str);
            if (!file.exists()) {
                IMLogger.d(str + "file not exist ");
                return null;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                return getUriForFile(context, fileProviderAuthority, file);
            }
            return Uri.fromFile(file);
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
            return null;
        }
    }
}
