package com.tencent.midas.oversea.business.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.text.TextUtils;
import com.intlgame.webview.WebViewManager;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.APBase64;
import com.tencent.midas.oversea.comm.APCommMethod;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.midas.oversea.data.APPayReceipt;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class APPayBaseChannel {
    public static final String MSG_KEY = "msg_key";
    public static final String MSG_STR_OBJ = "msg_key";
    public static final String ORDER_KEY = "order_key";
    public static final int REQUEST_CODE = 1001;
    public static final int RET_OK = 0;
    private final String TAG = getClass().getSimpleName();
    protected APPayBaseView mView = null;
    protected APPayModel mModel = null;
    protected boolean dropMessage = false;
    public final HandlerImpl UIHandler = new HandlerImpl();

    protected JSONObject addChannelExtra(JSONObject jSONObject) {
        return jSONObject;
    }

    protected String getProductType() {
        return "";
    }

    public boolean handleActivityResult(int i, int i2, Intent intent) {
        return false;
    }

    protected boolean hasGoodsList() {
        return true;
    }

    protected boolean isSdkProvide() {
        return false;
    }

    protected boolean needOrder() {
        return true;
    }

    protected boolean needShowSucc() {
        return true;
    }

    protected void onSaveReceipt(APPayReceipt aPPayReceipt) {
    }

    public void pay(Activity activity, JSONObject jSONObject) {
    }

    public void init(APPayBaseView aPPayBaseView) {
        this.mView = aPPayBaseView;
        this.mModel = new APPayModel();
        this.mModel.setProductType(getProductType());
        this.mModel.setHasGoodsList(hasGoodsList());
        this.mModel.setRequest(this.mView.getOrder().request);
        this.mModel.setCallback(new XCallback() { // from class: com.tencent.midas.oversea.business.pay.APPayBaseChannel.1
            @Override // com.tencent.midas.oversea.business.pay.XCallback
            public void notifyInner(Message message) {
                if (APPayBaseChannel.this.UIHandler != null) {
                    APPayBaseChannel.this.UIHandler.sendMessage(message);
                }
            }

            @Override // com.tencent.midas.oversea.business.pay.XCallback
            public void notifyOuterLoginErr() {
                APPayBaseChannel.this.callBackLoginError();
            }

            @Override // com.tencent.midas.oversea.business.pay.XCallback
            public void notifyOuterRiskErr(int i, String str) {
                if (1145 == i) {
                    APPayBaseChannel.this.callBackError(new MidasResponse(-5, str));
                }
            }
        });
    }

    public void startPayCheckEnv() {
        if (APTools.isTestEnv()) {
            this.mView.showSandboxDialog();
        } else {
            startPay();
        }
    }

    public void startPay() {
        this.dropMessage = false;
        this.UIHandler.sendEmptyMessage(MConstants.MSG_PAYCHANNEL_INIT);
    }

    public int getOrderKey() {
        return this.mView.getOrderKey();
    }

    /* loaded from: classes.dex */
    public class HandlerImpl {
        public HandlerImpl() {
        }

        public void sendMessage(Message message) {
            handleMessage(message);
        }

        public void sendEmptyMessage(int i) {
            Message message = new Message();
            message.what = i;
            handleMessage(message);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0188  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x01a2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean handleMessage(android.os.Message r6) {
            /*
                Method dump skipped, instructions count: 1052
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.midas.oversea.business.pay.APPayBaseChannel.HandlerImpl.handleMessage(android.os.Message):boolean");
        }
    }

    public void release() {
        APPayModel aPPayModel = this.mModel;
        if (aPPayModel != null) {
            aPPayModel.release();
            this.mModel = null;
        }
        this.mView = null;
    }

    private void wrapperResponse(MidasResponse midasResponse) {
        if (midasResponse == null || TextUtils.isEmpty(midasResponse.getExtra())) {
            return;
        }
        try {
            midasResponse.setExtra(addChannelExtra(new JSONObject(midasResponse.getExtra())));
        } catch (JSONException e) {
            APLog.e(this.TAG, "wrapperResponse exception: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackLoginError() {
        APPayBaseView aPPayBaseView = this.mView;
        if (aPPayBaseView != null) {
            aPPayBaseView.callBackLoginError();
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackError(MidasResponse midasResponse) {
        wrapperResponse(midasResponse);
        APPayBaseView aPPayBaseView = this.mView;
        if (aPPayBaseView != null) {
            aPPayBaseView.callBackError(midasResponse);
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackErrorWithUI(String str, MidasResponse midasResponse) {
        wrapperResponse(midasResponse);
        APPayBaseView aPPayBaseView = this.mView;
        if (aPPayBaseView != null) {
            aPPayBaseView.showErrorMsg(str, midasResponse);
        }
        dispose();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callBackSuccess(int i) {
        MidasResponse midasResponse = new MidasResponse(0);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(WebViewManager.KEY_JS_CHANNEL, this.mModel.getChannelId());
            jSONObject.put("num", i);
            jSONObject.put("billNo", this.mModel.getBillNo());
            String payInfo = this.mModel.getPayInfo();
            if (!TextUtils.isEmpty(payInfo)) {
                jSONObject.put(NetworkManager.CMD_INFO, APBase64.encode(payInfo.getBytes()));
            }
            midasResponse.setExtra(addChannelExtra(jSONObject));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        midasResponse.needShowSuccess = needShowSucc();
        this.mView.callBackSuccess(midasResponse);
        dispose();
    }

    protected void init() {
        this.UIHandler.sendEmptyMessage(MConstants.MSG_PAYCHANNEL_INIT_SUCC);
    }

    public void prePay() {
        this.UIHandler.sendEmptyMessage(MConstants.MSG_PAYCHANNEL_PREPAY_SUCC);
    }

    public void postPay() {
        this.UIHandler.sendEmptyMessage(MConstants.MSG_PAYCHANNEL_POSTPAY_SUCC);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void dispose() {
        APLog.i(this.TAG, "dispose()");
        APPayBaseView aPPayBaseView = this.mView;
        if (aPPayBaseView != null) {
            aPPayBaseView.dismissWaitDialog();
        }
        this.dropMessage = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoading() {
        APPayBaseView aPPayBaseView = this.mView;
        if (aPPayBaseView != null) {
            aPPayBaseView.showWaitDialog();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCommError(Message message) {
        String str = (String) message.obj;
        int i = message.arg1 == 0 ? -1 : message.arg1;
        APPayBaseView aPPayBaseView = this.mView;
        boolean z = true;
        if (aPPayBaseView != null) {
            try {
                z = aPPayBaseView.getActivity().getPackageManager().getApplicationInfo(this.mView.getActivity().getPackageName(), 128).metaData.getBoolean("isShowErrDialog", true);
                APLog.d(this.TAG, "showErrDialog is " + z);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (TextUtils.isEmpty(str)) {
            callBackError(new MidasResponse(i, APCommMethod.getStringId(this.mView.getActivity(), "unipay_pay_error_tip")));
        } else if (z) {
            callBackErrorWithUI(str, new MidasResponse(i, str));
        } else {
            callBackError(new MidasResponse(i, str));
        }
    }
}
