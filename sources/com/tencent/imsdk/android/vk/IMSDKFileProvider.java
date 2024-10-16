package com.tencent.imsdk.android.vk;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.io.File;

/* loaded from: classes.dex */
public class IMSDKFileProvider extends FileProvider {
    public static final String FILE_SCHEME = "file://";
    public static final String FILE_SCHEME_CONTENT = "content://";

    public static Uri getUriFromPath(Context context, String str) {
        try {
            if (context == null) {
                IMLogger.w("context is  null", new Object[0]);
                return null;
            }
            String str2 = context.getPackageName() + ".IMSDKFileProvider";
            IMLogger.d("IMSDKFileProvider is : " + str2);
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
                return getUriForFile(context, str2, file);
            }
            return Uri.fromFile(file);
        } catch (Exception e) {
            IMLogger.e(e.getMessage(), new Object[0]);
            return null;
        }
    }
}
