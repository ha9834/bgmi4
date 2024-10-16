package com.tencent.imsdk.android.base.gameservice;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class IMSDKGameServiceManager extends IMSDKManagerBase {
    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return null;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        return null;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        return null;
    }

    public abstract void increaseAchieve(String str, int i, IMSDKResultListener iMSDKResultListener, Object... objArr);

    public abstract void setScore(String str, int i, IMSDKResultListener iMSDKResultListener, Object... objArr);

    public abstract void setup(IMSDKResultListener iMSDKResultListener, Object... objArr);

    public abstract void showAchievement(IMSDKResultListener iMSDKResultListener, Object... objArr);

    public abstract void showLeaderBoard(String str, IMSDKResultListener iMSDKResultListener, Object... objArr);

    public abstract void unlockAchieve(String str, IMSDKResultListener iMSDKResultListener, Object... objArr);

    public IMSDKGameServiceManager(Context context) {
        super(context);
        StringBuilder sb = new StringBuilder();
        sb.append("initialize ");
        sb.append((this.mCurCtx == null && context == null) ? "fail" : "success");
        IMLogger.d(sb.toString());
        if (context != null && this.mCurCtx == null) {
            this.mCurCtx = context.getApplicationContext();
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_GAME, "Init<IMSDKGameServiceManager>");
        }
    }
}
