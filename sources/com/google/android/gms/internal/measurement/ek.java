package com.google.android.gms.internal.measurement;

import com.tencent.smtt.sdk.TbsListener;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
abstract class ek {
    abstract int a(int i, byte[] bArr, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int a(CharSequence charSequence, byte[] bArr, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(CharSequence charSequence, ByteBuffer byteBuffer);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract String b(byte[] bArr, int i, int i2) throws zzfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(byte[] bArr, int i, int i2) {
        return a(0, bArr, i, i2) == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void b(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int length = charSequence.length();
        int position = byteBuffer.position();
        int i2 = 0;
        while (i2 < length) {
            try {
                char charAt = charSequence.charAt(i2);
                if (charAt >= 128) {
                    break;
                }
                byteBuffer.put(position + i2, (byte) charAt);
                i2++;
            } catch (IndexOutOfBoundsException unused) {
                int position2 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                char charAt2 = charSequence.charAt(i2);
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(position2);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            }
        }
        if (i2 == length) {
            byteBuffer.position(position + i2);
            return;
        }
        position += i2;
        while (i2 < length) {
            char charAt3 = charSequence.charAt(i2);
            if (charAt3 < 128) {
                byteBuffer.put(position, (byte) charAt3);
            } else if (charAt3 < 2048) {
                int i3 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt3 >>> 6) | 192));
                    byteBuffer.put(i3, (byte) ((charAt3 & '?') | 128));
                    position = i3;
                } catch (IndexOutOfBoundsException unused2) {
                    position = i3;
                    int position22 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                    char charAt22 = charSequence.charAt(i2);
                    StringBuilder sb2 = new StringBuilder(37);
                    sb2.append("Failed writing ");
                    sb2.append(charAt22);
                    sb2.append(" at index ");
                    sb2.append(position22);
                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                }
            } else if (charAt3 < 55296 || 57343 < charAt3) {
                int i4 = position + 1;
                try {
                    byteBuffer.put(position, (byte) ((charAt3 >>> '\f') | TbsListener.ErrorCode.EXCEED_INCR_UPDATE));
                    position = i4 + 1;
                    byteBuffer.put(i4, (byte) (((charAt3 >>> 6) & 63) | 128));
                    byteBuffer.put(position, (byte) ((charAt3 & '?') | 128));
                } catch (IndexOutOfBoundsException unused3) {
                    position = i4;
                    int position222 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                    char charAt222 = charSequence.charAt(i2);
                    StringBuilder sb22 = new StringBuilder(37);
                    sb22.append("Failed writing ");
                    sb22.append(charAt222);
                    sb22.append(" at index ");
                    sb22.append(position222);
                    throw new ArrayIndexOutOfBoundsException(sb22.toString());
                }
            } else {
                int i5 = i2 + 1;
                if (i5 != length) {
                    try {
                        char charAt4 = charSequence.charAt(i5);
                        if (Character.isSurrogatePair(charAt3, charAt4)) {
                            int codePoint = Character.toCodePoint(charAt3, charAt4);
                            int i6 = position + 1;
                            try {
                                byteBuffer.put(position, (byte) ((codePoint >>> 18) | 240));
                                position = i6 + 1;
                            } catch (IndexOutOfBoundsException unused4) {
                                position = i6;
                            }
                            try {
                                byteBuffer.put(i6, (byte) (((codePoint >>> 12) & 63) | 128));
                                i = position + 1;
                            } catch (IndexOutOfBoundsException unused5) {
                                i2 = i5;
                                int position2222 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                                char charAt2222 = charSequence.charAt(i2);
                                StringBuilder sb222 = new StringBuilder(37);
                                sb222.append("Failed writing ");
                                sb222.append(charAt2222);
                                sb222.append(" at index ");
                                sb222.append(position2222);
                                throw new ArrayIndexOutOfBoundsException(sb222.toString());
                            }
                            try {
                                byteBuffer.put(position, (byte) (((codePoint >>> 6) & 63) | 128));
                                byteBuffer.put(i, (byte) ((codePoint & 63) | 128));
                                position = i;
                                i2 = i5;
                            } catch (IndexOutOfBoundsException unused6) {
                                position = i;
                                i2 = i5;
                                int position22222 = byteBuffer.position() + Math.max(i2, (position - byteBuffer.position()) + 1);
                                char charAt22222 = charSequence.charAt(i2);
                                StringBuilder sb2222 = new StringBuilder(37);
                                sb2222.append("Failed writing ");
                                sb2222.append(charAt22222);
                                sb2222.append(" at index ");
                                sb2222.append(position22222);
                                throw new ArrayIndexOutOfBoundsException(sb2222.toString());
                            }
                        } else {
                            i2 = i5;
                        }
                    } catch (IndexOutOfBoundsException unused7) {
                    }
                }
                throw new zzib(i2, length);
            }
            i2++;
            position++;
        }
        byteBuffer.position(position);
    }
}
