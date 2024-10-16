package kotlin.text;

import java.nio.charset.Charset;

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f6980a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    public static final d g = new d();

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.h.a((Object) forName, "Charset.forName(\"UTF-8\")");
        f6980a = forName;
        Charset forName2 = Charset.forName("UTF-16");
        kotlin.jvm.internal.h.a((Object) forName2, "Charset.forName(\"UTF-16\")");
        b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.h.a((Object) forName3, "Charset.forName(\"UTF-16BE\")");
        c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.h.a((Object) forName4, "Charset.forName(\"UTF-16LE\")");
        d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.h.a((Object) forName5, "Charset.forName(\"US-ASCII\")");
        e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.h.a((Object) forName6, "Charset.forName(\"ISO-8859-1\")");
        f = forName6;
    }

    private d() {
    }
}
