package com.google.android.gms.internal.gtm;

import android.annotation.SuppressLint;
import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.analytics.Logger;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
@Deprecated
/* loaded from: classes2.dex */
public final class zzch {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Logger f4406a = new x();

    @SuppressLint({"LogTagMismatch"})
    public static void zzf(String str, Object obj) {
        String str2;
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zze(str, obj);
        } else if (a(3)) {
            if (obj != null) {
                String valueOf = String.valueOf(obj);
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(valueOf).length());
                sb.append(str);
                sb.append(CertificateUtil.DELIMITER);
                sb.append(valueOf);
                str2 = sb.toString();
            } else {
                str2 = str;
            }
            Log.e(zzby.zzzb.get(), str2);
        }
        Logger logger = f4406a;
        if (logger != null) {
            logger.error(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzab(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzq(str);
        } else if (a(0)) {
            Log.v(zzby.zzzb.get(), str);
        }
        Logger logger = f4406a;
        if (logger != null) {
            logger.verbose(str);
        }
    }

    @SuppressLint({"LogTagMismatch"})
    public static void zzac(String str) {
        zzci zzfn = zzci.zzfn();
        if (zzfn != null) {
            zzfn.zzt(str);
        } else if (a(2)) {
            Log.w(zzby.zzzb.get(), str);
        }
        Logger logger = f4406a;
        if (logger != null) {
            logger.warn(str);
        }
    }

    private static boolean a(int i) {
        return f4406a != null && f4406a.getLogLevel() <= i;
    }

    @VisibleForTesting
    public static void setLogger(Logger logger) {
        f4406a = logger;
    }

    @VisibleForTesting
    public static Logger getLogger() {
        return f4406a;
    }
}
