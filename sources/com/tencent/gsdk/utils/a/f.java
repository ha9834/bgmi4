package com.tencent.gsdk.utils.a;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class f {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f6238a = {1, 2};
    private static final SparseArray<d> b = new SparseArray<>(2);

    static {
        b.put(1, new b());
        b.put(2, new g());
    }

    public static List<d> a(int i) {
        ArrayList arrayList = null;
        for (int i2 : f6238a) {
            if ((i2 & i) != 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(b.get(i2));
            }
        }
        return arrayList != null ? arrayList : Collections.emptyList();
    }
}
