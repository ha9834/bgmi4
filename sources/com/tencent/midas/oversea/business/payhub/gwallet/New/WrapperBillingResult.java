package com.tencent.midas.oversea.business.payhub.gwallet.New;

import com.android.billingclient.api.h;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.comm.MRetCode;

/* loaded from: classes.dex */
public class WrapperBillingResult {
    private final String TAG = "WrapperBillingResult";
    private final h billingResult;

    public WrapperBillingResult(h hVar) {
        this.billingResult = hVar;
    }

    public boolean isSuccess() {
        return this.billingResult.a() == 0;
    }

    public int resultCode() {
        return this.billingResult.a();
    }

    public String resultMsg() {
        return this.billingResult.b();
    }

    public int unifyErrCode() {
        APLog.i("WrapperBillingResult", "unifyGWErrCode(),gw origin error code: " + resultMsg());
        int resultCode = resultCode();
        if (resultCode == -3) {
            return MRetCode.ERR_GW_BILLING_SERVICE_TIMEOUT;
        }
        if (resultCode == -1) {
            return MRetCode.ERR_GW_BILLING_SERVICE_DISCONNECTED;
        }
        switch (resultCode) {
            case 1:
                return -2001;
            case 2:
                return MRetCode.ERR_GW_BILLING_SERVICE_UNAVAILABLE;
            case 3:
                return resultMsg().contains("unavailable on device") ? MRetCode.ERR_GW_BILLING_UNAVAILABLE_DEVICE : MRetCode.ERR_GW_BILLING_UNAVAILABLE_ACCOUNT;
            case 4:
                return MRetCode.ERR_GW_BILLING_ITEM_UNAVAILABLE;
            case 5:
                return MRetCode.ERR_GW_BILLING_DEVELOPER_ERROR;
            case 6:
                return MRetCode.ERR_GW_BILLING_RESULT_ERROR;
            case 7:
                return MRetCode.ERR_GW_BILLING_ITEM_ALREADY_OWNED;
            case 8:
                return MRetCode.ERR_GW_BILLING_ITEM_NOT_OWNED;
            default:
                return -2000;
        }
    }

    public void showSandboxErrTips() {
        switch (resultCode()) {
            case 1:
                APLog.e("WrapperBillingResult", resultMsg() + "\n原因：用户按下了返回键或取消了对话框\n");
                return;
            case 2:
                APLog.e("WrapperBillingResult", resultMsg() + "\n原因：网络连接丢失\n");
                return;
            case 3:
                APLog.e("WrapperBillingResult", resultMsg() + "\n原因：Billing API 版本不受所请求类型的支持\n");
                return;
            case 4:
                APLog.e("WrapperBillingResult", resultMsg() + "\n原因：请求的商品不可以购买\n");
                return;
            case 5:
                APLog.e("WrapperBillingResult", resultMsg() + "\n原因：向 API 提供的参数无效。此错误也可能说明应用未在 Google Play 中针对应用内购买结算正确签署或设置，或者在清单中没有所需的权限\n");
                return;
            case 6:
                APLog.e("WrapperBillingResult", resultMsg() + "\n原因1：\ngoogle play返回错误内容，可能手机未开启系统弹框权限，小米默认未开启\n解决：\n设置中开启google play store的系统弹窗权限，再重试\n原因2：\nAPI操作期间发生致命错误");
                return;
            case 7:
                APLog.e("WrapperBillingResult", resultMsg() + "\n原因：\n已拥有该物品，可能是上次购买该物品后发货失败导致\n解决：\n1、先退出应用重新登录，再重试\n2、不行再清除google play store缓存重试");
                return;
            case 8:
                APLog.e("WrapperBillingResult", resultMsg() + "\n原因：由于未拥有该商品，消耗失败\n");
                return;
            default:
                return;
        }
    }

    public String toString() {
        return "resultCode|" + resultCode() + ",resultMsg|" + resultMsg();
    }
}
