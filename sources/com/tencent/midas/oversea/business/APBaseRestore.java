package com.tencent.midas.oversea.business;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.comm.APBase64;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.data.APPayReceipt;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;
import com.tencent.midas.oversea.newapi.response.IAPMidasCallback;
import com.tencent.midas.oversea.newapi.response.ICallback;
import com.tencent.midas.oversea.newapi.response.IGetPurchaseCallback;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.tencent.midas.oversea.newnetwork.model.APOverSeaCommAns;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public abstract class APBaseRestore {
    protected static final String DEFAULT_RET_MSG = "";
    private static final String TAG = "APBaseRestore";
    protected String mChannel;
    private IAPMidasCallback outCallback;
    private int curIndex = 0;
    protected boolean isNeedVerifyRes = false;
    private List<APPayReceipt> provideList = new ArrayList();
    private List<String> consumeList = new ArrayList();
    protected List<String> forbiddenPrompts = new ArrayList();
    protected HashMap<String, String> provideSdkRetMap = new HashMap<>();
    private IAPMidasHttpCallback mReProvideObserver = new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.business.APBaseRestore.4
        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onStop(APMidasHttpAns aPMidasHttpAns) {
            APBaseRestore.this.reProvide(true);
            APLog.e(APBaseRestore.TAG, "reProvide onStop.");
        }

        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
            int resultCode = aPMidasHttpAns.getResultCode();
            APLog.i(APBaseRestore.TAG, "reProvide onSuccess: " + resultCode + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + aPMidasHttpAns.getResultMessage());
            if (APBaseRestore.this.provideList == null || APBaseRestore.this.curIndex >= APBaseRestore.this.provideList.size()) {
                APDataReportManager.instance().insertData(APDataReportManager.SDK_CRASH_RESTORE, "threadId=" + Thread.currentThread().getId() + "&curIndex=" + APBaseRestore.this.curIndex + "&provideList=" + APBaseRestore.this.provideList.size());
                APBaseRestore.this.callbackOut(-1, "");
                return;
            }
            APDataReportManager.instance().insertData(APDataReportManager.SDK_RESTORE, "threadId=" + Thread.currentThread().getId() + "&curIndex=" + APBaseRestore.this.curIndex + "&provideList=" + APBaseRestore.this.provideList.size());
            APOverSeaCommAns aPOverSeaCommAns = (APOverSeaCommAns) aPMidasHttpAns;
            APBaseRestore.this.saveProvideSdkRet(aPOverSeaCommAns.getProvideSdkRet());
            if (resultCode != 0) {
                if (resultCode == 1018) {
                    APBaseRestore.access$308(APBaseRestore.this);
                    APBaseRestore.this.reProvide(false);
                    return;
                } else if (resultCode != 1138 && resultCode != 5017) {
                    if (resultCode == 5020) {
                        APBaseRestore.this.forbiddenPrompts.add(((APPayReceipt) APBaseRestore.this.provideList.get(APBaseRestore.this.curIndex)).sku);
                    } else if (resultCode != 6001) {
                        APBaseRestore.access$308(APBaseRestore.this);
                        APBaseRestore.this.reProvide(true);
                        return;
                    }
                }
            }
            if (!APBaseRestore.this.isNeedVerifyRes) {
                if (TextUtils.isEmpty(APBaseRestore.this.mChannel) || !APBaseRestore.this.mChannel.equals("os_amazon")) {
                    APBaseRestore.this.consumeList.add(((APPayReceipt) APBaseRestore.this.provideList.get(APBaseRestore.this.curIndex)).sku);
                } else {
                    APBaseRestore.this.consumeList.add(new String(APBase64.decode(((APPayReceipt) APBaseRestore.this.provideList.get(APBaseRestore.this.curIndex)).receipt)) + "&sku=" + ((APPayReceipt) APBaseRestore.this.provideList.get(APBaseRestore.this.curIndex)).sku);
                }
            } else if (aPMidasHttpAns instanceof APOverSeaCommAns) {
                APBaseRestore.this.consumeList.add(aPOverSeaCommAns.getVerifyRes());
            }
            APBaseRestore.access$308(APBaseRestore.this);
            APBaseRestore.this.reProvide(true);
        }

        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
        public void onFailure(APMidasHttpAns aPMidasHttpAns) {
            APBaseRestore.access$308(APBaseRestore.this);
            APBaseRestore.this.reProvide(true);
            APLog.e(APBaseRestore.TAG, "reProvide onFailure.");
        }
    };

    public abstract void getPurchaseList(Context context, IGetPurchaseCallback iGetPurchaseCallback);

    public abstract void init(Context context, ICallback iCallback);

    public abstract void postProvide(List<String> list, IAPMidasCallback iAPMidasCallback);

    static /* synthetic */ int access$308(APBaseRestore aPBaseRestore) {
        int i = aPBaseRestore.curIndex;
        aPBaseRestore.curIndex = i + 1;
        return i;
    }

    public void restore(final Context context, String str, IAPMidasCallback iAPMidasCallback) {
        this.mChannel = str;
        this.outCallback = iAPMidasCallback;
        this.curIndex = 0;
        init(context, new ICallback() { // from class: com.tencent.midas.oversea.business.APBaseRestore.1
            @Override // com.tencent.midas.oversea.newapi.response.ICallback
            public void callback(int i) {
                if (i == 0) {
                    APLog.i(APBaseRestore.TAG, "init success");
                    APBaseRestore.this.startReProvide(context);
                } else {
                    APLog.i(APBaseRestore.TAG, "init error");
                    APBaseRestore.this.callbackOut(-1, "");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startReProvide(Context context) {
        getPurchaseList(context, new IGetPurchaseCallback() { // from class: com.tencent.midas.oversea.business.APBaseRestore.2
            @Override // com.tencent.midas.oversea.newapi.response.IGetPurchaseCallback
            public void callback(List<APPayReceipt> list) {
                if (list != null && !list.isEmpty()) {
                    if (APBaseRestore.this.provideList == null) {
                        APBaseRestore.this.provideList = new ArrayList(list.size());
                    }
                    APBaseRestore.this.provideList.addAll(list);
                    APLog.i(APBaseRestore.TAG, "purchase list size:" + list.size());
                    APBaseRestore.this.reProvide(true);
                    return;
                }
                APLog.i(APBaseRestore.TAG, "purchase list is empty");
                APBaseRestore.this.callbackOut(-1, "");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reProvide(boolean z) {
        List<APPayReceipt> list = this.provideList;
        if (list == null) {
            callbackOut(-1, "");
            APLog.i(TAG, "curIndex = " + this.curIndex + " provideList is null ");
            return;
        }
        if (!z || this.curIndex >= list.size()) {
            postProvide(this.consumeList, new IAPMidasCallback() { // from class: com.tencent.midas.oversea.business.APBaseRestore.3
                @Override // com.tencent.midas.oversea.newapi.response.IAPMidasCallback
                public void callback(int i, String str) {
                    APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_GW_RESULT, "reprovide=" + i + "&receiptList=" + str);
                    NetworkManager.singleton().dataReport(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.business.APBaseRestore.3.1
                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                        }

                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onStop(APMidasHttpAns aPMidasHttpAns) {
                        }

                        @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
                        public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                        }
                    });
                    APBaseRestore.this.callbackOut(i, str);
                }
            });
            return;
        }
        APLog.i(TAG, "curIndex = " + this.curIndex + " provideList = " + this.provideList.size() + " productid=" + this.provideList.get(this.curIndex).sku);
        APPayReceipt aPPayReceipt = this.provideList.get(this.curIndex);
        NetworkManager.singleton().provide(true, "", this.mChannel, "", "", aPPayReceipt.receipt, null, aPPayReceipt.receipt_sig, new BillingFlowParams.Builder().build(), this.mReProvideObserver);
    }

    public void callbackOut(int i, String str) {
        IAPMidasCallback iAPMidasCallback = this.outCallback;
        if (iAPMidasCallback != null) {
            iAPMidasCallback.callback(i, str);
        }
        dispose();
    }

    public void dispose() {
        this.outCallback = null;
        this.mReProvideObserver = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveProvideSdkRet(String str) {
        int i;
        if (TextUtils.isEmpty(str) || (i = this.curIndex) < 0 || i >= this.provideList.size()) {
            return;
        }
        String str2 = this.provideList.get(this.curIndex).sku;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        APLog.d(TAG, "saveProvideSdkRet,key: " + str2 + ",value: " + str);
        this.provideSdkRetMap.put(str2, str);
    }
}
