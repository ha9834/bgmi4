package com.helpshift.support;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* loaded from: classes2.dex */
public class FaqTagFilter implements Serializable {
    private static final long serialVersionUID = 7526472295622776147L;
    private String operator;
    private String[] tags;

    public FaqTagFilter(String str, String[] strArr) {
        this.operator = Operator.UNDEFINED;
        if (Operator.valueSet.contains(str)) {
            this.operator = str;
        }
        this.tags = strArr;
    }

    public String getOperator() {
        return this.operator;
    }

    public String[] getTags() {
        return this.tags;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> toMap() {
        String[] strArr;
        if (this.operator == null || !Operator.valueSet.contains(this.operator) || (strArr = this.tags) == null || strArr.length <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("operator", this.operator);
        hashMap.put("tags", this.tags);
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj instanceof FaqTagFilter) {
            FaqTagFilter faqTagFilter = (FaqTagFilter) obj;
            if (this.operator.equals(faqTagFilter.operator) && Arrays.equals(this.tags, faqTagFilter.tags)) {
                return true;
            }
        }
        return false;
    }

    /* loaded from: classes2.dex */
    public static class Operator {
        public static final String AND = "and";
        public static final String NOT = "not";
        public static final String OR = "or";
        public static final String UNDEFINED = "undefined";
        public static final HashSet<String> valueSet = getSupportedValueSet();

        private static HashSet<String> getSupportedValueSet() {
            HashSet<String> hashSet = new HashSet<>();
            hashSet.add(AND);
            hashSet.add(OR);
            hashSet.add(NOT);
            return hashSet;
        }
    }
}
