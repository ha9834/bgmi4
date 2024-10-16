package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ConditionalOperator {
    AND("AND"),
    OR("OR");

    private static final Map<String, ConditionalOperator> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("AND", AND);
        enumMap.put("OR", OR);
    }

    ConditionalOperator(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ConditionalOperator fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
