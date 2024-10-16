package com.tencent.midas.oversea.business;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.TestConfig;
import com.tencent.midas.oversea.api.APMidasPayAPI;
import com.tencent.midas.oversea.api.IAPMidasPayCallBack;
import com.tencent.midas.oversea.business.h5.APMidasWebActivity;
import com.tencent.midas.oversea.business.pay.APMidasProxyActivity;
import com.tencent.midas.oversea.business.pay.APOrder;
import com.tencent.midas.oversea.business.pay.ChannelHelper;
import com.tencent.midas.oversea.business.pay.MidasResponse;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GDPR;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.IabBroadcastReceiver;
import com.tencent.midas.oversea.comm.MTimer;
import com.tencent.midas.oversea.data.RestoreItem;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;
import com.tencent.midas.oversea.newapi.response.IAPMidasCallback;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* loaded from: classes.dex */
public class APPayManager {
    public static final String ORDER_KEY = "order_key";
    public static final String TAG = "APPayManager";
    private boolean isBRRegister;
    private ChannelHelper mChannelHelper;
    private IabBroadcastReceiver mIabBroadcastReceiver;
    private SparseArray<APOrder> mOrders;
    private IAPMidasCallback mRestoreCallBack;
    private ArrayList<String> promoRestoreKeys;
    private LinkedList<RestoreItem> restores;
    private IAPMidasCallback seriesCallBack;

    private APPayManager() {
        this.mChannelHelper = null;
        this.mOrders = null;
        this.isBRRegister = false;
        this.mRestoreCallBack = null;
        this.seriesCallBack = null;
    }

    /* loaded from: classes.dex */
    static class InstanceHolder {
        static final APPayManager instance = new APPayManager();

        InstanceHolder() {
        }
    }

    public static APPayManager instance() {
        return InstanceHolder.instance;
    }

