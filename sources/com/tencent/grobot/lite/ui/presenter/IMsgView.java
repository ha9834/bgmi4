package com.tencent.grobot.lite.ui.presenter;

import com.tencent.grobot.lite.model.node.AnsOptionNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import com.tencent.grobot.lite.model.req.EvaluateReqInfo;
import com.tencent.grobot.lite.ui.model.HotInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public interface IMsgView {
    int getLastPosition();

    void onEvaluateResult(boolean z, EvaluateReqInfo evaluateReqInfo);

    void onGetHostSucc(ArrayList<HotInfo> arrayList);

    void onGetPackageResult(int i, String str, String str2, String str3);

    void onInitFinish(boolean z);

    void onLoadCacheFinish(boolean z, boolean z2, ArrayList<BaseNode> arrayList, int i, AnsOptionNode ansOptionNode, int i2, int i3, boolean z3);

    void onLoadMsgFinish(boolean z, boolean z2, int i, ArrayList<BaseNode> arrayList, int i2, AnsOptionNode ansOptionNode, int i3, int i4, boolean z3, boolean z4);

    void onPureInitFinish(boolean z);

    void onSendRobotMsg();
}
