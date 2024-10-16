package com.ihoc.mgpa.m;

import com.ihoc.mgpa.n.m;
import com.tencent.turingsmi.sdk.IDataCallBack;
import com.tencent.turingsmi.sdk.UploadResult;

/* loaded from: classes2.dex */
class e implements IDataCallBack {
    public boolean onDataCallBack(boolean z) {
        m.a("TGPA_TuringShield", "[method: onDataCallBack ] " + z + ", " + Thread.currentThread().getName());
        return true;
    }

    public void onUploadResult(UploadResult uploadResult) {
        m.a("TGPA_TuringShield", "[method: onResultCallBack ] " + uploadResult.mRetCode + ", " + Thread.currentThread().getName());
    }
}
