package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;

/* loaded from: classes2.dex */
public final class zzef extends ee {

    /* renamed from: a, reason: collision with root package name */
    private char f4931a;
    private long b;
    private String c;
    private final zzeh d;
    private final zzeh e;
    private final zzeh f;
    private final zzeh g;
    private final zzeh h;
    private final zzeh i;
    private final zzeh j;
    private final zzeh k;
    private final zzeh l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzef(zzfj zzfjVar) {
        super(zzfjVar);
        this.f4931a = (char) 0;
        this.b = -1L;
        this.d = new zzeh(this, 6, false, false);
        this.e = new zzeh(this, 6, true, false);
        this.f = new zzeh(this, 6, false, true);
        this.g = new zzeh(this, 5, false, false);
        this.h = new zzeh(this, 5, true, false);
        this.i = new zzeh(this, 5, false, true);
        this.j = new zzeh(this, 4, false, false);
        this.k = new zzeh(this, 3, false, false);
        this.l = new zzeh(this, 2, false, false);
    }

    @Override // com.google.android.gms.measurement.internal.ee
    protected final boolean a() {
        return false;
    }

    public final zzeh zzgk() {
        return this.d;
    }

    public final zzeh zzgl() {
        return this.e;
    }

    public final zzeh zzgm() {
        return this.f;
    }

    public final zzeh zzgn() {
        return this.g;
    }

    public final zzeh zzgo() {
        return this.h;
    }

    public final zzeh zzgp() {
        return this.i;
    }

    public final zzeh zzgq() {
        return this.j;
    }

    public final zzeh zzgr() {
        return this.k;
    }

    public final zzeh zzgs() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object a(String str) {
        if (str == null) {
            return null;
        }
        return new ct(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(int i, boolean z, boolean z2, String str, Object obj, Object obj2, Object obj3) {
        if (!z && a(i)) {
            a(i, a(false, str, obj, obj2, obj3));
        }
        if (z2 || i < 5) {
            return;
        }
        Preconditions.checkNotNull(str);
        zzfc b = this.v.b();
        if (b == null) {
            a(6, "Scheduler not set. Not logging error/warn");
        } else {
            if (!b.k()) {
                a(6, "Scheduler not initialized. Not logging error/warn");
                return;
            }
            if (i < 0) {
                i = 0;
            }
            b.zza(new cs(this, i >= 9 ? 8 : i, str, obj, obj2, obj3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final boolean a(int i) {
        return Log.isLoggable(c(), i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @VisibleForTesting
    public final void a(int i, String str) {
        Log.println(i, c(), str);
    }

    @VisibleForTesting
    private final String c() {
        String str;
        synchronized (this) {
            if (this.c == null) {
                if (this.v.zzhz() != null) {
                    this.c = this.v.zzhz();
                } else {
                    this.c = zzs.a();
                }
            }
            str = this.c;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(boolean z, String str, Object obj, Object obj2, Object obj3) {
        if (str == null) {
            str = "";
        }
        String a2 = a(z, obj);
        String a3 = a(z, obj2);
        String a4 = a(z, obj3);
        StringBuilder sb = new StringBuilder();
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            str2 = ": ";
        }
        if (!TextUtils.isEmpty(a2)) {
            sb.append(str2);
            sb.append(a2);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a3)) {
            sb.append(str2);
            sb.append(a3);
            str2 = ", ";
        }
        if (!TextUtils.isEmpty(a4)) {
            sb.append(str2);
            sb.append(a4);
        }
        return sb.toString();
    }

    @VisibleForTesting
    private static String a(boolean z, Object obj) {
        String str;
        String className;
        if (obj == null) {
            return "";
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        int i = 0;
        if (obj instanceof Long) {
            if (!z) {
                return String.valueOf(obj);
            }
            Long l = (Long) obj;
            if (Math.abs(l.longValue()) < 100) {
                return String.valueOf(obj);
            }
            String str2 = String.valueOf(obj).charAt(0) == '-' ? "-" : "";
            String valueOf = String.valueOf(Math.abs(l.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 43 + String.valueOf(str2).length());
            sb.append(str2);
            sb.append(round);
            sb.append("...");
            sb.append(str2);
            sb.append(round2);
            return sb.toString();
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        if (obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            StringBuilder sb2 = new StringBuilder(z ? th.getClass().getName() : th.toString());
            String b = b(zzfj.class.getCanonicalName());
            StackTraceElement[] stackTrace = th.getStackTrace();
            int length = stackTrace.length;
            while (true) {
                if (i >= length) {
                    break;
                }
                StackTraceElement stackTraceElement = stackTrace[i];
                if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null && b(className).equals(b)) {
                    sb2.append(": ");
                    sb2.append(stackTraceElement);
                    break;
                }
                i++;
            }
            return sb2.toString();
        }
        if (!(obj instanceof ct)) {
            return z ? "-" : String.valueOf(obj);
        }
        str = ((ct) obj).f4793a;
        return str;
    }

    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    public final String zzgu() {
        Pair<String, Long> zzhl = zzac().b.zzhl();
        if (zzhl == null || zzhl == cz.f4797a) {
            return null;
        }
        String valueOf = String.valueOf(zzhl.second);
        String str = (String) zzhl.first;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length());
        sb.append(valueOf);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str);
        return sb.toString();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzl() {
        super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzm() {
        super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzn() {
        super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ void zzo() {
        super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzac zzw() {
        return super.zzw();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Clock zzx() {
        return super.zzx();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzed zzy() {
        return super.zzy();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzjs zzz() {
        return super.zzz();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzfc zzaa() {
        return super.zzaa();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzef zzab() {
        return super.zzab();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ cz zzac() {
        return super.zzac();
    }

    @Override // com.google.android.gms.measurement.internal.ef
    public final /* bridge */ /* synthetic */ zzs zzad() {
        return super.zzad();
    }

    @Override // com.google.android.gms.measurement.internal.ef, com.google.android.gms.measurement.internal.eg
    public final /* bridge */ /* synthetic */ zzr zzae() {
        return super.zzae();
    }
}
