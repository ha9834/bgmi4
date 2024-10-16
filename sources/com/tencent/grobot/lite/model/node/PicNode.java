package com.tencent.grobot.lite.model.node;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public class PicNode extends BaseNode {
    public String name;
    public String resourceId;
    public String thumbImageUrl;
    public String url;

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 2;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.url;
    }
}
