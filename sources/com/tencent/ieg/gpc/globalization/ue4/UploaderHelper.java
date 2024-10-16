package com.tencent.ieg.gpc.globalization.ue4;

import android.app.Activity;
import com.tencent.ieg.gpc.globalization.base.GGConfig;
import com.tencent.ieg.gpc.globalization.base.GGResult;
import com.tencent.ieg.gpc.globalization.base.GGReusltRunnable;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploadResult;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploader;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderListener;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderManager;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderProgressRunnable;
import com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderState;
import com.tencent.ieg.gpc.globalization.utils.GGLog;
import java.io.File;
import java.util.Map;

/* loaded from: classes2.dex */
public class UploaderHelper {
    private static final String CALLBACK_FUN_COMPLETE = "OnAWSUploadCompleted";
    private static final String CALLBACK_FUN_PROGRESS = "OnAWSUploading";
    private static final String TAG = "UploaderHelper";
    private static final String UNITY_GAME_OBJECT = "AWSUploadCallBackGameObj";
    private static Activity _currentAcitivty = null;
    private static String _uploaderChannel = "AWS";
    private static long mUploadingCompleteCallbackPointer;
    private static long mUploadingProgressCallbackPointer;
    private static GGUploader uploader;

    public static native void onUplaodProgress(long j, int i, long j2, long j3);

    public static native void onUploadComplete(long j, int i, String str);

    public static boolean initialize(Activity activity) {
        GGLog.d(TAG, "in initialize : ");
        _currentAcitivty = activity;
        GGConfig.initialize(activity);
        return true;
    }

    public static void setAuthorData(Map<String, String> map) {
        GGLog.d(TAG, "in setAuthorData " + map.toString());
        GGUploader.authorData = map;
    }

    public static void setCallbackPointer(long j, long j2) {
        mUploadingProgressCallbackPointer = j;
        mUploadingCompleteCallbackPointer = j2;
    }

    public static void upload(String str, String str2) {
        GGLog.d(TAG, "Upload File: " + str + " to " + str2);
        if (!isFileExist(str)) {
            callbackWithResult(new GGResult(5, "File not exist!"));
            return;
        }
        if (_currentAcitivty == null || _uploaderChannel.isEmpty()) {
            callbackWithResult(new GGResult(4, "Plugin should initialize first!"));
            return;
        }
        GGUploaderListener gGUploaderListener = new GGUploaderListener() { // from class: com.tencent.ieg.gpc.globalization.ue4.UploaderHelper.1
            @Override // com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderListener
            public void onStateChanged(int i, GGUploaderState gGUploaderState, String str3) {
                GGLog.d(UploaderHelper.TAG, "onStateChanged Share state chagned:" + gGUploaderState.name() + " and external:" + str3);
                switch (AnonymousClass3.$SwitchMap$com$tencent$ieg$gpc$globalization$base$uploader$GGUploaderState[gGUploaderState.ordinal()]) {
                    case 1:
                        GGUploadResult gGUploadResult = new GGUploadResult(1, "success");
                        gGUploadResult.fileUrl = str3;
                        UploaderHelper.callbackWithResult(gGUploadResult);
                        return;
                    case 2:
                        UploaderHelper.callbackWithResult(new GGResult(2, "User canceled!!"));
                        return;
                    case 3:
                        UploaderHelper.callbackWithResult(new GGResult(3, "Upload Timeout!"));
                        return;
                    case 4:
                        UploaderHelper.callbackWithResult(new GGResult(0, "Unknown error!"));
                        return;
                    default:
                        return;
                }
            }

            @Override // com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderListener
            public void onProgressChanged(int i, long j, long j2) {
                GGLog.d(UploaderHelper.TAG, "onProgressChanged");
                UploaderHelper._currentAcitivty.runOnUiThread(new GGUploaderProgressRunnable(i, j, j2) { // from class: com.tencent.ieg.gpc.globalization.ue4.UploaderHelper.1.1
                    @Override // com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderProgressRunnable, java.lang.Runnable
                    public void run() {
                        try {
                            GGLog.d(UploaderHelper.TAG, "{\"id\" : " + String.valueOf(this.mId) + ", \"current\": " + String.valueOf(this.mBytesCurrent) + ", \"total\": " + String.valueOf(this.mBytesTotal) + "}");
                            UploaderHelper.onUplaodProgress(UploaderHelper.mUploadingProgressCallbackPointer, this.mId, this.mBytesCurrent, this.mBytesTotal);
                        } catch (Exception e) {
                            GGLog.e(UploaderHelper.TAG, e.getMessage());
                        }
                    }
                });
            }

            @Override // com.tencent.ieg.gpc.globalization.base.uploader.GGUploaderListener
            public void onError(int i, Exception exc) {
                GGLog.d(UploaderHelper.TAG, "onError:" + exc.getMessage());
                UploaderHelper.callbackWithResult(new GGResult(0, exc.getMessage()));
            }
        };
        if (uploader == null) {
            uploader = GGUploaderManager.GetInstance(_currentAcitivty).getUploader(_uploaderChannel);
        }
        uploader.setListener(gGUploaderListener);
        uploader.upload(str, str2);
    }

    /* renamed from: com.tencent.ieg.gpc.globalization.ue4.UploaderHelper$3, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$ieg$gpc$globalization$base$uploader$GGUploaderState = new int[GGUploaderState.values().length];

        static {
            try {
                $SwitchMap$com$tencent$ieg$gpc$globalization$base$uploader$GGUploaderState[GGUploaderState.COMPLETED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$ieg$gpc$globalization$base$uploader$GGUploaderState[GGUploaderState.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$ieg$gpc$globalization$base$uploader$GGUploaderState[GGUploaderState.UPLOAD_TIMEOUT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$ieg$gpc$globalization$base$uploader$GGUploaderState[GGUploaderState.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void callbackWithResult(final GGResult gGResult) {
        GGLog.d(TAG, "callbackWithResult");
        _currentAcitivty.runOnUiThread(new GGReusltRunnable(gGResult) { // from class: com.tencent.ieg.gpc.globalization.ue4.UploaderHelper.2
            @Override // com.tencent.ieg.gpc.globalization.base.GGReusltRunnable, java.lang.Runnable
            public void run() {
                try {
                    GGLog.d(UploaderHelper.TAG, gGResult.toJasonString());
                    if (gGResult.code != 1) {
                        UploaderHelper.onUploadComplete(UploaderHelper.mUploadingCompleteCallbackPointer, gGResult.code, gGResult.msg);
                    } else {
                        GGUploadResult gGUploadResult = (GGUploadResult) gGResult;
                        GGLog.d(UploaderHelper.TAG, "success and file name:" + gGUploadResult.fileUrl);
                        UploaderHelper.onUploadComplete(UploaderHelper.mUploadingCompleteCallbackPointer, gGResult.code, gGUploadResult.fileUrl);
                    }
                } catch (Exception e) {
                    GGLog.e(UploaderHelper.TAG, e.getMessage());
                }
            }
        });
    }

    protected static boolean isFileExist(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return new File(str).exists();
    }
}
