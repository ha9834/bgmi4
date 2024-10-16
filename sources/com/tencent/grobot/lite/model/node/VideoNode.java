package com.tencent.grobot.lite.model.node;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class VideoNode extends BaseNode {
    public int nodeType = 3;
    public ArrayList<VideoItem> videoItemList = new ArrayList<>();

    public void setNodeType(int i) {
        this.nodeType = i;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return this.nodeType;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        ArrayList<VideoItem> arrayList = this.videoItemList;
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + (arrayList == null ? 0 : arrayList.size());
    }
}
