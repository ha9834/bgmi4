package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.drive.DriveFile;

/* loaded from: classes2.dex */
public class TbsVideo {
    public static void openVideo(Context context, String str) {
        openVideo(context, str, null);
    }

    public static void openVideo(Context context, String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            Log.e("TbsVideo", "videoUrl is empty!");
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("videoUrl", str);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.setFlags(DriveFile.MODE_READ_ONLY);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extraData", bundle);
        context.startActivity(intent);
    }

    public static boolean openYunboVideo(Context context, String str, Bundle bundle, com.tencent.tbs.video.interfaces.a aVar) {
        if (canUseYunbo(context)) {
            return m.a(context).a(str, bundle, aVar);
        }
        return false;
    }

    public static boolean canUseTbsPlayer(Context context) {
        return m.a(context).a();
    }

    public static boolean canUseYunbo(Context context) {
        return m.a(context).a() && QbSdk.canUseVideoFeatrue(context, 1);
    }
}
