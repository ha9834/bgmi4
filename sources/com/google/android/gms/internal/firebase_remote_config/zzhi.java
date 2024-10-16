package com.google.android.gms.internal.firebase_remote_config;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class zzhi {

    /* renamed from: a, reason: collision with root package name */
    static final Charset f4184a = Charset.forName("UTF-8");
    private static final Charset b = Charset.forName("ISO-8859-1");
    private static final ByteBuffer c;
    private static final zzgj d;
    public static final byte[] zzty;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(zzim zzimVar) {
        return false;
    }

    public static int zzg(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzq(long j) {
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

    public static boolean zze(byte[] bArr) {
        return ej.a(bArr);
    }

    public static String zzf(byte[] bArr) {
        return new String(bArr, f4184a);
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
        return ((zzim) obj).zzha().zza((zzim) obj2).zzgv();
    }

    static {
        byte[] bArr = new byte[0];
        zzty = bArr;
        c = ByteBuffer.wrap(bArr);
        byte[] bArr2 = zzty;
        d = zzgj.a(bArr2, 0, bArr2.length, false);
    }
}
