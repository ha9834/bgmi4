package com.google.android.gms.internal.ads;

import com.tencent.smtt.sdk.TbsListener;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.util.Collections;

/* loaded from: classes2.dex */
public final class zzkg {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3669a = {48000, 44100, 32000};
    private static final int[] b = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] c = {32, 40, 48, 56, 64, 80, 96, 112, 128, TbsListener.ErrorCode.STARTDOWNLOAD_1, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] d = {69, 87, 104, 121, TwitterApiConstants.Errors.ALREADY_FAVORITED, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzhj zza(zzkm zzkmVar) {
        int i = f3669a[(zzkmVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzkmVar.readUnsignedByte();
        int i2 = b[(readUnsignedByte & 56) >> 3];
        return zzhj.zzb("audio/ac3", -1, -1L, (readUnsignedByte & 4) != 0 ? i2 + 1 : i2, i, Collections.emptyList());
    }

    public static zzhj zzb(zzkm zzkmVar) {
        zzkmVar.zzac(2);
        int i = f3669a[(zzkmVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzkmVar.readUnsignedByte();
        int i2 = b[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        return zzhj.zza("audio/eac3", -1, i2, i, Collections.emptyList());
    }

    public static int zza(int i, int i2) {
        return (((i << 3) * i2) + 768000) / 1536000;
    }
}
