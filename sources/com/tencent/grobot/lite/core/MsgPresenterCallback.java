package com.tencent.grobot.lite.core;

import com.tencent.grobot.lite.model.local.HotTopicInfo;
import com.tencent.grobot.lite.model.local.NavigationInfo;
import com.tencent.grobot.lite.model.local.RecommendsInfo;
import com.tencent.grobot.lite.model.local.TagInfo;
import com.tencent.grobot.lite.model.node.AnsOptionNode;
import com.tencent.grobot.lite.model.node.BaseNode;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public interface MsgPresenterCallback extends IServiceCallback {
    void onClearRedPointResult(int i, String str);

    void onGetDetailRecommendResult(int i, String str, RecommendsInfo recommendsInfo);

    void onGetHotResult(int i, String str, ArrayList<HotTopicInfo> arrayList);

    void onGetNavigationIndexResult(int i, String str, List<TagInfo> list);

    void onGetNavigationResult(int i, int i2, String str, NavigationInfo navigationInfo);

    void onGetRecommendResult(int i, String str, List<RecommendsInfo> list);

    int onInitLoadedFinished(int i, ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i2, int i3, String str, String str2, JSONObject jSONObject, String str3, boolean z);

    int onLoadedCacheFinished(ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i, int i2, boolean z, boolean z2);

    int onLoadedFinished(int i, ArrayList<BaseNode> arrayList, AnsOptionNode ansOptionNode, int i2, int i3, String str, boolean z);
}
