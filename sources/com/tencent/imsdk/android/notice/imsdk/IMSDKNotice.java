package com.tencent.imsdk.android.notice.imsdk;

import android.content.Context;
import com.tencent.imsdk.android.IR;
import com.tencent.imsdk.android.api.IMSDKResult;
import com.tencent.imsdk.android.api.IMSDKResultListener;
import com.tencent.imsdk.android.api.auth.IMSDKAuthResult;
import com.tencent.imsdk.android.api.config.IMSDKConfig;
import com.tencent.imsdk.android.api.notice.IMSDKNoticeResult;
import com.tencent.imsdk.android.base.IMSDKDB4Login;
import com.tencent.imsdk.android.base.IMSDKDBLoginData;
import com.tencent.imsdk.android.base.IMSDKErrCode;
import com.tencent.imsdk.android.base.IMSDKListener;
import com.tencent.imsdk.android.base.notice.IMSDKNoticeBase;
import com.tencent.imsdk.android.tools.DeviceUtils;
import com.tencent.imsdk.android.tools.InnerStat;
import com.tencent.imsdk.android.tools.T;
import com.tencent.imsdk.android.tools.log.IMLogger;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

/* loaded from: classes.dex */
public class IMSDKNotice extends IMSDKNoticeBase {
    private static final int DEFAULT_INTERVAL_REQUEST = 120000;
    private static final String INTERVAL_REQUEST = "IMSDK_NOTICE_INTERVAL_REQUEST";
    protected static long mLastRequestStartTime;
    private static IMSDKNoticeCache mNoticeCache;
    private static IMSDKNoticeResult mNoticeResult;
    private Context mCtx;
    private int mIntervalRequest;
    private HashMap<String, String> mLastRequestParams;

    public IMSDKNotice(Context context) {
        super(context);
        this.mIntervalRequest = 0;
        this.mLastRequestParams = new HashMap<>();
        IMLogger.d("IMSDKNotice init");
        this.mIntervalRequest = IMSDKConfig.getOrMetaData(INTERVAL_REQUEST, INTERVAL_REQUEST, DEFAULT_INTERVAL_REQUEST);
        if (this.mCtx == null) {
            this.mCtx = context.getApplicationContext();
            mNoticeCache = new IMSDKNoticeCache(this.mCtx);
            this.mSTBuilder = new InnerStat.Builder(this.mCtx, BuildConfig.VERSION_NAME);
        }
    }

