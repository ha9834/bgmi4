package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzdbu {

    /* renamed from: a, reason: collision with root package name */
    private zzdha f3537a;

    private zzdbu(zzdha zzdhaVar) {
        this.f3537a = zzdhaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzdbu a(zzdha zzdhaVar) throws GeneralSecurityException {
        if (zzdhaVar == null || zzdhaVar.zzasj() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        return new zzdbu(zzdhaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdha a() {
        return this.f3537a;
    }

    public final String toString() {
        return abl.a(this.f3537a).toString();
    }
}
