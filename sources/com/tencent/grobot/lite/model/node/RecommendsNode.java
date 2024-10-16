package com.tencent.grobot.lite.model.node;

import com.twitter.sdk.android.core.internal.scribe.EventsFilesManager;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class RecommendsNode extends BaseNode {
    public ArrayList<Object> items = new ArrayList<>();

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 13;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        ArrayList<Object> arrayList = this.items;
        return "item_" + getType() + EventsFilesManager.ROLL_OVER_FILE_NAME_SEPARATOR + (arrayList == null ? 0 : arrayList.size());
    }
}
