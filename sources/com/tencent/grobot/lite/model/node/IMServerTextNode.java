package com.tencent.grobot.lite.model.node;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public class IMServerTextNode extends BaseNode {
    public String agentName = "";
    public String msg = "";

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 41;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.agentName;
    }
}
