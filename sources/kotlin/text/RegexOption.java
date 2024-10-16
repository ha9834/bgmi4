package kotlin.text;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'c' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class RegexOption {

    /* renamed from: a, reason: collision with root package name */
    public static final RegexOption f6979a;
    public static final RegexOption b;
    public static final RegexOption c;
    public static final RegexOption d;
    public static final RegexOption e;
    public static final RegexOption f;
    public static final RegexOption g;
    private static final /* synthetic */ RegexOption[] h;
    private final int mask;
    private final int value;

    public static RegexOption valueOf(String str) {
        return (RegexOption) Enum.valueOf(RegexOption.class, str);
    }

    public static RegexOption[] values() {
        return (RegexOption[]) h.clone();
    }

    private RegexOption(String str, int i, int i2, int i3) {
        this.value = i2;
        this.mask = i3;
    }

    /* synthetic */ RegexOption(String str, int i, int i2, int i3, int i4, kotlin.jvm.internal.f fVar) {
        this(str, i, i2, (i4 & 2) != 0 ? i2 : i3);
    }

    public int a() {
        return this.value;
    }

    static {
        RegexOption regexOption = new RegexOption("IGNORE_CASE", 0, 2, 0, 2, null);
        f6979a = regexOption;
        RegexOption regexOption2 = new RegexOption("MULTILINE", 1, 8, 0, 2, null);
        b = regexOption2;
        int i = 0;
        int i2 = 2;
        kotlin.jvm.internal.f fVar = null;
        RegexOption regexOption3 = new RegexOption("LITERAL", 2, 16, i, i2, fVar);
        c = regexOption3;
        RegexOption regexOption4 = new RegexOption("UNIX_LINES", 3, 1, i, i2, fVar);
        d = regexOption4;
        RegexOption regexOption5 = new RegexOption("COMMENTS", 4, 4, i, i2, fVar);
        e = regexOption5;
        RegexOption regexOption6 = new RegexOption("DOT_MATCHES_ALL", 5, 32, i, i2, fVar);
        f = regexOption6;
        RegexOption regexOption7 = new RegexOption("CANON_EQ", 6, 128, i, i2, fVar);
        g = regexOption7;
        h = new RegexOption[]{regexOption, regexOption2, regexOption3, regexOption4, regexOption5, regexOption6, regexOption7};
    }
}
