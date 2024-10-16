package com.tencent.midas.oversea.newnetwork.http;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.http.core.Request;
import com.tencent.midas.http.core.Response;
import com.tencent.midas.http.midashttp.APMidasHttpAns;
import com.tencent.midas.http.midashttp.APMidasHttpRequest;
import com.tencent.midas.http.midashttp.APMidasNetworkManager;
import com.tencent.midas.http.midashttp.IAPDataReportNotifier;
import com.tencent.midas.http.midashttp.IAPMidasCommonInfoGetter;
import com.tencent.midas.http.midashttp.IAPMidasHttpCallback;
import com.tencent.midas.oversea.api.IAPMidasNetCallBack;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MTimer;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;
import com.tencent.midas.oversea.newapi.params.InitParams;
import com.tencent.midas.oversea.newapi.params.NetParams;
import com.tencent.midas.oversea.newapi.response.NotifyCallback;
import com.tencent.midas.oversea.newnetwork.model.APDataReportAns;
import com.tencent.midas.oversea.newnetwork.model.APDataReportReq;
import com.tencent.midas.oversea.newnetwork.model.APDetectAns;
import com.tencent.midas.oversea.newnetwork.model.APDetectRequest;
import com.tencent.midas.oversea.newnetwork.model.APEndGetIPInterceptor;
import com.tencent.midas.oversea.newnetwork.model.APEndGetKeyInterceptor;
import com.tencent.midas.oversea.newnetwork.model.APFrontGetIPInterceptor;
import com.tencent.midas.oversea.newnetwork.model.APHttpsIPDirectHandler;
import com.tencent.midas.oversea.newnetwork.model.APIntroPriceAns;
import com.tencent.midas.oversea.newnetwork.model.APIntroPriceReq;
import com.tencent.midas.oversea.newnetwork.model.APMpAns;
import com.tencent.midas.oversea.newnetwork.model.APMpReq;
import com.tencent.midas.oversea.newnetwork.model.APOverSeaCommAns;
import com.tencent.midas.oversea.newnetwork.model.APOverSeaCommReq;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NetworkManager {
    public static final String CMD_GET_IP_LIST = "get_ip";
    public static final String CMD_GET_KEY = "get_key";
    public static final String CMD_INFO = "info";
    public static final String CMD_ORDER = "order";
    public static final String CMD_PROVIDE = "provide";
    public static final String CMD_TAG = "overseas_cmd";
    public static final String TAG = "NetworkManager";
    private APMidasNetworkManager networkManager;

    private NetworkManager() {
        initNewNetworkModule();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InstanceHolder {
        static NetworkManager instance = new NetworkManager();

        InstanceHolder() {
        }
    }

    public static NetworkManager singleton() {
        return InstanceHolder.instance;
    }

    private void initNewNetworkModule() {
        NewNetLog newNetLog = new NewNetLog();
        newNetLog.setLogEnable(false);
        this.networkManager = new APMidasNetworkManager(newNetLog);
        this.networkManager.setBaseKey(GlobalData.singleton().getBaseKey());
        APMidasNetworkManager aPMidasNetworkManager = this.networkManager;
        GlobalData.singleton();
        aPMidasNetworkManager.setIV(GlobalData.getIV());
        this.networkManager.setContext(APMidasPayNewAPI.singleton().getApplicationContext());
        this.networkManager.addFistInterceptor(new APFrontGetIPInterceptor());
        this.networkManager.addLastInterceptor(new APEndGetIPInterceptor());
        APMidasNetworkManager aPMidasNetworkManager2 = this.networkManager;
        aPMidasNetworkManager2.addLastInterceptor(new APEndGetKeyInterceptor(aPMidasNetworkManager2));
        this.networkManager.setMidasCommonInfoGetter(new IAPMidasCommonInfoGetter() { // from class: com.tencent.midas.oversea.newnetwork.http.NetworkManager.1
            @Override // com.tencent.midas.http.midashttp.IAPMidasCommonInfoGetter
            public String getSdkVersion() {
                return GlobalData.SDK_VERSION;
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasCommonInfoGetter
            public String getHttpHostHeaderDomain(APMidasHttpRequest aPMidasHttpRequest) {
                String host;
                if ((aPMidasHttpRequest instanceof APDataReportReq) || (aPMidasHttpRequest instanceof APDetectRequest)) {
                    host = aPMidasHttpRequest.getHost();
                } else {
                    host = GlobalData.singleton().NetCfg().getHost();
                }
                APLog.d(NetworkManager.TAG, "getHttpHostHeaderDomain host: " + host);
                return host;
            }
        });
        this.networkManager.setDataReportNotifier(new IAPDataReportNotifier() { // from class: com.tencent.midas.oversea.newnetwork.http.NetworkManager.2
            @Override // com.tencent.midas.http.midashttp.IAPDataReportNotifier
            public void onNetworkSuccess(Request request, Response response) {
                if (request == null || response == null) {
                    return;
                }
                NetWorker.sendReportData(request, 0, 200, "", response);
            }

            @Override // com.tencent.midas.http.midashttp.IAPDataReportNotifier
            public void onNetworkFailure(Request request, Response response) {
                if (request == null || response == null) {
                    return;
                }
                NetWorker.sendReportData(request, APTools.getErrorTypeFromException(response.exception), APTools.getResponseCodeForDataReport(response), response.exception != null ? response.exception.toString() : "", response);
            }
        });
        this.networkManager.addHttpHandler(new APHttpsIPDirectHandler());
        this.networkManager.setup();
    }

    public void saveKeyInfo(String str, String str2, String str3, String str4, String str5) {
        Context applicationContext = APMidasPayNewAPI.singleton().getApplicationContext();
        this.networkManager.setSecretKeyToRam(str2, str, str3);
        this.networkManager.setCryptKeyToRam(str2, str, str4);
        this.networkManager.setKeyTimeToRam(str2, str, str5);
        this.networkManager.saveSecretKeyToDisk(applicationContext, str2, str, str3, GlobalData.SDK_VERSION);
        this.networkManager.saveCryptKeyToDisk(applicationContext, str2, str, str4, GlobalData.SDK_VERSION);
        this.networkManager.saveKeyTimeToDisk(applicationContext, str2, str, str5, GlobalData.SDK_VERSION);
        APLog.i(TAG, "save key success.");
    }

    public String getCryToKey(String str, String str2) {
        return this.networkManager.getCryptKeyFromRam(str2, str);
    }

    public String readKeyTime(String str, String str2) {
        return this.networkManager.getKeyTimeFromRam(str2, str);
    }

    public boolean needChangeKey(String str, String str2) {
        IAPMidasCommonInfoGetter midasCommonInfoGetter = this.networkManager.getMidasCommonInfoGetter();
        if (midasCommonInfoGetter == null) {
            APLog.e(TAG, "needChangeKey: commonInfoGetter = null");
            return false;
        }
        return this.networkManager.needChangeKey(APMidasPayNewAPI.singleton().getApplicationContext(), str2, str, midasCommonInfoGetter.getSdkVersion());
    }

    public void introPriceReq(String str, List<String> list, IAPMidasHttpCallback iAPMidasHttpCallback) {
        this.networkManager.executeRequestAsync(new APIntroPriceReq().setChannel(str).setQueryProductList(list).setUp(), new APIntroPriceAns(iAPMidasHttpCallback));
    }

    public void initReq(InitParams initParams, final NotifyCallback notifyCallback) {
        APOverSeaCommReq up = new APOverSeaCommReq().setRequest(NetworkReqParams.switchParams(initParams)).setUp();
        MTimer.start(String.valueOf(up.hashCode()));
        this.networkManager.executeRequestAsync(up, new APOverSeaCommAns(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newnetwork.http.NetworkManager.3
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Succ");
                NotifyCallback notifyCallback2 = notifyCallback;
                if (notifyCallback2 != null) {
                    notifyCallback2.onFinish();
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Fail");
                NotifyCallback notifyCallback2 = notifyCallback;
                if (notifyCallback2 != null) {
                    notifyCallback2.onFinish();
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Stop");
                NotifyCallback notifyCallback2 = notifyCallback;
                if (notifyCallback2 != null) {
                    notifyCallback2.onFinish();
                }
            }
        }));
    }

    public void startSecInfo(final String str, NetParams netParams, final IAPMidasNetCallBack iAPMidasNetCallBack) {
        APOverSeaCommReq up = new APOverSeaCommReq().setCmd(CMD_INFO).setRequest(NetworkReqParams.switchParams(netParams)).setInfoType(str).setUp();
        MTimer.start(String.valueOf(up.hashCode()));
        this.networkManager.executeRequestAsync(up, new APOverSeaCommAns(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newnetwork.http.NetworkManager.4
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Succ");
                if (aPMidasHttpAns.getResultCode() == 0 && (aPMidasHttpAns instanceof APOverSeaCommAns)) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("ret", 0);
                        jSONObject.put("err_code", "0");
                        jSONObject.put("msg", new JSONObject(((APOverSeaCommAns) aPMidasHttpAns).getInfoMsg()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    IAPMidasNetCallBack iAPMidasNetCallBack2 = iAPMidasNetCallBack;
                    if (iAPMidasNetCallBack2 != null) {
                        iAPMidasNetCallBack2.MidasNetFinish(str, jSONObject.toString());
                        return;
                    }
                    return;
                }
                IAPMidasNetCallBack iAPMidasNetCallBack3 = iAPMidasNetCallBack;
                if (iAPMidasNetCallBack3 != null) {
                    iAPMidasNetCallBack3.MidasNetError(str, aPMidasHttpAns.getResultCode(), aPMidasHttpAns.getResultMessage());
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Fail");
                IAPMidasNetCallBack iAPMidasNetCallBack2 = iAPMidasNetCallBack;
                if (iAPMidasNetCallBack2 != null) {
                    iAPMidasNetCallBack2.MidasNetError(str, aPMidasHttpAns.getResultCode(), aPMidasHttpAns.getResultMessage());
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Stop");
                IAPMidasNetCallBack iAPMidasNetCallBack2 = iAPMidasNetCallBack;
                if (iAPMidasNetCallBack2 != null) {
                    iAPMidasNetCallBack2.MidasNetStop(str);
                }
            }
        }));
    }

    public void net(final String str, NetParams netParams, final IAPMidasNetCallBack iAPMidasNetCallBack) {
        APMpReq up = new APMpReq().setRequest(NetworkReqParams.switchParams(netParams)).setHttpRequestKey(str).setUp();
        MTimer.start(String.valueOf(up.hashCode()));
        this.networkManager.executeRequestAsync(up, new APMpAns(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newnetwork.http.NetworkManager.5
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "netSucc");
                if (aPMidasHttpAns instanceof APMpAns) {
                    APMpAns aPMpAns = (APMpAns) aPMidasHttpAns;
                    IAPMidasNetCallBack iAPMidasNetCallBack2 = iAPMidasNetCallBack;
                    if (iAPMidasNetCallBack2 != null) {
                        iAPMidasNetCallBack2.MidasNetFinish(((APMidasHttpRequestBase) aPMidasHttpAns.getAPMidasHttpRequest()).getHttpRequestKey(), aPMpAns.getMpJson());
                        return;
                    }
                    return;
                }
                IAPMidasNetCallBack iAPMidasNetCallBack3 = iAPMidasNetCallBack;
                if (iAPMidasNetCallBack3 != null) {
                    iAPMidasNetCallBack3.MidasNetFinish(str, "");
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "netFail");
                IAPMidasNetCallBack iAPMidasNetCallBack2 = iAPMidasNetCallBack;
                if (iAPMidasNetCallBack2 != null) {
                    iAPMidasNetCallBack2.MidasNetError(((APMidasHttpRequestBase) aPMidasHttpAns.getAPMidasHttpRequest()).getHttpRequestKey(), aPMidasHttpAns.getResultCode(), aPMidasHttpAns.getResultMessage());
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "netStop");
                IAPMidasNetCallBack iAPMidasNetCallBack2 = iAPMidasNetCallBack;
                if (iAPMidasNetCallBack2 != null) {
                    iAPMidasNetCallBack2.MidasNetStop(((APMidasHttpRequestBase) aPMidasHttpAns.getAPMidasHttpRequest()).getHttpRequestKey());
                }
            }
        }));
    }

    public void getOrder(String str, String str2, String str3, String str4, String str5, String str6, String str7, BillingFlowParams billingFlowParams, final IAPMidasHttpCallback iAPMidasHttpCallback) {
        APOverSeaCommReq up = new APOverSeaCommReq().setCmd(CMD_ORDER).setServiceCode(str5).setCurrencyType(str2).setPayCurrencyType(str3).setAmt(str7).setPayMethod(str).setPayAmount(str4).setBuyQuantity(str6).setIsReProvide(false).setRequest(NetworkReqParams.switchParams(billingFlowParams)).setUp();
        MTimer.start(String.valueOf(up.hashCode()));
        this.networkManager.executeRequestAsync(up, new APOverSeaCommAns(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newnetwork.http.NetworkManager.6
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Succ");
                IAPMidasHttpCallback iAPMidasHttpCallback2 = iAPMidasHttpCallback;
                if (iAPMidasHttpCallback2 != null) {
                    iAPMidasHttpCallback2.onSuccess(aPMidasHttpAns);
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Fail");
                IAPMidasHttpCallback iAPMidasHttpCallback2 = iAPMidasHttpCallback;
                if (iAPMidasHttpCallback2 != null) {
                    iAPMidasHttpCallback2.onFailure(aPMidasHttpAns);
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Stop");
                IAPMidasHttpCallback iAPMidasHttpCallback2 = iAPMidasHttpCallback;
                if (iAPMidasHttpCallback2 != null) {
                    iAPMidasHttpCallback2.onStop(aPMidasHttpAns);
                }
            }
        }));
    }

    public void provide(boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, BillingFlowParams billingFlowParams, final IAPMidasHttpCallback iAPMidasHttpCallback) {
        APOverSeaCommReq up = new APOverSeaCommReq().setCmd(CMD_PROVIDE).setCurrencyType(str).setPayMethod(str2).setBillNO(str4).setReceipt(str5).setReceiptOpenID(str6).setReceiptSign(str7).setIsReProvide(z).setNum(str3).setRequest(NetworkReqParams.switchParams(billingFlowParams)).setUp();
        MTimer.start(String.valueOf(up.hashCode()));
        this.networkManager.executeRequestAsync(up, new APOverSeaCommAns(new IAPMidasHttpCallback() { // from class: com.tencent.midas.oversea.newnetwork.http.NetworkManager.7
            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onSuccess(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Succ");
                IAPMidasHttpCallback iAPMidasHttpCallback2 = iAPMidasHttpCallback;
                if (iAPMidasHttpCallback2 != null) {
                    iAPMidasHttpCallback2.onSuccess(aPMidasHttpAns);
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onFailure(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Fail");
                IAPMidasHttpCallback iAPMidasHttpCallback2 = iAPMidasHttpCallback;
                if (iAPMidasHttpCallback2 != null) {
                    iAPMidasHttpCallback2.onFailure(aPMidasHttpAns);
                }
            }

            @Override // com.tencent.midas.http.midashttp.IAPMidasHttpCallback
            public void onStop(APMidasHttpAns aPMidasHttpAns) {
                NetworkManager.this.reportTime(aPMidasHttpAns, "Stop");
                IAPMidasHttpCallback iAPMidasHttpCallback2 = iAPMidasHttpCallback;
                if (iAPMidasHttpCallback2 != null) {
                    iAPMidasHttpCallback2.onStop(aPMidasHttpAns);
                }
            }
        }));
    }

    public void getMall(IAPMidasHttpCallback iAPMidasHttpCallback) {
        this.networkManager.executeRequestAsync(new APOverSeaCommReq().setCmd(CMD_INFO).setUp(), new APOverSeaCommAns(iAPMidasHttpCallback));
    }

    public void request(APMidasHttpRequest aPMidasHttpRequest, APMidasHttpAns aPMidasHttpAns) {
        this.networkManager.executeRequestAsync(aPMidasHttpRequest, aPMidasHttpAns);
    }

    public void cancelPreRequest() {
        this.networkManager.cancelAllRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportTime(APMidasHttpAns aPMidasHttpAns, String str) {
        APMidasHttpRequestBase aPMidasHttpRequestBase = (APMidasHttpRequestBase) aPMidasHttpAns.getAPMidasHttpRequest();
        MTimer.stop(String.valueOf(aPMidasHttpRequestBase.hashCode()));
        String str2 = aPMidasHttpRequestBase.getCmd() + str;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        str2.replace("|", "");
        APDataReportManager.instance().insertData(APDataReportManager.SDK_COMM_NET_TIME, "name=" + str2 + "&times=" + MTimer.duration(String.valueOf(aPMidasHttpRequestBase.hashCode())) + "&retCode=" + aPMidasHttpAns.getResultCode());
    }

    public void dataReport(IAPMidasHttpCallback iAPMidasHttpCallback) {
        ArrayList<String> arrayList = new ArrayList<>();
        int logRecord = APDataReportManager.instance().getLogRecord(arrayList);
        for (int i = 0; i < logRecord; i++) {
            APLog.i(TAG, "report data: " + arrayList.get(i));
            APDataReportReq up = new APDataReportReq().setData(arrayList.get(i)).setUp();
            if (up.needReport()) {
                APLog.d("isNeedReport", "needreport");
                this.networkManager.executeRequestAsync(up, new APDataReportAns(iAPMidasHttpCallback));
            }
        }
    }

    public void detectTaskQuery(IAPMidasHttpCallback iAPMidasHttpCallback) {
        APDetectRequest aPDetectRequest = new APDetectRequest();
        aPDetectRequest.setUp();
        this.networkManager.executeRequestAsync(aPDetectRequest, new APDetectAns(iAPMidasHttpCallback));
    }
}
