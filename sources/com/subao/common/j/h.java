package com.subao.common.j;

import com.subao.common.j.l;

/* loaded from: classes2.dex */
public class h {
    public static l.a a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return l.a.MOBILE_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return l.a.MOBILE_3G;
            case 13:
                return l.a.MOBILE_4G;
            default:
                if (i >= 19) {
                    return l.a.MOBILE_4G;
                }
                return l.a.UNKNOWN;
        }
    }
}