    @Override // com.tencent.imsdk.android.base.notice.IMSDKNoticeBase, com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult handleServerData(String str, byte[] bArr, Map<String, String> map) {
        try {
            String str2 = new String(bArr);
            IMLogger.json(str2);
            IMSDKNoticeResult iMSDKNoticeResult = new IMSDKNoticeResult(str2);
            if (iMSDKNoticeResult.thirdRetCode == 1) {
                iMSDKNoticeResult.imsdkRetCode = 1;
                iMSDKNoticeResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(1);
            } else {
                iMSDKNoticeResult.imsdkRetCode = 5;
                iMSDKNoticeResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(5);
            }
            return iMSDKNoticeResult;
        } catch (JSONException e) {
            return retByError(5, -1, e.getMessage());
        } catch (Exception e2) {
            IMLogger.w(e2.getMessage(), new Object[0]);
            return retByError(0, -1, e2.getMessage());
        }
    }

    @Override // com.tencent.imsdk.android.base.notice.IMSDKNoticeBase, com.tencent.imsdk.android.base.IMSDKManagerBase
    public IMSDKResult convertResult(String str, IMSDKResult iMSDKResult) {
        return new IMSDKNoticeResult(iMSDKResult.imsdkRetCode, iMSDKResult.thirdRetCode, iMSDKResult.thirdRetMsg);
    }

    private boolean isNewRequest(Map<String, String> map) {
        boolean z = !this.mLastRequestParams.equals(map);
        if (z) {
            this.mLastRequestParams.clear();
            this.mLastRequestParams.putAll(map);
        }
        return z;
    }

    private IMSDKNoticeResult retByError(int i, int i2, String str) {
        if (this.mSTBuilder != null) {
            this.mSTBuilder.setStage("exception").setResult("thirdCode=" + i2 + ", thirdMsg=" + str).create().reportEvent();
        }
        IMSDKNoticeResult iMSDKNoticeResult = new IMSDKNoticeResult();
        iMSDKNoticeResult.imsdkRetCode = i;
        iMSDKNoticeResult.imsdkRetMsg = IMSDKErrCode.getMessageByCode(i);
        iMSDKNoticeResult.thirdRetCode = i2;
        iMSDKNoticeResult.thirdRetMsg = str;
        mLastRequestStartTime = 0L;
        return iMSDKNoticeResult;
    }

    private IMSDKAuthResult getAuthResult() {
        IMSDKAuthResult loginData = IMSDKDB4Login.getLoginData(this.mCtx, "5");
        if (loginData != null) {
            return loginData.tokenExpireTime < System.currentTimeMillis() / 1000 ? new IMSDKAuthResult(1002, -1, "local cache expired") : loginData;
        }
        return new IMSDKAuthResult(1001, -1, "no local cache data");
    }

    @Override // com.tencent.imsdk.android.base.notice.IMSDKNoticeBase
    public void loadNoticeData(String str, String str2, int i, int i2, final boolean z, int i3, final IMSDKResultListener iMSDKResultListener, String str3) {
        super.loadNoticeData(str, str2, i, i2, z, i3, iMSDKResultListener, str3);
        IMSDKDBLoginData dBLoginData = IMSDKDB4Login.getDBLoginData(this.mCurCtx);
        IMLogger.d("build request params for query notice start with noticeType = " + i3);
        Map<String, String> sortableMap = T.getSortableMap();
        sortableMap.put("sLang", str2);
        sortableMap.put("sVersion", str);
        sortableMap.put("iRegion", String.valueOf(i));
        sortableMap.put("iPartition", String.valueOf(i2));
        sortableMap.put("sExtra", str3);
        sortableMap.put("iChannel", dBLoginData != null ? String.valueOf(dBLoginData.channelId) : "");
        switch (i3) {
            case 1:
                sortableMap.put("sGuestId", DeviceUtils.getDeviceUuid(this.mCtx));
                break;
            case 2:
                sortableMap.put("iOpenid", dBLoginData != null ? dBLoginData.openId : "");
                break;
        }
        if (isNewRequest(sortableMap) || mLastRequestStartTime == 0 || System.currentTimeMillis() - mLastRequestStartTime >= this.mIntervalRequest) {
            IMLogger.d("init notice request start time ...");
            mLastRequestStartTime = System.currentTimeMillis();
            connectIMSDK(IR.path.GET_NOTICE_PATH, sortableMap, new IMSDKResultListener<IMSDKNoticeResult>() { // from class: com.tencent.imsdk.android.notice.imsdk.IMSDKNotice.1
                @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                public void onResult(IMSDKNoticeResult iMSDKNoticeResult) {
                    if (iMSDKNoticeResult.noticesList == null || iMSDKNoticeResult.imsdkRetCode != 1) {
                        iMSDKResultListener.onResult(iMSDKNoticeResult);
                        if (iMSDKNoticeResult.noticesList != null && iMSDKNoticeResult.noticesList.size() == 0) {
                            IMSDKNotice.mNoticeCache.clearNoticePicOutOfDate(new String[0]);
                            return;
                        }
                        IMLogger.d("current return code is " + iMSDKNoticeResult.thirdRetCode);
                        IMSDKNotice.mLastRequestStartTime = 0L;
                        return;
                    }
                    if (z) {
                        IMSDKNotice.mNoticeCache.saveAndClearExpiredNoticePicture(iMSDKNoticeResult, new IMSDKListener<Boolean>() { // from class: com.tencent.imsdk.android.notice.imsdk.IMSDKNotice.1.1
                            @Override // com.tencent.imsdk.android.base.IMSDKListener
                            public void onNotify(Boolean bool) {
                                IMSDKNotice.mLastRequestStartTime = 0L;
                            }

                            @Override // com.tencent.imsdk.android.api.IMSDKResultListener
                            public void onResult(IMSDKResult iMSDKResult) {
                                iMSDKResultListener.onResult(iMSDKResult);
                                if (iMSDKResult instanceof IMSDKNoticeResult) {
                                    IMSDKNoticeResult unused = IMSDKNotice.mNoticeResult = (IMSDKNoticeResult) iMSDKResult;
                                } else {
                                    IMLogger.e("class cast error while execute saveAndClearExpiredNoticePicture()", new Object[0]);
                                }
                            }
                        });
                    } else {
                        iMSDKResultListener.onResult(iMSDKNoticeResult);
                        IMSDKNoticeResult unused = IMSDKNotice.mNoticeResult = iMSDKNoticeResult;
                    }
                }
            });
            return;
        }
        IMLogger.d("last request : " + mLastRequestStartTime + " , " + (System.currentTimeMillis() - mLastRequestStartTime));
        IMSDKNoticeResult iMSDKNoticeResult = mNoticeResult;
        if (iMSDKNoticeResult == null || iMSDKResultListener == null) {
            return;
        }
        iMSDKResultListener.onResult(iMSDKNoticeResult);
    }
}
