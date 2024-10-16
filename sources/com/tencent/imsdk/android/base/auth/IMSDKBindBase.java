package com.tencent.imsdk.android.base.auth;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.auth.IMSDKAuthResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKFuse;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.base.IMSDKValidKeyCalcUnit;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKBindBase extends IMSDKManagerBase {
    private static final String[] NEED_UPDATE_AUTH = {IR.path.EMAIL_RECOVER};
    private static final String[] RETURN_AUTH_RESULT = {IR.path.EMAIL_CONNECT, IR.path.EMAIL_RECOVER};

    public IMSDKBindBase(Context context) {
        super(context);
        StringBuilder sb = new StringBuilder();
        sb.append("initialize ");
        sb.append((this.mCurCtx == null && context == null) ? "fail" : "success");
        IMLogger.d(sb.toString());
        if (context != null && this.mCurCtx == null) {
            this.mCurCtx = context.getApplicationContext();
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_BIND, "Init<IMSDKBindBase>");
        }
    }

    protected boolean isConfigNotFuse(String str, String str2, String str3, IMSDKResultListener iMSDKResultListener) {
        boolean z = true;
        if (!T.ckIsEmpty(str2) && (!IMSDKFuse.isAvailable(str2) || !IMSDKFuse.isAvailable(str2, str3))) {
            z = false;
        }
        int i = !z ? 19 : -1;
        if (iMSDKResultListener != null && i != -1) {
            iMSDKResultListener.onResult(createIMSDKResult(str, i, -1, IMSDKErrCode.getMessageByCode(i)));
        }
        return z;
    }

    protected void retByError(String str, IMSDKResultListener iMSDKResultListener, int i, int i2, String str2) {
        if (iMSDKResultListener != null) {
            iMSDKResultListener.onResult(createIMSDKResult(str, i, i2, str2));
        } else {
            IMLogger.e(str2, new Object[0]);
        }
    }

    protected IMSDKAuthResult getAuthResult() {
        IMLogger.d("activity = " + this.mCurCtx);
        IMSDKAuthResult loginData = IMSDKDB4Login.getLoginData(this.mCurCtx, "5");
        if (loginData != null) {
            return loginData.tokenExpireTime < System.currentTimeMillis() / 1000 ? new IMSDKAuthResult(1002, -1, "local cache expired") : loginData;
        }
        return new IMSDKAuthResult(1001, -1, "no local cache data");
    }

    protected boolean fillCommonParams(Map<String, String> map) {
        IMSDKValidKeyCalcUnit ins = IMSDKValidKeyCalcUnit.getIns(this.mCurCtx);
        IMSDKAuthResult authResult = getAuthResult();
        ins.putIfAbsence(map, "iOpenid", authResult.openId);
        ins.putIfAbsence(map, "sInnerToken", authResult.innerToken);
        ins.putIfAbsence(map, "sGuestId", DeviceUtils.getDeviceUuid(this.mCurCtx));
        return authResult.imsdkRetCode == 1;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        String str2;
        IMSDKResult iMSDKResult;
        if (bArr != null) {
            try {
                str2 = new String(bArr, "UTF-8");
            } catch (JSONException e) {
                return createIMSDKResult(str, 5, -1, e.getMessage());
            } catch (Exception e2) {
                return createIMSDKResult(str, 3, -1, e2.getMessage());
            }
        } else {
            str2 = "";
        }
        IMLogger.d("raw string = " + str2);
        IMLogger.json(str2);
        if (isPathPresent(str, RETURN_AUTH_RESULT)) {
            iMSDKResult = new IMSDKAuthResult(str2);
        } else {
            iMSDKResult = new IMSDKResult(str2);
        }
        if (iMSDKResult.thirdRetCode == 1) {
            iMSDKResult.imsdkRetCode = 1;
            if (isPathPresent(str, NEED_UPDATE_AUTH)) {
                IMSDKDB4Login.saveLoginData(this.mCurCtx, iMSDKResult, "5");
            }
        } else {
            iMSDKResult.imsdkRetCode = 5;
        }
        iMSDKResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(iMSDKResult.imsdkRetCode);
        return iMSDKResult;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return isPathPresent(str, RETURN_AUTH_RESULT) ? new IMSDKAuthResult(iMSDKResult.imsdkRetCode, iMSDKResult.imsdkRetCode) : iMSDKResult;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(enableHttps() ? "https" : "http");
        sb.append("://");
        sb.append(IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_SDKAPI.toUpperCase(), IR.meta.IMSDK_SERVER_SDKAPI));
        sb.append("/v");
        sb.append(IMSDKConfig.getOrDefault(IR.meta.IMSDK_SERVER_SDKAPI_VERSION, "1.0"));
        sb.append("/");
        sb.append(str);
        sb.append("?");
        return sb.toString();
    }

    private IMSDKResult createIMSDKResult(String str, int i, int i2, String str2) {
        if (i != 1) {
            this.mSTBuilder.setMethod(str).setStage("exception").setResult("thirdCode=" + i2 + ", thirdMsg=" + str2).create().reportEvent();
        }
        if (isPathPresent(str, RETURN_AUTH_RESULT)) {
            return new IMSDKAuthResult(i, i2, str2);
        }
        return new IMSDKResult(i, i2, str2);
    }
}
