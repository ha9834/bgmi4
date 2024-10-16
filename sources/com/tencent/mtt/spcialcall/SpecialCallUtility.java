package com.tencent.mtt.spcialcall;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.widget.Toast;
import com.adjust.sdk.Constants;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.mtt.common.utils.MttResources;
import com.tencent.mtt.engine.AppEngine;
import java.io.File;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public class SpecialCallUtility {
    private static final int SAVE_IMAGE_FAIL = 1;
    private static final int SAVE_IMAGE_SUCCESS = 0;
    private static Handler mHandler = new Handler() { // from class: com.tencent.mtt.spcialcall.SpecialCallUtility.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SpecialCallUtility.scanImage(Uri.parse((String) message.obj));
                    Toast.makeText(AppEngine.getInstance().getContext(), MttResources.getStringId("thrdcall_save_success"), 0).show();
                    return;
                case 1:
                    Toast.makeText(AppEngine.getInstance().getContext(), MttResources.getStringId("thrdcall_image_viewer_save_failed"), 0).show();
                    return;
                default:
                    return;
            }
        }
    };

    /* JADX WARN: Type inference failed for: r1v1, types: [com.tencent.mtt.spcialcall.SpecialCallUtility$2] */
    public static void saveImage(String str, final Bitmap bitmap) {
        new Thread("saveImage") { // from class: com.tencent.mtt.spcialcall.SpecialCallUtility.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String insertImage;
                super.run();
                Message obtainMessage = SpecialCallUtility.mHandler.obtainMessage();
                obtainMessage.what = 1;
                if (bitmap != null && (insertImage = MediaStore.Images.Media.insertImage(AppEngine.getInstance().getContext().getContentResolver(), bitmap, String.valueOf(System.currentTimeMillis()), "")) != null) {
                    obtainMessage.what = 0;
                    obtainMessage.obj = insertImage;
                }
                obtainMessage.sendToTarget();
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void scanImage(Uri uri) {
        Cursor query = AppEngine.getInstance().getContext().getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
        if (query == null) {
            return;
        }
        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
        query.moveToFirst();
        AppEngine.getInstance().getContext().sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.parse("file://" + new File(query.getString(columnIndexOrThrow)).getAbsolutePath())));
        query.close();
    }

    public static byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(Constants.MD5);
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String byteToHexString(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED) < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Long.toString(bArr[i] & DeviceInfos.NETWORK_TYPE_UNCONNECTED, 16));
        }
        return stringBuffer.toString();
    }
}
