package kotlin.random;

/* loaded from: classes3.dex */
public final class c {
    public static final int a(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
