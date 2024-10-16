package com.tencent.imsdk.cpphelper;

import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.tools.log.IMLogger;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKCppListener implements IMSDKResultListener {
    private long mMetadataPointer;
    private long mResultPointer;
    private int mTag = -1;

    public static native void onResult(long j, long j2, int i, String str);

    IMSDKCppListener(long j, long j2) {
        this.mMetadataPointer = j;
        this.mResultPointer = j2;
    }

    public void setTag(int i) {
        this.mTag = i;
    }

    @Override // com.tencent.imsdk.android.api.IMSDKResultListener
    public void onResult(IMSDKResult iMSDKResult) {
        try {
            IMLogger.d("onResult result is : " + iMSDKResult.toUnityString());
            IMLogger.d("onResult with MetadataPointer : " + this.mMetadataPointer + ", ResultPointer : " + this.mResultPointer + ", Tag : " + this.mTag);
            onResult(this.mMetadataPointer, this.mResultPointer, this.mTag, iMSDKResult.toUnityString());
        } catch (JSONException e) {
            IMLogger.e("onResult catch exception : " + e.getMessage(), new Object[0]);
        }
    }
}
