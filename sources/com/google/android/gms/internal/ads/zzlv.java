package com.google.android.gms.internal.ads;

import com.tencent.smtt.sdk.TbsListener;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzlv {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3681a = {1, 2, 3, 6};
    private static final int[] b = {48000, 44100, 32000};
    private static final int[] c = {24000, 22050, 16000};
    private static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, TbsListener.ErrorCode.STARTDOWNLOAD_1, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] f = {69, 87, 104, 121, TwitterApiConstants.Errors.ALREADY_FAVORITED, TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4, TbsListener.ErrorCode.EXCEED_DEXOPT_RETRY_NUM, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static zzlh zza(zzst zzstVar, String str, String str2, zzne zzneVar) {
        int i = b[(zzstVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzstVar.readUnsignedByte();
        int i2 = d[(readUnsignedByte & 56) >> 3];
        return zzlh.zza(str, "audio/ac3", null, -1, -1, (readUnsignedByte & 4) != 0 ? i2 + 1 : i2, i, null, null, 0, str2);
    }

    public static int zzhi() {
        return 1536;
    }

    public static zzlh zzb(zzst zzstVar, String str, String str2, zzne zzneVar) {
        zzstVar.zzac(2);
        int i = b[(zzstVar.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = zzstVar.readUnsignedByte();
        int i2 = d[(readUnsignedByte & 14) >> 1];
        return zzlh.zza(str, "audio/eac3", null, -1, -1, (readUnsignedByte & 1) != 0 ? i2 + 1 : i2, i, null, null, 0, str2);
    }

    public static int zzh(ByteBuffer byteBuffer) {
        return (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? f3681a[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4] : 6) * 256;
    }
}
