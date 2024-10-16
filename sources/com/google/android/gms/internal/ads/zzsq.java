package com.google.android.gms.internal.ads;

import android.util.Log;
import com.tencent.bigdata.dataacquisition.DeviceInfos;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzsq {
    public static final byte[] zzaqt = {0, 0, 0, 1};

    /* renamed from: a, reason: collision with root package name */
    private static final float[] f3734a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object b = new Object();
    private static int[] c = new int[10];

    public static void zzk(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                int i4 = byteBuffer.get(i) & DeviceInfos.NETWORK_TYPE_UNCONNECTED;
                if (i2 == 3) {
                    if (i4 == 1 && (byteBuffer.get(i3) & 31) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (i4 == 0) {
                    i2++;
                }
                if (i4 != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static zzsr zze(byte[] bArr, int i, int i2) {
        int zzkd;
        boolean z;
        int i3;
        boolean z2;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        zzsu zzsuVar = new zzsu(bArr, i, i2);
        zzsuVar.zzbq(8);
        int zzbn = zzsuVar.zzbn(8);
        zzsuVar.zzbq(16);
        int zzkd2 = zzsuVar.zzkd();
        if (zzbn == 100 || zzbn == 110 || zzbn == 122 || zzbn == 244 || zzbn == 44 || zzbn == 83 || zzbn == 86 || zzbn == 118 || zzbn == 128 || zzbn == 138) {
            zzkd = zzsuVar.zzkd();
            boolean zzkc = zzkd == 3 ? zzsuVar.zzkc() : false;
            zzsuVar.zzkd();
            zzsuVar.zzkd();
            zzsuVar.zzbq(1);
            if (zzsuVar.zzkc()) {
                int i8 = zzkd != 3 ? 8 : 12;
                int i9 = 0;
                while (i9 < i8) {
                    if (zzsuVar.zzkc()) {
                        int i10 = i9 < 6 ? 16 : 64;
                        int i11 = 8;
                        int i12 = 8;
                        for (int i13 = 0; i13 < i10; i13++) {
                            if (i11 != 0) {
                                i11 = ((zzsuVar.zzke() + i12) + 256) % 256;
                            }
                            if (i11 != 0) {
                                i12 = i11;
                            }
                        }
                    }
                    i9++;
                }
            }
            z = zzkc;
        } else {
            zzkd = 1;
            z = false;
        }
        int zzkd3 = zzsuVar.zzkd() + 4;
        int zzkd4 = zzsuVar.zzkd();
        if (zzkd4 == 0) {
            i3 = zzsuVar.zzkd() + 4;
            z2 = false;
        } else if (zzkd4 == 1) {
            boolean zzkc2 = zzsuVar.zzkc();
            zzsuVar.zzke();
            zzsuVar.zzke();
            long zzkd5 = zzsuVar.zzkd();
            for (int i14 = 0; i14 < zzkd5; i14++) {
                zzsuVar.zzkd();
            }
            z2 = zzkc2;
            i3 = 0;
        } else {
            i3 = 0;
            z2 = false;
        }
        zzsuVar.zzkd();
        zzsuVar.zzbq(1);
        int zzkd6 = zzsuVar.zzkd() + 1;
        int zzkd7 = zzsuVar.zzkd() + 1;
        boolean zzkc3 = zzsuVar.zzkc();
        int i15 = (2 - (zzkc3 ? 1 : 0)) * zzkd7;
        if (!zzkc3) {
            zzsuVar.zzbq(1);
        }
        zzsuVar.zzbq(1);
        int i16 = zzkd6 << 4;
        int i17 = i15 << 4;
        if (zzsuVar.zzkc()) {
            int zzkd8 = zzsuVar.zzkd();
            int zzkd9 = zzsuVar.zzkd();
            int zzkd10 = zzsuVar.zzkd();
            int zzkd11 = zzsuVar.zzkd();
            if (zzkd == 0) {
                i7 = 2 - (zzkc3 ? 1 : 0);
                i6 = 1;
            } else {
                i6 = zzkd == 3 ? 1 : 2;
                i7 = (2 - (zzkc3 ? 1 : 0)) * (zzkd == 1 ? 2 : 1);
            }
            int i18 = i17 - ((zzkd10 + zzkd11) * i7);
            i4 = i16 - ((zzkd8 + zzkd9) * i6);
            i5 = i18;
        } else {
            i4 = i16;
            i5 = i17;
        }
        float f2 = 1.0f;
        if (zzsuVar.zzkc() && zzsuVar.zzkc()) {
            int zzbn2 = zzsuVar.zzbn(8);
            if (zzbn2 == 255) {
                int zzbn3 = zzsuVar.zzbn(16);
                int zzbn4 = zzsuVar.zzbn(16);
                if (zzbn3 != 0 && zzbn4 != 0) {
                    f2 = zzbn3 / zzbn4;
                }
                f = f2;
            } else {
                float[] fArr = f3734a;
                if (zzbn2 < fArr.length) {
                    f = fArr[zzbn2];
                } else {
                    StringBuilder sb = new StringBuilder(46);
                    sb.append("Unexpected aspect_ratio_idc value: ");
                    sb.append(zzbn2);
                    Log.w("NalUnitUtil", sb.toString());
                }
            }
            return new zzsr(zzkd2, i4, i5, f, z, zzkc3, zzkd3, zzkd4, i3, z2);
        }
        f = 1.0f;
        return new zzsr(zzkd2, i4, i5, f, z, zzkc3, zzkd3, zzkd4, i3, z2);
    }
}
