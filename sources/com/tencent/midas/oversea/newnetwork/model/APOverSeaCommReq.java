package com.tencent.midas.oversea.newnetwork.model;

import android.content.Context;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.gamingservices.cloudgaming.internal.SDKAnalyticsEvents;
import com.tencent.connect.common.Constants;
import com.tencent.mid.api.MidEntity;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.api.APMidasPayAPI;
import com.tencent.midas.oversea.comm.APDataReportManager;
import com.tencent.midas.oversea.comm.APMD5;
import com.tencent.midas.oversea.comm.APTools;
import com.tencent.midas.oversea.comm.GDPR;
import com.tencent.midas.oversea.comm.GlobalData;
import com.tencent.midas.oversea.comm.MConstants;
import com.tencent.midas.oversea.newapi.params.BillingFlowParams;
import com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase;
import com.tencent.midas.oversea.newnetwork.http.NetworkManager;
import com.tencent.midas.oversea.newnetwork.http.NetworkReqParams;
import com.tencent.open.SocialOperation;
import java.net.URLEncoder;
import java.util.Locale;

/* loaded from: classes.dex */
public class APOverSeaCommReq extends APMidasHttpRequestBase {
    public static final String TAG = "APOverSeaCommReq";
    private String amt;
    private String billno;
    private String buy_quantity;
    private String currency_type;
    private String infoType = "";
    private boolean isReProvide = false;
    private String num;
    private String payAmount;
    private String payCurrencyType;
    private String pay_method;
    private String receipt;
    private String receipt_openid;
    private String receipt_sign;
    private String service_code;
    private String userip;

    public APOverSeaCommReq setCmd(String str) {
        this.cmd = str;
        return this;
    }

    public APOverSeaCommReq setRequest(NetworkReqParams networkReqParams) {
        this.request = networkReqParams;
        return this;
    }

    public APOverSeaCommReq setInfoType(String str) {
        this.infoType = str;
        return this;
    }

    public APOverSeaCommReq setServiceCode(String str) {
        this.service_code = str;
        return this;
    }

    public APOverSeaCommReq setUserIp(String str) {
        this.userip = str;
        return this;
    }

    public APOverSeaCommReq setCurrencyType(String str) {
        this.currency_type = str;
        return this;
    }

    public APOverSeaCommReq setPayCurrencyType(String str) {
        this.payCurrencyType = str;
        return this;
    }

    public APOverSeaCommReq setAmt(String str) {
        this.amt = str;
        return this;
    }

    public APOverSeaCommReq setPayMethod(String str) {
        this.pay_method = str;
        return this;
    }

    public APOverSeaCommReq setPayAmount(String str) {
        this.payAmount = str;
        return this;
    }

    public APOverSeaCommReq setBuyQuantity(String str) {
        this.buy_quantity = str;
        return this;
    }

    public APOverSeaCommReq setBillNO(String str) {
        this.billno = str;
        return this;
    }

    public APOverSeaCommReq setReceipt(String str) {
        this.receipt = str;
        return this;
    }

    public APOverSeaCommReq setReceiptOpenID(String str) {
        this.receipt_openid = str;
        return this;
    }

    public APOverSeaCommReq setReceiptSign(String str) {
        this.receipt_sign = str;
        return this;
    }

    public APOverSeaCommReq setIsReProvide(boolean z) {
        this.isReProvide = z;
        return this;
    }

    public APOverSeaCommReq setNum(String str) {
        this.num = str;
        return this;
    }

