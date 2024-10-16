package com.tencent.gcloud.qr;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.tencent.gcloud.qr.defines.QRResult;
import com.tencent.gcloud.qr.zxing.EncodeUtil;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.io.File;

/* loaded from: classes2.dex */
public class QRCodeAPI {
    private static final int MSG_TAG = 0;
    private static final String TAG = "ApolloQR";
    private static QRCodeAPI mInstance;
    private EncodeUtil mQREncodeUtil = null;
    private String mAppPath = null;
    private String mLaunchURL = "AUTOSTART";
    private Handler mHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.gcloud.qr.QRCodeAPI.2
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.obj == null) {
                Log.e(QRCodeAPI.TAG, "QRCodeAPI handler Message is null");
            } else {
                if (message.what != 0) {
                    return;
                }
                QRResult qRResult = (QRResult) message.obj;
                QRCodeAPI.this.OnGenerateQRImage(qRResult.getTag(), qRResult.getRetCode(), qRResult.getImagePath());
            }
        }
    };

    private synchronized void GenerateQRImage(final int i, boolean z, final String str, final Bitmap bitmap) {
        if (this.mAppPath != null) {
            new Thread(new Runnable() { // from class: com.tencent.gcloud.qr.QRCodeAPI.1
                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    int i2;
                    String str2 = "QR_" + String.valueOf((System.currentTimeMillis() / 1000) + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + i);
                    String str3 = QRCodeAPI.this.mAppPath + "/" + str2 + ".jpg";
                    try {
                        bitmap2 = QRCodeAPI.this.mQREncodeUtil.createQRCode(str, bitmap);
                    } catch (Exception e) {
                        Log.e(QRCodeAPI.TAG, "QRCodeAPI GenerateQRImage error=" + e.toString());
                        bitmap2 = null;
                    }
                    if (bitmap2 == null) {
                        i2 = 1;
                    } else if (QRCodeAPI.this.mQREncodeUtil.writeToFile(bitmap2, QRCodeAPI.this.mAppPath, str2)) {
                        i2 = 0;
                    } else {
                        Log.e(QRCodeAPI.TAG, "QRCodeAPI GenerateQRImage QRRetCode.SystemError: 11");
                        i2 = 11;
                    }
                    QRResult qRResult = new QRResult(i, i2, 0, str3);
                    Message obtain = Message.obtain();
                    obtain.obj = qRResult;
                    obtain.what = 0;
                    QRCodeAPI.this.mHandler.sendMessage(obtain);
                }
            }).start();
        } else {
            Log.e(TAG, "QRCodeAPI GenerateQRImage savePath is null");
            OnGenerateQRImage(i, 23, "");
        }
    }

    private native void genQRImgNotify(int i, int i2, String str);

    public static QRCodeAPI getInstance() {
        if (mInstance == null) {
            mInstance = new QRCodeAPI();
        }
        return mInstance;
    }

    private native void launchNotify(String str);

    public synchronized void GenerateQRImage(int i, int i2, String str, String str2) {
        if (this.mQREncodeUtil != null && str != null) {
            if (str2 == null) {
                Log.d(TAG, "QRCodeAPI GenerateQRLogoImage logoPath is null");
                GenerateQRImage(i, true, str, (Bitmap) null);
                return;
            }
            if (!new File(str2).exists()) {
                Log.e(TAG, "QRCodeAPI GenerateQRLogoImage logoFile not exists");
                GenerateQRImage(i, true, str, (Bitmap) null);
                return;
            }
            Bitmap decodeFile = BitmapFactory.decodeFile(str2);
            if (decodeFile == null) {
                Log.e(TAG, "QRCodeAPI GenerateQRLogoImage Bitmap logo is null");
                OnGenerateQRImage(i, 10, "error");
                return;
            } else {
                this.mQREncodeUtil.setQRCodeSize(i2);
                GenerateQRImage(i, true, str, decodeFile);
                return;
            }
        }
        Log.e(TAG, "QRCodeAPI GenerateQRLogoImage content is null");
        OnGenerateQRImage(i, 10, "error");
    }

    public boolean Initialize(Activity activity) {
        if (activity == null) {
            Log.e(TAG, "QRCodeAPI Initialize Activity is null");
            return false;
        }
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState == null || !externalStorageState.equals("mounted")) {
            Log.e(TAG, "QRCodeAPI Initialize getExternalCacheDir failed");
            this.mAppPath = activity.getApplicationContext().getFilesDir().getPath();
        } else {
            File externalCacheDir = activity.getApplicationContext().getExternalCacheDir();
            if (externalCacheDir == null) {
                externalCacheDir = activity.getApplicationContext().getFilesDir();
            }
            this.mAppPath = externalCacheDir.getPath();
            Log.d(TAG, "QRCodeAPI Initialize mAppPath: " + this.mAppPath);
        }
        if (this.mQREncodeUtil == null) {
            this.mQREncodeUtil = new EncodeUtil();
        }
        return RefreshLaunch(activity.getIntent());
    }

    public void OnGenerateQRImage(int i, int i2, String str) {
        try {
            genQRImgNotify(i, i2, str);
        } catch (Exception e) {
            Log.e(TAG, "QRCodeAPI OnGenerateQRImage Exception:" + e.toString());
        }
    }

    public void QRCodeInit() {
        try {
            qrCodeInit();
        } catch (Throwable th) {
            Log.e(TAG, "QRCodeAPI QRCoceInit jni error=" + th.toString());
        }
    }

    public boolean RefreshLaunch(Intent intent) {
        if (intent == null) {
            Log.e(TAG, "QRCodeAPI RefreshLaunch Intent is null");
            return false;
        }
        Uri data = intent.getData();
        this.mLaunchURL = data == null ? "" : data.toString();
        Log.d(TAG, "QRCodeAPI RefreshLaunch mLaunchURL:" + this.mLaunchURL);
        if (!this.mLaunchURL.equals("")) {
            try {
                launchNotify(this.mLaunchURL);
                return true;
            } catch (Throwable th) {
                Log.e(TAG, "QRCodeAPI RefreshLaunch launchNotify jni error:" + th.toString());
            }
        }
        return false;
    }

    public void init() {
        if (mInstance == null) {
            mInstance = new QRCodeAPI();
        }
    }

    public native void qrCodeInit();
}
