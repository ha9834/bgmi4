package com.tencent.grobot.lite.model.node;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public class FeedbackNode extends BaseNode {
    public EvaluateItemInfo itemInfo;
    public String id = "";
    public String desc = "";
    public String answerKey = "";
    public int position = 0;

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 24;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.id;
    }
}
