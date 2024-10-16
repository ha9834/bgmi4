package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ProjectionType {
    ALL("ALL"),
    KEYS_ONLY("KEYS_ONLY"),
    INCLUDE("INCLUDE");

    private static final Map<String, ProjectionType> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("ALL", ALL);
        enumMap.put("KEYS_ONLY", KEYS_ONLY);
        enumMap.put("INCLUDE", INCLUDE);
    }

    ProjectionType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ProjectionType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
