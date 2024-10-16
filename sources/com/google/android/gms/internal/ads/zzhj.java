package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaFormat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.tencent.smtt.sdk.TbsListener;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzhj {

    /* renamed from: a, reason: collision with root package name */
    private final int f3645a;
    private final int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private MediaFormat g;
    public final int height;
    public final String mimeType;
    public final int width;
    public final long zzack;
    public final float zzaft;
    public final List<byte[]> zzafw;

    @TargetApi(16)
    public static zzhj zza(MediaFormat mediaFormat) {
        return new zzhj(mediaFormat);
    }

    public static zzhj zza(String str, int i, long j, int i2, int i3, List<byte[]> list) {
        return zza(str, -1, j, i2, i3, 1.0f, list);
    }

    public static zzhj zza(String str, int i, long j, int i2, int i3, float f, List<byte[]> list) {
        return new zzhj(str, -1, j, i2, i3, f, -1, -1, list);
    }

    public static zzhj zza(String str, int i, int i2, int i3, List<byte[]> list) {
        return zzb(str, -1, -1L, i2, i3, list);
    }

    public static zzhj zzb(String str, int i, long j, int i2, int i3, List<byte[]> list) {
        return new zzhj(str, i, j, -1, -1, -1.0f, i2, i3, list);
    }

    public static zzhj zzem() {
        return new zzhj("application/ttml+xml", -1, -1L, -1, -1, -1.0f, -1, -1, null);
    }

    @TargetApi(16)
    private zzhj(MediaFormat mediaFormat) {
        this.g = mediaFormat;
        this.mimeType = mediaFormat.getString("mime");
        this.f3645a = a(mediaFormat, "max-input-size");
        this.width = a(mediaFormat, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        this.height = a(mediaFormat, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        this.b = a(mediaFormat, "channel-count");
        this.c = a(mediaFormat, "sample-rate");
        this.zzaft = mediaFormat.containsKey("com.google.android.videos.pixelWidthHeightRatio") ? mediaFormat.getFloat("com.google.android.videos.pixelWidthHeightRatio") : -1.0f;
        this.zzafw = new ArrayList();
        int i = 0;
        while (true) {
            StringBuilder sb = new StringBuilder(15);
            sb.append("csd-");
            sb.append(i);
            if (!mediaFormat.containsKey(sb.toString())) {
                break;
            }
            StringBuilder sb2 = new StringBuilder(15);
            sb2.append("csd-");
            sb2.append(i);
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer(sb2.toString());
            byte[] bArr = new byte[byteBuffer.limit()];
            byteBuffer.get(bArr);
            this.zzafw.add(bArr);
            byteBuffer.flip();
            i++;
        }
        this.zzack = mediaFormat.containsKey("durationUs") ? mediaFormat.getLong("durationUs") : -1L;
        this.d = -1;
        this.e = -1;
    }

    private zzhj(String str, int i, long j, int i2, int i3, float f, int i4, int i5, List<byte[]> list) {
        this.mimeType = str;
        this.f3645a = i;
        this.zzack = j;
        this.width = i2;
        this.height = i3;
        this.zzaft = f;
        this.b = i4;
        this.c = i5;
        this.zzafw = list == null ? Collections.emptyList() : list;
        this.d = -1;
        this.e = -1;
    }

    public final int hashCode() {
        if (this.f == 0) {
            String str = this.mimeType;
            int hashCode = (((((((((((((((((((str == null ? 0 : str.hashCode()) + 527) * 31) + this.f3645a) * 31) + this.width) * 31) + this.height) * 31) + Float.floatToRawIntBits(this.zzaft)) * 31) + ((int) this.zzack)) * 31) + this.d) * 31) + this.e) * 31) + this.b) * 31) + this.c;
            for (int i = 0; i < this.zzafw.size(); i++) {
                hashCode = (hashCode * 31) + Arrays.hashCode(this.zzafw.get(i));
            }
            this.f = hashCode;
        }
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzhj zzhjVar = (zzhj) obj;
        if (this.f3645a != zzhjVar.f3645a || this.width != zzhjVar.width || this.height != zzhjVar.height || this.zzaft != zzhjVar.zzaft || this.d != zzhjVar.d || this.e != zzhjVar.e || this.b != zzhjVar.b || this.c != zzhjVar.c || !zzkq.zza(this.mimeType, zzhjVar.mimeType) || this.zzafw.size() != zzhjVar.zzafw.size()) {
            return false;
        }
        for (int i = 0; i < this.zzafw.size(); i++) {
            if (!Arrays.equals(this.zzafw.get(i), zzhjVar.zzafw.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        String str = this.mimeType;
        int i = this.f3645a;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzaft;
        int i4 = this.b;
        int i5 = this.c;
        long j = this.zzack;
        int i6 = this.d;
        int i7 = this.e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + TbsListener.ErrorCode.NEEDDOWNLOAD_4);
        sb.append("MediaFormat(");
        sb.append(str);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(f);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append(", ");
        sb.append(j);
        sb.append(", ");
        sb.append(i6);
        sb.append(", ");
        sb.append(i7);
        sb.append(")");
        return sb.toString();
    }

    @TargetApi(16)
    public final MediaFormat zzen() {
        if (this.g == null) {
            MediaFormat mediaFormat = new MediaFormat();
            mediaFormat.setString("mime", this.mimeType);
            a(mediaFormat, "max-input-size", this.f3645a);
            a(mediaFormat, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.width);
            a(mediaFormat, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.height);
            a(mediaFormat, "channel-count", this.b);
            a(mediaFormat, "sample-rate", this.c);
            float f = this.zzaft;
            if (f != -1.0f) {
                mediaFormat.setFloat("com.google.android.videos.pixelWidthHeightRatio", f);
            }
            for (int i = 0; i < this.zzafw.size(); i++) {
                StringBuilder sb = new StringBuilder(15);
                sb.append("csd-");
                sb.append(i);
                mediaFormat.setByteBuffer(sb.toString(), ByteBuffer.wrap(this.zzafw.get(i)));
            }
            long j = this.zzack;
            if (j != -1) {
                mediaFormat.setLong("durationUs", j);
            }
            a(mediaFormat, "max-width", this.d);
            a(mediaFormat, "max-height", this.e);
            this.g = mediaFormat;
        }
        return this.g;
    }

    @TargetApi(16)
    private static final void a(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    @TargetApi(16)
    private static final int a(MediaFormat mediaFormat, String str) {
        if (mediaFormat.containsKey(str)) {
            return mediaFormat.getInteger(str);
        }
        return -1;
    }
}
