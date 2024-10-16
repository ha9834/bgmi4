package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum Select {
    ALL_ATTRIBUTES("ALL_ATTRIBUTES"),
    ALL_PROJECTED_ATTRIBUTES("ALL_PROJECTED_ATTRIBUTES"),
    SPECIFIC_ATTRIBUTES("SPECIFIC_ATTRIBUTES"),
    COUNT("COUNT");

    private static final Map<String, Select> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("ALL_ATTRIBUTES", ALL_ATTRIBUTES);
        enumMap.put("ALL_PROJECTED_ATTRIBUTES", ALL_PROJECTED_ATTRIBUTES);
        enumMap.put("SPECIFIC_ATTRIBUTES", SPECIFIC_ATTRIBUTES);
        enumMap.put("COUNT", COUNT);
    }

    Select(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static Select fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
