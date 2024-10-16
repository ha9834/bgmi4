package com.google.android.gms.internal.drive;

import com.google.android.gms.games.Notifications;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes2.dex */
public final class zzip {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f3995a;

    private zzip(ByteBuffer byteBuffer) {
        this.f3995a = byteBuffer;
        this.f3995a.order(ByteOrder.LITTLE_ENDIAN);
    }

    private zzip(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, i, i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int a(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        int i2 = 0;
        while (i2 < length && charSequence.charAt(i2) < 128) {
            i2++;
        }
        int i3 = length;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char charAt = charSequence.charAt(i2);
            if (charAt < 2048) {
                i3 += (127 - charAt) >>> 31;
                i2++;
            } else {
                int length2 = charSequence.length();
                while (i2 < length2) {
                    char charAt2 = charSequence.charAt(i2);
                    if (charAt2 < 2048) {
                        i += (127 - charAt2) >>> 31;
                    } else {
                        i += 2;
                        if (55296 <= charAt2 && charAt2 <= 57343) {
                            if (Character.codePointAt(charSequence, i2) < 65536) {
                                StringBuilder sb = new StringBuilder(39);
                                sb.append("Unpaired surrogate at index ");
                                sb.append(i2);
                                throw new IllegalArgumentException(sb.toString());
                            }
                            i2++;
                        }
                    }
                    i2++;
                }
                i3 += i;
            }
        }
        if (i3 >= length) {
            return i3;
        }
        long j = i3 + 4294967296L;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("UTF-8 length does not fit in int: ");
        sb2.append(j);
        throw new IllegalArgumentException(sb2.toString());
    }

    private final void a(int i) throws IOException {
        byte b = (byte) i;
        if (!this.f3995a.hasRemaining()) {
            throw new zziq(this.f3995a.position(), this.f3995a.limit());
        }
        this.f3995a.put(b);
    }

