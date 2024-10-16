package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzta {

    /* renamed from: a, reason: collision with root package name */
    private final int f3741a;
    private final int b;
    public final List<byte[]> zzafw;
    public final int zzamf;
    public final float zzbne;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzta zzf(zzst zzstVar) throws zzlm {
        int i;
        int i2;
        float f;
        try {
            zzstVar.zzac(4);
            int readUnsignedByte = (zzstVar.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int readUnsignedByte2 = zzstVar.readUnsignedByte() & 31;
            for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                arrayList.add(a(zzstVar));
            }
            int readUnsignedByte3 = zzstVar.readUnsignedByte();
            for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                arrayList.add(a(zzstVar));
            }
            if (readUnsignedByte2 > 0) {
                zzsr zze = zzsq.zze((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                int i5 = zze.width;
                int i6 = zze.height;
                f = zze.zzbne;
                i = i5;
                i2 = i6;
            } else {
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new zzta(arrayList, readUnsignedByte, i, i2, f);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzlm("Error parsing AVC config", e);
        }
    }

    private zzta(List<byte[]> list, int i, int i2, int i3, float f) {
        this.zzafw = list;
        this.zzamf = i;
        this.f3741a = i2;
        this.b = i3;
        this.zzbne = f;
    }

    private static byte[] a(zzst zzstVar) {
        int readUnsignedShort = zzstVar.readUnsignedShort();
        int position = zzstVar.getPosition();
        zzstVar.zzac(readUnsignedShort);
        return zzsl.zza(zzstVar.data, position, readUnsignedShort);
    }
}
