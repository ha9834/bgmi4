package com.google.android.gms.internal.ads;

import com.tencent.bigdata.dataacquisition.DeviceInfos;
import com.tencent.smtt.sdk.WebView;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class zzbc {
    public static int zza(byte b) {
        return b < 0 ? b + 256 : b;
    }

    public static long zza(ByteBuffer byteBuffer) {
        long j = byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static int zzb(ByteBuffer byteBuffer) {
        return (zza(byteBuffer.get()) << 8) + 0 + zza(byteBuffer.get());
    }

    public static long zzc(ByteBuffer byteBuffer) {
        long zza = (zza(byteBuffer) << 32) + 0;
        if (zza < 0) {
            throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
        }
        return zza + zza(byteBuffer);
    }

    public static double zzd(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = 0 | ((bArr[0] << 24) & WebView.NIGHT_MODE_COLOR) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        Double.isNaN(d);
        return d / 65536.0d;
    }

    public static double zze(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = 0 | ((bArr[0] << 24) & WebView.NIGHT_MODE_COLOR) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & DeviceInfos.NETWORK_TYPE_UNCONNECTED);
        Double.isNaN(d);
        return d / 1.073741824E9d;
    }

    public static String zzf(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
}