    public APOverSeaCommReq setUp() {
        initUrl();
        constructParam();
        ifChangeKey();
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.midas.oversea.newnetwork.http.APMidasHttpRequestBase
    public void constructParam() {
        String str;
        String str2;
        if (this.request == null) {
            APLog.e(TAG, "Request is null !!!");
            return;
        }
        super.constructParam();
        addHttpParameters("openid", GlobalData.singleton().openID);
        addHttpParameters(Constants.PARAM_PLATFORM_ID, GlobalData.singleton().pf);
        addHttpParameters("pfkey", GlobalData.singleton().pfKey);
        addHttpParameters(SocialOperation.GAME_ZONE_ID, GlobalData.singleton().zoneID);
        addHttpParameters("format", "json");
        addHttpParameters("key_len", "newkey");
        addHttpParameters("key_time", NetworkManager.singleton().readKeyTime(GlobalData.singleton().offerID, GlobalData.singleton().openID));
        addHttpParameters("session_token", GlobalData.singleton().getNetToken());
        addHttpParameters("goods_zoneid", this.request.goodsZoneID);
        if (GDPR.ifCollect) {
            if (TextUtils.isEmpty(GDPR.getXgMid())) {
                addHttpParameters("xg_mid", "");
            } else {
                addHttpParameters("xg_mid", URLEncoder.encode(GDPR.getXgMid()));
            }
        }
        addHttpEncodeParameter("openid", GlobalData.singleton().openID);
        addHttpEncodeParameter("openkey", GlobalData.singleton().openKey);
        addHttpEncodeParameter(SDKAnalyticsEvents.PARAMETER_SESSION_ID, GlobalData.singleton().sessionID);
        addHttpEncodeParameter("session_type", GlobalData.singleton().sessionType);
        addHttpEncodeParameter("sdkversion", "androidoversea_v4.5.2b");
        addHttpEncodeParameter("buy_quantity", this.buy_quantity);
        if (!TextUtils.isEmpty(this.infoType)) {
            addHttpParameters("type", this.infoType);
        } else if (!TextUtils.isEmpty(this.request.mType)) {
            addHttpEncodeParameter("type", this.request.mType);
        }
        String str3 = this.request.drmInfo;
        if (TextUtils.isEmpty(str3)) {
            str = "version=3.0";
        } else {
            str = str3 + "&version=3.0";
        }
        addHttpEncodeParameter("drm_info", URLEncoder.encode(str));
        if (!TextUtils.isEmpty(this.currency_type)) {
            addHttpEncodeParameter("currency_type", this.currency_type);
        }
        if (!TextUtils.isEmpty(this.request.country)) {
            addHttpEncodeParameter(UserDataStore.COUNTRY, this.request.country);
        }
        if (!TextUtils.isEmpty(this.service_code)) {
            addHttpEncodeParameter("service_code", this.service_code);
        }
        if (!TextUtils.isEmpty(this.userip)) {
            addHttpEncodeParameter("userip", this.userip);
        }
        String str4 = this.request.reserve;
        if (!TextUtils.isEmpty(str4)) {
            str2 = str4 + "&midas_goods_zoneid=" + this.request.goodsZoneID;
        } else {
            str2 = "midas_goods_zoneid=" + this.request.goodsZoneID;
        }
        APLog.d("Extend reserv", str2);
        try {
            addHttpEncodeParameter("language", Locale.getDefault().getISO3Language());
            addHttpParameters("extend", URLEncoder.encode(str2, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!TextUtils.isEmpty(this.pay_method)) {
            addHttpEncodeParameter("pay_method", this.pay_method);
        }
        String str5 = this.request.productID;
        if (!TextUtils.isEmpty(str5)) {
            addHttpEncodeParameter(APDataReportManager.SDK_FIELD_PRODUCTID, str5);
        }
        if (!TextUtils.isEmpty(this.amt)) {
            addHttpEncodeParameter("amt", this.amt);
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.payAmount)) {
            sb.append("gw_amt=");
            sb.append(this.payAmount);
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.payCurrencyType)) {
            sb.append("gw_currency=");
            sb.append(this.payCurrencyType);
            sb.append("&");
        }
        if (MConstants.DevEnv.equals(GlobalData.singleton().env) || MConstants.TestEnv.equals(GlobalData.singleton().env)) {
            sb.append("sandbox=true");
            sb.append("&");
        }
        if (!TextUtils.isEmpty(this.pay_method) && "os_doku".equals(this.pay_method)) {
            sb.append("from=doku_sdk");
            sb.append("&");
        }
        sb.append(this.request.extra);
        if (TextUtils.isEmpty(sb)) {
            addHttpEncodeParameter("wf_info", "");
        } else {
            addHttpEncodeParameter("wf_info", APTools.urlEncode(sb.toString(), 1));
        }
        if (this.cmd.contains(NetworkManager.CMD_ORDER) && this.request != null && ("unimonth".equals(this.request.mType) || BillingFlowParams.TYPE_MONTH.equals(this.request.mType))) {
            addHttpEncodeParameter("producttype", this.request.isAutoPay ? "2" : "0");
        }
        if (this.cmd.contains(NetworkManager.CMD_PROVIDE)) {
            if (!TextUtils.isEmpty(this.billno)) {
                addHttpEncodeParameter(APDataReportManager.SDK_FIELD_BILLNO, this.billno);
            }
            if (!TextUtils.isEmpty(this.receipt)) {
                addHttpEncodeParameter("receipt", this.receipt);
            }
            if (!TextUtils.isEmpty(this.receipt_openid)) {
                addHttpEncodeParameter("receipt_openid", this.receipt_openid);
            }
            addHttpEncodeParameter("buy_quantity", this.num);
            if (!TextUtils.isEmpty(this.receipt_sign)) {
                addHttpEncodeParameter("receipt_sign", this.receipt_sign);
                addHttpEncodeParameter("sig", APMD5.toMd5(this.receipt.getBytes()));
            }
            if (!TextUtils.isEmpty(GlobalData.singleton().offerID)) {
                addHttpEncodeParameter("receipt_offer_id", GlobalData.singleton().offerID);
            }
            if (this.isReProvide) {
                addHttpParameters("action", "reprovide");
            } else {
                addHttpParameters("action", NetworkManager.CMD_PROVIDE);
            }
        }
        if (GDPR.ifCollect) {
            Context applicationContext = APMidasPayAPI.singleton().getApplicationContext();
            String wifiSSID = GDPR.getWifiSSID(applicationContext);
            if (TextUtils.isEmpty(wifiSSID)) {
                addHttpEncodeParameter("wifi_ssid", "");
            } else {
                addHttpEncodeParameter("wifi_ssid", URLEncoder.encode(wifiSSID));
            }
            addHttpEncodeParameter("device_imei", GDPR.getDeviceId(applicationContext));
            addHttpEncodeParameter("vendor_id", GDPR.getAndroidId(applicationContext));
            addHttpEncodeParameter("device_guid", GDPR.getDeviceGuid(applicationContext));
            addHttpEncodeParameter(MidEntity.TAG_MAC, GDPR.getMacAddress(applicationContext));
            addHttpEncodeParameter("device_type", GDPR.getDeviceType());
            addHttpEncodeParameter("device_name", GDPR.getDeviceName());
            addHttpEncodeParameter("device", GDPR.getDevice());
            addHttpEncodeParameter("device_product", GDPR.getDeviceManufacturer());
            addHttpEncodeParameter("sys_version", GDPR.getSysVersion());
        }
        addHttpEncodeParameter("rtt", "" + GlobalData.singleton().NetTimeout().getRtt(getHost()));
        addHttpEncodeParameter("loss_rate", "" + GlobalData.singleton().NetTimeout().getIpLossRate(getHost()));
    }
}
