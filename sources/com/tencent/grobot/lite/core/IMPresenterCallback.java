package com.tencent.grobot.lite.core;

import com.tencent.grobot.lite.model.local.IMMsgInfo;
import com.tencent.grobot.lite.model.node.BaseNode;
import java.util.ArrayList;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface IMPresenterCallback extends IServiceCallback {
    void onCloseIMResult(int i, int i2, String str, JSONObject jSONObject);

    void onCreateIMResult(int i, int i2, String str, JSONObject jSONObject);

    void onPullIMMsgResult(int i, ArrayList<IMMsgInfo> arrayList);

    void onPushIMMsgResult(int i, ArrayList<BaseNode> arrayList, int i2, int i3);
}
