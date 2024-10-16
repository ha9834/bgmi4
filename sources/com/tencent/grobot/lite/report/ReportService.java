package com.tencent.grobot.lite.report;

import android.os.Handler;
import android.os.Looper;
import com.adjust.sdk.AdjustConfig;
import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.core.IService;
import com.tencent.grobot.lite.core.LogicPresenterCallback;
import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.req.CommonReportReqInfo;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.model.req.EventReportInfo;
import com.tencent.grobot.lite.model.req.GetPackageReqInfo;
import com.tencent.grobot.lite.presenter.PresenterService;
import com.tencent.midas.oversea.comm.MConstants;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class ReportService implements IService {
    private static final String TAG = "ReportService";
    private ArrayList<JSONObject> cacheEvents = new ArrayList<>();
    private long lasReportTime = 0;
    private Handler mainHandler = new Handler(Looper.getMainLooper());
    private Runnable reportRunnable = new Runnable() { // from class: com.tencent.grobot.lite.report.ReportService.1
        @Override // java.lang.Runnable
        public void run() {
            ReportService.this.mainHandler.removeCallbacks(ReportService.this.reportRunnable);
            PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
            if (presenterService != null && ReportService.this.cacheEvents.size() > 0) {
                TLog.d(ReportService.class.getName(), "report : size = " + ReportService.this.cacheEvents.size());
                ArrayList<String> arrayList = new ArrayList<>();
                Iterator it = ReportService.this.cacheEvents.iterator();
                while (it.hasNext()) {
                    arrayList.add(((JSONObject) it.next()).toString());
                }
                if (arrayList.size() > 0) {
                    ReportService.this.cacheEvents.clear();
                    presenterService.reportCommon(arrayList, ReportService.this.logicPresenterCallback);
                }
            }
            ReportService.this.lasReportTime = System.currentTimeMillis();
        }
    };
    private LogicPresenterCallback logicPresenterCallback = new LogicPresenterCallback() { // from class: com.tencent.grobot.lite.report.ReportService.2
        @Override // com.tencent.grobot.lite.core.LogicPresenterCallback
        public void onEvaluateResult(int i, String str, EvaluateReqInfo evaluateReqInfo) {
        }

        @Override // com.tencent.grobot.lite.core.LogicPresenterCallback
        public void onGetPackageResult(int i, String str, AnswerInfo answerInfo, GetPackageReqInfo getPackageReqInfo) {
        }

        @Override // com.tencent.grobot.lite.core.IServiceCallback
        public void onResult(int i, String str, Object... objArr) {
        }

        @Override // com.tencent.grobot.lite.core.LogicPresenterCallback
        public void onReportEventResult(int i, String str, EventReportInfo eventReportInfo) {
            TLog.d(ReportService.class.getName(), "onReportEventResult errorCode = " + i + " errMsg = " + str);
        }

        @Override // com.tencent.grobot.lite.core.LogicPresenterCallback
        public void onCommonReportResult(int i, String str, CommonReportReqInfo commonReportReqInfo) {
            TLog.d(ReportService.class.getName(), "onCommonReportResult errorCode = " + i + " errMsg = " + str);
        }
    };

    public ReportService(GRobotApplication gRobotApplication) {
    }

    public void report(JSONObject jSONObject, boolean z) {
        JSONObject buildReportObject = buildReportObject(jSONObject);
        if (buildReportObject != null) {
            this.cacheEvents.add(buildReportObject);
        }
        if (z) {
            this.mainHandler.post(this.reportRunnable);
        } else if (System.currentTimeMillis() - this.lasReportTime > 5000) {
            this.mainHandler.post(this.reportRunnable);
        } else {
            this.mainHandler.postDelayed(this.reportRunnable, 5000L);
        }
    }

    public void reportEvent(String str, String str2, String str3) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null) {
            presenterService.reportEvent(str, str2, str3, this.logicPresenterCallback);
        }
    }

    private JSONObject buildReportObject(JSONObject jSONObject) {
        String str;
        if (jSONObject == null) {
            return null;
        }
        try {
        } catch (JSONException e) {
            TLog.d(TAG, "Add env failed, " + e);
        }
        if (GRobotApplication.getInstance().getServerKey() != 1 && !TLog.isServerDebug()) {
            str = AdjustConfig.ENVIRONMENT_PRODUCTION;
            jSONObject.put("env", str);
            return jSONObject;
        }
        str = MConstants.TestEnv;
        jSONObject.put("env", str);
        return jSONObject;
    }

    @Override // com.tencent.grobot.lite.core.IService
    public void onDestroy() {
        this.cacheEvents.clear();
    }
}
