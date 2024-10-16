package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum AttributeAction {
    ADD("ADD"),
    PUT("PUT"),
    DELETE("DELETE");

    private static final Map<String, AttributeAction> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("ADD", ADD);
        enumMap.put("PUT", PUT);
        enumMap.put("DELETE", DELETE);
    }

    AttributeAction(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static AttributeAction fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
