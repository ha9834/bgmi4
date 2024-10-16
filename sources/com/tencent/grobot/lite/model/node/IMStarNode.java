package com.tencent.grobot.lite.model.node;

import com.tencent.grobot.lite.model.local.EvaluateInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public class IMStarNode extends BaseNode {
    public String title = "";
    public String sessionId = "";
    public int rating = 0;
    public int position = 0;
    public EvaluateInfo evaluateInfo = null;

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 43;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.sessionId;
    }
}