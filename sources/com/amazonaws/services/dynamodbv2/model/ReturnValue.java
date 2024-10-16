package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ReturnValue {
    NONE("NONE"),
    ALL_OLD("ALL_OLD"),
    UPDATED_OLD("UPDATED_OLD"),
    ALL_NEW("ALL_NEW"),
    UPDATED_NEW("UPDATED_NEW");

    private static final Map<String, ReturnValue> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("NONE", NONE);
        enumMap.put("ALL_OLD", ALL_OLD);
        enumMap.put("UPDATED_OLD", UPDATED_OLD);
        enumMap.put("ALL_NEW", ALL_NEW);
        enumMap.put("UPDATED_NEW", UPDATED_NEW);
    }

    ReturnValue(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ReturnValue fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
