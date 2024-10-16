package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zztg {
    public final List<byte[]> zzafw;
    public final int zzamf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zztg zzh(zzst zzstVar) throws zzlm {
        try {
            zzstVar.zzac(21);
            int readUnsignedByte = zzstVar.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzstVar.readUnsignedByte();
            int position = zzstVar.getPosition();
            int i = 0;
            int i2 = 0;
            while (i < readUnsignedByte2) {
                zzstVar.zzac(1);
                int readUnsignedShort = zzstVar.readUnsignedShort();
                int i3 = i2;
                for (int i4 = 0; i4 < readUnsignedShort; i4++) {
                    int readUnsignedShort2 = zzstVar.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    zzstVar.zzac(readUnsignedShort2);
                }
                i++;
                i2 = i3;
            }
            zzstVar.setPosition(position);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < readUnsignedByte2) {
                zzstVar.zzac(1);
                int readUnsignedShort3 = zzstVar.readUnsignedShort();
                int i7 = i6;
                for (int i8 = 0; i8 < readUnsignedShort3; i8++) {
                    int readUnsignedShort4 = zzstVar.readUnsignedShort();
                    System.arraycopy(zzsq.zzaqt, 0, bArr, i7, zzsq.zzaqt.length);
                    int length = i7 + zzsq.zzaqt.length;
                    System.arraycopy(zzstVar.data, zzstVar.getPosition(), bArr, length, readUnsignedShort4);
                    i7 = length + readUnsignedShort4;
                    zzstVar.zzac(readUnsignedShort4);
                }
                i5++;
                i6 = i7;
            }
            return new zztg(i2 == 0 ? null : Collections.singletonList(bArr), readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm("Error parsing HEVC config", e);
        }
    }

    private zztg(List<byte[]> list, int i) {
        this.zzafw = list;
        this.zzamf = i;
    }
}
