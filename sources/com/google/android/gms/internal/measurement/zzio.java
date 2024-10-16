package com.google.android.gms.internal.measurement;

import com.google.android.gms.games.Notifications;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ReadOnlyBufferException;

/* loaded from: classes2.dex */
public final class zzio {

    /* renamed from: a, reason: collision with root package name */
    private final ByteBuffer f4574a;
    private zzee b;
    private int c;

    private zzio(byte[] bArr, int i, int i2) {
        this(ByteBuffer.wrap(bArr, 0, i2));
    }

    public static int zzbq(int i) {
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

    private zzio(ByteBuffer byteBuffer) {
        this.f4574a = byteBuffer;
        this.f4574a.order(ByteOrder.LITTLE_ENDIAN);
    }

    public static zzio zzj(byte[] bArr) {
        return new zzio(bArr, 0, bArr.length);
    }

    public static zzio zzk(byte[] bArr, int i, int i2) {
        return new zzio(bArr, 0, i2);
    }

    public final void zzc(int i, int i2) throws IOException {
        zzb(i, 0);
        if (i2 >= 0) {
            zzck(i2);
        } else {
            zzbz(i2);
        }
    }

    public final void zzb(int i, boolean z) throws IOException {
        zzb(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        if (!this.f4574a.hasRemaining()) {
            throw new zzin(this.f4574a.position(), this.f4574a.limit());
        }
        this.f4574a.put(b);
    }

    public final void zzb(int i, String str) throws IOException {
        zzb(i, 2);
        try {
            int zzbq = zzbq(str.length());
            if (zzbq == zzbq(str.length() * 3)) {
                int position = this.f4574a.position();
                if (this.f4574a.remaining() < zzbq) {
                    throw new zzin(position + zzbq, this.f4574a.limit());
                }
                this.f4574a.position(position + zzbq);
                a(str, this.f4574a);
                int position2 = this.f4574a.position();
                this.f4574a.position(position);
                zzck((position2 - position) - zzbq);
                this.f4574a.position(position2);
                return;
            }
            zzck(a(str));
            a(str, this.f4574a);
        } catch (BufferOverflowException e) {
            zzin zzinVar = new zzin(this.f4574a.position(), this.f4574a.limit());
            zzinVar.initCause(e);
            throw zzinVar;
        }
    }

    public final void zza(int i, zziw zziwVar) throws IOException {
        zzb(i, 2);
        if (zziwVar.b < 0) {
            zziwVar.zzuk();
        }
        zzck(zziwVar.b);
        zziwVar.zza(this);
    }

    public final void zze(int i, zzgi zzgiVar) throws IOException {
        if (this.b == null) {
            this.b = zzee.zza(this.f4574a);
            this.c = this.f4574a.position();
        } else if (this.c != this.f4574a.position()) {
            this.b.write(this.f4574a.array(), this.c, this.f4574a.position() - this.c);
            this.c = this.f4574a.position();
        }
        zzee zzeeVar = this.b;
        zzeeVar.zza(i, zzgiVar);
        zzeeVar.flush();
        this.c = this.f4574a.position();
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void a(CharSequence charSequence, ByteBuffer byteBuffer) {
        int i;
        char charAt;
        if (byteBuffer.isReadOnly()) {
            throw new ReadOnlyBufferException();
        }
        int i2 = 0;
        if (byteBuffer.hasArray()) {
            try {
                byte[] array = byteBuffer.array();
                int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
                int remaining = byteBuffer.remaining();
                int length = charSequence.length();
                int i3 = remaining + arrayOffset;
                while (i2 < length) {
                    int i4 = i2 + arrayOffset;
                    if (i4 >= i3 || (charAt = charSequence.charAt(i2)) >= 128) {
                        break;
                    }
                    array[i4] = (byte) charAt;
                    i2++;
                }
                if (i2 == length) {
                    i = arrayOffset + length;
                } else {
                    i = arrayOffset + i2;
                    while (i2 < length) {
                        char charAt2 = charSequence.charAt(i2);
                        if (charAt2 < 128 && i < i3) {
                            array[i] = (byte) charAt2;
                            i++;
                        } else if (charAt2 < 2048 && i <= i3 - 2) {
                            int i5 = i + 1;
                            array[i] = (byte) ((charAt2 >>> 6) | 960);
                            i = i5 + 1;
                            array[i5] = (byte) ((charAt2 & '?') | 128);
                        } else {
                            if ((charAt2 >= 55296 && 57343 >= charAt2) || i > i3 - 3) {
                                if (i <= i3 - 4) {
                                    int i6 = i2 + 1;
                                    if (i6 != charSequence.length()) {
                                        char charAt3 = charSequence.charAt(i6);
                                        if (Character.isSurrogatePair(charAt2, charAt3)) {
                                            int codePoint = Character.toCodePoint(charAt2, charAt3);
                                            int i7 = i + 1;
                                            array[i] = (byte) ((codePoint >>> 18) | 240);
                                            int i8 = i7 + 1;
                                            array[i7] = (byte) (((codePoint >>> 12) & 63) | 128);
                                            int i9 = i8 + 1;
                                            array[i8] = (byte) (((codePoint >>> 6) & 63) | 128);
                                            i = i9 + 1;
                                            array[i9] = (byte) ((codePoint & 63) | 128);
                                            i2 = i6;
                                        } else {
                                            i2 = i6;
                                        }
                                    }
                                    StringBuilder sb = new StringBuilder(39);
                                    sb.append("Unpaired surrogate at index ");
                                    sb.append(i2 - 1);
                                    throw new IllegalArgumentException(sb.toString());
                                }
                                StringBuilder sb2 = new StringBuilder(37);
                                sb2.append("Failed writing ");
                                sb2.append(charAt2);
                                sb2.append(" at index ");
                                sb2.append(i);
                                throw new ArrayIndexOutOfBoundsException(sb2.toString());
                            }
                            int i10 = i + 1;
                            array[i] = (byte) ((charAt2 >>> '\f') | 480);
                            int i11 = i10 + 1;
                            array[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                            array[i11] = (byte) ((charAt2 & '?') | 128);
                            i = i11 + 1;
                        }
                        i2++;
                    }
                }
                byteBuffer.position(i - byteBuffer.arrayOffset());
                return;
            } catch (ArrayIndexOutOfBoundsException e) {
                BufferOverflowException bufferOverflowException = new BufferOverflowException();
                bufferOverflowException.initCause(e);
                throw bufferOverflowException;
            }
        }
        int length2 = charSequence.length();
        while (i2 < length2) {
            char charAt4 = charSequence.charAt(i2);
            if (charAt4 < 128) {
                byteBuffer.put((byte) charAt4);
            } else if (charAt4 < 2048) {
                byteBuffer.put((byte) ((charAt4 >>> 6) | 960));
                byteBuffer.put((byte) ((charAt4 & '?') | 128));
            } else if (charAt4 < 55296 || 57343 < charAt4) {
                byteBuffer.put((byte) ((charAt4 >>> '\f') | 480));
                byteBuffer.put((byte) (((charAt4 >>> 6) & 63) | 128));
                byteBuffer.put((byte) ((charAt4 & '?') | 128));
            } else {
                int i12 = i2 + 1;
                if (i12 != charSequence.length()) {
                    char charAt5 = charSequence.charAt(i12);
                    if (Character.isSurrogatePair(charAt4, charAt5)) {
                        int codePoint2 = Character.toCodePoint(charAt4, charAt5);
                        byteBuffer.put((byte) ((codePoint2 >>> 18) | 240));
                        byteBuffer.put((byte) (((codePoint2 >>> 12) & 63) | 128));
                        byteBuffer.put((byte) (((codePoint2 >>> 6) & 63) | 128));
                        byteBuffer.put((byte) ((codePoint2 & 63) | 128));
                        i2 = i12;
                    } else {
                        i2 = i12;
                    }
                }
                StringBuilder sb3 = new StringBuilder(39);
                sb3.append("Unpaired surrogate at index ");
                sb3.append(i2 - 1);
                throw new IllegalArgumentException(sb3.toString());
            }
            i2++;
        }
    }

    public static int zzg(int i, int i2) {
        return zzbi(i) + zzbj(i2);
    }

    public static int zzc(int i, String str) {
        int zzbi = zzbi(i);
        int a2 = a(str);
        return zzbi + zzbq(a2) + a2;
    }

    public static int zzb(int i, zziw zziwVar) {
        int zzbi = zzbi(i);
        int zzuk = zziwVar.zzuk();
        return zzbi + zzbq(zzuk) + zzuk;
    }

    public static int zzbj(int i) {
        if (i >= 0) {
            return zzbq(i);
        }
        return 10;
    }

    private final void a(int i) throws IOException {
        byte b = (byte) i;
        if (!this.f4574a.hasRemaining()) {
            throw new zzin(this.f4574a.position(), this.f4574a.limit());
        }
        this.f4574a.put(b);
    }

    public final void zzk(byte[] bArr) throws IOException {
        int length = bArr.length;
        if (this.f4574a.remaining() >= length) {
            this.f4574a.put(bArr, 0, length);
            return;
        }
        throw new zzin(this.f4574a.position(), this.f4574a.limit());
    }

    public final void zzb(int i, int i2) throws IOException {
        zzck((i << 3) | i2);
    }

    public static int zzbi(int i) {
        return zzbq(i << 3);
    }

    public final void zzck(int i) throws IOException {
        while ((i & (-128)) != 0) {
            a((i & Notifications.NOTIFICATION_TYPES_ALL) | 128);
            i >>>= 7;
        }
        a(i);
    }

    public final void zzbz(long j) throws IOException {
        while (((-128) & j) != 0) {
            a((((int) j) & Notifications.NOTIFICATION_TYPES_ALL) | 128);
            j >>>= 7;
        }
        a((int) j);
    }
}
