package com.tencent.grobot.lite.presenter.business.callback;

import com.tencent.grobot.lite.model.local.HotTopicInfo;
import com.tencent.grobot.lite.model.req.HotReqInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public interface HotCallback extends ActionCallback {
    void onGetHotResult(int i, int i2, String str, ArrayList<HotTopicInfo> arrayList, HotReqInfo hotReqInfo);
}
