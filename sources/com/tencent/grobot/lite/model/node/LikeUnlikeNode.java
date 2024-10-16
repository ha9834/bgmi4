package com.tencent.grobot.lite.model.node;

import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public class LikeUnlikeNode extends BaseNode {
    public EvaluateInfo evaluateInfo;

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 23;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.evaluateInfo.evaluateId;
    }
}
