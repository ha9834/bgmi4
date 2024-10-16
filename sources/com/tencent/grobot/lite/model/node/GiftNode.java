package com.tencent.grobot.lite.model.node;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public class GiftNode extends BaseNode {
    public boolean isReceived = false;
    public String title = "";
    public String groupId = "";
    public String amsId = "";
    public String name = "";
    public String desc = "";
    public String imageUrl = "";
    public String answerId = "";

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 51;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.title;
    }
}
