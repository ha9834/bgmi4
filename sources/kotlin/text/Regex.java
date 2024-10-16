package kotlin.text;

import com.tencent.grobot.lite.model.local.EvaluateItemInfo;
import java.io.Serializable;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class Regex implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f6977a = new a(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public Regex(Pattern pattern) {
        kotlin.jvm.internal.h.b(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.h.b(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.jvm.internal.h.a(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public Regex(java.lang.String r2, kotlin.text.RegexOption r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.h.b(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.h.b(r3, r0)
            kotlin.text.Regex$a r0 = kotlin.text.Regex.f6977a
            int r3 = r3.a()
            int r3 = kotlin.text.Regex.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            kotlin.jvm.internal.h.a(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    public final boolean a(CharSequence charSequence) {
        kotlin.jvm.internal.h.b(charSequence, EvaluateItemInfo.ACTIONTYPE_INPUT);
        return this.nativePattern.matcher(charSequence).matches();
    }

    public static /* synthetic */ i a(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.a(charSequence, i);
    }

    public final i a(CharSequence charSequence, int i) {
        i b;
        kotlin.jvm.internal.h.b(charSequence, EvaluateItemInfo.ACTIONTYPE_INPUT);
        Matcher matcher = this.nativePattern.matcher(charSequence);
        kotlin.jvm.internal.h.a((Object) matcher, "nativePattern.matcher(input)");
        b = k.b(matcher, i, charSequence);
        return b;
    }

    public final String a(CharSequence charSequence, kotlin.jvm.a.b<? super i, ? extends CharSequence> bVar) {
        kotlin.jvm.internal.h.b(charSequence, EvaluateItemInfo.ACTIONTYPE_INPUT);
        kotlin.jvm.internal.h.b(bVar, "transform");
        int i = 0;
        i a2 = a(this, charSequence, 0, 2, null);
        if (a2 == null) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            kotlin.jvm.internal.h.a(a2);
            sb.append(charSequence, i, a2.a().f().intValue());
            sb.append(bVar.a(a2));
            i = a2.a().g().intValue() + 1;
            a2 = a2.c();
            if (i >= length) {
                break;
            }
        } while (a2 != null);
        if (i < length) {
            sb.append(charSequence, i, length);
        }
        String sb2 = sb.toString();
        kotlin.jvm.internal.h.a((Object) sb2, "sb.toString()");
        return sb2;
    }

    public String toString() {
        String pattern = this.nativePattern.toString();
        kotlin.jvm.internal.h.a((Object) pattern, "nativePattern.toString()");
        return pattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        kotlin.jvm.internal.h.a((Object) pattern, "nativePattern.pattern()");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    /* loaded from: classes3.dex */
    private static final class Serialized implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6978a = new a(null);
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        /* loaded from: classes3.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public Serialized(String str, int i) {
            kotlin.jvm.internal.h.b(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            kotlin.jvm.internal.h.a((Object) compile, "Pattern.compile(pattern, flags)");
            return new Regex(compile);
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public final int a(int i) {
            return (i & 2) != 0 ? i | 64 : i;
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }
}
