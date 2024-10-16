package com.tencent.grobot.lite.model.node;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.tencent.grobot.lite.model.local.OptionItemInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.List;

/* loaded from: classes2.dex */
public class AnsOptionNode extends BaseNode {
    public List<EvaluateItemInfo> evaluateItemInfos;
    public List<OptionItemInfo> optionItems;
    public String answerKey = "";
    public boolean needReport = false;

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 22;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.optionItems.size();
    }
}
