package com.tencent.midas.oversea.comm;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.midas.comm.APLog;
import com.tencent.midas.oversea.newapi.APMidasPayNewAPI;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class APDataReportManager {
    private static final int GROUP_SIZE = 12;
    public static final String NETWORK_REQUEST = "sdk.oversea.midas.networkrequest";
    public static final String PHONE_DEVICE = "sdk.oversea.deviceinfo";
    public static final String SDK_CALL_GW20_SDK_CALL = "sdk.oversea.call.gw20.sdk.call";
    public static final String SDK_CALL_GW20_SDK_RESPONSE = "sdk.oversea.call.gw20.sdk.response";
    public static final String SDK_CALL_GW_SDK_API_VERSION = "sdk.oversea.call.gw.api.version";
    public static final String SDK_CALL_GW_SDK_CALL = "sdk.oversea.call.gw.sdk.call";
    public static final String SDK_CALL_GW_SDK_INNER_ERROR = "sdk.oversea.call.gw.inner.error";
    public static final String SDK_CALL_GW_SDK_RESPONSE = "sdk.oversea.call.gw.sdk.response";
    public static final String SDK_COMM_NET_TIME = "sdk.comm.net.time";
    public static final String SDK_CRASH_RESTORE = "sdk.oversea.cash.restore";
    public static final String SDK_FIELD_BILLNO = "billno";
    public static final String SDK_FIELD_PRODUCTID = "productid";
    public static final String SDK_MIDAS_API_CALL = "sdk.midas.api.call";
    public static final String SDK_MIDAS_API_RESPONSE = "sdk.midas.api.resp";
    public static final String SDK_NETWORK_CALL_RESPONSE = "sdk.oversea.network.call.response";
    public static final String SDK_OVERSEA_BOKU_BACK = "sdk.oversea.boku.back";
    public static final String SDK_OVERSEA_BOKU_CANCEL = "sdk.oversea.boku.cancel";
    public static final String SDK_OVERSEA_BOKU_SHOW = "sdk.oversea.boku.show";
    public static final String SDK_OVERSEA_CHANNEL_PAYRESULT = "sdk.oversea.channel.payresult";
    public static final String SDK_OVERSEA_CHANNEL_SHOW = "sdk.oversea.channel.show";
    public static final String SDK_OVERSEA_COUNTRY_SELECT = "sdk.oversea.country.select";
    public static final String SDK_OVERSEA_COUNTRY_SHOW = "sdk.oversea.country.show";
    public static final String SDK_OVERSEA_ENTER = "sdk.oversea.enter";
    public static final String SDK_OVERSEA_EXIT = "sdk.oversea.exit";
    public static final String SDK_OVERSEA_GW_CONSUME_RESULT = "sdk.oversea.gw.consume.result";
    public static final String SDK_OVERSEA_GW_REPROVIDE_TIME_CONSUME = "sdk.reprovide.oversea.gw.time.consume";
    public static final String SDK_OVERSEA_GW_REPROVIDE_TIME_CONSUME_20 = "sdk.reprovide.oversea.gw.time.20.consume";
    public static final String SDK_OVERSEA_GW_RESULT = "sdk.oversea.gw.result";
    public static final String SDK_OVERSEA_GW_RESULT_20 = "sdk.oversea.gw.20.result";
    public static final String SDK_OVERSEA_GW_TIME = "sdk.oversea.gw.time";
    public static final String SDK_OVERSEA_GW_TIME_20 = "sdk.oversea.gw.20.time";
    public static final String SDK_OVERSEA_IPDETECT_CONNECT_TIME = "sdk.oversea.ip.detect.ip.time";
    public static final String SDK_OVERSEA_IPDETECT_DNS_RESULT = "sdk.oversea.ip.detect.dns.result";
    public static final String SDK_OVERSEA_IPDETECT_ERROR = "sdk.oversea.ip.detect.error";
    public static final String SDK_OVERSEA_MAIN_BACK = "sdk.oversea.main.back";
    public static final String SDK_OVERSEA_MAIN_SHOW = "sdk.oversea.main.show";
    public static final String SDK_OVERSEA_REPROVIDE_INFO = "sdk.oversea.reprovide.info";
    public static final String SDK_OVERSEA_SYSTEM_LANGUAGE = "sdk.oversea.sys.lang";
    public static final String SDK_RESTORE = "sdk.oversea.restore";
    public static final String SDK_WEBVIEW_END = "sdk.webview.end";
    public static final String SDK_WEBVIEW_ERROR = "sdk.webview.err";
    public static final String SDK_WEBVIEW_LOAD = "sdk.webview.onfinish";
    public static final String TAG = "APDataReportManager";
    private int dataCount;
    private ArrayList<ReportItem> reportData;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class ReportItem {
        public String extend;
        public String format;
        public String times = String.valueOf(System.currentTimeMillis());
    }

    private APDataReportManager() {
        this.reportData = null;
        this.dataCount = 0;
        this.reportData = new ArrayList<>(16);
        loadDataId(APMidasPayNewAPI.singleton().getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class InstanceHolder {
        static APDataReportManager instance = new APDataReportManager();

        InstanceHolder() {
        }
    }

    public static APDataReportManager instance() {
        return InstanceHolder.instance;
    }

    private void loadDataId(Context context) {
        if (context != null) {
            this.dataCount = APSPTools.getInt(context, "dataCount");
        }
    }

    public void saveDataId(Context context) {
        if (context != null) {
            APSPTools.putInt(context, "dataCount", this.dataCount);
        }
    }

    private int getDataId() {
        this.dataCount++;
        if (this.dataCount >= 30000) {
            this.dataCount = 0;
        }
        return this.dataCount;
    }

    public synchronized void insertData(String str, String str2) {
        APLog.d(TAG, "format====" + str);
        APLog.d(TAG, "extend====" + str2);
        if (!TextUtils.isEmpty(str)) {
            ReportItem reportItem = new ReportItem();
            reportItem.format = str;
            if (!TextUtils.isEmpty(str2)) {
                reportItem.extend = str2;
            }
            this.reportData.add(reportItem);
        }
    }

    public int getLogRecord(ArrayList<String> arrayList) {
        ArrayList<ReportItem> arrayList2;
        int i;
        if (arrayList == null || (arrayList2 = this.reportData) == null || arrayList2.isEmpty()) {
            return 0;
        }
        ArrayList arrayList3 = new ArrayList(this.reportData.size());
        arrayList3.addAll(this.reportData);
        this.reportData.clear();
        arrayList.clear();
        int size = arrayList3.size();
        int i2 = size % 12 == 0 ? size / 12 : (size / 12) + 1;
        GlobalData singleton = GlobalData.singleton();
        StringBuilder sb = new StringBuilder();
        APLog.d(getClass().getName(), "sGD.openID=" + singleton.openID);
        String str = "|3=" + singleton.openID + "|7=0|13=" + getDataId() + "|24=" + singleton.offerID + "|26=" + singleton.pf + "|29=" + singleton.getNetToken() + "|31=androidoversea_v" + GlobalData.SDK_VERSION + "|37=" + singleton.sessionID + "|43=" + singleton.sessionType + "&";
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = 0;
            int i5 = 0;
            while (i4 < 12 && (i = (i3 * 12) + i4) < size) {
                ReportItem reportItem = (ReportItem) arrayList3.get(i);
                if (reportItem != null) {
                    sb.append("record");
                    sb.append(i4);
                    sb.append("=");
                    if (!TextUtils.isEmpty(reportItem.extend)) {
                        sb.append("|8=");
                        sb.append(APTools.urlEncode(reportItem.extend + "&currency=" + GlobalData.singleton().getCurrencyInGw(), 3));
                    } else {
                        sb.append("|8=");
                        sb.append(APTools.urlEncode("currency=" + GlobalData.singleton().getCurrencyInGw(), 3));
                    }
                    sb.append("|21=");
                    sb.append(reportItem.format);
                    sb.append("|38=");
                    sb.append(reportItem.times);
                    sb.append(str);
                }
                i4++;
                i5++;
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("num=");
            sb2.append(i5);
            sb2.append("&");
            sb2.append(sb.toString());
            APLog.d(getClass().getName(), "report Content=" + sb.toString());
            arrayList.add(sb2.toString());
            sb.setLength(0);
        }
        return i2;
    }
}
