package com.tencent.grobot.lite.model.node;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public class TextInfoNode extends BaseNode {
    public String msg = "";

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 8;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.msg;
    }
}
