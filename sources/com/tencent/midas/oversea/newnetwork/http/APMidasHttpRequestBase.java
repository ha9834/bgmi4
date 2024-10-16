package com.tencent.midas.oversea.newnetwork.http;

import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.HttpURL;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpRequest;
import com.tencent.midas.http.midashttp.IAPMidasEncodeKeyType;
import com.tencent.midas.oversea.comm.GlobalData;

/* loaded from: classes.dex */
public abstract class APMidasHttpRequestBase extends APMidasHttpRequest {
    private final String TAG = getClass().getSimpleName();
    protected String cmd = "";
    protected String httpRequestKey = "";
    protected NetworkReqParams request = null;

    public APMidasHttpRequestBase() {
        this.needFrontGetKeyInterceptor = false;
        this.needEndGetKeyInterceptor = false;
        GlobalData.singleton().refreshNetToken();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initUrl() {
        if ("release".equals(GlobalData.singleton().env)) {
            setMidasHttpURL("https", String.format("/v1/r/%s/mobile_overseas_common", GlobalData.singleton().offerID));
        } else {
            setMidasHttpURL("http", String.format("/v1/r/%s/mobile_overseas_common", GlobalData.singleton().offerID));
        }
    }

    @Override // com.tencent.midas.http.core.Request
    public void onHttpStart() {
        super.onHttpStart();
        APLog.d("onHttpStart", "url=" + getHttpUrl().host);
        this.connectTimeout = NetWorker.getTimeOut(getHost());
        this.readTimeout = this.connectTimeout;
    }

    @Override // com.tencent.midas.http.core.Request
    public void onHttpRetry(int i, int i2, Request request, Response response) {
        String host;
        APLog.d("HttpBase", "retry:" + request.getClass().getName());
        if (i < i2) {
            host = GlobalData.singleton().IPManager().getRandomIp();
        } else if (GlobalData.singleton().isUseDomainFirst() && GlobalData.singleton().NetCfg().getIPList().length >= i2 - 1) {
            host = GlobalData.singleton().IPManager().getRandomIp();
        } else {
            host = GlobalData.singleton().NetCfg().getHost();
        }
        if (TextUtils.isEmpty(host)) {
            return;
        }
        request.setHost(host);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setMidasHttpURL(String str, String str2) {
        String randomIp;
        if (TextUtils.isEmpty(str2)) {
            APLog.e(this.TAG, "Setting a empty http url suffix!");
        }
        if (TextUtils.isEmpty(str)) {
            APLog.e(this.TAG, "Setting a empty http url schema!");
        }
        if (GlobalData.singleton().isUseDomainFirst()) {
            randomIp = GlobalData.singleton().NetCfg().getHost();
        } else {
            randomIp = GlobalData.singleton().IPManager().getRandomIp();
        }
        HttpURL httpURL = new HttpURL(str, randomIp);
        httpURL.suffix = str2;
        setURL(httpURL);
        APLog.i(this.TAG, this.cmd + " requestUrl: " + getFullURLString());
    }

    public String getHttpRequestKey() {
        return this.httpRequestKey;
    }

    public String getDecodeKey() {
        String cryToKey = NetworkManager.singleton().getCryToKey(GlobalData.singleton().offerID, GlobalData.singleton().openID);
        return TextUtils.isEmpty(cryToKey) ? getEncodeKeyString() : cryToKey;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ifChangeKey() {
        if (!TextUtils.isEmpty(this.cmd) && this.cmd.contains(NetworkManager.CMD_GET_KEY)) {
            return true;
        }
        if (NetworkManager.singleton().needChangeKey(getOfferIDFromRequest(), getOpenIDFromRequest())) {
            addGetKey();
            return true;
        }
        APLog.i(this.TAG, this.cmd + " don't need change key.");
        return false;
    }

    public void addGetKey() {
        if (TextUtils.isEmpty(this.cmd)) {
            this.cmd += NetworkManager.CMD_GET_KEY;
        } else if (!this.cmd.contains(NetworkManager.CMD_GET_KEY)) {
            this.cmd += "|get_key";
        }
        addHttpParameters(NetworkManager.CMD_TAG, this.cmd);
        addHttpEncodeParameter("key", GlobalData.singleton().getBaseKey());
        addHttpParameters("get_key_type", IAPMidasEncodeKeyType.ENCODE_KEY_TYPE_SECRET);
        addHttpParameters("vid", GlobalData.singleton().changeVid);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void constructParam() {
        addHttpParameters("amode", "1");
        addHttpParameters("offer_id", GlobalData.singleton().offerID);
        if (TextUtils.isEmpty(this.cmd)) {
            return;
        }
        addHttpParameters(NetworkManager.CMD_TAG, this.cmd);
    }

    public NetworkReqParams getRequest() {
        return this.request;
    }

    public String getCmd() {
        return this.cmd;
    }
}
