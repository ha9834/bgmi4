package com.google.android.gms.internal.ads;

import com.amazonaws.services.s3.Headers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public final class zzaq {
    public static zzc zzb(zzp zzpVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = zzpVar.zzab;
        String str = map.get("Date");
        long a2 = str != null ? a(str) : 0L;
        String str2 = map.get(Headers.CACHE_CONTROL);
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            j = 0;
            int i2 = 0;
            j2 = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals("no-cache") || trim.equals("no-store")) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j2 = Long.parseLong(trim.substring(23));
                } else if (trim.equals("must-revalidate") || trim.equals("proxy-revalidate")) {
                    i2 = 1;
                }
                i++;
            }
            i = i2;
            z = true;
        } else {
            j = 0;
            j2 = 0;
            z = false;
        }
        String str3 = map.get(Headers.EXPIRES);
        long a3 = str3 != null ? a(str3) : 0L;
        String str4 = map.get(Headers.LAST_MODIFIED);
        long a4 = str4 != null ? a(str4) : 0L;
        String str5 = map.get(Headers.ETAG);
        if (z) {
            j3 = currentTimeMillis + (j * 1000);
            if (i != 0) {
                j4 = j3;
            } else {
                Long.signum(j2);
                j4 = (j2 * 1000) + j3;
            }
        } else if (a2 <= 0 || a3 < a2) {
            j3 = 0;
            j4 = 0;
        } else {
            j4 = (a3 - a2) + currentTimeMillis;
            j3 = j4;
        }
        zzc zzcVar = new zzc();
        zzcVar.data = zzpVar.data;
        zzcVar.zza = str5;
        zzcVar.zze = j3;
        zzcVar.zzd = j4;
        zzcVar.zzb = a2;
        zzcVar.zzc = a4;
        zzcVar.zzf = map;
        zzcVar.zzg = zzpVar.allHeaders;
        return zzcVar;
    }

    private static long a(String str) {
        try {
            return a().parse(str).getTime();
        } catch (ParseException e) {
            zzag.zza(e, "Unable to parse dateStr: %s, falling back to 0", str);
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(long j) {
        return a().format(new Date(j));
    }

    private static SimpleDateFormat a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }
}
