package com.tencent.imsdk.android.base.relation;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.common.IMSDKUrlResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKUrlBase extends IMSDKManagerBase {
    public IMSDKUrlBase(Context context) {
        super(context);
        if (context != null) {
            this.mCurCtx = context;
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.10.1", IR.MODULE_URL, "Init<IMSDKUrlBase>");
        }
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        String str2;
        if (bArr != null) {
            try {
                str2 = new String(bArr, "UTF-8");
            } catch (JSONException e) {
                return new IMSDKResult(5, -1, e.getMessage());
            } catch (Exception e2) {
                return new IMSDKResult(3, -1, e2.getMessage());
            }
        } else {
            str2 = "";
        }
        IMLogger.json(str2);
        IMSDKUrlResult iMSDKUrlResult = new IMSDKUrlResult(str2);
        if (iMSDKUrlResult.thirdRetCode == 1) {
            iMSDKUrlResult.imsdkRetCode = 1;
        } else {
            iMSDKUrlResult.imsdkRetCode = 5;
        }
        iMSDKUrlResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(iMSDKUrlResult.imsdkRetCode);
        return iMSDKUrlResult;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return str.equals(IR.path.URL_CONVERT) ? new IMSDKUrlResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode) : iMSDKResult;
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
        IMLogger.d("request url is : " + ((Object) sb));
        return sb.toString();
    }
}
