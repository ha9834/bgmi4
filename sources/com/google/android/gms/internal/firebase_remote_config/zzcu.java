package com.google.android.gms.internal.firebase_remote_config;

/* loaded from: classes2.dex */
public final class zzcu extends zzcv {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f4149a = {'+'};
    private static final char[] b = "0123456789ABCDEF".toCharArray();
    private final boolean c;
    private final boolean[] d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzcu(String str, boolean z) {
        if (str.matches(".*[0-9A-Za-z].*")) {
            throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
        }
        if (z && str.contains(" ")) {
            throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
        }
        if (str.contains("%")) {
            throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
        }
        this.c = z;
        char[] charArray = str.toCharArray();
        int i = 122;
        for (char c : charArray) {
            i = Math.max((int) c, i);
        }
        boolean[] zArr = new boolean[i + 1];
        for (int i2 = 48; i2 <= 57; i2++) {
            zArr[i2] = true;
        }
        for (int i3 = 65; i3 <= 90; i3++) {
            zArr[i3] = true;
        }
        for (int i4 = 97; i4 <= 122; i4++) {
            zArr[i4] = true;
        }
        for (char c2 : charArray) {
            zArr[c2] = true;
        }
        this.d = zArr;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzcv
    protected final int a(CharSequence charSequence, int i, int i2) {
        while (i < i2) {
            char charAt = charSequence.charAt(i);
            boolean[] zArr = this.d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                break;
            }
            i++;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzcr
    public final String zzag(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            boolean[] zArr = this.d;
            if (charAt >= zArr.length || !zArr[charAt]) {
                return a(str, i);
            }
        }
        return str;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.zzcv
    protected final char[] a(int i) {
        boolean[] zArr = this.d;
        if (i < zArr.length && zArr[i]) {
            return null;
        }
        if (i == 32 && this.c) {
            return f4149a;
        }
        if (i <= 127) {
            char[] cArr = b;
            return new char[]{'%', cArr[i >>> 4], cArr[i & 15]};
        }
        if (i <= 2047) {
            char[] cArr2 = b;
            char[] cArr3 = {'%', cArr2[(r14 >>> 4) | 12], cArr2[r14 & 15], '%', cArr2[(r14 & 3) | 8], cArr2[i & 15]};
            int i2 = i >>> 4;
            int i3 = i2 >>> 2;
            return cArr3;
        }
        if (i <= 65535) {
            char[] cArr4 = b;
            char[] cArr5 = {'%', 'E', cArr4[r14 >>> 2], '%', cArr4[(r14 & 3) | 8], cArr4[r14 & 15], '%', cArr4[(r14 & 3) | 8], cArr4[i & 15]};
            int i4 = i >>> 4;
            int i5 = i4 >>> 2;
            int i6 = i5 >>> 4;
            return cArr5;
        }
        if (i <= 1114111) {
            char[] cArr6 = b;
            char[] cArr7 = {'%', 'F', cArr6[(r14 >>> 2) & 7], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[r14 & 15], '%', cArr6[(r14 & 3) | 8], cArr6[i & 15]};
            int i7 = i >>> 4;
            int i8 = i7 >>> 2;
            int i9 = i8 >>> 4;
            int i10 = i9 >>> 2;
            int i11 = i10 >>> 4;
            return cArr7;
        }
        StringBuilder sb = new StringBuilder(43);
        sb.append("Invalid unicode character value ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }
}
