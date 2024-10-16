package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum TableStatus {
    CREATING("CREATING"),
    UPDATING("UPDATING"),
    DELETING("DELETING"),
    ACTIVE("ACTIVE");

    private static final Map<String, TableStatus> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("CREATING", CREATING);
        enumMap.put("UPDATING", UPDATING);
        enumMap.put("DELETING", DELETING);
        enumMap.put("ACTIVE", ACTIVE);
    }

    TableStatus(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static TableStatus fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
