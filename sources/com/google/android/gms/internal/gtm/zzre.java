package com.google.android.gms.internal.gtm;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzre {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f4443a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    private static final ByteBuffer c;
    private static final zzqe d;
    public static final byte[] zzbbh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzsk zzskVar) {
        return false;
    }

    public static int zzk(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzz(long j) {
        return (int) (j ^ (j >>> 32));
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

    public static boolean zzi(byte[] bArr) {
        return dx.a(bArr);
    }

    public static String zzj(byte[] bArr) {
        return new String(bArr, f4443a);
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
        return ((zzsk) obj).zzpg().zza((zzsk) obj2).zzpl();
    }

    static {
        byte[] bArr = new byte[0];
        zzbbh = bArr;
        c = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzbbh;
        d = zzqe.a(bArr2, 0, bArr2.length, false);
    }
}
