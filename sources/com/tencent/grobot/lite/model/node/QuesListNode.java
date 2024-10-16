package com.tencent.grobot.lite.model.node;

import com.tencent.grobot.lite.model.local.HotTextItemInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class QuesListNode extends BaseNode {
    public List<HotTextItemInfo> hotQuesItems = new ArrayList();

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 7;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.hotQuesItems.size();
    }
}
