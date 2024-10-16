package com.google.android.gms.measurement.internal;

import com.facebook.internal.security.CertificateUtil;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class cs implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f4792a;
    private final /* synthetic */ String b;
    private final /* synthetic */ Object c;
    private final /* synthetic */ Object d;
    private final /* synthetic */ Object e;
    private final /* synthetic */ zzef f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(zzef zzefVar, int i, String str, Object obj, Object obj2, Object obj3) {
        this.f = zzefVar;
        this.f4792a = i;
        this.b = str;
        this.c = obj;
        this.d = obj2;
        this.e = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        char c;
        long j;
        char c2;
        long j2;
        cz zzac = this.f.v.zzac();
        if (!zzac.k()) {
            this.f.a(6, "Persisted config not initialized. Not logging error/warn");
            return;
        }
        c = this.f.f4931a;
        if (c == 0) {
            if (this.f.zzad().zzbn()) {
                zzef zzefVar = this.f;
                zzefVar.zzae();
                zzefVar.f4931a = 'C';
            } else {
                zzef zzefVar2 = this.f;
                zzefVar2.zzae();
                zzefVar2.f4931a = 'c';
            }
        }
        j = this.f.b;
        if (j < 0) {
            zzef zzefVar3 = this.f;
            zzefVar3.b = zzefVar3.zzad().zzao();
        }
        char charAt = "01VDIWEA?".charAt(this.f4792a);
        c2 = this.f.f4931a;
        j2 = this.f.b;
        String a2 = zzef.a(true, this.b, this.c, this.d, this.e);
        StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 24);
        sb.append("2");
        sb.append(charAt);
        sb.append(c2);
        sb.append(j2);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(a2);
        String sb2 = sb.toString();
        if (sb2.length() > 1024) {
            sb2 = this.b.substring(0, 1024);
        }
        zzac.b.zzc(sb2, 1L);
    }
}
