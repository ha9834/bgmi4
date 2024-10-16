package com.google.android.gms.internal.ads;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;

/* loaded from: classes2.dex */
public final class zzdsx extends zzdtc {

    /* renamed from: a, reason: collision with root package name */
    private String f3614a;

    public zzdsx(String str) {
        this.f3614a = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdtc
    public final void zzhc(String str) {
        String str2 = this.f3614a;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(CertificateUtil.DELIMITER);
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
