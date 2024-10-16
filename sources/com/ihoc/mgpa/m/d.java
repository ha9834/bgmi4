package com.ihoc.mgpa.m;

import com.ihoc.mgpa.n.m;
import com.tencent.turingsmi.sdk.IDataCallBack;
import com.tencent.turingsmi.sdk.UploadResult;

/* loaded from: classes2.dex */
class d implements IDataCallBack {
    public boolean onDataCallBack(boolean z) {
        m.a("[method: onDataCallBack ] " + z + ", " + Thread.currentThread().getName(), new Object[0]);
        return true;
    }

    public void onUploadResult(UploadResult uploadResult) {
        m.a("[method: onResultCallBack ] " + uploadResult.mRetCode + ", " + Thread.currentThread().getName(), new Object[0]);
    }
}
