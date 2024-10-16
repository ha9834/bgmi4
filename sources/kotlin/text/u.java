package kotlin.text;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class u extends t {
    public static final boolean a(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        }
        if (!z) {
            return str.equals(str2);
        }
        return str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return l.a(str, str2, str3, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String a(String str, String str2, String str3, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$replace");
        kotlin.jvm.internal.h.b(str2, "oldValue");
        kotlin.jvm.internal.h.b(str3, "newValue");
        String str4 = str;
        int i = 0;
        int a2 = l.a(str4, str2, 0, z);
        if (a2 < 0) {
            return str;
        }
        int length = str2.length();
        int c = kotlin.d.d.c(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str4, i, a2);
            sb.append(str3);
            i = a2 + length;
            if (a2 >= str.length()) {
                break;
            }
            a2 = l.a(str4, str2, a2 + c, z);
        } while (a2 > 0);
        sb.append((CharSequence) str4, i, str.length());
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.a((Object) sb2, "stringBuilder.append(this, i, length).toString()");
        return sb2;
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return l.b(str, str2, z);
    }

    public static final boolean b(String str, String str2, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$startsWith");
        kotlin.jvm.internal.h.b(str2, "prefix");
        if (!z) {
            return str.startsWith(str2);
        }
        return l.a(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return l.c(str, str2, z);
    }

    public static final boolean c(String str, String str2, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$endsWith");
        kotlin.jvm.internal.h.b(str2, "suffix");
        if (!z) {
            return str.endsWith(str2);
        }
        return l.a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static final boolean a(CharSequence charSequence) {
        boolean z;
        kotlin.jvm.internal.h.b(charSequence, "$this$isBlank");
        if (charSequence.length() != 0) {
            Iterable c = l.c(charSequence);
            if (!(c instanceof Collection) || !((Collection) c).isEmpty()) {
                Iterator it = c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = true;
                        break;
                    }
                    if (!a.a(charSequence.charAt(((kotlin.collections.v) it).b()))) {
                        z = false;
                        break;
                    }
                }
            } else {
                z = true;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(String str, int i, String str2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.h.b(str, "$this$regionMatches");
        kotlin.jvm.internal.h.b(str2, "other");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }
}
