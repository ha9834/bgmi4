package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzez {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f4562a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    private static final ByteBuffer c;
    private static final zzeb d;
    public static final byte[] zzair;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzgi zzgiVar) {
        return false;
    }

    public static int zzbx(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzs(boolean z) {
        return z ? 1231 : 1237;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzh(byte[] bArr) {
        return ej.a(bArr);
    }

    public static String zzi(byte[] bArr) {
        return new String(bArr, f4562a);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int a2 = a(length, bArr, 0, length);
        if (a2 == 0) {
            return 1;
        }
        return a2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, Object obj2) {
        return ((zzgi) obj).zzuo().zza((zzgi) obj2).zzuf();
    }

    static {
        byte[] bArr = new byte[0];
        zzair = bArr;
        c = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzair;
        d = zzeb.a(bArr2, 0, bArr2.length, false);
    }
}
