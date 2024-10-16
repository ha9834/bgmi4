package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ReturnConsumedCapacity {
    INDEXES("INDEXES"),
    TOTAL("TOTAL"),
    NONE("NONE");

    private static final Map<String, ReturnConsumedCapacity> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("INDEXES", INDEXES);
        enumMap.put("TOTAL", TOTAL);
        enumMap.put("NONE", NONE);
    }

    ReturnConsumedCapacity(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ReturnConsumedCapacity fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
