package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.Hide;
import java.util.Arrays;

@Hide
/* loaded from: classes2.dex */
public class zzc {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f5029a = "0123456789abcdef".toCharArray();
    private final byte[] b;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzc(byte[] bArr) {
        this.b = bArr;
    }

    public static byte[] zzky(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((Character.digit(str.charAt(i2), 16) << 4) + Character.digit(str.charAt(i2 + 1), 16));
        }
        return bArr;
    }

    public static String zzw(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(f5029a[(b >> 4) & 15]);
            sb.append(f5029a[b & 15]);
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj.getClass().isAssignableFrom(getClass())) {
            return Arrays.equals(this.b, ((zzc) obj).b);
        }
        return false;
    }

    public final byte[] getBytes() {
        return this.b;
    }

    public final String getHex() {
        return zzw(this.b);
    }

    public int hashCode() {
        return Arrays.hashCode(this.b);
    }

    public String toString() {
        return zzw(this.b);
    }
}
