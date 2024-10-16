package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ReturnItemCollectionMetrics {
    SIZE("SIZE"),
    NONE("NONE");

    private static final Map<String, ReturnItemCollectionMetrics> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("SIZE", SIZE);
        enumMap.put("NONE", NONE);
    }

    ReturnItemCollectionMetrics(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ReturnItemCollectionMetrics fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
