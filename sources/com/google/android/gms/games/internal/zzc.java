package com.google.android.gms.games.internal;

import android.os.Bundle;
import android.util.SparseArray;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzc {
    /* JADX WARN: Removed duplicated region for block: B:102:0x00f7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0029 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0029 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean zza(android.os.Bundle r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.internal.zzc.zza(android.os.Bundle, android.os.Bundle):boolean");
    }

    public static int zza(Bundle bundle) {
        int size;
        if (bundle == null || (size = bundle.size()) == 0) {
            return 0;
        }
        String[] strArr = (String[]) bundle.keySet().toArray(new String[size]);
        Arrays.sort(strArr);
        int i = 1;
        for (String str : strArr) {
            i *= 31;
            Object obj = bundle.get(str);
            if (obj != null) {
                if (obj instanceof Bundle) {
                    i += zza((Bundle) obj);
                } else if (obj instanceof byte[]) {
                    i += Arrays.hashCode((byte[]) obj);
                } else if (obj instanceof char[]) {
                    i += Arrays.hashCode((char[]) obj);
                } else if (obj instanceof short[]) {
                    i += Arrays.hashCode((short[]) obj);
                } else if (obj instanceof float[]) {
                    i += Arrays.hashCode((float[]) obj);
                } else if (obj instanceof CharSequence[]) {
                    i += Arrays.hashCode((CharSequence[]) obj);
                } else if (obj instanceof Object[]) {
                    int i2 = 1;
                    for (Object obj2 : (Object[]) obj) {
                        i2 *= 31;
                        if (obj2 instanceof Bundle) {
                            i2 += zza((Bundle) obj2);
                        } else if (obj2 != null) {
                            i2 += obj2.hashCode();
                        }
                    }
                    i += i2;
                } else if (obj instanceof SparseArray) {
                    SparseArray sparseArray = (SparseArray) obj;
                    int size2 = sparseArray.size();
                    int i3 = 1;
                    for (int i4 = 0; i4 < size2; i4++) {
                        i3 = ((i3 * 31) + sparseArray.keyAt(i4)) * 31;
                        Object valueAt = sparseArray.valueAt(i4);
                        if (valueAt instanceof Bundle) {
                            i3 += zza((Bundle) valueAt);
                        } else if (valueAt != null) {
                            i3 += valueAt.hashCode();
                        }
                    }
                    i += i3;
                } else {
                    i += obj.hashCode();
                }
            }
        }
        return i;
    }
}
