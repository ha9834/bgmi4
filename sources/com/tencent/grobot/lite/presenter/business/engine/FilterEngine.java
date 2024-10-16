package com.tencent.grobot.lite.presenter.business.engine;

import android.text.TextUtils;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.model.req.FilterReqInfo;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterCode;
import com.tencent.grobot.lite.presenter.business.callback.ActionCallback;
import com.tencent.grobot.lite.presenter.business.callback.CallbackHelper;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class FilterEngine extends BaseEngine<FilterActionCallback> {
    private static final int HAS_SENSITIVE_WORDS = 2;
    private static ConcurrentHashMap<String, Integer> robotTypeMap = new ConcurrentHashMap<>();

    /* loaded from: classes2.dex */
    public interface FilterActionCallback extends ActionCallback {
        void onLoadFinish(int i, int i2, String str, FilterReqInfo filterReqInfo, int i3);
    }

    public void sendJsonRequest(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            FilterReqInfo filterReqInfo = new FilterReqInfo();
            filterReqInfo.text = str;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("text", filterReqInfo.text);
            int sendJsonRequest = sendJsonRequest(filterReqInfo, jSONObject);
            robotTypeMap.put(str, Integer.valueOf(i));
            TLog.d("Presenter.Engine", "sendRequest, seq:" + sendJsonRequest + ",text:" + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    protected void handleJsonSuccess(final int i, JSONObject jSONObject, ReqInfo reqInfo) {
        final FilterReqInfo filterReqInfo = reqInfo instanceof FilterReqInfo ? (FilterReqInfo) reqInfo : null;
        try {
            if (jSONObject != null) {
                if (jSONObject.getInt("dirtyFlag") != 2) {
                    String str = filterReqInfo != null ? filterReqInfo.text : "";
                    final int intValue = robotTypeMap.containsKey(str) ? robotTypeMap.get(str).intValue() : 0;
                    final String str2 = str;
                    final FilterReqInfo filterReqInfo2 = filterReqInfo;
                    notifyDataChanged(new CallbackHelper.Caller<FilterActionCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.FilterEngine.1
                        @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                        public void call(FilterActionCallback filterActionCallback) {
                            filterActionCallback.onLoadFinish(i, 0, str2, filterReqInfo2, intValue);
                        }
                    });
                    robotTypeMap.remove(str);
                    return;
                }
                notifyDataChanged(new CallbackHelper.Caller<FilterActionCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.FilterEngine.2
                    @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
                    public void call(FilterActionCallback filterActionCallback) {
                        filterActionCallback.onLoadFinish(i, PresenterCode.Code_Engine_Filter_Sensitive, "", filterReqInfo, 0);
                    }
                });
                return;
            }
            onNoSensentive(filterReqInfo, i);
        } catch (Exception e) {
            e.printStackTrace();
            onNoSensentive(filterReqInfo, i);
        }
    }

    private void onNoSensentive(final FilterReqInfo filterReqInfo, final int i) {
        String str = filterReqInfo != null ? filterReqInfo.text : "";
        final int intValue = robotTypeMap.containsKey(str) ? robotTypeMap.get(str).intValue() : 0;
        final String str2 = str;
        notifyDataChanged(new CallbackHelper.Caller<FilterActionCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.FilterEngine.3
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(FilterActionCallback filterActionCallback) {
                filterActionCallback.onLoadFinish(i, 0, str2, filterReqInfo, intValue);
            }
        });
        robotTypeMap.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.grobot.lite.presenter.business.engine.BaseEngine
    public void handleJsonFail(final int i, int i2, String str, JSONObject jSONObject, final ReqInfo reqInfo) {
        TLog.d("Presenter.Engine", "handleFail seq:" + i);
        notifyDataChanged(new CallbackHelper.Caller<FilterActionCallback>() { // from class: com.tencent.grobot.lite.presenter.business.engine.FilterEngine.4
            @Override // com.tencent.grobot.lite.presenter.business.callback.CallbackHelper.Caller
            public void call(FilterActionCallback filterActionCallback) {
                ReqInfo reqInfo2 = reqInfo;
                filterActionCallback.onLoadFinish(i, PresenterCode.Code_Engine_Filter_Error, "", reqInfo2 instanceof FilterReqInfo ? (FilterReqInfo) reqInfo2 : null, 0);
            }
        });
    }
}
