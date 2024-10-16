package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcan {

    /* renamed from: a, reason: collision with root package name */
    private final zzayu f3157a;
    private final Clock b;
    private final Executor c;

    public zzcan(zzayu zzayuVar, Clock clock, Executor executor) {
        this.f3157a = zzayuVar;
        this.b = clock;
        this.c = executor;
    }

    public final zzbbh<Bitmap> zza(String str, double d, boolean z) {
        return zzbar.zza(zzayu.zzeg(str), new qt(this, d, z), this.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Bitmap a(byte[] bArr, double d, boolean z) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inDensity = (int) (d * 160.0d);
        if (!z) {
            options.inPreferredConfig = Bitmap.Config.RGB_565;
        }
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcwo)).booleanValue()) {
            options.inJustDecodeBounds = true;
            a(bArr, options);
            options.inJustDecodeBounds = false;
            int i = options.outWidth * options.outHeight;
            if (i > 0) {
                int i2 = i - 1;
                options.inSampleSize = 1 << ((33 - Integer.numberOfLeadingZeros(i2 / ((Integer) zzyt.zzpe().zzd(zzacu.zzcwp)).intValue())) / 2);
            }
        }
        return a(bArr, options);
    }

    private final Bitmap a(byte[] bArr, BitmapFactory.Options options) {
        long elapsedRealtime = this.b.elapsedRealtime();
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        long elapsedRealtime2 = this.b.elapsedRealtime();
        if (Build.VERSION.SDK_INT >= 19 && decodeByteArray != null) {
            int width = decodeByteArray.getWidth();
            int height = decodeByteArray.getHeight();
            int allocationByteCount = decodeByteArray.getAllocationByteCount();
            long j = elapsedRealtime2 - elapsedRealtime;
            boolean z = Looper.getMainLooper().getThread() == Thread.currentThread();
            StringBuilder sb = new StringBuilder(108);
            sb.append("Decoded image w: ");
            sb.append(width);
            sb.append(" h:");
            sb.append(height);
            sb.append(" bytes: ");
            sb.append(allocationByteCount);
            sb.append(" time: ");
            sb.append(j);
            sb.append(" on ui thread: ");
            sb.append(z);
            zzawz.zzds(sb.toString());
        }
        return decodeByteArray;
    }
}
