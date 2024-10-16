package com.tencent.grobot.lite.presenter.business.engine;

import com.tencent.grobot.lite.GRobotApplication;
import com.tencent.grobot.lite.common.TLog;
import com.tencent.grobot.lite.core.MsgPresenterCallback;
import com.tencent.grobot.lite.model.local.HotTopicInfo;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.model.node.AnsOptionNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.req.ReqInfo;
import com.tencent.grobot.lite.presenter.PresenterService;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final class InvalidCertDelegate implements MsgPresenterCallback {
    private static final String TAG = "InvalidCertDelegate";
    private final BaseEngine engine;
    ReqInfo reqInfo;
    JSONObject reqJson;
    private int retryCount = 0;

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onClearRedPointResult(int i, String str) {
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetDetailRecommendResult(int i, String str, RecommendsInfo recommendsInfo) {
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetHotResult(int i, String str, ArrayList<HotTopicInfo> arrayList) {
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetNavigationIndexResult(int i, String str, List<TagInfo> list) {
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetNavigationResult(int i, int i2, String str, NavigationInfo navigationInfo) {
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public void onGetRecommendResult(int i, String str, List<RecommendsInfo> list) {
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public int onLoadedCacheFinished(ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i, int i2, boolean z, boolean z2) {
        return 0;
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public int onLoadedFinished(int i, ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i2, int i3, String str, boolean z) {
        return 0;
    }

    @Override // com.tencent.grobot.lite.core.IServiceCallback
    public void onResult(int i, String str, Object... objArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InvalidCertDelegate(BaseEngine baseEngine) {
        this.engine = baseEngine;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void handle(ReqInfo reqInfo, JSONObject jSONObject) {
        PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
        if (presenterService != null && this.retryCount < 3) {
            TLog.d(TAG, "InvalidCertDelegate, try");
            presenterService.initMessage(false, false, false, this);
            this.retryCount++;
            this.reqInfo = reqInfo;
            this.reqJson = jSONObject;
            return;
        }
        this.engine.handleJsonFail(-1, -1000, null, null, reqInfo);
    }

    @Override // com.tencent.grobot.lite.core.MsgPresenterCallback
    public int onInitLoadedFinished(int i, ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i2, int i3, String str, String str2, JSONObject jSONObject, String str3, boolean z) {
        TLog.d(TAG, "onInitLoadedFinished, code=" + i);
        if (i == 0) {
            PresenterService presenterService = (PresenterService) GRobotApplication.getInstance().getService(PresenterService.class);
            if (presenterService != null) {
                this.reqInfo.certificate = presenterService.getCertificate();
                if (!this.reqJson.isNull("certificate")) {
                    try {
                        this.reqJson.put("certificate", this.reqInfo.certificate);
                    } catch (JSONException e) {
                        TLog.d(TAG, "change reqJson cert failed, ex=" + e);
                    }
                }
            }
            this.engine.sendJsonRequest(this.reqInfo, this.reqJson);
            BaseEngine.sReInit = false;
        } else {
            this.engine.handleJsonFail(-1, -1000, null, null, this.reqInfo);
        }
        return 0;
    }
}
