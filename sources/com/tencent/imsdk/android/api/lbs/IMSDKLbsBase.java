package com.tencent.imsdk.android.api.lbs;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKManagerBase;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public abstract class IMSDKLbsBase extends IMSDKManagerBase {
    public static final String LBS_PATH = "lbs/getLbsInfo";
    public static final String MODULE_LBS = "base_lbs";
    private String mCurrentChannel;
    private boolean mEnableGPS;
    private String mLanTag;

    protected void fillLbsParams(Map<String, String> map) {
    }

    public IMSDKLbsBase(Context context) {
        super(context);
        if (this.mCurCtx == null) {
            this.mCurCtx = context.getApplicationContext();
            this.mSTBuilder = new InnerStat.Builder(this.mCurCtx, "2.5.8", MODULE_LBS, "Init<IMSDKLbs>");
        }
    }

    public void setChannel(String str) {
        this.mCurrentChannel = str;
    }

    protected String getChannel() {
        return this.mCurrentChannel;
    }

    public void getLocationInfo(IMSDKResultListener<IMSDKLbsResult> iMSDKResultListener) {
        Map<String, String> sortableMap = T.getSortableMap();
        fillLbsParams(sortableMap);
        connectIMSDK(LBS_PATH, sortableMap, iMSDKResultListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setEnableGPS(boolean z) {
        this.mEnableGPS = z;
    }

    protected boolean getEnableGPS() {
        return this.mEnableGPS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLanTag(String str) {
        this.mLanTag = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getLanTag() {
        return this.mLanTag;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        String str2;
        if (bArr != null) {
            try {
                str2 = new String(bArr, "UTF-8");
            } catch (JSONException e) {
                return new IMSDKLbsResult(5, -1, e.getMessage());
            } catch (Exception e2) {
                IMLogger.w(e2.getMessage(), new Object[0]);
                return new IMSDKLbsResult(0, -1, e2.getMessage());
            }
        } else {
            str2 = "";
        }
        IMLogger.d("raw string = " + str2);
        IMLogger.json(str2);
        IMSDKLbsResult iMSDKLbsResult = new IMSDKLbsResult(str2);
        if (iMSDKLbsResult.thirdRetCode == 1) {
            iMSDKLbsResult.imsdkRetCode = 1;
            iMSDKLbsResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(1);
            return iMSDKLbsResult;
        }
        iMSDKLbsResult.imsdkRetCode = 5;
        iMSDKLbsResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(5);
        return iMSDKLbsResult;
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return new IMSDKLbsResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg);
    }

    @Override // com.tencent.imsdk.android.base.IMSDKManagerBase
    protected String getUrl(String str) {
        return "https://" + IMSDKConfig.getOrMetaData(IR.meta.IMSDK_SERVER_SDKAPI.toUpperCase(), IR.meta.IMSDK_SERVER_SDKAPI) + "/v" + IMSDKConfig.getOrDefault(IR.meta.IMSDK_SERVER_SDKAPI_VERSION, "1.0") + "/" + str + "?";
    }
}
