package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.MurmurHash3;
import java.io.UnsupportedEncodingException;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzve {
    public static int zzbn(String str) {
        byte[] bytes;
        try {
            bytes = str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException unused) {
            bytes = str.getBytes();
        }
        return MurmurHash3.murmurhash3_x86_32(bytes, 0, bytes.length, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
    
        if (((r6 >= 65382 && r6 <= 65437) || (r6 >= 65441 && r6 <= 65500)) != false) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] zzg(java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzve.zzg(java.lang.String, boolean):java.lang.String[]");
    }
}
