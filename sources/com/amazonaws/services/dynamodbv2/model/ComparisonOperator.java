package com.amazonaws.services.dynamodbv2.model;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public enum ComparisonOperator {
    EQ("EQ"),
    NE("NE"),
    IN("IN"),
    LE("LE"),
    LT("LT"),
    GE("GE"),
    GT("GT"),
    BETWEEN("BETWEEN"),
    NOT_NULL("NOT_NULL"),
    NULL("NULL"),
    CONTAINS("CONTAINS"),
    NOT_CONTAINS("NOT_CONTAINS"),
    BEGINS_WITH("BEGINS_WITH");

    private static final Map<String, ComparisonOperator> enumMap = new HashMap();
    private String value;

    static {
        enumMap.put("EQ", EQ);
        enumMap.put("NE", NE);
        enumMap.put("IN", IN);
        enumMap.put("LE", LE);
        enumMap.put("LT", LT);
        enumMap.put("GE", GE);
        enumMap.put("GT", GT);
        enumMap.put("BETWEEN", BETWEEN);
        enumMap.put("NOT_NULL", NOT_NULL);
        enumMap.put("NULL", NULL);
        enumMap.put("CONTAINS", CONTAINS);
        enumMap.put("NOT_CONTAINS", NOT_CONTAINS);
        enumMap.put("BEGINS_WITH", BEGINS_WITH);
    }

    ComparisonOperator(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static ComparisonOperator fromValue(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty!");
        }
        if (enumMap.containsKey(str)) {
            return enumMap.get(str);
        }
        throw new IllegalArgumentException("Cannot create enum from " + str + " value!");
    }
}
