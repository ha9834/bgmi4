package com.tencent.grobot.lite.presenter.business;

import com.tencent.grobot.lite.core.LogicPresenterCallback;
import com.tencent.grobot.lite.model.local.AnswerInfo;
import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.model.req.EventReportInfo;
import com.tencent.grobot.lite.model.req.GetPackageReqInfo;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import com.tencent.grobot.lite.presenter.business.callback.LogicCallback;
import com.tencent.grobot.lite.presenter.business.callback.ServiceCallbackHelper;
import com.tencent.grobot.lite.presenter.business.engine.LogicEngine;
import com.tencent.grobot.lite.presenter.transport.json.JsonReqSender;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class LogicCenter {
    private ServiceCallbackHelper<LogicPresenterCallback> mCallbacks = new ServiceCallbackHelper<>();
    private LogicCallback logicCallback = new LogicCallback() { // from class: com.tencent.grobot.lite.presenter.business.LogicCenter.1
        @Override // com.tencent.grobot.lite.presenter.business.callback.LogicCallback
        public void onAddEvaluate(int i, final int i2, final String str, JSONObject jSONObject, final EvaluateReqInfo evaluateReqInfo) {
            LogicCenter.this.mCallbacks.broadcast(new CallbackHelper.Caller<LogicPresenterCallback>() { // from class: com.tencent.grobot.lite.presenter.business.LogicCenter.1.1
                @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                public void call(LogicPresenterCallback logicPresenterCallback) {
                    logicPresenterCallback.onEvaluateResult(i2, str, evaluateReqInfo);
                }
            });
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.LogicCallback
        public void onReportEvent(int i, final int i2, final String str, final EventReportInfo eventReportInfo) {
            LogicCenter.this.mCallbacks.broadcast(new CallbackHelper.Caller<LogicPresenterCallback>() { // from class: com.tencent.grobot.lite.presenter.business.LogicCenter.1.2
                @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                public void call(LogicPresenterCallback logicPresenterCallback) {
                    logicPresenterCallback.onReportEventResult(i2, str, eventReportInfo);
                }
            });
        }

        @Override // com.tencent.grobot.lite.presenter.business.callback.LogicCallback
        public void onGetPackage(int i, final int i2, final String str, final AnswerInfo answerInfo, final GetPackageReqInfo getPackageReqInfo) {
            LogicCenter.this.mCallbacks.broadcast(new CallbackHelper.Caller<LogicPresenterCallback>() { // from class: com.tencent.grobot.lite.presenter.business.LogicCenter.1.3
                @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                public void call(LogicPresenterCallback logicPresenterCallback) {
                    logicPresenterCallback.onGetPackageResult(i2, str, answerInfo, getPackageReqInfo);
                }
            });
        }
    };
    private LogicEngine logicEngine = new LogicEngine();

    public LogicCenter(JsonReqSender jsonReqSender) {
        this.logicEngine.register(this.logicCallback, jsonReqSender);
    }

    public void onDestory() {
        this.logicEngine.unregister(this.logicCallback);
    }

    public int addEvaluate(String str, int i, EvaluateItemInfo evaluateItemInfo, boolean z, LogicPresenterCallback logicPresenterCallback) {
        this.mCallbacks.register(logicPresenterCallback);
        return this.logicEngine.addEvaluate(str, i, evaluateItemInfo, z);
    }

    public int reportEvent(String str, String str2, String str3, String str4, LogicPresenterCallback logicPresenterCallback) {
        this.mCallbacks.register(logicPresenterCallback);
        return this.logicEngine.reportEvent(str, str2, str3, str4);
    }

    public int reportCommon(String str, ArrayList<String> arrayList, LogicPresenterCallback logicPresenterCallback) {
        this.mCallbacks.register(logicPresenterCallback);
        return this.logicEngine.reportCommon(str, arrayList);
    }

    public int getGiftPackage(String str, String str2, String str3, String str4, String str5, LogicPresenterCallback logicPresenterCallback) {
        this.mCallbacks.register(logicPresenterCallback);
        return this.logicEngine.getGiftPackage(str, str2, str3, str4, str5);
    }
}
