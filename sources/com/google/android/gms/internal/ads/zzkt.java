package com.google.android.gms.internal.ads;

import com.shieldtunnel.svpn.common.ErrorCode;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzkt {
    public static final int CHANNEL_OUT_7POINT1_SURROUND;

    /* renamed from: a, reason: collision with root package name */
    private static final UUID f3676a;
    private static final UUID b;
    private static final UUID c;
    public static final UUID zzarg;

    public static long zzdz(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j / 1000;
    }

    public static long zzea(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j * 1000;
    }

    static {
        CHANNEL_OUT_7POINT1_SURROUND = zzsy.SDK_INT < 23 ? ErrorCode.SOCKET_REGISTER_ERROR : 6396;
        zzarg = new UUID(0L, 0L);
        f3676a = new UUID(1186680826959645954L, -5988876978535335093L);
        b = new UUID(-1301668207276963122L, -6645017420763422227L);
        c = new UUID(-7348484286925749626L, -6083546864340672619L);
    }
}
