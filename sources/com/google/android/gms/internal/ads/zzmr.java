package com.google.android.gms.internal.ads;

import com.amazonaws.event.ProgressEvent;
import com.tencent.smtt.sdk.TbsListener;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzmr {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f3685a = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] b = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] c = {64, 112, 128, 192, TbsListener.ErrorCode.EXCEED_INCR_UPDATE, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, ProgressEvent.PART_COMPLETED_EVENT_CODE, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int zzj(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) << 5;
    }
}
