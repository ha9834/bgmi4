package kotlin.text;

import com.google.android.gms.nearby.messages.BleSignal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class t extends s {
    public static final Integer a(String str) {
        kotlin.jvm.internal.h.b(str, "$this$toIntOrNull");
        return l.a(str, 10);
    }

    public static final Integer a(String str, int i) {
        boolean z;
        int i2;
        kotlin.jvm.internal.h.b(str, "$this$toIntOrNull");
        a.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (kotlin.jvm.internal.h.a(charAt, 48) >= 0) {
            z = false;
            i5 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                i4 = BleSignal.UNKNOWN_TX_POWER;
                z = true;
            } else {
                if (charAt != '+') {
                    return null;
                }
                z = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int a2 = a.a(str.charAt(i5), i);
            if (a2 < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / i))) || (i2 = i3 * i) < i4 + a2) {
                return null;
            }
            i3 = i2 - a2;
            i5++;
        }
        return z ? Integer.valueOf(i3) : Integer.valueOf(-i3);
    }

    public static final Long b(String str) {
        kotlin.jvm.internal.h.b(str, "$this$toLongOrNull");
        return l.b(str, 10);
    }

    public static final Long b(String str, int i) {
        kotlin.jvm.internal.h.b(str, "$this$toLongOrNull");
        a.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        boolean z = false;
        char charAt = str.charAt(0);
        long j = -9223372036854775807L;
        int i2 = 1;
        if (kotlin.jvm.internal.h.a(charAt, 48) >= 0) {
            i2 = 0;
        } else {
            if (length == 1) {
                return null;
            }
            if (charAt == '-') {
                j = Long.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            }
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int a2 = a.a(str.charAt(i2), i);
            if (a2 < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 != j2) {
                    return null;
                }
                j4 = j / i;
                if (j3 < j4) {
                    return null;
                }
            }
            long j5 = j3 * i;
            long j6 = a2;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }
}
