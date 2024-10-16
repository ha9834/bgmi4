package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzdod {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f3593a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    private static final ByteBuffer c;
    private static final zzdnd d;
    public static final byte[] zzhia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzdpk zzdpkVar) {
        return false;
    }

    public static int zzbh(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzft(long j) {
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

    public static boolean zzad(byte[] bArr) {
        return ahv.a(bArr);
    }

    public static String zzae(byte[] bArr) {
        return new String(bArr, f3593a);
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
        return ((zzdpk) obj).zzaxt().zzi((zzdpk) obj2).zzaxz();
    }

    static {
        byte[] bArr = new byte[0];
        zzhia = bArr;
        c = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzhia;
        d = zzdnd.a(bArr2, 0, bArr2.length, false);
    }
}
