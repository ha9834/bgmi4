package com.intlgame.foundation;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class EmptyUtils {
    public static boolean isNonEmpty(String str) {
        return str != null && str.length() > 0;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isEmpty(List list) {
        return list == null || list.isEmpty();
    }

    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }
}
