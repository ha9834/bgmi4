package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum StreamViewType {
    NEW_IMAGE("NEW_IMAGE"),
    OLD_IMAGE("OLD_IMAGE"),
    NEW_AND_OLD_IMAGES("NEW_AND_OLD_IMAGES"),
    KEYS_ONLY("KEYS_ONLY");

    private static final Map<String, StreamViewType> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("NEW_IMAGE", NEW_IMAGE);
        enumMap.put("OLD_IMAGE", OLD_IMAGE);
        enumMap.put("NEW_AND_OLD_IMAGES", NEW_AND_OLD_IMAGES);
        enumMap.put("KEYS_ONLY", KEYS_ONLY);
    }

    StreamViewType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static StreamViewType fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
