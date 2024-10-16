package com.helpshift.support;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class Metadata {
    private String[] issueTags;
    private Map<String, Object> metadata;

    public Metadata(Map<String, Object> map) {
        this(map, null);
    }

    public Metadata(Map<String, Object> map, String[] strArr) {
        if (map != null) {
            this.metadata = map;
        }
        if (strArr == null || strArr.length <= 0) {
            return;
        }
        this.issueTags = strArr;
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.metadata;
        if (map != null) {
            hashMap.putAll(map);
        }
        String[] strArr = this.issueTags;
        if (strArr != null) {
            hashMap.put(Support.TagsKey, strArr);
        }
        return hashMap;
    }
}
