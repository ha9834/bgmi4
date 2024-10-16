package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzard
@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzadi {
    private zzadi e;
    private final List<zzadg> b = new LinkedList();
    private final Map<String, String> c = new LinkedHashMap();
    private final Object d = new Object();

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    boolean f2706a = true;

    public zzadi(boolean z, String str, String str2) {
        this.c.put("action", str);
        this.c.put("ad_format", str2);
    }

    public final void zzc(zzadi zzadiVar) {
        synchronized (this.d) {
            this.e = zzadiVar;
        }
    }

    public final zzadg zzfa(long j) {
        if (this.f2706a) {
            return new zzadg(j, null, null);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza(zzadg zzadgVar, long j, String... strArr) {
        synchronized (this.d) {
            for (String str : strArr) {
                this.b.add(new zzadg(j, str, zzadgVar));
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzqx() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.d) {
            for (zzadg zzadgVar : this.b) {
                long time = zzadgVar.getTime();
                String zzqu = zzadgVar.zzqu();
                zzadg zzqv = zzadgVar.zzqv();
                if (zzqv != null && time > 0) {
                    long time2 = time - zzqv.getTime();
                    sb2.append(zzqu);
                    sb2.append('.');
                    sb2.append(time2);
                    sb2.append(',');
                }
            }
            this.b.clear();
            if (!TextUtils.isEmpty(null)) {
                sb2.append((String) null);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public final void zzh(String str, String str2) {
        zzacy zzuw;
        if (!this.f2706a || TextUtils.isEmpty(str2) || (zzuw = zzk.zzlk().zzuw()) == null) {
            return;
        }
        synchronized (this.d) {
            zzadc zzch = zzuw.zzch(str);
            Map<String, String> map = this.c;
            map.put(str, zzch.zzg(map.get(str), str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Map<String, String> a() {
        synchronized (this.d) {
            zzacy zzuw = zzk.zzlk().zzuw();
            if (zzuw != null && this.e != null) {
                return zzuw.a(this.c, this.e.a());
            }
            return this.c;
        }
    }
}
