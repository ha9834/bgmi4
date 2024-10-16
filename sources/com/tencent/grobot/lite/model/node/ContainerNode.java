package com.tencent.grobot.lite.model.node;

import com.tencent.grobot.lite.model.local.ContainerInfo;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ContainerNode extends BaseNode {
    public ArrayList<ContainerInfo> nodeList = new ArrayList<>();

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public int getType() {
        return 6;
    }

    @Override // com.tencent.grobot.lite.model.node.BaseNode
    public String getStoreKey() {
        return "item_type_" + getType() + "_size_" + this.nodeList.size();
    }
}