    private final void a(long j) throws IOException {
        while (((-128) & j) != 0) {
            a((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128);
            j >>>= 7;
        }
        a((int) j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v26 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        int i2;
        char charAt;
        int i3;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i4 = 0;
        if (!byteBuffer.hasArray()) {
            int length = charSequence.length();
            while (i4 < length) {
                char charAt2 = charSequence.charAt(i4);
                char c = charAt2;
                if (charAt2 >= 128) {
                    if (charAt2 < 2048) {
                        i3 = (charAt2 >>> 6) | 960;
                    } else {
                        if (charAt2 >= 55296 && 57343 >= charAt2) {
                            int i5 = i4 + 1;
                            if (i5 != charSequence.length()) {
                                char charAt3 = charSequence.charAt(i5);
                                if (Character.isSurrogatePair(charAt2, charAt3)) {
                                    int codePoint = Character.toCodePoint(charAt2, charAt3);
                                    byteBuffer.put((byte) ((codePoint >>> 18) | 240));
                                    byteBuffer.put((byte) (((codePoint >>> 12) & 63) | 128));
                                    byteBuffer.put((byte) (((codePoint >>> 6) & 63) | 128));
                                    byteBuffer.put((byte) ((codePoint & 63) | 128));
                                    i4 = i5;
                                    i4++;
                                } else {
                                    i4 = i5;
                                }
                            }
                            StringBuilder sb = new StringBuilder(39);
                            sb.append("Unpaired surrogate at index ");
                            sb.append(i4 - 1);
                            throw new IllegalArgumentException(sb.toString());
                        }
                        byteBuffer.put((byte) ((charAt2 >>> '\f') | 480));
                        i3 = ((charAt2 >>> 6) & 63) | 128;
                    }
                    byteBuffer.put((byte) i3);
                    c = (charAt2 & '?') | 128;
                }
                byteBuffer.put((byte) c);
                i4++;
            }
            return;
        }
        try {
            byte[] array = byteBuffer.array();
            int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
            int remaining = byteBuffer.remaining();
            int length2 = charSequence.length();
            int i6 = remaining + arrayOffset;
            while (i4 < length2) {
                int i7 = i4 + arrayOffset;
                if (i7 >= i6 || (charAt = charSequence.charAt(i4)) >= 128) {
                    break;
                }
                array[i7] = (byte) charAt;
                i4++;
            }
            if (i4 == length2) {
                i = arrayOffset + length2;
            } else {
                i = arrayOffset + i4;
                while (i4 < length2) {
                    char charAt4 = charSequence.charAt(i4);
                    if (charAt4 >= 128 || i >= i6) {
                        if (charAt4 < 2048 && i <= i6 - 2) {
                            int i8 = i + 1;
                            array[i] = (byte) ((charAt4 >>> 6) | 960);
                            i = i8 + 1;
                            array[i8] = (byte) ((charAt4 & '?') | 128);
                        } else {
                            if ((charAt4 >= 55296 && 57343 >= charAt4) || i > i6 - 3) {
                                if (i > i6 - 4) {
                                    StringBuilder sb2 = new StringBuilder(37);
                                    sb2.append("Failed writing ");
                                    sb2.append(charAt4);
                                    sb2.append(" at index ");
                                    sb2.append(i);
                                    throw new ArrayIndexOutOfBoundsException(sb2.toString());
                                }
                                int i9 = i4 + 1;
                                if (i9 != charSequence.length()) {
                                    char charAt5 = charSequence.charAt(i9);
                                    if (Character.isSurrogatePair(charAt4, charAt5)) {
                                        int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                                        int i10 = i + 1;
                                        array[i] = (byte) ((codePoint2 >>> 18) | 240);
                                        int i11 = i10 + 1;
                                        array[i10] = (byte) (((codePoint2 >>> 12) & 63) | 128);
                                        int i12 = i11 + 1;
                                        array[i11] = (byte) (((codePoint2 >>> 6) & 63) | 128);
                                        i = i12 + 1;
                                        array[i12] = (byte) ((codePoint2 & 63) | 128);
                                        i4 = i9;
                                    } else {
                                        i4 = i9;
                                    }
                                }
                                StringBuilder sb3 = new StringBuilder(39);
                                sb3.append("Unpaired surrogate at index ");
                                sb3.append(i4 - 1);
                                throw new IllegalArgumentException(sb3.toString());
                            }
                            int i13 = i + 1;
                            array[i] = (byte) ((charAt4 >>> '\f') | 480);
                            int i14 = i13 + 1;
                            array[i13] = (byte) (((charAt4 >>> 6) & 63) | 128);
                            i2 = i14 + 1;
                            array[i14] = (byte) ((charAt4 & '?') | 128);
                        }
                        i4++;
                    } else {
                        i2 = i + 1;
                        array[i] = (byte) charAt4;
                    }
                    i = i2;
                    i4++;
                }
            }
            byteBuffer.position(i - byteBuffer.arrayOffset());
        } catch (ArrayIndexOutOfBoundsException e) {
            BufferOverflowException bufferOverflowException = new BufferOverflowException();
            bufferOverflowException.initCause(e);
            throw bufferOverflowException;
        }
    }

    private static long b(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzb(int i, long j) {
        int zzo = zzo(i);
        long b = b(j);
        return zzo + (((-128) & b) == 0 ? 1 : ((-16384) & b) == 0 ? 2 : ((-2097152) & b) == 0 ? 3 : ((-268435456) & b) == 0 ? 4 : ((-34359738368L) & b) == 0 ? 5 : ((-4398046511104L) & b) == 0 ? 6 : ((-562949953421312L) & b) == 0 ? 7 : ((-72057594037927936L) & b) == 0 ? 8 : (b & Long.MIN_VALUE) == 0 ? 9 : 10);
    }

    public static zzip zzb(byte[] bArr) {
        return zzb(bArr, 0, bArr.length);
    }

    public static zzip zzb(byte[] bArr, int i, int i2) {
        return new zzip(bArr, 0, i2);
    }

    public static int zzc(int i, int i2) {
        return zzo(i) + zzm(i2);
    }

    public static int zzi(String str) {
        int a2 = a(str);
        return zzq(a2) + a2;
    }

    public static int zzm(int i) {
        if (i >= 0) {
            return zzq(i);
        }
        return 10;
    }

    public static int zzo(int i) {
        return zzq(i << 3);
    }

    public static int zzq(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public final void zza(int i, long j) throws IOException {
        zzd(i, 0);
        a(b(j));
    }

    public final void zzb(int i, int i2) throws IOException {
        zzd(i, 0);
        if (i2 >= 0) {
            zzp(i2);
        } else {
            a(i2);
        }
    }

    public final void zzbh() {
        if (this.f3995a.remaining() != 0) {
            throw new IllegalStateException(String.format("Did not write as much data as expected, %s bytes remaining.", Integer.valueOf(this.f3995a.remaining())));
        }
    }

    public final void zzc(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f3995a.remaining() < length) {
            throw new zziq(this.f3995a.position(), this.f3995a.limit());
        }
        this.f3995a.put(bArr, 0, length);
    }

    public final void zzd(int i, int i2) throws IOException {
        zzp((i << 3) | i2);
    }

    public final void zzh(String str) throws IOException {
        try {
            int zzq = zzq(str.length());
            if (zzq != zzq(str.length() * 3)) {
                zzp(a(str));
                a(str, this.f3995a);
                return;
            }
            int position = this.f3995a.position();
            if (this.f3995a.remaining() < zzq) {
                throw new zziq(position + zzq, this.f3995a.limit());
            }
            this.f3995a.position(position + zzq);
            a(str, this.f3995a);
            int position2 = this.f3995a.position();
            this.f3995a.position(position);
            zzp((position2 - position) - zzq);
            this.f3995a.position(position2);
        } catch (BufferOverflowException e) {
            zziq zziqVar = new zziq(this.f3995a.position(), this.f3995a.limit());
            zziqVar.initCause(e);
            throw zziqVar;
        }
    }

    public final void zzp(int i) throws IOException {
        while ((i & (-128)) != 0) {
            a((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
            i >>>= 7;
        }
        a(i);
    }
}
