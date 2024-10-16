package kotlin.text;

/* loaded from: classes3.dex */
class b {
    public static final boolean a(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }

    public static final int a(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final int a(int i) {
        if (2 <= i && 36 >= i) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new kotlin.d.c(2, 36));
    }
}
