package com.ihoc.mgpa.n;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static DecimalFormat f5665a = new DecimalFormat(".00");

    public static String a(ArrayList<String> arrayList, String str) {
        if (arrayList == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (z) {
                sb.append(str);
            } else {
                z = true;
            }
            sb.append(next);
        }
        return sb.toString();
    }

    public static String a(float[] fArr, String str) {
        if (fArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (float f : fArr) {
            if (z) {
                sb.append(str);
            } else {
                z = true;
            }
            sb.append(f5665a.format(f));
        }
        return sb.toString();
    }

    public static boolean a(String[] strArr, String str) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String b(ArrayList<Integer> arrayList, String str) {
        if (arrayList == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        Iterator<Integer> it = arrayList.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (z) {
                sb.append(str);
            } else {
                z = true;
            }
            sb.append(next);
        }
        return sb.toString();
    }
}
