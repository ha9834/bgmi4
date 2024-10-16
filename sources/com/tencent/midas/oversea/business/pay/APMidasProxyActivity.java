package com.tencent.midas.oversea.business.pay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.CocosPayHelper;
import com.tencent.midas.oversea.business.APPayManager;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APUICommMethod;
import com.tencent.midas.oversea.comm.MTimer;
import com.tencent.midas.oversea.comm.MUIManager;

/* loaded from: classes.dex */
public class APMidasProxyActivity extends Activity implements APPayBaseView {
    public static final String TAG = "APMidasProxyActivity";
    private int orderKey = 0;
    private APOrder mOrder = null;
    private MUIManager uiManager = null;
    private APPayBaseChannel mPresenter = null;

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public Activity getActivity() {
        return this;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        APLog.i(TAG, "onCreate()");
        super.onCreate(bundle);
        APUICommMethod.clearCoverForStatus(getWindow(), true);
        MTimer.stop(MTimer.SDK_PROCESS_ACTIVITY);
        this.orderKey = getIntent().getIntExtra("order_key", 0);
        this.mOrder = APPayManager.instance().getOrder(this.orderKey);
        if (this.mOrder != null) {
            this.uiManager = new MUIManager(this);
            APPayBaseChannel createChannel = createChannel();
            this.mPresenter = createChannel;
            if (createChannel != null) {
                this.mPresenter.init(this);
                this.mPresenter.startPayCheckEnv();
            } else {
                callBackError(new MidasResponse(-3, "Wrong assign pay channel."));
            }
            APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_ENTER, "name=enterPay");
            return;
        }
        finish();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            callBackError(new MidasResponse(-2));
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        MUIManager mUIManager = this.uiManager;
        if (mUIManager != null) {
            mUIManager.release();
            this.uiManager = null;
        }
        this.mOrder = null;
        APPayBaseChannel aPPayBaseChannel = this.mPresenter;
        if (aPPayBaseChannel != null) {
            aPPayBaseChannel.release();
            this.mPresenter = null;
        }
        APLog.i(TAG, "onDestroy()");
    }

    private APPayBaseChannel createChannel() {
        return APPayManager.instance().channelHelper().createPayChannel(getOrder().request.getPayChannel());
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public void callBackLoginError() {
        APPayManager.instance().callBackLoginError(this.orderKey);
        finish();
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public void callBackError(MidasResponse midasResponse) {
        APPayManager.instance().callBackError(this.orderKey, midasResponse);
        finish();
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public void callBackSuccess(MidasResponse midasResponse) {
        MUIManager mUIManager;
        APPayManager.instance().callBackSuccess(this.orderKey, midasResponse);
        if (midasResponse.needShowSuccess && (mUIManager = this.uiManager) != null) {
            mUIManager.successToast("");
        }
        finish();
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public APOrder getOrder() {
        return this.mOrder;
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public int getOrderKey() {
        return this.orderKey;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        APPayBaseChannel aPPayBaseChannel = this.mPresenter;
        if (aPPayBaseChannel != null) {
            aPPayBaseChannel.handleActivityResult(i, i2, intent);
        }
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public void showWaitDialog() {
        MUIManager mUIManager = this.uiManager;
        if (mUIManager != null) {
            mUIManager.showLoading();
        }
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public void dismissWaitDialog() {
        MUIManager mUIManager = this.uiManager;
        if (mUIManager != null) {
            mUIManager.dismissWaitDialog();
        }
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public void showErrorMsg(String str, final MidasResponse midasResponse) {
        MUIManager mUIManager = this.uiManager;
        if (mUIManager != null) {
            mUIManager.showErrorMsg(str, new MUIManager.MNotifier() { // from class: com.tencent.midas.oversea.business.pay.APMidasProxyActivity.1
                @Override // com.tencent.midas.oversea.comm.MUIManager.MNotifier
                public void callback() {
                    APMidasProxyActivity.this.callBackError(midasResponse);
                }
            });
        }
    }

    @Override // com.tencent.midas.oversea.business.pay.APPayBaseView
    public void showSandboxDialog() {
        MUIManager mUIManager = this.uiManager;
        if (mUIManager != null) {
            mUIManager.showSandboxDialog(new MUIManager.MNotifier() { // from class: com.tencent.midas.oversea.business.pay.APMidasProxyActivity.2
                @Override // com.tencent.midas.oversea.comm.MUIManager.MNotifier
                public void callback() {
                    APMidasProxyActivity.this.mPresenter.startPay();
                }
            }, new MUIManager.MNotifier() { // from class: com.tencent.midas.oversea.business.pay.APMidasProxyActivity.3
                @Override // com.tencent.midas.oversea.comm.MUIManager.MNotifier
                public void callback() {
                    APMidasProxyActivity.this.callBackError(new MidasResponse(-2));
                }
            });
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (TextUtils.equals(this.mOrder.request.getPayChannel(), CocosPayHelper.GWALLET)) {
            MTimer.stop(MTimer.GW_PROCESS_SHOW_DIALOG);
            MTimer.stop(MTimer.GW_FIRST_SCREEN_SHOWDIALOG);
        }
    }
}
