package com.tencent.imsdk.android.base.notice;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class IMSDKNoticeBase extends IMSDKManagerBase {
    public Context context;

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return null;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        return null;
    }

    public IMSDKNoticeBase(Context context) {
        super(context);
        if (context != null) {
            this.mCurCtx = context;
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_NOTICE, "Init<IMSDKNoticeBase>");
        }
    }

    public void showNotice(String str, int i, String str2, IMSDKResultListener iMSDKResultListener, String str3) {
        IMLogger.d("not support showNotice");
    }

    public void loadNoticeData(String str, int i, String str2, int i2, IMSDKResultListener iMSDKResultListener, String str3) {
        IMLogger.d("not support loadNoticeData");
    }

    public void loadNoticeData(String str, String str2, int i, int i2, boolean z, int i3, IMSDKResultListener iMSDKResultListener, String str3) {
        if (this.mSTBuilder != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("version", str);
            hashMap.put("language", str2);
            hashMap.put("region", String.valueOf(i));
            hashMap.put("isUseCache", String.valueOf(z));
            this.mSTBuilder.setExtraProp(hashMap).setStage("start").setMethod("loadNoticeData").setResult("success").create().reportEvent();
        }
    }

    public void setUserData(String str, IMSDKResultListener iMSDKResultListener, String str2) {
        IMLogger.d("not support setUserData");
    }

    public void syncUserDataToSvr(IMSDKResultListener iMSDKResultListener, String str) {
        IMLogger.d("not support syncUserDataToSvr");
    }

    public void closeNotice(String str, int i, IMSDKResultListener iMSDKResultListener, String str2) {
        IMLogger.d("not support closeNotice");
    }

    public void initialize(Context context) {
        this.context = context;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(enableHttps() ? "https" : "http");
        sb.append("://");
        sb.append(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_NOTICE.toUpperCase(), IR.meta.IMSDK_SERVER_NOTICE));
        sb.append("/v");
        sb.append(IMSDKConfig.getOrDefault(IR.meta.IMSDK_SERVER_NOTICE_VERSION, "1.0"));
        sb.append("/");
        sb.append(str);
        sb.append("?");
        return sb.toString();
    }
}
