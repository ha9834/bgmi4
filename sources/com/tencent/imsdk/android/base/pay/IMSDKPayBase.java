package com.tencent.imsdk.android.base.pay;

import android.app.Activity;
import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.pay.IMPayMidasReq;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class IMSDKPayBase extends IMSDKManagerBase {
    public Activity activity;

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return null;
    }

    public abstract void deinit();

    public void getProductInfoFromMidas(IMPayMidasReq iMPayMidasReq, IMSDKResultListener iMSDKResultListener) {
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        return null;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        return null;
    }

    public abstract void netFromMidas(IMPayMidasReq iMPayMidasReq, IMSDKResultListener iMSDKResultListener);

    public abstract void payFromMidas(IMPayMidasReq iMPayMidasReq, IMSDKResultListener iMSDKResultListener);

    public abstract void prepareFromMidas(IMPayMidasReq iMPayMidasReq, boolean z, IMSDKResultListener iMSDKResultListener);

    public abstract void setEnv(String str);

    public abstract void setLogEnable(boolean z);

    public abstract void setReleaseIDC(String str);

    public void setScreenType(boolean z) {
    }

    public IMSDKPayBase(Context context) {
        super(context);
        this.activity = null;
        this.activity = T.mGlobalActivityUpToDate;
        if (context == null || this.mCurCtx != null) {
            return;
        }
        this.mCurCtx = context;
        this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_PAY, "Init<IMSDKPayBase>");
    }
}
