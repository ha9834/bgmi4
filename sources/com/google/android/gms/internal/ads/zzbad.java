package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.ads.AdRequest;
import com.google.android.gms.common.util.VisibleForTesting;

@zzard
/* loaded from: classes2.dex */
public class zzbad {
    public static void zzdp(String str) {
        if (isLoggable(3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
    }

    public static void zzb(String str, Throwable th) {
        if (isLoggable(3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzen(String str) {
        if (isLoggable(6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
    }

    public static void zzc(String str, Throwable th) {
        if (isLoggable(6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
    }

    public static void zzeo(String str) {
        if (isLoggable(4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
    }

    public static void zzep(String str) {
        if (isLoggable(5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
    }

    public static void zzd(String str, Throwable th) {
        if (isLoggable(5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
    }

    @VisibleForTesting
    private static String a(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace.length < 4) {
            return str;
        }
        int lineNumber = stackTrace[3].getLineNumber();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append(" @");
        sb.append(lineNumber);
        return sb.toString();
    }

    public static void zze(String str, Throwable th) {
        if (isLoggable(5)) {
            if (th != null) {
                zzd(a(str), th);
            } else {
                zzep(a(str));
            }
        }
    }

    public static void zzer(String str) {
        zze(str, null);
    }

    public static boolean isLoggable(int i) {
        return i >= 5 || Log.isLoggable(AdRequest.LOGTAG, i);
    }
}
