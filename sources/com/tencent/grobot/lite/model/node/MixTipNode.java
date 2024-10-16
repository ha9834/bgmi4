package com.tencent.grobot.lite.model.node;

import com.tencent.grobot.lite.model.local.MixTipInfo;
import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;

/* loaded from: classes2.dex */
public final class MixTipNode extends BaseNode {
    public MixTipInfo info;

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 4;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.info.title + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + this.info.format;
    }
}