    public void init() {
        if (this.mChannelHelper == null) {
            this.mChannelHelper = new ChannelHelper();
        }
        if (this.mOrders == null) {
            this.mOrders = new SparseArray<>();
        }
        if (this.seriesCallBack == null) {
            this.seriesCallBack = new IAPMidasCallback() { // from class: com.tencent.midas.oversea.business.APPayManager.1
                @Override // com.tencent.midas.oversea.newapi.response.IAPMidasCallback
                public void callback(int i, String str) {
                    Exception e;
                    RestoreItem restoreItem;
                    if (APPayManager.this.mRestoreCallBack != null) {
                        APPayManager.this.mRestoreCallBack.callback(i, str);
                    }
                    if (APPayManager.this.restores == null || APPayManager.this.restores.isEmpty()) {
                        APPayManager.this.restores = null;
                        if (APPayManager.this.isBRRegister) {
                            return;
                        }
                        APPayManager.this.registerBR();
                        return;
                    }
                    try {
                        restoreItem = (RestoreItem) APPayManager.this.restores.poll();
                        if (restoreItem != null) {
                            try {
                                APLog.i(APPayManager.TAG, restoreItem.channel + " start reProvide.");
                                restoreItem.restore.restore(APMidasPayNewAPI.singleton().getApplicationContext(), restoreItem.channel, this);
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                APLog.i(APPayManager.TAG, restoreItem.channel + e.getMessage().toString());
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        restoreItem = null;
                    }
                }
            };
        }
    }

    public void pay(Activity activity, BillingFlowParams billingFlowParams, IAPMidasPayCallBack iAPMidasPayCallBack) {
        int generateOrderKey = generateOrderKey();
        this.mOrders.put(generateOrderKey, new APOrder(billingFlowParams, iAPMidasPayCallBack));
        if (this.mChannelHelper.isH5Channel(billingFlowParams.getPayChannel())) {
            Intent intent = new Intent(activity, (Class<?>) APMidasWebActivity.class);
            Bundle bundle = new Bundle();
            bundle.putInt("OrderKey", generateOrderKey);
            bundle.putBoolean("LogEnable", APMidasPayNewAPI.singleton().isLogEnable());
            bundle.putString("PayChannel", billingFlowParams.getPayChannel());
            bundle.putString("debugUrl", TestConfig.mWebViewUrl);
            HashMap<String, String> map = billingFlowParams.toMap();
            map.put("offerId", GlobalData.singleton().offerID);
            map.put("openId", GlobalData.singleton().openID);
            map.put("zoneId", GlobalData.singleton().zoneID);
            map.put("env", GlobalData.singleton().env);
            map.put("idc", GlobalData.singleton().IDC);
            bundle.putString("PayParams", APTools.map2Js(map));
            intent.putExtras(bundle);
            activity.startActivity(intent);
            return;
        }
        MTimer.start(MTimer.SDK_PROCESS_ACTIVITY);
        Intent intent2 = new Intent(activity, (Class<?>) APMidasProxyActivity.class);
        intent2.putExtra("order_key", generateOrderKey);
        activity.startActivity(intent2);
    }

    public APOrder getOrder(int i) {
        SparseArray<APOrder> sparseArray = this.mOrders;
        if (sparseArray != null) {
            return sparseArray.get(i);
        }
        APLog.e(TAG, "getOrder(): order is null !!!");
        return null;
    }

    public void callBackLoginError(int i) {
        APLog.i(TAG, "callBackLoginError()");
        APOrder order = getOrder(i);
        if (order != null) {
            order.callBack.MidasPayNeedLogin();
            updateOrders(i);
        }
        reportData(-1, "MidasPayNeedLogin");
    }

    public void callBackError(int i, MidasResponse midasResponse) {
        APLog.i(TAG, "callBackError()");
        APOrder order = getOrder(i);
        if (order != null) {
            midasResponse.setAppExtends(order.request.getExtra().getAppExtends());
            order.callBack.MidasPayCallBack(midasResponse);
            updateOrders(i);
        }
        reportData(midasResponse.getResultCode(), midasResponse.getResultMsg());
    }

    public void callBackSuccess(int i, MidasResponse midasResponse) {
        APLog.i(TAG, "callBackSuccess()");
        APOrder order = getOrder(i);
        if (order != null) {
            midasResponse.setAppExtends(order.request.getExtra().getAppExtends());
            order.callBack.MidasPayCallBack(midasResponse);
            updateOrders(i);
        }
        reportData(midasResponse.getResultCode(), midasResponse.getResultMsg());
    }

    public void reProvide(IAPMidasCallback iAPMidasCallback) {
        ChannelHelper channelHelper = channelHelper();
        ArrayList<String> restoreChannelList = channelHelper.restoreChannelList();
        if (restoreChannelList == null || restoreChannelList.isEmpty()) {
            if (iAPMidasCallback != null) {
                iAPMidasCallback.callback(0, "don't need reProvide.");
                return;
            }
            return;
        }
        if (this.restores == null) {
            this.restores = new LinkedList<>();
        }
        if (this.promoRestoreKeys == null) {
            this.promoRestoreKeys = new ArrayList<>();
        }
        Iterator<String> it = restoreChannelList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            APBaseRestore createRestoreChannel = channelHelper.createRestoreChannel(next);
            if (createRestoreChannel != null) {
                this.restores.offer(new RestoreItem(next, createRestoreChannel));
                APLog.i(TAG, "Need restore channel: " + next);
                if (channelHelper.isPromoCodeChannel(next) && !this.promoRestoreKeys.contains(next)) {
                    this.promoRestoreKeys.add(next);
                    APLog.i(TAG, "BroadcastReceiver restore channel: " + next);
                }
            }
        }
        if (!this.restores.isEmpty()) {
            this.mRestoreCallBack = iAPMidasCallback;
            triggerRestore();
        } else if (iAPMidasCallback != null) {
            iAPMidasCallback.callback(0, "don't need reProvide.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void triggerRestore() {
        RestoreItem poll;
        LinkedList<RestoreItem> linkedList = this.restores;
        if (linkedList == null || linkedList.isEmpty() || (poll = this.restores.poll()) == null) {
            return;
        }
        APLog.i(TAG, poll.channel + " start reProvide.");
        poll.restore.restore(APMidasPayNewAPI.singleton().getApplicationContext(), poll.channel, this.seriesCallBack);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void registerBR() {
        this.isBRRegister = true;
        this.mIabBroadcastReceiver = new IabBroadcastReceiver(new IabBroadcastReceiver.IabBroadcastListener() { // from class: com.tencent.midas.oversea.business.APPayManager.2
            @Override // com.tencent.midas.oversea.comm.IabBroadcastReceiver.IabBroadcastListener
            public void receivedBroadcast() {
                APLog.i(APPayManager.TAG, "Receiver received broadcast.");
                if (!APPayManager.this.isAllPayFinished() || APPayManager.this.promoRestoreKeys == null || APPayManager.this.promoRestoreKeys.isEmpty()) {
                    return;
                }
                if (APPayManager.this.restores == null) {
                    APPayManager.this.restores = new LinkedList();
                }
                Iterator it = APPayManager.this.promoRestoreKeys.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    APPayManager.this.restores.offer(new RestoreItem(str, APPayManager.this.channelHelper().createRestoreChannel(str)));
                }
                APPayManager.this.triggerRestore();
            }
        });
        APLog.i(TAG, "Register Receiver.");
        APMidasPayNewAPI.singleton().getApplicationContext().registerReceiver(this.mIabBroadcastReceiver, new IntentFilter(IabBroadcastReceiver.ACTION));
    }

    public ChannelHelper channelHelper() {
        if (this.mChannelHelper == null) {
            this.mChannelHelper = new ChannelHelper();
        }
        return this.mChannelHelper;
    }

    public void release() {
        LinkedList<RestoreItem> linkedList = this.restores;
        if (linkedList != null) {
            linkedList.clear();
            this.restores = null;
        }
        ArrayList<String> arrayList = this.promoRestoreKeys;
        if (arrayList != null) {
            arrayList.clear();
            this.promoRestoreKeys = null;
        }
        this.mRestoreCallBack = null;
        this.seriesCallBack = null;
        this.mChannelHelper = null;
        if (this.mIabBroadcastReceiver != null) {
            APMidasPayNewAPI.singleton().getApplicationContext().unregisterReceiver(this.mIabBroadcastReceiver);
            this.isBRRegister = false;
            this.mIabBroadcastReceiver = null;
            APLog.i(TAG, "UnRegister GooglePlay BroadcastReceiver.");
        }
    }

    private int generateOrderKey() {
        SparseArray<APOrder> sparseArray = this.mOrders;
        if (sparseArray != null) {
            return sparseArray.size() + 1;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAllPayFinished() {
        SparseArray<APOrder> sparseArray = this.mOrders;
        return sparseArray == null || sparseArray.size() == 0;
    }

    private void updateOrders(int i) {
        SparseArray<APOrder> sparseArray = this.mOrders;
        if (sparseArray != null) {
            sparseArray.delete(i);
        }
    }

    private void reportData(int i, String str) {
        APDataReportManager.instance().insertData(APDataReportManager.SDK_OVERSEA_EXIT, "name=exitPay&retCode=" + i + "&retMsg=" + str);
        APDataReportManager.instance().insertData(APDataReportManager.PHONE_DEVICE, GDPR.getDeviceInfo(APMidasPayAPI.singleton().getApplicationContext()));
        NetworkManager.singleton().dataReport(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.business.APPayManager.3
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
                APLog.e(APPayManager.TAG, "reportData() onStop.");
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                APDataReportManager.instance().saveDataId(APMidasPayNewAPI.singleton().getApplicationContext());
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                APLog.e(APPayManager.TAG, "reportData() onFailure.");
            }
        });
    }
}
