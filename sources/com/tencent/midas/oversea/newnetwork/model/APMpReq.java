package com.tencent.midas.oversea.newnetwork.model;

import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.tencent.connect.common.Constants;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.GDPR;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.tencent.midas.oversea.newnetwork.http.NetworkReqParams;
import com.tencent.open.SocialOperation;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class APMpReq extends APMidasHttpRequestBase {
    public static final String TAG = "APMpReq";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void initUrl() {
        if ("release".equals(GlobalData.singleton().env)) {
            setMidasHttpURL("https", String.format("/v1/r/%s/mobile_mp_info", GlobalData.singleton().offerID));
        } else {
            setMidasHttpURL("https", String.format("/v1/r/%s/mobile_mp_info", GlobalData.singleton().offerID));
        }
    }

    public APMpReq setRequest(NetworkReqParams networkReqParams) {
        this.request = networkReqParams;
        return this;
    }

    public APMpReq setHttpRequestKey(String str) {
        this.httpRequestKey = str;
        return this;
    }

    public APMpReq setUp() {
        initUrl();
        constructParam();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void constructParam() {
        if (this.request == null) {
            APLog.e(TAG, "Request is null !!!");
            return;
        }
        super.constructParam();
        addHttpParameters("openid", GlobalData.singleton().openID);
        addHttpParameters(Constants.PARAM_PLATFORM_ID, GlobalData.singleton().pf);
        addHttpParameters("pfkey", GlobalData.singleton().pfKey);
        addHttpParameters("format", "json");
        addHttpParameters("session_token", GlobalData.singleton().getNetToken());
        String str = this.request.drmInfo;
        if (!TextUtils.isEmpty(str)) {
            addHttpParameters("drm_info", URLEncoder.encode(str));
            APLog.i(TAG, "drm_info:" + URLEncoder.encode(str));
        }
        addHttpParameters("openkey", GlobalData.singleton().openKey);
        addHttpParameters(SDKAnalyticsEvents.PARAMETER_SESSION_ID, GlobalData.singleton().sessionID);
        addHttpParameters(SocialOperation.GAME_ZONE_ID, GlobalData.singleton().zoneID);
        addHttpParameters("session_type", GlobalData.singleton().sessionType);
        addHttpParameters("sdkversion", GlobalData.SDK_VERSION);
        addHttpParameters("key_len", "newkey");
        addHttpParameters("key_time", NetworkManager.singleton().readKeyTime(GlobalData.singleton().offerID, GlobalData.singleton().openID));
        addHttpParameters("extend", this.request.reserve);
        addHttpParameters("currency_type", this.request.currency);
        addHttpParameters(UserDataStore.COUNTRY, this.request.country);
        addHttpParameters("pay_method", this.request.payChannel);
        addHttpParameters("type", this.request.mType);
        if (GDPR.ifCollect) {
            addHttpParameters("xg_mid", URLEncoder.encode(GDPR.getXgMid()));
        }
    }
}
