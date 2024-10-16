package com.tencent.midas.oversea.business;

import android.content.Context;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.newapi.response.IAPMidasCallback;
import com.tencent.midas.oversea.newapi.response.InfoCallback;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.tencent.midas.oversea.newnetwork.model.APIntroPriceAns;
import java.util.List;

/* loaded from: classes.dex */
public abstract class APBaseIntroInfo {
    protected static final int RET_ERR = -1;
    protected static final int RET_OK = 0;
    protected String channel = "";
    protected List<String> productList = null;

    public abstract void getIntroInfo(Context context, String str, List<String> list, InfoCallback infoCallback);

    /* JADX INFO: Access modifiers changed from: protected */
    public void queryServerInfo(final IAPMidasCallback iAPMidasCallback) {
        NetworkManager.singleton().introPriceReq(this.channel, this.productList, new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.business.APBaseIntroInfo.1
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                IAPMidasCallback iAPMidasCallback2 = iAPMidasCallback;
                if (iAPMidasCallback2 != null) {
                    iAPMidasCallback2.callback(0, ((APIntroPriceAns) aPMidasHttpAns).getJsIntroInfo());
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                IAPMidasCallback iAPMidasCallback2 = iAPMidasCallback;
                if (iAPMidasCallback2 != null) {
                    iAPMidasCallback2.callback(-1, "");
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
                IAPMidasCallback iAPMidasCallback2 = iAPMidasCallback;
                if (iAPMidasCallback2 != null) {
                    iAPMidasCallback2.callback(-1, "");
                }
            }
        });
    }
}
