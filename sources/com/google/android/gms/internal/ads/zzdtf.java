package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzdtf {
    private static int b(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static <T> List<T> zzhk(int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> HashSet<T> a(int i) {
        return new HashSet<>(b(i));
    }

    public static <K, V> LinkedHashMap<K, V> zzhm(int i) {
        return new LinkedHashMap<>(b(i));
    }
}
