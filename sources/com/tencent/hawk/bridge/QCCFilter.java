package com.tencent.hawk.bridge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class QCCFilter {
    private Map<String, List<String>> qccFilterMap;

    public QCCFilter() {
        this.qccFilterMap = null;
        this.qccFilterMap = new HashMap();
    }

    public List<String> getTargetCategoryFilter(String str) {
        if (this.qccFilterMap.containsKey(str)) {
            return this.qccFilterMap.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, List<String>> getFilterMap() {
        return this.qccFilterMap;
    }
}
