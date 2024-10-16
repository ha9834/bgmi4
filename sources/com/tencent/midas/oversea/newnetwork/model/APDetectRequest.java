package com.tencent.midas.oversea.newnetwork.model;

import android.text.TextUtils;
import com.facebook.internal.security.CertificateUtil;
import com.tencent.midas.http.core.HttpURL;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;
import com.tencent.midas.oversea.newnetwork.service.APNetDetectService;
import com.tencent.open.SocialOperation;

/* loaded from: classes.dex */
public class APDetectRequest extends APMidasHttpRequestBase {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public boolean ifChangeKey() {
        return false;
    }

    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase, com.tencent.midas.http.core.Request
    public void onHttpRetry(int i, int i2, Request request, Response response) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void initUrl() {
        String str = APNetDetectService.finalDetectDomain;
        String str2 = APNetDetectService.finalDetectDomain.startsWith("https") ? "https" : "https";
        if (APNetDetectService.finalDetectDomain.contains(CertificateUtil.DELIMITER)) {
            if (APNetDetectService.finalDetectDomain.length() > 7) {
                str = APNetDetectService.finalDetectDomain.substring(TextUtils.equals("http", str) ? 6 : 7);
            }
        }
        if (MConstants.TestEnv.equals(GlobalData.singleton().env)) {
            HttpURL httpURL = new HttpURL(str2, str);
            httpURL.suffix = "/region";
            setURL(httpURL);
        } else {
            HttpURL httpURL2 = new HttpURL(str2, str);
            httpURL2.suffix = "/region";
            setURL(httpURL2);
        }
    }

    public void setUp() {
        initUrl();
        constructParam();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void constructParam() {
        super.constructParam();
        addHttpParameters("openid", GlobalData.singleton().openID);
        addHttpParameters("offerid", GlobalData.singleton().offerID);
        addHttpParameters(SocialOperation.GAME_ZONE_ID, GlobalData.singleton().zoneID);
    }
}
