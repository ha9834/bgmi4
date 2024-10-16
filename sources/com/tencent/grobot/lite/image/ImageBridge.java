package com.tencent.grobot.lite.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.a;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.core.IServiceCallback;
import com.tencent.grobot.lite.image.download.ImageService;

/* loaded from: classes2.dex */
public class ImageBridge {
    private static final String TAG = "ImageBridge";
    private static final String TAG_YUN_OPERATE = "?imageMogr2";

    public static void loadImage(Context context, String str, int i, int i2, int i3, ImageView imageView) {
        loadImage(context, str, i, i2, i3, imageView, null);
    }

    public static void loadImage(Context context, String str, int i, int i2, int i3, ImageView imageView, IServiceCallback iServiceCallback) {
        String str2;
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        if (str != null) {
            if (!str.contains("http") && !str.contains("https")) {
                str = "http:" + str;
            }
            if (layoutParams == null || layoutParams.width <= 0 || layoutParams.height <= 0 || str.contains(TAG_YUN_OPERATE)) {
                str2 = str;
            } else {
                str2 = str + TAG_YUN_OPERATE + "/thumbnail/" + layoutParams.width + "x" + layoutParams.height;
            }
        } else {
            str2 = str;
        }
        Drawable a2 = i > 0 ? a.a(context, i) : null;
        Drawable a3 = i2 > 0 ? a.a(context, i2) : null;
        ImageService imageService = (ImageService) GRobotApplication.getInstance().getService(ImageService.class);
        if (imageService != null) {
            TLog.d(TAG, "loadImage, url=" + str2);
            imageService.load(context, str2, a2, a3, i3, imageView, iServiceCallback);
        }
    }
}
