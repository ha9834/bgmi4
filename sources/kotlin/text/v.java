package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes3.dex */
public class v extends u {
    public static final kotlin.d.c c(CharSequence charSequence) {
        kotlin.jvm.internal.h.b(charSequence, "$this$indices");
        return new kotlin.d.c(0, charSequence.length() - 1);
    }

    public static final int d(CharSequence charSequence) {
        kotlin.jvm.internal.h.b(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }

    public static final String a(CharSequence charSequence, kotlin.d.c cVar) {
        kotlin.jvm.internal.h.b(charSequence, "$this$substring");
        kotlin.jvm.internal.h.b(cVar, "range");
        return charSequence.subSequence(cVar.f().intValue(), cVar.g().intValue() + 1).toString();
    }

    public static /* synthetic */ String a(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return l.a(str, c, str2);
    }

    public static final String a(String str, char c, String str2) {
        kotlin.jvm.internal.h.b(str, "$this$substringBefore");
        kotlin.jvm.internal.h.b(str2, "missingDelimiterValue");
        int a2 = l.a((CharSequence) str, c, 0, false, 6, (Object) null);
        if (a2 == -1) {
            return str2;
        }
        String substring = str.substring(0, a2);
        kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String a(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return l.a(str, str2, str3);
    }

    public static final String a(String str, String str2, String str3) {
        kotlin.jvm.internal.h.b(str, "$this$substringBefore");
        kotlin.jvm.internal.h.b(str2, "delimiter");
        kotlin.jvm.internal.h.b(str3, "missingDelimiterValue");
        int a2 = l.a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (a2 == -1) {
            return str3;
        }
        String substring = str.substring(0, a2);
        kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String b(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return l.b(str, c, str2);
    }

    public static final String b(String str, char c, String str2) {
        kotlin.jvm.internal.h.b(str, "$this$substringAfter");
        kotlin.jvm.internal.h.b(str2, "missingDelimiterValue");
        int a2 = l.a((CharSequence) str, c, 0, false, 6, (Object) null);
        if (a2 == -1) {
            return str2;
        }
        String substring = str.substring(a2 + 1, str.length());
        kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String b(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return l.b(str, str2, str3);
    }

    public static final String b(String str, String str2, String str3) {
        kotlin.jvm.internal.h.b(str, "$this$substringAfter");
        kotlin.jvm.internal.h.b(str2, "delimiter");
        kotlin.jvm.internal.h.b(str3, "missingDelimiterValue");
        int a2 = l.a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (a2 == -1) {
            return str3;
        }
        String substring = str.substring(a2 + str2.length(), str.length());
        kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String c(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return l.c(str, c, str2);
    }

    public static final String c(String str, char c, String str2) {
        kotlin.jvm.internal.h.b(str, "$this$substringAfterLast");
        kotlin.jvm.internal.h.b(str2, "missingDelimiterValue");
        int b = l.b((CharSequence) str, c, 0, false, 6, (Object) null);
        if (b == -1) {
            return str2;
        }
        String substring = str.substring(b + 1, str.length());
        kotlin.jvm.internal.h.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$regionMatchesImpl");
        kotlin.jvm.internal.h.b(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!a.a(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        boolean z2;
        kotlin.jvm.internal.h.b(charSequence, "$this$indexOfAny");
        kotlin.jvm.internal.h.b(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(kotlin.collections.d.a(cArr), i);
        }
        int c = kotlin.d.d.c(i, 0);
        int d = l.d(charSequence);
        if (c > d) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(c);
            int length = cArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z2 = false;
                    break;
                }
                if (a.a(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return c;
            }
            if (c == d) {
                return -1;
            }
            c++;
        }
    }

    public static final int b(CharSequence charSequence, char[] cArr, int i, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$lastIndexOfAny");
        kotlin.jvm.internal.h.b(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(kotlin.collections.d.a(cArr), i);
        }
        for (int d = kotlin.d.d.d(i, l.d(charSequence)); d >= 0; d--) {
            char charAt = charSequence.charAt(d);
            int length = cArr.length;
            boolean z2 = false;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (a.a(cArr[i2], charAt, z)) {
                    z2 = true;
                    break;
                }
                i2++;
            }
            if (z2) {
                return d;
            }
        }
        return -1;
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        return a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        kotlin.d.c a2;
        if (!z2) {
            a2 = new kotlin.d.c(kotlin.d.d.c(i, 0), kotlin.d.d.d(i2, charSequence.length()));
        } else {
            a2 = kotlin.d.d.a(kotlin.d.d.d(i, l.d(charSequence)), kotlin.d.d.c(i2, 0));
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a3 = a2.a();
            int b = a2.b();
            int c = a2.c();
            if (c >= 0) {
                if (a3 > b) {
                    return -1;
                }
            } else if (a3 < b) {
                return -1;
            }
            while (!l.a((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z)) {
                if (a3 == b) {
                    return -1;
                }
                a3 += c;
            }
            return a3;
        }
        int a4 = a2.a();
        int b2 = a2.b();
        int c2 = a2.c();
        if (c2 >= 0) {
            if (a4 > b2) {
                return -1;
            }
        } else if (a4 < b2) {
            return -1;
        }
        while (!l.a(charSequence2, 0, charSequence, a4, charSequence2.length(), z)) {
            if (a4 == b2) {
                return -1;
            }
            a4 += c2;
        }
        return a4;
    }

    public static final Pair<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i, boolean z, boolean z2) {
        Object obj;
        Object obj2;
        if (!z && collection.size() == 1) {
            String str = (String) kotlin.collections.j.a((Iterable) collection);
            int a2 = !z2 ? l.a(charSequence, str, i, false, 4, (Object) null) : l.b(charSequence, str, i, false, 4, (Object) null);
            if (a2 < 0) {
                return null;
            }
            return kotlin.i.a(Integer.valueOf(a2), str);
        }
        kotlin.d.c cVar = !z2 ? new kotlin.d.c(kotlin.d.d.c(i, 0), charSequence.length()) : kotlin.d.d.a(kotlin.d.d.d(i, l.d(charSequence)), 0);
        if (charSequence instanceof String) {
            int a3 = cVar.a();
            int b = cVar.b();
            int c = cVar.c();
            if (c < 0 ? a3 >= b : a3 <= b) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str2 = (String) obj2;
                        if (l.a(str2, 0, (String) charSequence, a3, str2.length(), z)) {
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 == null) {
                        if (a3 == b) {
                            break;
                        }
                        a3 += c;
                    } else {
                        return kotlin.i.a(Integer.valueOf(a3), str3);
                    }
                }
            }
        } else {
            int a4 = cVar.a();
            int b2 = cVar.b();
            int c2 = cVar.c();
            if (c2 < 0 ? a4 >= b2 : a4 <= b2) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it2.next();
                        String str4 = (String) obj;
                        if (l.a(str4, 0, charSequence, a4, str4.length(), z)) {
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        if (a4 == b2) {
                            break;
                        }
                        a4 += c2;
                    } else {
                        return kotlin.i.a(Integer.valueOf(a4), str5);
                    }
                }
            }
        }
        return null;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.a(charSequence, c, i, z);
    }

    public static final int a(CharSequence charSequence, char c, int i, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$indexOf");
        return (z || !(charSequence instanceof String)) ? l.a(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$indexOf");
        kotlin.jvm.internal.h.b(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        return ((String) charSequence).indexOf(str, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = l.d(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.b(charSequence, c, i, z);
    }

    public static final int b(CharSequence charSequence, char c, int i, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$lastIndexOf");
        return (z || !(charSequence instanceof String)) ? l.b(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = l.d(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return l.b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, String str, int i, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$lastIndexOf");
        kotlin.jvm.internal.h.b(str, "string");
        if (z || !(charSequence instanceof String)) {
            return a(charSequence, (CharSequence) str, i, 0, z, true);
        }
        return ((String) charSequence).lastIndexOf(str, i);
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return l.a(charSequence, charSequence2, z);
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        kotlin.jvm.internal.h.b(charSequence, "$this$contains");
        kotlin.jvm.internal.h.b(charSequence2, "other");
        return charSequence2 instanceof String ? l.a(charSequence, (String) charSequence2, 0, z, 2, (Object) null) >= 0 : a(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    static /* synthetic */ kotlin.f.b a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    private static final kotlin.f.b<kotlin.d.c> a(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
        }
        final List a2 = kotlin.collections.d.a(strArr);
        return new e(charSequence, i, i2, new kotlin.jvm.a.m<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.a.m
            public /* synthetic */ Pair<? extends Integer, ? extends Integer> a(CharSequence charSequence2, Integer num) {
                return a(charSequence2, num.intValue());
            }

            public final Pair<Integer, Integer> a(CharSequence charSequence2, int i3) {
                Pair b;
                kotlin.jvm.internal.h.b(charSequence2, "$receiver");
                b = v.b(charSequence2, (Collection<String>) a2, i3, z, false);
                if (b != null) {
                    return kotlin.i.a(b.a(), Integer.valueOf(((String) b.b()).length()));
                }
                return null;
            }
        });
    }

    public static /* synthetic */ List a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return l.a(charSequence, strArr, z, i);
    }

    public static final List<String> a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        kotlin.jvm.internal.h.b(charSequence, "$this$split");
        kotlin.jvm.internal.h.b(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable d = kotlin.f.c.d(a(charSequence, strArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(kotlin.collections.j.a(d, 10));
        Iterator it = d.iterator();
        while (it.hasNext()) {
            arrayList.add(l.a(charSequence, (kotlin.d.c) it.next()));
        }
        return arrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i) {
        int i2 = 0;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Limit must be non-negative, but was " + i + '.').toString());
        }
        int a2 = l.a(charSequence, str, 0, z);
        if (a2 == -1 || i == 1) {
            return kotlin.collections.j.a(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList(z2 ? kotlin.d.d.d(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i2, a2).toString());
            i2 = str.length() + a2;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            a2 = l.a(charSequence, str, i2, z);
        } while (a2 != -1);
        arrayList.add(charSequence.subSequence(i2, charSequence.length()).toString());
        return arrayList;
    }

    public static final CharSequence b(CharSequence charSequence) {
        kotlin.jvm.internal.h.b(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean a2 = a.a(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!a2) {
                    break;
                }
                length--;
            } else if (a2) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }
}
